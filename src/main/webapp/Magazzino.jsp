<%@ page import="java.util.List" %>
<%@ page import="ENTITY.Scaffale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function updateTextInput(val) {
            document.getElementById('textInput').value=val;
        }
    </script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Magazzino</title>
    <%List<Scaffale> scaf = (List<Scaffale>) request.getAttribute("Scaffali");%>
    <link rel="stylesheet" href="view/css/magazzinoEDocumenti.css">
    <%@include file="/view/component/NavBar.jsp"%>
</head>
<body style="background: #555555">
<section class="home">
     <div class="text">
        <div class="divBottoni">
            <button class ="but" style="font-size: 15px" onclick="window.location.href='formProdotto.jsp'">Aggiungi Prodotto</button>
            <button class ="but" style="font-size: 15px">Modifica Prodotto</button>
            <button class ="but" style="font-size: 15px">Rimuovi Prodotto</button>
            <button class ="but" style="font-size: 15px">Aggiungi Magazzino</button>
            <button class ="but" style="font-size: 15px">Modifica Magazzino</button>
            <button class ="but" style="font-size: 15px">Rimuovi Magazzino</button>
            <button class ="but" style="font-size: 15px">Aggiungi Scaffale</button>
            <button class ="but" style="font-size: 15px">Modifica Scaffale</button>
            <button class ="but" style="font-size: 15px">Rimuovi Scaffale</button>
        </div>
        <table>
            <tr style="border: 1px solid black;
            text-align: center">
                <th class="Bordo">Seleziona</th>
                <th class="Bordo">Codice</th>
                <th class="Bordo">Nome</th>
                <th class="Bordo">Descrizione</th>
                <th class="Bordo">Superfice occupata</th>
                <th class="Bordo">Superfice disponibile</th>
                <th class="Bordo">Codice magazzino</th>
            </tr>
            <% for(int i = 0; i<scaf.size();i++) { %>
            <tr style="border: 1px solid black;
            text-align: center">
                <td class="Bordo"> <input type="checkbox"> </td>
                <td class="Bordo"> <%=scaf.get(i).getCodiceScaffale()%> </td>
                <td class="Bordo"> <%=scaf.get(i).getNome()%> </td>
                <td class="Bordo"> <%=scaf.get(i).getDescrizione()%> </td>
                <td class="Bordo"> <%=scaf.get(i).getSurOccupata()%> </td>
                <td class="Bordo"> <%=scaf.get(i).getSurDisponibile()%> </td>
                <td class="Bordo"> <%=scaf.get(i).getCodiceMagazzino()%> </td>
            </tr>
            <%}%>
        </table>
        <div class="divRicerca" style="font-size: 20px;">
            <form class="example">
                <input type="text" placeholder="Search.." name="search2">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
            <label>Superfice disponibile: </label>
            <input type="range" min="0" max="500" value="0" step="50" onchange="updateTextInput(this.value);">
            <label>Valore superfice: <input type="text" id="textInput" value="0" class="Valore" readonly></label>
            <br> <input type="button" class="BottoniFiltri1" value="Rimuovi" style="">
            <input type="button" class="BottoniFiltri2" value="Applica">
        </div>
     </div>
</section>
</body>
</html>
