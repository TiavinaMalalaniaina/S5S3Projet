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
        <select name="styleId" class="js-example-basic-single js-states form-control" id="id_label_multiple">
            <% for(Style style : model.styles){ %>
            <option value="<%= style.getId()%>"><%= style.getNom() %></option>
        <% } %>
      </select>
    </div>
    <div class="form-group">
        <label for="id_label_multiple">
          Categorie:
        </label>
        <select name="categorieId" class="js-example-basic-single js-states form-control" id="id_label_multiple">
            <% for(Categorie categorie : model.categories){ %>
            <option value="<%= categorie.getId()%>"><%= categorie.getNom() %></option>
        <% } %>
      </select>
    </div>
    <div class="form-group">
        <label for="id_label_multiple">
          Prix de vente petit:
        </label>
        <input type="text" class="form-control" id="nom" name="prix_vente_petit" placeholder="Saisissez le prix...">
    </div>
    <div class="form-group">
        <label for="id_label_multiple">
          Prix de vente grand:
        </label>
        <input type="text" class="form-control" id="nom" name="prix_vente_grand" placeholder="Saisissez le prix...">
    </div>
   
  
      <input class="btn btn-primary" type="submit" value="Valider">
</form>