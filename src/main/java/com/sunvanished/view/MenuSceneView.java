package com.sunvanished.view;


import java.awt.Color;
import java.awt.Graphics;

import com.sunvanished.helps.AssetsHelper;
import com.sunvanished.controller.GameController;
import com.sunvanished.controller.SceneController;
import com.sunvanished.model.ScenesState;



public class MenuSceneView extends ScenesState {

  public int getSelectState() {
    return selectState;
  }

  public void setSelectStateS(int selectState) {
    this.selectState += selectState;
  }
  public void setSelectStateR(int selectState) {
    this.selectState -= selectState;
  }
  public void setSelectState(int selectState) {
    this.selectState = selectState;
  }
  public int selectState = 0;
  public MenuSceneView(SceneController sceneController){
    super(sceneController);
  }

  @Override
  public void paintScene(Graphics g){
    g.setColor(new Color(22, 23, 26));

    g.fillRect(0, 0, GameController.WIDTH, GameController.HEIGHT);
    g.setFont(AssetsHelper.bit8);
   
    g.drawImage(AssetsHelper.logo, 450, 92, null);
  
    switch(selectState){
      case 0:
        g.drawImage(AssetsHelper.btnSelect, 550, 395, null);
        g.setColor(Color.white);
        g.drawString("Play", 620, 440);
        g.setColor(new Color(176, 184, 206));
        g.drawString("CREDITS", 620, 510);
        g.drawString("EXIT", 620, 590);
        break;
      case 1:
        g.drawImage(AssetsHelper.btnSelect, 550, 465, null);
        g.setColor(new Color(176, 184, 206));
        g.drawString("Play", 620, 440);
        g.drawString("EXIT", 620, 590);

        g.setColor(Color.white);
        g.drawString("CREDITS", 620, 510);
        break;
      case 2:
        g.drawImage(AssetsHelper.btnSelect, 550, 535, null);
        g.setColor(new Color(176, 184, 206));
        g.drawString("Play", 620, 440);
        g.drawString("CREDITS", 620, 510);
        
        g.setColor(Color.white);
        g.drawString("EXIT", 620, 590);
        break;
    }
  }
}



