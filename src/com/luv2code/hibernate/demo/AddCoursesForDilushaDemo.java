package com.luv2code.hibernate.demo;

 import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;



public class AddCoursesForDilushaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
         SessionFactory factory	= new Configuration()
        		 				.configure("hibernate.cfg.xml")
        		 				.addAnnotatedClass(Instructor.class)
        		 				.addAnnotatedClass(InstructorDetail.class)
        		 				.addAnnotatedClass(Course.class)
        		 				.addAnnotatedClass(Review.class)
        		 				.addAnnotatedClass(Student.class)
        		 				.buildSessionFactory();
		//create session
         Session session =factory.getCurrentSession();
    
         try {       	 
      	 
        	 //start s transaction
        	 session.beginTransaction();
        	 
            //get the student dilusha from database
        	int studentId = 2;
        	Student tempStudent = session.get(Student.class, studentId);
        	
        	System.out.println("\n Load Student "+ tempStudent);
        	System.out.println("courses: "+ tempStudent.getCourses());
        	 
            // create more courses
        	
        	Course tempCourse1= new Course("SE Course");
        	Course tempCourse2 = new Course("Darabase Course");
        	 
        	 //add student to courses
        	tempCourse1.addStudent(tempStudent);
        	tempCourse2.addStudent(tempStudent);
        	 
        	 //save the courses
        	System.out.println("\n Saving the course");
        	session.save(tempCourse1);
        	session.save(tempCourse2);
        	 //commit transaction
        	 session.getTransaction().commit();
        	 System.out.println("Done...");
        	 
         }finally {
        	 //add clean up code 
        	 session.close();
			factory.close();
		}
         
	}	
	
}
