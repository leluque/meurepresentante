<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MeuRepresentante - Acompanhe o trabalho do seu vereador</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fuelux/3.15.8/css/fuelux.min.css" />
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fuelux/3.15.8/js/fuelux.min.js"></script>
        
        <style>
            body {
                font-family: 'Lato';
                font-size: 18px;
                margin: 5px;
            }
            .jumbotron {
                background-color: #ccffcc;
            }
            .jumbotron img {
                float: left;
                padding: 2em;
                width: 14%;
            }
            .jumbotron h1 {
                float: left;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <img src="${pageContext.request.contextPath}/images/bandeira.jpg" />
                <h1> Meu Representante</h1>
                <div style="clear: both"></div>
                <p>Nesta página, você pode pesquisar por informações sobre os projetos propostos por vereadores de Mogi das Cruzes.</p> 
            </div>
            <p>O Meu Representante permite que você acompanhe o vereador que elegeu e saiba quais projetos ele propõe. Além disso, você pode avaliar os projetos votados por ele. Afinal de contas, o que você acha de um vereador que só propõe projetos de denominação de vias?</p>
            <strong>Para começar, digite palavras-chave, como "denominação", para verificar o número de projetos propostos pelo vereador que possuem essa palavra-chave.</strong>
            <div class="fuelux">
                <div class="pillbox" data-initialize="pillbox" id="myPillbox">
                    <ul class="clearfix pill-group">
                        <li class="btn btn-default pill" data-value="foo">
                            <span>Denominação de via pública</span>
                            <span class="glyphicon glyphicon-close">
                                <span class="sr-only">Remover</span>
                            </span>
                        </li>
                        <li class="btn btn-default pill" data-value="foo">
                            <span>Denominação de praça pública</span>
                            <span class="glyphicon glyphicon-close">
                                <span class="sr-only">Remover</span>
                            </span>
                        </li>
                        <li class="btn btn-default pill" data-value="foo">
                            <span>Denominação de rotatória</span>
                            <span class="glyphicon glyphicon-close">
                                <span class="sr-only">Remover</span>
                            </span>
                        </li>
                        <li class="pillbox-input-wrap btn-group">
                            <a class="pillbox-more">and <span class="pillbox-more-count"></span>mais ...</a>
                            <input type="text" class="form-control dropdown-toggle pillbox-add-item" placeholder="Escreva para adicionar...">
                            <button type="button" class="dropdown-toggle sr-only">
                                <span class="caret"></span>
                                <span class="sr-only">Alternar</span>
                            </button>
                            <ul class="suggest dropdown-menu" role="menu" data-toggle="dropdown" data-flip="auto"></ul>
                        </li>
                    </ul>
                </div>
            </div>
            <table>
                <c:forEach items="${projetos}" var="projeto">
                    <tr>
                        <td>${projeto.assunto}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
