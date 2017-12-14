package org.effectivejava.examples.chapter07.item46;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

public class NestedIterator {

	private enum Suit{
		CLUB, DIAMOND, HEART, SPADE
	}
	
	private enum Rank{
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}
	
	public static void main(String[] args) {
		Collection<Suit> suits = Arrays.asList(Suit.values());
		Collection<Rank> ranks = EnumSet.allOf(Rank.class);
		
		// throws NoSuchElementException
		for(Iterator<Suit> i = suits.iterator(); i.hasNext(); )
			for(Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
				System.out.println(i.next() + " " + j.next());

		// only print 13 repeated words: 'ACE ACE' to 'KING KING', not expected 13*13 combinations
//		for(Iterator<Rank> i = ranks.iterator(); i.hasNext(); )
//			for(Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
//				System.out.println(i.next() + " " + j.next());
	}
	
}
