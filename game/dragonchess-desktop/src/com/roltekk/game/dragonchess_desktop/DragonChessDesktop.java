/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: desktop platform wrapper
 */

package com.roltekk.game.dragonchess_desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.roltekk.game.dragonchess_core.DragonChessCore;

public class DragonChessDesktop {
  public static void main(String[] args) {
    new LwjglApplication(new DragonChessCore(), "DragonChess", 480, 800, false);
  }
}
