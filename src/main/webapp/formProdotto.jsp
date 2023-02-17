<%@ page import="LogicTier.GestioneProdotto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Prodotto</title>
  <%@include file="view/component/Head.html"%>
    <%GestioneProdotto gP = new GestioneProdotto();%>
    <script type="text/javascript" src="view/js/validaProdotto.js"></script>
</head>
<body>
<%@include file="view/component/NavBar.jsp"%>
<section class="vh-100 home" style="background: linear-gradient(to right,#1F1F1F,#787878);">
    <div class="container-fluid py-5 h-100 text">
        <div class="row  justify-content-center align-items-center h-100">
            <div class="col col-lg-6 mb-4 mb-lg-0">
                <div class="card mb-3" style="border-radius: .5rem;">
                   <div class="row d-flex justify-content-center align-items-center">
                       <form method="post" action="AggiungiProdotto">
                           <div class="container" style="background: linear-gradient(to right,#FF5418,#F9D213)">
                           <h1 style="text-align: center;color:black; " >Aggiungi prodotto</h1>
                           </div>

                           <div class="col">
                               <h3>Codice Articolo</h3>
                               <input name="codiceProdotto" class="form-control  form-control-lg" type="text" placeholder="codice" readonly value=<%=gP.generaChiaveProdotto()%>>
                           </div>
                           <div class="col">
                               <h3>Nome</h3>
                               <input name="nomeProdotto" id="nomeProdotto" class="form-control  form-control-lg" type="text" required>
                           </div>
                           <div class="col">
                               <h3>Descrizione</h3>
                               <textarea type="text" name="descrizioneProdotto" id="descrizioneProdotto" class="form-control  form-control-lg" rows="4" cols="80"></textarea>
                           </div>
                           <div class="row pt-1">
                               <div class="col-6 mb-3">
                                   <h3>Prezzo Vendita</h3>
                                   <input name="prezzoVendita" id="prezzoVendita" class="form-control form-control-lg" type="text" required>
                               </div>
                               <div class="col-6 mb-3">
                                   <h3>Prezzo Acquisto</h3>
                                   <input name="prezzoAcquisto" id="prezzoAcquisto" class="form-control  form-control-lg" type="text" required>
                               </div>
                           </div>
                           <div class="col">
                               <h3>Tipologia Vendita</h3>
                               <div class="form-group">
                                   <select name="tipologiaVendita" class="form-control form-control-lg" required>
                                       <option value="pz">Pezzo</option>
                                       <option value="mq">Metro Quadro</option>
                                       <option value="ml">Metro Lineare</option>
                                       <option value="kg">Kilo Grammo</option>
                                   </select>
                               </div>
                           </div>
                           <div class="container bg-light">
                               <div class="col-md-12 text-center">
                                   <button onclick="return(validateNewProduct())" type="submit" class="btn btn-success btn-lg">Conferma</button>
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
</body>
</html>
