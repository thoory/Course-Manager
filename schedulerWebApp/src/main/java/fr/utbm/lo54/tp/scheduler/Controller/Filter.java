package fr.utbm.lo54.tp.scheduler.Controller;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;
import fr.utbm.lo54.tp.scheduler.service.CoursesService;
import fr.utbm.lo54.tp.scheduler.service.LocationService;

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
        response.setContentType("text/html;charset=UTF-8");

        //init services
        CourseSessionService sessionService = new CourseSessionService();
        LocationService locService = new LocationService();

        List<CourseSessionEntity> sessions;
        List<LocationEntity> locationsList = locService.getAll();

        //Parameters
        String locRequested = (request.getParameter("location") != null) ? request.getParameter("location") : "";
        LocationEntity currentLoc = null;

        try {
            int l = Integer.parseInt(locRequested);
            sessions = sessionService.getByLocation(l);
            currentLoc = locService.getById(l);
        } catch (NumberFormatException e) {
            sessions = sessionService.getAll();
        }

        request.setAttribute("sessions", sessions);
        request.setAttribute("locationsList", locationsList);
        request.setAttribute("currentLoc", currentLoc);

        this.getServletContext().getRequestDispatcher("/Filter.jsp").forward(request, response);

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
