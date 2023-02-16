package Servlet;

import ENTITY.Documento;
import LogicTier.GestioneDocumenti;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet utile alla ricerca di un documento all'interno del database tramite l'utilizzo di filtri e id.
 */
@WebServlet(name = "RicercaDocumento", value = "/RicercaDocumento")
public class RicercaDocumento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("search");
        GestioneDocumenti gd = new GestioneDocumenti();
        List<Documento> list = new ArrayList<Documento>();

        nome = nome.trim();

        Documento d = gd.ricercaIdD(nome);


        String address = "/display.jsp";
        if(d!=null) {

            list.add(d);
            request.setAttribute("payload",docPage(list));
        }
        else{
            request.setAttribute("payload",docPage(null));
        }

        request.setAttribute("csp",2);
        request.setAttribute("extraBtns","");


        request.setAttribute("finder","RicercaDocumento");

        request.setAttribute("adder","/AggiuntaDocumento");

        request.setAttribute("name","Documenti");


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    private String docPage(List<Documento> list){
        String toRet="";

        GestioneDocumenti doc = new GestioneDocumenti();

        List<Documento> listDoc = null;

        if(list==null)
            listDoc = doc.ricercaTuttiD();
        else
            listDoc = list;


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
}
