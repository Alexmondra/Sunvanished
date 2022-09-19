package com.sunvanished.model.entities;

import java.awt.*;
import java.util.ArrayList;

import com.sunvanished.helps.AssetsHelper;
import com.sunvanished.model.Entity;
import com.sunvanished.model.EntityBuilder;

public class Player extends Entity {

    private int ammo = 50;
    private int life;
    private final boolean visible;
    // 1 rig
    // -1 left
    static ArrayList<Bullet> bullets;
    
    public Player() {
        bullets = new ArrayList<>();
        life = 3;
        visible = true;
            
    }
    public void update(){

        if(speedX < 0) facing = -1; 
        else if (speedX > 0) facing = 1;
        if (x + speedX > -10 && x + speedX <= 1210){
            x+= speedX;
        }
        double gravity = 2;
        if( speedY < gravity){
            speedY += 0.1;
        }
        if (y+ speedY < 420){
            y+= speedY;
        }else{
            speedY = 0;
        }
        hitbox = new Rectangle((int)x+20,(int)y,20,64);

        
    }
    
    public void fire()
    {
        if( ammo > 0 ){
            ammo--;
            EntityBuilder bulletBuild = new EntityBuilder.Builder(new Bullet())
                    .enPosX((int) (x + 32))
                    .enPosY((int) (y + 27))
                    .enSpeedX(facing * 3)
                    .build();
            bullets.add((Bullet) bulletBuild.getEntity());
        }
    }
 
    public void draw(Graphics g){
        if (visible){
             if (facing == -1){
                 g.drawImage(AssetsHelper.player_l, (int)x, (int)y, null);
             }
             if (facing == 1){
                 g.drawImage(AssetsHelper.player_r, (int)x, (int)y, null);
             }
        }
    }

    public static ArrayList<Bullet> getBullets(){
        return bullets;
    }

    public int getAmmo(){
        return ammo;
    }

    public void setAmmo(int ammo){
        this.ammo += ammo;
    }

    public int getLife(){
        return life;
    }
    public void setLife(int m){
        this.life -=m;
    }
   
}

    
    
     
