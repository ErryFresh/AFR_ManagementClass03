package Servlet;

import ENTITY.Documento;
import LogicTier.GestioneDocumenti;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RicercaDocumento", value = "/RicercaDocumento")
public class RicercaDocumento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("search");
        GestioneDocumenti gd = new GestioneDocumenti();
        Documento d = gd.ricercaIdD(nome);
        if(d!=null) {
            request.setAttribute("DocumentoTrovato", d);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Documenti.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Documenti");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
