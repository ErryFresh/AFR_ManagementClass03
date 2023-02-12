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
</head>
<body>
<%@include file="view/component/NavBar.jsp"%>
<section class="vh-100 home" style="background: linear-gradient(to right,#1F1F1F,#787878);">
  <div class="container-fluid py-5 h-100 text">
    <div class="row  justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row d-flex justify-content-center align-items-center">
            <form>
              <div class="container" style="background: linear-gradient(to right,#FF5418,#F9D213)">
                <h1 style="text-align: center;color:black; " >Aggiungi Documento</h1>
              </div>
              <div class="row pt-1">
                <div class="col-4 mb-3">
                  <h3>Tipo Documento</h3>
                  <div class="form-group">
                    <select class="form-control form-control-lg" required>
                      <option value="Amsterdam">DDT</option>
                      <option value="Washington">BOH</option>
                      <option value="Sydney">VAFFANCULO</option>
                      <option value="Beijing">VAFFANCULO</option>
                      <option value="Cairo">VAFFANCULO</option>
                    </select>
                  </div>
                </div>

                <div class="col-3 mb-3">
                  <h3>Data Emissione</h3>
                    <input type="date" name="" id="date" class="form-control-lg">
                </div>

                <div class="col-4 mb-3">
                  <h3>Docs</h3>
                    <div class=" custom-file">
                      <input type="file" class="custom-file-input form-control" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                    </div>
                </div>
              </div>
              <div class="col">
                <h3 style="text-align: center">Descrizione</h3>
                <textarea class="form-control" aria-label="With textarea"></textarea>
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
