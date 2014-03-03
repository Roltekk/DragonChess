/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: initial logo screen
 */

package com.roltekk.game.dragonchess_core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.roltekk.game.dragonchess_core.DragonChessCore;
import com.roltekk.game.dragonchess_core.Global;
import com.roltekk.game.dragonchess_core.actors.RTLogoActor;
import com.roltekk.game.dragonchess_core.enums.Screens;

public class LogoScreen implements Screen {
  private static final String TAG       = "LogoScreen";
  private static LogoScreen   mInstance = null;
  private DragonChessCore     mDCC;
  private Color               mBGColor  = Color.BLACK;
  private RTLogoActor         mRTLogoActor;
  private Stage               mStage;
  private Camera              mCamera;
  
  // unctor
  protected LogoScreen() {}

  // singleton accessor
  public static LogoScreen getInstance() {
    if (null == mInstance) { mInstance = new LogoScreen(); }
    return mInstance;
  }
  
  public void init(DragonChessCore dcc) {
    mInstance.mDCC = dcc;
    
    // create camera and viewport
    mCamera = new OrthographicCamera(Global.GAME_WIDTH, Global.GAME_HEIGHT);
    mCamera.position.set(0, 0, 0);
    
    // create actors and stage
    mRTLogoActor = new RTLogoActor();
    mRTLogoActor.setPosition(-mRTLogoActor.textureWidth / 2, -mRTLogoActor.textureHeight / 2);
    mRTLogoActor.setWidth(mRTLogoActor.textureWidth);
    mRTLogoActor.setHeight(mRTLogoActor.textureHeight);
    
    // setup logo fadein, pause, fadeout action sequence
    mRTLogoActor.addAction(
        Actions.sequence(
            Actions.fadeIn(0.73f),
            Actions.delay(1.75f),
            Actions.fadeOut(0.73f),
            new RunnableAction() {
      public void run() {
        // go to title screen after logo is faded out
        mDCC.setScreen(Screens.TITLE);
      }
    }));

    mStage = new Stage();
    mStage.addActor(mRTLogoActor);
    mStage.setCamera(mCamera);
  }

  // Screen overrides /////////////////////////////////////////////////////////
  @Override
  public void render(float delta) {
    // clear screen
    Gdx.gl.glClearColor(mBGColor.r, mBGColor.b, mBGColor.g, mBGColor.a);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

    // draw RolTekk logo
    mStage.act(Gdx.graphics.getDeltaTime());
    mStage.draw();

    // msg core to go to the title screen
    if (Gdx.input.justTouched()) { mDCC.setScreen(Screens.TITLE); }
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
    mStage.dispose();
  }
}
