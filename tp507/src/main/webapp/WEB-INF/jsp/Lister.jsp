<h1>Liste des Étudiants</h1>
<ul>
    <c:forEach var="etudiant" items="${etudiants}">
        <li>${etudiant.nom} ${etudiant.prenom}</li>
    </c:forEach>
</ul>