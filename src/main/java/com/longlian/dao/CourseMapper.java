package com.longlian.dao;

import com.longlian.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CourseMapper {

    Course getCourse(@Param("id") long id);


    void updateVideoAddr(Course course);

    public void addVisitCount(@Param("id") long id);


    void update(Course course);
}
