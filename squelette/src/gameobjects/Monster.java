package gameobjects;

import libraries.Vector2;

public class Monster extends Personnage  {
   public Monster(Vector2 position, Vector2 size, double speed, String imagePath,int pointlife ,int damage){
	   super(position, size,speed, imagePath,pointlife, damage);
	}
   
}
