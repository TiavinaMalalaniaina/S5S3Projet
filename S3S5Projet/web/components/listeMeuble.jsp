<%@page import="models.Meuble"%>
<%@page import="models.Materiel"%>
<%@page import="models.Style"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="GET" action="ListMeuble">
    <div class="form-group">
        <select name="materielId" class="js-example-basic-single form-control" id="id_label_single">
            <% for(Materiel materiel : model.materiels){ %>
             <option value="<%= materiel.getId() %>"><%= materiel.getNom() %></option>
            <%  } %> 
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Valider</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>Designation</th>
        <th>Petit</th>
        <th>Grand</th>
    </tr>
    </thead>
    <tbody>
        <% for(Meuble meuble : model.meubles){ %>
         <tr>
            <td><%= meuble.getStyleNom() + " " + meuble.getCategorieNom() %></td> 
            <td><%= meuble.getPetit() %></td> 
            <td><%= meuble.getGrand() %></td> 
        </tr>
      <%  } %>
    </tbody>
</table>
