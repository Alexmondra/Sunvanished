package com.sunvanished.model;

import com.sunvanished.controller.SceneController;

import java.awt.*;

public abstract class ScenesState {

  protected SceneController game;

  public ScenesState(SceneController sceneController){
    this.game = sceneController;
  }
  //Metodo que debe ser llamado por cada hijo de la clase
  public abstract void paintScene(Graphics g);

  private static ScenesState currentScene = null;

  public static ScenesState getScene(){
    return currentScene;
  }

  public SceneController getController(){
    return game;
  }

  public static void setScene(ScenesState s){
    currentScene = s;
  }

  public void setController(SceneController g){
    this.game = g;
  }

}
