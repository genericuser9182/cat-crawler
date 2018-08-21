import java.io.*;
import java.util.*;
import java.net.*;	// URL
public class WebCrawler {
	public static void main(String[] args) throws Exception {
		ArrayList<String> images = new ArrayList<>();
	//	URL url = new URL(args[0]);
        String start = "https://www.pexels.com/search/cat";
        String date = java.time.LocalDate.now().toString();
        String seed = "&seed=" + date + "+17%3A23%3A08++0000&format=js";
		URL url = new URL(start);
		Scanner sc = new Scanner(url.openStream());
		String line;
        int count = 0;
        for(int i = 0; i < 10; i++) {
            url = new URL(start+"?page=" + i + seed);
            sc = new Scanner(url.openStream());
            while(sc.hasNext()) {
                line = sc.nextLine();
                while(line.contains("jpg") || line.contains("jpeg") || line.contains("gif")) {
                    String substring = line.substring(line.indexOf("http"), line.indexOf("\"", line.indexOf("http")));
                    line = line.replace(substring, "");
                    images.add(substring);
                    count++;
                }
            }
        }
		PrintWriter out = new PrintWriter(new FileWriter("cat_pictures.txt"));
		for(String s: images) 
			out.println(s);
		out.close();
        
        System.out.println(count);
	}
}
