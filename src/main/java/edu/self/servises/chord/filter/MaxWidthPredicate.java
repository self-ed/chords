package edu.self.servises.chord.filter;

import java.util.function.Predicate;

public class MaxWidthPredicate implements Predicate<Integer[]> {
	private int maxWidth;
	public MaxWidthPredicate(){
		this(4);
	}
	
	public MaxWidthPredicate(int maxWidth){
		this.maxWidth = maxWidth;
	}
	
	@Override
	public boolean test(Integer[] frets) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (Integer fret: frets){
			if (fret != null){
				if (fret < min){
					min = fret;
				}
				if (fret > max){
					max = fret;
				}
			}
		}
		return max - min < maxWidth;
	}
}
