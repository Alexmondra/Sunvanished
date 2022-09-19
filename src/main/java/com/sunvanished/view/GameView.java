package com.sunvanished.view;

import javax.swing.*;

public class GameView extends JFrame {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;


    public GameView(GamePaneView gmw){
        setSize(WIDTH,HEIGHT);
        setTitle("SunVanished");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(gmw);
        setVisible(true);
    }
}
