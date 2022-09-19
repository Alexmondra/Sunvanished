package com.sunvanished.controller;

import com.sunvanished.model.ScenesState;
import com.sunvanished.helps.StateHelper;
import com.sunvanished.view.*;

import java.awt.*;

public class GameController implements Runnable{
    private boolean isRunning = false;
    private Thread thread;


    SceneController sceneController;
    //Constantes del tamano de la ventana
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    //public static final int

    private final GamePaneView gpv;

    public GameController(){
        gpv = new GamePaneView(this);
        GameView gv = new GameView(gpv);
        sceneController = new SceneController();
        gpv.requestFocus();

        //Inicia hilo principal
        RunGame();
    }

    //Inicia el hilo principal
    public void RunGame(){
        isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
        ScenesState.setScene(sceneController.getMenuScene());
    }

    //Detiener el hilo principal
    public void StopGame(){
        isRunning = false;
        this.thread.interrupt();
    }
    @Override
    public void run(){
        int FPS_SET = 60;
        int UPS_SET = 120;
        double TimePS = 1000000000.0 / FPS_SET;

        double TimePUpdate = 1000000000.0 / UPS_SET;

        long previusT = System.nanoTime();
        int frame = 0;
        int updates = 0;
        long lastTick = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;


        while (isRunning) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - previusT) / TimePUpdate;
            deltaF += (currentTime - previusT) / TimePS;
            previusT = currentTime;
            if (deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            if (deltaF >= 1){
                gpv.repaint();
                frame++;
                deltaF--;
            }
            if(System.currentTimeMillis() - lastTick >= 1000){
                lastTick = System.currentTimeMillis();
                frame = 0;
                updates = 0;
            }
        }
        StopGame();
    }

    private void update() {
        switch (StateHelper.currentScene){
            case GAME:
                sceneController.UpdateSceneGame();break;
        }

    }
    //Funcion que se encarga de dibujar los objetos en pantalla

    public void draw(Graphics g){
        ScenesState.getScene().paintScene(g);
    }

    public SceneController getSceneController() {
        return sceneController;
    }

    public void setSceneController(SceneController sceneController) {
        this.sceneController = sceneController;
    }

}
