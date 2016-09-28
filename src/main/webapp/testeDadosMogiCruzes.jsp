<%-- 
    Document   : TesteDownloadMogi
    Created on : 27/09/2016, 20:10:31
    Author     : leand
--%>

<%@page import="br.com.luque.meurepresentante.dominio.Politico"%>
<%@page import="java.util.List"%>
<%@page import="br.com.luque.meurepresentante.servico.DadosMogiCruzes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <pre><%
                DadosMogiCruzes dadosMogiCruzes = new DadosMogiCruzes();
                List<Politico> vereadores = dadosMogiCruzes.carregarPoliticos();
                for(Politico vereador : vereadores) {
                    out.println(vereador + " # " + vereador.getFoto().getNomeOriginal());
                }
            %></pre>
    </body>
</html>
