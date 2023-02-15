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
        String address = "";
        if(d!=null) {
            request.setAttribute("DocumentoTrovato", d);
            address="/display.jsp";
        }
        else{
            address="/Documenti";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
