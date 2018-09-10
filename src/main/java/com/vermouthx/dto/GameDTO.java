package com.vermouthx.dto;

import com.vermouthx.entity.BaseBullet;
import com.vermouthx.entity.PlayerPlane;

import java.util.ArrayList;
import java.util.List;

public class GameDTO {

    private String difficulty;

    private PlayerPlane playerPlane;

    private List<BaseBullet> playerBullets;

    private List<BaseBullet> enemyBullets;

    public GameDTO() {
        playerPlane = new PlayerPlane();
        playerBullets = new ArrayList<>();
        enemyBullets = new ArrayList<>();
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

    public List<BaseBullet> getPlayerBullets() {
        return playerBullets;
    }

    public List<BaseBullet> getEnemyBullets() {
        return enemyBullets;
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
