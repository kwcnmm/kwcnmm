package com.vermouthx.view;

import com.vermouthx.config.GameConfig;
import com.vermouthx.util.ResourceUtil;

import javax.swing.*;

class BaseFrame extends JFrame {

    BaseFrame() {
        setTitle(GameConfig.getGameName());
        setSize(GameConfig.getWindowWidth(), GameConfig.getWindowHeight() + 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(ResourceUtil.getResource("logo/smsBuyMust1.jpg")).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
