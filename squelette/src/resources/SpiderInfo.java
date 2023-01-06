package resources;

import java.util.Random;

import libraries.Vector2;

public class SpiderInfo {
	public static Vector2 SPIDER_SIZE = RoomInfos.TILE_SIZE.scalarMultiplication(0.6);
	public static final double SPIDER_SPEED = 0.02;
	public static final int SPIDER_LIFE = 5;
	public static final int SPIDER_DAMAGE = 1;
	
	
	/*public static int controlposition() {
		Random posit = new Random();
		double pos = posit.nextDouble();
		if(pos>0.8||pos<0.4 && pos>0.2||pos<0.8) return new Vector2(pos,pos);
		else controlposition(); 
		}*/
}
