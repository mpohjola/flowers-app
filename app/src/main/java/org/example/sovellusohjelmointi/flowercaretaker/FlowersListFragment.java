package org.example.sovellusohjelmointi.flowercaretaker;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.example.sovellusohjelmointi.flowercaretaker.dummy.DummyContent;
import org.example.sovellusohjelmointi.flowercaretaker.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFlowerSelected}
 * interface.
 */
public class FlowersListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnFlowerSelected mListener;
    private static RESTController restController = new RESTController();
    private static AppData appData = new AppData();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FlowersListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FlowersListFragment newInstance(int columnCount) {
        FlowersListFragment fragment = new FlowersListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        new GetFlowersTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(AppData.flowersList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFlowerSelected) {
            mListener = (OnFlowerSelected) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFlowerSelected {
        // TODO: Update argument type and name

        void onFlowerSelected(AppData.FlowerItem flowerItem);
    }
    private class GetFlowersTask extends AsyncTask<Integer,Void, ArrayList<Flower>> {

        @Override
        protected ArrayList<Flower> doInBackground(Integer... params) {

            ArrayList<Flower> flowers = restController.getFlowers();
            //ArrayList<String> tempFlowers = new ArrayList<String>();
            //tempBuildings.add("");
            return flowers;
        }


        @Override
        protected void onPostExecute(ArrayList<Flower> flowers) {
            saveFlowersList(flowers);
        }

        private void saveFlowersList(ArrayList<Flower> flowers) {
            AppData appData = new AppData();
            appData.addFlowers(flowers);
            //Log.i(TAG,"Added flowers");
            //reset adapter?;

        }

    }
}
