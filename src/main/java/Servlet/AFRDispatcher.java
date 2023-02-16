package Servlet;

import ENTITY.*;
import LogicTier.GestioneCalendario;
import LogicTier.GestioneDocumenti;
import LogicTier.GestioneMagazzino;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AFRDispatcher", value = "/page")
public class AFRDispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String destination = request.getParameter("dest");
        //String extra = request.getParameter("extra");

        Dipendente connected = (Dipendente) session.getAttribute("dipendente");

        String payload=null;
        String target="/display.jsp";

        switch (destination){
            case "documenti":
                request.setAttribute("csp",2);
                request.setAttribute("extraBtns","");

                request.setAttribute("adder","/AggiuntaDocumento");

                request.setAttribute("name","Documenti");
                request.setAttribute("payload",docPage());
                break;
            case "pagamenti":
                break;
            case "magazzino":
                request.setAttribute("csp",3);
                request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\">Visualizza Prodotti</button></td>");

                request.setAttribute("name","Magazzino");
                request.setAttribute("payload",magPage());
                break;

            case "scaffale":
                break;

            case "cf":
                break;

            case "home":
                target="/home.jsp";

                GestioneCalendario gc = new GestioneCalendario();
                Calendario c = gc.ricercaRepC(connected.getCodiceRep());

                Date bound = new Date();
                List<EventoCalendario> list = gc.ricercaTuttiE(bound,c.getCodiceCal());

                request.setAttribute("eventi",list);
                break;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(target);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String docPage(){
        String toRet="";

        GestioneDocumenti doc = new GestioneDocumenti();
        List<Documento> listDoc = doc.ricercaTuttiD();

        toRet+="<table class=\"table table-borderless mb-0\">";
        toRet+="<thead>";
        toRet+="<tr>";
        toRet+="<th scope=\"col\">";
        toRet+="</th>";
        toRet+="<th scope=\"col\">Seleziona</th>";
        toRet+="<th scope=\"col\">Codice</th>";
        toRet+="<th scope=\"col\">Tipo</th>";
        toRet+="<th scope=\"col\">Data emissione</th>";
        toRet+="<th scope=\"col\">Note</th>";
        toRet+="<th scope=\"col\">Codice Fiscale</th>";
        toRet+="<th scope=\"col\">Matricola</th>";
        toRet+="</tr>";
        toRet+="</thead>";
        toRet+="<tbody>";

        if(listDoc!=null){
            for(Documento d:listDoc) {
                toRet+="<tr>";
                toRet+="<th scope=\"row\">";
                toRet+="<td > <input type=\"checkbox\" name=\"docSelector\" value=\""+d.getnDocumento()+"\"> </td>";
                toRet+="<td > "+d.getnDocumento()+" </td>";
                toRet+="<td > "+d.getTipo()+" </td>";
                toRet+="<td > "+d.getEmissione()+" </td>";
                toRet+="<td > "+d.getNote()+" </td>";
                toRet+="<td > "+d.getCf()+" </td>";
                toRet+="<td > "+d.getMatricola()+" </td>";
                toRet+="</th>";
                toRet+="</tr>";
            }
        }
        toRet+="</tbody>";
        toRet+="</table>";
        return toRet;
    }

    private String magPage(){
        String toRet="";

        GestioneMagazzino mag = new GestioneMagazzino();
        List<Scaffale> scaf = mag.ricercaTuttiS();

        toRet+="<table class=\"table table-borderless mb-0\">";
        toRet+="<thead>";
        toRet+="<tr>";
        toRet+="<th scope=\"col\">";
        toRet+="</th>";
        toRet+="<th scope=\"col\">Seleziona</th>";
        toRet+="<th scope=\"col\">Codice</th>";
        toRet+="<th scope=\"col\">Nome</th>";
        toRet+="<th scope=\"col\">Descrizione</th>";
        toRet+="<th scope=\"col\">Superfice occupata</th>";
        toRet+="<th scope=\"col\">Superfice disponibile</th>";
        toRet+="<th scope=\"col\">Codice magazzino</th>";
        toRet+="</tr>";
        toRet+="</thead>";
        toRet+="<tbody>";

        if(scaf!=null){
            for(Scaffale d:scaf) {
                toRet+="<tr>";
                toRet+="<th scope=\"row\">";
                toRet+="<td > <input type=\"checkbox\" name=\"docSelector\" value=\""+d.getCodiceScaffale()+"\"> </td>";
                toRet+="<td > "+d.getCodiceScaffale()+" </td>";
                toRet+="<td > "+d.getNome()+" </td>";
                toRet+="<td > "+d.getDescrizione()+" </td>";
                toRet+="<td > "+d.getSurOccupata()+" </td>";
                toRet+="<td > "+d.getSurDisponibile()+" </td>";
                toRet+="<td > "+d.getCodiceMagazzino()+" </td>";
                toRet+="</th>";
                toRet+="</tr>";
            }
        }
        toRet+="</tbody>";
        toRet+="</table>";

        return toRet;
    }
}
