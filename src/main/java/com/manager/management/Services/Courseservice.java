package com.manager.management.Services;

import java.util.List;
import com.manager.management.Entities.Course;
public interface Courseservice 
{
    Course addCourse(Course course);

    public List<Course> getCourses();

    Course getCourse(long id);
    
    Course updateCourse(Course course);

    void deleteCourse(long id); 
    
}
