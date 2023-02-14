<%@ page import="com.mysql.cj.Session" %><%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 12/02/2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Help</title>
    <%@include file="view/component/Head.html"%>
    <link rel="stylesheet" href="view/css/contactUs.css">
    <%Dipendente connectedContact = (Dipendente) session.getAttribute("dipendente");%>
</head>
<body>
<%if(connectedContact!=null){%>
<!--se é loggato esce la navbar-->
    <%@include file="view/component/NavBar.jsp"%>
<%}%>
<section class="home">
  <div class="container">
      <div class=" text contact-box">
          <div class="left"></div>
          <div class="right">
              <h2>Contattaci!</h2>
              <input type="text" class="field" placeholder="Matricola" required>
              <input type="text" class="field" placeholder="Oggetto" required>
              <textarea class="field" placeholder="Messaggio..." maxlength="400"></textarea>
              <button class="btn">Invia</button>
        </div>
      </div>
  </div>
</section>
</body>
</html>
