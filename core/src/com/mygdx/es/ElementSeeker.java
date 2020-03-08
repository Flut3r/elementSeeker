package com.mygdx.es;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.es.Player;

public class ElementSeeker extends ApplicationAdapter {
	
	
	SpriteBatch batch;
	Texture player_sprite;
	private Rectangle player;
	Texture background;
	World world;
	
	
	private OrthographicCamera camera;
	   
	
	@Override
	public void create () {
		 world = new World(new Vector2(0, -10), true); 
		Box2D.init();
			camera = new OrthographicCamera();
		   camera.setToOrtho(false, 800, 480);
		   
		   player_sprite = new Texture(Gdx.files.internal("graphics/character.png"));
		
		   player = new Rectangle();
		   player.x = 800 / 2 - 64 / 2;
		   player.y = 20;
		   player.width = 128;
		   player.height = 128;
		   batch = new SpriteBatch();
		  
		   
		
		
		
		
	}

	@Override
	public void render () {
		Player p = new Player();
		 world.step(1/60f, 6, 2);
		
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
			batch.setProjectionMatrix(camera.combined);
		   batch.begin();
		   batch.draw(player_sprite, player.x, player.y);
		   batch.end();
		
		p.move(player, 200);
		
	
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player_sprite.dispose();
	}
}
