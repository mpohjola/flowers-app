package org.example.sovellusohjelmointi.flowercaretaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppData {
    public static Map<String, Flower> flowersMap = new HashMap<>();
    public static ArrayList<FlowerItem> flowersList = new ArrayList<>();


    public class FlowerItem {
        public int id;
        public String name;
        public String latinName;

        public FlowerItem(int id, String name, String latinName) {
            this.id = id;
            this.name = name;
            this.latinName = latinName;
        }
    }

    public static Flower getFlowerForListItem(int listId){
        String mapId = Integer.toString(listId);
        Flower flower = flowersMap.get(mapId);
        return flower;
    }

    public void addFlowers(ArrayList<Flower> flowers) {
        for (int i = 0; i < flowers.size(); i++) {
            String mapKey = Integer.toString(flowers.get(i).getId());
            flowersMap.put(mapKey, flowers.get(i));
            FlowerItem newFlowerItem = new FlowerItem(flowers.get(i).getId(), flowers.get(i).getName(), flowers.get(i).getLatinName());
            flowersList.add(newFlowerItem);
        }
    }

    public String printFlowers(){
        String flowersString = "";
        for (int i = 0; i < flowersList.size(); i++) {
            flowersString+= flowersList.get(i).name + " ; ";
        }
        return flowersString;
    }
}

