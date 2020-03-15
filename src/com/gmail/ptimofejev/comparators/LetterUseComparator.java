package com.gmail.ptimofejev.comparators;

import java.util.Comparator;

import com.gmail.ptimofejev.Letter;

public class LetterUseComparator implements Comparator<Letter> {

	@Override
	public int compare(Letter o1, Letter o2) {
		if (o1 != null && o2 == null) {
			return 1;
		}
		if (o1 == null && o2 != null) {
			return -1;
		}
		if (o1 == null && o2 == null) {
			return 0;
		}
		return o1.getUses() - o2.getUses();
	}

}
