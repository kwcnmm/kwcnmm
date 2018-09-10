package com.vermouthx.controller;

import com.vermouthx.dto.GameDTO;
import com.vermouthx.util.FrameUtil;
import com.vermouthx.view.GameFrame;
import com.vermouthx.view.layer.GamePanel;
import com.vermouthx.view.layer.LaunchPanel;

import javax.swing.*;

public class GameController {

    private GameDTO dto;

    private JFrame gameFrame;
    private JPanel launchPanel;
    private JPanel gamePanel;

    private PlayerController playerController;

    public GameController() {
        init();
        dto = GameDTO.getDto();
        playerController = new PlayerController(dto.getPlayerPlane(), this);
    }

    private void init() {
        launchPanel = new LaunchPanel(this);
        gameFrame = new GameFrame();
        FrameUtil.setContentPanel(gameFrame, launchPanel);
    }

    public void startGame() {
        gamePanel = new GamePanel(this);
        gamePanel.addKeyListener(playerController);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    playerController.triggerPressedKey();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        FrameUtil.setContentPanel(gameFrame, gamePanel);
        gameFrame.repaint();
    }

    public void repaintGamePanel() {
        gamePanel.repaint();
    }

    public GameDTO getDto() {
        return dto;
    }
}
