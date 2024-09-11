import java.io.*;
import java.util.*;

public class b20291{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String extension[] = new String[n];
		ArrayList<String> strArray = new ArrayList<String>();
		int txt=0;
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(int i=0;i<n;i++) {
			int num=0;
			String str = br.readLine();
			extension[i]=str.split("\\.")[1];
			hm.put(extension[i], (hm.getOrDefault(extension[i], 0)+1));
			if(hm.get(extension[i])==1) {
				strArray.add(extension[i]);
			}
		}
		Collections.sort(strArray);
		for(int i=0;i<strArray.size();i++) {
			System.out.println(strArray.get(i)+" "+hm.get(strArray.get(i)));
		}
		
	}
}