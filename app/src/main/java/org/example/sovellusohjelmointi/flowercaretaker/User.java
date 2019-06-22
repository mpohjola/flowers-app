package org.example.sovellusohjelmointi.flowercaretaker;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import android.provider.Settings.Secure;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data class for user.
 */
public class User {


    @JsonProperty("identifier")
    private String identifier;
    private String username;
    private Map<String, UserFlower> flowers;
    private String lastseen;

    public User() {
    }

    public Map<String, UserFlower> getFlowers() {
        return flowers;
    }

    public void setFlowers(Map<String, UserFlower> flowers) {
        this.flowers = flowers;
    }


    public String getLastseen() {
        return lastseen;
    }

    public void setLastseen(String lastseen) {
        this.lastseen = lastseen;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addToFlowers(UserFlower newFlower) {
        this.flowers.put(Integer.toString(newFlower.getId()), newFlower);
    }

    public String getNewID() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
}
