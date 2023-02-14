<%@ page import="ENTITY.Calendario" %><%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 12/02/2023
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Aggiungi Evento</title>
  <%@include file="view/component/Head.html"%>

  <% Calendario c = (Calendario) request.getAttribute("cal");%>
</head>
<body>
<%@include file="view/component/NavBar.jsp"%>
<section class="vh-100 home" style="background: linear-gradient(to right,#1F1F1F,#787878)">
  <div class="container  justify-content-center align-items-center  py-5 h-100 text">
    <div class="row  justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row d-flex justify-content-center align-items-center">
            <form action="Eventi" method="post">
              <div class="container" style="background: linear-gradient(to right,#FF5418,#F9D213)">
                <h1 style="text-align: center;color:black; " >Aggiungi Evento</h1>
              </div>
              <div class="row pt-1">

                <div class="col-5 mb-5">
                  <h3>Data Evento</h3>
                  <input type="date" name="dataEv" id="date" class="form-control-lg">
                </div>
                <div class="col-5 mb-5">
                  <h3>Nome</h3>
                  <input type="text" name="nome" id="titolo" class="form-control-lg">
                </div>
              </div>


              <div class="col">
                <h3 style="text-align: center">Descrizione</h3>
                <textarea class="form-control" name="desc"  maxlength="400"></textarea>
                <input type="hidden" name="code" value="<%=c.getCodiceCal()%>">
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
</body>
</html>
