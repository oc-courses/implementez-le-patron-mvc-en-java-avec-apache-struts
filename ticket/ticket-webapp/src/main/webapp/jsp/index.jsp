<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/head.jsp"%>
</head>

<body>
    <h2><s:text name="home.welcome" /></h2>

    <nav>
        <s:a action="projet_list">
            <s:text name="nav.listProjet" />
        </s:a>
    </nav>
</body>
</html>
