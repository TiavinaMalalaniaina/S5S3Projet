<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<table class="table">
    <thead>
    <tr>
        <th>Designation</th>
        <th>Petit</th>
        <th>Grand</th>
    </tr>
    </thead>
    <tbody>
        <% for(Meuble meuble : model.meubles){ %>
         <tr>
            <td><%= meuble.getStyleNom() + " " + meuble.getCategorieNom() %></td> 
            <td><%= meuble.getPetit()%></td> 
            <td><%= meuble.getGrand()%></td> 
        </tr>
      <%  } %>
    </tbody>
</table>
