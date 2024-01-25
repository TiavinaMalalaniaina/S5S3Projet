<nav id="sidebar">
    <div class="custom-menu">
        <button type="button" id="sidebarCollapse" class="btn btn-primary">
            <i class="fa fa-bars"></i>
            <span class="sr-only">Toggle Menu</span>
        </button>
    </div>
    <div class="p-4 pt-5">
        <h1><a href="index.html" class="logo">Aria</a></h1>
        <ul class="list-unstyled components mb-5">
            <li>
                <a href="#meuble" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">MEUBLES</a>
                <ul class="collapse list-unstyled" id="meuble">
                     <li>
                        <a href="FormMeuble">Cr�ation</a>
                    </li>
                    <li>
                        <a href="FormBuildMeuble">Construction</a>
                    </li>
                    <li>
                        <a href="ListMeubleFiltre?min=0&max=9999999999">Prix de revient</a>
                    </li>
                    <li>
                        <a href="ListMeubleFiltreBenef?min=0&max=999999999">B�n�fice</a>
                    </li>
                    <li>
                        <a href="ListeStockMeuble">Stock</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#materiel" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">MATERIEL</a>
                <ul class="collapse list-unstyled" id="materiel">
                     <li>
                        <a href="FormMateriel">Cr�ation</a>
                    </li>
                    <li>
                        <a href="FormAddMateriel">Ajout</a>
                    </li>
                    <li>
                        <a href="ListMeuble?materielId=0">Meuble</a>
                    </li>
                    <li>
                        <a href="ListeStockMateriel">Stock</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#style" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">STYLE</a>
                <ul class="collapse list-unstyled" id="style">
                     <li>
                        <a href="FormStyle">Cr�ation</a>
                    </li>
                    <li>
                        <a href="ListType?style=0">Mat�riel</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#employe" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">EMPLOYE</a>
                <ul class="collapse list-unstyled" id="employe">
                     <li>
                        <a href="FormTypeEmploye">Cr�ation de poste</a>
                    </li>
                     <li>
                        <a href="FormEmploye">Cr�ation</a>
                    </li>
                     <li>
                        <a href="ListEmploye">Listes</a>
                    </li>
                     <li>
                        <a href="FormGrade">Graduation</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>