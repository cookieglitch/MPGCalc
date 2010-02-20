/**
 * MPG Calc Public Version (UK)
 * 
 * @author John Tiernan
 * @version 19-Feb-2010
 */
import java.util.ArrayList;
import java.io.Serializable;

public class MPGStore implements Serializable
{
	ArrayList<MPGEntry> store;
	public MPGStore()
	{
		store = new ArrayList<MPGEntry>();
	}

	/**
	 * @param e MPGEntry to be added to the data store
	 */
	public void addEntry(MPGEntry e)
	{
		store.add(e);
	}

	/**
	 * @param ind MPGEntry to be retrieved from the data store
	 * @return MPGEntry
	 */
	public MPGEntry getEntry(int ind)
	{
		return store.get(ind);
	}

	/**
	 * @return int
	 */
	public int getEntryCount()
	{
		return store.size();
	}
}
