import java.util.Random;


public class Crossover {

	Random rand=new Random();
	public static Candidate children[];
	Crossover(Candidate[] can,int childNum,int sen)
	{
		
		
		children=new Candidate[childNum];
		
		sen=sen/2;
		for(int i=0;i<childNum;i++)
		{
			children[i]=new Candidate();
			int n=rand.nextInt(can.length);
			Candidate c=can[n];
			String per=c.getName().substring(sen);
			System.out.print("p:"+c.getName());
			String child=permutation(per);
			children[i].setName((can[n].getName().substring(0,sen))+child);
			System.out.println("c:"+children[i].getName());
		}
	}
	
	String permutation(String st)
	{
		int count=0;
		int pos=0;
		char parent[]=st.toCharArray();
		for(int i=0;i<st.length();i++)
			if(parent[i]=='1')
				count++;
		
		int arr[]=new int[st.length()];
		for(int i=0;i<count;)
		{
			pos=rand.nextInt(arr.length);
			if(arr[pos]==1)
				continue;
			arr[pos]=1;
			i++;
		}
		st="";
		for(int i=0;i<arr.length;i++)
			st+=arr[i];
		return st;
	}
	
	
}
