package com.sunvanished.model.entities;

import com.sunvanished.model.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Entity {
  
  private boolean visible;

  public Bullet(){
    visible = true;
  }

  public void update(){
    x += speedX;
    if (x < 0 || x > 1245) visible = false;
    hitbox = new Rectangle((int)x, (int)y,10,3);
  }

  public void draw(Graphics g){
    g.setColor(Color.WHITE);
    g.fillRect((int)x, (int)y, 10, 3);
  }
  public boolean getVisible(){
    return visible;
  }
}
