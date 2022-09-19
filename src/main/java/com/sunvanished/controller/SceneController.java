package com.sunvanished.controller;

import com.sunvanished.model.ScenesState;
import com.sunvanished.helps.StateHelper;
import com.sunvanished.model.entities.*;
import com.sunvanished.view.CreditsSceneView;
import com.sunvanished.view.GameSceneView;
import com.sunvanished.view.MenuSceneView;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class SceneController {


    private GameSceneView gameScene;
    private MenuSceneView menuScene;
    private CreditsSceneView creditsScene;


    public SceneController(){
        gameScene = new GameSceneView(this);
        menuScene = new MenuSceneView(this);
        creditsScene = new CreditsSceneView(this);
    }
    public void UpdateSceneGame(){
        gameScene.getPlayer().update();
        ArrayList<Bullet> bullets = gameScene.getPlayer().getBullets();
        for( int i = 0; i < bullets.size(); i++){
            Bullet m = bullets.get(i);
            if(m.getVisible()){
                m.update();
            }else{
                bullets.remove(i);
            }
        }

        ArrayList<Powerup> ps = gameScene.getSpawn().getListBonus();
        for(int o = 0; o < ps.size(); o++){
            gameScene.setBonusBullet(ps.get(o));
            gameScene.getBonusBullet().update();
            if(gameScene.getPlayer().getHitBox().intersects(gameScene.getBonusBullet().getHitBox())){
                ps.remove(o);
                gameScene.getSpawn().removeBonus(gameScene.getBonusBullet());
                gameScene.getPlayer().setAmmo(gameScene.getBonusBullet().getBonusBullets());
            }
        }

        //Enemigos
        ArrayList<Enemy> ene = gameScene.getSpawn().getListEnemy();
        for(int y = 0 ; y < ene.size(); y++){
            gameScene.setEnemy(ene.get(y));
            if(gameScene.getEnemy().getVisible()){
                gameScene.getEnemy().update();
                for(int j =0; j<bullets.size(); j++){
                    Bullet m = bullets.get(j);
                    if(gameScene.getEnemy().getHitBox().intersects(m.getHitBox())){
                        ene.remove(y);
                        gameScene.getSpawn().removeEnemy(gameScene.getEnemy());
                        bullets.remove(j);
                        gameScene.setScore(10);
                    }
                }
                if(gameScene.getPlayer().getHitBox().intersects(gameScene.getEnemy().getHitBox())){
                    ene.remove(y);
                    gameScene.getSpawn().removeEnemy(gameScene.getEnemy());
                    gameScene.getPlayer().setLife(1);

                }
            }else{
                ene.remove(y);
                gameScene.getSpawn().removeEnemy(gameScene.getEnemy());
            }
        }

        if(gameScene.getPlayer().getLife() == 0){
            gameScene.getSpawn().stop();
            gameScene.getSpawn().removeEnemy(gameScene.getEnemy());
        }
    }
    public void keyPressed(KeyEvent e){
        switch(StateHelper.currentScene){
            case MENU:
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    menuScene.setSelectStateR(1);
                    if (menuScene.getSelectState() < 0){
                        menuScene.setSelectState(2);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    menuScene.setSelectStateS(1);
                    if (menuScene.getSelectState() > 2){
                        menuScene.setSelectState(0);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    switch(menuScene.getSelectState()){
                        case 0:
                            StateHelper.currentScene = StateHelper.GAME;
                            ScenesState.setScene(gameScene);
                            break;
                        case 1:

                            StateHelper.currentScene = StateHelper.CREDITS;
                            ScenesState.setScene(creditsScene);
                            break;
                        case 2:
                            System.exit(0);
                            break;
                    }
                }
                break;
            case GAME:
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    gameScene.getSpawn().stop();
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    gameScene.getPlayer().setSpeedX(-1);
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    gameScene.getPlayer().setSpeedX(1);
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_W){
                    if(gameScene.getPlayer().getSpeedY() == 0 ){
                        gameScene.getPlayer().setSpeedY(-4.6);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_P){
                    gameScene.getPlayer().fire();
                }
                if (e.getKeyCode() == KeyEvent.VK_L) gameScene.getPlayer().setAmmo(10);
                break;
            case CREDITS:
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    StateHelper.currentScene = StateHelper.MENU;
                    ScenesState.setScene(menuScene);
                } 
                break;
            default: ;break;
        }
    }
    public void keyReleased(KeyEvent e){
        switch(StateHelper.currentScene){
            case MENU:
                break;
            case GAME:
                if(e.getKeyCode() == KeyEvent.VK_A){
                    gameScene.getPlayer().setSpeedX(0);
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    gameScene.getPlayer().setSpeedX(0);
                }
                break;
            case CREDITS:
                break;
        }

    }
    public GameSceneView getGameScene() {
        return gameScene;
    }

    public void setGameScene(GameSceneView gameScene) {
        this.gameScene = gameScene;
    }

    public MenuSceneView getMenuScene() {
        return menuScene;
    }

    public void setMenuScene(MenuSceneView menuScene) {
        this.menuScene = menuScene;
    }

    public CreditsSceneView getCreditsScene() {
        return creditsScene;
    }

    public void setCreditsScene(CreditsSceneView creditsScene) {
        this.creditsScene = creditsScene;
    }
}
