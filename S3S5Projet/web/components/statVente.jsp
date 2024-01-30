<%@page import="models.VenteStat"%>
<%@page import="models.TypeEmploye"%>
<%@page import="models.Employe"%>
<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
    String[] genres = {"Homme", "Femme"};
%>
<a href="StatVente?meubleId=0">
    <button class="btn btn-primary"> Tous</button>
</a>
<form method="GET" action="StatVente">
    <div class="form-group">
        <select name="meubleId" class=" form-control" id="id_label_single">
            <% for(Meuble m : model.meubles){ %>
             <option value="<%= m.getId() %>"><%= m.getCategorieNom() %> <%= m.getStyleNom() %></option>
            <%  } %> 
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Valider</button>
</form>
           
<table class="table">
    <thead>
    <tr>
        <th>Nom</th>
        <th>Genre</th>
        <th>Nombre</th>
    </tr>
    </thead>
    <tbody>
        <% for(VenteStat m : model.venteStatAll){ %>
        <tr>
            <td><%= m.getCategorie_nom() %> <%= m.getStyle_nom()%></td>
            <td><%= m.getQuantite() %></td>
            <td><%= genres[m.getGenre_id()-1] %></td>
        </tr>
        <% } %> 
    </tbody>
</table>
<table class="table">
    <thead>
    <tr>
        <th>Genre</th>
        <th>Nombre</th>
    </tr>
    </thead>
    <tbody>
        <% for (int i=0; i<model.venteStat.size(); i++) { %>
        <tr>
            <td><%= genres[model.venteStat.get(i).getGenre_id()-1] %><td>
            <td><%= model.venteStat.get(i).getQuantite() %><td>
        </tr>
        <% } %>
    </tbody>
</table>
    <div style="width: 80%; margin: auto;">
        <canvas id="myPieChart"></canvas>
    </div>
        
        
<script>
var ctx = document.getElementById('myPieChart').getContext('2d');

const dataPie = [
<% for (VenteStat v : model.venteStat) { %>
        <%= v.getQuantite() %>,
<% } %>
]



var data = {
    labels: ['Homme', 'Femme'],
    datasets: [{
        data: dataPie,
        backgroundColor: ['red', 'yellow']
    }]
};

var options = {
    responsive: true,
    maintainAspectRatio: false
};

var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: data,
    options: options
});
</script>

