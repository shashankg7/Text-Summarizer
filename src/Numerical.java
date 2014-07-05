import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
public class Numerical {
	
	public double[] score;
	
	/*public Numerical()
	{
		
		try{
		String [] st = new String[6] ;
		st[0]=" In June 2012, the ABS progressively released results from the 2011 Census,[3] with additional releases due in 2013.";
		st[1]="R&D Higher Education survey, conducted biennially by the ABS since 1994; in 1990 and 1992 it was collected by Department of Employment";
		st[2]=" The Indus Valley Civilisation, which spread and flourished in the northwestern part of the Indian subcontinent from c. 3300 to 1300 BCE in present-day Pakistan and northwest India, was the first major civilisation in South Asia.";
		st[3]="The Mughal dynasty ruled most of the Indian subcontinent by 1600; it went into a slow decline after 1707";
         num(st);
		}
		catch(Exception e)
		{
			System.out.println();
		}
         
	}*/
	
	double[] num(String[] st)
	{ score= new double[st.length];
	String num="[0-9]+";
			for(int i=0;i<st.length;i++){
			double numCount=0;
			int j=0;

            Pattern pat =Pattern.compile("[ .,:;!()@~+]");
			
			String temp[]=pat.split(st[i]);
			int senLen=temp.length;
			while( j<temp.length){
				
				if(temp[j]==null){
					j++;
					continue;
					
				}
				if(temp[j].matches(num)){
					numCount++;
					j++;
					
				}
				else
					j++;
				
			}
			System.out.println(numCount+"    "+senLen);
			score[i]=(numCount/senLen)*100;
			//System.out.println("sentence"+" "+i+" "+score[i]);
		
			
		}
			for(int i=0;i<score.length;i++){
				System.out.println("sentence"+" "+i+" "+score[i]);
			}
			return score;
	}


}
