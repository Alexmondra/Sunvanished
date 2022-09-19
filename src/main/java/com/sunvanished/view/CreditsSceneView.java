package com.sunvanished.view;

import java.awt.Color;
import java.awt.Graphics;

import com.sunvanished.helps.AssetsHelper;
import com.sunvanished.controller.SceneController;
import com.sunvanished.model.ScenesState;

public class CreditsSceneView extends ScenesState {

  public CreditsSceneView(SceneController sceneController){
    super(sceneController);

  }
  @Override
  public void paintScene(Graphics g){
    g.setColor(new Color(22, 23, 26));

    g.fillRect(0, 0, 1920, 1080);
    g.setFont(AssetsHelper.bit8_2);
   
    g.drawImage(AssetsHelper.logo, 450, 92, null);

    g.setColor(new Color(224, 224, 224));
    g.drawString("Cieza Llontop Segundo", 465, 400);
    g.drawString("Mondragon Fernandez Alex", 414, 460);
    g.drawString("Reluz Mendo Jesus Alejando", 397, 520);
    g.drawString("Rojas Cisneros Jhordan Alexis", 375, 580);

    g.setColor(Color.WHITE);
    g.drawImage(AssetsHelper.btnSelect, 1040, 615, null);
    g.drawString("Volver", 1100, 655);
  }


}
