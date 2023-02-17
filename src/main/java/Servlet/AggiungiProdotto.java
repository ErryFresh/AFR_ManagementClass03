package Servlet;

import ENTITY.Prodotto;
import ENTITY.Scaffale;
import LogicTier.GestioneMagazzino;
import LogicTier.GestioneProdotto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet utile all'aggiunta di un nuovo prodotto effettuato tramite il formProdotto.jsp
 */
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
        request.setAttribute("csp",4);
        request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=magazzino'\">Visualizza Magazzino</button></td>");
        request.setAttribute("adder","/formProdotto.jsp");
        request.setAttribute("name","Prodotti");
        request.setAttribute("payload",msgProduct());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/display.jsp");
        dispatcher.forward(request,response);
    }

    private String msgProduct(){
        String toRet="";

        GestioneProdotto p = new GestioneProdotto();
        List<Prodotto> scaf = new ArrayList<Prodotto>();
        scaf = p.ricercaTuttiP();
        toRet+="<table class=\"table table-borderless mb-0\">";
        toRet+="<thead>";
        toRet+="<tr>";
        toRet+="<th scope=\"col\">";
        toRet+="</th>";
        toRet+="<th scope=\"col\">Seleziona</th>";
        toRet+="<th scope=\"col\">Codice articolo</th>";
        toRet+="<th scope=\"col\">Nome</th>";
        toRet+="<th scope=\"col\">Descrizione</th>";
        toRet+="<th scope=\"col\">Prezzo acquisto</th>";
        toRet+="<th scope=\"col\">Prezzo vendita</th>";
        toRet+="<th scope=\"col\">Tipologia di vendita</th>";
        toRet+="</tr>";
        toRet+="</thead>";
        toRet+="<tbody>";

        if(scaf!=null){
            for(Prodotto d:scaf) {
                toRet+="<tr>";
                toRet+="<th scope=\"row\">";
                toRet+="<td > <input type=\"checkbox\" name=\"docSelector\" value=\""+d.getCodiceArt()+"\"> </td>";
                toRet+="<td > "+d.getCodiceArt()+" </td>";
                toRet+="<td > "+d.getNome()+" </td>";
                toRet+="<td > "+d.getDescrizione()+" </td>";
                toRet+="<td > "+d.getPrezzoAcquisto()+" </td>";
                toRet+="<td > "+d.getPrezzoVendita()+" </td>";
                toRet+="<td > "+d.getTipologiaVendita()+" </td>";
                toRet+="</th>";
                toRet+="</tr>";
            }
        }
        toRet+="</tbody>";
        toRet+="</table>";

        return toRet;
    }

}
