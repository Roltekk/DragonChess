package com.roltekk.game.dragonchess_core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DragonChessCore implements ApplicationListener, InputProcessor {
  private float color1[] = { 0, 0, 0 };
  private float color2[] = { 1, 1, 1 };
  private float currentColor[] = { 0, 0, 0 };
  private int colorInx = 1;

  private SpriteBatch batch;
  private Pixmap pixmap;
  private Texture texture;
  private Sprite sprite;

  // ApplicationListener overrides ////////////////////////////////////////////
  @Override
  public void create() {
    System.out.println("create");
    // create test pixmap to make sure all platforms are drawing correctly
    // (taken from sample)
    batch = new SpriteBatch();
    pixmap = new Pixmap(256,128, Pixmap.Format.RGBA8888);
    
    //Fill it red
    pixmap.setColor(Color.RED);
    pixmap.fill();
    
    //Draw two lines forming an X
    pixmap.setColor(Color.BLACK);
    pixmap.drawLine(0, 0, pixmap.getWidth()-1, pixmap.getHeight()-1);
    pixmap.drawLine(0, pixmap.getHeight()-1, pixmap.getWidth()-1, 0);
    
    //Draw a circle about the middle
    pixmap.setColor(Color.YELLOW);
    pixmap.drawCircle(pixmap.getWidth()/2, pixmap.getHeight()/2, pixmap.getHeight()/2 - 1);

    texture = new Texture(pixmap);
    
    //It's the textures responsibility now... get rid of the pixmap
    pixmap.dispose();
    sprite = new Sprite(texture);
    

    // set this class as input processor
    Gdx.input.setInputProcessor(this);
  }

  @Override
  public void render() {
    // clear screen (black)
    Gdx.gl.glClearColor(currentColor[0], currentColor[1], currentColor[2], 1);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    
    // render pixmap
    batch.begin();
    sprite.setPosition(0, 0);
    sprite.draw(batch);
    sprite.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    sprite.draw(batch);
    batch.end();
  }

  @Override
  public void resize(int width, int height) {
  }

  @Override
  public void pause() {
  }

  @Override
  public void resume() {
  }

  @Override
  public void dispose() {
    batch.dispose();
    texture.dispose();
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
    // test screen colour switch
    switch (colorInx) {
    case 1:
      colorInx = 2;
      currentColor[0] = color2[0];
      currentColor[1] = color2[1];
      currentColor[2] = color2[2];
      break;
    case 2:
      colorInx = 1;
      currentColor[0] = color1[0];
      currentColor[1] = color1[1];
      currentColor[2] = color1[2];
      break;
    }
    return true;
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
