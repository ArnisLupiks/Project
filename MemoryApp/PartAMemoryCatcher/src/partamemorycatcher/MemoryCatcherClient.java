package partamemorycatcher;
import MemoryCatcherApp.Memory;
import MemoryCatcherApp.MemoryCatcherHelper; // The package containing generated stubs.
import MemoryCatcherApp.MemoryCatcher;
import MemoryCatcherApp.Message;
import MemoryCatcherApp.Resources;
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
                                                System.out.println("1 Memory; 2 Resources; 3 Messages; 4 Logout.");
                                                menuChoice = (char)(System.in.read());
                                                userEntry.readLine(); //Need to clear the out the buffer
                                                if (menuChoice==(char)'1') {
                                                    //memories
                                                    try{
                                                        do{
                                                            System.out.println("----------------------------------------------------");
                                                            System.out.println("Please choose following options: ");
                                                            System.out.println("1 view memory; 2 add memory; 3 share memory; 4 remove memory; 5 back.");

                                                            menuChoice = (char)(System.in.read());
                                                            userEntry.readLine(); //Need to clear the out the buffer
                                                            if (menuChoice==(char)'1') {      
                                                                  //view Memory
                                                                    System.out.println("----------------------------------------------------");
                                                                    Memory[] memories = memorycatcherRef.getAllMemories();
                                                                    System.out.println("This is all your memories:");  
                                                                    for (Memory m : memories){
                                                                    System.out.println("Name: " + m.name + " Description: " + m.description);    
                                                                    }
                                                            }else if (menuChoice == (char)'2'){
                                                                System.out.println("----------------------------------------------------");
                                                                System.out.println("Please share your memory");
                                                                System.out.println("Please enter your Memory Name: ");
                                                                String memoryName=userEntry.readLine();
                                                                System.out.println("Please enter your Memory description: ");
                                                                String memoryDescription=userEntry.readLine();
                                                                int addMemory = memorycatcherRef.addMemory(memoryName, memoryDescription);          
                                                            }else if (menuChoice ==(char)'3'){
                                                                System.out.println("Need to work on share memory");
                                                            }else if (menuChoice==(char)'4'){
                                                             // Delete memory
                                                                System.out.println("----------------------------------------------------");
                                                                System.out.println("Which memory would you like to delete?");
                                                                Memory[] memories = memorycatcherRef.getAllMemories();
                                                                System.out.println("Please select the id of the  memory you want to delete:");  
                                                                for (Memory m : memories){
                                                                    System.out.println("ID:" +m.id + " Name:" + m.name);    
                                                                }
                                                                String memory = userEntry.readLine();
                                                                int memoryID = Integer.parseInt(memory);
                                                                boolean removeMemory = memorycatcherRef.removeMemory(memoryID); 
                                                                if (removeMemory ){
                                                                    System.out.println("Memory with id of " + memoryID +" is removed");
                                                                }else{
                                                                    System.out.println("Failed to delete memory " + memoryID);
                                                                }           
                                                            }
                                                        }while(menuChoice !=(char)'4');
                                                    }catch(Exception e){
                                                        System.out.println("memory menu is broken: "+e);
                                                    }
                                                    }else if (menuChoice==(char)'2') {
                                                        //Resources
                                                        try{
                                                            do{
                                                            System.out.println("----------------------------------------------------");
                                                            System.out.println("Please choose following options: ");
                                                            System.out.println("1 view resources; 2 add resources; 3 share resources; 4 back.");
                                                            menuChoice = (char)(System.in.read());
                                                            userEntry.readLine(); //Need to clear the out the buffer
                                                            if (menuChoice==(char)'1') {
                                                                System.out.println("----------------------------------------------------");
                                                                System.out.println("----------------------------------------------------");
                                                                Resources[] resources = memorycatcherRef.viewResources();
                                                                System.out.println("This is all your resources:");  
                                                                for (Resources r : resources){
                                                                System.out.println("Your Resources: " + r.resources);    
                                                                }
                                                            }else if(menuChoice==(char)'2'){
                                                                System.out.println("----------------------------------------------------");
                                                                System.out.println("How much would you like to add");
                                                                String amounts = userEntry.readLine();
                                                                int resources = Integer.parseInt(amounts);
                                                                int addResources = memorycatcherRef.addResources(resources);
                                                            } else if(menuChoice==(char)'3'){
                                                                System.out.println("----------------------------------------------------");
                                                                System.out.println("Please write user name to whom ou would like to send resources: ");
                                                                String user = userEntry.readLine();
                                                                System.out.println("Please enter amount you would like to send: ");
                                                                String amount = userEntry.readLine();
                                                                int resources = Integer.parseInt(amount);
                                                                int addResources = memorycatcherRef.shareResources(resources, user);
                                                            } 
                                                        }while (menuChoice != (char)'4');
                                                        }
                                                        catch(Exception e){
                                                        System.out.println("Systems is broken: "+e);
                                                        }
                                                    }else if (menuChoice==(char)'3') {
                                                        //Messages
                                                        try{
                                                            do{
                                                                System.out.println("----------------------------------------------------");
                                                                System.out.println("1 Invite User; 2 Inbox; 3 back.");
                                                                menuChoice = (char)(System.in.read());
                                                                userEntry.readLine(); //Need to clear the out the buffer
                                                                if (menuChoice==(char)'1') {
                                                                //This is the invite user to see snaps code    
                                                                System.out.println("----------------------------------------------------");
                                                                System.out.println("Please type your username:");
                                                                String sender = userEntry.readLine();
                                                                System.out.println("Please type your message name");
                                                                String messageName = userEntry.readLine();
                                                                System.out.println("Please type your message");
                                                                String messageContent  = userEntry.readLine();
                                                                System.out.println("Please enter userID of who you want to invite");
                                                                String receiver = userEntry.readLine();
                                                                int addMessage = memorycatcherRef.addMessage(messageName, messageContent, receiver);
                                                                }else if (menuChoice==(char)'2'){
                                                                //This is the user inbox    
                                                                System.out.println("----------------------------------------------------");
                                                                    Message [] messages = memorycatcherRef.getAllMessages();
                                                                System.out.println("This is all your messages:");  
                                                                    for (Message n : messages){
                                                                System.out.println("From: " + n.sender);
                                                                System.out.println("Title : " + n.name); 
                                                                System.out.println("Message: " + n.content);  
                                                                         }
                                                                    }
                                                                }while(menuChoice!=(char)'3');
                                                            }
                                                            catch(Exception e){
                                                            System.out.println("Systems is broken: "+e);
                                                        }
                                                    }
                                            }while(menuChoice != (char)'4');
                                        }
                                        catch(Exception e){
                                        System.out.println("Systems is broken: "+e);
                                        }
                                    }else{
                                        System.out.println("Login is not correct. Please try again!");
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
