package Servlet;

import DataTier.AutenticazioneDAO;
import DataTier.DipendenteDAO;
import ENTITY.Dipendente;
import ENTITY.Reparto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        synchronized (session){
            String usr = request.getParameter("usr");
            String psw = request.getParameter("psw");
            String address = "/index.jsp"; //da cambiare con la destinazione

            Dipendente connected = AutenticazioneDAO.getSingle_instance().logIn(psw,usr);

            if(connected == null){
                request.setAttribute("sconosciuto", usr);
                request.setAttribute("msg", true);
            }else{
                session.setAttribute("dipendente", connected);
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
            dispatcher.forward(request,response);
        }
    }
}
