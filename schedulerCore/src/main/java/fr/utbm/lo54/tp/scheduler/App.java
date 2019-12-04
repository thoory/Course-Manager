package fr.utbm.lo54.tp.scheduler;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;
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

        System.out.println( "Hello World!" );

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //sessionFactory.openSession();
        CourseSessionService cSesService = new CourseSessionService();

        CourseSessionEntity cc = cSesService.getById(1);

        cc.setLocation_id(new LocationEntity());

        List<CourseSessionEntity> courses = cSesService.getAll();
        courses.forEach( course -> {
                    System.out.println(course.getStartDate());
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