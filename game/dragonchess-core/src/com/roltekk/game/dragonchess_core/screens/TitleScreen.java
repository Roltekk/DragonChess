/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: title and main menu screen
 */

package com.roltekk.game.dragonchess_core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.roltekk.game.dragonchess_core.DragonChessCore;
import com.roltekk.game.dragonchess_core.enums.Screens;

public class TitleScreen implements Screen, InputProcessor {
  private static final String TAG = "TitleScreen";
  private static TitleScreen mInstance = null;
  private DragonChessCore mDCC;
  
  // unctor
  protected TitleScreen() {}

  // singleton accessor
  public static TitleScreen getInstance() {
    if (null == mInstance) { mInstance = new TitleScreen(); }
    return mInstance;
  }
  
  public void init(DragonChessCore dcc) {
    mInstance.mDCC = dcc;
  }

  // Screen overrides /////////////////////////////////////////////////////////
  @Override
  public void render(float delta) {
    // clear screen (black)
    Gdx.gl.glClearColor(1.0f, 0.0f, 0.0f, 1);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    // TODO : draw title screen here
    //...
    // test
    if (Gdx.input.justTouched()) {
      // msg core to go to the options screen
      mDCC.setScreen(Screens.OPTIONS);
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

  // InputProcessor overrides /////////////////////////////////////////////////
  @Override
  public boolean keyDown(int keycode) {
    return false;
  }

  @Override
  public boolean keyUp(int keycode) {
    return false;
  }

  @Override
  public boolean keyTyped(char character) {
    return false;
  }

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    return false;
  }

  @Override
  public boolean mouseMoved(int screenX, int screenY) {
    return false;
  }

  @Override
  public boolean scrolled(int amount) {
    return false;
  }
}
