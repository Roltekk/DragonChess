/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: game options screen
 */

package com.roltekk.dragonchess.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.roltekk.dragonchess.DragonChess;
import com.roltekk.dragonchess.enums.Screens;

public class OptionsScreen implements Screen, InputProcessor {
  private static final String TAG = "OptionsScreen";
  private static OptionsScreen mInstance = null;
  private DragonChess mDCC;
  private Color mBGColor = Color.GREEN;
  
  // unctor
  protected OptionsScreen() {}

  // singleton accessor
  public static OptionsScreen getInstance() {
    if (null == mInstance) { mInstance = new OptionsScreen(); }
    return mInstance;
  }
  
  public void init(DragonChess dcc) {
    mInstance.mDCC = dcc;
  }

  // Screen overrides /////////////////////////////////////////////////////////
  @Override
  public void render(float delta) {
    // clear screen
    Gdx.gl.glClearColor(mBGColor.r, mBGColor.b, mBGColor.g, mBGColor.a);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    // TODO : draw options screen here
    //...
    // test
    if (Gdx.input.justTouched()) {
      // msg core to go to the game screen
      mDCC.setScreen(Screens.GAME);
    }
  }

  @Override
  public void resize(int width, int height) {
    Gdx.app.debug(TAG, "resize");
  }

  @Override
  public void show() {
    Gdx.app.debug(TAG, "show");
  }

  @Override
  public void hide() {
    Gdx.app.debug(TAG, "hide");
  }

  @Override
  public void pause() {
    Gdx.app.debug(TAG, "pause");
  }

  @Override
  public void resume() {
    Gdx.app.debug(TAG, "resume");
  }

  @Override
  public void dispose() {
    Gdx.app.debug(TAG, "dispose");
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
