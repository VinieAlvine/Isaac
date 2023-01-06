package gameobjects;

import java.time.Duration;

import libraries.StdDraw;
import libraries.Vector2;
import resources.Controls;
import resources.ImagePaths;
import resources.SpiderInfo;
import resources.TireInfo;
import resources.RoomInfos;

import java.util.*;
public class Hero extends Personnage
{    
         private projectile larme;
         

	public Hero(Vector2 position, Vector2 size, double speed, String imagePath,int pointlife,int damage)
	{
		super(position, size,speed, imagePath,pointlife, damage);
		this.larme=larme;
			
	}
	
	public void tiredeplacement() {
		
		 if (StdDraw.isKeyPressed(Controls.shoUp))
		 {   if(((int)System.nanoTime()-this.startMoov)/100000000>1) {
			 projectile larme = new projectile(this.getPosition(),TireInfo.Tire_SIZE,TireInfo.Tire_SPEED,ImagePaths.TEAR);
		     larme.tiregoUpNext();
		     this.larmes.add(larme);
		     this.startMoov=(int)System.nanoTime();
		 }
			 
			
		}
		if (StdDraw.isKeyPressed(Controls.shoDown))
		{    if(((int)System.nanoTime()-this.startMoov)/100000000>1) {
			 projectile larme = new projectile(this.getPosition(),TireInfo.Tire_SIZE,TireInfo.Tire_SPEED,ImagePaths.TEAR);
			 larme.tiregoDownNext();
			 larmes.add(larme);
			 this.startMoov=(int)System.nanoTime();
			 }
			
		}
		if (StdDraw.isKeyPressed(Controls.shRight))
		{   if(((int)System.nanoTime()-this.startMoov)/100000000>1) {
			 projectile larme = new projectile(this.getPosition(),TireInfo.Tire_SIZE,TireInfo.Tire_SPEED,ImagePaths.TEAR);
			 larme.tiregoRightNext();
			 larmes.add(larme);
			 this.startMoov=(int)System.nanoTime();}
			
		}
		if (StdDraw.isKeyPressed(Controls.shLeft))
		{   if(((int)System.nanoTime()-this.startMoov)/100000000>1) {
			projectile larme = new projectile(this.getPosition(),TireInfo.Tire_SIZE,TireInfo.Tire_SPEED,ImagePaths.TEAR);
		     larme.tiregoLeftNext();
		     larmes.add(larme);
		     this.startMoov=(int)System.nanoTime();
		     }
		   
		}

	}

	public projectile getLarme() {
		return larme;
	}

	public void setLarme(projectile larme) {
		this.larme = larme;
	}

	public List<projectile> getLarmes() {
		return larmes;
	}

	public void setLarmes(List<projectile> larmes) {
		this.larmes = larmes;
	}
	
	
	
	
	
}
