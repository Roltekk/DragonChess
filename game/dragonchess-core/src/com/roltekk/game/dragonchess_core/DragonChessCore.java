package com.roltekk.game.dragonchess_core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

public class DragonChessCore implements ApplicationListener {
  
  private Mesh mTestMesh;

  @Override
  public void create() {
    // create test mesh to make sure all platforms are drawing correctly
    if (null == mTestMesh) {
      mTestMesh = new Mesh(true, 3, 3, 
          new VertexAttribute(Usage.Position, 3, "a_position"),
          new VertexAttribute(Usage.ColorPacked, 4, "a_color"));

      mTestMesh.setVertices(new float[] 
          { -0.5f, -0.5f, 0.0f, Color.toFloatBits(255, 0, 0, 255),
             0.5f, -0.5f, 0.0f, Color.toFloatBits(0, 255, 0, 255),
             0.0f,  0.5f, 0.0f, Color.toFloatBits(0, 0, 255, 255) });

      mTestMesh.setIndices(new short[] { 0, 1, 2 });
    }
  }

  @Override
  public void render() {
    // clear screen (black)
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    
    // render test mesh
    mTestMesh.render(GL10.GL_TRIANGLES, 0, 3);
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
  }
}
