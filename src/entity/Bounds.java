package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Bounds extends Entity {
	GamePanel gp;
	
	
	public Bounds(GamePanel gp, int x, int y) {
		this.gp = gp;
		
		getBoundsImage();
//		setDefaultValues();
	}
//	public void setDefaultValues() {
//	}

	
	public void getBoundsImage() {
		try {
			
			block = ImageIO.read(getClass().getResourceAsStream("/bounds/Block.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2, int x, int y) {
//		g2.setColor(Color.white);
//		g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		
		BufferedImage image = null;
		image = block;
		g2.drawImage(image, x, y, gp.blockTileSize, gp.blockTileSize, null);
	}
	

}

