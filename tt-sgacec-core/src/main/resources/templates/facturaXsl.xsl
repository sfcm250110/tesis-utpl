<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:decimal-format name="numerico" NaN="" decimal-separator="," grouping-separator="." />
	
	<xsl:template match="/">
		<xsl:variable name="logoEmpresa" select="autorizacion/logoEmpresa" />
		<xsl:variable name="logoCodigoBarras" select="autorizacion/logoCodigoBarras" />
		
		<html>
			<table style="width:100%" cellpadding="3" cellspacing="3">
			<tbody>
				<tr>
					<td style="vertical-align: bottom;">
						<table style="width:100%">
						<tr>
							<td>
								<div align="center" style="padding-left: 20px;"><img src="{$logoEmpresa}"/></div>
							</td>
						</tr>
						<tr>
							<td style="border: 1px solid; padding: 5px 5px 5px 5px;">
								<p>
									<span style="font-family: 'Trebuchet MS'; font-size: 9px; font-weight: bold;">
										<xsl:value-of select="autorizacion/factura/infoTributaria/razonSocial" />
									</span>
								</p>
								<p>
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Dir. Matriz:
									</span>
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										<xsl:value-of select="autorizacion/factura/infoTributaria/dirMatriz" />
									</span>
									<br />
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Dir. Establecimiento:
									</span>
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										<xsl:value-of select="autorizacion/factura/infoFactura/dirEstablecimiento" />
									</span>
									<br />
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Contribuyente Especial Nro:
									</span>
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										<xsl:value-of select="autorizacion/factura/infoFactura/contribuyenteEspecial" />
									</span>
									<br />
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Obligado a llevar contabilidad:
									</span>
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
										<xsl:value-of select="autorizacion/factura/infoFactura/obligadoContabilidad" />
									</span>
									<br />
								</p>
							</td>
						</tr>
					</table>
					</td >
					<td style="vertical-align: bottom;">
						<table style="width:100%">
							<tr>
								<td style="border: 1px solid; padding: 5px 5px 5px 5px;">
									<p>
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
											RUC:
										</span>
										<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
											<xsl:value-of select="autorizacion/factura/infoTributaria/ruc" />
										</span>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 10px; font-weight: bold;">FACTURA</span>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
											Nro.
										</span>
										<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
											<xsl:value-of select="autorizacion/factura/infoTributaria/estab"/>-<xsl:value-of select="autorizacion/factura/infoTributaria/ptoEmi"/>-<xsl:value-of select="autorizacion/factura/infoTributaria/secuencial"/>
										</span>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
											N&#250;mero de Autorizaci&#243;n:
										</span>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
											<xsl:value-of select="autorizacion/numeroAutorizacion"/>
										</span>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
											Fecha y Hora de Autorizaci&#243;n:
										</span>
										<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
											<xsl:value-of select="autorizacion/fechaAutorizacion"/>
										</span>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
											Ambiente:
										</span>
										<span style="font-family: 'Trebuchet MS'; font-size: 8px;">PRODUCCI&#211;N</span>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
											Emisi&#243;n:
										</span>
										<xsl:if test="autorizacion/factura/infoTributaria/tipoEmision = '1'">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px;">NORMAL</span>
										</xsl:if>
										<xsl:if test="autorizacion/factura/infoTributaria/tipoEmision = '2'">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px;">INDISPONIBILIDAD</span>
										</xsl:if>
										<br />
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
											Clave de Acceso
										</span>
										<br />
										<div style="text-align: center;">
											<div border="1" align="middle" class="codigoBarras" src="{$logoCodigoBarras}">&#xA0;</div>
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; letter-spacing: 0.06em; text-align: center;">
												<xsl:value-of select="autorizacion/factura/infoTributaria/claveAcceso"/>
											</span>
										</div>	
									</p>
								</td>
							</tr>
						</table>
					
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<table cellspacing="0" cellpadding="0" style="border:solid 1px; width:100%; height:auto">
							<tr>
								<td style="padding:5px;">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Raz&#243;n Social/Nombres y Apellidos:
									</span>
								</td>
								<td style="padding:5px; height:auto">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										<xsl:value-of select="autorizacion/factura/infoFactura/razonSocialComprador" />
									</span>
								</td>
								<td style="padding:5px;">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Identificaci&#243;n:
									</span>
								</td>
								<td style="padding:5px;">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										<xsl:value-of select="autorizacion/factura/infoFactura/identificacionComprador" />
									</span>
								</td>
							</tr>
							<tr>
								<td style="padding:5px;">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Fecha Emisi&#243;n:
									</span>
								</td>
								<td style="padding:5px;">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										<xsl:value-of select="autorizacion/factura/infoFactura/fechaEmision" />
									</span>
								</td>
								<td style="padding:5px;">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
										Gu&#237;a Remisi&#243;n:
									</span>
								</td>
								<td style="padding:5px;">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										<xsl:value-of select="autorizacion/factura/infoFactura/guiaRemision" />
									</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<table cellpadding="0" cellspacing="0" border = "1" style="width:100%">
							<tr>
								<th align="center" style="padding:1px;" valign="middle">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										Cod.<br />Principal
									</span>
								</th>
								<th align="center" style="padding:1px;" valign="middle">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										Cod.<br />Auxiliar
									</span>
								</th>
								<th align="center" style="padding:1px;" valign="middle">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										Cant.
									</span>
								</th>
								<th align="center" style="padding:1px; width: 9.3cm;" valign="middle">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										Descripci&#243;n
									</span>
								</th>
								<th align="center" style="padding:1px;" valign="middle">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										Precio<br />Unitario
									</span>
								</th>
								<th align="center" style="padding:1px;" valign="middle">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										Descuento
									</span>
								</th>
								<th align="center" style="padding:1px;" valign="middle">
									<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
										Precio<br />Total
									</span>
								</th>
							</tr>
							<xsl:for-each select="autorizacion/factura/detalles/detalle">
								<tr>
									<td align="left" valign="middle" style="padding:1px;">
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
											<xsl:value-of select="codigoPrincipal" />
										</span>
									</td>
									
									<td align="left" valign="middle" style="padding:1px;">
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
											<xsl:value-of select="codigoAuxiliar" />
										</span>
									</td>
									<td align="left" valign="middle" style="padding:1px;">
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
											<xsl:value-of select="format-number(cantidad,'###.##0,00','numerico')" />
										</span>
									</td>
									<td align="left" valign="middle" style="padding:1px;">
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
											<xsl:value-of select="descripcion" />
										</span>
									</td>
									<td align="right" valign="middle" style="padding:1px;">
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
											<xsl:value-of select="format-number(precioUnitario,'###.##0,00','numerico')" />
										</span>
									</td>
									<td align="right" valign="middle" style="padding:1px;">
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
											<xsl:value-of select="format-number(descuento,'###.##0,00','numerico')" />
										</span>
									</td>
									<td align="right" valign="middle" style="padding:1px;">
										<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
											<xsl:value-of select="format-number(precioTotalSinImpuesto,'###.##0,00','numerico')" />
										</span>
									</td>
								</tr>
							</xsl:for-each>
						</table>
					</td>
				</tr>
			</tbody>		
			</table>
			<table cellpadding="4" cellspacing="4">
				<tbody>
					<tr>
						<td>
							<table style="width:100%" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td>	
											<table style="width:100%" cellpadding="0" cellspacing="0">
												<tbody>
													<tr>
														<td align="left" style="padding:5px; border:solid 1px; vertical-align: bottom;">
															<span style="font-family: 'Trebuchet MS'; font-size: 8px;  font-weight: bold;  ">
																Informaci&#243;n Adicional
																<br/><br/>
															</span>

															<xsl:for-each select="autorizacion/factura/infoAdicional/campoAdicional">
																<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;  line-height:10px;">
																	<xsl:value-of select="@nombre" />:
																</span>
																<span style="font-family: 'Trebuchet MS'; font-size: 8px; line-height:10px;">
																	<xsl:value-of select="text()" />
																</span>
																<br/>
															</xsl:for-each>
														</td>
													</tr>
												</tbody>		
											</table>
										</td>
									</tr>
									<tr>
										<td>	
											<table cellpadding="0" cellspacing="0" border = "1" style="width:100%">
												<tr>
													<th align="center" style="padding:1px;" valign="middle">
														<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
															Forma de Pago
														</span>
													</th>
													<th align="center" style="padding:1px;" valign="middle">
														<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
															Valor
														</span>
													</th>
												</tr>
												<xsl:for-each select="autorizacion/factura/infoFactura/pagos/pago">
													<tr>
														<td align="left" valign="middle" style="padding:1px;">
															<xsl:choose>
																<xsl:when test="formaPago = 01">
																	<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
																		SIN UTILIZACI&#211;N DEL SISTEMA FINANCIERO
																	</span>
																</xsl:when>
																<xsl:when test="formaPago = 16">
																	<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
																		TARJETA DE D&#201;BITO
																	</span>
																</xsl:when>
																<xsl:when test="formaPago = 17">
																	<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
																		DINERO ELECTR&#211;NICO
																	</span>
																</xsl:when>
																<xsl:when test="formaPago = 18">
																	<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
																		TARJETA PREPAGO
																	</span>
																</xsl:when>
																<xsl:when test="formaPago = 19">
																	<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
																		TARJETA DE CR&#201;DITO
																	</span>
																</xsl:when>
																<xsl:when test="formaPago = 20">
																	<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
																		OTROS CON UTILIZACI&#211;N DEL SISTEMA FINANCIERO
																	</span>
																</xsl:when>
																<xsl:when test="formaPago = 21">
																	<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
																		ENDOSO DE T&#205;TULOS 
																	</span>
																</xsl:when>
															</xsl:choose>
														</td>

														<td align="right" valign="middle" style="padding:1px;">
															<span style="font-family: 'Trebuchet MS'; font-size: 8px; ">
																<xsl:value-of select="format-number(total,'###.##0,00','numerico')" />
															</span>
														</td>
													</tr>
												</xsl:for-each>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
						<td>
							<table style="width:100%" border = "1" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td align="left" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- Subtotal 12%-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 2)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;  ">
														SUBTOTAL 12%
													</span>
												</xsl:if>
												<!-- Subtotal 14%-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 3)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;  ">
														SUBTOTAL 14%
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
										<td align="right" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- total con iva y porcentaje 12%-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 2 or codigoPorcentaje = 3)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px;  ">
														<xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
									<tr>
										<td align="left" style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												SUBTOTAL 0%
											</span>
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- total con iva y porcentaje 0%-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 0)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
														<xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
									<tr>
										<td align="left" style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												SUBTOTAL No objeto de IVA
											</span>
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- total no objeto de iva-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 6)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
														<xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
									<tr>
										<td align="left" style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												SUBTOTAL Excento de IVA
											</span>
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- total excento de iva-->
												<xsl:if test="(codigo=2) and (codigoPorcentaje = 7)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
														<xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
									<tr>
										<td align="left" style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												SUBTOTAL SIN IMPUESTOS
											</span>
										</td>
										<td align="right" style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
												<xsl:value-of select="format-number(autorizacion/factura/infoFactura/totalSinImpuestos,'###.##0,00','numerico')" />
											</span>
										</td>
									</tr>
									<tr>
										<td style="padding:3px;" align="left">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												TOTAL Descuento
											</span>
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
												<xsl:value-of select="format-number(autorizacion/factura/infoFactura/totalDescuento,'###.##0,00','numerico')" />
											</span>
										</td>
									</tr>
									<tr>
										<td style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												ICE
											</span>
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- total excento de iva-->
												<xsl:if test="(codigo = 3) and (codigoPorcentaje &gt; 3000)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
														<xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
									<tr>
										<td style="padding:3px;" align="left">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- IVA 12%-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 2)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
														IVA 12%
													</span>
												</xsl:if>
												<!-- IVA 14%-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 3)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
														IVA 14%
													</span>
												</xsl:if>
											</xsl:for-each>
											
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- total excento de iva-->
												<xsl:if test="(codigo = 2) and (codigoPorcentaje = 2 or codigoPorcentaje = 3)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px ">
														<xsl:value-of select="format-number(valor,'###.##0,00','numerico')" />
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
									<tr>
										<td style="padding:3px;" align="left">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												IRBPNR
											</span>
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<xsl:for-each select="autorizacion/factura/infoFactura/totalConImpuestos/totalImpuesto">
												<!-- total excento de iva-->
												<xsl:if test="(codigo = 5) and (codigoPorcentaje &gt; 3000)">
													<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
														<xsl:value-of select="format-number(valor,'###.##0,00','numerico')" />
													</span>
												</xsl:if>
											</xsl:for-each>
										</td>
									</tr>
									<tr>
										<td style="padding:3px;" align="left">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												PROPINA
											</span>
										</td>
										<td align="right" valign="middle" style="padding:3px;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px;">
												<xsl:value-of select="format-number(autorizacion/factura/infoFactura/propina,'###.##0,00','numerico')" />
											</span>
										</td>
									</tr>
									<tr>
										<td align="left" style="padding: 3px;" >
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												VALOR TOTAL
											</span>
										</td>
										<td align="right" style="padding: 3px; font-weight: bold;">
											<span style="font-family: 'Trebuchet MS'; font-size: 8px; font-weight: bold;">
												<xsl:value-of select="format-number(autorizacion/factura/infoFactura/importeTotal,'###.##0,00','numerico')" />
											</span>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</html>
		
	</xsl:template>
</xsl:stylesheet>