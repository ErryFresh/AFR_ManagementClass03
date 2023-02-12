<%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 09/02/2023
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AFR_Management</title>
    <%@include file="view/component/Head.html"%>
    <link rel="stylesheet" href="view/css/login.css">

</head>
<body>
 <div class="wrapper">
     <div class="container main">
        <div class="row">
            <div class="col-md-6 side-image">
                <div class="text">
                    <h1>WORK<br>TOGETHER<br>FOR A<br>BETTER PLACE</h1>
                </div>
            </div>
            <div class="col-md-6 right">
                <form action="login" method="post">
                    <div class="input-box">
                        <img src="view/css/img/LOGO.png">
                        <header>AFR Management</header>
                        <div class="input-field">
                            <input type="text" class="input" id="usr" name="usr" required autocomplete="off">
                            <label for="usr">Username...</label>
                        </div>
                        <div class="input-field">
                            <input type="password" class="input" id="psw" name="psw" required>
                            <label for="psw">Password...</label>
                        </div>
                        <div class="input-field">
                            <input type="submit" class="submit" value="Accedi">
                        </div>
                        <%Boolean incorrect = (Boolean) request.getAttribute("msg");
                            if(incorrect!=null)
                                if(incorrect == true){%>
                        <p class="error">USERNAME o PASSWORD non validi!</p>
                        <% }%>
                        <div class="remember">
                            <a href="<%= request.getContextPath()%>/contactUs.jsp">Password dimenticata?</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
     </div>
 </div>
</body>
</html>
