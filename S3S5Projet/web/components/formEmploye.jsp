<%@page import="models.TypeEmploye"%>
<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="SaveEmploye">
    <div class="form-group">
        <label for="nom">Nom: </label>
        <input type="text" class="form-control" id="nom" name="nom" placeholder="Saisissez le nom ...">
    </div>
    <div class="form-group">
        <label for="nom">Date de naissance</label>
        <input type="date" class="form-control" id="nom" name="dateNaissance" placeholder="Saisissez la date de naissance ...">
    </div>
    <div class="form-group">
        <label for="nom">Date d'embauche</label>
        <input type="date" class="form-control" id="nom" name="dateEmbauche" placeholder="Saisissez la date de naissance ...">
    </div>
    <div class="form-group">
        <label for="nom">Salaire de base</label>
        <input type="number" step="2" class="form-control" id="nom" name="salaireBase" placeholder="Saisissez le salaire de base ...">
    </div>
    <div class="form-group">
        <label for="id_label_multiple">
          Poste(ouvrier):
        </label>
        <select name="typeEmployeId" class="js-example-basic-single js-states form-control" id="id_label_multiple">
            <% for(TypeEmploye t : model.typeEmployes){ %>
            <option value="<%= t.getId()%>"><%= t.getNom() %></option>
        <% } %>
        </select>
    </div>
    
      <input class="btn btn-primary" type="submit" value="Valider">
</form>