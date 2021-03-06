<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="model.EnumNivel"%>
<%@page import="util.Constantes"%>
<%
	String url = (String) request.getAttribute("url");
	List<Modulo> modulosDoPerfil = (List<Modulo>) request.getAttribute("modulosDoPerfil");
	List<Modulo> modulos = (List<Modulo>) request.getAttribute("modulos");
	Perfil perfil = (Perfil) request.getAttribute("perfil");
%>
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Modulos Desassociados</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<th>Título</th>
						<th>URL</th>
						<th>Opções</th>
						</thead>
						<tbody>
							<%
								for (Modulo modulo : modulos) {
							%>
							<tr>
								<td><%=modulo.getTitulo()%></td>
								<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
										alt="<%=modulo.getTitulo()%>" src="<%=modulo.getImagem()%>"></a></td>
								<td>
									<form method="POST" action="<%=url%>/associar_modulo_perfil">
										<input type="hidden" value="<%=perfil.getId()%>"
											name="perfil_id" /> <input type="hidden"
											value="<%=modulo.getId()%>" name="modulo_id" /> <input
											type="submit" class="btn btn-success" value="Associar" />
									</form>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Modulos Associados</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<th>Título</th>
							<th>URL</th>
							<th>Opções</th>
						</thead>
						<tbody>
							<%
								for (Modulo modulo : modulosDoPerfil) {
							%>
							<tr>
								<td><%=modulo.getTitulo()%></td>
								<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
										alt="<%=modulo.getTitulo()%>" src="<%=modulo.getImagem()%>"></a></td>
								<td>
									<form method="POST" action="<%=url%>/desassociar_modulo_perfil">
										<input type="hidden" value="<%=perfil.getId()%>"
											name="perfil_id" /> <input type="hidden"
											value="<%=modulo.getId()%>" name="modulo_id" /> <input
											type="submit" class="btn btn-danger" value="Desassociar" />
									</form>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>