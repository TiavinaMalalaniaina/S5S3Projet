<%@page import="models.ViewModel"%>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Date de Naissance</th>
        <th>Salaire</th>
        <th>Heure</th>
        <th>Date et Heure</th>
        <th>Marié</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>John Doe</td>
            <td>1990-01-01</td>
            <td><%= ViewModel.moneyFormat(50000) %></td>
            <td>09:00:00</td>
            <td>2022-01-01T12:00:00</td>
            <td>Oui</td>
        </tr>
        <tr>
            <td>1</td>
            <td>John Doe</td>
            <td>1990-01-01</td>
            <td>50000.00</td>
            <td>09:00:00</td>
            <td>2022-01-01T12:00:00</td>
            <td>Oui</td>
        </tr>
        <tr>
            <td>1</td>
            <td>John Doe</td>
            <td>1990-01-01</td>
            <td>50000.00</td>
            <td>09:00:00</td>
            <td>2022-01-01T12:00:00</td>
            <td>Oui</td>
        </tr>
    <!-- Ajoutez plus de lignes ici avec les données que vous avez -->
    </tbody>
</table>