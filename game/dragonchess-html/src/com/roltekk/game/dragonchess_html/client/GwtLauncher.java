package com.roltekk.game.dragonchess_html.client;

import com.roltekk.game.dragonchess_core.DragonChessCore;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(480, 800);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new DragonChessCore();
	}
}
