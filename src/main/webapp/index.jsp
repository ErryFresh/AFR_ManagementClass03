<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AFR Management</title>
    <link rel="icon" href="img/LOGO.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
</head>
<body class="hero d-flex" style="justify-content: center;margin-top: 15vh">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<div class="d-flex  align-content-stretch flex-wrap">
    <div class="d-flex flex-column">
        <div class="p-2" >
            <h1 style="color: white;font-size: 60pt">WORK</h1>
        </div>
        <div class="p-2">
            <h1 style="color: white;font-size: 60pt">TOGETHER</h1>
        </div>
        <div class="p-2">
            <h1 style="color: white;font-size: 60pt">FOR A</h1>
        </div>
        <div class="p-2">
            <h1 style="color: white;font-size: 60pt">BETTER PLACE  |</h1>
        </div>
    </div>
    <div class="d-flex">
        <div class="login-container">
            <form action="login" method="post">
                <img src="img/LOGO.png">
                <h2>AFR MANAGEMENT</h2>
                <div class="input-div one focus">
                    <div class="i">
                        <i class="fas fa-user"></i>
                    </div>
                    <div>
                        <input class="input" name = "usr" type="text" placeholder="Username..." required>
                    </div>
                </div>
                <div class="input-div two">
                    <div class="i">
                        <i class="fas fa-lock"></i>
                    </div>
                    <div>
                        <input class="input" name = "psw" type="password" placeholder="Password..." required>
                    </div>
                </div>
                <a href="#">Password dimenticata?</a>
                <input type="submit" class="btn" value="Login">
                <%Boolean incorrect = (Boolean) request.getAttribute("msg");
                    if(incorrect!=null)
                        if(incorrect == true){%>
                            <p style="color: red">USERNAME o PASSWORD non validi!</p>
                       <% }%>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</div>
</body>
</html>