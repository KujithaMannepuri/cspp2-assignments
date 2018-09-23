import java.util.*;
import java.io.*;

class bagOfWords {

	bagOfWords() {
	}
	
	public static Map removeAll(String text) {
		String[] words = text.replaceAll("[^a-zA-Z. ]","").toLowerCase().split(" ");
		Map<String, Integer> hmap = new HashMap<>();
		int freq = 0;
		for (int i = 0; i < words.length; i++) {
			if (!hmap.containsKey(words[i])) {
				hmap.put(words[i], 1);
			} else {
				hmap.put(words[i], hmap.get(words[i]) + 1);
			}
		}
		return hmap;
	}
	public static int similarity(String file1, String file2) {
		double nmrtr = 0;
		double sum1 = 0;
		double sum2 = 0;
		Map<String, Integer> hmap1 = removeAll(file1);
		Map<String, Integer> hmap2 = removeAll(file2);
		for (String ind1:hmap1.keySet()) {
			for (String ind2:hmap2.keySet()) {
				if (ind1.equals(ind2)){
					nmrtr += hmap1.get(ind1)*hmap2.get(ind2);
				}
			}
		}
		for (String ind1:hmap1.keySet()) {
			sum1 += Math.pow(hmap1.get(ind1), 2);
		}
		for (String ind2:hmap2.keySet()) {
			sum2 += Math.pow(hmap2.get(ind2), 2);
		}
		double denominator = Math.sqrt(sum1) * Math.sqrt(sum2);
		return (int)((((nmrtr / denominator) * 100D) / 100D) * 100);
	}
	public static String toString(File filename) {
		String str = "";
		try {
			Scanner sc = new Scanner(new FileReader(filename));
			StringBuilder s = new StringBuilder();
			while(sc.hasNext()) {
				s.append(sc.next());
				s.append(" ");
			}
			sc.close();
			str = s.toString();
		} catch (FileNotFoundException e) {
			System.out.println("no file");
		}
		return str;
	}
}

class Solution {
	public static void main(String[] args) {
		try {
		bagOfWords f = new bagOfWords();
		Scanner sc = new Scanner(System.in);
		File ip = new File(sc.next());
		File[] listOfFiles = ip.listFiles();
		int max = 0;
		String res1 = "";
		int length = listOfFiles.length;
		int[][] res = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					res[i][j] = 100;
				} else {
				res[i][j] = bagOfWords.similarity(bagOfWords.toString(listOfFiles[i]),bagOfWords.toString(listOfFiles[j]));
				if (max < res[i][j]) {
					max = res[i][j];
					res1 = "Maximum similarity is in between " + listOfFiles[i].getName() + " and " + listOfFiles[j].getName();
				}
			}
			}
		}
		System.out.print("      \t");
		for (int i = 0; i < length; i++) {
			System.out.print("\t" + listOfFiles[i].getName());
		}
		System.out.println();
		for (int i = 0; i < length; i++) {
			System.out.print(listOfFiles[i].getName() + "\t");
			for (int j = 0; j < length; j++) {
				System.out.print(res[i][j] + "\t\t");
			}
			System.out.println();
		}
		System.out.println(res1);

	}catch(NoSuchElementException e) {
		System.out.println("empty directory");
	}
	}
}