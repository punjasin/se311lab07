package camt.se331.shoppingcart.dao;
import camt.se331.shoppingcart.entity.Course;
import camt.se331.shoppingcart.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * Created by Punjasin on 17/3/2558.
 */
@Profile("db.dbdao")
@Repository
public class dbCourseDao implements CourseDAO {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }
    @Override
    public List<Course> getCourses(String anyKeyword) {
        HashSet output = new HashSet();
        for(Course course:courseRepository.findAll()){
            if (course.getName().toLowerCase().contains(anyKeyword.toLowerCase()) || course.getCourseid().contains(anyKeyword)){
                output.add(course);
            }
        }
        List<Course> outputList = (new ArrayList<Course>());
        outputList.addAll(output);
        return outputList;
    }
    @Override
    public Course getCourse(Long id) {
        return courseRepository.findOne(id);
    }
    @Override
    public Course addCourse(Course product) {
        return courseRepository.save(product);
    }
    @Override
    public Course deleteCourse(Course product) {
        courseRepository.delete(product);
        product.setId(null);
        return product;
    }
    @Override
    public Course updateCourse(Course product) {
        return courseRepository.save(product);
    }
}