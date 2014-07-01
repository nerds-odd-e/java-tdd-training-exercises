package game2048;

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
import static org.mockito.Mockito.*;

import com.game2048.Game2048;
import com.game2048.Game2048.Tile;


public class Game2048Test {
	class Game2048ForTest extends Game2048 {

		private String savedFace;

		@Override
		protected int getLineHeight(Graphics2D g, String s, FontMetrics fm) {
			return 10;
		}


		private static final long serialVersionUID = 1L;

		public String getFaceDrew() {
			return savedFace;
		}
	}
	
	@Test
	public void shouldDraw2WithATileFaceThatIs2()
	{
		Game2048ForTest game = new Game2048ForTest();
		game.setNumberMode();
		Graphics2D g2 = mock(Graphics2D.class);
		game.drawTile(g2, new Tile(2), 0, 0);
		verify(g2).drawString("2", 38, 51);
	}
	
	@Test
	public void shouldDrawAwith2InModeOne()
	{
		Game2048ForTest game = new Game2048ForTest();
		game.setAZMode();
		Graphics2D g2 = mock(Graphics2D.class);
		game.drawTile(g2, new Tile(2), 0, 0);
		verify(g2).drawString("A", 35, 51);
	}
}
