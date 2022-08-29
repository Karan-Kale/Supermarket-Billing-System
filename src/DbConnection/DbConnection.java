/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{

    //void getConnect()
    static Connection con; 
    public static Connection getConnect()
    {
        try
        {
            
               //Class.forName("com.mysql.jdbc.Driver");
	    
               //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
            

        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
        
    }
}


