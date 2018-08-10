<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
        <title>.::Trabajo de Titulación - SGACEC</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link media="all" href="<%=request.getContextPath()%>/resources/css/ui.css" type="text/css" rel="stylesheet" />
        <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/favicon.ico"/>
        
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/js/jquery-ui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/js/login.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/css/jquery-ui.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/css/style.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/css/inputtext.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/css/login.css" />
    </head>
    
    <body>
    	<div id="contentHeader">
    		<div>
				<div class="content_header">
					<div class="logo">
						<img src="<%=request.getContextPath()%>/resources/images/logo-largo.png" alt="Logo Empresa" />
					</div>
					<div class="texto_header">Trabajo de Titulación</div>
				</div>
				<div class="header_menu">
					<div class="nav_principal">
						<a id="corporacion" class="nav_principal_a" href=""><span></span></a>
						<a id="ingreso" class="nav_principal_a" href=""><span></span></a>
					</div>
				</div>
			</div>
		</div>
		
		<div id="main_wrapper" class="content">
			<div id="wrapper_ie" class="wrapper">
				<h1 class="wrapper_h1" align="right">
					
				</h1>
				<div class="contenido_info_login">
					<div class="contenido_left">
						<h2>Ingreso al Sistema</h2>
						<h3>Por favor ingrese su usuario y clave</h3>
						<div class="campos_general">
							<form action="j_security_check" method="post">
								<div id="pnlLoginPrincipal">
									<table>
										<tbody>
											<tr>
												<td>
													<div class="campos_texto">Usuario: </div>
													<div class="campos_texto">Clave: </div>
												</td>
												<td>
													<div class="campos_form">
														<input name="j_username" type="text" title="Usuario" />
													</div>
													<div class="campos_form">
														<input name="j_password" type="password" title="Clave" />
													</div>
												</td>
											</tr>
										</tbody>
									</table>
									<table>
										<tbody>
											<tr>
												<td>
													<button>Ingresar</button>
												</td>
											</tr>
										</tbody>
									</table>
									<br />
									<br />
									<table>
										<tbody>
											<tr>
												<td>
													<a id="link_olvido_contraseniaId" href="<%=request.getContextPath()%>/olvidoClave.jsp" class="ui-commandlink ui-widget link_registro_a">recuperar su clave</a>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</form>
						</div>
					</div>
					
					<div class="contenido_right">
						<h2>UTPL</h2>
						<br />
						<br />
						<br />
						<ul>
							<li>2015: La Universidad recibi&#243; el Premio Nous de Excelencia Educativa, por ser pionera en Educaci&#243;n a Distancia y, por su nivel acad&#233;mico e importante aporte a la comunidad a trav&#233;s de sus investigaciones cient&#205;ficas.</li>
							<li>2014: Prendho recibi&#243; la <b>Acreditaci&#243;n de Espacios de Innovaci&#243;n</b>, por parte de la SENESCYT, siendo as&#205; la mejor incubadora del pa&#205;s.</li>
							<li>2013: La UTPL lidera la publicaci&#243;n cient&#205;fica nacional en Ecuador en revistas internacionales indexadas en Scopus, llegando as&#205; a obtener 59. Corte 07 de agosto.</li>
						</ul>
					</div>
				</div>
				<br />
			</div>
			
			<div>
				<div class="piePagina">
					<div class="footer">
						<h1 align="right">Copyright © 2018 UTPL. Todos los Derechos Reservados </h1>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>