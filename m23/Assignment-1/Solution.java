import java.util.*;
import java.io.*;
class bagOfWords {
	public HashMap text(File file) {
		HashMap<String,Integer> hmap = new <String,Integer>HashMap();
		try{
			BufferedReader files = new BufferedReader(new FileReader(file));
			String s = files.readLine();
			while (s != null) {
				String[] text = s.split(" ");
				String word = "";
				for (int i = 0; i < text.length; i++) {
					word = text[i].replaceAll("[.,*%&!@#$():?-]","").trim().toLowerCase();
					if (word.length() > 0) {
						if (hmap.containsKey(word)) {
							hmap.put(word,hmap.get(word)+1);
						} else {
							hmap.put(word,1);
						}
					}
				}
				s = files.readLine();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return hmap;
	}
	public double plagiarism(HashMap<String,Integer> hmap1, HashMap<String,Integer> hmap2) {
		double freq1 = 0;
		double freq2 = 0;
		double similarity;
		int dotPrdct = 0;

		for(int i : hmap1.values()) {
			freq1 = freq1 + Math.pow(i, 2);
		}
		freq1 = Math.sqrt(freq1);

		for(int i : hmap2.values()) {
			freq2 = freq2 + Math.pow(i, 2);
		}
		freq2 = Math.sqrt(freq2);
		
		for (String i : hmap1.keySet()) {
			if (hmap2.containsKey(i)) {
				dotPrdct = dotPrdct + hmap1.get(i) * hmap2.get(i);
			}
		}
		similarity = dotPrdct/(freq1 * freq2);
		return similarity;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String folder;
		try{
			folder = sc.nextLine();
		}catch(Exception e){
			System.out.println("empty directory");
			return;
		}
		File dir = new File(folder);
		File[] fileList = dir.listFiles();
		HashMap[] hmapArr = new HashMap[fileList.length];
		bagOfWords obj = new bagOfWords();
		int temp = 0;
		long[][] result = new long[fileList.length][fileList.length];
		
		for(File print:fileList) {
			hmapArr[temp] = obj.text(print);
			temp++;
		}
		for(int i = 0;i<fileList.length;i++){
			for(int j = 0; j< fileList.length;j++){
				result[i][j] = Math.round(obj.plagiarism(hmapArr[i],hmapArr[j])*100);
			}
		}
		
		for(int i = 0; i < fileList.length;i++) {
			for(int j = 0; j < fileList.length; j++) {
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
	}
}