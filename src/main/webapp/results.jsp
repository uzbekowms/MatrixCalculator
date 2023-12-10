<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>Results</h1>
    <c:forEach var="item" varStatus="loop" items="${items}" >
      <span>${item}<sub><fmt:formatNumber value="${Math.floor(loop.index / 3 + 1)} " minFractionDigits="0" maxFractionDigits="0"/></sub><sub>${(loop.index % 3 + 1)} </sub></span>
        <c:if test="${((loop.index + 1) % 3) == 0}">
            <br>
        </c:if>
    </c:forEach>
  </body>
</html>
