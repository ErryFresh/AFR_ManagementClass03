<%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 11/02/2023
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info utente</title>
    <%@include file="view/component/Head.html"%>
    <link rel="stylesheet" href="view/css/info.css">
    <%Dipendente connectedContact = (Dipendente) session.getAttribute("dipendente");%>
</head>
<body>
<%@include file="view/component/NavBar.jsp"%>
<section class="vh-100 home" style="background: linear-gradient(to right,#1F1F1F,#787878);">
  <div class="container py-5 h-100 text">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row g-0">
            <div class="col-md-4 gradient-custom text-center text-white"
                 style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
              <img src="view/css/img/angelo.jpg"
                   alt="Avatar" class="img-fluid my-5" style="width: 80px;border-radius: 50%" />

              <h5><%=connectedContact.getNome()%></h5>
              <h5><%=connectedContact.getCognome()%></h5>
            </div>
            <div class="col-md-8">
              <div class="card-body p-4">
                <h6>Informazioni</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Matricola</h6>
                    <p class="text-muted"><%=connectedContact.getMatricola()%></p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Reparto</h6>
                    <p class="text-muted"><%=connectedContact.getCodiceRep()%></p>
                  </div>
                </div>
                <h6>Contatti</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Email</h6>
                    <p class="text-muted"><%=connectedContact.getEmail()%></p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Recapito</h6>
                    <p class="text-muted"><%=connectedContact.getRecapito()%></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>
