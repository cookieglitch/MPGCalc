/**
 * MPG Calc Public Version (UK)
 * 
 * @author John Tiernan
 * @version 19-Feb-2010
 */
public class MPGCalc
{
	public static void main(String args[])
	{
		System.out.println("MPG Calculator\nJohn Tiernan & co\n19-2-2010");
		System.out.println("Initialising...\n\tWARNING: This is the command line version");
		
		//Create Store
		MPGStore s = new MPGStore();

		//Create sample entry
		String d = "Today";
		double m = 100;
		double f = 30;
		MPGEntry e = new MPGEntry("now", 100, 300);
		
		//Add sample to store
		s.addEntry(e);

		//Output sample
		MPGEntry sample = s.getEntry(0);
		System.out.println("Sample: " + sample.getDate() + "-" + sample.getMiles());
		
	}
}
