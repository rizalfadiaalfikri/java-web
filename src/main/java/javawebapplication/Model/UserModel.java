package javawebapplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javawebapplication.bean.UserBEan;
import javawebapplication.utility.JDBCDaraScource;

public class UserModel {
	 public static long nextPk() {
		    long pk = 0;
		    Connection conn;
		    try {
		      conn = JDBCDaraScource.getConnection();
		      PreparedStatement stmt = conn.prepareStatement("select Max(id) from user");
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
		        pk = rs.getLong(1);
		      }
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    return pk+1;
		    
		  }
		  
		  // Registration User
		  public static long addUser(UserBEan user) {
		    int i = 0;
		    try {
		      Connection conn = JDBCDaraScource.getConnection();
		      PreparedStatement stmt = conn.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
		      stmt.setLong(1, nextPk());
		      stmt.setString(2 , user.getFirstName() );
		      stmt.setString(3 , user.getLastName() );
		      stmt.setString(4 , user.getLogin() );
		      stmt.setString(5 , user.getPassword() );
		      stmt.setDate(6 , new java.sql.Date(user.getDob().getTime()) );
		      stmt.setString(7 , user.getMobileNo() );
		        i =     stmt.executeUpdate();
		      
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    
		    
		    return i;
		  }
		  
		//Login User......
		  public static UserBEan  UserLogin(String login,String password) {
		    Connection con;
		    UserBEan user = null;
		    try {
		      con = JDBCDaraScource.getConnection();
		      PreparedStatement stmt = con.prepareStatement("Select * from users where login=? and password = ?");
		      stmt.setString(1,login);
		      stmt.setString(2,password);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {
		        user = new UserBEan();
		        System.out.println("ID: "+rs.getLong("id"));
		        user.setId(rs.getLong("id"));
		        user.setFirstName(rs.getString("fname"));
		        user.setLastName(rs.getString("lname"));
		        user.setLogin(rs.getString("login"));
		        user.setPassword(rs.getString("password"));
		        user.setDob(rs.getDate("dob"));
		        user.setMobileNo(rs.getString("mobile"));    
		      }
		      
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    
		    return user;
		  }
}
