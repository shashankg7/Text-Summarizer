import java.util.Arrays;
import java.util.Collections;



public class Roulette {
	public Candidate[] RW(Candidate[] selectPool,int num)
	{
		double sum=0.0;
		for(int l=0;l<selectPool.length;l++){
				sum+=selectPool[l].getFitness();
		}
		double[] cf=new double[selectPool.length];
		cf[0]=selectPool[1].getFitness()/sum;
	
		for(int i=1;i<selectPool.length-1;i++)
		{
			cf[i]=cf[i-1]+selectPool[i+1].getFitness()/sum;
		}
		for(int i=0;i<cf.length;i++)
		{
			double n;
			do{
				n= Math.random();
			}while(n>sum);
			for(int j=0;j<cf.length;j++)
			{
				if(cf[j]>=n){
					int t=(selectPool[j+1].getCount()+1);
					selectPool[j+1].setCount(t);
					break;
				}	
			}
		}
		GA.flag=1;
		Candidate[] c=new Candidate[num];
		Arrays.sort(selectPool,Collections.reverseOrder());
		for(int k=0;k<num;k++)
			c[k]=selectPool[k];
		
		return c;
		
	}
}
