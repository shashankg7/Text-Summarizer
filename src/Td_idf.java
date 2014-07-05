
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Td_idf extends Cosine_similarity{
	
		public Td_idf(String doc[],int size)
		{ 
		super(size,temp);
		String st[]=new String[size];
		HashMap <String,Entry> map= new HashMap <String,Entry>();
		int k=0;
		/*st[0]="Iraqi Vice President 5756 Taha Yassin Ramadan announced today, Sunday,that Iraq refuses to back down from its decision to stop cooperating with disarmament inspectors before its demands are met.";
		st[1]="Iraqi Vice president Taha 5 Yassin Ramadan announced today, Thursday,that Iraq rejects cooperating with the United Nations except on the issue of lifting the blockade imposed upon it since the year 1990.";
		st[2]="Ramadan 635632 told reporters in Baghdad that ”6764 Iraq cannot deal positively with whoever represents the Security Council unless there was a clear stance on the issue of lifting the blockade off of it.";
		st[3]="Baghdad had decided late last October to completely cease cooperating with the inspectors of the United Nations Special Commission(UNSCOM), in charge of disarming Iraq’s weapons, and whose work became very limited since the fifth of August, and announced it will not resume its cooperation with the Commission even if it were subjected to a military operation.";
		st[4]="The Russian Foreign Minister,64783647 Igor Ivanov, warned today, Wednesday against using force against Iraq, which will destroy, according to him, seven years of difficult diplomatic work and will complicate the regional situation in the area.";
		st[5]="Ivanov contended that carrying out air strikes against Iraq, who refuses to cooperate with the United Nations inspectors, “will end the tremendous work achieved by the international group during the past seven years and will complicate the situation in the region.”";
		st[6]="Nevertheless, 3784 Ivanov stressed that Baghdad must resume working with the Special Commission in charge of disarming the Iraqi weapons of mass destruction (UNSCOM).";
		st[7]="The Special Represe 54 ntative of the United Nations Secretary-General in Baghdad, Prakash Shah, announced today, Wednesday, after meeting with the Iraqi Deputy Prime Minister Tariq Aziz, that Iraq refuses to back down from its decision to cut off cooperation with the disarmament inspectors.";
		st[8]="British Prime Minister Tony Blair said today,3564 Sunday, that the crisis between the international community and Iraq “did not end” and that Britain is still “ready, prepared, and able to strike Iraq.”";
		st[9]="In a gathering with the press 8763 held at the Prime Minister’s office,Blair contended that the crisis with Iraq “will not end until Iraq has absolutely and unconditionally respected its commitments” towardsthe United Nations.";
		st[10]="A spokesman for Tony Blair had indicated that the British Prime 675 Minister gave permission to British Air Force Tornado planes stationedin Kuwait to join the aerial bombardment against Iraq.";
		
		
		/*st[0]="summly! this is a very good application of summly.";
		st[1]="this application of summly is interesting and is useful";
		st[2]="i am loving it";
		*/
		for(int i=0;i<doc.length;i++)
		{
			st[i]=doc[i];
		}
		Entry e,e1;
		String temp[][]=new String[size][];
		
		try
		{
		
		for(int i=0;i<st.length;i++){
			
			Pattern pat =Pattern.compile("[ ,.!()@~+-]");
			
			temp[i]=pat.split(st[i]);
			
			for(int j=0;j<temp[i].length;j++)
			{
				if(temp[i][j].contains("“")==true || temp[i][j].contains("”")==true)
					{temp[i][j]=temp[i][j].replaceAll("“","");
					temp[i][j]=temp[i][j].replaceAll("”","");}
				
				

				if(temp[i][j].isEmpty())
					continue;
		
				if(map.containsKey(temp[i][j])==false)
				{
					 e = new Entry(temp[i][j]);
					 e.set_prevSentence(i);
					 map.put(temp[i][j], e);
				}
				else{
					e1 = map.get(temp[i][j]);
                    if((map.containsKey(temp[i][j]) & (e1.prevSentence==i) )){
						(e1).updateCount();
					}
				    if((map.containsKey(temp[i][j]) & (e1.prevSentence!=i) )){
						(e1).updateCount();
						(e1).updateNi();
						e1.set_prevSentence(i);
					}
				}
			}
		}
		
		Set set=map.keySet();
		Iterator iter =set.iterator();
		
		while(iter.hasNext()){
			
			String s1= (String)(iter.next());  
			e1=map.get(s1);
			if(e1.equals(null) || e1.getName().equals(" "))
				continue;
			Double idf=(Math.log10(st.length/ e1.getNi()));
			e1.set_idf(idf);
			Double d=e1.getCount()*idf;
			e1.set_Tdf(d);
			
			System.out.println("next token:"+e1.getName()+" "+e1.getCount()+" "+e1.getNi()+" "+e1.get_Tdf()+" "+e1.get_idf());

		}
		Cosine_similarity cs=new Cosine_similarity(size,temp);
		cs.setSenWeight(map);
		cs.setSimMatrix(map);
		}
		
		catch (Exception ie) {
			ie.printStackTrace();
		}
	}
}
		
		
	
	