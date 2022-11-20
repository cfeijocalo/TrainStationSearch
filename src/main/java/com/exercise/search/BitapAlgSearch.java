package com.exercise.search;

/**
 * 
 * @author Caio Calo
 * @since 0.0.1
 */
public class BitapAlgSearch {

	private BitapAlgSearch() {
	}

	private static long[] initializePatternMask(char[] pattern) {
		long[] patternMask = new long[Character.MAX_VALUE + 1];
		for (int i = 0; i <= Character.MAX_VALUE; ++i)
			patternMask[i] = ~0;

		for (int i = 0; i < pattern.length; ++i)
			patternMask[pattern[i]] &= ~(1L << i);
		return patternMask;
	}

	public static int search(char[] pattern, char[] text) {
		int patternLength = pattern.length;
		long[] patternMask = initializePatternMask(pattern);
		long bitArray = ~1;

		for (int i = 0; i < text.length; ++i) {
			bitArray |= patternMask[text[i]];
			bitArray <<= 1;
			if ((bitArray & (1L << patternLength)) == 0)
				return i - patternLength + 1;
		}

		return -1;
	}

}
