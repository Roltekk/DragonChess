/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: core application code
 */

package com.roltekk.dragonchess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.roltekk.dragonchess.debug.Debug;
import com.roltekk.dragonchess.enums.Screens;
import com.roltekk.dragonchess.screens.GameScreen;
import com.roltekk.dragonchess.screens.LogoScreen;
import com.roltekk.dragonchess.screens.OptionsScreen;
import com.roltekk.dragonchess.screens.TitleScreen;

public class DragonChess extends Game {
  private static final String TAG = "DragonChessCore";
  private Music               mBGMusic;

  // ApplicationListener overrides ////////////////////////////////////////////
  @Override
  public void create() {
    Gdx.app.setLogLevel(Debug.LOG_LVL);
    Gdx.app.debug(TAG, "create game");
    
    // try to start music
    mBGMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Decline.mp3"));
    mBGMusic.setLooping(true);
    mBGMusic.play();
    
//    Global.checkGLVersion();
    // libgdx 0.9.8 results for :
    // Android - GL11
    // Desktop - GL11
    // HTML    - GL20
    
    // libgdx 1.4.1 results for :
    // Android 
    //    Nexus One 2.3.7 ------ < GL30
    //    Nexus 7 4.4.4 -------- < GL30
    //    Nexus 5 5.0 ---------- < GL30
    // Desktop (RT03/Win7) ----- + GL30
    // HTML (RT03/Win7/Chrome) - < GL30

    // TODO : get screen metrics and save in global state
    
    // TODO : will have to change where screens get inited so that a loading bar can be shown
    //        (possibly on logo screen)

    LogoScreen.getInstance().init(this);
    TitleScreen.getInstance().init(this);
    OptionsScreen.getInstance().init(this);
    GameScreen.getInstance().init(this);

    // set first screen
    setScreen(Screens.LOGO);
  }
  
  @Override
  public void dispose() {
    mBGMusic.dispose();
    LogoScreen.getInstance().dispose();
    TitleScreen.getInstance().dispose();
    OptionsScreen.getInstance().dispose();
    GameScreen.getInstance().dispose();
  }

  // other functions //////////////////////////////////////////////////////////
  public void setScreen(Screens nextScreen) {
    switch (nextScreen) {
    case LOGO:
      setScreen(LogoScreen.getInstance());
      break;
    case TITLE:
      setScreen(TitleScreen.getInstance());
      break;
    case OPTIONS:
      setScreen(OptionsScreen.getInstance());
      break;
    case GAME:
      setScreen(GameScreen.getInstance());
      break;
    }
  }
}
