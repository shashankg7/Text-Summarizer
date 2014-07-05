
import java.io.BufferedReader;
import java.io.FileReader;


public class stop_count {
	@SuppressWarnings("finally")
	int ReadFile(String file) throws Exception
	{
		int i=0;
		int stop_count=1;
		 BufferedReader br = new BufferedReader(new FileReader(file));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        //String line1[]=new String[size];
		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		          //  line1[i]=line;
		            	i++;
		         stop_count++;
		        }
		        // return line1;
		    } finally {
		        br.close();
		        //System.out.print(stop_count+"\n \n");
		        return stop_count;
		    }

		}
}
