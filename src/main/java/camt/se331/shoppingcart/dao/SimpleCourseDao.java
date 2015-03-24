package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Dto on 2/8/2015.
 */
@Repository
@Profile("db.SimpleDao")
public class SimpleCourseDao implements  CourseDAO{
@Autowired
    private Set<Course> courses;

    public SimpleCourseDao(){
        Course[] initCourse =  {
               };
        courses = new TreeSet<Course>(Arrays.asList(initCourse));

    }
    @Override
    public List<Course> getCourse() {
        return new ArrayList<Course>(courses);
    }

    @Override
    public List<Course> getCourses(String anyKeyword) {
        HashSet output = new HashSet();
        for(Course course:courses){
            if (course.getName().contains(anyKeyword)){
                output.add(course);
            }
        }
        List<Course> outputList = (new ArrayList<Course>());
        outputList.addAll(output);
        return outputList;
    }

    @Override
    public Course addCourse(Course course) {
        course.setId((long)(courses.size()+1));
        courses.add(course);
        return course;
    }

    @Override
    public Course deleteCourse(Course course) {
        if (courses.remove(course)){
            return course;
        }else
        {
            return null;
        }
    }

    @Override
    public Course updateCourse(Course course) {
        Course toRemove = getCourse(course.getId());
        if (toRemove == null){
            return null;
        }
        if (!courses.remove(course))
            return null;

        courses.add(course);
        return course;
    }

    @Override
    public Course getCourse(Long id){
        for(Course course:courses){
            if (course.getId().equals(id)){
                return course;
            }
        }
        return null;
    }
}
