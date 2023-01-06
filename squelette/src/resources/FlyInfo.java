package resources;

import libraries.Vector2;

public class FlyInfo {
	public static Vector2 Fly_SIZE = RoomInfos.TILE_SIZE.scalarMultiplication(0.7);
	public static final double Fly_SPEED = 0.01/8;
	public static final int FLY_LIFE = 5;
	public static final int FLY_DAMAGE = 1;
}
