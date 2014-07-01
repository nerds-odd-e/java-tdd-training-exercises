package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import com.game2048.Game2048;

class myGraphic2D extends myGraphic2D1 {

	private String str;
	private int coordX;
	private int coordY;

	@Override
	public void drawString(String str, int x, int y) {
		this.str = str;
		this.coordX = x;
		this.coordY = y;
	}
	public String getStr() {
		return str;
	}

	public int getCoordX() {
		return coordX;
	}

	public int getCoordY() {
		return coordY;
	}
}

public class AZModeUnitTest {
	Game2048 game2048 = new Game2048();

	
	private myGraphic2D graphics2d;
	
	@Test
	public void test() {
		assertEquals(1, 1);
	}
	
	
	@Test
	public void Get2AsA() {
		String drawCharacter = game2048.GetCharacterToDraw(2);
		assertEquals("A", drawCharacter);
	}
	
	@Test
	public void Get4AsB() {
		String drawCharacter = game2048.GetCharacterToDraw(4);
		assertEquals("B", drawCharacter);
	}
	
	@Test
	public void ModeSelectionTest() {
		game2048.setMode("azMode");
		assertEquals("azMode", game2048.getMode());
	}

	@Test
	public void draw2AtTile00(){
		graphics2d = new myGraphic2D();
		
		Game2048 game2048 = new Game2048(){
			@Override
			public int getStringWidth(String s, Font font) {
				return 10;
			}
			
			@Override
			public int getStringHeight(Graphics2D g, String s, Font font) {
				return -10;
			}
		};

		game2048.drawTileValue(graphics2d, 2, 0, 0);
		assertEquals(graphics2d.getStr(), "2");
	}
	
	@Test
	public void drawAAtTile00InNormalMode(){
		graphics2d = new myGraphic2D();
		
		Game2048 game2048 = new Game2048(){
			@Override
			public int getStringWidth(String s, Font font) {
				return 10;
			}
			
			@Override
			public int getStringHeight(Graphics2D g, String s, Font font) {
				return -10;
			}
		};
		game2048.setMode("azMode");
		game2048.drawTileValue(graphics2d, 2, 0, 0);
		assertEquals(graphics2d.getStr(), "A");
	}

	
	@Test
	public void drawBAtTile00InNormalMode(){
		graphics2d = new myGraphic2D();
		
		Game2048 game2048 = new Game2048(){
			@Override
			public int getStringWidth(String s, Font font) {
				return 10;
			}
			
			@Override
			public int getStringHeight(Graphics2D g, String s, Font font) {
				return -10;
			}
		};
		game2048.setMode("azMode");
		game2048.drawTileValue(graphics2d, 4, 0, 0);
		assertEquals(graphics2d.getStr(), "B");
	}

}
