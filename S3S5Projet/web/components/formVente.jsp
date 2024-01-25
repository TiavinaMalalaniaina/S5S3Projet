<%@page import="models.Client"%>
<%@page import="models.Meuble"%>
<%@page import="models.TypeEmploye"%>
<%@page import="models.Materiel"%>
<%@page import="models.ViewModel"%>
<%
    ViewModel model = (ViewModel) request.getAttribute("model");
%>

<form method="POST" action="SaveVente">
    
    <div class="form-group">
        <label for="id_label_multiple">
          Meuble: 
        </label>
        <select name="meubleId" class="js-example-basic-single js-states form-control">
            <% for(Meuble meuble : model.meubles) { %>
            <option value="<%=meuble.getId()%>"><%=meuble.getCategorieNom()%> <%=meuble.getStyleNom()%></option>
            <% } %>
        </select>
    </div>
    
    
    <div class="form-group">
        <label for="nom">Quantite </label>
        <input type="text" class="form-control" id="nom" name="quantite" placeholder="Saisissez le nom ...">
    </div>
    
    
    <div class="form-group">
        <label for="id_label_multiple">
          Client:
        </label>
        <select name="clientId" class="js-example-basic-single js-states form-control">
            <% for(Client client : model.clients) { %>
            <option value="<%=client.getId()%>"><%=client.getNom()%> </option>
            <% } %>
        </select>
    </div>
    
    <div class="form-group">
        <label for="id_label_multiple">
          Taille:
        </label>
        <select name="taille" class="js-states form-control">
            <option value="1">Petit</option>
            <option value="2">Grand</option>
        </select>
    </div>
    
      <input class="btn btn-primary" type="submit" value="Valider">
</form>