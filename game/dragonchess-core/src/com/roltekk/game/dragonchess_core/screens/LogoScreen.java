/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: initial logo screen
 */

package com.roltekk.game.dragonchess_core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

import com.roltekk.game.dragonchess_core.DragonChessCore;
import com.roltekk.game.dragonchess_core.enums.Screens;

public class LogoScreen implements Screen {
  private static final String TAG = "LogoScreen";
  private static LogoScreen mInstance = null;
  private DragonChessCore mDCC;
  
  // unctor
  protected LogoScreen() {}

  // singleton accessor
  public static LogoScreen getInstance() {
    if (null == mInstance) { mInstance = new LogoScreen(); }
    return mInstance;
  }
  
  public void init(DragonChessCore dcc) {
    mInstance.mDCC = dcc;
  }

  // Screen overrides /////////////////////////////////////////////////////////
  @Override
  public void render(float delta) {
    // clear screen (black)
    Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    // TODO : draw RolTekk logo here
    //...
    
    if (Gdx.input.justTouched()) {
      // msg core to go to the title screen
      mDCC.setScreen(Screens.TITLE);
    }
  }

  @Override
  public void resize(int width, int height) {
  }

  @Override
  public void show() {
  }

  @Override
  public void hide() {
  }

  @Override
  public void pause() {
  }

  @Override
  public void resume() {
  }

  @Override
  public void dispose() {
  }
}
