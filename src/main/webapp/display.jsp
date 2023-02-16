<%@ page import="ENTITY.Documento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="view/css/shower.css">
  <title>${name}</title>
  <%
    String payload = request.getAttribute("payload").toString();
  %>
  <link rel="stylesheet" href="view/css/magEdoc.css">
  <%@include file="view/component/Head.html"%>


</head>
<body style="background: #555555">
<%@include file="/view/component/NavBar.jsp"%>
<section class="intro">
  <div>
    <div class="bg-image h-100" style="background: linear-gradient(to right bottom,#FF5418,#F9D213);">
    <div class="mask d-flex align-items-center h-100">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-12">
            <div class="card shadow-2-strong" style="background-color: #f5f7fa;">
              <div class="card-body">
                <div class="table-responsive">
                  <h2>${name}</h2>
                  <table class="search">
                    <tr>

                      <td colspan="${csp}"><input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search"></td>
                      <td>
                        <button type="button" class="btn me-2">Cerca</button>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <button type="button" class="btn me-2">Modifica</button>
                      </td>

                      <td>
                        <button type="button" class="btn me-2" onclick="location.href='<%= request.getContextPath()%>${adder}'">Aggiungi</button>
                      </td>

                      <td>
                        <button type="button" class="btn me-2">Rimuovi</button>
                      </td>
                      ${extraBtns}
                    </tr>
                  </table>
                  <%=payload%>
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