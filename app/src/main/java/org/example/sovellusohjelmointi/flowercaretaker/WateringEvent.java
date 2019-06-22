package org.example.sovellusohjelmointi.flowercaretaker;

import java.util.Date;

public class WateringEvent {
    private int id;
    private int wateringAmount;
    private int userFlowerId;
    private Date date;

    public WateringEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWateringAmount() {
        return wateringAmount;
    }

    public void setWateringAmount(int wateringAmount) {
        this.wateringAmount = wateringAmount;
    }

    public int getUserFlowerId() {
        return userFlowerId;
    }

    public void setUserFlowerId(int userFlowerId) {
        this.userFlowerId = userFlowerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }






}
