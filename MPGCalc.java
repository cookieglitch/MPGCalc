/**
 * MPG Calc Public Version (UK)
 * 
 * @author John Tiernan
 * @version 19-Feb-2010
 */

import java.io.*;

public class MPGCalc
{
	private boolean debug = false;
	
	public static void main(String args[])
	{
		boolean running = true;

		if(args[0].equals("DEBUG"))
		{
			debug = true;
		}
		
		System.out.println("MPG Calculator\nJohn Tiernan & co\n19-2-2010");
		System.out.println("Initialising...\n\tWARNING: This is the command line version."
							+ "\n\tFor the GUI version see the website.");

		showOptionsList();
		
		//Create Store
		MPGStore s = new MPGStore();
		
		if(debug)
		{
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
		
		while(running)
		{
			String command = getUserInput();
			
		}
	}

	/**
	 * Currently always false until implemented
	 * @param MPGStore Data store to be saved
	 * @param fname File name to be used. Must NOT include file extension
	 * @return boolean
	 */
	public static boolean save(MPGStore store, String fname)
	{
		boolean status = false;
		
		try
		{
			//Create output stream
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fname, true));
		
			//Write storwe to file
			output.writeObject(store);
		
			//Close file
			output.close();

			status = true;
		}
		catch(IOException ioe)
		{
			System.out.println("Error saving file. Nothing you can do.");
			status = false;
		}

		return status;
	}

	/**
	 * Currently always false until implemented
	 * @param fname Name of file to load
	 * @return MPGStore
	 */
	public static MPGStore load(String fname)
	{
		MPGStore store = null;

		try
		{
			//Create input stream
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname+".mpg"));
			
			//Read stored data
			store = (MPGStore)(in.readObject());

		}
		catch(IOException ioe)
		{
			System.out.println("Error reading file. Nothing you can do.");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error reading file. Nothing you can do.");
		}
		
		return store;
	}

	/**
	 * Shows the options
	 */
	public static void showOptionsList()
	{
		System.out.println("\n\nOptions:\n\tload <filename>.mpg - Loads the named data file");
		System.out.println("\tsave <filename>.mpg - Saves the current records to the named file");
		System.out.println("\tnew - Creates a new entry");
		System.out.println("\thelp - Shows this list of options");
		System.out.println("\texit - Exits the program\n\tquit - See exit");
	}

	/**
	 * Checks if the given input is a valid command
	 * @param c Command to be checked
	 * @return boolean
	 */
	public static boolean isValidCommand(String c)
	{
		String[] commands = new String[6];
		commands[0] = "load";
		commands[1] = "save";
		commands[2] = "new";
		commands[3] = "help";
		commands[4] = "exit";
		commands[5] = "quit";
		
		boolean found = false;
		
		
		
		for(int i = 0; i < commands.length; i++)
		{
			if(commands[i].equals(c))
			{
				found = true;
			}
		}
		return false;	
	}

	/**
	 * Reads the command line for any user input and returns it to the calling method
	 * @return String
	 */
	public static String getUserInput()
	{
		boolean workingRead = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String input = null;

		while(!workingRead)
		{
    	   	try
			{
    			input = br.readLine();
    		}
			catch (IOException ioe)
			{
    			System.out.println("Error trying to read your input. Less fail please.");
	    	}

			if(isValidCommand(input))
			{
				workingRead = true;
			}
		}
		
		return input;
	}
}
