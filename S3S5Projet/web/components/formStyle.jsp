<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="POST" action="SaveStyle">
        <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" class="form-control" id="nom" name="nom" placeholder="Saisissez le nom ...">
    </div>
    <div class="form-group">
        <label for="id_label_multiple">
          Mat�riaux:
        </label>
        <select name="materielId" class="js-example-basic-multiple js-states form-control" id="id_label_multiple" multiple="multiple">
    <% for(Materiel materiel : model.materiels){ %>
        <option value="<%= materiel.getId()%>"><%= materiel.getNom() %></option>
   <% } %>
      </select>
    </div>
   
  
      <input class="btn btn-primary" type="submit" value="Valider">
</form>