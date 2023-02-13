package Servlet;

import ENTITY.Prodotto;
import LogicTier.GestioneProdotto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AggiungiProdotto", value = "/AggiungiProdotto")
public class AggiungiProdotto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Prodotto p = new Prodotto();
        GestioneProdotto gP = new GestioneProdotto();
        p.setCodiceArt(request.getParameter("codiceProdotto"));
        p.setNome(request.getParameter("nomeProdotto"));
        p.setDescrizione(request.getParameter("descrizioneProdotto"));
        p.setPrezzoAcquisto(Double.parseDouble(request.getParameter("prezzoAcquisto")));
        p.setPrezzoVendita(Double.parseDouble(request.getParameter("prezzoVendita")));
        p.setTipologiaVendita(request.getParameter("tipologiaVendita"));
        gP.addProdotto(p);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        dispatcher.forward(request,response);
    }
}
