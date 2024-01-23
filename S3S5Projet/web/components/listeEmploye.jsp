<%@page import="models.TypeEmploye"%>
<%@page import="models.Employe"%>
<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="ListEmploye">
    <div class="form-group">
        <select name="type" class=" form-control" id="id_label_single">
            <% for(TypeEmploye t : model.typeEmployes){ %>
             <option value="<%= t.getId() %>"><%= t.getNom() %></option>
            <%  } %> 
        </select>
    </div>
    <div class="form-group">
        <select name="poste" class="form-control" id="id_label_single">
             <option value="1">Ouvrier</option>
             <option value="2">Senior</option>
             <option value="3">Expert</option>
        </select>
    </div>
    
    <button type="submit" class="btn btn-primary">Valider</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>Nom & prénom</th>
        <th>Salaire</th>
        <th>Ancienneté</th>
        <th>Poste</th>
    </tr>
    </thead>
    <tbody>
        <% for(Employe m : model.employes) { %>
         <tr>
             <td><%= m.getNom() %></td>
             <td><%= m.getSalaire() %></td>
             <td><%= m.getAnciennete()%></td>
             <td><%= m.getPoste_employe() + " " + m.getGrade() %></td>
        </tr>
      <%  } %>
    </tbody>
</table>
