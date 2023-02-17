package Servlet;

import ENTITY.ClienteFornitore;
import LogicTier.GestioneClientiFornitori;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La seguente servlet permette l'aggiunta di un nuovo Cliente/Forniore all'interno del database utilizzando il formAddCf.jsp
 */
@WebServlet(name = "addClienteFornitore", value = "/addClienteFornitore")
public class addClienteFornitore extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formAddCf.jsp");

        dispatcher.forward(request,response);
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

            request.setAttribute("csp",4);
            request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=cliente'\">Visualizza Clienti</button></td><td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=fornitore'\">Visualizza Fornitori</button></td>");

            request.setAttribute("adder","/addClienteFornitore");

            request.setAttribute("name","Cliente/Fornitore");
            request.setAttribute("payload",cfPage(1));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/display.jsp");
            dispatcher.forward(request,response);
        }
    }

    private String cfPage(int n){
        String toRet="";

        GestioneClientiFornitori cf = new GestioneClientiFornitori();
        List<ClienteFornitore> scaf = new ArrayList<ClienteFornitore>();
        if(n == 1){
            scaf = cf.ricercaTuttiCf();
        }else if( n == 2){
            scaf = cf.ricercaTuttiCfS(true);
        }else{
            scaf = cf.ricercaTuttiCfS(false);
        }


        toRet+="<table class=\"table table-borderless mb-0\">";
        toRet+="<thead>";
        toRet+="<tr>";
        toRet+="<th scope=\"col\">";
        toRet+="</th>";
        toRet+="<th scope=\"col\">Seleziona</th>";
        toRet+="<th scope=\"col\">Codice</th>";
        toRet+="<th scope=\"col\">Nome</th>";
        toRet+="<th scope=\"col\">Cognome</th>";
        toRet+="<th scope=\"col\">Recapito</th>";
        toRet+="<th scope=\"col\">Email</th>";
        toRet+="</tr>";
        toRet+="</thead>";
        toRet+="<tbody>";

        if(scaf!=null){
            for(ClienteFornitore d:scaf) {
                toRet+="<tr>";
                toRet+="<th scope=\"row\">";
                toRet+="<td > <input type=\"checkbox\" name=\"docSelector\" value=\""+d.getCf()+"\"> </td>";
                toRet+="<td > "+d.getCf()+" </td>";
                toRet+="<td > "+d.getNome()+" </td>";
                toRet+="<td > "+d.getCognome()+" </td>";
                toRet+="<td > "+d.getRecapito()+" </td>";
                toRet+="<td > "+d.getEmail()+" </td>";
                toRet+="</th>";
                toRet+="</tr>";
            }
        }
        toRet+="</tbody>";
        toRet+="</table>";

        return toRet;
    }
}
