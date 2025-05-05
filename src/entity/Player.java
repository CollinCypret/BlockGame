package entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		solidArea = new Rectangle(0, 0, gp.blockTileSize, gp.blockTileSize);
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		x = 350;
		y = 200;
		speed = 2;
		orientation = "down";
	}
	public void getPlayerImage() {
		try {
			
			or1 = ImageIO.read(getClass().getResourceAsStream("/blocks/Block3.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {

//		if(keyH.upPressed == true) {
//			orientation = "up";
//		}else 
		if(keyH.downPressed == true) {
			orientation = "down";
		}
		else if(keyH.leftPressed == true) {
			orientation = "left";
		}
		else if(keyH.rightPressed == true) {
			orientation = "right";
		}
		else {
			orientation = "down";
			//return;
		}
		
		//Check Tile Collision
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		//If collision false, player can move
		if (collisionOn == false) {
			switch(orientation) {
			case "up":
				y -= speed;
				break;
			case "down":
				y += speed;
				break;
			case "left":
				x -= speed;
				y += speed;
				break;
			case "right":
				x += speed;
				y += speed;
				break;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		
		BufferedImage image = null;
		switch(orientation) {
		case "up":
			image = or1;
			break;
		case "down":
			image = or1;
			break;
		case "right":
			image = or1;
			break;
		case "left":
			image = or1;
			break;
		}
		
		g2.drawImage(image, x, y, gp.blockTileSize, gp.blockTileSize, null);
	}
}