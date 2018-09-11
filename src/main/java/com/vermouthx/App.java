package com.vermouthx;

import com.vermouthx.config.MybatisConfig;
import com.vermouthx.controller.GameController;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        new GameController();
    }
}
