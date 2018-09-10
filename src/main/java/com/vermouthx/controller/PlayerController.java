package com.vermouthx.controller;

import com.vermouthx.entity.Direction;
import com.vermouthx.entity.PlayerPlane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerController extends KeyAdapter {

    private PlayerPlane playerPlane;

    public PlayerController(PlayerPlane playerPlane) {
        this.playerPlane = playerPlane;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'e':
                playerPlane.move(Direction.UP);
                break;
            case 'd':
                playerPlane.move(Direction.DOWN);
                break;
            case 's':
                playerPlane.move(Direction.LEFT);
                break;
            case 'f':
                playerPlane.move(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerPlane.move(Direction.STILL);
    }
}
