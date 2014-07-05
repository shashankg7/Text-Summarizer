import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GA {

	static String title;
	public static String sentences[];
	static double SenFitness[];
	int pop_size;
	int SummaryLength;
	int NumOfSentences;
	double[] F_Weights=new double[5];  //1.cenntrality 2.title resemblance 3.numerical data 4.sentence position 5.sentence length
	int crossoverProb;
	double mut_per;
	Candidate[] Initial;
	Candidate[] childArr;
	Candidate[] selectPool;
	Candidate[] next_can;
	//Candidate[] temp;
	Random rand=new Random();
	
	int p_per;
	int mut;
	public static int flag;
	int iter_no;
	static float start_time;
	
	public GA(String doc[],int size)
	{
		sentences=doc;
		NumOfSentences=size;
		Fitness();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title:");
		title="iraq";//sc.nextLine();
		System.out.println("Enter number of sentences in summary:");
		SummaryLength=5;//sc.nextInt();
		System.out.println("Enter population size:");
		pop_size=12;//sc.nextInt();
		System.out.println("Enter centrality weight:");
		F_Weights[0]=1;//sc.nextInt();
		System.out.println("Enter title resemblance weight:");
		F_Weights[1]=1;//sc.nextInt();
		System.out.println("Enter num data weight:");
		F_Weights[2]=1;//sc.nextInt();
		System.out.println("Enter position weight:");
		F_Weights[3]=1;//sc.nextInt();
		System.out.println("Enter length weight:");
		F_Weights[4]=1;//sc.nextInt();
		System.out.println("Enter crossover probability:");
		crossoverProb=(int)((double)((sc.nextInt()*pop_size)/100));
		Initial=new Candidate[pop_size];
		generateInitialPop();
		evaluateFitness(Initial);
		Crossover c=new Crossover(Initial,pop_size-crossoverProb,NumOfSentences);
		childArr=c.children;
		System.out.println("Enter mutation percent:");
		mut=(int)((double)((sc.nextInt()*childArr.length)/100));
		Mutation m =new Mutation();
		m.mutate(childArr,mut);
		System.out.println("Enter parent percent:");
		p_per=(int)((double)((sc.nextInt()*pop_size)/100));
		generateNextCan();
		System.out.println("Enter no. of generation:");
		iter_no=sc.nextInt();
		Iteration();
	}
	
	void generateInitialPop()
	{
		for(int n=0;n<pop_size;n++)
		{
			int arr[]=new int[NumOfSentences];
			for(int i=0;i<SummaryLength;)
			{
				int sen=rand.nextInt(NumOfSentences);
				if(arr[sen]==1)
					continue;
				else
				{
					arr[sen]=1;
					i++;
				}
				
			}
			String name="";
			for(int i=0;i<NumOfSentences;i++)
				name+=arr[i]+"";
			Candidate c=new Candidate(name);
			Initial[n]=c;
		}
		System.out.println("Initial population:");
		for(int i=0;i<pop_size;i++)
			System.out.println(Initial[i].getName());
	}
	
	void Fitness()
	{
		Td_idf t=new Td_idf(sentences,NumOfSentences);
		SenFitness=LexRank.Rank;
	}
	
	void Iteration()
	{
		for(int i=0;i<iter_no;i++)
		{
			evaluateFitness(next_can);
			Crossover c=new Crossover(next_can,pop_size-crossoverProb,NumOfSentences);
			childArr=c.children;
			Mutation m =new Mutation();
			m.mutate(childArr,mut);
			generateNextCan();			
			System.out.println("Generation "+i+":");
			flag=1;
			Arrays.sort(next_can,Collections.reverseOrder());
			for(int j=0;j<next_can.length;j++)
				System.out.println("name:"+next_can[j].getName()+"fit:"+next_can[j].getFitness());
		}
	}
	
	
	
	
	void evaluateFitness(Candidate[] can)
	{
		int pos;
		double fit;
		
		title_sim t=new title_sim();
		double titleSim[]=t.resem(sentences,title,NumOfSentences);
		
		Numerical num =new Numerical();
		double numData[]=num.num(sentences);
		for(int i=0;i<can.length;i++)
		{
			fit=0.0;
			pos=0;
			for(int j=0;j<SummaryLength;j++)
			{
				pos=can[i].getName().indexOf("1", pos+1);
				if(pos!=-1)
					can[i].setFitness(((F_Weights[0]*SenFitness[pos]+F_Weights[1]*titleSim[pos]+F_Weights[2]*numData[pos]+F_Weights[3]*(pos/10)+F_Weights[4]*(sentences[pos].length()/100))/(F_Weights[0]+F_Weights[1]+F_Weights[2]+F_Weights[3]+F_Weights[4]))*100);
				else
					break;
			}
			System.out.println("candidate "+i+" fitness:"+can[i].getFitness());
		}
	}
	
	void generateNextCan()
	{
		flag=0;
		Arrays.sort(Initial,Collections.reverseOrder());
		int i=0;
		next_can=new Candidate[Initial.length];
		selectPool=new Candidate[pop_size-p_per+childArr.length];
		for(i=0;i<Initial.length;i++)
		{
			next_can[i]=new Candidate("");
			if(i<p_per)
				next_can[i]=Initial[i];
			else
				selectPool[i-p_per]=Initial[i];
		}
		for(i=0;i<childArr.length;i++)
			selectPool[i+(pop_size-p_per)]=childArr[i];
		evaluateFitness(selectPool);
		Roulette r=new Roulette();
		r.RW(selectPool,pop_size-p_per);
		for(int j=p_per;j<Initial.length;j++)
			next_can[j]=selectPool[j-p_per];
		
	}
	
	
	
	public static void main(String args[])
	{
		//GA g=new GA(d,15);
	}
	
}
