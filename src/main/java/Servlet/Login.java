package Servlet;

import DataTier.AutenticazioneDAO;
import DataTier.DipendenteDAO;
import ENTITY.Dipendente;
import ENTITY.Reparto;
import LogicTier.AutenticazioneService;
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
            String address = "/home.jsp";

            AutenticazioneService as = new AutenticazioneService();

            Dipendente connected = as.logIn(psw,usr);

            if(connected == null){
                request.setAttribute("sconosciuto", usr);
                request.setAttribute("msg", true);
                address = "/index.jsp";
            }else{
                session.setAttribute("dipendente", connected);
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
            dispatcher.forward(request,response);
        }
    }
}
