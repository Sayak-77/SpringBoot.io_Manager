package com.manager.management.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.management.Entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>
{
    
}
