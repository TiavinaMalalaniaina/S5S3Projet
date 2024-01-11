<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="ListMeubleFiltre">
    <div class="form-group">
        <label for="nom">Min:</label>
        <input type="number" class="form-control" id="nom" name="min" placeholder="Entrez le nom">
    </div>
    <div class="form-group">
        <label for="nom">Max:</label>
        <input type="number" class="form-control" id="nom" name="max" placeholder="Entrez le nom">
    </div>
    <button type="submit" class="btn btn-primary">Valider</button>
</form>
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
            <td><%= meuble.getPrix_petit()%></td> 
            <td><%= meuble.getPrix_grand()%></td> 
        </tr>
      <%  } %>
    </tbody>
</table>
