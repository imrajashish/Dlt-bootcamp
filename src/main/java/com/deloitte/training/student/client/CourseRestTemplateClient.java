package com.deloitte.training.student.client;


import com.deloitte.training.student.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
//@Slf4j
public class CourseRestTemplateClient {
    @Autowired
    private RestTemplate restTemplate;

    public Course getCourse(Integer courseId) {

        String url = "http://localhost:9090/course/{courseId}";

//        log.info("Calling API: {}", url);

        Course response =
                restTemplate.getForObject(url, Course.class, courseId);

//        log.info("Response received: {}", response);

        return response;
    }
}
