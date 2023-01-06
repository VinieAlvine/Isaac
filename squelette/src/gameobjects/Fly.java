package gameobjects;

import java.util.Random;

import libraries.Vector2;
import resources.ImagePaths;
import resources.TireInfo;

public class Fly extends Personnage {
	
	public static Vector2 positions;

	private int direct ;
	private int duration;
	private int startMoov;
	private boolean moovOk;
	protected double x;
	protected double  y;
	
	public  Fly ( Vector2 positions,Vector2 size, double speed, String imagePath,int lifepoint,int damage)
	{  
		super(positions, size,speed, imagePath,lifepoint,damage);
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
		
		//flyMove();
		this.moovOk=false;
		}
		if(durationMoov>1.5 ) {
			this.startMoov= (int)System.nanoTime();
			this.moovOk=true;}
		
		return;
		}

	public void flyMove(Hero hero) {
		// calcul de la distance entre hero et fly 
		this.x=(hero.getPosition().getX()-this.getPosition().getX())*this.getSpeed();
		this.y=(hero.getPosition().getY()-this.getPosition().getY())*this.getSpeed();
		int durationMoov=((int)System.nanoTime()-this.startMoov)/1000000000;
		if(durationMoov>1.2) {
			 projectile larme = new projectile(this.getPosition(),TireInfo.Tire_SIZE,TireInfo.Tire_SPEED,ImagePaths.TEAR);
			 larme.tiredirection(this.x, this.y);
			 this.larmes.add(larme);
			 this.startMoov=(int)System.nanoTime();
		}
		
	}
	protected void move()
	{
		Vector2 normalizedDirection = getNormalizedDirection();
		Vector2 positionAfterMoving = getPosition().addVector(normalizedDirection);
		setPosition(new Vector2(positionAfterMoving.getX()+x,positionAfterMoving.getY()+y));
		direction = new Vector2();
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
