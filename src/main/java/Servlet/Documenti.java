package Servlet;

import ENTITY.Documento;
import LogicTier.GestioneDocumenti;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Documenti", value = "/Documenti")
public class Documenti extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestioneDocumenti doc = new GestioneDocumenti();
        List<Documento> listDoc = doc.ricercaTuttiD();
        request.setAttribute("Documenti",listDoc);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Documenti.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
