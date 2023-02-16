package Servlet;

import ENTITY.Calendario;
import ENTITY.Dipendente;
import ENTITY.EventoCalendario;
import LogicTier.AutenticazioneService;
import LogicTier.GestioneCalendario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * La servlet si rende utile a effettuare il login del Dipendente verificando i parametri eMail e password inseriti
 * da quest'ultimo inoltre dispone un oggetto cookie per effettuare la disconnessione di quest'ultimo dopo 15 min d'inattività
 */
@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);
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

            GestioneCalendario gc = new GestioneCalendario();

            if(connected == null){
                request.setAttribute("sconosciuto", usr);
                request.setAttribute("msg", true);
                address = "/index.jsp";
            }else{
                Cookie auth = new Cookie("Auth",connected.getMatricola());

                Date bound = new Date();

                Calendario c = gc.ricercaRepC(connected.getCodiceRep());

                if(c!=null){
                    List<EventoCalendario> list = gc.ricercaTuttiE(bound,c.getCodiceCal());
                    request.setAttribute("eventi",list);

                }
                else
                request.setAttribute("eventi",null);

                auth.setMaxAge(15*60);
                session.setAttribute("dipendente", connected);
                session.setAttribute("cookie", auth);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request,response);
        }
    }
}
