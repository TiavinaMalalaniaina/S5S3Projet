<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>
<form method="post" action="CheckServlet">
    <!-- Champ ID -->
    <div class="form-group">
        <label for="id">ID:</label>
        <input type="text" class="form-control" id="id" name="id" placeholder="Entrez l'ID">
    </div>

    <!-- Champ Nom -->
    <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" class="form-control" id="nom" name="nom" placeholder="Entrez le nom">
    </div>
    

    
    <!-- Champ Date de Naissance -->
    <div class="form-group">
        <label for="dtn">Date de Naissance:</label>
        <input type="date" class="form-control" id="dtn" name="dtn">
    </div>

    <!-- Champ Salaire -->
    <div class="form-group">
        <label for="salaire">Salaire:</label>
        <input type="text" class="form-control" id="salaire" name="salaire" placeholder="Entrez le salaire">
    </div>

    <!-- Champ Heure -->
    <div class="form-group">
        <label for="heure">Heure:</label>
        <input type="time" class="form-control" id="heure" name="heure">
    </div>

    <!-- Champ Date et Heure -->
    <div class="form-group">
        <label for="dateHeure">Date et Heure:</label>
        <input type="datetime-local" class="form-control" id="dateHeure" name="dateHeure">
    </div>

    <!-- Champ Marié -->
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="marie" name="marie">
        <label class="form-check-label" for="marie">Marié</label>
    </div>
    
    <div class="form-group">
        <label for="id_label_single">Select avec recherche</label>
        <select name="research-select" class="js-example-basic-single form-control" id="id_label_single">
            <option value="1">Value 1</option>
            <option value="1">Value 1</option>
            <option value="1">Value 1</option>
        </select>
    </div>
    

    <div class="form-group">
        <label for="id_label_multiple">
          Click this to highlight the multiple select element
        </label>
        <select name="multiple-select" class="js-example-basic-multiple js-states form-control" id="id_label_multiple" multiple="multiple">
        <option value="1">Value 1</option>
        <option value="2">Value 1</option>
        <option value="3">Value 1</option>
      </select>
    </div>

    <!-- Bouton Soumettre -->
    <button type="submit" class="btn btn-primary">Soumettre</button>
</form>
