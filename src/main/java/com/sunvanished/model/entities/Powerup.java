package com.sunvanished.model.entities;

import com.sunvanished.helps.AssetsHelper;
import com.sunvanished.model.Entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Powerup extends Entity {

  Random r = new Random();
  private final int bonusBullets;

  public Powerup(){
    bonusBullets = r.nextInt(30)+1;
  }
  public void update(){
    if (y+ speedY < 455){
      y+= speedY;
    }else{
      speedY = 0;
    }
    hitbox = new Rectangle((int)x,(int)y,32,32);
  }

  public void draw(Graphics g){
    g.drawImage(AssetsHelper.bonus,(int)x,(int)y,null);
  }

  public int getBonusBullets(){
    return bonusBullets;
  }
}
