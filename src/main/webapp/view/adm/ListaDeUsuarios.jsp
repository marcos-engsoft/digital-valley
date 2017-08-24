<%@page import="model.Usuario"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<html lang="pt">
<head>
<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>lista de usuários</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="../assets2/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="../assets2/css/demo.css" rel="stylesheet" />
	
	<style>
		#topo{background: steelblue; }
		#nivelUsuario{margin-top: 70px;}
		#textB{color: white;}
		#rodap{
			background: steelblue;
			border-radius: 0px 0px 10px 10px;
		}		
		#save{
			margin-right: 100px;
			margin-top: 15px;
			width: 110px;
			height: 30px;
			color: white;
			margin-left: 30%;	
		}
		#tudo{
			width: 80%;
			margin-left: 10%;
			border-radius: 10px;
		}
		#rodape{
			margin-right: 40%;
			color: white;
		}
		#save{
			background: steelblue;
			border-color: steelblue;
		}
		#txt_busca{width: 25%;
			border-radius: 10px;
			height: 35px;
		}
		#btn_busca{background: steelblue;
			color: white;
			border-radius: 8%;
			width: 06%;
			height: 35px;
		}
		#busca{position: absolute;
			left: 40%;
			width: 90%;
		}
	</style>
</head>
	
	
<body>

	<% List<Usuario> usuarios = (List<Usuario>) session.getAttribute("listaDeUsuarios"); %>
	
	<div id ="tudo" class="wrapper">
	    
	    <div class="main-panel">
	        <nav class="navbar navbar-default navbar-fixed">
	            <div id ="topo" class="container-fluid">
	                <div class="navbar-header">
	                    
	                    <a id="textB" class="navbar-brand" >Lista de Usuários</a>
	                </div>
	                 <%@ include file="menuDropDown.jsp"  %>
	            </div>
	        </nav>
	
			<div class="content">
	            <div class="container-fluid">
					<div class="col-md-12">
			          <div class="card">
			              <div class="header">
			              	<div id="busca">
							  	<input id="txt_Busca" type="text"  placeholder="Buscar..."/>
							  	<!--  <img src="search3.png" id="btnBusca" alt="Buscar"/> -->
							  	<input id="btn_Busca" type="button" value="Buscar"/>
							</div>
							<br>
			                <h4 class="title">Usuários</h4>
			              </div>
			              <div id="tabUsuarios">
			                  <table class="table table-hover table-striped">
			                      <thead>
			                      	  <th>Código</th>
			                          <th>Nome</th>
			                          <th>E-mail</th>
			                          <th>Nível</th>
			                      </thead>
			                      <tbody>
			                      	<% for(Usuario usuario : usuarios){%>
			                          <tr>
			                          	<td><%=usuario.getPessoa().getId() %></td>
			                          	<td><a href="EditarNivel.jsp?idUsuario="<%=usuario.getPessoa().getId() %>></a><%usuario.getPessoa().getNome()%></td>
			                          	<td><%usuario.getPessoa().getEmail()%></td>
			                          	<td><%usuario.getNivel()%></td>
			                          </tr>                    
		                          	<%}%>    
			                      </tbody>
			                  </table>
			              </div>
			          </div>
			      </div>
	      	</div>
	      </div>
	       <footer class="footer">
	            <div id="rodap" class="container-fluid">
	                <p id="rodape" class="copyright pull-right">
					<br>
	                    ₢ Todos os direitos reservados | N2S
	                </p>
	            </div>
	        </footer>
	       </div>
	</div>
</body>
<!--   Core JS Files   -->
	<script src="../assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="../assets2/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets2/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="../assets2/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="../assets2/js/jquery.validate.min.js"></script>
</html>