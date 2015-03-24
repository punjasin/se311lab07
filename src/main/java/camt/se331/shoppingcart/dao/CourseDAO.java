package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Course;


import java.util.List;

/**
 * Created by Punjasin on 24/3/2558.
 */
public interface CourseDAO {
    List<Course> getCourse();
    List<Course> getCourses(String anyKeyword);
    Course getCourse(Long id);
    Course addCourse(Course product);
    Course deleteCourse(Course product);
    Course updateCourse(Course product);
}
