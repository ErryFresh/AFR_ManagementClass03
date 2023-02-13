<%@ page import="java.util.List" %>
<%@ page import="ENTITY.EventoCalendario" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Errico
  Date: 11/02/2023
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="/view/component/Head.html"%>>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script>
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawPie);
    google.charts.setOnLoadCallback(drawBar);
    google.charts.setOnLoadCallback(drawArea);

    function drawPie() {

    var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['Work',     11],
    ['Eat',      2],
    ['Commute',  2],
    ['Watch TV', 2],
    ['Sleep',    7]
    ]);

    var options = {
    title: 'My Daily Activities'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
    }


    function drawBar() {
    var data = google.visualization.arrayToDataTable([
    ["Element", "Density", { role: "style" } ],
    ["Copper", 8.94, "#b87333"],
    ["Silver", 10.49, "silver"],
    ["Gold", 19.30, "gold"],
    ["Platinum", 21.45, "color: #e5e4e2"]
    ]);

    var view = new google.visualization.DataView(data);
    view.setColumns([0, 1,
    { calc: "stringify",
    sourceColumn: 1,
    type: "string",
    role: "annotation" },
    2]);

    var options = {
    title: "Density of Precious Metals, in g/cm^3",
    width: 600,
    height: 400,
    bar: {groupWidth: "95%"},
    legend: { position: "none" },
    };
    var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
    chart.draw(view, options);
    }

    function drawArea() {
    var data = google.visualization.arrayToDataTable([
    ['Year', 'Sales', 'Expenses'],
    ['2013',  1000,      400],
    ['2014',  1170,      460],
    ['2015',  660,       1120],
    ['2016',  1030,      540]
    ]);

    var options = {
    title: 'Company Performance',
    hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
    vAxis: {minValue: 0}
    };

    var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
    chart.draw(data, options);
    }

    function readEvent(event){
        alert(event.getAttribute("name"));
    }
    </script>

    <style>
        .charts{
            height: 300px;
        }

        body{
            background-color: hotpink;
        }

        .col-md-6{
            background-color: transparent;
        }

        table{
            margin: 0 auto ;
            background-color: #ffffff;
            width: 350px;
            height: 350px;
            font-size:  larger;
            text-align: center;
        }

        td{
            border-radius: 30px;
        }
    </style>

</head>
<body>
<%@include file="/view/component/NavBar.jsp"%>

<section class="home">
    <div class="text">
        <div class="jumbotron" style="background: linear-gradient(to right,#FF5418,#F9D213)">
            <div class="container text-center">
                <h1>Benvenuto!</h1>
                <p>Rendi anche oggi un giorno migliore!</p>
            </div>
        </div>

        <div class="container-fluid bg-3 text-center">
            <h3>Overview</h3><br>
            <div class="row justify-content-center">
            <div class="col-md-6">
                <table>
                    <tr><th colspan="7">CALENDARIO</th></tr>
                    <tr>
                <%
                    List<EventoCalendario> list = (List<EventoCalendario>) request.getAttribute("eventi");

                    LocalDate date = LocalDate.now();

                    for(int i=1;i<=date.lengthOfMonth();i++){
                        String aux="";
                        if(list!=null)
                            for(EventoCalendario e : list){
                                if(Integer.parseInt(e.getData().split("-")[2])==i){
                                    aux="onclick='readEvent(this)' style=\"background-color: #d4a555 !important;\" name='"+e.getNome()+"\n"+e.getDescrizione()+"'";
                                }
                            }

                        %>
                            <td id="<%=i%>;" <%=aux%> ><%=i%></td>
                        <%
                        if (i%7==0){%>
                        </tr>
                        <tr>
                    <%}
                    }
                %>
                    <td colspan="<%=7-(date.lengthOfMonth()%7)%>" onmouseover="color(this, true)" onmouseout="color(this,false)"><a href="Eventi" style="text-decoration: none; color: black">AGGIUNGI</a></td>
                </tr>
                </table>
            </div>
            <div class="col-md-6">
                <p>Grafico 1</p>
                <div class="charts" id="piechart"></div>
            </div>
        </div>
        </div><br>

        <div class="container-fluid bg-4 text-center ">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <p>Grafico 2</p>
                    <div class="charts" id="columnchart_values"></div>
                </div>
                <div class="col-md-6">
                    <p>Grafico 3</p>
                    <div class="charts" id="chart_div"></div>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    show()

</script>
</body>
</html>
