import java.io.*;
import java.util.*;

class SocialNetwork {
	public static void main(String[] args) {
		Network net = new Network();
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		for(int i = 0; i < Integer.parseInt(line[1]); i++){
			String str = sc.nextLine();
			String[] lst = str.split(" is connected to ");
			net.user(lst[0], lst[1]);
		}
		while(sc.hasNext()) {
			String lst = sc.nextLine();
			String[] tokens = lst.split(" ");
			if(tokens[0].equals("getConnections")) {
				net.getConnections(tokens[1]);
			}
			if(tokens[0].equals("addConnections")) {
				net.addConnections(tokens[1],tokens[2]);
			}
			if(tokens[0].equals("CommonConnections")) {
				System.out.println(net.getCommonConnections(tokens[1], tokens[2]));
			}
			if(tokens[0].equals("Network")) {
				net.network();
			}
		}
		
	}
} 