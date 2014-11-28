/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: Scene2D actor for logo screen image
 */

package com.roltekk.game.dragonchess_core.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class RTLogoActor extends Actor {
  private static final String TAG = "RTLogoActor";
  private Texture             mLogoTexture;
  public int                  textureWidth, textureHeight;
  
  public RTLogoActor() {
    mLogoTexture = new Texture(Gdx.files.internal("RTLogo.png"));
    textureWidth = mLogoTexture.getWidth();
    textureHeight = mLogoTexture.getHeight();
    mLogoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
    // set initial alpha value
    this.getColor().a = 0.0f;
  }

  @Override
  public void draw(SpriteBatch batch, float parentAlpha) {
    super.draw(batch, parentAlpha);
    batch.setColor(this.getColor().r, this.getColor().g, this.getColor().b, this.getColor().a);
    batch.draw(mLogoTexture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
  }
}
