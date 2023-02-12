<%@ page import="ENTITY.Documento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>

    table tr{background-color: white;}

    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
      margin-left: 500px;
    }

    .but {
      font-size: 20px;
      background-color: white;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      margin: 4px 2px;
      border-radius: 12px;
      border: none;
    }

    .divRicerca{
      background-color: white;
      border: none;
      width: 400px;
      margin-left: 10px;
      margin-top: -3%;
      border-radius: 12px;
    }

    .divBottoni{
      margin-top: 150px;
      margin-left: 500px;
    }

    form.example input[type=text] {
      padding: 6px;
      width: 80%;
      font-size: 17px;
      border: 1px solid orangered;
      border-top: none;
      float: left;
      background: #f1f1f1;
      border-right: none;
      border-bottom-left-radius: 12px;
      outline:none;
    }

    form.example button {
      float: left;
      width: 20%;
      height: 2.95%;
      padding: 10px;
      background: #f1f1f1;
      color: orange;
      font-size: 17px;
      border: 1px solid orangered;
      border-left: none;
      border-top: none;
      cursor: pointer;
      border-bottom-right-radius: 12px;
    }

    form.example button:hover {
      background: white;
    }

    form.example::after {
      content: "";
      clear: both;
      display: table;
    }

    .example{
      width: 250px;
      margin-left: 18%;
    }

    .Filtri{
      margin-left: 30%;
    }

    .BottoniFiltri1{
      font-size: 20px;
      margin-left: 60%;
      margin-bottom: 2%;
      background-color: red;
      border-radius: 12px;
      border: none;
      color: white;
    }

    .BottoniFiltri2{
      font-size: 20px;
      background-color: orangered;
      border-radius: 12px;
      border: none;
      color: white;
    }

    .Bordo{
      border: 1px solid black;
    }

  </style>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  <%@include file="/view/component/NavBar.jsp"%>
</head>
<body style="background: #555555">
<section class="home">
  <div class="text">
    <div class="divBottoni">
      <button class ="but">Aggiungi</button>
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
      <br> <input type="button" class="BottoniFiltri1" value="Rimuovi" style="">
      <input type="button" class="BottoniFiltri2" value="Applica">
    </div>
  </div>
</section>
</body>
</html>