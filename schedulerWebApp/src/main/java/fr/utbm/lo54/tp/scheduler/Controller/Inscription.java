package fr.utbm.lo54.tp.scheduler.Controller;

import fr.utbm.lo54.tp.scheduler.entity.ClientEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.service.ClientService;
import fr.utbm.lo54.tp.scheduler.service.CourseSessionService;
import fr.utbm.lo54.tp.scheduler.service.LocationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Inscription extends HttpServlet {

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
        CourseSessionEntity cSession = null;

        //Parameters
        String courseRequested = request.getParameter("id");

        try {
            int id = Integer.parseInt(courseRequested);
            cSession = sessionService.getById(id);
            if (request.getParameter("firstname") != null && request.getParameter("lastname") != null) {
                ClientService clientService = new ClientService();
                ClientEntity client = new ClientEntity();
                client.setFirstname(request.getParameter("firstname"));
                client.setLastname(request.getParameter("lastname"));
                client.setAddress(request.getParameter("address"));
                client.setEmail(request.getParameter("email"));
                client.setPhone(request.getParameter("phone"));
                client.setCourse(cSession);

                clientService.save(client);
                request.setAttribute("client", client);
            }
        } catch (NumberFormatException e) {
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

        request.setAttribute("cSession", cSession);

        this.getServletContext().getRequestDispatcher("/Inscription.jsp").forward(request, response);

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
