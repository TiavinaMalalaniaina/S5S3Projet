<%@page import="meuble.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>


    <div class="form-group">
        <label for="nom">Style:</label>
        <input type="text" class="form-control" id="nom" name="nom" placeholder="Entrez vos choix">
    </div>
    <% for(Materiel materiel : model.materiels){ %>
      <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="bois" name="bois" value="<%= materiel.getId() %>">
        <label class="form-check-label"  for="marie"><%= materiel.getNom() %></label>
    </div>
   
   <% } %>
  
    <input type="button" value="Valider">
