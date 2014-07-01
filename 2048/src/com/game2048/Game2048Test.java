package com.game2048;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.game2048.Game2048.Tile;

public class Game2048Test {

	private int counter;

	@Test
	public void testNumericMode() {
		Game2048 game2048 = new Game2048(false);
		assertTrue(StringUtils.isNumeric(game2048.getDisplayString(1024)));
	}

	@Test
	public void testAlphaMode() {
		Game2048 game2048 = new Game2048(true);
		assertTrue(StringUtils.isAlpha(game2048.getDisplayString(1024)));
	}
	
	@Test
	public void isTilePaintedWithNumber() {
		counter = 0;
		Game2048 game2048 = new Game2048(false){

			@Override
			protected void drawTile(Graphics g2, Tile tile, int x, int y) {
				counter++;
			}
		};
		
		MyGraphics graph = new MyGraphics();
		game2048.paint(graph );
		assertEquals(16, counter);
	}
}
