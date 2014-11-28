/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: Global state class
 */

package com.roltekk.game.dragonchess_core;

import com.badlogic.gdx.Gdx;

public class Global {
  private static final String TAG               = "Global";
  public static final int     GAME_WIDTH        = 480;
  public static final int     GAME_HEIGHT       = 800;
  public static final float   GAME_ASPECT_RATIO = (float) GAME_WIDTH / (float) GAME_HEIGHT;
  
  public static void checkGLVersion() {
    if (Gdx.graphics.isGL20Available()) {
      Gdx.app.debug(TAG, "GL20");
    } else {
      if (Gdx.graphics.isGL11Available()) {
        Gdx.app.debug(TAG, "GL11");
      } else {
        Gdx.app.debug(TAG, "GL10");
      }
    }
  }
}
