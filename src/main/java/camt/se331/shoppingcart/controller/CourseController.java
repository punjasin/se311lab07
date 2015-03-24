package camt.se331.shoppingcart.controller;

/**
 * Created by Punjasin on 24/3/2558.
 */

import camt.se331.shoppingcart.entity.Course;
import camt.se331.shoppingcart.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@RestController
@RequestMapping("/")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "course",method = RequestMethod.GET)
    public  List<Course> list(){
        return courseService.getCourse();
    }

    @RequestMapping(value = "course",method = RequestMethod.POST)
    public Course add(@RequestBody Course course, BindingResult bindingResult){
        return courseService.addCourse(course);
    }


    @RequestMapping(value = "course/{id}",method = RequestMethod.GET)
    public  Course getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "course/{id}",method = RequestMethod.PUT)
    public  Course edit(@PathVariable("id") Long id,@RequestBody Course course, BindingResult bindingResult){
        return courseService.updateCourse(course);
    }
    @RequestMapping(value = "/course/name/id.json",method = RequestMethod.GET)

    public @ResponseBody List<Course> getCourseByid(@RequestParam("id")String id ){
        return courseService.getCourses(id);
    }

    @RequestMapping(value = "/course/name/name.json",method = RequestMethod.GET)

    public @ResponseBody List<Course>  getCourseByKeyword(@RequestParam("name")String name ){
        return courseService.getCourses(name);
    }

    @RequestMapping(value = "course/{id}",method = RequestMethod.DELETE)
    public  Course edit(@PathVariable("id") Long id){
        return courseService.deleteCourse(id);
    }
}
