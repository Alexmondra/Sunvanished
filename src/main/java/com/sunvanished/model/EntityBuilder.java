package com.sunvanished.model;

public class EntityBuilder {
  private Entity typeEntity;

  public static class Builder{

    private final Entity typeEntity;

    public Builder(Entity enty){
      this.typeEntity = enty;
    }
    public Builder enPosX(double x){
      this.typeEntity.setPosX(x);

      return this;
    }

    public Builder enPosY(double y){
      this.typeEntity.setPosY(y);

      return this;
    }
    public Builder enSpeedX(double speedX){
      this.typeEntity.setSpeedX(speedX);;
      return this;
    }
    public Builder enSpeedY(double speedY){
      this.typeEntity.setSpeedY(speedY);
      return this;
    }

    public EntityBuilder build(){
      EntityBuilder en = new EntityBuilder();
      en.typeEntity = this.typeEntity;
      return en;
    }
  }

  public EntityBuilder(){
  }

  public Entity getEntity(){
    return typeEntity;
  }

}
