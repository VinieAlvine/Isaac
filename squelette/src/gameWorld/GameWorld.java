package gameWorld;
import resources.ImagePaths;
import java.util.*;
import resources.TireInfo;
import resources.RoomInfos;
import gameobjects.projectile;
import gameobjects.Hero;
import libraries.StdDraw;
import resources.Controls;
import gameobjects.Spider;
public class GameWorld
{   
	private RoomSpider currentRoom;
	protected Hero hero;
	private RoomFly roomfly;
	private RoomBoss roomboss;
	private List<Room>rooms;
	//private projectile larme;
	

	// A world needs a hero
	public GameWorld(Hero hero)
	{ 
		this.hero = hero;
		//rooms=new LinkedHashSet<Room>();
		this.currentRoom = new RoomSpider (hero,3);
		this.roomfly=new RoomFly(hero,3);
		this.roomboss=new RoomBoss(hero,1);
	   
		
	}
	/*public void listrooms() {
		this.currentRoom = new RoomSpider (hero,1);
	    this.roomboss=new RoomBoss(hero,1);
	    this.roomfly=new RoomFly(hero,1);
	    rooms.add(currentRoom);
	    rooms.add(roomfly);
	    rooms.add(roomboss);
	    
	};*/

	public void processUserInput()
	{   
		processKeysForMovement();
		hero.tiredeplacement();
		
		for(int i=0;i<currentRoom.getSpiders().size();i++) {
			currentRoom.getSpiders().get(i).duration();
		//System.out.println(currentRoom.getSpiders().get(i));
			}
		if(currentRoom.getSpiders().size()==0) {
			for(int i=0;i<roomfly.getFlys().size();i++) {
				roomfly.getFlys().get(i).flyMove(hero);
			//System.out.println(currentRoom.getSpiders().get(i));
				}
		}
		if(roomfly.getFlys().size()==0) {for(int i=0;i<1;i++) {
			roomboss.getBoss().flyMove(hero);
		//System.out.println(currentRoom.getSpiders().get(i));
			}}
	}

	public boolean gameOver()
	{  
		boolean gover = false;
		if(hero.getPointlife()==0) {
			gover=true;
		}
		return gover;
	}
	

	public void updateGameObjects()
	{
		currentRoom.updateRoom();
		if(currentRoom.getSpiders().size()==0)roomfly.updateRoom();
		if(roomfly.getFlys().size()==0)	roomboss.updateRoom();
	}

	public void drawGameObjects()
	{   
		currentRoom.drawRoom();
		if(currentRoom.getSpiders().size()==0)roomfly.drawRoom();
		if(roomfly.getFlys().size()==0)roomboss.drawRoom();
		
	}

	/*
	 * Keys processing
	 */

	private void processKeysForMovement()
	{
		if (StdDraw.isKeyPressed(Controls.goUp))
		{
			hero.goUpNext();
		}
		if (StdDraw.isKeyPressed(Controls.goDown))
		{
			hero.goDownNext();
		}
		if (StdDraw.isKeyPressed(Controls.goRight))
		{
			hero.goRightNext();
		}
		if (StdDraw.isKeyPressed(Controls.goLeft))
		{
			hero.goLeftNext();
		}
		
		//projectile larme = new projectile(RoomInfos.POSITION_CENTER_OF_ROOM,TireInfo.Tire_SIZE,TireInfo.Tire_SPEED,ImagePaths.TEAR);

		
	}
	
	}
