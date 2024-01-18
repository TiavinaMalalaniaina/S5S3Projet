<%@page import="models.TypeEmploye"%>
<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="POST" action="SaveMeubleEmploye">
    <input type="hidden" name="meubleId" value="<%= model.meubleId %>"/>
    <div class="form-group">
        <label for="id_label_multiple">
          Personnel:
        </label>
        <select name="type_employe_id" class="js-example-basic-single js-states form-control" id="id_label_multiple">
            <% for(TypeEmploye materiel : model.typeEmployes){ %>
            <option value="<%= materiel.getId()%>"><%= materiel.getNom() %></option>
            <% } %>
        </select>
    </div>
    <div class="form-group">
        <label for="nom">Nombre de personne(petit):</label>
        <input type="number" class="form-control" id="nom" name="nb_personne" placeholder="Saisissez la quantite ...">
    </div>
    <div class="form-group">
        <label for="nom">Nombre d'heure:</label>
        <input type="number" class="form-control" id="nom" name="heure_travail" placeholder="Saisissez la quantite ...">
    </div>
      <input class="btn btn-primary" type="submit" value="Valider">
</form>
<a href="/S3S5Projet/FormMeuble">
    <button class="btn btn-secondary">Terminer</button>
</a> 