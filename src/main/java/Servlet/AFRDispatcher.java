package Servlet;

import ENTITY.*;
import LogicTier.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet utile allo smistamento delle pagine che mostrano una lista con i relativi
 * aggiunti/modifica e ricerca come Cliente/Fornitore,Documento,Magazzino ecc.
 */
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
                request.setAttribute("finder","RicercaDocumento");
                break;
            case "pagamenti":
                request.setAttribute("csp",3);
                request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\">Visualizza Pagamenti</button></td>");


                request.setAttribute("name","Pagamenti");
                request.setAttribute("payload",payPage());
                break;
            case "magazzino":
                request.setAttribute("csp",4);
                request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=prodotti'\">Visualizza Prodotti</button></td><td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='formProdotto.jsp'\">Aggiungi Prodotto</button></td>");
                request.setAttribute("adder","/formProdotto.jsp");
                request.setAttribute("name","Magazzino");
                request.setAttribute("payload",magPage());
                break;
            case "prodotti":
                request.setAttribute("csp",4);
                request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=magazzino'\">Visualizza Magazzino</button></td>");
                request.setAttribute("adder","/formProdotto.jsp");
                request.setAttribute("name","Prodotti");
                request.setAttribute("payload",msgProduct());
                break;
            case "scaffale":
                break;

            case "cf":
                request.setAttribute("csp",4);
                request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=cliente'\">Visualizza Clienti</button></td><td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=fornitore'\">Visualizza Fornitori</button></td>");

                request.setAttribute("adder","/addClienteFornitore");

                request.setAttribute("name","Cliente/Fornitore");
                request.setAttribute("payload",cfPage(1));
                break;
            case "cliente":
                request.setAttribute("csp",4);
                request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=fornitore'\">Visualizza Fornitori</button></td><td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=cf'\">Visualizza Tutti</button></td>");

                request.setAttribute("adder","/addClienteFornitore");

                request.setAttribute("name","Clienti");
                request.setAttribute("payload",cfPage(2));
                break;
            case "fornitore":
                request.setAttribute("csp",4);
                request.setAttribute("extraBtns","<td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=cliente'\">Visualizza Clienti</button></td><td><button type=\"button\" class=\"btn me-2\" onclick=\"location.href='page?dest=cf'\">Visualizza Tutti</button></td>");

                request.setAttribute("adder","/addClienteFornitore");

                request.setAttribute("name","Fornitori");
                request.setAttribute("payload",cfPage(3));
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

        GestioneScaffale mag = new GestioneScaffale();
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

    private String payPage(){
        String toRet="";

        GestionePagamenti pay = new GestionePagamenti();
        List<Pagamento> pays = pay.ricercaTuttiP();

        toRet+="<table class=\"table table-borderless mb-0\">";
        toRet+="<thead>";
        toRet+="<tr>";
        toRet+="<th scope=\"col\">";
        toRet+="</th>";
        toRet+="<th scope=\"col\">Seleziona</th>";
        toRet+="<th scope=\"col\">Numero transazione</th>";
        toRet+="<th scope=\"col\">Tipo</th>";
        toRet+="<th scope=\"col\">Numero assegno</th>";
        toRet+="<th scope=\"col\">Causale</th>";
        toRet+="<th scope=\"col\">Importo</th>";
        toRet+="<th scope=\"col\">Saldato</th>";
        toRet+="<th scope=\"col\">Data emissione</th>";
        toRet+="<th scope=\"col\">Data scadenza</th>";
        toRet+="<th scope=\"col\">Beneficiario</th>";
        toRet+="<th scope=\"col\">Emittente</th>";
        toRet+="</tr>";
        toRet+="</thead>";
        toRet+="<tbody>";

        if(pays!=null){
            for(Pagamento p:pays) {
                toRet+="<tr>";
                toRet+="<th scope=\"row\">";
                toRet+="<td > <input type=\"checkbox\" name=\"docSelector\" value=\""+p.getnTransazione()+"\"> </td>";
                toRet+="<td > "+p.getnTransazione()+" </td>";
                toRet+="<td > "+p.getTipo()+" </td>";
                toRet+="<td > "+p.getnAssegno()+" </td>";
                toRet+="<td > "+p.getCausale()+" </td>";
                toRet+="<td > "+p.getImporto()+" </td>";
                toRet+="<td > "+p.isSaldato()+" </td>";
                toRet+="<td > "+p.getEmissione()+" </td>";
                toRet+="<td > "+p.getScadenza()+" </td>";
                toRet+="<td > "+p.getBeneficiario()+" </td>";
                toRet+="<td > "+p.getEmittente()+" </td>";
                toRet+="</th>";
                toRet+="</tr>";
            }
        }
        toRet+="</tbody>";
        toRet+="</table>";

        return toRet;
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
