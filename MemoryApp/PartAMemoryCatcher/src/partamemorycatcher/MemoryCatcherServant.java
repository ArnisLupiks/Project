package partamemorycatcher;
import MemoryCatcherApp.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//Servant
public class MemoryCatcherServant extends _MemoryCatcherImplBase {
	// Add the MemoryCatchers methods here in the next step.
     
        int Logged = -1;   
        int memoryID = -1;
        int resourceID = -1;
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
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memorycatcher","root","");
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
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memorycatcher","root","");
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

//******Add Memory**************************************************************
	public int addMemory(String memoryName, String memoryDescription){
            int userIDs = Logged;
            memoryID=-1;
            try{
                //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memorycatcher","root","");
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
        
        
                
	//view Memory
        @Override
        public Memory[] getAllMemories() {
            int user = Logged;
            List<Memory> memories = new ArrayList<Memory>();
            try{
                 //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memorycatcher","root","");
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
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memorycatcher","root","");
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
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memorycatcher","root","");
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
