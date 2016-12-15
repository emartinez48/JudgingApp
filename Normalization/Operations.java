import java.util.ArrayList;
import java.util.HashMap;

public class Operations {
	//Normalization methods stored here for modularity
		public static int Elementsum(double [][] Array,double rowcount)
		{
			int arraysum=0;
			for(int i=1;i<rowcount;i++)
			{
				arraysum+=Array[i][3];
			}
			return arraysum;
		}
		public static double mean(double[][] Array, double rowcount,double savedelementsum)
		{
			double mean =0;
			savedelementsum = Operations.Elementsum(Array,rowcount);
			mean=savedelementsum/rowcount;
			return mean;
		}
		public static double standard_deviation(int[][] Array,int rowcount,int savedmean, int savedelementsum)
		{
			//variable and initializations
			double thestandarddeviation = 0.0;
			int thevariance = 0;

			for(int i=1;i<rowcount;i++)
			{
				thevariance+=Math.pow((Array[i][3]-savedmean),2);
			}
			thevariance = thevariance / rowcount;
			System.out.println(thevariance);
			thestandarddeviation = Math.pow( thevariance, 0.5);
			return thestandarddeviation;

		}
		public static double meanjudge(double total,double amount)
		{
			double mean=0.0;
			mean=total/amount;
			return mean;
		}

		public static HashMap JudgesMax (HashMap<Double, ArrayList<Double>> JudgesScores,HashMap<Double,Double> JMax)
		{
			double max=-100.00;
			for(HashMap.Entry<Double, ArrayList<Double>> entry : JudgesScores.entrySet())
			{
				Double Judge = entry.getKey();
				ArrayList<Double> Score = entry.getValue();
				for(Double ascore : Score)
				{
					if(ascore>max)
					{
						max=ascore;
						//System.out.println("The max score is" + max);
					}
				}
				JMax.put(Judge,max);
				max=-100.00;
			}

			return JMax;
		}
		public static HashMap JudgesMin (HashMap<Double, ArrayList<Double>> JudgesScores,HashMap<Double,Double> JMin)
		{
			double min=100.00;
			for(HashMap.Entry<Double, ArrayList<Double>> entry : JudgesScores.entrySet())
			{
				Double Judge = entry.getKey();
				ArrayList<Double> Score = entry.getValue();
				for(Double ascore : Score)
				{
					if(ascore<min)
					{
						min=ascore;
						//System.out.println("The min score is" + min);
					}
				}
				JMin.put(Judge,min);
				min=100.00;
			}

			return JMin;
		}
		public static HashMap JudgeSD (HashMap<Double, ArrayList<Double>> JudgesScores,HashMap<Double,Double> JudgesMean,HashMap<Double,Double> JudgesSD)
		{
			for(HashMap.Entry<Double, ArrayList<Double>> entry : JudgesScores.entrySet())
			{
				double Variance=0.0;
				double amount=0.0;

				Double Judge = entry.getKey();
				ArrayList<Double> Score = entry.getValue();
				for(Double ascore : Score)
				{
					amount++;
					Variance+=Math.pow(ascore-JudgesMean.get(Judge),2);

				}
				amount--;
				if(Variance==0)
				{
					//System.out.println("We are gonna have mistakes");
				}
				if(amount!=0)
					Variance=(Variance/amount);
				else
					Variance=0;
				//System.out.println("Do we get here");
				//System.out.println("The variance is " + Variance + " Amount is " + amount);
				JudgesSD.put(Judge, Math.pow(Variance,.5));
				//System.out.println("The standard deviation is " + JudgesSD.get(Judge));
				Variance=0;
				amount=0;

			}
			return JudgesSD;
		}
		public static double[][] Normalized(HashMap<Double, ArrayList<Double>> JudgesScores,HashMap<Double,Double> JMin,HashMap<Double,Double> JMax,double [][] Scores,int i)
		{

			for(int k=0;k<i;k++)	
			{
				if(Scores[k][1]==1738)
				{
					System.out.println(Scores[k][3] +" We also want to see their judge " + Scores[k][2]);
				}

				if((JMax.get(Scores[k][2])-JMin.get(Scores[k][2]) == 0))
				{
					Scores[k][4]=Scores[k][3];
				}

				else
				{
					//System.out.println("The original score was " + Scores[k][3] + " The Judges Max Score was " + JMax.get(Scores[k][2]) + " The min score was" + JMin.get(Scores[k][2]));
					Scores[k][4]= 10+((Scores[k][3]-JMin.get(Scores[k][2]))*(40-10))/(JMax.get(Scores[k][2])-JMin.get(Scores[k][2])); //We can get 0's here as well
					//System.out.println("Normalized Score is " + Scores[k][3]);
				}
				if(Scores[k][1]==1738)
				{
					System.out.println(Scores[k][4] +" We also want to see their judge " + Scores[k][2]);
				}

			}
			return Scores;
		}
		public static HashMap AvaragedNormScore(HashMap<Double,ArrayList<Double>> NormalizedScores, HashMap<Double,Double> TotalScore)
		{
			double newmean=0.0;
			double amount=0.0;
			double total=0.0;
			for(HashMap.Entry<Double, ArrayList<Double>> entry : NormalizedScores.entrySet())
			{
				Double Student = entry.getKey();
				ArrayList<Double> Score = entry.getValue();
				for(Double ascore : Score)
				{
					amount++;
					total+=ascore;
				}
				if(amount!=0)
					total=total/amount;
				TotalScore.put(Student,total);
				total=0.0;
				amount=0.0;

			}
			TotalScore.remove(0);
			return TotalScore;
		}

		public static HashMap NFactor (HashMap<Double, ArrayList<Double>> JudgesScores,HashMap<Double,Double> JMin,HashMap<Double,Double> JMax,double [][] Scores,int i,HashMap<Double,Double> Nfactor)
		{
			double Factor = 0.0;
			for(int k=0;k<i;k++)	
			{

				if((JMax.get(Scores[k][2])-JMin.get(Scores[k][2]) == 0))
				{
					Nfactor.put(Scores[k][0],0.0);
					if(Scores[k][1]==1738)
					{
						System.out.println(Scores[k][4] +" We also want to see their judge " + Scores[k][2] + " And the N factor is " + Factor + " NO Deviation  ");
					}
				}

				else
				{
					Factor= ((Scores[k][3]-JMin.get(Scores[k][2])))/(JMax.get(Scores[k][2])-JMin.get(Scores[k][2])); //0's
					Nfactor.put(Scores[k][0],Factor);
					if(Scores[k][1]==1738)
					{
						System.out.println(Scores[k][4] +" We also want to see their judge " + Scores[k][2] + " And the N factor is " + Factor + " ");
					}
					Factor=0.0;
				}
				//System.out.println("Normalized Score is " + Scores[k][3]);


			}
			return Nfactor;
		}
		
		public static void Nadjust(HashMap<Double,Double> Nfactor,double [][] Scores,int i,HashMap<Double,Double> JudgesSD,HashMap<Double,String> IDName, HashMap<Double,String> IDCategory,HashMap<Double,String> IDMentor)
		{
			double AdjustedScore=0.0;
			for(int k=0;k<i;k++)	
			{
				//System.out.println("The normalized score is " + Scores[k][4] + " Nfactor is " + Nfactor.get(Scores[k][0]) + " The SD is " + JudgesSD.get(Scores[k][2]) );
				AdjustedScore= Scores[k][4]+(Nfactor.get(Scores[k][0])*JudgesSD.get(Scores[k][2]))+.25;
				Scores[k][4]=AdjustedScore;
				//System.out.println(Scores[k][4]);
				AdjustedScore=0.0;
			}
			Loops.PrintArray(Scores,i);
			System.out.println("We are Finished!!");
			Main.OutputCSV(Scores,i,IDName,IDCategory,IDMentor);

		}

}
