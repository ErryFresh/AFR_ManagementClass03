<%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 12/02/2023
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Cliente/Fornitore</title>
    <%@include file="/view/component/Head.html"%>
    <link rel="stylesheet" href="view/css/magEdoc.css">
</head>
<body>
<%@include file="/view/component/NavBar.jsp"%>
<section class="home">
    <div class="container-fluid py-5 h-100 text">
        <div class="row  justify-content-center align-items-center h-100">
            <div class="col col-lg-6 mb-4 mb-lg-0">
                <div class="card mb-3" style="border-radius: .5rem;">
                    <div class="row d-flex justify-content-center align-items-center">
                        <form action="addClienteFornitore" method="post">
                            <div class="container" style="background: linear-gradient(to right,#FF5418,#F9D213)">
                                <h1 style="text-align: center;color:black; " > Aggiungi Cliente</h1>
                            </div>
                            <div class="col">
                                <h3>Codice Fiscale</h3>
                                <input class="form-control  form-control-lg" type="text" name="cf" placeholder="codice" pattern="^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$" required>
                            </div>
                            <div class="col">
                                <h3>Nome</h3>
                                <input class="form-control  form-control-lg" type="text" name="nome" pattern="^[a-zA-Z]{1,30}$" required>
                            </div>
                            <div class="col">
                                <h3>Cognome</h3>
                                <input class="form-control  form-control-lg" type="text" name="cognome" pattern="^[a-zA-Z]{1,50}$" required>
                            </div>
                            <div class="row pt-1">
                                <div class="col-6 mb-3">
                                    <h3>Recapito</h3>
                                    <input class="form-control form-control-lg" type="tel" name="tel" pattern="^\+(?:[0-9]?){6,14}[0-9]$" required>
                                </div>
                                <div class="col-6 mb-3">
                                    <h3>Email</h3>
                                    <input class="form-control  form-control-lg" type="email" name="eMail" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" required>
                                </div>
                            </div>
                            <div class="container bg-light">
                                <div class="col-md-12 text-center">
                                    <button type="submit" class="btn btn-success btn-lg">Conferma</button>
                                    <button type="button" class="btn btn-danger btn-lg" onclick="location.href='home.jsp'">Elimina</button>
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
