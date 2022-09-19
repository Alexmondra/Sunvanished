package com.sunvanished.view;

import com.sunvanished.helps.AssetsHelper;
import com.sunvanished.controller.GameController;
import com.sunvanished.controller.KeyIntputController;

import javax.swing.*;
import java.awt.*;

public class GamePaneView  extends JPanel {
    private final GameController gameController;
    public GamePaneView(GameController gameController){
        this.gameController = gameController;
        setPreferredSize(new Dimension(GameController.WIDTH,GameController.HEIGHT));

        addKeyListener(new KeyIntputController(this));
        setFocusable(true);
        AssetsHelper.initAsset();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gameController.draw(g);
    }

    public GameController getGame(){
        return gameController;
    }
}
