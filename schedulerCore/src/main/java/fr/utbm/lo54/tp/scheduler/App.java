package fr.utbm.lo54.tp.scheduler;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.repository.CourseSessionDAO;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;

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

        CourseSessionDAO cDAO = new CourseSessionDAO();
        CourseSessionService cSer = new CourseSessionService();
        Date h = new SimpleDateFormat("dd/MM/yyyy").parse("2019/09/08");
        List<CourseSessionEntity> c = cDAO.getWithFilter("EPS", "2019-09-05", 2);

        c.forEach( x -> {
            System.out.println(x.getCourse_code().getTitle());
            System.out.println(x.getLocation_id().getCity());
            System.out.println();
        });
    }
}