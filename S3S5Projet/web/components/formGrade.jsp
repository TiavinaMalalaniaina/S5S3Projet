<form method="POST" action="UpdateGrade">
    <div class="form-group">
        <label for="nom">GRADE:</label>
        <select name="typeEmployeId" class="form-control">
            <option value="1">Ouvrier</option>
            <option value="2">Senior</option>
            <option value="3">Expert</option>
        </select>
    </div>
    <div class="form-group">
        <label for="nom">Annee d'experience:</label>
        <input type="number" class="form-control" id="nom" name="salaire" placeholder="Saisissez le prix...">
    </div>
    <div class="form-group">
        <label for="nom">Taux horaire:</label>
        <input type="number" class="form-control" id="nom" name="salaire" placeholder="Saisissez le prix...">
    </div>
    <input class="btn btn-primary" type="submit" value="Valider">
 </form>