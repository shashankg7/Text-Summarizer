
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
public class Filter {
String[] Filterdoc(String doc_vec[],String stopfile,int size,int stop_size) throws IOException
{	int stop_wrdsize=0;
	int line_size=0;
	boolean equal_test=false;
	String line=new String();	
	String line2=new String();
	String filt_doc[]=new String[size];
	String stop_table[]=new String[stop_size];
	String doc_vec1[]=new String[size];
	
	BufferedReader br = new BufferedReader(new FileReader(stopfile));
	//BufferedReader br1 = new BufferedReader(new FileReader("StopWords1.txt"));
	for(int i=0;i<size;i++)
	 {
		 if(doc_vec[i]!=null)
		 {
			 line_size++;	//calculates total number of lines in doc
		 }
	 }
	int index=0;
	//for(int i=0;i<line_size;i++)
	//	System.out.print(doc_vec[i]+"\n");
	
	words Words=new words();
		 line = br.readLine();   		
	 while (line != null) {
		 stop_table[index]=line;
			line = br.readLine();
         	stop_wrdsize++;
         	index++;
           }
	 br.close();
	 /*for(int i=0;i<stop_table.length-70;i++)
	 {
		 System.out.print(stop_table[i]+"\n");
	 }*/
	 String[] line1=null;
	// line2 = br1.readLine(); //string with stop words
	 //System.out.print("stow word 1 file"+line2+"\n");
	  int compare;//variable to compare with stop words
	 /*for(int i=0;i<size;i++)
	 {
		 if(doc_vec[i]!=null)
		 {
			 line_size++;	//calculates total number of lines in doc
		 }
	 }*/
	for(int i = 0;i<line_size;i++)		
	{	
		//System.out.print(doc_vec[i]);
		line1=Words.test1(doc_vec[i]); //words from line extract
		//for(int j=0;j<line1.length;j++){
		//System.out.print(line1[j]+"\n");}
	int flag=0;
	for(int j=0;j<line1.length;j++)
		{
		//br1 = new BufferedReader(new FileReader("StopWords1.txt"));
		
			//System.out.print("stop word"+line2+"\n");
			for(int k=0;k<stop_table.length;k++)
			{
			equal_test=false;
			if(line1[j].length()==stop_table[k].length())
			{		
				//System.out.print("lenght of "+line1[j]+" is "+line1[j].length()+"\n");
				equal_test=line1[j].equals(stop_table[k]);
			}
				// compare1=line1[j+1].compareTo(" ");
				
				if(equal_test==true)
				{	
					//System.out.print("\n replacing "+stop_table[k]+"   " +"in "+line1[j]);
					doc_vec[i]=doc_vec[i].replaceAll("\\b"+line1[j]+"\\b","");
				}
				//line2=br1.readLine();
			}
		}
	//System.out.print("modified line is"+doc_vec[i]);
	}

	//for(int i=0;i<line_size;i++)
	//		System.out.print(doc_vec[i]+"\n");
	
	words Words1=new words();
	String filt_words[]=new String[100];
	filt_words=Words1.test1(doc_vec[0]);
	for(int i=0;i<size;i++)
	{
		filt_doc[i]=doc_vec[i];
	}
	//br1.close();
	return filt_doc;
	}
}
