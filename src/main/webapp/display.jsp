<%@ page import="ENTITY.Documento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>${name}</title>
  <%
    String payload = request.getAttribute("payload").toString();
  %>
  <%@include file="view/component/Head.html"%>
  <link rel="stylesheet" href="view/css/shower.css">
  <link rel="stylesheet" href="view/css/magEdoc.css">
</head>
<body style="background: #555555">
<%@include file="/view/component/NavBar.jsp"%>
<section class=" home intro">
  <div>
    <div class="bg-image h-100">
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
                        <button type="button" class="btn me-2">Aggiungi</button>
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