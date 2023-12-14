<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="POST" action="SaveStyle">
        <div class="form-group">
        <label for="nom">Style:</label>
        <input type="text" class="form-control" id="nom" name="nom" placeholder="Entrez vos choix">
    </div>
    <div class="form-group">
        <label for="id_label_multiple">
          Click this to highlight the multiple select element
        </label>
        <select name="materielId" class="js-example-basic-multiple js-states form-control" id="id_label_multiple" multiple="multiple">
    <% for(Materiel materiel : model.materiels){ %>
        <option value="<%= materiel.getId()%>"><%= materiel.getNom() %></option>
   <% } %>
      </select>
    </div>
   
  
    <input type="submit" value="Valider">
</form>