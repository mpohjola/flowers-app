package org.example.sovellusohjelmointi.flowercaretaker;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String PREFERENCES_FILE = "FlowerCaretakerPreferences";
    private final String TAG = "MAIN_ACTIVITY";
    private static RESTController restController = new RESTController();

    private static User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFERENCES_FILE, 0);
        String userID = settings.getString("userID", "");
        String username = settings.getString("username", "");

        new GetFlowersTask().execute();

        if (userID.equals("")) {
            Log.i(TAG,"No user ID present.");
            userID = user.getNewID();
            //request new username from user

            SharedPreferences.Editor editor = settings.edit();
            editor.putString("UserID",userID);
            editor.apply();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This class extends AsyncTask interface and asynchroniously fetches building data
     * from the server and then adds the building names to the building listView. Furthermore
     * an event listener is attached to the listview to trigger an event when user chooses a building.
     */
    private class GetFlowersTask extends AsyncTask<Integer,Void, ArrayList<Flower>> {

        @Override
        protected ArrayList<Flower> doInBackground(Integer... params) {

            ArrayList<Flower> flowers = restController.getFlowers();
            //ArrayList<String> tempFlowers = new ArrayList<String>();
            //tempBuildings.add("");
            return flowers;
        }


        @Override
        protected void onPostExecute(ArrayList<Flower> tempBuildings) {
            //super.onPostExecute(o);
        }

    }
}
