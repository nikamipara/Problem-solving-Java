package prec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dsdsd {

	/*public static void main(String[] args) throws IOException{
		 File file = new File("C:\\Users\\NikZz\\Downloads\\Compressed\\imgur_dRrDl\\a.txt");
		 String one = " = new Image()";
		 //image1.src = "914_0yitE07.gif"
	        try {
	        	PrintWriter f0 = new PrintWriter(new FileWriter("C:/Users\\NikZz\\Downloads\\Compressed\\imgur_dRrDl\\b.txt"));
	            Scanner scanner = new Scanner(file);
	            int i =1;
	            while (scanner.hasNext()) {
	                String line = scanner.next();
	                //f0.println("var image"+i+one);
	               f0.println("\""+line+"\",");
	                i++;
	                System.out.println(line);
	            }
	            scanner.close();
	            f0.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        
	}*/
	public static void main(String[] args) throws IOException{
		 /*File file = new File("C:\\Users\\NikZz\\Downloads\\Compressed\\imgur_dRrDl\\aaa.txt");
		 String one = " = new Image()";
		 //image1.src = "914_0yitE07.gif"
	        try {
	        	PrintWriter f0 = new PrintWriter(new FileWriter("C:/Users\\NikZz\\Downloads\\Compressed\\imgur_dRrDl\\bb.txt"));
	            Scanner scanner = new Scanner(file);
	            int i =1;
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                line = line.replace('"', '+');
	                //f0.println("var image"+i+one);
	               f0.println("\""+line+"\",");
	                i++;
	                System.out.println(line);
	            }
	            scanner.close();
	            f0.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        */
		String s = "<tbody><tr><td class=\"a1\"><a href=\""
				+"/subtitles/the-originals-second-season/english/1048923\"><span class=\"l r neutral-icon\">English</span><span>The.Originals.S02E10.HDTV.x264-LOL </span></a></td><td class=\"a3\"></td><td class=\"a40\">";
		String ss = "<Br>fuck</Br>";
		System.out.println(clean(s));
	}
	private static String clean(String string) {
	
		String regularExpression="<tbody><tr><td class=\"a1\"><a href=\"";
		string = string.replaceAll(regularExpression, "GOOD ");
		regularExpression="\"><span class=\"l r neutral-icon\">English</span><span>";
		string = string.replaceAll(regularExpression, " ENGLISH");
		return string;
	}
}
