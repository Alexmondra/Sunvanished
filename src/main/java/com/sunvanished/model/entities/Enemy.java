package com.sunvanished.model.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunvanished.helps.AssetsHelper;
import com.sunvanished.model.Entity;

public class Enemy extends Entity {

  private boolean visible = true;

  public void update(){


    if(speedX < 0) facing = -1; 
    else if (speedX > 0) facing = 1;

    if (x < 0 || x > 1240) visible = false;
    x -=speedX;


    hitbox = new Rectangle((int)x+20,(int)y,20,64);
  }
  public void draw(Graphics g){
    if(facing == 1){
      g.drawImage(AssetsHelper.enemy_1, (int)x, (int)y, null);
    }
    if(facing == -1){
      g.drawImage(AssetsHelper.enemy_2, (int)x, (int)y, null);
    }
  }

  public boolean getVisible(){
    return visible;
  } 
}
