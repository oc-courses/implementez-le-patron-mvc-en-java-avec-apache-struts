<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>

<body>
    <%@ include file="../_include/header.jsp" %>

    <h2>Démo - Converter</h2>

    <s:form action="demo_convert">
        <s:textfield name="fraction" label="Fraction (format : #/#)" />

        <s:submit value="OK"/>
    </s:form>
</body>
</html>
