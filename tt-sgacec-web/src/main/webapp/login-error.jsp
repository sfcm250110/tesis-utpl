<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
        <title>.::Trabajo de Titulación - SGACEC</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link media="all" href="<%=request.getContextPath()%>/resources/css/ui.css" type="text/css" rel="stylesheet" />
        <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/favicon.ico"/>
        
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/css/jquery-ui.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/js/jquery-ui.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/css/style.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/primefaces/primefaces-smoothness/js/login.js"></script>
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
						<a id="corporacion" class="nav_principal_a" href=""><span>Inicio &gt;</span></a>
						<a id="ingreso" class="nav_principal_a" href=""><span>Error Ingreso</span></a>
					</div>
				</div>
			</div>
		</div>
		
		<div id="main_wrapper" class="content">
			<div id="wrapper_ie" class="wrapper">
				<h1 class="wrapper_h1" align="right">
					
				</h1>
				<div class="contenido_info_login">
					<div class="contenido_left_error">
						<h2>Informaci&#243;n Error</h2>
						<h3>Credenciales incorrectas</h3>
						<div class="campos_general_error">
						<div>
							<div class="error_message">
								<div class="icono">&nbsp;</div>
								<div class="mensaje">
									<p>USUARIO / CLAVE INV&#193;LIDOS</p>
								</div>
								<div class="linkNuevamente">
									<a href="<%=request.getContextPath()%>" class="link_intentar_nuevamente_error_a">Intentar Nuevamente</a>
								</div>
							</div>
						</div>
						</div>
					</div>
					
					<div class="contenido_right_error">
						<h2>Sugerencia:</h2>
						<ul>
							<li>Su Usuario  o  Clave  las digito de manera incorrecta.</li>
							<li>Presione el link  Intentar Nuevamente  para ingresar correctamente su credenciales.</li>
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