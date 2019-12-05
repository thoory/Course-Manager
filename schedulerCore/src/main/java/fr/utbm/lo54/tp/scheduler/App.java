package fr.utbm.lo54.tp.scheduler;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.repository.CourseSessionDAO;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;
import fr.utbm.lo54.tp.scheduler.service.LocationService;
import fr.utbm.lo54.tp.scheduler.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Hello world!
 *
 */

public class App
{

    public static void main( String[] args )
    {

        CourseSessionDAO sessionList = new CourseSessionDAO();

        CourseSessionEntity courses = sessionList.getById(2);
        LocationService lser = new LocationService();
        lser.getById(courses.getId());

        System.out.println(courses.getId());
        System.out.println(courses.getLocation_id().getCity());

        /*courses.forEach( course -> {

            System.out.println(course.getId());
            System.out.println(course.location_id);
            System.out.println(course.location_id.getCity());
            System.out.println(course.course_code);
            System.out.println(course.course_code.getTitle());
            }
        );*/
    }
}