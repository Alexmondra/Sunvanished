package com.sunvanished.helps;

import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class AssetsHelper {

  public static BufferedImage logo, bg, btnSelect, player_r, player_l, bullet, enemy_1, enemy_2, gm, bonus;
  public static Font bit8, bit8_2;

  public static BufferedImage loadImg(String path){
    try {
      return ImageIO.read(Objects.requireNonNull(AssetsHelper.class.getResourceAsStream(path)));
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("No se encontro en la ruta" +  path);
    }
    return null;
  }

  public static Font loadFont(String fontName, int style, int size){
    Font newfont = null;
    try {
      InputStream is = AssetsHelper.class.getResourceAsStream(fontName);
      newfont = Font.createFont(Font.TRUETYPE_FONT, is);

    } catch (Exception e) {
      newfont = new Font("Arial", Font.PLAIN, 14);
    }

    return newfont.deriveFont(style, size);

  }

  //
  public static void initAsset(){
    logo = loadImg("/logo.png");
    btnSelect = loadImg("/btnSelect.png");
    bg = loadImg("/background.png");
    player_r = loadImg("/Player/player_1.png");
    player_l = loadImg("/Player/player_2.png");
    bullet = loadImg("/Player/dispa.png");
    enemy_1 = loadImg("/Enemy/Zombie_1.png");
    enemy_2 = loadImg("/Enemy/Zombie_2.png");
    gm = loadImg("/GameOver.png");
    bonus = loadImg("/Bonus.png");

    //Funtes
   
    bit8 = loadFont("/fonts/bit8.TTF", 0, 34);
    bit8_2 = loadFont("/fonts/bit8.TTF", 0, 24);
  }
}
