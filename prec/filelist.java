package prec;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class filelist {
	public static PrintWriter pw;
public static void main(String... ss) throws IOException{
	Scanner s = new Scanner(System.in);
	File template = new File("D:\\DropBox\\experiments"+File.separator+"template.html");
	System.out.println("enter the path to dir");
	String dir = ss[0];
	if(ss[0].isEmpty()){
	 dir = s.nextLine();}
	//creater new file
	File newFile = new File(dir,"myfile.html");
	pw = new PrintWriter(newFile);
	Scanner templatescanner = new Scanner(template);
	while(templatescanner.hasNextLine()){
		pw.println(templatescanner.nextLine());
	}
	templatescanner.close();
	File D = new File(dir);
	if(D.isDirectory()){
		scan(D);
	}
	pw.println("]");
	pw.println("</script>");
	pw.close();
	s.close();
	
	System.out.println(newFile.getAbsolutePath());
	// open the template
	// add predefinded lines to it
	// call the functuin
	
	/*File D = new File(dir);
	if(D.isDirectory()){
		scan(D);
	}*/
	// add closing lines
	// close all the pointeers and print the saved path of html.
	
}
public static void scan(File f){
	if(f.isDirectory()){
		File[] files = f.listFiles();
		for(File ff:files)scan(ff);
	}
	else{
		if(f.exists()&& f.getAbsolutePath().contains(".gif")){
			p("'"+f.getAbsolutePath().replace("\\","/")+"',\n");
		}
	}
}
public static void p(String s){
	pw.println(s);
}
}
