package org.example.sovellusohjelmointi.flowercaretaker;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import android.provider.Settings.Secure;

/**
 * Data class for user.
 */
public class User {
    private static String userID;
    private static String username;
    private static Map<String, UserFlower> flowers;

    public static Map<String, UserFlower> getFlowers() {
        return flowers;
    }

    public static void setFlowers(Map<String, UserFlower> flowers) {
        User.flowers = flowers;
    }

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        User.userID = userID;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static void addToFlowers(UserFlower newFlower) {
        User.flowers.put(Integer.toString(newFlower.getId()), newFlower);
    }

    public String getNewID() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
}
