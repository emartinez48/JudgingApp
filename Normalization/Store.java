import java.util.ArrayList;
import java.util.HashMap;

public class Store {

	public static HashMap JudgeMean (HashMap<Double, ArrayList<Double>> JudgesScores,HashMap<Double,Double> JudgesMean)
	{
		double newmean=0.0;
		double amount=0.0;
		double total=0.0;
		for(HashMap.Entry<Double, ArrayList<Double>> entry : JudgesScores.entrySet())
		{
			Double Judge = entry.getKey();
			ArrayList<Double> Score = entry.getValue();
			for(Double ascore : Score)
			{
				amount++;
				total+=ascore;
			}
			newmean=Operations.meanjudge(total,amount);
			//System.out.println("The mean is " + newmean);
			JudgesMean.put(Judge,newmean);
			newmean=0.0;
			amount=0.0;
			total=0.0;
		}

		return JudgesMean;
	}
	public static HashMap ScoreID(HashMap<Double, Double> ScoreID,double [][] Array,int rowcount)
	{ 
		for(int j=0;j<rowcount;j++)
			ScoreID.put(Array[j][1],Array[j][3]); 
		return ScoreID;
	}
	public static HashMap Jscores(HashMap<Double, ArrayList<Double>> JudgesScores,double [][] Array,int rowcount)
	{ 
		for(int j=0;j<rowcount;j++)
			JudgesScores.put(Array[j][2],new ArrayList<Double>()); // We want to create an array list for all of the judges and store their scores

		for(int i=0;i<rowcount;i++)
		{       
			if(Array[i][2]!=0 || Array[i][3]!=0)
				JudgesScores.get(Array[i][2]).add(Array[i][3]);  //We want to store the scores here in their respective places
		}
		JudgesScores.remove(0);
		//System.out.println(JudgesScores);
		return JudgesScores;
	}
	
	public static HashMap NormalizedScores(double [][]Array, int rowcount,HashMap<Double,ArrayList<Double>> AddingNormalized)
	{
		{ 
			for(int j=0;j<rowcount;j++)
				AddingNormalized.put(Array[j][1],new ArrayList<Double>()); 

			for(int i=0;i<rowcount;i++)
			{       
				if(Array[i][1]!=0 || Array[i][4]!=0)
					AddingNormalized.get(Array[i][1]).add(Array[i][4]);  //We want to store the scores here in their respective places
			}

			//System.out.println(JudgesScores);
			return AddingNormalized;
		}
	}
	
	public static HashMap NameID(String[][] Information,int filecounter,HashMap<Double, String> IDname)
	{ 
		double Converter=0.0;
		for(int j=1;j<filecounter;j++)
		{
			Converter = Double.parseDouble(Information[j][0]);
			IDname.put(Converter,Information[j][3]); 
		}
		return IDname;
	}
	
	public static HashMap MentorID(String[][] Information,int filecounter,HashMap<Double, String> IDMentor)
	{ 
		double Converter=0.0;
		for(int j=1;j<filecounter;j++)
		{
			Converter=Double.parseDouble(Information[j][0]);
			IDMentor.put(Converter,Information[j][4]); 
		}
		return IDMentor;
	}
	
	public static HashMap CategoryID(String[][] Information,int filecounter,HashMap<Double, String> IDCategory)
	{ 
		double Converter=0.0;
		for(int j=1;j<filecounter;j++)
		{
			Converter=Double.parseDouble(Information[j][0]);
			Information[j][5]=(Information[j][5]).replace(","," and ");
			IDCategory.put(Converter,Information[j][5]); 
		}
		return IDCategory;
	}


}
