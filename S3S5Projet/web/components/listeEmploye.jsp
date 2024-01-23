<%@page import="models.Employe"%>
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
        <th>Nom & prénom</th>
        <th>Salaire</th>
        <th>Ancienneté</th>
        <th>Poste</th>
    </tr>
    </thead>
    <tbody>
        <% for(Employe m : model.employes) { %>
         <tr>
             <td><%= m.getNom() %></td>
             <td><%= m.getSalaire() %></td>
             <td><%= m.getAnciennete()%></td>
             <td><%= m.getPoste() %></td>
        </tr>
      <%  } %>
    </tbody>
</table>
