package com.vermouthx.view.layer;

import com.vermouthx.controller.GameController;

import javax.swing.*;

class BasePanel extends JPanel {
    GameController gameController;

    BasePanel(GameController gameController) {
        this.gameController = gameController;
    }
}
