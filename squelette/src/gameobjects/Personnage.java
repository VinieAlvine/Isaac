package gameobjects;

import java.util.ArrayList;
import java.util.List;

import libraries.StdDraw;
import libraries.Vector2;
public class Personnage {
	
		private Vector2 position;
		private Vector2 size;
		private String imagePath;
		private double speed;
		protected Vector2 direction;
		protected int startMoov;
        protected int pointlife;
        protected int damage;
        protected   List<projectile>larmes;

		public List<projectile> getLarmes() {
			return larmes;
		}

		public void setLarmes(List<projectile> larmes) {
			this.larmes = larmes;
		}

		public Personnage(Vector2 position, Vector2 size, double speed, String imagePath,int pointlife,int damage)
		{
			this.position = position;
			this.size = size;
			this.speed = speed;
			this.imagePath = imagePath;
			this.direction = new Vector2();
			this.startMoov=0;
			this.damage= damage;
			this.pointlife=pointlife;
			this.larmes= new ArrayList<projectile>();
		}

		public void updateGameObject()
		{
			move();
		}

		protected void move()
		{
			Vector2 normalizedDirection = getNormalizedDirection();
			Vector2 positionAfterMoving = getPosition().addVector(normalizedDirection);
			setPosition(positionAfterMoving);
			direction = new Vector2();
		}

		public void drawGameObject()
		{
			StdDraw.picture(getPosition().getX(), getPosition().getY(), getImagePath(), getSize().getX(), getSize().getY(),
					0);
		}

		/*
		 * Moving from key inputs. Direction vector is later normalised.
		 */
		
		
		
		public void goUpNext()
		{  if(getPosition().getY()<0.75)
			getDirection().addY(1);
		}

		public int getPointlife() {
			return pointlife;
		}

		public void setPointlife(int pointlife) {
			this.pointlife = pointlife;
		}

		public int getDamage() {
			return damage;
		}

		public void setDamage(int damage) {
			this.damage = damage;
		}

		public void goDownNext()
		{   if(getPosition().getY()>0.25)
			getDirection().addY(-1);
		}

		public void goLeftNext()
		{    if(getPosition().getX()>0.15)
			getDirection().addX(-1);
		}

		public void goRightNext()
		{   if(getPosition().getX()<0.85)
			getDirection().addX(1);
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
