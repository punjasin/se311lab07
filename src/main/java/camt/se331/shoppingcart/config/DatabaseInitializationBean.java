package camt.se331.shoppingcart.config;
import camt.se331.shoppingcart.entity.Course;

import camt.se331.shoppingcart.repository.CourseRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Profile("db.init")
@Component
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        Course[] initCourse = {
                new Course(1l,"953101","Computer and Programming",3,701),
                new Course(2l,"953331","Compo Base Software",3,701),
                new Course(3l,"953321","SQA",3,701),
                new Course(4l,"953351","Test",3,701)


        };
        courseRepository.save(Arrays.asList(initCourse));

    }
}