package fr.utbm.lo54.tp.scheduler.Controller;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;
import fr.utbm.lo54.tp.scheduler.service.CoursesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Filter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("coucou");
        response.setContentType("text/html;charset=UTF-8");
        CoursesService service = new CoursesService();
        //request.getSession().setAttribute("service", service);

        List<CourseEntity> result = service.getAll();
        /*List location = service.getAllFormationLoc();
        String display = "none";
        String title = (String) request.getParameter("titleFilter");
        String loc = (String) request.getParameter("locFilter");
        String date = (String) request.getParameter("dateFilter");
        if (title != null) {
            result = service.filterFormation(1, title);
        }
        if ((loc != null) && !("vide".equals(loc))) {

            result = service.filterFormation(3, loc);
        }
        if ((date != null) && (date.length() != 0)) {
            result = service.filterFormation(2, date);
        }
        if (result.isEmpty()) {
            display = "";
            result = service.getAllFormationSession();
        }*/

        request.setAttribute("visible2", "none");

        request.getSession().setAttribute("result", result);
        //request.getSession().setAttribute("listLocation", location);
        //request.getSession().setAttribute("visible", display);

        this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code.

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
