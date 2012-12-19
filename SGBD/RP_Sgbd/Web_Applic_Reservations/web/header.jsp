<%@page import="Session.UserInfo"%>
<header>
    <div id="titre_principal">
        <img src="images/zozor_logo.png" alt="Logo de Zozor" id="logo" />
        <h1>Rennequinepolis</h1>
        <h2>Votre cin�ma en ligne !</h2>
    </div>

    <nav>
        <ul>
            <li><a href="controlServlet">Accueil</a></li>
            <%
            if(userinfo.isLogged())
            {
                %>
                <li><a href="Search?action=caddie">Reserver</a></li>
                <li><a href="Search?action=caddie">Caddie</a></li>
                <li><a href="controlServlet?action=logoff">Logout</a></li>
                <%
            }
            %>
        </ul>
    </nav>
</header>

<div id="banniere_image">
    <div id="banniere_description">
        le cin�ma en ligne...
    </div>
</div>