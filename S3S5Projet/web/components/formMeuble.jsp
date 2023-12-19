<%@page import="models.Categorie"%>
<%@page import="models.Style"%>
<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="POST" action="SaveMeuble">
      
    <div class="form-group">
        <label for="id_label_multiple">
          Styles:
        </label>
        <select name="style" class="js-example-basic-single js-states form-control" id="id_label_multiple">
        <% for(Style style : model.style){ %>
            <option value="<%= style.getId()%>"><%= style.getNom() %></option>
        <% } %>
      </select>
    </div>
    <div class="form-group">
        <label for="id_label_multiple">
          Categorie:
        </label>
        <select name="categorie" class="js-example-basic-single js-states form-control" id="id_label_multiple">
        <% for(Categorie categorie : model.categorie){ %>
            <option value="<%= categorie.getId_categorie() %>"><%= categorie.getNom_categorie() %></option>
        <% } %>
      </select>
    </div>
   
  
      <input class="btn btn-primary" type="submit" value="Valider">
</form>