
import java.io.*;


public class Read {					//read a text file in root mentioned by user
@SuppressWarnings("null")
String[] ReadFile(String file,int size) throws Exception
{
	int i=0;
	 BufferedReader br = new BufferedReader(new FileReader(file));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        String line1[]=new String[size];
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	            line1[i]=line;
	            	i++;
	         
	        }
	         return line1;
	    } finally {
	        br.close();
	    }

	}
}
