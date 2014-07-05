
public class LexRank {
	static Double T_Matrix[][];
	static Integer adjacency[];
	Double L[][];
	static public double Rank[];
	LexRank(Double[][] t,Integer[] a)
	{
		
		T_Matrix=t;
		adjacency=a;
		Rank=new double[T_Matrix.length];
		normalize();
		Double e=0.02;
		L=powerMethod(T_Matrix,e);
		showRank();
	}
	
	void normalize()
	{
		for(int i=0;i<T_Matrix.length;i++)
			for(int j=0;j<T_Matrix.length;j++)
				T_Matrix[i][j]=T_Matrix[i][j]/(Double.parseDouble(adjacency[i]+""));
	}
	
	Double[][] powerMethod(Double T_Matrix[][],Double e)
	{
		Double p0[][]=new Double[T_Matrix.length][1];
		Double p1[][]=new Double[T_Matrix.length][1];
		Double diff[][]=new Double[T_Matrix.length][1];
		for(int i=0;i<T_Matrix.length;i++)
		{
			p0[i][0]=1.0/Double.parseDouble(T_Matrix.length+"");
			p1[i][0]=0.0;
		}

		Double del=0.05;
		while(del>e)
		{
			del=0.0;
			for(int i=0;i<T_Matrix.length;i++)
				for(int j=0;j<1;j++)
					for(int k=0;k<T_Matrix.length;k++)
				{
					p1[i][j]+=T_Matrix[k][i]*p0[i][j];
				}
			for(int i=0;i<T_Matrix.length;i++)
			{	
				diff[i][0]=p1[i][0]-p0[i][0];
				del+=diff[i][0];
				
			}	
			//			del=determinant(diff);
			p0=p1;
		
		}
		
		return p1;
		
	}
	
	
	public Double determinant(Double[][] matrix){ //method sig. takes a matrix (two dimensional array), returns determinant.
		Double sum=0.0; 
	    int s;
	    if(matrix.length==1){  //bottom case of recursion. size 1 matrix determinant is itself.
	      return(matrix[0][0]);
	    }
	    for(int i=0;i<matrix.length;i++){ //finds determinant using row-by-row expansion
	    	Double[][]smaller= new Double[matrix.length-1][matrix.length-1]; //creates smaller matrix- values not in same row, column
	      for(int a=1;a<matrix.length;a++){
	        for(int b=0;b<matrix.length;b++){
	          if(b<i){
	            smaller[a-1][b]=matrix[a][b];
	          }
	          else if(b>i){
	            smaller[a-1][b-1]=matrix[a][b];
	          }
	        }
	      }
	      if(i%2==0){ //sign changes based on i
	        s=1;
	      }
	      else{
	        s=-1;
	      }
	      sum+=s*matrix[0][i]*(determinant(smaller)); //recursive step: determinant of larger determined by smaller.
	    }
	    return(sum); //returns determinant value. once stack is finished, returns final determinant.
	  }

	
	void showRank()
	{
		System.out.println("Lex Ranks:");
		for(int a=0;a<L.length;a++)
			{
				System.out.println(a+1+":"+L[a][0]);
				Rank[a]=L[a][0];
			}
		
	}
	}
	
	
