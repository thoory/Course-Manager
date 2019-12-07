package fr.utbm.lo54.tp.scheduler;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.repository.CourseSessionDAO;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;
import org.hibernate.Hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */

public class App
{

    public static void main( String[] args ) throws ParseException {

        CourseSessionService cSer = new CourseSessionService();
        //List<CourseSessionEntity> list = cSer.searchCourse("an");
        List<CourseSessionEntity> list = cSer.getByLocation(1);


        list.forEach( x -> {
            System.out.println(x.getCourse_code().getTitle());
            System.out.println(x.getLocation_id().getCity());
            float inscrits = 0;
            if ( x.getCourse_session_id() != null ) {
                inscrits = x.getCourse_session_id().size();
            }
            inscrits = (inscrits/x.getMax())*100;
            System.out.println(inscrits);
            System.out.println("---");
        });
    }
}