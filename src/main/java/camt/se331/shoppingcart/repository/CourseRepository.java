package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Punjasin on 24/3/2558.
 */
public interface CourseRepository extends JpaRepository<Course,Long> {
}
