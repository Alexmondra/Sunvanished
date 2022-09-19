package com.sunvanished.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.sunvanished.controller.GameController;
import com.sunvanished.controller.SceneController;
import com.sunvanished.controller.SpawnController;
import com.sunvanished.helps.AssetsHelper;
import com.sunvanished.model.EntityBuilder;
import com.sunvanished.model.ScenesState;
import com.sunvanished.model.entities.*;

public class GameSceneView extends ScenesState {

  private Enemy enemy;
  private EntityBuilder playerBuild;
  private Player player;
  private int Score = 0;
  private SpawnController spawn;
  private Powerup bonusBullet;

  public GameSceneView(SceneController sceneController){
    super(sceneController);

    playerBuild = new EntityBuilder.Builder(new Player())
            .enPosX(640)
            .enPosY(320)
            .build();
    player = (Player)playerBuild.getEntity();
    spawn = new SpawnController();
    spawn.start();

  }
  @Override
  public void paintScene(Graphics g){

    g.drawImage(AssetsHelper.bg, 0, 0, GameController.WIDTH, GameController.HEIGHT, null);
    player.draw(g);
    ArrayList<Bullet> bullets = player.getBullets();
    for (Bullet bullet : bullets) {
      Bullet m = bullet;
      m.draw(g);
    }

    //Enemigos
    ArrayList<Enemy> ene = spawn.getListEnemy();
    for (Enemy enemy : ene) {
      this.enemy = enemy;
      this.enemy.draw(g);
    }

    ArrayList<Powerup> ps = spawn.getListBonus();
    for (Powerup powerup : ps) {
      bonusBullet = powerup;
      bonusBullet.draw(g);
    }

    g.setFont(AssetsHelper.bit8_2);
    g.setColor(new Color(165, 92, 255));
    g.drawString("Ammo", 4, 530);
    g.drawString("Life", 4, 585);
    g.drawString("Score", 4, 640);

    g.setColor(Color.WHITE);
    g.drawString(""+ player.getAmmo(), 4, 555);
    g.drawString(""+ player.getLife(), 4, 610);
    g.drawString(""+Score, 4, 665);

    //GameOver 
    if (player.getLife() == 0){

      g.setColor(new Color(0,0,0, 200));
      g.fillRect(0, 0, 1280, 720);

      g.setColor(Color.WHITE);
      g.drawString("GAME OVER", 515, 350);
      g.drawString("S1N7AX", 565, 280);
      g.drawString("Press - esc - to back Menu", 410, 460);
    }
  }

  public Enemy getEnemy() {
    return enemy;
  }

  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public int getScore() {
    return Score;
  }

  public void setScore(int score) {
    Score += score;
  }

  public Powerup getBonusBullet() {
    return bonusBullet;
  }

  public void setBonusBullet(Powerup bonusBullet) {
    this.bonusBullet = bonusBullet;
  }
  public EntityBuilder getPlayerBuild() {
    return playerBuild;
  }

  public void setPlayerBuild(EntityBuilder playerBuild) {
    this.playerBuild = playerBuild;
  }

  public SpawnController getSpawn() {
    return spawn;
  }

  public void setSpawn(SpawnController spawn) {
    this.spawn = spawn;
  }

}
