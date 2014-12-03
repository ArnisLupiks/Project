package partamemorycatcher;
import MemoryCatcherApp.MemoryCatcherHelper; // The package containing generated stubs.
import MemoryCatcherApp.MemoryCatcher;
import org.omg.CORBA.*; // All CORBA
// needed for output to the file system.
import java.io.*;
/**
 *
 * @author Arnis
 */
public class MemoryCatcherClient {
	//Main method.
	public static void main(String args[]) {
		try { //  FundraisingClient code here.
			//Initialize the ORB
			ORB orb = ORB.init(args, null);
			//Read the object Reference for the MemoryCatherServant
			BufferedReader br = new BufferedReader(new FileReader("MemoryCatcherIOR"));
			String ior = br.readLine();
			//Convert the string object reference to an object
			org.omg.CORBA.Object obj = orb.string_to_object(ior);
			//Convert the object to the correct type i.e. MemoryCatcher
			MemoryCatcher memorycatcherRef = MemoryCatcherHelper.narrow(obj);
			//Call theoperation on the servant
			BufferedReader userEntry = new BufferedReader(new InputStreamReader(System.in));
			char menuChoice;
                        //open main Login window
			do  {
                            System.out.println("Please log in or else create an account");
                            System.out.println("1 Log in; 2 Create Account; 3 Quit.");
                                menuChoice = (char)(System.in.read());
                                userEntry.readLine(); //Need to clear the out the buffer
				if (menuChoice==(char)'1') {
                                    System.out.println("Please enter your login details");
                                    System.out.println("Please enter your Name: ");
                                    String username=userEntry.readLine();
                                    System.out.println("Please enter your Password: ");
                                    String password=userEntry.readLine();
                                    int loginResult = memorycatcherRef.login(username, password);
                                    //When login succeed open Main window of the user
                                    if(loginResult>-1){
                                        try{
                                            do{
                                                // System.out.println("Please log in or else create an account");
                                                System.out.println("-----------------------------------------------------------------------------");
                                                System.out.println("1 view memory; 2 add memory; 3 view resource points; 4 Show database; 5 Quit.");
                                                menuChoice = (char)(System.in.read());
                                                userEntry.readLine(); //Need to clear the out the buffer
                                                if (menuChoice==(char)'1') {
                                                    //loginResult will be a param in other calls for memorycatcherRef
                                                        //view Memory
                                                        System.out.println("----------------------------------------------------");
                                                        String memory = memorycatcherRef.getMemories();
                                                        System.out.println(memory+" some memories");
                                                }else if (menuChoice==(char)'2') {
                                                       //Add memory
                                                        System.out.println("----------------------------------------------------");
                                                        System.out.println("Please share your memory");
                                                        System.out.println("Please enter your Memory Name: ");
                                                        String memoryName=userEntry.readLine();
                                                        System.out.println("Please enter your Memory description: ");
                                                        String memoryDescription=userEntry.readLine();
                                                        int addMemory = memorycatcherRef.addMemory(memoryName, memoryDescription);
                                                }else if (menuChoice==(char)'3') {
                                                                
                                                }else if (menuChoice==(char)'4') {
                                                                
                                                }
                                            }while(menuChoice != (char)'5');
                                        }
                                        catch(Exception e){
                                        System.out.println("Systems is fucked up: "+e);
                                        }
                                    }else{
                                        System.out.println("Loggin is not correct. Please try again!");
                                    }
                                }
                                //Register page            
                                else if (menuChoice==(char)'2') {                        
                                    System.out.println("Please enter your details");
                                    System.out.println("Please enter your name: ");
                                    String username = userEntry.readLine();
                                    System.out.println("Please enter your email: ");
                                    String email = userEntry.readLine();
                                    System.out.println("Please enter your password: ");
                                    String password = userEntry.readLine();
                                    int registerResult = memorycatcherRef.register(username, email, password);
                                    System.out.println(registerResult);
                                }
                            }
                            //exit application
                            while (menuChoice != (char)'3');
                    }
                    catch(Exception e) {
                    System.out.println("ERROR : " + e);
                    e.printStackTrace(System.out);
		}
	}
}
