<%@page import="models.TypeEmploye"%>
<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="POST" action="SaveClient">
    <div class="form-group">
        <label for="nom">Nom: </label>
        <input type="text" class="form-control" id="nom" name="nom" placeholder="Saisissez le nom ...">
    </div>
    
    <div class="form-group">
        <label for="id_label_multiple">
          Genre:
        </label>
        <select name="genreId" class="js-example-basic-single js-states form-control" id="id_label_multiple">
            <option value="1">Homme</option>
            <option value="2">Femme</option>
        </select>
    </div>
    
      <input class="btn btn-primary" type="submit" value="Valider">
</form>