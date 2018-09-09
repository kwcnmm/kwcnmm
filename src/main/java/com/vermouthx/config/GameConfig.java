package com.vermouthx.config;

import java.util.HashMap;
import java.util.Map;

public class GameConfig {

    /**
     * game name
     */
    private static final String GAME_NAME = "Aircraft";
    /**
     * window width
     */
    private static final int WINDOW_WIDTH = 380;
    /**
     * window height
     */
    private static final int WINDOW_HEIGHT = 700;
    /**
     * number of difficulty
     */
    private static final int DIFFICULTY_DEGREE = 3;
    /**
     * map for int and difficulty (String)
     */
    private static final Map<Integer, String> DIFFICULT_MAP = new HashMap<>();

    /**
     * interval pixel for map moving
     */
    private static final int MAP_MOVE_INTERVAL = 1;

    /**
     * speed for map moving (millisecond)
     */
    private static final int MAP_MOVE_SPEED = 50;

    static {
        // fill difficulty map
        DIFFICULT_MAP.put(0, "EASY");
        DIFFICULT_MAP.put(1, "MEDIUM");
        DIFFICULT_MAP.put(2, "HARD");
    }

    public static String getGameName() {
        return GAME_NAME;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getDifficultyDegree() {
        return DIFFICULTY_DEGREE;
    }

    public static Map<Integer, String> getDifficultMap() {
        return DIFFICULT_MAP;
    }

    public static int getMapMoveInterval() {
        return MAP_MOVE_INTERVAL;
    }

    public static int getMapMoveSpeed() {
        return MAP_MOVE_SPEED;
    }
}
