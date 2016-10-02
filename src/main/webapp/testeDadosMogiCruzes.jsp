<%-- 
    Document   : TesteDownloadMogi
    Created on : 27/09/2016, 20:10:31
    Author     : leand
--%>

<%@page import="br.com.luque.meurepresentante.dominio.Projeto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.luque.meurepresentante.servico.CarregadorDadosMC"%>
<%@page import="br.com.luque.meurepresentante.dominio.Politico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados carregados</title>
    </head>
    <body>
        <h1>Dados carregados:</h1>
        Exibir dados carregados aqui.
        <pre><%
                CarregadorDadosMC carregadorDadosMC = new CarregadorDadosMC();
                List<Projeto> projetos = carregadorDadosMC.carregarProjetos(new ArrayList<Politico>());
                for (Projeto projeto : projetos) {
                    if(!projeto.getAutores().isEmpty()) {
                        String nomesProj = "";
                    for(Politico autor : projeto.getAutores()) {
                        nomesProj += autor.getNome() + ",";
                    }
                    out.print(nomesProj);
            %>;<%= projeto.getAssunto()%>
<%
                }}
            %></pre>
    </body>
</html>
