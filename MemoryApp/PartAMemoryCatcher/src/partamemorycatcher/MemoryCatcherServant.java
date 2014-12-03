package partamemorycatcher;
import MemoryCatcherApp.*;
import java.sql.*;
import org.omg.CORBA.*; // All CORBA
//Servant
public class MemoryCatcherServant extends _MemoryCatcherImplBase {
	// Add the MemoryCatchers methods here in the next step.
        int resources = 3;
        int Logged = -1;   
        int memoryID = -1;
        String displayMemories = "";
        //private Connection con;
        private ResultSet rs;
        private PreparedStatement pst;   
        private Statement st;
//******Login to application****************************************************
	public int login(String username, String password){
        
        Logged =-1;
             try{
                //make connection to database
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
                pst = con.prepareStatement("insert into users (username, email, password)VALUES(?,?,?)");
                pst.setString(1, username);
                pst.setString(2, email);
                pst.setString(3, password);
                pst.executeUpdate();
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
             if(rs.next()){
                   
                    //store userID in local server
                    int memoryIDs = rs.getInt("memoryID");
                    System.out.println("userID:" +memoryIDs);
                    memoryID = memoryIDs;
                }else{
                    memoryID = -1;
                }
            } catch (Exception e) {
                System.out.println("Got an exception in addMemory Servant! "+e);  
            }
            return memoryID;
        }        
//********view Memory***********************************************************
        public String getMemories(){
            int user = Logged;
            try{
                 //connects to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memorycatcher","root","");
                st = con.createStatement();
                pst = con.prepareStatement("select * from memory WHERE userID=?");  
                //compare data between input and databse
                pst.setString(1,""+Logged);
                rs = pst.executeQuery();
                //if loggin succeed do:
                while(rs.next()){
                    int userID = rs.getInt("userID");
                    int memoryID = rs.getInt("memoryID");
                    String memoryName = rs.getString("memoryName");
                    //store userID in local server
                    String memoryDescription = rs.getString("memoryDescription");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    System.out.println("memoryID: '" +memoryID+ "'| memoryName: '"+memoryName+"'| memoryDescription: '"+memoryDescription+"'");
                    
                } return displayMemories;
                    
                
            }catch(Exception e){
                System.out.println("Got an exception in Get Memories" +e);
            }
            return null;
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
