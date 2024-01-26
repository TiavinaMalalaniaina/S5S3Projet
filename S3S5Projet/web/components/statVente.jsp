<%@page import="models.VenteStat"%>
<%@page import="models.TypeEmploye"%>
<%@page import="models.Employe"%>
<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
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

