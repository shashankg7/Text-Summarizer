
	import java.io.File;
	import java.io.IOException;


	public class GASummly {

		
		public static void main(String[] args) throws Exception {
			int stop_size;
			stop_count s=new stop_count();
			stop_size=s.ReadFile("C:/Users/COMP1/Desktop/summly project/Stop.txt");
			Read read=new Read();
			ReadLine readline=new ReadLine();
			//String Files[]=new String[20];
			String Files1[]=new String[20];
			Files1=readline.Reads("C:/Users/COMP1/Desktop/summly project/abcnum.txt",11);//sentences vector
			for(int i=0;i<Files1.length;i++)
			{
				Files1[i]=Files1[i].toLowerCase();
			}
			
		
			for(int i=0;i<Files1.length;i++)
				System.out.print(Files1[i]+"\n");
			//System.out.print("starting flad"+Files[10]);
			Filter filter=new Filter();
			String Filt_doc[]=new String[20];
			Filt_doc=filter.Filterdoc(Files1,"C:/Users/COMP1/Desktop/summly project/Stop.txt",11,stop_size-1 );
			//Filter1 Filter=new Filter1();
			//Filter.filter(Filt_doc, Files);
			for(int i=0;i<Filt_doc.length;i++)
			{
				Filt_doc[i]=Filt_doc[i].toLowerCase();
			}
			for(int i=0;i<Filt_doc.length;i++)
			{
				System.out.print(Filt_doc[i]+" \n");
			}
			ReadLine readline1=new ReadLine();
			GA g=new GA(Filt_doc,Filt_doc.length);
			//Td_idf idf=new Td_idf(Filt_doc,Filt_doc.length);


		}

	}

