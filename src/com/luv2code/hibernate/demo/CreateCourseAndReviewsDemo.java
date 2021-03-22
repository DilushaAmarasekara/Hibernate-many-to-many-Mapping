package com.luv2code.hibernate.demo;

 import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;


public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
         SessionFactory factory	= new Configuration()
        		 				.configure("hibernate.cfg.xml")
        		 				.addAnnotatedClass(Instructor.class)
        		 				.addAnnotatedClass(InstructorDetail.class)
        		 				.addAnnotatedClass(Course.class)
        		 				.addAnnotatedClass(Review.class)
        		 				.buildSessionFactory();
		//create session
         Session session =factory.getCurrentSession();
    
         try {       	 
      	 
        	 //start s transaction
        	 session.beginTransaction();
        	 
             //create a course
        	 Course tempCourse = new Course("computer engineering");
        	 
        	 //add some reviews
        	 tempCourse.addReview(new Review("good course"));
        	 tempCourse.addReview(new Review("awesone course"));
        	 tempCourse.addReview(new Review("best course"));
        	 
        	 //save the course.. and leverage the cascade all
        	 System.out.println("saving the course");
        	 System.out.println(tempCourse);
        	 System.out.println(tempCourse.getReviews());
        	 
        	 session.save(tempCourse);
        	 
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
