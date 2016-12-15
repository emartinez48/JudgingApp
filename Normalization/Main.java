

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;


public class Main 
{


	public static void main(String[] args) throws IOException 
	{

		String csvFilename = "/Users/eduardomartinez/Desktop/export_2016.08.06.csv"; 
		CSVReader csvReader;
		csvReader = new CSVReader(new FileReader(csvFilename));
		//Instanciate Variables
		double [][] Scores = new double [400][5];
		int i =0; 
		String[] row = null;
		int rowtracker=0;
		double MaxScale=40;
		double MinScale=10;
		//Loop through the file till there is nothing
		
		
		while((row = csvReader.readNext()) != null) 
		{                        //ID            PID               JID               Score
			//System.out.println(row[0]+ " # " + row[1]+ " # " + row[2]+ " #  " + row[13]);
			if(i!=0)// Since we are not printing the first spot we adjust everything one space to right
			{
				Scores[i-1][0]= Double.parseDouble(row[0]);  
				Scores[i-1][1]= Double.parseDouble(row[1]);
				Scores[i-1][2]= Double.parseDouble(row[2]);
				Scores[i-1][3]= Double.parseDouble(row[13]);
				Scores[i-1][4]=0;
			}
			i++;
		}
		csvReader.close();
		String File = "/Users/eduardomartinez/Desktop/Poster_Summer.csv";
		csvReader = new CSVReader(new FileReader(File));
		int filecounter=0;
		String[][] Information =new String [400][10];
		//Loop through the file till there is nothing
		while((row = csvReader.readNext()) != null) 
		{                       
			if(row!=null)
			{
				//System.out.println(row[0]+ " # " + row[1]+ " # " + row[2]+ " # " + row[3] + " # " + row[4] + " # " + row[6]);

				Information[filecounter][0]=row[0];
				Information[filecounter][1]=row[1];
				Information[filecounter][2]=row[2];
				Information[filecounter][3]=row[3];
				Information[filecounter][4]=row[4];
				Information[filecounter][5]=row[5];
			}
			//System.out.println(Information[filecounter][0]+ " # " + Information[filecounter][1]+ " # " + Information[filecounter][2]+ " # " + Information[filecounter][3] + " # " + Information[filecounter][4] + " # " + Information[filecounter][5]);
			filecounter++;
		}
		csvReader.close();
		
		
		Store.NameID(Information,filecounter,Objects.IDName); // Have
		Store.MentorID(Information,filecounter,Objects.IDMentor); //Have
		Store.CategoryID(Information,filecounter,Objects.IDCategory); //Have
		Objects.savedelementsum = Operations.Elementsum(Scores,i);
		Objects.savedmean= Operations.mean(Scores,i,Objects.savedelementsum);
		Store.Jscores(Objects.JudgesScores,Scores,i);
		Store.ScoreID(Objects.ScoreID,Scores,i);
		Store.JudgeMean(Objects.JudgesScores,Objects.JudgesMean);
		Operations.JudgeSD(Objects.JudgesScores,Objects.JudgesMean,Objects.JudgesSD);
		Operations.JudgesMax(Objects.JudgesScores,Objects.JMax);
		Operations.JudgesMin(Objects.JudgesScores,Objects.JMin);
		Operations.Normalized(Objects.JudgesScores,Objects.JMin,Objects.JMax,Scores,i);
		Store.ScoreID(Objects.ScoreID,Scores,i);
		Store.NormalizedScores(Scores,i,Objects.NormalizedMap);
		Operations.NFactor(Objects.JudgesScores,Objects.JMin,Objects.JMax,Scores,i,Objects.Nfactor);
		Operations.Nadjust(Objects.Nfactor,Scores,i,Objects.JudgesSD,Objects.IDName,Objects.IDCategory,Objects.IDMentor);
		//AvaragedNormScore(NormalizedMap,TotalScore);
	}
	
	
	public static void OutputCSV(double [][] Array,int rowcount,HashMap<Double,String> IDName, HashMap<Double,String> IDCategory,HashMap<Double,String> IDMentor )
	{
		Loops.InfoLoop(IDCategory);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File("/Users/eduardomartinez/Desktop/normalized.csv"));
			StringBuilder sb = new StringBuilder();
			sb.append("Poster ID");
			sb.append(',');
			sb.append("Normalized score");
			sb.append(',');
			sb.append("Presenter");
			sb.append(',');
			sb.append("Judge Category");
			sb.append(',');
			sb.append("Mentor");
			sb.append('\n');
			for(int i=0;i<rowcount;i++)
			{
				sb.append(Array[i][1]);
				sb.append(',');
				sb.append(Array[i][4]);
				sb.append(',');
				sb.append(IDName.get(Array[i][1]));
				sb.append(',');
				sb.append(IDCategory.get(Array[i][1]));
				sb.append(',');
				sb.append(IDMentor.get(Array[i][1]));
				sb.append('\n');
			}
			pw.write(sb.toString());
			pw.close();
			System.out.println("done!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	
	

}


