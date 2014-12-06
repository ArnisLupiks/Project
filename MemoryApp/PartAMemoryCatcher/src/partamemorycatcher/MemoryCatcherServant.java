package partamemorycatcher;
import MemoryCatcherApp.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//Servant
public class MemoryCatcherServant extends _MemoryCatcherImplBase {
	// Add the MemoryCatchers methods here in the next step.
        final String DATABASE_CONN = "jdbc:mysql://localhost:3306/memorycatcher";
        final String ROOT = "root";
        
         class User{
          int id;
          String username;
          
          public User(int id, String username){
            this.id = id;
            this.username = username;
          }
        }
        
        User loggedInUser = null;
        int Logged = -1;   
        int memoryID = -1;
        int resourceID = -1;
        int messageID =-1;
        String user = null;
        String mail = null;
        //private Connection con;
        private ResultSet rs;
        private PreparedStatement pst;   
        private Statement st;
//******Login to application****************************************************
	public int login(String username, String password){
        
        Logged =-1;
             try{
                //make connection to d0atabase
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                st = con.createStatement();
                //select from database
                String query = "select * from users WHERE username=? and password=?";
                pst = con.prepareStatement(query);  
                //compare data between input and databse
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                //if loggin succeed do:
                if(rs.next()){
                    String usernamers = rs.getString("username");
                    //store userID in local server
                    int userID = rs.getInt("userID");
                    System.out.println("userID:" +userID+" username: "+usernamers);
                    Logged = userID;
                }else{
                    Logged = -1;
                }
                } catch (Exception e) {
                    System.out.println("Got an exception in Login Servant! "+e);
                    Logged = -1;
                } return Logged;
            }
//******Register function*******************************************************
	public int register(String username, String email, String password){
            int register = 0;
            try{
                //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                st = con.createStatement();
                //inserts data into table
                pst = con.prepareStatement("INSERT INTO `users` (`username`, `email`, `password`)VALUES(?,?,?)");
                pst.setString(1, username);
                pst.setString(2, email);
                pst.setString(3, password);
                user = username;
                mail = email;
                pst.executeUpdate();
                if(pst.executeUpdate()>0){
                    pst = con.prepareStatement("SELECT * FROM `users` WHERE username=? and email=?");
                    pst.setString(1, user);
                    pst.setString(2, mail);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int userIDs = rs.getInt("userID");
                        pst = con.prepareStatement("INSERT INTO `resources`(`userID`,`resources`) VALUES (?,?)");
                        pst.setInt(1,userIDs);
                        pst.setInt(2, 20);
                        pst.executeUpdate();
                        System.out.println("?!?!?!?!?!?!?!?!??!?!?!?!?!!?"+userIDs);
                        memoryID = userIDs;
                    }else{
                        return 0;
                    }
                }else{
                    memoryID = -1;
                }
            } catch (Exception e) {
                System.out.println("Got an exception in Register Servant! "+e);  
            }
            return register;
        }

//****** Add Memory **************************************************************
	public int addMemory(String memoryName, String memoryDescription){
            int userIDs = Logged;
            memoryID=-1;
            try{
                //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                st = con.createStatement();
                //inserts data into table
                pst = con.prepareStatement("INSERT INTO `memory`(`userID`, `memoryName`, `MemoryDescription`) VALUES (?,?,?)");
                pst.setString(1, ""+userIDs);
                pst.setString(2, memoryName);
                pst.setString(3, memoryDescription);
                pst.executeUpdate();
                pst = con.prepareStatement("SELECT * FROM `resources` WHERE userID=?");
                pst.setInt(1, Logged);
                rs = pst.executeQuery();
                if(rs.next()){
                    //store userID in local server
                    int resource = rs.getInt("resources");
                    int total = resource - 2;
                    System.out.println("Resources left:" +total);
                    pst = con.prepareStatement("UPDATE `resources` set resources=? where userID=?");
                    pst.setInt(1, total);
                    pst.setInt(2, Logged);
                    pst.executeUpdate();
                    memoryID = Logged;
                }else{
                    memoryID = -1;
                }
            } catch (Exception e) {
                System.out.println("Got an exception in addMemory Servant! "+e);  
            }
            return memoryID;
        }
        //Removes a Memory
        public boolean removeMemory(int memoryID){
             int userIDs = Logged;
          try{
                //connects to database
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                
                // Removes data from the tables
                pst = con.prepareStatement("delete from memory WHERE memoryID=?");
                pst.setInt(1,memoryID);
                pst.executeUpdate();
            
            } catch (Exception e) {
                System.out.println("Got an exception in removeMemory Servant! "+e);  
                return false;
            }
            return true;
        }
        
        
                
	//view Memory
        @Override
        public Memory[] getAllMemories() {
            int user = Logged;
            List<Memory> memories = new ArrayList<Memory>();
            try{
                 //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                st = con.createStatement(); 
                pst = con.prepareStatement("select * from memory WHERE userID=?");  
                //compare data between input and databse
                pst.setString(1,""+Logged);
                rs = pst.executeQuery();
                
                Memory aMemory;
                //if loggin succeed do:
                while(rs.next()){
                    int userID = rs.getInt("userID");
                    int memoryID = rs.getInt("memoryID");
                    String memoryName = rs.getString("memoryName");
                    //store userID in local server
                    String memoryDescription = rs.getString("memoryDescription");
                    aMemory = new Memory(memoryName, memoryDescription, memoryID);
                    memories.add(aMemory);
                    System.out.println("memoryID: '" +memoryID+ "'| memoryName: '"+memoryName+"'| memoryDescription: '"+memoryDescription+"'");
                }    
            }catch(Exception e){
                System.out.println("Got an exception in Get Memories" +e);
            }
            //TODO memories to Memory[];
            Memory[] allMemories = new Memory[memories.size()];
            allMemories = memories.toArray(allMemories);
             return allMemories;
        
        }
//****** Add Resources ***********************************************************************************************       
        public int addResources(int resources){
            int addResources=0;
            try{
                 //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                st = con.createStatement(); 
                pst = con.prepareStatement("SELECT * FROM `resources` WHERE userID=?");
                pst.setInt(1, Logged);
                rs = pst.executeQuery();
                if(rs.next()){
                    //store userID in local server
                    int resource = rs.getInt("resources");
                    int total = resource + resources;
                    System.out.println("userID:" +total);
                    pst = con.prepareStatement("UPDATE `resources` set resources=? where userID=?");
                    pst.setInt(1, total);
                    pst.setInt(2, Logged);
                    pst.executeUpdate();
                    addResources = total;
                }else{
                    addResources = -1;
                }
            }catch(Exception e){
                System.out.println("Got an exception in add Resorces" +e);
            }
            return addResources;
    }
 //***** View Resources ***********************************************************************************************  
        public Resources[] viewResources() {
            int user = Logged;
            List<Resources> resources = new ArrayList<Resources>();
            try{
                 //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                st = con.createStatement(); 
                pst = con.prepareStatement("SELECT * FROM resources WHERE userID=?");  
                //compare data between input and databse
                pst.setString(1,""+Logged);
                rs = pst.executeQuery();
                Resources aResources;
                //if loggin succeed do:
                while(rs.next()){
                    int userID = rs.getInt("userID");
                    int Resources = rs.getInt("resources");
                    aResources = new Resources(userID, Resources);
                    resources.add(aResources);
                    System.out.println("memoryID: '" +userID+ "'| memoryName: '"+Resources);
                }    
            }catch(Exception e){
                System.out.println("Got an exception in Get Memories" +e);
            }
            //TODO memories to Memory[];
            Resources[] allResources = new Resources[resources.size()];
            allResources = resources.toArray(allResources);
             return allResources;
        
        } 
//****** Add Resources ***********************************************************************************************       
          public int shareResources(int resources, String name){
            int shareResources=0;
            int resource = 0;
            int userIdent = 0;
            try{
                 //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DATABASE_CONN,ROOT,"");
                st = con.createStatement(); 
                pst = con.prepareStatement("SELECT * FROM `resources` WHERE userID=?");
                pst.setInt(1, Logged);
                rs = pst.executeQuery();
                char answer;
                if(rs.next()){
                    //store userID in local server
                    resource = rs.getInt("resources");
                    pst = con.prepareStatement("SELECT * FROM `users` WHERE username=?");
                    pst.setString(1, name);
                    rs = pst.executeQuery();
                    if(rs.next()){
                        userIdent = rs.getInt("userID");
                        System.out.println("Yeey, you have found user!!!!!");
                        System.out.println("Your fiend "+name+ " userID is: "+userIdent);
                        int total = resource - resources;
                        System.out.println("You have left " +total+" resources");
                        pst = con.prepareStatement("UPDATE `resources` set resources=? where userID=?");
                        pst.setInt(1, total);
                        pst.setInt(2, Logged);
                        pst.executeUpdate();
                        shareResources = total;
                        if(pst.executeUpdate()>0){
                            pst = con.prepareStatement("SELECT * FROM `resources` WHERE userID=?");
                            pst.setInt(1, userIdent);
                            rs = pst.executeQuery();
                            if(rs.next()){
                                int userResources = rs.getInt("resources");
                                System.out.println("User :"+userIdent+" before recieveing resources was: "+userResources);
                                int updatedResources = resources+ userResources;
                                pst = con.prepareStatement("UPDATE `resources` set resources=? where userID=?");
                                pst.setInt(1, updatedResources);
                                pst.setInt(2, userIdent);
                                pst.executeUpdate();
                            }else{
                                return 0;
                            }
                        }else{
                            return 0;
                        }
                    }else{
                        return 0;
                    }
                }else{
                    shareResources = -1;
                }
            }catch(Exception e){
                System.out.println("Got an exception in Share Resorces" +e);
            }
            return shareResources;
    }
       //view Messages in inbox
        @Override
        public Message[] getAllMessages() {
            int user = Logged;
            List<Message> messages = new ArrayList<Message>();
            try{
                 //connects to database
                Connection con = DriverManager.getConnection(DATABASE_CONN,"root","");
                st = con.createStatement(); 
                pst = con.prepareStatement("select * from messages WHERE username=?");  
                //compare data between input and databse
                pst.setString(1,""+Logged);
                rs = pst.executeQuery();
                
                Message aMessage;
                //if loggin succeed do:
                while(rs.next()){
                    int messageID = rs.getInt("messageID");
                    String receiver = rs.getString("receiver");
                    String messageContent = rs.getString("messageContent");
                    String sender = rs.getString("sender");
                    //store userID in local server
                    String content = rs.getString("messageContent");
                    aMessage = new Message(receiver, messageContent, sender, messageID);
                    messages.add(aMessage);
                    System.out.println("messageID: " +messageID+ " receiver: "+receiver+ " sender: " + sender + " messageContent: "+content);
                }    
            }catch(Exception e){
                System.out.println("Got an exception in Get Messages" +e);
            }
            //TODO memories to Memory[];
            Message[] allMessages = new Message[messages.size()];
            allMessages = messages.toArray(allMessages);
             return allMessages;
        
        }   
        
        
         //Invite User
           public int addMessage(String receiver, String messageContent, String sender){
               sender = null;
               if (loggedInUser != null){
               sender = loggedInUser.username;
               }
               messageID = -1;
                 try{
                 //connects to database
                Connection con = DriverManager.getConnection(DATABASE_CONN,"root","");
                st = con.createStatement();  
                //compare data between input and databse
                pst = con.prepareStatement("INSERT INTO `messages`(`receiver``messageContent`, `sender`)VALUES(?,?,?)");
                pst.setString(1, messageContent);
                pst.setString(2,receiver);
                pst.setString(3, sender);
                pst.executeUpdate();
             
           
         }catch(Exception e){
                System.out.println("Got an exception in addMessage into messages" +e);
         }
        
                    return -1;
    }


}

/*	//Remove Memory
	public boolean removeMemory(String memoryName){
            String sql = "DELETE FROM ARNIS.MEMORIES WHERE memoryName = memoryName";
            return true;
	}
	//Transfer Points
	//public boolean transfer(int points, String username){

	//}
	//Buy Resource Points
	public void buy(int amount){
		memoryResourcePoints = memoryResourcePoints + amount;
	}
	//public boolean share(int memoryIndex){

	//}
	//Get Memory
	//public int getMemory(int memoryIndex){
	//	return memory;

	//}

	//View Resouces
        
  
	


	//public ArrayList<String> getMemories(){
	//  return memories;
	//}

	//public String share(String memories){
	//  moments = memories + moments;
	//}

	//public boolean login(String userName, String password){
	//	return false;
	//}

	

	//public boolean addMemory(String memory){
	//  return memories.add(memory);
	//}

	//public boolean removeMemory(String memory){
	  	//TODO
	//}

*/
//}
