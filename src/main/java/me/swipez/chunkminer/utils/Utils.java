package me.swipez.chunkminer.utils;

public class Utils {
    public static String SOUTH = "SOUTH";
    public static String EAST = "EAST";
    public static String NORTH = "NORTH";
    public static String WEST = "WEST";
    public static String UP = "UP";
    public static String DOWN = "DOWN";
    public static String UNKNOWN = "UNKNOWN";
    public static String getDirection(float yaw) {
        String returnString = "UNKNOWN";
        if (yaw > -45 && yaw <= 45) returnString = SOUTH;
        if (yaw > 45 && yaw <= 135) returnString = WEST;
        if (yaw > -45 && yaw <= -135) returnString = EAST;
        if (yaw > 135 && yaw <= -135) returnString = NORTH;

        return returnString;
    }
    public static String getUpOrDown(float pitch) {
        String returnString = "UNKNOWN";
        if (pitch > 70) returnString = DOWN;
        if (pitch < -70) returnString = UP;


        return returnString;
    }
}


