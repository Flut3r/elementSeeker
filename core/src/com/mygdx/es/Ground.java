package com.mygdx.es;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Ground extends Image {
	   private Body body;

	    private World world;
	    
	    public Ground(World w, float xPos, float yPos, float width, float height) {
	    	super(new Texture("graphics/ground.png"));
	    	this.setSize(width,height);

	        this.setOrigin(this.getWidth()/2,this.getHeight()/2);

	       

	        this.setPosition(xPos,yPos);

	        

	        BodyDef groundBodyDef = new BodyDef();
	        groundBodyDef.position.set(new Vector2(xPos, yPos));
	        body = world.createBody(groundBodyDef);
	    	
	        PolygonShape groundBox = new PolygonShape();
	        groundBox.setAsBox(this.getWidth()/2, this.getHeight()/2);

	        body.setTransform(this.getX()+this.getWidth()/2,this.getY()+this.getHeight()/2, 0);
	        body.createFixture(groundBox, 0.0f);
	        groundBox.dispose();
	    	world = w;
	    }
	    
	    @Override
	    public void act(float delta) {
	    	super.act(delta);
	    }
	    
	    @Override
	    public void draw(Batch batch, float parentAlpha) {
	    	super.draw(batch, parentAlpha);
	    }
}
