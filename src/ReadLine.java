
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadLine {
String[] Reads(String File,int size) throws Exception
{	
	  StringBuffer sb = new StringBuffer();
	 BufferedReader br = new BufferedReader(new FileReader(File));
	 String line1 = br.readLine();
	 String line[]=new String[size];
	 String sb1=new String();
	 while (line1 != null) {
		 
		 sb.append(line1);
		 sb.append(" ");
		 //System.out.print(sb);
        // sb.append(line1);
         //sb.append("\n"); 
         line1=br.readLine();
	 }
	 sb1=sb.toString();
	//System.out.print("\n"+"\n"+sb1);
		// line=sb.split(".");
	String s[]=new String[size];
	s=sb1.split("[\\.\\!\\?]");
	for(int i=0;i<s.length;i++)
			 System.out.print(""+s[i]+"\n");
	
     
	 return s;
}
}
