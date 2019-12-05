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

import javax.xml.stream.Location;
import java.util.List;

/**
 * Hello world!
 *
 */

public class App
{

    public static void main( String[] args )
    {

        System.out.println("coucou");
        CourseSessionService cSer = new CourseSessionService();
        List<CourseSessionEntity> l = cSer.getByLocation(1);

        l.forEach( x -> {
            System.out.println(x.getCourse_code());
            System.out.println(x.getLocation_id().getCity());
            System.out.println();
        });
    }
}