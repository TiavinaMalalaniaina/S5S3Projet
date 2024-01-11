<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="SaveAddMateriel">
    <div class="form-group">
        <label for="id_label_multiple">
          Materiel:
        </label>
        <select name="materielId" class="js-example-basic-single js-states form-control" id="id_label_multiple">
        <% for(Materiel materiel : model.materiels){ %>
            <option value="<%= materiel.getId()%>"><%= materiel.getNom() %></option>
        <% } %>
      </select>
    </div>
    <div class="form-group">
        <label for="nom">Quantité:</label>
        <input type="number" class="form-control" id="nom" name="quantite" placeholder="Saisissez la quantite ...">
    </div>
      <input class="btn btn-primary" type="submit" value="Valider">
</form>