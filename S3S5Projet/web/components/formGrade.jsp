<form method="GET" action="UpdateGrade">
    <div class="form-group">
        <label for="nom">GRADE:</label>
        <select name="id" class="form-control">
            <option value="1">Ouvrier</option>
            <option value="2">Senior</option>
            <option value="3">Expert</option>
        </select>
    </div>
    <div class="form-group">
        <label for="nom">Annee d'experience:</label>
        <input type="number" class="form-control" id="nom" name="annee" placeholder="...">
    </div>
    <div class="form-group">
        <label for="nom">Taux horaire:</label>
        <input type="number" class="form-control" id="nom" name="taux_horaire" placeholder="...">
    </div>
    <input class="btn btn-primary" type="submit" value="Valider">
 </form>