package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.CourseDAO;
import camt.se331.shoppingcart.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDAO courseDao;
    @Override
    public List<Course> getCourse() {
        return courseDao.getCourse();
    }



    @Override
    public List<Course> getCourses(String anyKeyword) {
        return courseDao.getCourses(anyKeyword);
    }

    @Override
    public Course getCourse(Long id) {
        return courseDao.getCourse(id);
    }

    @Override
    public Course addCourse(Course product) {
        return courseDao.addCourse(product);
    }

    @Override
    public Course deleteCourse(Long id) {
        Course course = getCourse(id);
        return courseDao.deleteCourse(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }
}
