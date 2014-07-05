
public class Entry{
		String name;
		int count ;                            //tf in document
		int ni ;  								//tf in sentence ie kitne sentences mein aa rha h
		int prevSentence;
		Double idf;
		Double Tdf;
		//Double Tdf_sen;                        //tf-idf for each word in sentence
		public Entry()
		{
		this.name=null;
			this.count=0;
			this.ni=0;
			
		}



public Entry(String name)
		{
			this.name=name;
			this.count=1;
			this.ni=1;
			this.prevSentence=0;
			
			
		}//no of sentences in which word in recurring
	public void set_prevSentence(int i){
		this.prevSentence=i;
	}
	
	public void updateCount()
	{
		count=count+1;
	}
	public void updateNi()
	{
		ni=ni+1;
	}

	public String getName(){
		return name;
	}
	public void setName(String s){
		this.name=s;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count=count;
	}
	public void set_idf(double d){
		this.idf=d;
	}
	public void set_Tdf(double d){
		this.Tdf=d;
	}
	/*public void set_Tdf_sen(double d){
		this.Tdf_sen=d;
	}*/
	public int getNi(){
		return ni;
	}
	public double get_idf(){
		return idf;
	}
	public double get_Tdf(){
		return Tdf;
	}
	/*public double get_Tdf_sen(){
		return Tdf_sen;
	}*/
	//public String toString(){
//		return "name:"+name+"Count:"+count+"tdf:"+Tdf;
//	}

		
	}