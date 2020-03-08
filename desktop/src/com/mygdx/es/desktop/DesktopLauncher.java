package com.mygdx.es.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.es.ElementSeeker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Element Seeker";
		config.addIcon("graphics/icon.png", Files.FileType.Internal);
		new LwjglApplication(new ElementSeeker(), config);
	}
}
