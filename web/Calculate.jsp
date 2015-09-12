

<!--<%@page import="mypackage.Statistics"%>-->
<%@page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: lionliliya
  Date: 31.08.15
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Результаты анкетирования</title>
  </head>
  <body>
    <p><h1 ALIGN=CENTER>Статистика по анкетам</h1></p>
    <p>Всего опрошеных лиц <em><%=mypackage.Statistics.getInstance().countElement()%></em>.</p>
    <h3>Статистика по именам</h3>
    <%for (Map.Entry<String, Integer> names :  mypackage.Statistics.getInstance().getNames().entrySet()) {%>
    <p>Имя: <em><%=names.getKey()%></em>, количество: <em><%=names.getValue()%></em></p>
    <%}%>
    <h3>Статистика по возрасту</h3>
    <%for (Map.Entry<String, Integer> ages :  mypackage.Statistics.getInstance().getAges().entrySet()) {%>
    <p>Возраст: <em><%=ages.getKey()%></em>, количество: <em><%=ages.getValue()%></em></p>
    <%}%>
    <h3>Статистика по полу</h3>
    <%for (Map.Entry<String, Integer> sex :  mypackage.Statistics.getInstance().getGender().entrySet()) {%>
    <p>Пол: <em><%=sex.getKey()%></em>, количество: <em><%=sex.getValue()%></em></p>
    <%}%>
    <h3>Статистика по опыту</h3>
    <%for (Map.Entry<String, Integer> exp :  mypackage.Statistics.getInstance().getExpert().entrySet()) {%>
    <p>Опыт работы в сфере IT: <em><%=exp.getKey()%></em>, встречается: <em><%=exp.getValue()%></em> раз</p>
    <%}%>
    <br>
    <h3 style="color: lightseagreen"><b>Соотношение опыта в сфере IT и возраста</b></h3>
   <%for( Map.Entry<String, String> enames : mypackage.Statistics.getInstance().getDependence().entrySet() ) {%>
      <p>Опыт работы в сфере IT: <%=enames.getKey()%> соотноситься с <%=enames.getValue()%></p>
    <%}%>
    <br>
    <a href="index.html">Назад к анкете</a>
  </body>
</html>
