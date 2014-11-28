/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: web platform wrapper
 */

package com.roltekk.dragonchess.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.roltekk.dragonchess.DragonChess;

public class HtmlLauncher extends GwtApplication {

  @Override
  public GwtApplicationConfiguration getConfig() {
    return new GwtApplicationConfiguration(480, 800);
  }

  @Override
  public ApplicationListener getApplicationListener() {
    return new DragonChess();
  }
}
