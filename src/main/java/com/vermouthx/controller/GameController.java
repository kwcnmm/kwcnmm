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

    public GameController() {
        init();
        dto = new GameDTO();
    }

    private void init() {
        launchPanel = new LaunchPanel(this);
        gameFrame = new GameFrame();
        FrameUtil.setContentPanel(gameFrame, launchPanel);
    }

    public void startGame() {
        gamePanel = new GamePanel(this);
        FrameUtil.setContentPanel(gameFrame, gamePanel);
        gameFrame.repaint();
    }

    public GameDTO getDto() {
        return dto;
    }
}
