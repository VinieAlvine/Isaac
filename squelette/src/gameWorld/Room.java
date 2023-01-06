package gameWorld;

import java.util.*;
import gameobjects.projectile;
import gameobjects.Hero;
import gameobjects.Personnage;
import gameobjects.Spider;
import gameobjects.Equipement;
import libraries.Physics;
import libraries.StdDraw;
import libraries.Vector2;
import resources.ImagePaths;
import resources.RoomInfos;
import resources.TireInfo;
import resources.EquimentInfos;

public class Room {   
	private double nbreMonsters;
	protected Hero hero;
	protected int time1;
	protected int time2;
	protected List<Equipement>hearts;
	protected List<Equipement>obstacles;
	protected List<Equipement> doors;
	
	//private projectile larme;
	
	


	public Room(Hero hero)
	{
		this.hero = hero;
		this.time1 = 0;
		this.time2 = 0;
	    this.hearts=new ArrayList<Equipement>();
	    this.obstacles=new ArrayList<Equipement>();
	    this.doors=new ArrayList<Equipement>();
		//this.larme=larme;
	    addHeart();
		//this.nbreMonsters = nbreMonsters;
	}
     public void addHeart() {
    	 hearts.add(new Equipement(new Vector2(0.17, 0.87),EquimentInfos.SIZE, ImagePaths.HEART_HUD));
    	 hearts.add(new Equipement(new Vector2(0.21, 0.87),EquimentInfos.SIZE, ImagePaths.HEART_HUD));
    	 hearts.add(new Equipement(new Vector2(0.25, 0.87),EquimentInfos.SIZE, ImagePaths.HEART_HUD));
    	// (new Vector2(0.17, 0.8),EquimentInfos.SIZE, ImagePaths.HALF_HEART_HUD));
    	 obstacles.add(new Equipement(new Vector2(0.25, 0.6),EquimentInfos.ROCK_SIZE , ImagePaths.ROCK));
    	 obstacles.add(new Equipement(new Vector2(0.7, 0.5),EquimentInfos.ROCK_SIZE , ImagePaths.ROCK));
    	 obstacles.add(new Equipement(new Vector2(0.7, 0.3),EquimentInfos.ROCK_SIZE , ImagePaths.ROCK));
    	 // portes
    	 doors.add(new Equipement(new Vector2(0.50, 0.85),EquimentInfos.DOOR_SIZE , ImagePaths.OPENED_DOOR));
    	// doors.add(new Equipement(new Vector2(0.50, 0.2),EquimentInfos.DOOR_SIZE , ImagePaths.OPENED_DOOR));
    	// doors.add(new Equipement(new Vector2(0.25, 0.6),EquimentInfos.DOOR_SIZE , ImagePaths.OPENED_DOOR));
    	// doors.add(new Equipement(new Vector2(0.25, 0.6),EquimentInfos.DOOR_SIZE , ImagePaths.OPENED_DOOR));
     }

	/*
	 * Make every entity that compose a room process one step
	 */
	public void updateRoom()
	{
		makeHeroPlay();
	}


	protected void makeHeroPlay()
	{
		hero.updateGameObject();
		if(hero.getLarmes().size()!=0) {
			for(projectile lar :hero.getLarmes()) {
				lar.updateGameObject();
			}
			}
		
		// a utiliser pour la mouche
		if(hero.getLarmes().size()!=0) {
			for(int i=0;i< hero.getLarmes().size();i++) {
				if(hero.getLarmes().get(i).getPosition().getX()>0.86||hero.getLarmes().get(i).getPosition().getX()<0.14||hero.getLarmes().get(i).getPosition().getY()>0.8||hero.getLarmes().get(i).getPosition().getY()<0.2)
					hero.getLarmes().remove(i);
			}
			//Collision monstre larme
		}
		
		
	}
	public void CollisionTirHero(Object object1, Object object2, Object object3) {
		if(Physics.rectangleCollision(((projectile) object1).getPosition(), ((projectile) object1).getSize(), ((Personnage) object2).getPosition(), ((Personnage) object2).getSize())) {
			//temps a modier
			if(((int)System.nanoTime()-this.time1)>1) {
			if(((Personnage) object2).getPointlife()>0) {
				((Personnage) object2).setPointlife(((Personnage) object2).getPointlife()-((Personnage)object3).getDamage());
				this.time1 = (int)System.nanoTime();
				
			}
			System.out.println(((Personnage) object2).getPointlife());
			
			}
			
		};
	}
	
	
	// COLLISION FLY LARME AND ISACC
	public void CollisionTirHeroFLY(Object object1, Object object2, Object object3) {
		if(Physics.rectangleCollision(((projectile) object1).getPosition(), ((projectile) object1).getSize(), ((Personnage) object2).getPosition(), ((Personnage) object2).getSize())) {
			//temps a modier
			if(((int)System.nanoTime()-this.time1)/1000000000>1.5) {
			if(((Personnage) object2).getPointlife()>0) {
				((Personnage) object2).setPointlife(((Personnage) object2).getPointlife()-((Personnage)object3).getDamage());
				this.time1 = (int)System.nanoTime();
				
			}
			System.out.println(((Personnage) object2).getPointlife());
			
			}
			
		};
	}
	
	
	public void CollisionMonstre(Object object1, Object object2) {
		if(Physics.rectangleCollision(((Personnage) object1).getPosition(), ((Personnage) object1).getSize(), ((Personnage) object2).getPosition(), ((Personnage) object2).getSize())) {
			if(((int)System.nanoTime()-this.time2)/1000000000>0.1) {
			if(((Personnage) object1).getPointlife()>0) {
				((Personnage) object1).setPointlife(((Personnage) object1).getPointlife()-((Personnage)object2).getDamage());
				this.time2 = (int)System.nanoTime();
			}
			System.out.println(((Personnage) object1).getPointlife());
			
		}
		
		};
	}

	/*
	 * Drawing
	 */
	public void drawRoom()
	{
		// For every tile, set background color.
		StdDraw.setPenColor(StdDraw.BLUE);
		for (int i = 0; i < RoomInfos.NB_TILES; i++)
		{
			for (int j = 0; j < RoomInfos.NB_TILES; j++)
			{
				Vector2 position = positionFromTileIndex(i, j);
				StdDraw.filledRectangle(position.getX(), position.getY(), RoomInfos.HALF_TILE_SIZE.getX(),
						RoomInfos.HALF_TILE_SIZE.getY());
			}
		}
		if(hero.getPointlife()!=0) {
		StdDraw.picture(RoomInfos.POSITION_CENTER_OF_ROOM.getX(),RoomInfos.POSITION_CENTER_OF_ROOM.getY(),ImagePaths.MAP,RoomInfos.SIZE.getX(),RoomInfos.SIZE.getY());
		
		if(hero.getPointlife()==6)for(Equipement heart :hearts) {
			heart.drawGameObject();
			
		}
		for(Equipement heart :hearts) {
			heart.drawGameObject();
			
		}
		for(Equipement rock :obstacles) {
			rock.drawGameObject();
			
		}
		for(Equipement dorr :doors) {
			dorr.drawGameObject();
			
		}
		if(hero.getPointlife()==5) {
			hearts.set(0,new Equipement(new Vector2(0.17, 0.8),EquimentInfos.SIZE, ImagePaths.HALF_HEART_HUD));
			for(Equipement heart :hearts) {
				heart.drawGameObject();
				
			}
		}
		if(hero.getPointlife()==4) {
			hearts.set(0,new Equipement(new Vector2(0.17, 0.8),EquimentInfos.SIZE, ImagePaths.EMPTY_HEART_HUD));
			for(Equipement heart :hearts) {
				heart.drawGameObject();
				
			}
		}
		if(hero.getPointlife()==3) {
			hearts.set(1,new Equipement(new Vector2(0.21, 0.8),EquimentInfos.SIZE, ImagePaths.HALF_HEART_HUD));
			for(Equipement heart :hearts) {
				heart.drawGameObject();
				
			}
		}
		if(hero.getPointlife()==2) {
			hearts.set(1,new Equipement(new Vector2(0.21, 0.8),EquimentInfos.SIZE, ImagePaths.EMPTY_HEART_HUD));
			for(Equipement heart :hearts) {
				heart.drawGameObject();
				
			}
		}
        
		if(hero.getPointlife()==1) {
			hearts.set(2,new Equipement(new Vector2(0.25, 0.8),EquimentInfos.SIZE, ImagePaths.HALF_HEART_HUD));
			for(Equipement heart :hearts) {
				heart.drawGameObject();
				
			}
		}
		if(hero.getPointlife()==0) {
			hearts.set(2,new Equipement(new Vector2(25, 0.8),EquimentInfos.SIZE, ImagePaths.EMPTY_HEART_HUD));
			for(Equipement heart :hearts) {
				heart.drawGameObject();
				
			}
		}
		
		hero.drawGameObject();
		for(projectile lar :hero.getLarmes()) {
			lar.drawGameObject();
			
		}}
		
		else StdDraw.picture(RoomInfos.POSITION_CENTER_OF_ROOM.getX(),RoomInfos.POSITION_CENTER_OF_ROOM.getY(),ImagePaths.LOSE_SCREEN,RoomInfos.SIZE.getX(),RoomInfos.SIZE.getY());
		
		
		
	}
	
	/**
	 * Convert a tile index to a 0-1 position.
	 * 
	 * @param indexX
	 * @param indexY
	 * @return
	 */
	private static Vector2 positionFromTileIndex(int indexX, int indexY)
	{
		return new Vector2(indexX * RoomInfos.TILE_WIDTH + RoomInfos.HALF_TILE_SIZE.getX(),
				indexY * RoomInfos.TILE_HEIGHT + RoomInfos.HALF_TILE_SIZE.getY());
	}


	


	public Hero getHero() {
		return hero;
	}


	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	
}
