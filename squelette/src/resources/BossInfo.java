package resources;

import libraries.Vector2;

public class BossInfo {
	public static Vector2 BOSS_SIZE = RoomInfos.TILE_SIZE.scalarMultiplication(1);
	public static final double BOSS_SPEED = 0.01/4;
	public static final int BOSS_LIFE = 8;
	public static final int BOSS_DAMAGE = 1;
}
