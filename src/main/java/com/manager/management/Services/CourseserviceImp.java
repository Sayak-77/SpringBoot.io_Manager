package com.manager.management.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.management.Dao.CourseDao;
import com.manager.management.Entities.Course;

@Service
public class CourseserviceImp implements Courseservice
{
    @Autowired
    private CourseDao courseDao;

    @Override
    public Course addCourse(Course course) {
        Course save = courseDao.save(course);
        return save;
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long id) 
    {
        Optional<Course> courseById= courseDao.findById(id);
        if(courseById.isPresent())
        {
            return courseById.get();
        }
        return null;
    }

    @Override
    public Course updateCourse(Course course) {
        Course save = courseDao.save(course);
        return save;
    }

    @Override
    public void deleteCourse(long id) 
    {
        Course course = courseDao.findById(id).get();
        courseDao.delete(course);
    }
}
