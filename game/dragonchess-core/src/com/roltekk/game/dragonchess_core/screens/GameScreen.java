/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: main game screen
 */

package com.roltekk.game.dragonchess_core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.roltekk.game.dragonchess_core.DragonChessCore;
import com.roltekk.game.dragonchess_core.enums.Screens;

public class GameScreen implements Screen, InputProcessor {
  private static final String TAG = "GameScreen";
  private static GameScreen mInstance = null;
  private DragonChessCore mDCC;
  private Color mBGColor = Color.BLUE;
  
  // unctor
  protected GameScreen() {}

  // singleton accessor
  public static GameScreen getInstance() {
    if (null == mInstance) { mInstance = new GameScreen(); }
    return mInstance;
  }
  
  public void init(DragonChessCore dcc) {
    mInstance.mDCC = dcc;
  }

  // Screen overrides /////////////////////////////////////////////////////////
  @Override
  public void render(float delta) {
    // clear screen
    Gdx.gl.glClearColor(mBGColor.r, mBGColor.b, mBGColor.g, mBGColor.a);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    // TODO : draw game screen here
    //...
    // test
    if (Gdx.input.justTouched()) {
      // msg core to go to the logo screen
      mDCC.setScreen(Screens.LOGO);
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
