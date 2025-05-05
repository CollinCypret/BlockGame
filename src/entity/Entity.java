package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int x, y;
	public int speed;
	
	public BufferedImage or1, or2, or3, or4;
	public BufferedImage block;
	public String orientation;
	
	public Rectangle solidArea;
	public boolean collisionOn = false;
}
