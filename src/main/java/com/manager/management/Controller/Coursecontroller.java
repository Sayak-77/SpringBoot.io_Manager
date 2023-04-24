package com.manager.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manager.management.Entities.Course;
import com.manager.management.Services.Courseservice;



@RestController
public class Coursecontroller 
{
    @Autowired
    private Courseservice courseservice;

    @RequestMapping(value = "/course/test", method = RequestMethod.GET)
    public String Test()
    {
        return "Testing Connection...";
    }
    @RequestMapping(value= "/course/allCourses")
    public List<Course> getCourses()
    {
        return this.courseservice.getCourses();
    }
    @RequestMapping(value= "/course/{courseId}", method= RequestMethod.GET)
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseservice.getCourse(Long.parseLong(courseId));
    }
    @PostMapping(path = "/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseservice.addCourse(course);
    }
    @PutMapping(path = "/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return this.courseservice.updateCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
    {
        try{
            this.courseservice.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
