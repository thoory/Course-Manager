package fr.utbm.lo54.tp.scheduler;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.repository.CourseSessionDAO;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */

public class App
{

    public static void main( String[] args ) throws ParseException {
        //Test Core module: Write your code below
        CourseSessionService cSer = new CourseSessionService();
        CourseSessionEntity c = cSer.getById(1);
        System.out.println(c.getStartDate().toString());

        Date d = new Timestamp(c.getStartDate().getTime());

        System.out.println(c.getStartDate().getTime());
        System.out.println(d);
    }
}