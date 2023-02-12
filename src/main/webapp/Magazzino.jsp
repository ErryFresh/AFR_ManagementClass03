<%@ page import="java.util.List" %>
<%@ page import="ENTITY.Scaffale" %>
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
            margin-left: 50px;
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

        .Bordo{
            border: 1px solid black;
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

        .Valore{
            background: none;
            /*margin-left: 350px;
            margin-top: 50px;*/
            border: none;
            outline:none;
        }

    </style>

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
            <input type="range" min="0" max="500" value="0" onchange="updateTextInput(this.value);">
            <label>Valore superfice: <input type="text" id="textInput" value="0" class="Valore" readonly></label>
            <br> <input type="button" class="BottoniFiltri1" value="Rimuovi" style="">
            <input type="button" class="BottoniFiltri2" value="Applica">
        </div>
     </div>
</section>
</body>
</html>
