package gameloop;

import java.util.*;

import gameWorld.RoomSpider;
import gameWorld.GameWorld;
import gameobjects.Hero;
import gameobjects.Spider;
import gameobjects.projectile;
import libraries.StdDraw;
import libraries.Timer;
import libraries.Vector2;
import resources.DisplaySettings;
import resources.HeroInfos;
import resources.ImagePaths;
import resources.RoomInfos;
import resources.SpiderInfo;
import resources.TireInfo;

public class Main
{
	public static void main(String[] args)
	{
		// Hero, world and display initialisation.
	    projectile larme = new projectile(new Vector2(1,0.95),TireInfo.Tire_SIZE,TireInfo.Tire_SPEED,ImagePaths.TEAR);
		Hero isaac = new Hero(RoomInfos.POSITION_CENTER_OF_ROOM, HeroInfos.ISAAC_SIZE, HeroInfos.ISAAC_SPEED, ImagePaths.ISAAC,HeroInfos.ISAAC_LIFE,HeroInfos.ISAAC_DAMAGE);
		GameWorld world = new GameWorld(isaac);				
		initializeDisplay();

		// Main loop of the game
		while (world.gameOver()==false)
		{
			processNextStep(world);
		}
		
	}

	private static void processNextStep(GameWorld world)
	{
		Timer.beginTimer();
		StdDraw.clear();
		world.processUserInput();
		world.updateGameObjects();
		world.drawGameObjects();
		StdDraw.show();
		Timer.waitToMaintainConstantFPS();
	}

	private static void initializeDisplay()
	{
		// Set the window's size, in pixels.
		// It is strongly recommended to keep a square window.
		StdDraw.setCanvasSize(RoomInfos.NB_TILES * DisplaySettings.PIXEL_PER_TILE,
				RoomInfos.NB_TILES * DisplaySettings.PIXEL_PER_TILE);

		// Enables double-buffering.
		// https://en.wikipedia.org/wiki/Multiple_buffering#Double_buffering_in_computer_graphics
		StdDraw.enableDoubleBuffering();
	}
}
