package com.mygdx.es;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;




public class Player extends Image {
	
	World world;
	 private Body body;
	 
	public Player(World aWorld, float pos_x, float pos_y) {
		super(new Texture("graphics/character.png"));
		this.setPosition(pos_x,pos_y);
		world = aWorld;
		
		
		   BodyDef bodyDef = new BodyDef();

	        bodyDef.type = BodyDef.BodyType.DynamicBody;

	        bodyDef.position.set(pos_x, pos_y);
	        body = world.createBody(bodyDef);
	        
	        PolygonShape shape = new PolygonShape();
	        shape.setAsBox(this.getWidth()/2, this.getHeight()/2);
	        
	        
	        FixtureDef fixtureDef = new FixtureDef();

	        fixtureDef.shape = shape;

	        fixtureDef.density = 5f;

	        fixtureDef.friction = 0f;

	        fixtureDef.restitution= 1f;

	        Fixture fixture = body.createFixture(fixtureDef);
	        
	        shape.dispose();

	        this.setOrigin(this.getWidth()/2,this.getHeight()/2);
	}
	
	
	
	
	 @Override

	    public void draw(Batch batch, float parentAlpha) {

	        super.draw(batch, parentAlpha);

	      



	    }

	  @Override

	    public void act(float delta) {

	        super.act(delta);

	        this.setRotation(body.getAngle()*  MathUtils.radiansToDegrees);



	        this.setPosition(body.getPosition().x-this.getWidth()/2,body.getPosition().y-this.getHeight()/2);

	        


	    }

	

	
	float posX;
	float posY;
	
	public void move(float speed) {
		posX = this.getX();
		posY = this.getY();
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			posY += speed *Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			posX += speed *Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			posX -= speed *Gdx.graphics.getDeltaTime();
		}
		
		
		this.setPosition(posX, posY); 
		
	}
	
	
	
}
