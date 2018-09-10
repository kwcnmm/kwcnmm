package com.vermouthx.dto;

import com.vermouthx.entity.PlayerPlane;

public class GameDTO {

    private String difficulty;

    private PlayerPlane playerPlane;

    public GameDTO() {
        playerPlane = new PlayerPlane();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public PlayerPlane getPlayerPlane() {
        return playerPlane;
    }

    public void setPlayerPlane(PlayerPlane playerPlane) {
        this.playerPlane = playerPlane;
    }

    /**
     * single instance dto
     */
    private static GameDTO dto;

    public static GameDTO getDto() {
        if (dto == null)
            dto = new GameDTO();
        return dto;
    }
}
