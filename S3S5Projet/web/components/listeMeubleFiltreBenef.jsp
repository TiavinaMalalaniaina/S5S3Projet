<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="ListMeubleFiltreBenef">
    <div class="form-group">
        <label for="nom">Min:</label>
        <input type="number" class="form-control" id="nom" name="min" placeholder="Entrez le prix minimal">
    </div>
    <div class="form-group">
        <label for="nom">Max:</label>
        <input type="number" class="form-control" id="nom" name="max" placeholder="Entrez le prix maximal">
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
            <td><%= meuble.getBenefice_petit()%></td> 
            <td><%= meuble.getBenefice_grand() %></td> 
        </tr>
      <%  } %>
    </tbody>
</table>
