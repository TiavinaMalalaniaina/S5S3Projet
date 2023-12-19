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
            <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">STYLES</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="ListType?style=0">Liste</a>
                    </li>
                    <li>
                        <a href="FormStyle">Ajout de style</a>
                    </li>
                    <li>
                        <a href="FormMateriel">Ajout de materiel</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#otherComponent" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">EXAMPLES</a>
                <ul class="collapse list-unstyled" id="otherComponent">
                     <li>
                        <a href="HomeServlet">Listes</a>
                    </li>
                    <li>
                        <a href="CheckServlet">Formulaire</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>