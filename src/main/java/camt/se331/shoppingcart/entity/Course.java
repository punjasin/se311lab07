package camt.se331.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Punjasin on 24/3/2558.
 */
@Entity
public class Course implements Comparable {
    @Id
    @GeneratedValue
    Long id;
    String courseid;
    String name;
    int credit;
    int section;

    public Course(Long id, String courseid, String name, int credit, int section) {
        this.id = id;
        this.courseid = courseid;
        this.name = name;
        this.credit = credit;
        this.section = section;
    }
    public Course(){
    };

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (credit != course.credit) return false;
        if (section != course.section) return false;
        if (!courseid.equals(course.courseid)) return false;
        if (!id.equals(course.id)) return false;
        if (!name.equals(course.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + courseid.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + credit;
        result = 31 * result + section;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
