package partamemorycatcher;
// All CORBA applications need these classes.
import org.omg.CORBA.*;
// needed for output to the file system.
import java.io.*;

public class MemoryCatcherServer {
	// Main method Memory Catcher.
	public static void main(String args[]) {
		try {
			//Initialize the ORB
			ORB orb = ORB.init(args, null);
			//Instantiate the MemoryCatcherServant on the server
			MemoryCatcherServant memorycatcherRef = new MemoryCatcherServant();
			//Connect the MemoryCatcherServant to the orb
			orb.connect(memorycatcherRef);
			//Store an object Reference to the HelloServant in a
			//String format
			String ior = orb.object_to_string(memorycatcherRef);
			//Write the object reference to the memorycatcherServant to a
			//file called MemoryCatcherIOR
			FileOutputStream fos = new FileOutputStream("MemoryCatcherIOR");
			PrintStream ps = new PrintStream(fos);
			ps.print(ior);
			ps.close();
			//Run the orb so that it waits for requests from the
			//client
			orb.run();
		}
		catch(Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}
}