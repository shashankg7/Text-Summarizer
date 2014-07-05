
import java.util.HashMap;



public class Cosine_similarity{

	static Double sim_matrix[][];							//similarity matrix
	static String temp[][];									//array of sentences ie temp of Td_idf class
	static Double Sen_weight[];								//weight of each sentence to be used in denominator
	static Double Thresh_Matrix[][];
	Double Threshold=0.02;
	Integer adjacency[];
	public static LexRank lex;
	
	Cosine_similarity(int matrix_size,String tempSen[][])	//method for initializing similarity matrix
	{
		sim_matrix=new Double[matrix_size][matrix_size];
		temp=tempSen;
		Sen_weight=new Double[matrix_size];
		Thresh_Matrix=new Double[matrix_size][matrix_size];
		adjacency=new Integer[matrix_size];
		for(int i=0;i<adjacency.length;i++)
			adjacency[i]=0;
	}
	
	void setSenWeight(HashMap <String,Entry> map)				//method for calculating weight of each sentence
	{
		Entry e1;
		
		for(int i=0;i<temp.length;i++)
		{
			Sen_weight[i]=0.0;
			for(int j=0;j<temp[i].length;j++)
			{
				if(temp[i][j].equals(null) || temp[i][j].equals(""))
					continue;
				e1=(Entry) map.get((String)(temp[i][j]));
				Sen_weight[i]+=Math.pow(getFqInSen(temp[i][j],i)*e1.get_idf(),2);
				//Sen_weight[i]+=Math.pow(e1.get_idf(),2);
			}
			System.out.println("sentence weight "+i+":"+Sen_weight[i]);
		}
	}
	
	int getFqInSen(String word,int Sno)   		//method to get the frequency of a word in a sentence.
	{
		int count=0;
		for(int p=0;p<temp[Sno].length;p++)
			if(temp[Sno][p].equals(word))
				count++;
		return count;
	}
	
	boolean inSen2(String word,int n)				//method to find common words
	{
		for(int k=0;k<temp[n].length;k++)
			if(temp[n][k].equals(word))
				return true;
		return false;
	}
	
	void setSimMatrix(HashMap <String,Entry> map)
	{
		
		Entry e1;
			
		for(int p=0;p<sim_matrix.length;p++)
		{
			for(int q=p;q<sim_matrix.length;q++)
			{
				HashMap <String,Entry> commonWords= new HashMap <String,Entry>(); //list of common words in 2 sentences
				Double sumN=0.0;				//Numerator value
				int SenFq1=0;					//frequency of word in sentence 1
				int SenFq2=0;					//frequency of word in sentence 2
				if(p==q)
					{
					sim_matrix[p][q]=sim_matrix[q][p]=1.0;
					Thresh_Matrix[p][q]=Thresh_Matrix[q][p]=1.0;
					adjacency[p]++;
					}
				else{
				for(int r=0;r<temp[p].length;r++){
					if(temp[p][r].equals(null) || temp[p][r].equals(""))     //check null words
						continue;
					if(inSen2(temp[p][r],q))				//check if a word is present in both sentences p and q
					{
					e1=(Entry) map.get((String)(temp[p][r]));
					if(commonWords.containsKey(temp[p][r])==false)
					{
						commonWords.put(temp[p][r], e1);
						SenFq1=getFqInSen(temp[p][r],p);
						SenFq2=getFqInSen(temp[p][r],q);
						//System.out.println("word:"+e1.getName()+" "+e1.getCount()+" "+e1.getNi()+" "+e1.get_Tdf());
						System.out.println("common word("+p+","+q+"):"+e1.getName());
						sumN+=SenFq1*e1.get_idf()*SenFq2*e1.get_idf();
					}
					else continue;
					}
					
				}
				sim_matrix[p][q]=sim_matrix[q][p]=sumN/(Math.sqrt(Sen_weight[p])*Math.sqrt(Sen_weight[q]));
				if(sim_matrix[p][q]>Threshold)
				{
					Thresh_Matrix[p][q]=Thresh_Matrix[q][p]=1.0;
					adjacency[p]++;
				}
				else{
					Thresh_Matrix[p][q]=Thresh_Matrix[q][p]=0.0;
					}
				}
			}
		}
		showMatrix();
		lex=new LexRank(Thresh_Matrix,adjacency);
		
		}
		void showMatrix()
		{
			for(int p=0;p<sim_matrix.length;p++,System.out.println())
				for(int q=0;q<sim_matrix.length;q++)
				{
					System.out.print((sim_matrix[p][q])+"\t\t\t");
				}
					
		}

}
