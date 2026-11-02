package com.deloitte.training.student.client;

import com.deloitte.training.student.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(
        name = "course-service",
        url = "http://localhost:9090"
        //url = "${clients.course.base-url:http://localhost:9090}"
)
public interface CourseClient {
    @GetMapping("/course/{id}")
    Course getCourseById(@PathVariable("id") Integer id);
    /*@GetMapping("/course/{ids}")
    List<Course> getCourseListByIds(@PathVariable("ids") List<Integer> ids);*/

    @PostMapping("/course")
    Course addCourse(@RequestBody Course course);
}
