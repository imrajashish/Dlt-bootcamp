package com.deloitte.training.student.service;

import com.deloitte.training.student.client.CourseClient;
import com.deloitte.training.student.client.CourseRestTemplateClient;
import com.deloitte.training.student.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseClient courseClient;

//    @Autowired
//    CourseRestTemplateClient courseRestTemplateClient;

    private static final String COURSE_SERVICE = "courseService";



    /**
     * This method fetches course by id from course-service. It uses feign client.
     * @param id
     * @return
     */
//    @CircuitBreaker(name = "courseServiceCB", fallbackMethod = "getCourseFallback")
//    @Retry(name = "courseServiceRetry")
    //@CircuitBreaker(name = COURSE_SERVICE, fallbackMethod = "getCourseFallback")
    public Course getCourseById(Integer id) {
        System.out.println("Inside getCourseById method!!!");
        //return courseRestTemplateClient.getCourse(id);
        return courseClient.getCourseById(id);
    }

    /**
     * This is a fallback method, in case course-service is down
     * @param id
     * @param t
     * @return
     */
    public Course getCourseFallback(Integer id, Throwable t) {
        // return degraded response: maybe student info without courses, or cached/stubbed response
        System.out.println("Fallback triggered for courseId: " + id + ", reason: " + t.getMessage());
        //System.out.println("Inside getCourseFallback method!!!");
        Course fallback = new Course();
        fallback.setId(id);
        fallback.setName("Demo Fallback Course");
        fallback.setDescription("This is a fallback demo course.");
        fallback.setDurationInHours(0);
        return fallback;
    }
}
