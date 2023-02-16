<%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 12/02/2023
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Documento</title>
    <%@include file="view/component/Head.html"%>
  <script>
    function add(){
      var table=document.getElementById("components");
      var priceTable=document.getElementById("prices");

      var toSend = document.getElementById("toSend").value;

      var row = table.insertRow(table.rows.length);
      var priceRow = priceTable.insertRow(priceTable.rows.length);

      document.getElementById("order").style.display="block";
      document.getElementById("tot").style.display = "block";

      var articolo = document.getElementById("artSel");
      articolo = articolo.value;

      var nome = articolo.split("-")[1];
      var prezzo = articolo.split("-")[2];

      var cell1 = nome;
      var cell2 = document.getElementById("larg").value;
      var cell3 = document.getElementById("alt").value;
      var cell4 = document.getElementById("pcs").value;
      var cell5 = prezzo;
      var cell6 = cell2*cell3*cell4*cell5;

      toSend+=articolo.split("-")[0]+":"+cell2+":"+cell3+":"+cell4+":"+cell5+":"+cell6+"/";

      document.getElementById("toSend").value = toSend;

      row.insertCell(0).innerHTML = cell1;
      row.insertCell(1).innerHTML = cell2;
      row.insertCell(2).innerHTML = cell3;
      row.insertCell(3).innerHTML = cell4;
      priceRow.insertCell(0).innerHTML = cell5 +"€";
      priceRow.insertCell(1).innerHTML = cell6 +"€";

      tot = document.getElementById("tot").innerHTML.split(":")[1];
      tot = parseInt(tot)+parseInt(cell6);
      document.getElementById("tot").innerHTML="Complessivo:"+tot;
    }

    function chk(val){
      if(val.value == "ddt"){
          document.getElementById("prices").style.display = "none";
          document.getElementById("tot").style.display = "none";
      }
      else{
          document.getElementById("prices").style.display = "inline-block";
          document.getElementById("tot").style.display = "block";
      }
    }
  </script>

  <style>
    #order{
      border-top: dashed 1px gray;
    }

    table{
      display: inline-block;
      text-align: center;
      font-size: 2rem;
      width: auto;
    }

    th, td{
      padding: 0px 1rem;
    }

  </style>
</head>
<body>
<%@include file="/view/component/NavBar.jsp"%>
<section class="vh-100 home" style="background: linear-gradient(to right,#1F1F1F,#787878);">
  <div class="container-fluid py-5 h-100 text">
    <div class="row  justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row d-flex justify-content-center align-items-center">
            <form action="AggiuntaDocumento" method="post">
              <input type="hidden" name="document" id="toSend" value="">

              <div class="container" style="background: linear-gradient(to right,#FF5418,#F9D213)">
                <h1 style="text-align: center;color:black; " >Aggiungi Documento</h1>
              </div>
              <div class="row pt-1">
                <div class="col-4 mb-3">
                  <h3>Tipo Documento</h3>
                  <div class="form-group">
                    <select name="tipo" class="form-control form-control-lg" onchange="chk(this)" required>
                      <option value="ddt">Documento di trasporto</option>
                      <option value="prev" selected>Preventivo</option>
                      <option value="fattura">Fattura</option>
                    </select>
                  </div>
                </div>

                <div class="col-3 mb-3">
                  <h3>Data Emissione</h3>
                    <input type="date" name="data" id="date" class="form-control-lg">
                </div>

                <div class="col-4 mb-3">
                  <h3>Dipendente</h3>
                    <div>
                      <input type="text"  id="dipendente" class="form-control-lg" disabled value="${mat}">
                    </div>
                </div>

                <div class="col-4 mb-3">
                  <h3>Destinatario</h3>
                  <div>
                    <select name="cf" class="form-control form-control-lg" required>
                      ${cf}
                    </select>
                  </div>
                </div>
              </div>
              <div class="col">
                <h3 style="text-align: center">Note</h3>
                <textarea class="form-control" name="note" aria-label="With textarea"></textarea>
              </div>

              <div class="col-4 mb-3">
                <h3>Articoli</h3>
                <div>
                  <select name="art" id="artSel" class="form-control form-control-lg" required>
                    ${articoli}
                  </select>
                </div>
              </div>


              <div class="row pt-1">
                <div class="col-4 mb-3">
                  <h3>Base</h3>
                  <div>
                    <input type="text"  id="larg" class="form-control-lg" value="1">
                  </div>
                </div>

                <div class="col-4 mb-3">
                  <h3>Altezza</h3>
                  <div>
                    <input type="text"  id="alt" class="form-control-lg" value="1">
                  </div>
                </div>

                <div class="col-4 mb-3">
                  <h3>Pezzi</h3>
                  <div>
                    <input type="number"  id="pcs" class="form-control-lg" value="1">
                  </div>
                </div>
              </div>

              <p class="btn btn-success btn-lg" onclick="add()">Aggiungi</p>

              <div id="order" class="col" style="display: none">
                <table id="components">
                  <tr>
                    <th>Articolo</th>
                    <th>Qta</th>
                    <th>Lunghezza</th>
                    <th>Larghezza</th>
                  </tr>
                </table>

                <table id="prices">
                 <tr>
                   <th>Costo</th>
                   <th>Totale</th>
                 </tr>
                </table>
                <p id="tot" style="display: none">Complessivo:0</p>
              </div>
              <div class="container bg-light">
                <div class="col-md-12 text-center">
                  <button type="submit" class="btn btn-success btn-lg">Conferma</button>
                  <a href="home.jsp">
                    <button type="button" class="btn btn-danger btn-lg">Elimina</button>
                  </a>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script>date.max = new Date().toISOString().split("T")[0];</script>
</body>
</html>
