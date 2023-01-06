package gameobjects;

import libraries.StdDraw;
import libraries.Vector2;
import resources.Controls;

import java.util.*;

public class Spider  extends Personnage{
	
	
	public static Vector2 positions;

	private int direct ;
	private int duration;
	private int startMoov;
	private boolean moovOk;
	
	public  Spider ( Vector2 positions,Vector2 size, double speed, String imagePath,int poinlife,int damage)
   {  
		super(positions, size,speed, imagePath,poinlife,damage);
		this.startMoov= (int)System.nanoTime();// temps de dépard
		this.direct = new Random().nextInt(4) ;
		this.moovOk=true;
	}
	public void duration() {
		int durationMoov=((int)System.nanoTime()-this.startMoov)/1000000000;
		if(moovOk) {
			this.direct = new Random().nextInt(4);
		}
		if(durationMoov>0 && durationMoov<1.2) {
			// les spiders bougent
		
		spiderMove();
		this.moovOk=false;
		}
		if(durationMoov>1.5 ) {
			this.startMoov= (int)System.nanoTime();
			this.moovOk=true;}
		
		return;
		}

	private void spiderMove()
	{
		//System.out.println(this.direct);
		if (direct == 0)
		{
			this.goUpNext();
		}
		if (direct  ==1)
		{
			this.goDownNext();
		}
		if (direct  ==2)
		{
			this.goRightNext();
		}
		if (direct ==3)
		{
			this.goLeftNext();
		}
	}
	// getter and setter
	public static Vector2 getPositions() {
		return positions;
	}


	public static void setPositions(Vector2 positions) {
		Spider.positions = positions;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getStartMoov() {
		return startMoov;
	}
	public void setStartMoov(int startMoov) {
		this.startMoov = startMoov;
	}
	public boolean isMoovOk() {
		return moovOk;
	}
	public void setMoovOk(boolean moovOk) {
		this.moovOk = moovOk;
	}

	

	


	

	
}
