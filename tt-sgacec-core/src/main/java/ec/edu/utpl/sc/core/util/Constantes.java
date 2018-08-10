package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.util.Date;

public class Constantes implements Serializable {
	
	private static final long serialVersionUID = -6724265690080854973L;
	
	public static final String DEPRECATION = "deprecation";
	public static final String UNCHECKED = "unchecked";
	public static final String RESOURCE = "resource";
	
	public static final String BREAK_LINE = "\n";
	public static final String STRING_EMPTY = "";
	public static final String SPACE_BLANK = " ";
	public static final String PORCENTAJE = "%";
	public static final String COMA = ",";
	public static final String COMILLA_SIMPLE = "'";
	public static final String IGUAL = "=";
	public static final String NULL = "null";
	public static final String OF = "of";
	public static final String NOT_NULL = "not null";
	public static final String TAB = "\t";
	public static final String GUION_BAJO = "_";
	public static final String GUION_MEDIO = "-";
	public static final String BACKSPACE = "\b";
	public static final String NEWLINE = "\n";
	public static final String CARRIAGE = "\r";
	public static final String FORMFEED = "\f";
	public final static String SLASH = "/";
	public final static String DOBLE_SLASH = "//";
	public final static String PUNTO_Y_COMA = ";";
	public final static String PUNTO = ".";
	public final static String ABRIR_TAG_MENOR = "<";
	public final static String ABRIR_TAG_MAYOR = ">";
	public final static String CERRAR_TAG_MENOR = "</";
	public final static String SALTO_LINEA = "\n";
	public final static String SIGNO_IGUAL = "=";
	public final static String SIGNO_NUMERAL = "#";
	
	public final static char C_DOT = '.';
	public final static char C_COMMA = ',';
	public final static char C_SPACE = ' ';
	
	public final static String DOT = ".";
	public final static String COMMA = ",";
	
	public final static String CONTENT_TYPE_HTML = "text/html";
	public final static String CONTENT_TYPE_PDF = "application/pdf";
	public final static String CONTENT_TYPE_XML = "text/xml";
	public final static String CONTENT_TYPE_EXCEL = "application/vnd.ms-excel";
	public final static String CONTENT_TYPE_WORD = "application/msword";
	
	public static final String ENCODING_UTF_8 = "UTF-8";
	public static final String ENCODING_UTF_16 = "UTF-16";
	
	public static final String CONTENT_DISPOSITION = "Content-Disposition";
	public final static String CONTENT_LENGTH = "content-length";
	public final static String CONTENT_ATTACHMENT_FILE_NAME = "attachment; filename=";
	public static final String FILENAME = "filename";
	public static final String INLINE = "inline";
	
	public final static String PARAM_ACEPTABLE = "aceptable";
	
	public static final String NAME_FILE_XLS_ANEXO_GATOS_SRI = "anexo-gastos-sri-";
	
	public static final String XLS_MAP_ANEXO_GATOS = "anexoGestosXls";
	public static final String XLS_MAP_ANEXOS_GATOS_SRI = "anexosGastosSriXls";
	
	public final static Integer MSJ_ERROR = 1;
	public final static Integer MSJ_FATAL = 2;
	public final static Integer MSJ_WARN = 3;
	public final static Integer MSJ_INFO = 4;
	
	public final static String VALOR_SI = "SI";
	public final static String VALOR_NO = "NO";
	
	public static final String CODIFICACION_UTF8 = "UTF-8";
	
	public static final String FIELD_ID = "id";
	public static final String FIELD_FECHA_PROCESO = "fechaProceso";
	public static final String FIELD_FECHA_DOWNLOAD = "fechaDownload";
	public static final String FIELD_FECHA_REGISTRO = "fechaRegistro";
	public static final String FIELD_PART_QUERY = "Query";
	public static final String FIELD_PART_CRUD = "Crud";
	
	public static final String CRUD_DAO = "crudDao";
	public static final String COMPROBANTE_DAO = "comprobanteDao";
	
	public static final String CRUD_GESTOR = "crudGestor";
	public static final String SELENIUM_GESTOR = "seleniumGestor";
	public static final String COMPROBANTE_GESTOR = "comprobanteGestor";
	public static final String FILE_GESTOR = "fileGestor";
	public static final String PDF_GESTOR = "pdfGestor";
	public static final String PARAMETRO_GENERAL_GESTOR = "parametroGeneralGestor";
	public static final String DOWNLOAD_SRI_GESTOR = "downloadSriGestor";
	public static final String EMPRESA_GESTOR = "empresaGestor";
	public static final String GENERICO_GESTOR = "genericoGestor";
	public static final String CONSULTAS_GESTOR = "consultasGestor";
	public static final String COMPROBANTE_EMPRESA_GESTOR = "comprobanteEmpresaGestor";
	public static final String ADM_GESTOR = "admGestor";
	public static final String FW_GESTOR = "fwGestor";
	public static final String ANEXO_GASTO_GESTOR = "anexoGastoGestor";
	public static final String HTTP_GESTOR = "httpGestor";
	
	public static final String CRUD_SERVICIO = "crudServicio";
	public static final String SELENIUM_SERVICIO = "seleniumServicio";
	public static final String COMPROBANTE_SERVICIO = "comprobanteServicio";
	public static final String FILE_SERVICIO = "fileServicio";
	public static final String PDF_SERVICIO = "pdfServicio";
	public static final String PARAMETRO_GENERAL_SERVICIO = "parametroGeneralServicio";
	public static final String DOWNLOAD_SRI_SERVICIO = "downloadSriServicio";
	public static final String EMPRESA_SERVICIO = "empresaServicio";
	public static final String GENERICO_SERVICIO = "genericoServicio";
	public static final String CONSULTAS_SERVICIO = "consultasServicio";
	public static final String COMPROBANTE_EMPRESA_SERVICIO = "comprobanteEmpresaServicio";
	public static final String ADM_SERVICIO = "admServicio";
	public static final String FW_SERVICIO = "fwServicio";
	public static final String ANEXO_GASTO_SERVICIO = "anexoGastoServicio";
	public static final String HTTP_SERVICIO = "httpServicio";
	
	public static final String USUARIO_CONTROLLER = "usuarioController";
	public static final String DOWNLOAD_CONTROLLER = "downloadController";
	public static final String ADM_EMPRESA_CONTROLLER = "admEmpresaController";
	public static final String LOGIN_CONTROLLER = "loginController";
	public static final String ADM_COMPROBANTE_FISICO_CONTROLLER = "admComprobanteFisicoController";
	public static final String ADM_VALOR_MAXIMO_RUBRO_SRI_CONTROLLER = "admValorMaximoRubroSriController";
	
	public static final String COMMON_DATAMANAGER = "commonDataManager";
	public static final String USUARIO_DATAMANAGER = "usuarioDataManager";
	public static final String DOWNLOAD_DATAMANAGER = "downloadDataManager";
	public static final String ADM_EMPRESA_DATAMANAGER = "admEmpresaDataManager";
	public static final String LOGIN_DATAMANAGER = "loginDataManager";
	public static final String ADM_COMPROBANTE_FISICO_DATAMANAGER = "admComprobanteFisicoDataManager";
	public static final String ADM_VALOR_MAXIMO_RUBRO_SRI_DATAMANAGER = "admValorMaximoRubroSriDataManager";
	public static final String ADM_ERROR_SISTEMA_DATA_MANAGER = "admErrorSistemaDataManager";
	
	public static final String USUARIO_DATAMANAGER_EL = "#{usuarioDataManager}";
	public static final String DOWNLOAD_DATAMANAGER_EL = "#{downloadDataManager}";
	public static final String ADM_EMPRESA_DATAMANAGER_EL = "#{admEmpresaDataManager}";
	public static final String LOGIN_DATAMANAGER_EL = "#{loginDataManager}";
	public final static String INICIO_DATAMANAGER_EL = "#{inicioDataManager}";
	public final static String INICIO_CONTROLADOR_EL = "#{inicioControlador}";
	public final static String I18N_EL = "#{i18n}";
	public final static String ADMINISTRAR_PARAMETROS_SISTEMA_DATA_MANAGER_EL = "#{administrarParametrosSistemaDataManager}";
	public final static String ADMINISTRAR_PREGUNTAS_SEGURIDAD_DATA_MANAGER_EL = "#{administrarPreguntaSeguridadDataManager}";
	public final static String OLVIDO_CLAVE_DATA_MANAGER_EL = "#{olvidoClaveDataManager}";
	public final static String CAMBIAR_CLAVE_DATA_MANAGER_EL = "#{cambiarClaveDataManager}";
	public final static String PROCESAR_SRI_WEB_DATA_MANAGER_EL = "#{procesarSriWebDataManager}";
	public final static String PROCESAR_SRI_WS_DATA_MANAGER_EL = "#{procesarSriWsDataManager}";
	public final static String CONSULTAR_COMPROBANTES_DATA_MANAGER_EL = "#{consultaComprobantesDataManager}";
	public static final String ADM_COMPROBANTE_FISICO_DATAMANAGER_EL = "#{admComprobanteFisicoDataManager}";
	public static final String ADM_VALOR_MAXIMO_RUBRO_SRI_DATAMANAGER_EL = "#{admValorMaximoRubroSriDataManager}";
	public static final String GENERAR_ANEXO_GASTOS_DATAMANAGER_EL = "#{generarAnexoGastosDataManager}";
	public final static String CHECK_DOWNLOAD_SRI_DATA_MANAGER_EL = "#{checkDownloadSriDataManager}";
	public static final String ADM_ERROR_SISTEMA_DATA_MANAGER_EL = "#{admErrorSistemaDataManager}";
	
	public static final String USUARIO_DATAMANAGER_EMPRESAS_EL = "#{usuarioDataManager.empresas}";
	
	public static final String TRANSACTION_MANAGER = "transactionManager";
	public static final String PATH_SPRING_CONFIG = "ec/edu/utpl/sc/core/spring/spring-config.xml";
	public static final String CLASSPATH_SPRING_CONFIG = "classpath:" + PATH_SPRING_CONFIG;
	
	public static final String SERIAL_VERSION_UID = "serialVersionUID";
	public static final String HASH_VALUE = "hashValue";
	
	public static final String DD_MM_YYYY_HHMMSS = "dd/MM/yyyy HH:mm:ss";
	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DD_MM_YYYY_GUION = "dd-MM-yyyy";
	
	public static final String NOMBRE_FACTURA = "Factura";
	public static final String NOMBRE_NOTA_CREDITO = "Notas de Credito";
	public static final String NOMBRE_NOTA_DEBITO = "Notas de Debito";
	public static final String NOMBRE_GUIA_REMISION = "Guia de Remision";
	public static final String NOMBRE_COMPROBANTE_RETENCION = "Comprobante de Retencion";
	
	public static final String FACTURA_LBL = "Factura";
	public static final String NOTA_CREDITO_LBL = "Notas de Cr\u00e9dito";
	public static final String NOTA_DEBITO_LBL = "Notas de D\u00e9bito";
	public static final String GUIA_REMISION_LBL = "Gu\u00eda de Remisi\u00f3n";
	public static final String COMPROBANTE_RETENCION_LBL = "Comprobante de Retenci\u00f3n";
	
	public static final Integer TIPO_FACTURA = 1;
	public static final Integer TIPO_NOTA_CREDITO = 2;
	public static final Integer TIPO_NOTA_DEBITO = 3;
	public static final Integer TIPO_GUIA_REMISION = 4;
	public static final Integer TIPO_COMPROBANTE_RETENCION = 5;
	
	public static final String NOMBRE_NORMAL = "NORMAL";
	public static final String NOMBRE_CONTINGENCIA = "CONTINGENCIA";
	
	public static final Integer TIPO_NORMAL = 1;
	public static final Integer TIPO_CONTINGENCIA = 2;
	
	public static final Integer FISICO = 1;
	public static final Integer ELECTRONICO = 2;
	
	public static final String LBL_FISICO = "F\u00edsico";
	public static final String LBL_ELECTRONICO = "Electr\u00f3nico";
	
	public static final Integer I1M = -1;
	public static final Integer I0 = 0;
	public static final Integer I1 = 1;
	public static final Integer I2 = 2;
	public static final Integer I3 = 3;
	public static final Integer I4 = 4;
	public static final Integer I5 = 5;
	public static final Integer I6 = 6;
	public static final Integer I7 = 7;
	public static final Integer I8 = 8;
	public static final Integer I9 = 9;
	public static final Integer I10 = 10;
	public static final Integer I11 = 11;
	public static final Integer I12 = 12;
	public static final Integer I13 = 13;
	public static final Integer I14 = 14;
	public static final Integer I15 = 15;
	public static final Integer I16 = 16;
	public static final Integer I17 = 17;
	public static final Integer I18 = 18;
	public static final Integer I19 = 19;
	public static final Integer I20 = 20;
	public static final Integer I21 = 21;
	public static final Integer I22 = 22;
	public static final Integer I23 = 23;
	public static final Integer I24 = 24;
	public static final Integer I25 = 25;
	public static final Integer I26 = 26;
	public static final Integer I27 = 27;
	public static final Integer I28 = 28;
	public static final Integer I29 = 29;
	public static final Integer I30 = 30;
	public static final Integer I40 = 40;
	public static final Integer I50 = 50;
	public static final Integer I100 = 100;
	public static final Integer I200 = 200;
	public static final Integer I300 = 300;
	public static final Integer I350 = 350;
	public static final Integer I400 = 400;
	public static final Integer I500 = 500;
	public static final Integer I1000 = 1000;
	public static final Integer I10000 = 10000;
	
	public static final Double D0 = 0D;
	
	public static final Long TYPE_L_SELECT = -1L;
	public static final Long TYPE_L_UPDATE = -1L;	
	public static final Integer TYPE_I_SELECT = -1;	
	public static final String TYPE_S_SELECT = "null";
	public static final Date TYPE_D_SELECT = null;
	
	public static final String RUC = "ruc";
	
	public static final Integer COLUMNA_FILA = 1;
	public static final Integer COLUMNA_RUC_RAZON_SOCIAL = 2;
	public static final Integer COLUMNA_TIPO_SERIE = 3;
	public static final Integer COLUMNA_CLAVE_ACCESO_NUMERO_AUTORIZACION = 4;
	public static final Integer COLUMNA_FECHA_AUTORIZACION = 5;
	public static final Integer COLUMNA_FECHA_EMISION = 6;
	public static final Integer COLUMNA_TIPO_EMISION = 7;
	public static final Integer COLUMNA_XML = 8;
	public static final Integer COLUMNA_PDF = 9;
	
	public static final String PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS = "profile.default_content_settings.popups";
	public static final String DOWNLOAD_DEFAULT_DIRECTORY = "download.default_directory";
	public static final String SAFE_BROWSING_ENABLED = "safebrowsing.enabled";
	public static final String PREFS = "prefs";
	
	public static final String URL_SRI = "https://declaraciones.sri.gob.ec/tuportal-internet/";
	public static final String URL_SRI_CONSULTA_COMPROBANTES_ELECTRONICOS = "https://declaraciones.sri.gob.ec/tuportal-internet/menusFavoritos.jspa?redireccion=57&idGrupo=55";
	public static final String URL_CONSULTA_RUC_SRI = "https://declaraciones.sri.gob.ec/facturacion-internet/consultas/publico/ruc-datos2.jspa";
	
	public static final String ELEMENT_USER_NAME = "j_username";
	public static final String ELEMENT_PASSWORD = "j_password";
	public static final String ELEMENT_BOTON = "boton";
	public static final String ELEMENT_TR = "tr";
	public static final String ELEMENT_TD = "td";
	public static final String ELEMENT_TH = "th";
	public static final String ELEMENT_OCULTAR = "ocultar";
	public static final String ELEMENT_TABLE_INFO_RUC = "table[class=formulario]";
	public static final String ELEMENT_FRM_PRINCIPAL_ID_ANIO = "frmPrincipal:ano";
	public static final String ELEMENT_FRM_PRINCIPAL_ID_MES = "frmPrincipal:mes";
	public static final String ELEMENT_FRM_PRINCIPAL_ID_DIA = "frmPrincipal:dia";
	public static final String ELEMENT_FRM_PRINCIPAL_BTN_BUSCAR = "frmPrincipal:btnBuscar";
	public static final String ELEMENT_FRM_PRINCIPAL_TABLE_COMP_RECIBIDOS = "frmPrincipal:tablaCompRecibidos";
	public static final String ELEMENT_XPATH_FRM_PRINCIPAL_TABLE_COMP_RECIBIDOS_ROW = "//*[@id='frmPrincipal:tablaCompRecibidos']/table/tbody/tr";
	public static final String ELEMENT_XPATH_FRM_PRINCIPAL_TABLE_COMP_RECIBIDOS_METADATA = "//*[@id='frmPrincipal:tablaCompRecibidos']/table/tfoot/tr";
	public static final String ELEMENT_XPATH_PAGINADO = "//*[@id='frmPrincipal:tablaCompRecibidos']/table/tfoot/tr/td/select/option[@selected='selected']";
	public static final String ELEMENT_XPATH_NUMERO_PAGINAS = "//*[@id='frmPrincipal:tablaCompRecibidos']/table/tfoot/tr/td/span[@class='ui-paginator-current']";
	public static final String ELEMENT_XPATH_LAST_PAGE = "//*[@id='frmPrincipal:tablaCompRecibidos']/table/tfoot/tr/td/span[@class='ui-paginator-last ui-state-default ui-corner-all ui-state-enabled']/span[@class='ui-icon ui-icon-seek-end']";
	public static final String ELEMENT_XPATH_ID = "//*[@id='";
	public static final String ELEMENT_XPATH_TABLE_TBODY_TR = "']/table/tbody/tr";
	
	public static final String TAG_COMPROBANTE = "comprobante";
	public static final String TAG_NUMERO_AUTORIZACION = "numeroAutorizacion";
	public static final String TAG_FECHA_AUTORIZACION = "fechaAutorizacion";
	public static final String TAG_LOGO_EMPRESA = "logoEmpresa";
	public static final String TAG_LOGO_CODIGO_BARRAS = "logoCodigoBarras";
	public static final String TAG_CLAVE_ACCESO = "claveAcceso";
	public static final String TAG_TIPO_IDENTIFICACION_COMPRADOR = "tipoIdentificacionComprador";
	public static final String TAG_IDENTIFICACION_COMPRADOR = "identificacionComprador";
	public static final String TAG_AUTORIZACION = "autorizacion";
	
	public static final String TIPO_IDENTIFICACION_COMPRADOR_RUC = "04";
	public static final String TIPO_IDENTIFICACION_COMPRADOR_CEDULA = "05";
	
	public static final String SUFIJO_RUC = "001";
	
	public static final String DML_UPDATE = "Update";
	public static final String DML_SET = "Set";
	public static final String DML_WHERE = "Where";
	public static final String DML_AND = "And";
	public static final String DML_WHERE_DEFAULT = "1 = 1";
	
	public static final float X_INFERIOR_IZQUIERDA = 290f;
	public static final float X_SUPERIOR_DERECHA = 550f;		
	public static final float Y_INFERIOR_IZQUIERDA = 720f;
	public static final float Y_SUPERIOR_DERECHA = 705f;
	
	public static final float X_INFERIOR_IZQUIERDA_RUC_CEDULA = 93f;
	public static final float X_SUPERIOR_DERECHA_RUC_CEDULA = 150f;		
	public static final float Y_INFERIOR_IZQUIERDA_RUC_CEDULA = 500f;
	public static final float Y_SUPERIOR_DERECHA_RUC_CEDULA = 490f;
	
	public static final String CRON_10S = "*/10 * * * * *";
	public static final String CRON_20S = "*/20 * * * * *";
	public static final String CRON_30S = "*/30 * * * * *";
	public static final String CRON_40S = "*/40 * * * * *";
	public static final String CRON_50S = "*/50 * * * * *";
	public static final String CRON_1M = "0 0/1 * * * ?";
	public static final String CRON_2M = "0 0/2 * * * ?";
	public static final String CRON_3M = "0 0/3 * * * ?";
	public static final String CRON_4M = "0 0/4 * * * ?";
	public static final String CRON_5M = "0 0/5 * * * ?";
	public static final String CRON_10M = "0 0/10 * * * ?";
	public static final String CRON_20M = "0 0/20 * * * ?";
	public static final String CRON_30M = "0 0/30 * * * ?";
	public static final String CRON_40M = "0 0/40 * * * ?";
	public static final String CRON_50M = "0 0/50 * * * ?";
	public static final String CRON_1H = "0 0 0/1 * * ?";
	public static final String CRON_2H = "0 0 0/2 * * ?";
	public static final String CRON_3H = "0 0 0/3 * * ?";
	public static final String CRON_4H = "0 0 0/4 * * ?";
	public static final String CRON_5H = "0 0 0/5 * * ?";
	public static final String CRON_1D = "0 0 0 1/1 * ?";
	public static final String CRON_2D = "0 0 0 1/2 * ?";
	public static final String CRON_3D = "0 0 0 1/5 * ?";
	public static final String CRON_4D = "0 0 0 1/4 * ?";
	public static final String CRON_5D = "0 0 0 1/5 * ?";
	
	public static final String TODO_XML = "*.xml";
	public static final String TODO_PDF = "*.pdf";
	
	public static final String CODIGO_IMPUESTO_ICE = "3";
	
	public static final String AE_ALIMENTACION_1 = "ALIMENT";
	public static final String AE_SALUD_1 = "FARMAC";
	public static final String AE_SALUD_2 = "MEDICIN";
	public static final String AE_EDUCACION_1 = "EDUCACION";
	public static final String AE_VESTIMENTA_1 = "VESTIMENTA";
	public static final String AE_VIVIENDA_1 = "VIVIENDA";
	
	public static final Integer INOT_FOUND = 0;
	public static final Integer IVIVIENDA = 1;
	public static final Integer IEDUCACION = 2;
	public static final Integer IALIMENTACION = 3;
	public static final Integer IVESTIMENTA = 4;
	public static final Integer ISALUD = 5;
	
	public static final String RUC_FAVORITA = "1790016919001";
	
	public static final String DEDUCIBLE = "DEDUCIBLE";
	public static final String RUBRO_VIVIENDA = "VIVIENDA";
	public static final String RUBRO_EDUCACION = "EDUCACION";
	public static final String RUBRO_ALIMENTACION = "ALIMENTACION";
	public static final String RUBRO_VESTIMENTA = "VESTIMENTA";
	public static final String RUBRO_SALUD_1 = "SALUD";
	public static final String RUBRO_SALUD_2 = "MEDICINA";
	
	public static final String LBL_VIVIENDA = "Vivienda";
	public static final String LBL_EDUCACION = "Educaci\u00f3n";
	public static final String LBL_ALIMENTACION = "Alimentaci\u00f3n";
	public static final String LBL_VESTIMENTA = "Vestimenta";
	public static final String LBL_SALUD = "Salud";
	public static final String LBL_CONSOLIDADO = "Consolidado";
	public static final String LBL_CLASIFICADO = "Clasificado";
	public static final String LBL_SIN_CLASIFICAR = "Sin Clasificar";
	public static final String LBL_DISPONIBLE = "Disponible";
	public static final String LBL_UTILIZADO = "Utilizado";
	public static final String LBL_ANEXO_GASTOS = "Anexo Gastos";
	public static final String LBL_TOTAL_BASE_IMPONIBLE = "Total Base Imponible";
	
	public static final String VIVIENDA = "Vivienda";
	public static final String EDUCACION = "Educacion";
	public static final String ALIMENTACION = "Alimentacion";
	public static final String VESTIMENTA = "Vestimenta";
	public static final String SALUD = "Salud";
	
	public static final String LABEL_FORMAT_CHAR_F1 = "%#.1f %";
	public static final String LEGEND_POSITION_W_CHAR = "w";
	public static final String LEGEND_POSITION_E_CHAR = "e";
	public static final Integer DIAMETER_CHAR_235 = 235;
	public static final Integer DIAMETER_CHAR_110 = 110;
	
	public static final String TYPE_PDF = ".pdf";
	public static final String TYPE_XML = ".xml";
	public final static String TYPE_HTML = ".html";
	public final static String TYPE_XLS = ".xls";
	public final static String TYPE_DOC = ".doc";
	public final static String TYPE_PNG = ".png";
	public final static String TYPE_RAR = ".rar";
	public final static String TYPE_ZIP = ".zip";
	
	public final static String TYPE_PNG_ONLY = "png";
	
	public final static String NOMBRE_COMPROBANTE_DOWNLOAD = "nombreComprobante";
	public final static String DOWNLOAD_SERVLET = "/downloadHelper.jsf";
	
	public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	public static final Integer ENERO = 0;
	public static final Integer FEBRERO = 1;
	public static final Integer MARZO = 2;
	public static final Integer ABRIL = 3;
	public static final Integer MAYO = 4;
	public static final Integer JUNIO = 5;
	public static final Integer JULIO = 6;
	public static final Integer AGOSTO = 7;
	public static final Integer SEPTIEMBRE = 8;
	public static final Integer OCTUBRE = 9;
	public static final Integer NOVIEMBRE = 10;
	public static final Integer DICIEMBRE = 11;
	
	public static final String LBL_ENERO = "Enero";
	public static final String LBL_FEBRERO = "Febrero";
	public static final String LBL_MARZO = "Marzo";
	public static final String LBL_ABRIL = "Abril";
	public static final String LBL_MAYO = "Mayo";
	public static final String LBL_JUNIO = "Junio";
	public static final String LBL_JULIO = "Julio";
	public static final String LBL_AGOSTO = "Agosto";
	public static final String LBL_SEPTIEMBRE = "Septiembre";
	public static final String LBL_OCTUBRE = "Octubre";
	public static final String LBL_NOVIEMBRE = "Noviembre";
	public static final String LBL_DICIEMBRE = "Diciembre";
	
	public static final String JMS_IP = "127.0.0.1";
	public static final String JMS_USUARIO = "admin";
	public static final String JMS_CLAVE = "admin";
	public static final String JMS_PUERTO = "61616";
	public static final String JMS_RECONEXION_DELAY = "1000";
	
	public static final String QUEUE_DOWNLOAD_COMPROBANTES_SRI = "DOW.COM.SRI.REQ";
	public static final String QUEUE_DOWNLOAD_COMPROBANTES_WS_SRI = "DOW.COM.SRI.WS.REQ";
	public static final String QUEUE_DOWNLOAD_RUC_EMISOR_SRI = "DOW.RUC.EMI.SRI.REQ";
	public static final String QUEUE_CLASIFICAR_COMPROBANTES_ANEXO = "CLA.COM.ANE.REQ";
	public static final String QUEUE_DOWNLOAD_FECHA_SRI_ANEXO = "DOW.FEC.SRI.REQ";
	public static final String QUEUE_SEND_EMAIL = "SEN.MAIL.REQ";
	
	public static final Integer REGISTRADO = 1;
	public static final Integer SEND_QUEUE = 2;
	public static final Integer PROCESADO = 3;
	public static final Integer ERROR_QUEUE = 4;
	public static final Integer NO_PROCESAR = 5;
	public static final Integer CLASIFICADO = 6;
	public static final Integer NO_CLASIFICADO = 7;
	public static final Integer PRE_PROCESADO = 8;
	
	public static final String REGISTRADO_LBL = "Registrado";
	public static final String SEND_QUEUE_LBL = "Procesando";
	public static final String PROCESADO_LBL = "Procesado";
	public static final String ERROR_QUEUE_LBL = "Error al Procesar";
	public static final String NO_PROCESAR_LBL = "No Procesar";
	public static final String CLASIFICADO_LBL = "Clasificado";
	public static final String NO_CLASIFICADO_LBL = "No Clasificado";
	public static final String POR_CLASIFICAR_LBL = "Por Clasificar";
	public static final String PRE_PROCESADO_LBL = "Pre Procesado";
	
	public static final String FILE_PATH_SRC = "C:\\Users\\Kruger\\Desktop\\u\\semestre-oct-2017-feb-2018\\tesis\\doc\\Factura.pdf";
	public static final String FILE_PATH_DEST = "C:\\Users\\Kruger\\Desktop\\u\\semestre-oct-2017-feb-2018\\tesis\\doc\\Factura_.pdf";
	
	public static final String ACTIVO = "Activo";
	public static final String INACTIVO = "Inactivo";
	
	public static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	
	public static final String PAGE_LOGIN = "/pages/public/login.xhtml";
	public static final String PAGE_ACCESS_DENIED = "/pages/public/accessDenied.xhtml";
	public static final String PAGE_INDEX = "/pages/protected/index.xhtml";
	public final static String REDIRIGIR_INICIO = "/pages/inicio/inicio.jsf";
	public final static String REDIRIGIR_LOGIN = "/tt-sgacec-web/";
	
	public static final String SESSION_ATRIBUTE_USER_LOGIN = "usuarioLogin";
	
	public final static String LABEL_MENU_ADMINISTRACION = "menu.administracion";
	public final static String LABEL_MENU_CATALOGOS = "menu.catalogos";
	public final static String LABEL_MENU_GESTION = "menu.gestion";
	public final static String LABEL_MENU_CONSULTAS = "menu.consultas";
	public final static String LABEL_MENU_PROCESOS = "menu.procesos";
	public final static String LABEL_MENU_ERRORES = "menu.errores";
	
	public final static String LABEL_MENU_ITEM_CAMBIAR_CLAVE = "menu.item.cambiar.clave";
	public final static String LABEL_MENU_ITEM_PREGUNTAS_SEGURIDAD = "menu.item.preguntas.seguridad";
	public final static String LABEL_MENU_ITEM_PARAMETROS_SISTEMA = "menu.item.parametros.sistema";
	public final static String LABEL_MENU_ITEM_USUARIO = "menu.item.usuario";
	public final static String LABEL_MENU_ITEM_EMPRESA = "menu.item.empresa";
	public final static String LABEL_MENU_ITEM_VALOR_MAXIMO_RUBRO_SRI = "menu.item.valor.maximo.rubro.sri";
	public final static String LABEL_MENU_ITEM_PROCESAR_SRI_WEB = "menu.item.procesar.sri.web";
	public final static String LABEL_MENU_ITEM_PROCESAR_SRI_WS = "menu.item.procesar.sri.ws";	
	public final static String LABEL_MENU_ITEM_COMPROBANTES_ELECTRONICOS = "menu.item.adm.comprobantes.electronicos";
	public final static String LABEL_MENU_ITEM_COMPROBANTES_FISICOS = "menu.item.adm.comprobantes.fisicos";
	public final static String LABEL_MENU_ITEM_GENERAR_ANEXO_GASTOS = "menu.item.generar.anexo.gastos";
	public final static String LABEL_MENU_ITEM_CHECK_DOWNLOAD_SRI = "menu.item.check.download.sri";
	public final static String LABEL_MENU_ITEM_VER_ERRORES_SISTEMA = "menu.item.ver.errores.sistema";
	
	public final static String MENU_OUTCOME_ADM_CAMBIAR_CLAVE = "/pages/adm/cambiarClave";
	public final static String MENU_OUTCOME_ADM_PREGUNTAS_SEGURIDAD = "/pages/adm/administrarPreguntasSeguridad";
	public final static String MENU_OUTCOME_ADM_PARAMETROS_SISTEMA = "/pages/adm/administrarParametrosSistema";
	public final static String MENU_OUTCOME_ADM_USUARIO = "/pages/adm/administrarUsuario";
	public final static String MENU_OUTCOME_ADM_EMPRESA = "/pages/adm/admEmpresa";
	public final static String MENU_OUTCOME_PROCESAR_SRI_WEB = "/pages/adm/procesarSriWeb";
	public final static String MENU_OUTCOME_PROCESAR_SRI_WS = "/pages/adm/procesarSriWs";
	public final static String MENU_OUTCOME_GESTION_COMPROBANTES_ELECTRONICOS = "/pages/gestion/consultaComprobantes";
	public final static String MENU_OUTCOME_GESTION_COMPROBANTES_FISICOS = "/pages/gestion/admComprobanteFisico";
	public final static String MENU_OUTCOME_ADM_VALOR_MAXIMO_RUBRO_SRI = "/pages/adm/admValorMaximoRubroSri";
	public final static String MENU_OUTCOME_GENERAR_ANEXO_GASTOS = "/pages/gestion/generarAnexoGastos";
	public final static String MENU_OUTCOME_CHECK_DOWNLOAD_SRI = "/pages/gestion/checkDownloadSri";
	public final static String MENU_OUTCOME_ADM_ERRORES_SISTEMA = "/pages/adm/admErroresSistema";
	
	public final static String ROL_ADMIN = "ADMIN";
	public final static String ROL_OPERADOR = "OPERADOR";
	
	public static final String SESSION_PG_PATH_CHROME_WEBDRIVER = "pathChromeDrive";
	public static final String SESSION_PG_PATH_DIR_DOWNLOAD_CHROME = "pathDirDownload";
	public static final String SESSION_PG_PATH_DIR_PROCESS_CHROME = "pathDirProcess";
	public static final String SESSION_DESIRED_CAPABILITIES = "desiredCapabilities";
	public static final String SESSION_OPTIONS_ALIMENTACION = "optionsAlimentacion";
	public static final String SESSION_OPTIONS_EDUCACION = "optionsEducacion";
	public static final String SESSION_OPTIONS_SALUD = "optionsSalud";
	public static final String SESSION_OPTIONS_VESTIMENTA = "optionsVestimenta";
	public static final String SESSION_OPTIONS_VIVIENDA = "optionsVivienda";
	public static final String SESSION_ELEMENT_SRI_FRM_PRINCIPAL_TABLE = "sriFrmPrincipalTable";
	
	public final static String ID_SESSION_INIT_EMAIL = "pIdSessionDatosEmail";
	public final static String ID_SESSION_PROPERTIES_EMAIL = "pIdSessionPropertiesEmail";
	public final static String ID_SESSION_TRANSPORT_EMAIL = "pIdSessionTransportEmail";
	public final static String ID_SESSION_PARAMETROS_GENERAL = "pIdSessionParametrosGeneral";
	public final static String ID_SESSION_ESTADOS_ARCHIVO = "pIdSessionEstadosArchivo";
	public final static String ID_SESSION_ESTADOS = "pIdSessionEstados";
	public final static String ID_SESSION_REPOSITORIO_PRESUPUESTOS = "repositorioPresupuestos";
	public final static String ID_SESSION_REPOSITORIO_VENTAS = "repositorioVentas";
	public final static String ID_SESSION_REPOSITORIO_COBERTURA = "repositorioCobertura";
	public final static String ID_SESSION_REPOSITORIO_PARTICIPACION = "repositorioParticipacion";
	public final static String ID_SESSION_REPOSITORIO_DOMAIN_SERVER = "domainNameSeverRepository";
	public final static String ID_SESSION_REPOSITORIO_USER = "userSeverRepository";
	public final static String ID_SESSION_REPOSITORIO_PASSWORD = "passwordSeverRepository";
	public final static String ID_SESSION_REPOSITORIO_IP_SERVER = "ipSeverRepository";
	public final static String ID_SESSION_EMAIL_RECURSOS_HUMANOS = "emailRecursosHumanos";
	public final static String ID_SESSION_PLANTILLA_EMAIL_APROBACIONES = "aprobacionesEmail";
	public final static String ID_SESSION_PLANTILLA_EMAIL_REGISTRO_RECUPERACION_CLAVE = "registroRecuperacionClaveEmail";
	public final static String ID_SESSION_PLANTILLA_EMAIL_ERROR_PROCESAR_SRI = "errorProcesarSriEmail";
	public final static String ID_SESSION_PLANTILLA_FACTURA_CSS = "facturaCss";
	public final static String ID_SESSION_PLANTILLA_FACTURA_XSL = "facturaXsl";
	public final static String ID_SESSION_PLANTILLA_XHTML2FO = "xhtml2fo";
	public final static String ID_SESSION_IMAGE_NOT_FOUND_UTPL = "pIdSessionImageNotFoundUtpl";
	public final static String ID_SESSION_PLANTILLA_COMPROBANTE_FISICO_XML = "pComprobanteFisicoXml";
	public final static String ID_SESSION_PLANTILLA_CONSOLIDADR_ANEXO_GASTOS_XLS = "pConsolidarAnexoGastosXls";
	public final static String ID_SESSION_PLANTILLA_CONSOLIDADR_ANEXO_GASTOS_XML = "pConsolidarAnexoGastosXml";
	
	public final static String PROTOCOLO_MAIL = "smtp";
	
	public final static Long ID_EMPRESA_DEFAULT = 1L;
	public final static Long ID_USUARIO_DEFAULT = 1L;
	
	public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public final static String UNIVERSO_PASSWORD = "abcdefghjklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ0123456789@#$%";
	public final static String PATRON_PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{0,8})";
	
	public static final String PATH_PLANTILLA_REGISTRO_RECUPERACION_CLAVE_HTML = "templates/registroRecuperacionClaveEmail.html";
	public static final String PATH_PLANTILLA_ERROR_PROCESAR_SRI_HTML = "templates/errorProcesarSriEmail.html";
	public static final String PATH_PLANTILLA_FACTURA_CSS = "templates/facturaCss.css";
	public static final String PATH_PLANTILLA_FACTURA_XSL = "templates/facturaXsl.xsl";
	public final static String PATH_PLANTILLA_XHTML2FO = "templates/xhtml2fo.xsl";
	public static final String PATH_PLANTILLA_COMPROBANTE_FISICO_XML = "templates/comprobante-fisico.xml";
	public static final String PATH_PLANTILLA_CONSOLIDAR_ANEXO_GASTOS_XLS = "templates/consolidar-anexo-gastos.xls";
	public static final String PATH_PLANTILLA_CONSOLIDAR_ANEXO_GASTOS_XML = "templates/consolidar-anexo-gastos.xml";
	public static final String PATH_PLANTILLA_ANEXOS_GASTOS_SRI_XLS = "templates/anexo-gastos-sri.xls";
	
	public final static String MSJ_VERIFICAR_EMAIL_OLVIDO_CLAVE = "Paso 1: Verificar Direcci\u00f3n de Email del Usuario";
	public final static String MSJ_PREGUNTA_SECRETA_OLVIDO_CLAVE = "Paso 2: Verificar Pregunta de Seguridad del Usuario";
	public final static String MSJ_RECUPERACION_EXITOSA_OLVIDO_CLAVE = "Paso 3: Recuperaci\u00f3n Exitosa de la Clave del Usuario ";
	
	public final static String AUTORIZACION_PRODUCCION_OFFLINE_WSDL = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";
	public final static String NAMESPACE_URI_AUTORIZACION = "http://ec.gob.sri.ws.autorizacion";
	public final static String LOCAL_PART_AUTORIZACION_OFFLINE = "AutorizacionComprobantesOfflineService";
	
	public final static String SRC_MANUAL = "manual";
	public final static String SRC_WEB = "web";
	public final static String SRC_WS = "ws";
	public final static String SRC_FILE = "file";
	
	public final static String DOWNLOAD_WEB = "downloadWeb";
	
	public static final String RESOURCE_FACTURA_CSS = "src/main/resources/factura.css";
	public static final String RESOURCE_FACTURA_XSL = "src/main/resources/factura.xsl";
	
	public final static String ENCABEZADO_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	public final static String ENCABEZADO_XML_LOWER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	public final static String ANCHO_CODIGO_BARRAS = "widthCodigoBarras";
	public static final String VALOR_ANCHO_CODIGO_BARRAS_73 = "73%";
	public final static String PATH_MARCA_AGUA_PDF = "/resources/img/fondo_imprimir.png";
	
	public static final Integer BARCODE_HEIGHT = 50;
	public static final Integer BARCODE_WIDTH = 1;
	
	public static final String PATH_DIR_TEMPLATES = "C:/Users/Kruger/Desktop/u/semestre-oct-2017-feb-2018/tesis/java/templates/";
	public static final String NAME_TEMPLATE_XSL = "facturaXsl.xsl";
	
	public static final String IMAGE_DATA_BASE_64 = "data:image/png;base64,";
	public static final String PATH_DIR_IMAGES = "C:/Users/Kruger/Desktop/u/semestre-oct-2017-feb-2018/tesis/java/img/";
	public static final String NAME_IMAGE_NOT_FOUND_UTPL = "not-found-utpl.png";
	public static final String IMAGE_BASE64_NOT_FOUND_UTPL = "data:image/png;base64,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";
	
	public static final String CARGA_BY_ARCHIVO = "1";
	public static final String CARGA_BY_MANUAL = "2";
	
	public static final Integer MAX_ROWS_TABLA = 35;
	
	public static final Integer TYPE_ORDER_ASC = 1;
	public static final Integer TYPE_ORDER_DESC = 2;
	
	public final static String MODULO_CORE = "CORE";
	public final static String MODULO_LN = "LN";
	public final static String MODULO_WEB = "WEB";
	public final static String MODULO_WS = "WS";
	
	public final static String NIVEL_ERROR = "ERROR";
	public final static String NIVEL_FATAL = "FATAL";
	public final static String NIVEL_WARN = "WARN";
	public final static String NIVEL_INFO = "INFO";
	
	public final static String MSJ_ERROR_CUASA = ". Causa --> ";
	
	public final static String ALGORITHM_SHA_512 = "SHA-512";
	public final static String ALGORITHM_MD5 = "MD5";
	public final static String ALGORITHM_DESEDE = "DESede";
	
	public final static String SECRET_KEY = "utplsgacec";
	public final static String ENCODING_UTF8 = "UTF-8";

}
