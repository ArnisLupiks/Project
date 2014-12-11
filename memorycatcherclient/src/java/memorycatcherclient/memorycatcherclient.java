/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycatcherclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author Arnis
 */
@WebService(serviceName = "memorycatcherclient")
public class memorycatcherclient {
final String DATABASE_CONN = "jdbc:mysql://localhost:3306/memorycatcher";
        final String ROOT = "root";
        
        // This is a class for the user
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public int login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
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
                    //store userID in local server
                    int userID = rs.getInt("userID");
                    System.out.println("userID:" +userID+" username: "+username);
                    loggedInUser = new User(userID, username);
                    Logged = userID;
                }else{
                    Logged = -1;
                }
                } catch (Exception e) {
                    System.out.println("Got an exception in Login Servant! "+e);
                    Logged = -1;
                } return Logged;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public int register(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email) {
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMemory")
    public int addMemory(@WebParam(name = "memoryName") String memoryName, @WebParam(name = "memoryDescription") String memoryDescription) {
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

  
    
         
}
