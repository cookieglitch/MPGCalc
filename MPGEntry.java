/**
 * MPG Calc Public Version (UK)
 * 
 * @author John Tiernan
 * @version 19-Feb-2010
 */
public class MPGEntry
{
	String date;
	double milesDone;
	double fuelAdded;
	
	/**
	 * Constructor
	 * 
	 * @param d Date of entry
	 * @param m Miles done
	 * @param f Fuel added
	 */
	public MPGEntry(String d, double m, double f)
	{
		date = d;
		milesDone = m;
		fuelAdded = f;
	}

	/**
	 * @return String
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * @return double
	 */
	public double getMiles()
	{
		return milesDone;
	}

	/**
	 * @return double
	 */
	public double getFuel()
	{
		return fuelAdded;
	}
}
