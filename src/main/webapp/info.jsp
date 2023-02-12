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
              <h5>Angelo</h5>
              <h5>Nazzaro</h5>
              <i class="far fa-edit mb-5"></i>
            </div>
            <div class="col-md-8">
              <div class="card-body p-4">
                <h6>Informazioni</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Matricola</h6>
                    <p class="text-muted">49589345</p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Reparto</h6>
                    <p class="text-muted">Panettiere</p>
                  </div>
                </div>
                <h6>Contatti</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Email</h6>
                    <p class="text-muted">nazzaro@panificioAmore.it</p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Recapito</h6>
                    <p class="text-muted">+39 3711780696</p>
                  </div>
                </div>
                <div class="d-flex justify-content-start">
                  <a href="#!"><i class="fab fa-facebook-f fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-twitter fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-instagram fa-lg"></i></a>
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
