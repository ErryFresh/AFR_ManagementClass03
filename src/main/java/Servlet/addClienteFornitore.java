package Servlet;

import ENTITY.ClienteFornitore;
import LogicTier.GestioneClientiFornitori;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Servlet utilizzata per l'aggiunta di un nuovo Cliente/Fornitore tramite il formAddCf.jsp
 */
@WebServlet(name = "addClienteFornitore", value = "/addClienteFornitore")
public class addClienteFornitore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        synchronized (session){
            String cf = request.getParameter("cf");
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String recapito = request.getParameter("tel");
            String eMail = request.getParameter("eMail");

            GestioneClientiFornitori gcf = new GestioneClientiFornitori();
            gcf.addClienteFornitore(new ClienteFornitore(cf,nome,cognome,recapito,eMail));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/display.jsp");
            dispatcher.forward(request,response);
        }
    }
}
