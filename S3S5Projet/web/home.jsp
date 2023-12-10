
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
    String error = model.getError();
%>
<!doctype html>
<html lang="en">
    <head>
        <title>ARIA | ${title}</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="./images/favicon.ico" type="image/x-icon">
        <!--<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">-->
        <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">-->
        <link rel="stylesheet" href="http://localhost:8080/S3S5Projet/css/select2.min.css">
        <link rel="stylesheet" href="css/style.css">  <!-- Le CSS de la page si nécessaire -->
    </head>
    <style>
        .mycard {
            background-color: #f7f7f7;
        }
    </style>
    <body>
        <div class="wrapper d-flex align-items-stretch">
        <%@include file="templates/header.jsp" %>
            <div id="content" class="p-4 p-md-5 pt-5">
                
                <c:if test="${empty model.error}">
                    <div class="alert alert-danger collapse" role="alert">
                        ${model.error}
                    </div>
                </c:if>
                
                <c:if test="${not empty model.error}">
                    <div class="alert alert-danger" role="alert">
                        ${model.error}
                    </div>
                </c:if>
                
                <div class="card mycard">
                    
                <div class="card-body">
                    <h5 class="card-title">Table des Employés</h5>
                <!-- Page Content  -->
                    
                    <c:import url="${viewName}" />
                </div>
                    
                    
                </div>
            </div>
        <%--<%@include file="templates/footer.jsp" %>--%>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/select2.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>