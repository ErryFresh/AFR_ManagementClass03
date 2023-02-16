package Servlet;

import ENTITY.*;
import LogicTier.GestioneClientiFornitori;
import LogicTier.GestioneDocumenti;
import LogicTier.GestioneProdotto;
import LogicTier.GestioneProdottoDocumento;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Servlet che permette l'aggiunta di un Documento appena creato nel database
 */
@WebServlet(name = "AggiuntaDocumento", value = "/AggiuntaDocumento")
public class AggiuntaDocumento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Dipendente connected = (Dipendente) session.getAttribute("dipendente");


        GestioneClientiFornitori gcf = new GestioneClientiFornitori();
        GestioneProdotto gp = new GestioneProdotto();

        List<ClienteFornitore> cf = gcf.ricercaTuttiCf();
        List<Prodotto> lp = gp.ricercaTuttiP();

        String cfList = "";
        String artList = "";

        for(ClienteFornitore c:cf){
            cfList+="<option value=\""+c.getCf()+"\">"+c.getNome()+"</option>";
        }

        for(Prodotto p:lp){
            artList+="<option value=\""+p.getCodiceArt()+"-"+p.getNome()+"-"+p.getPrezzoVendita()+"\">"+p.getNome()+" €"+p.getPrezzoVendita()+"/"+p.getTipologiaVendita()+")</option>";
        }



        request.setAttribute("mat",connected.getMatricola());
        request.setAttribute("cf",cfList);
        request.setAttribute("articoli",artList);


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formDocumento.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Dipendente connected = (Dipendente) session.getAttribute("dipendente");

        String tipo = request.getParameter("tipo");
        String data = request.getParameter("data");
        String note = request.getParameter("note");
        String destinatario = request.getParameter("cf");
        String document = request.getParameter("document");

        String listArt[] = document.split("/");

        String code = generateCode(tipo);

        switch (tipo){
            case "ddt":
                tipo="Documento di trasporto";
                break;

            case "prev":
                tipo="Preventivo";
                break;

            case "fattura":
                tipo="Fattura";
                break;
        }

        GestioneDocumenti gd = new GestioneDocumenti();
        GestioneProdottoDocumento gpd = new GestioneProdottoDocumento();

        Documento doc = new Documento(code,tipo,data,note,destinatario,connected.getMatricola());

        if(!gd.addDocumento(doc))
            throw  new RuntimeException("Inserimento non riuscito");

        for(String s : listArt){
            if(s.equals(""))
                break;
            String a[]=s.split(":");
            ProdottoDocumento ps = new ProdottoDocumento(a[0],code,Integer.parseInt(a[3]),0,Double.parseDouble(a[1]),Double.parseDouble(a[2]));
            gpd.addProdottoDocumento(ps);
        }

        request.setAttribute("csp",2);
        request.setAttribute("extraBtns","");

        request.setAttribute("adder","/AggiuntaDocumento");

        request.setAttribute("name","Documenti");
        request.setAttribute("payload",docPage());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/display.jsp");
        dispatcher.forward(request,response);

    }

    private String generateCode(String tipo){
        String toRet="";

        switch (tipo){
            case "ddt":
                toRet="DT";
                break;

            case "prev":
                toRet="PV";
                break;

            case "fattura":
                toRet="FT";
                break;
        }

        String cd = String.valueOf(new Date().getTime());
        String code=cd.substring(cd.length()-8);

        return toRet+code;
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
}
