<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>

<body>
    <%@ include file="../_include/header.jsp" %>

    <h2>Démo - AJAX</h2>


    <h3>Liste des projets</h3>
    <ul id="listProjet">
        <li><em>à charger...</em></li>
    </ul>
    <button onclick="reloadListProjet()">Recharger</button>


    <h3>Selects en cascade</h3>
    <s:form>
        <s:select id="selectProjet" name="projet" label="Projet"
                  list="listProjet" listKey="id" listValue="nom"
                  onchange="onSelectProjetChange()"/>

        <s:select id="selectVersion" label="Version" list="{}"/>
    </s:form>


    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        function reloadListProjet() {
            // URL de l'action AJAX
            var url = '<s:url action="demo_ajax_getListProjet"/>';

            // Action AJAX en POST
            jQuery.post(
                url,
                function (data) {
                    var $listProjet = jQuery("#listProjet");
                    $listProjet.empty();
                    jQuery.each(data, function (key, val) {
                        $listProjet.append(
                            jQuery("<li>")
                                .append(val.nom)
                                .append(" - Responsable : ")
                                .append(val.responsable.prenom)
                        );
                    });
                })
                .fail(function () {
                    alert("Une erreur s'est produite.");
                });
        }


        function onSelectProjetChange() {
            // URL de l'action AJAX
            var url = '<s:url action="demo_ajax_getListVersion"/>';

            // Paramètres de la requête AJAX
            var params = {
                projet: jQuery("#selectProjet").val()
            };

            // Action AJAX en POST
            jQuery.post(
                url,
                params,
                function (data) {
                    var $selectVersion = jQuery("#selectVersion");
                    $selectVersion.empty();
                    jQuery.each(data, function (key, val) {
                        $selectVersion.append(
                            jQuery("<option>")
                                .text(val.numero)
                                .val(val.numero)
                        );
                    });
                })
                .fail(function (data) {
                    if (typeof data.responseJSON === 'object') {
                        console.log(data.responseJSON);
                    } else {
                        console.log(data);
                    }
                    alert("Une erreur s'est produite.");
                });
        }
    </script>
</body>
</html>
