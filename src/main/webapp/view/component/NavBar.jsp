<%@ page import="ENTITY.Dipendente" %><%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 08/02/2023
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="it">
<head>
    <%@include file="Head.html"%>
    <link rel="stylesheet" href="view/css/navbar.css">

    <%Dipendente connected = (Dipendente) session.getAttribute("dipendente");%>
</head>
<body>
<nav class="sidebar close">
    <header>
        <div class="image-text">
                <span class="image">
                    <img src="view/css/img/LOGO.png" alt="logo">
                </span>

            <div class="text header-text">
                <span class="name"><%=connected.getNome() +" "+ connected.getCognome()%></span>
                <span class="profession"><%=connected.getPosizione()%></span>
            </div>
        </div>

        <i class='bx bx-chevrons-right toggle'></i>
    </header>

    <div class="menu-bar">
        <div class="menu">
            <li class="search-box">
                <i class='bx bx-search-alt icon' ></i>
                <input type="text" placeholder="Ricerca...">
            </li>

            <li class="nav-link">
                <a href="page?dest=home">
                    <i class='bx bxs-home-smile icon'></i>
                    <span class="text nav-text">Home</span>
                </a>
            </li>
            <li class="nav-link">
                <a href="<%= request.getContextPath()%>/info.jsp">
                    <i class='bx bx-info-circle icon'></i>
                    <span class="text nav-text">Info</span>
                </a>
            </li>
            <li class="nav-link">

                <a href="page?dest=documenti">

                    <i class='bx bxs-file-doc icon' ></i>
                    <span class="text nav-text">Documenti</span>
                </a>
            </li>
            <li class="nav-link">
                <a href="page?dest=pagamenti">
                    <i class='bx bxs-badge-dollar icon' ></i>
                    <span class="text nav-text">Pagamenti</span>
                </a>
            </li>
            <li class="nav-link">
                <a href="page?dest=magazzino">
                    <i class='bx bxs-component icon'></i>
                    <span class="text nav-text">Magazzino</span>
                </a>
            </li>
            <li class="nav-link">
                <a href="page?dest=cf">
                    <i class='bx bxs-user icon' ></i>
                    <span class="text nav-text">Clienti</span>
                </a>
            </li>

        </div>

        <div class="bottom-content">
            <li class="">
                <a href="<%= request.getContextPath()%>/contactUs.jsp">
                    <i class='bx bxs-help-circle icon'></i>
                    <span class="text nav-text">Help</span>
                </a>
            </li>
            <li class="">
                <a href="<%= request.getContextPath()%>/login">
                    <i class='bx bx-log-out icon'></i>
                    <span class="text nav-text">Logout</span>
                </a>
            </li>
        </div>
    </div>
</nav>
<script src="view/js/main.js"></script>
</body>
</html>
