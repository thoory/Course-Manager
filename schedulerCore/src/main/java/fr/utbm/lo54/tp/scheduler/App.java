package fr.utbm.lo54.tp.scheduler;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
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

        CourseSessionService cSesService = new CourseSessionService();
        LocationService locSer = new LocationService();

        List<CourseSessionEntity> courses = cSesService.getAll();
        courses.forEach( course -> {
                    System.out.println(course.getStartDate());
                    System.out.println(course.location_id.getId());
                    //System.out.println(locSer.getById(course.location_id.getId()));
                }
        );

        /*CourseSessionEntity c = new CourseSessionEntity();
        c.setLastname("Besançon");
        cSesService.save(c);

        System.out.println("-------");
        courses = cSesService.getAll();
        courses.forEach( course ->
                System.out.println(course.getLastname())
        );

        cSesService.deleteById(10);*/
    }
}