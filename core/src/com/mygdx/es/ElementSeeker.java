package com.mygdx.es;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.es.Ground;



public class ElementSeeker extends ApplicationAdapter {
	Texture background;
	  Stage stage;
	SpriteBatch batch;
	Sprite backgroundSprite;
	 private Box2DDebugRenderer debugRenderer;
	 World world;
	 Player player;
	 Game game;
	
	private OrthographicCamera camera;
	
	public ElementSeeker() {
		

        Gdx.input.setInputProcessor(stage);

        stage = new Stage(new ScreenViewport());

        debugRenderer = new Box2DDebugRenderer();

        world = new World(new Vector2(0, -1000), true);



        Player player = new Player(world,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight());

        stage.addActor(player);
        stage.addActor(new Ground(world,0,Gdx.graphics.getHeight()/3,Gdx.graphics.getWidth()*2/3,Gdx.graphics.getHeight()/10));
	}
	
	@Override
	public void create () {
		Box2D.init();
	camera = new OrthographicCamera();
	stage = new Stage(new ScreenViewport());
	camera.setToOrtho(false, 800, 480);
	batch = new SpriteBatch();
	
	 
    debugRenderer = new Box2DDebugRenderer();
	 world = new World(new Vector2(0, -1000), true);
	 background = new Texture("graphics/background.png");
	 backgroundSprite =new Sprite(background);
	 

     
	}

	@Override
	public void render () {
		player.move(20);
	Gdx.gl.glClearColor(0, 0, 1, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	 camera.update();
     batch.setProjectionMatrix(camera.combined);
	batch.begin();
	backgroundSprite.draw(batch); 
	
  
batch.end();
stage.act();

stage.draw();
world.step(Gdx.graphics.getDeltaTime(), 6, 2);


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
	}
	
	
	
}
