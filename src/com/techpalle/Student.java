package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student 
{
	private static final  String url="jdbc:mysql://localhost:3306/palle";
	private static final  String username ="root";
	private static final  String password="admin";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs =null;
	
	
	
	public int sid;
	public String sname;
	public String sub;
	public String email;
	
	
	public Student(int s, String n, String p, String e)
	{
		this.sid=s;
		this.sname=n;
		this.sub=p;
	}


	public void Creating()
	{
	try 
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			s=con.createStatement();
			s.executeUpdate("create table student(sid int primary key auto_increment,sname varchar(40),sub varchar(40),email varchar(40)unique)");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			
		//closing connections;
			try
			{
				if(s!=null)
				{
					s.close();
				}
				if(con!=null) 
				{
					con.close();
					
				}
			}
			
				catch(SQLException e) 
			{
					e.printStackTrace();
			}
			
					
					
				}
			}
	
	
	 public void insert(String sname,String sub,String email) 
     {
    	 try
    	 {
    		 
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	 
    	 con= DriverManager.getConnection(url ,username ,password);
    	 ps=con.prepareStatement("insert into student (sname,sub,email) values (?,?,?)");
    	 ps.setString(1,"sname");
    	 ps.setString(2,"sub");
    	 ps.setString(3,"email");
    	 ps.executeUpdate();
     }
     
    	 catch(ClassNotFoundException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 catch(SQLException e)
    	 {
    		
    		e.printStackTrace();
    	 }
    	 finally 
    	 {
    		 //closing connection
    		 try{
    			 if(ps!=null)
    			 {
    				 ps.close();
    				 
    			 }
    			 if(con!=null)
    			 {
    				 con.close();
    			 }
    			 }
    			 catch(SQLException e)
    			 {
    				 e.printStackTrace();
    			 }
    		}
          }
	 
	 public void update(int sid ,String sub,String email) 
     {
    
		 try
    	 {
    		 
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 con= DriverManager.getConnection(url ,username ,password);
    	 ps=con.prepareStatement("update student set sub=?,email=? where sid=?");
    	 ps.setString(1,sub);
    	 ps.setString(2,email);
    	 ps.setInt(3,sid);
    	
    	 ps.executeUpdate();
    	
     }
     
    	 catch(ClassNotFoundException  e)
    	 {
    		 e.printStackTrace();
    	 }
    	 catch(SQLException e)
    	 {
    		 //ToDo Auto-generated catch block
    		e.printStackTrace();
    	 }
    	 finally 
    	 {
    		 //closing connection
    		 try{
    			 if(ps!=null)
    			 {
    				 ps.close();
    				 
    			 }
    			 if(con!=null)
    			 {
    				 con.close();
    			 }
    			 }
    			 catch(SQLException e)
    			 {
    				 e.printStackTrace();
    			 }
    		}
          }
	 
	 
	 
	 public void delete(int sid)
     {
    	 try
    	 {
    		 
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	  con= DriverManager.getConnection(url ,username ,password);
    	  ps=con.prepareStatement("delete from student where sid=?");
    	  ps.setInt(1, sid);
    	  ps.executeUpdate();
     }
     
    	 catch(ClassNotFoundException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 catch(SQLException e)
    	 {
    		 //ToDo Auto-generated catch block
    		e.printStackTrace();
    	 }
    	 finally 
    	 {
    		 //closing connection
    		 try{
    			 if(ps!=null)
    			 {
    				 ps.close();
    				 
    			 }
    			 if(con!=null)
    			 {
    				 con.close();
    			 }
    			 }
    			 catch(SQLException e)
    			 {
    				 e.printStackTrace();
    			 }
    		}
          }
	 
	 public  void read() 
	 
	 {
        try
        { 
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con= DriverManager.getConnection(url ,username ,password);
            s=con.createStatement();
            rs=s.executeQuery("select * from student");
            
            
            
            while(rs.next()==true)
            {
            	System.out.println(rs.getInt("sid"));
            	System.out.println(rs.getString("sname"));
            	System.out.println(rs.getString("sub"));
            	System.out.println(rs.getString("email"));
            }
		 
       }
        catch (ClassNotFoundException e) 
        {
        	e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	
        try
        	{
        	if(rs!=null)
        	{
        		rs.close();
        	}
        	if(s!=null)
        	{
        		s.close();
        	}
        	if(con!=null)
        	{
        		con.close();
        	}
        	
        	}
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
        	
      }
	 }


	 
	 public static  ArrayList<Student> reading()
	 {
		  ArrayList<Student> stud= new ArrayList<Student>();
		  
		  try
		  {
			 
			  Class.forName("com.mysql.cj.jdbc.Driver");
	           con=DriverManager.getConnection(url,username,password);
	            s=con.createStatement();
	            rs=s.executeQuery("select * from student");
	            
	            
	            while(rs.next())
	            
	            {
	            	int s=rs.getInt("sid");
	            	String n =rs.getString("sname");
	            	String p=rs.getString("sub");
	            	String e=rs.getString("email");
	            	
	            	Student d=new Student(s,n,p,e);
	            	stud.add(d);
	            	
	            }
	            }
		  
		  catch(ClassNotFoundException e)
		  {
			  e.printStackTrace();
		  }
		  catch(SQLException e) 
		  {
			  e.printStackTrace();
		  }
		  finally
		  {
			  try 
			  {
				  if(rs!=null)
				  {
					  rs.close();
				  }
				  if(s!=null)
				  {
					  s.close();
				  }
				  if(con!=null)
				  {
					  con.close();
				  }
			  }
				  
					catch(SQLException e)  
					{
						e.printStackTrace();
					}
			  }
			  
					return stud;
				  
				  
		  }
	 }
	 
	
	 
       
	



