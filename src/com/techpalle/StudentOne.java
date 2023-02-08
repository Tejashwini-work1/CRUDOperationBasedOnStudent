package com.techpalle;

public class StudentOne 
{
	private int sid;
	private String name;
	private String subject;
	private String email;
	
	
	public StudentOne(int sid,String name, String subject,String email)
	{
		super();
		this.sid=sid;
		this.name=name;
		this.subject=subject;
		this.email =email;
	}
	public int getSID()
	{
		return sid;
	}
	public void setSID(int sid)
	{
		this.sid= sid;
	}
	public String getName()
	{
	   return name;
	 }
	public void setName(String name)
	{
		this.name=name;
	}
	public String getsubject ()
	{
		return subject;
	}
	public void setString(String subject)
	{
	this.subject=subject;
	}
	public  String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
}


	
	


