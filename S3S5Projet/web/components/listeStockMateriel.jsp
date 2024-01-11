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
        <th>Stock</th>
    </tr>
    </thead>
    <tbody>
        <% for(Materiel materiel : model.materiels){ %>
         <tr>
            <td><%= materiel.getNom() %></td> 
            <td><%= materiel.getQuantite()%></td> 
        </tr>
      <%  } %>
    </tbody>
</table>
