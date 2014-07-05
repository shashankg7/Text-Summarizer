

class Candidate implements Comparable<Candidate>{
		String chromosome;
		double Fit;
		double centrality;
		double position;
		double length;
		double titleSimilarity;
		double NumData;
		int count;
		
		public Candidate(){
			this.chromosome=" ";
			
		}
		public Candidate(String s){
			this.chromosome=s;
		}
		public String getName(){
			return chromosome;
		}
		public void setName(String s){
			this.chromosome=s;
		}
		public void setFitness(double fit){
			this.Fit=fit;
		}
		public double getFitness(){
			return Fit;
		}
		public void setCount(int c){
			this.count=c;
		}
		public int getCount(){
			return count;
		}
		public void setCentrality(double centrality){
			this.centrality=centrality;
		}
		public double getCentrality(){
			return centrality;
		}
		public void setTitleSimilarity(double titleSimilarity){
			this.titleSimilarity=titleSimilarity;
		}
		public double getTitleSimilarity(){
			return titleSimilarity;
		}
		public void setNumData(double numData){
			this.NumData=numData;
		}
		public double getNumData(){
			return NumData;
		}
		public void setPosition(double pos){
			this.position=pos;
		}
		public double getPosition(){
			return position;
		}
		public void setlength(double length){
			this.length=length;
		}
		public double getlength(){
			return length;
		}

			
		public String toString(){
			return "Chromosome:"+chromosome+"Fitness:"+Fit+"Length:"+length+"Position:"+position+"Title Resemblance:"+titleSimilarity+"Num Data:"+NumData;
		}
		@Override
		
		public int compareTo(Candidate o) {
			if(GA.flag==1)
				return  (int) ((int)this.Fit-o.Fit);
		else
			if(GA.flag==0)
				return  (int) ((int)this.count-o.count);
			
		return 0;
		}
		
		}
