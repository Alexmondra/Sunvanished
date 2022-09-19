package com.sunvanished.model;

import java.awt.Graphics;
import java.awt.Rectangle;

//Clase modelo
public abstract class Entity {
  protected double x, y, speedX, speedY;
  protected int facing = 1;
  protected Rectangle hitbox;

  public Entity(){
  }
  public double getPosX(){
    return x;
  }
  public abstract void update();
  public abstract void draw(Graphics g);

  public void setPosX(double x){
    this.x = x;
  }

  public double getPosY(){
    return y;
  }

  public void setPosY(double y){
    this.y = y;
  }

  public void setSpeedX(double speed){
    this.speedX = speed;
  }

  public double getSpeedX(){
    return speedX;
  }

  public void setSpeedY(double speedY){
    this.speedY = speedY;
  }

  public double getSpeedY(){
    return speedY;
  }

  public void setFacing(int facing){
    this.facing = facing;
  }

  public int getFacing(){
    return facing;
  }

  public Rectangle getHitBox(){
    return hitbox;
  }

}
