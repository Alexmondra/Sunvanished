package com.sunvanished.controller;

import com.sunvanished.model.entities.Enemy;
import com.sunvanished.model.entities.Powerup;
import com.sunvanished.model.EntityBuilder;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SpawnController extends Thread{

  private final ArrayList<Enemy> ListEnemy;
  private final ArrayList<Powerup> listPower;
  ThreadLocalRandom r = ThreadLocalRandom.current();
  EntityBuilder entityBuild;
  Random r2 = new Random();

  public SpawnController(){
    ListEnemy = new ArrayList<>();
    listPower = new ArrayList<>();
  }

  @Override

  public void run(){
    while (true) {
      int randomSpawnEnemy = r2.nextInt(2) + 1;
      int randomSpawnBonus = r2.nextInt(10) + 1;
      if (randomSpawnEnemy == 1){
        entityBuild = new EntityBuilder.Builder(new Enemy())
                .enPosX(1235)
                .enPosY(420)
                .enSpeedX(0.4)
                .build();

        addEnemy((Enemy) entityBuild.getEntity());
      }
      if(randomSpawnEnemy == 2){
         entityBuild = new EntityBuilder.Builder(new Enemy())
                 .enPosX(0)
                 .enPosY(420)
                 .enSpeedX(-0.4)
                 .build();
         addEnemy((Enemy) entityBuild.getEntity());
      }
      if(randomSpawnBonus == 6){
        entityBuild = new EntityBuilder.Builder(new Powerup())
                .enPosX((r.nextInt(10, 1215)+1))
                .enPosY(0)
                .enSpeedY(0.4)
                .build();
        addBonus((Powerup) entityBuild.getEntity());
      }
      try {
        int timeSpawn = r.nextInt(1500, 2500 + 1);
        sleep(timeSpawn);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void addEnemy(Enemy g){
    ListEnemy.add(g);
  }

  public void addBonus(Powerup p){
    listPower.add(p);
  }

  public void removeBonus(Powerup p){
    listPower.remove(p);
  }
  public void removeEnemy(Enemy g){
    ListEnemy.remove(g);
  }

  public ArrayList<Enemy> getListEnemy(){
    return ListEnemy;
  }

  public ArrayList<Powerup> getListBonus(){
    return listPower;
  }
  
}
