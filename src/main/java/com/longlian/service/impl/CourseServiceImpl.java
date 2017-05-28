package com.longlian.service.impl;

import com.longlian.dao.CourseMapper;
import com.longlian.model.Course;
import com.longlian.service.CourseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuhan on 2017-05-27.
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    private static Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    CourseMapper courseMapper;


    public Course getCourse(Long courseId) {
        return courseMapper.getCourse(courseId);
    }

}
