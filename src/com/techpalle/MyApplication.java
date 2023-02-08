package com.techpalle;

import java.util.ArrayList;

public class MyApplication {

	public static void main(String[] args) 
	{
		Student s=new Student(0 ,null ,null ,null);
		//s.Creating();
		/*s.insert("teju","Java","tejuk10@gmail.com");
		s.insert("prachi", ".net", "prachi12@gmail.com");
		s.insert("swati", "DB", "seati10@gmail.com");
		s.insert("karthik", "python", "karthik16@mail.com");*/
		
		//s.update(2, "C++", "prachi06@gmail.com");
		
		//s.delete(4);
		//s.read();
		
		
		
		ArrayList<Student>d=Student.reading();
		for(Student item:d)
		{
			System.out.println(item.sid);
			System.out.println(item.sname);
			System.out.println(item.sub);
			System.out.println(item.email);
			
			
			System.out.println("********************************");
			
		}
		}
			
			
			
		
		 

	}


