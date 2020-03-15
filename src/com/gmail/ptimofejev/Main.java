package com.gmail.ptimofejev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.gmail.ptimofejev.comparators.LetterUseComparator;

public class Main {

	public static void main(String[] args) {
		File sourceText = new File("sourceText.txt");
		char[] text = readFileToString(sourceText).toCharArray();
		System.out.println(Arrays.toString(text));
		List<Letter> letterStat = calculateLetterUse(text);
		Collections.sort(letterStat, new LetterUseComparator().reversed());
		int totalLetters = getTotalUses(letterStat);
		System.out.println(totalLetters);
		printRelativeResult(letterStat, totalLetters);
	}

	public static String readFileToString(File input) {
		StringBuilder sb1 = new StringBuilder();
		String nextline = null;
		try (BufferedReader br1 = new BufferedReader(new FileReader(input))) {
			while ((nextline = br1.readLine()) != null) {
				sb1.append(nextline);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb1.toString();
	}

	public static List<Letter> calculateLetterUse(char[] source) {
		List<Letter> letters = new ArrayList<Letter>();
		for (int i = 65; i <= 90; i++) {
			letters.add(new Letter(i, 0));
		}
		for (char ch : source) {
			int code = (int) Character.toUpperCase(ch);
			if (code >= 65 && code <= 90) {
				for (Letter let : letters) {
					if (code == let.getSymbolCode()) {
						let.setUses(let.getUses() + 1);
						break;
					}
				}
			}
		}
		return letters;
	}

	public static int getTotalUses(List<Letter> letters) {
		int total = 0;
		for (Letter let : letters) {
			total += let.getUses();
		}
		return total;
	}

	public static void printRelativeResult(List<Letter> letters, int total) {
		for (Letter let : letters) {
			double relative = (double) let.getUses() * 100 / total;
			System.out.print("Letter " + (char) let.getSymbolCode() + ": use - ");
			System.out.printf("%.2f", relative);
			System.out.println("%;");
		}
	}

}
