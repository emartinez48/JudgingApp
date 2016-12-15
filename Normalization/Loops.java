import java.util.HashMap;
import java.util.Map;

public class Loops {

	
	public static void Hashloop(HashMap<Double,Double> NormalizedMap)
	{
		for (Map.Entry<Double,Double> entry : NormalizedMap.entrySet()) {
			Double key = entry.getKey();
			Double value = entry.getValue();
			//System.out.println("Poster ID: " + key + " Averaged Normalized Score : " + value );
		}
	}
	public static void InfoLoop(HashMap<Double,String> NormalizedMap)
	{
		for (Map.Entry<Double,String> entry : NormalizedMap.entrySet()) {
			Double key = entry.getKey();
			String value = entry.getValue();
			//System.out.println("StudentID: " + key + " Averaged Normalized Score : " + value );
		}
	}

	public static void PrintArray(double [][] Array,int rowcount)
	{
		for(int i=0;i<rowcount;i++)
		{
			for	(int j=0;j<5;j++)
			{
				//System.out.print(Array[i][j] + " # ");

			}
			//System.out.println(" ");
		}
	}
	public static void PrintInfo(String[][]Information, int filecounter)
	{
		for(int i=0;i<filecounter;i++)
		{
			for(int k=0;k<6;k++)
			{
				//System.out.print(Information[i][k]+ " # ");
			}
			//System.out.println("");
		}
	}
}
