package com.luv2code.hibernate.demo;

 import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;



public class CreateCourseAndStudentDemo {

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
        	 
             //create a course
        	 Course tempCourse = new Course("computer engineering");
        	 
        	 //saving the course
        	 System.out.println("\nSaving the Course\n");
        	 session.save(tempCourse);
        	 System.out.println("save the course : " +tempCourse	);

        	 //create a student
        	 Student tempStudent1 = new Student("dilusha","amarasekara","abc@gmail.com");
        	 Student tempStudent2 = new Student("kavithma","amarasekara","pqr@gmail.com");
        	 
        	 //add student to the course
        	 tempCourse.addStudent(tempStudent1);
        	 tempCourse.addStudent(tempStudent2);
        	 
        	 //save the student
        	 
        	 System.out.println("save the student .....");
        	 session.save(tempStudent1);
        	 session.save(tempStudent1);
        	 System.out.println("saved students "+ tempCourse.getStudents());
        	 
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
