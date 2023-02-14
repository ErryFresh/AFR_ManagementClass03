<%@ page import="ENTITY.Documento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Documenti</title>
  <%
    List<Documento> doc = null;
    Documento d = null;
    if(request.getAttribute("Documenti")!=null)
    {
      doc = (List<Documento>) request.getAttribute("Documenti");
    }
    else{
      d = (Documento) request.getAttribute("DocumentoTrovato");
    }
  %>

  <%@include file="/view/component/Head.html"%>
  <link rel="stylesheet" href="view/css/magazzinoEDocumenti.css">
</head>
<body style="background: #555555">
<%@include file="/view/component/NavBar.jsp"%>
<section class="home">
    <div class="divBottoni">
      <button class ="but" onclick="location.href='Documenti'">Aggiungi</button>
      <button class ="but">Modifica</button>
      <button class ="but">Rimuovi</button>
    </div>
    <table>
      <tr style="border: 1px solid black;
            text-align: center">
        <th class="Bordo">Seleziona</th>
        <th class="Bordo">Codice</th>
        <th class="Bordo">Tipo</th>
        <th class="Bordo">Data emissione</th>
        <th class="Bordo">Note</th>
        <th class="Bordo">Codice Fiscale</th>
        <th class="Bordo">Matricola</th>
      </tr>
      <%
        if(doc!=null){
          for(int i = 0; i<doc.size();i++) { %>
      <tr style="border: 1px solid black;
            text-align: center">
        <td class="Bordo"> <input type="checkbox"> </td>
        <td class="Bordo"> <%=doc.get(i).getnDocumento()%> </td>
        <td class="Bordo"> <%=doc.get(i).getTipo()%> </td>
        <td class="Bordo"> <%=doc.get(i).getEmissione()%> </td>
        <td class="Bordo"> <%=doc.get(i).getNote()%> </td>
        <td class="Bordo"> <%=doc.get(i).getCf()%> </td>
        <td class="Bordo"> <%=doc.get(i).getMatricola()%> </td>
      </tr>
      <%}
      }
      else if(d!=null){%>
      <tr style="border: 1px solid black;
            text-align: center">
        <td class="Bordo"> <input type="checkbox"> </td>
        <td class="Bordo"> <%=d.getnDocumento()%> </td>
        <td class="Bordo"> <%=d.getTipo()%> </td>
        <td class="Bordo"> <%=d.getEmissione()%> </td>
        <td class="Bordo"> <%=d.getNote()%> </td>
        <td class="Bordo"> <%=d.getCf()%> </td>
        <td class="Bordo"> <%=d.getMatricola()%> </td>
      </tr>
      <%}%>
    </table>
    <div class="divRicerca" style="font-size: 20px;">
      <form class="example" action="RicercaDocumento">
        <input type="text" placeholder="Search by id..." name="search">
        <button type="submit"><i class="fa fa-search"></i></button>
      </form>
      <input type="checkbox" class="Filtri"> <label>Fattura</label>
      <br> <input type="checkbox" class="Filtri"> <label>Documento di trasporto</label>
      <br> <input type="checkbox" class="Filtri"> <label>Preventivo</label>
      <br> <input type="button" class="BottoniFiltri1" value="Rimuovi">
      <input type="button" class="BottoniFiltri2" value="Applica">
    </div>

</section>
</body>
</html>