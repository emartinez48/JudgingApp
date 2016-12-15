import java.util.ArrayList;
import java.util.HashMap;

public class Objects {

	ArrayList<Double> JScore = new ArrayList<Double>(); //Instanciate the class that will use all of the methods
	static HashMap<Double,Double> ScoreID = new HashMap<Double, Double>();
	static HashMap<Double, ArrayList<Double>> JudgesScores = new HashMap<Double, ArrayList<Double>>();
	static HashMap<Double,Double> JMax = new HashMap<Double, Double>();
	static HashMap<Double,Double> JMin = new HashMap<Double, Double>();
	static HashMap<Double, ArrayList<Double>> NormalizedMap = new HashMap<Double, ArrayList<Double>>();
	static HashMap<Double,Double> TotalScore = new HashMap<Double, Double>();
	static HashMap<Double,Double> Nfactor = new HashMap<Double, Double>();
	static HashMap<Double,Double> JudgesMean = new HashMap<Double, Double>(); 
	static HashMap<Double,Double> JudgesSD = new HashMap<Double, Double>();
	static HashMap<Double,String> IDName = new HashMap<Double, String>();
	static HashMap<Double,String> IDCategory = new HashMap<Double, String>();
	static HashMap<Double,String> IDMentor = new HashMap<Double, String>();

	static double savedmean=0.0;
	static int savedelementsum=0;

}
