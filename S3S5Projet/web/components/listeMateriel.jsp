<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="ListType">
    <div class="form-group">
        <select name="style" class="js-example-basic-single form-control" id="id_label_single">
            <% for(Style materiel : model.meubleType){ %>
             <option value="<%= materiel.getId() %>"><%= materiel.getNom() %></option>
            <%  } %> 
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Valider</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>Référence</th>
        <th>Désignation</th>
    </tr>
    </thead>
    <tbody>
        <% for(Materiel materiel : model.materiels){ %>
         <tr>
            <td><%= materiel.getId() %></td> 
            <td><%= materiel.getNom() %></td>             

        </tr>
      <%  } %>
    </tbody>
</table>
