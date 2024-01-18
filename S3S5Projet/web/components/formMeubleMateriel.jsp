<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="SaveMeubleMateriel">
    <input type="hidden" name="meubleId" value="<%= model.meubleId %>">
    <div class="form-group">
        <label for="id_label_multiple">
          Materiel
        </label>
        <select name="materielId" class="js-example-basic-single js-states form-control" id="id_label_multiple">
        <% for(Materiel materiel : model.materiels){ %>
            <option value="<%= materiel.getId()%>"><%= materiel.getNom() %></option>
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
<a href="/S3S5Projet/FormMeubleEmploye?meuble=<%= model.meubleId %>">
    <button class="btn btn-secondary" type="submit">Terminer</button>
</a>  