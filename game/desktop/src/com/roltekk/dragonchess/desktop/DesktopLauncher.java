/*
 * Copyright (C) 2014 RolTekk
 * Application: DragonChess
 * Description: desktop platform wrapper
 */

package com.roltekk.dragonchess.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.roltekk.dragonchess.DragonChess;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 800;
		config.width = 480;
		config.title = "DragonChess";
		new LwjglApplication(new DragonChess(), config);
	}
}
