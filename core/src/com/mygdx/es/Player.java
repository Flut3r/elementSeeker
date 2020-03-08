package com.mygdx.es;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;




public class Player {
	
	float posX;
	float posY;
	
	public void move(Rectangle r, float speed) {
		posX = r.x;
		posY = r.y;
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			posY += speed *Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			posX += speed *Gdx.graphics.getDeltaTime();
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.A)){
			posX -= speed *Gdx.graphics.getDeltaTime();
		}
		
		
		r.x = posX;
		r.y = posY;
	}
}
