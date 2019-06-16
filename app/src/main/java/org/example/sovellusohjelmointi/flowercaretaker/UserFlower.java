package org.example.sovellusohjelmointi.flowercaretaker;

import java.util.ArrayList;
import java.util.Date;

/**
 * Flower owned by user.
 */
public class UserFlower {
    private int id;
    private int userid;
    private int flowerid;
    private String added;
    private String age;
    private ArrayList<WateringEvent> wateringEvents;
    private Flower flower;

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getFlowerid() {
        return flowerid;
    }

    public void setFlowerid(int flowerid) {
        this.flowerid = flowerid;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<WateringEvent> getWateringEvents() {
        return wateringEvents;
    }

    public void setWateringEvents(ArrayList<WateringEvent> wateringEvents) {
        this.wateringEvents = wateringEvents;
    }

    public WateringEvent getLatestWatered() {
        return this.wateringEvents.get(0);
    }



}
