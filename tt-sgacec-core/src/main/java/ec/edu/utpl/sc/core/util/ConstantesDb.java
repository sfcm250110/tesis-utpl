package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class ConstantesDb implements Serializable {
	
	private static final long serialVersionUID = 4598396573279368409L;
	
	public static final String SP_INIT_RUN_JOB = "{CALL DBMS_SCHEDULER.RUN_JOB('";
	public static final String SP_END_RUN_JOB = "')}";
	public static final String SP_CREATE_TABLE_COMPROBANTE = "{CALL CREATE_TABLE_COMPROBANTE(?)}";
	
	public static final String NAME_FUNCTION_CREATE_TABLE_COMPROBANTE = "create_table_comprobante";
	public static final String PARAM_FUNCTION_RUC = "p_ruc";
	
	public static final String PARAM_ETAPA = "param_etapa";
	public static final String PARAM_TOTAL_FILAS = "param_total_filas";
	public static final String PARAM_FECHA_DOWNLOAD = "param_fecha_download";
	public static final String PARAM_CLAVE_ACCESO = "param_clave_acceso";
	public static final String PARAM_NUMERO_AUTORIZACION = "param_numero_autorizacion";
	public static final String PARAM_XML = "param_xml";
	public static final String PARAM_PDF = "param_pdf";
	public static final String PARAM_CEDULA_RUC = "param_cedula_ruc";
	public static final String PARAM_CLAVE = "param_clave";
	public final static String PARAM_USER_NAME = "param_username";
	public final static String PARAM_CLAVE_UNO = "param_clave_uno";
	public final static String PARAM_ID_USUARIO = "param_id_usuario";
	public final static String PARAM_ESTADO = "param_estado";
	public final static String PARAM_SRC = "param_src";
	public final static String PARAM_CLASIFICADO = "param_clasificado";
	public final static String PARAM_VIVIENDA = "param_vivienda";
	public final static String PARAM_EDUCACION = "param_educacion";
	public final static String PARAM_ALIMENTACION = "param_alimentacion";
	public final static String PARAM_VESTIMENTA = "param_vestimenta";
	public final static String PARAM_SALUD = "param_salud";
	public final static String PARAM_BASE_IMPONIBLE = "param_base_imponible";
	public final static String PARAM_RUC_EMISOR = "param_ruc_emisor";
	public final static String PARAM_ESTABLECIMIENTO = "param_establecimiento";
	public final static String PARAM_PUNTO_EMISION = "param_punto_emision";
	public final static String PARAM_SECUENCIAL = "param_secuencial";
	public final static String PARAM_PERIODO = "param_periodo";
	public final static String PARAM_RUC = "param_ruc";
	
	public static final String TABLE_UTPL_COMPROBANTE = "utpl_comprobante";
	
	public static final String LABEL_SELECT = "Select";
	public static final String LABEL_FROM = "From";
	public static final String LABEL_AS = "As";
	
	public final static String COMPROBANTES_EMPRESA_SRC = "Select clave_acceso As claveAcceso, ruc As ruc, numero_autorizacion As numeroAutorizacion, fecha_emision As fechaEmision From utpl_comprobante Where estado = " + PARAM_SRC;
	public final static String COMPROBANTES_EMPRESA_ESTADO = "Select clave_acceso As claveAcceso, ruc As ruc, numero_autorizacion As numeroAutorizacion, fecha_emision As fechaEmision From utpl_comprobante Where estado = " + PARAM_ESTADO;
	public final static String COMPROBANTES_EMPRESA_REGISTRADO = "Select clave_acceso As claveAcceso, ruc As ruc, numero_autorizacion As numeroAutorizacion From utpl_comprobante Where estado = 1";
	public final static String COMPROBANTE_EMPRESA_NA = "Select clave_acceso As claveAcceso From utpl_comprobante Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String USUARIO_LOGIN = "Select u.idUsuario As idUsuario, u.userName As userName, u.nombres As nombres, u.apellidos As apellidos From Usuario u Where u.cedulaRuc = '" + PARAM_CEDULA_RUC + "' And u.claveUno = '" + PARAM_CLAVE + "'";
	public final static String XML_COMPROBANTE_EMPRESA_NA = "Select xml As xml From utpl_comprobante Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String RUCS_EMPRESA = "Select ruc As ruc From Empresa Where ruc Not In ('1000000000001')";
	public final static String RUC_EMISORES = "Select Distinct ruc_emisor As rucEmisor From utpl_comprobante";
	public final static String INFO_RUCS_SRI = "Select ruc As ruc From InfoRucSri";
	public final static String COMPROBANTES_EMPRESA_CLASIFICAR = "Select ruc_emisor As rucEmisor, xml As xml,  ruc As ruc, numero_autorizacion As numeroAutorizacion From utpl_comprobante Where estado = 3 And tipo = 1";
	
	public final static String USUARIO_LOGIN_NATIVE = "Select u.id_usuario, u.user_name From utpl_usuario u Where u.cedula_ruc = '" + PARAM_CEDULA_RUC + "' And u.clave_uno = '" + PARAM_CLAVE + "'";
	
	public final static String INSERT_COMPROBANTE_XML = "Insert Into utpl_comprobante(clave_acceso, establecimiento, fecha_autorizacion, fecha_emision, fecha_registro, fila, numero_autorizacion, punto_emision, razon_social_emisor, ruc_emisor, secuencial, tipo, tipo_emision, ruc, estado, src, clasificado) Values(:pClaveAcceso, :pEstablecimiento, :pFechaAutorizacion, :pFechaEmision, :pFechaRegistro, :pFila, :pNumeroAutorizacion, :pPuntoEmision, :pRazonSocialEmisor, :pRucEmisor, :pSecuencial, :pTipo, :pTipoEmision, :pRuc, :pEstado, :pSrc, :pClasificado)";
	
	public final static String UPDATE_COMPROBANTE_XML = "Update utpl_comprobante Set xml = '" + PARAM_XML + "' Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String UPDATE_COMPROBANTE_PDF = "Update utpl_comprobante Set pdf = '" + PARAM_PDF + "' Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String UPDATE_COMPROBANTE_ESTADO = "Update utpl_comprobante Set estado = " + PARAM_ESTADO + " Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String UPDATE_COMPROBANTE_XML_ESTADO = "Update utpl_comprobante Set xml = '" + PARAM_XML + "', estado = " + PARAM_ESTADO + " Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String UPDATE_COMPROBANTE_CLASIFICAR = "Update utpl_comprobante Set estado = " + PARAM_ESTADO + " Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String UPDATE_COMPROBANTE_CLASIFICADO = "Update utpl_comprobante Set estado = " + PARAM_ESTADO + ", clasificado = '" + PARAM_CLASIFICADO + "', vivienda = " + PARAM_VIVIENDA + ", educacion = " + PARAM_EDUCACION + ", alimentacion = " + PARAM_ALIMENTACION + ", vestimenta = " + PARAM_VESTIMENTA + ", salud = " + PARAM_SALUD + ", base_imponible = " + PARAM_BASE_IMPONIBLE + " Where numero_autorizacion = '" + PARAM_NUMERO_AUTORIZACION + "'";
	public final static String UPDATE_COMPROBANTE_RE_CLASIFICADO = "Update utpl_comprobante Set clasificado = '" + PARAM_CLASIFICADO + "', vivienda = " + PARAM_VIVIENDA + ", educacion = " + PARAM_EDUCACION + ", alimentacion = " + PARAM_ALIMENTACION + ", vestimenta = " + PARAM_VESTIMENTA + ", salud = " + PARAM_SALUD + " Where ruc_emisor = '" + PARAM_RUC_EMISOR + "' And establecimiento = '" + PARAM_ESTABLECIMIENTO + "' And punto_emision = '" + PARAM_PUNTO_EMISION + "' And secuencial = '" + PARAM_SECUENCIAL + "'";
	public final static String UPDATE_COMPROBANTE_RE_CLASIFICADO_FISICO = "Update utpl_comprobante_fisico Set clasificado = '" + PARAM_CLASIFICADO + "', vivienda = " + PARAM_VIVIENDA + ", educacion = " + PARAM_EDUCACION + ", alimentacion = " + PARAM_ALIMENTACION + ", vestimenta = " + PARAM_VESTIMENTA + ", salud = " + PARAM_SALUD + " Where ruc_emisor = '" + PARAM_RUC_EMISOR + "' And establecimiento = '" + PARAM_ESTABLECIMIENTO + "' And punto_emision = '" + PARAM_PUNTO_EMISION + "' And secuencial = '" + PARAM_SECUENCIAL + "'";
	
	public final static String CHECK_DOWNLOAD_SRI_EJBQL = 
			"  Select cds.idCheckDownloadSri, cds.ruc, cds.fechaDownload "
			+ "  From CheckDownloadSri cds "
			+ " Where cds.totalFilas > 0"
			+ "   And cds.totalFilas <= " + PARAM_TOTAL_FILAS
			+ "   And cds.etapa = " + PARAM_ETAPA;
	
	public final static String CHECK_DOWNLOAD_SRI_ETAPA_EJBQL = 
			"  Select cds.idCheckDownloadSri, cds.ruc, cds.fechaDownload "
			+ "  From CheckDownloadSri cds "
			+ " Where cds.etapa = " + PARAM_ETAPA;
	
	public final static String CHECK_DOWNLOAD_SRI_FECHA_DOWNLOAD_EJBQL = 
			"  Select cds.idCheckDownloadSri As idCheckDownloadSri, cds.ruc As ruc, cds.etapa As etapa, cds.fechaProceso As fechaProceso, cds.fila As fila, cds.totalFilas As totalFilas, cds.paginado As paginado, cds.totalPaginas As totalPaginas "
			+ "  From CheckDownloadSri cds "
			+ " Where ruc = '" + PARAM_RUC + "'"
			+ "  And to_char(cds.fechaDownload, 'YYYY-MM-dd') = '" + PARAM_FECHA_DOWNLOAD + "'";
	
	public final static String ROL_USUARIO_EJBQL = 
			  " Select ru"
			+ "   From RolUsuario ru"
			+ "  Where ru.userName = '" + PARAM_USER_NAME + "'";
	
	public final static String EMPRESAS_USUARIO_EJBQL = 
			  " Select e"
			+ "   From UsuarioEmpresa ue, Empresa e"
			+ "  Where ue.empresa.idEmpresa = e.idEmpresa"
			+ "    And ue.usuario.idUsuario = " + PARAM_ID_USUARIO;
	
	public final static String UPDATE_NQ_CLAVE_USUARIO = 
            " UPDATE UTPL_USUARIO"
          + "    SET CLAVE_UNO = '" + PARAM_CLAVE_UNO + "'"
          + "  WHERE USER_NAME = '" + PARAM_USER_NAME + "'";
	
	public final static String ANEXO_GASTOS_ELECTRONICO = "Select anexo.rucEmisor As rucEmisor, anexo.baseImponible As baseImponible, anexo.cantidadComprobantes As cantidadComprobantes, anexo.tipoGasto As tipoGasto From ( "
			+ "Select ruc_emisor As rucEmisor, Sum(vivienda) As baseImponible, Count(*) As cantidadComprobantes, 'VIVIENDA' As tipoGasto from utpl_comprobante Where clasificado = 't' And estado = 6 And vivienda > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(educacion) As baseImponible, Count(*) As cantidadComprobantes, 'EDUCACION' As tipoGasto from utpl_comprobante Where clasificado = 't' And estado = 6 And educacion > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(alimentacion) As baseImponible, Count(*) As cantidadComprobantes, 'ALIMENTACION' As tipoGasto from utpl_comprobante Where clasificado = 't' And estado = 6 And alimentacion > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(vestimenta) As baseImponible, Count(*) As cantidadComprobantes, 'VESTIMENTA' As tipoGasto from utpl_comprobante Where clasificado = 't' And estado = 6 And vestimenta > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(salud) As baseImponible, Count(*) As cantidadComprobantes, 'SALUD' As tipoGasto from utpl_comprobante Where clasificado = 't' And estado = 6 And salud > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ ") anexo Order By anexo.rucEmisor, anexo.tipoGasto";
	
	public final static String ANEXO_GASTOS_FISICO = "Select anexo.rucEmisor As rucEmisor, anexo.baseImponible As baseImponible, anexo.cantidadComprobantes As cantidadComprobantes, anexo.tipoGasto As tipoGasto From ( "
			+ "Select ruc_emisor As rucEmisor, Sum(vivienda) As baseImponible, Count(*) As cantidadComprobantes, 'VIVIENDA' As tipoGasto from utpl_comprobante_fisico Where clasificado = 't' And vivienda > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(educacion) As baseImponible, Count(*) As cantidadComprobantes, 'EDUCACION' As tipoGasto from utpl_comprobante_fisico Where clasificado = 't' And educacion > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(alimentacion) As baseImponible, Count(*) As cantidadComprobantes, 'ALIMENTACION' As tipoGasto from utpl_comprobante_fisico Where clasificado = 't' And alimentacion > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(vestimenta) As baseImponible, Count(*) As cantidadComprobantes, 'VESTIMENTA' As tipoGasto from utpl_comprobante_fisico Where clasificado = 't' And vestimenta > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ "Union "
			+ "Select ruc_emisor As rucEmisor, Sum(salud) As baseImponible, Count(*) As cantidadComprobantes, 'SALUD' As tipoGasto from utpl_comprobante_fisico Where clasificado = 't' And salud > 0 And date_part('year', fecha_emision) = '" +  PARAM_PERIODO + "' Group By ruc_emisor "
			+ ") anexo Order By anexo.rucEmisor, anexo.tipoGasto";
	
	public final static String ERRORES_SISTEMA_EJBQL = "Select es.idErrorSistema As idErrorSistema, es.modulo As modulo, es.nivel As nivel, es.mensaje As mensaje, es.localizacion As localizacion, es.fechaRegistro As fechaRegistro From ErrorSistema es Order By es.fechaRegistro Desc";
	
	public final static String GET_PERIODOS = 
			  " Select Distinct p.periodo As periodo"
			+ "   From ValorMaximoRubroSri p";

}
