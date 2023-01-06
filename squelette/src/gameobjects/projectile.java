package gameobjects;

import libraries.StdDraw;
import libraries.Vector2;
import resources.Controls;
import resources.ImagePaths;
import resources.RoomInfos;
import resources.TireInfo;


public class projectile { 
	
	private Vector2 position;
	private Vector2 size;
	private String imagePath;
	private double speed;
	private Vector2 direction;
	protected double x;
	protected double y ;


	public projectile(Vector2 position, Vector2 size, double speed, String imagePath)
	{
		this.position = position;
		this.size = size;
		this.speed = speed;
		this.imagePath = imagePath;
		this.direction = new Vector2();
		this.x=0;
		this.y=0;
	}

	public void updateGameObject()
	{
		move();
	}

	private void move()
	{
		Vector2 normalizedDirection = getNormalizedDirection();
		Vector2 positionAfterMoving = getPosition().addVector(normalizedDirection);
		setPosition(new Vector2(positionAfterMoving.getX()+x,positionAfterMoving.getY()+y));
		direction = new Vector2();
	}

	public void drawGameObject()
	{
		StdDraw.picture(getPosition().getX(), getPosition().getY(), getImagePath(), getSize().getX(), getSize().getY(),
				0);
	}
    public void tiredirection(double x ,double y) {
    	 this.x=x*21;//modifier
    	 this.y=y*21;//modifier
    }
	/*
	 * Moving from key inputs. Direction vector is later normalised.
	 */
	public void tiregoUpNext()
	{  this.x= 0;
	   this.y=0.015;
	}

	public void tiregoDownNext()
	{   this.x= 0;
	   this.y= -0.015;
	}

	public void tiregoLeftNext()
	{    this.x= -0.015;
	   this.y=0;
	}

	public void tiregoRightNext()
	{    this.x= 0.015;
	   this.y=0;
	}

	public Vector2 getNormalizedDirection()
	{
		Vector2 normalizedVector = new Vector2(direction);
		normalizedVector.euclidianNormalize(speed);
		return normalizedVector;
	}


	/*
	 * Getters and Setters
	 */
	public Vector2 getPosition()
	{
		return position;
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}

	public Vector2 getSize()
	{
		return size;
	}

	public void setSize(Vector2 size)
	{
		this.size = size;
	}

	public String getImagePath()
	{
		return imagePath;
	}

	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

	public double getSpeed()
	{
		return speed;
	}

	public void setSpeed(double speed)
	{
		this.speed = speed;
	}

	public Vector2 getDirection()
	{
		return direction;
	}

	public void setDirection(Vector2 direction)
	{
		this.direction = direction;
	}
	
	
}
	 
	  


	

