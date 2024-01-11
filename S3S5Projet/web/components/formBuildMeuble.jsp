<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="SaveBuildMeuble">
    <div class="form-group">
        <label for="id_label_multiple">
          Meuble
        </label>
        <select name="meubleId" class="js-example-basic-single js-states form-control" id="id_label_multiple">
            <% for(Meuble meuble : model.meubles){ %>
            <option value="<%= meuble.getId()%>"><%= meuble.getCategorieNom() + " " + meuble.getStyleNom() %></option>
        <% } %>
      </select>
    </div>
    <div class="form-group">
        <label for="nom">Petit:</label>
        <input type="number" class="form-control" id="nom" name="petit" placeholder="Saisissez le nom ...">
    </div>
    <div class="form-group">
        <label for="nom">Grand:</label>
        <input type="number" class="form-control" id="nom" name="grand" placeholder="Saisissez le nom ...">
    </div>
      <input class="btn btn-primary" type="submit" value="Valider">
</form>