import java.util.Random;


public class Mutation {

	Candidate[] mutate(Candidate[] childArr,int mut)
	{
		char arr[];
		int n;
		Random rand=new Random();
		for(int i=0;i<mut;i++)
		{
			n=rand.nextInt(childArr.length);
			Candidate c=childArr[n];
			int p1=rand.nextInt(childArr[0].getName().length());
			if(c.getName().charAt(p1)=='1')
				{
					arr=c.getName().toCharArray();
					arr[p1]='0';
					int p2=rand.nextInt(childArr[0].getName().length());
					if(c.getName().charAt(p2)=='0' && p1!=p2)
						arr[p2]='1';
					
				}
			else
			{
				arr=c.getName().toCharArray();
				arr[p1]='1';
				int p2=rand.nextInt(childArr[0].getName().length());
				if(c.getName().charAt(p2)=='1' && p1!=p2)
					arr[p2]='0';
			}
			String mutated="";
			for(int j=0;j<arr.length;j++)
				mutated+=arr[j]+"";
			childArr[n].setName(mutated);
			System.out.println("c:"+childArr[n].getName()+"");
		}
		
		
		
		return childArr;
	}
}
