
public class title_sim {

	public double[] resem(String sentence[],String title,int size)
	{
		double resemblence[]=new double[size];
		String words[]=null;
		String twords[]=title.split(" ");
		for(int i=0;i<size;i++)
		{	
			words=sentence[i].split(" ");
			for(int k=0;k<twords.length;k++)
			{
			for(int j=0;j<words.length;j++)
			{
				if(words[j].contains(twords[k]))
				{
					resemblence[i]++;
				}
			}
			}
		}
		for(int i=0;i<resemblence.length;i++)
			System.out.println(i+"::"+resemblence[i]);
		return resemblence;
		
	}
}
