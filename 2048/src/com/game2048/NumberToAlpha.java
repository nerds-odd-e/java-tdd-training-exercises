package com.game2048;

import java.util.HashMap;
import java.util.Map;

public class NumberToAlpha {
	  @SuppressWarnings("serial")
	  public char getMapNumberToAlpha(int num) {
		  if (num == 0) {
			  return ' ';
		  }
	  	  Map <Integer, Character> numAlpha = new HashMap<Integer, Character>();
	  	  for (int i = 2, offset = 0; i < 4096; i*=2, offset++) {
	  		  numAlpha.put(i, (char) ('A' + offset)); 
	  	  }
	  	  return numAlpha.get(num).charValue();
	    }
}
