package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.Course;

import java.util.List;

/**
 * Created by Punjasin on 24/3/2558.
 */
public interface CourseService {
    List<Course> getCourse();
    List<Course> getCourses(String anyKeyword);
    Course getCourse(Long id);
    Course addCourse(Course product);
    Course deleteCourse(Long id);
    Course updateCourse(Course product);
}
