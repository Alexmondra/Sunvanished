package com.sunvanished.controller;

import com.sunvanished.helps.StateHelper;
import com.sunvanished.model.ScenesState;
import com.sunvanished.view.GamePaneView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyIntputController implements KeyListener {
    GamePaneView gamePanel;
    public KeyIntputController(GamePaneView gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyPressed(KeyEvent e){
        gamePanel.getGame().getSceneController().keyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE && StateHelper.currentScene == StateHelper.GAME){
            StateHelper.currentScene = StateHelper.MENU;
            gamePanel.getGame().setSceneController(new SceneController());
            ScenesState.setScene(gamePanel.getGame().getSceneController().getMenuScene());
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        gamePanel.getGame().getSceneController().keyReleased(e);
    }
    @Override
    public void keyTyped(KeyEvent e){
 
    }
}
