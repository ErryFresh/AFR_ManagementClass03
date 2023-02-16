package Servlet;

import ENTITY.Calendario;
import ENTITY.Dipendente;
import ENTITY.EventoCalendario;
import LogicTier.GestioneCalendario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 *Servlet per visualizzazione e creazione degli Eventi.
 */
@WebServlet(name = "Eventi", value = "/Eventi")
public class Eventi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Dipendente connected = (Dipendente) session.getAttribute("dipendente");

        GestioneCalendario gc = new GestioneCalendario();

        Calendario cal = gc.ricercaRepC(connected.getCodiceRep());

        if(cal==null){
            cal = new Calendario("c"+connected.getCodiceRep(),"Calendario",connected.getCodiceRep(),connected.getMatricola());
            gc.addCalendario(cal);
        }
        request.setAttribute("cal", cal);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formEvento.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = (String) request.getParameter("dataEv");
        String nome = (String) request.getParameter("nome");
        String desc = (String) request.getParameter("desc");
        String code = (String) request.getParameter("code");

        HttpSession session = request.getSession();
        Dipendente connected = (Dipendente) session.getAttribute("dipendente");

        Random r = new Random();

        GestioneCalendario gc = new GestioneCalendario();

        EventoCalendario newEv = new EventoCalendario("ev"+r.nextInt(100)*r.nextInt(10),nome,desc,data,connected.getMatricola(),code);

        gc.addEvento(newEv);

        Date bound = new Date();
        List<EventoCalendario> list = gc.ricercaTuttiE(bound,code);

        request.setAttribute("eventi",list);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        dispatcher.forward(request,response);
    }
}
