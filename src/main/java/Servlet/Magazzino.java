package Servlet;

import DataTier.MagazzinoDAO;
import ENTITY.Scaffale;
import LogicTier.GestioneMagazzino;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Magazzino", value = "/Magazzino")
public class Magazzino extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestioneMagazzino mag = new GestioneMagazzino();
        List<Scaffale> scaf = mag.ricercaTuttiS();
        request.setAttribute("Scaffali",scaf);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Magazzino.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
