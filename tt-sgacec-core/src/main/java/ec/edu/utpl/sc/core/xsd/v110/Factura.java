//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.11.30 a las 05:58:51 AM COT 
//


package ec.edu.utpl.sc.core.xsd.v110;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infoTributaria" type="{}infoTributaria"/>
 *         &lt;element name="infoFactura">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fechaEmision" type="{}fechaEmision"/>
 *                   &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/>
 *                   &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
 *                   &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
 *                   &lt;element name="comercioExterior" type="{}comercioExterior" minOccurs="0"/>
 *                   &lt;element name="incoTermFactura" type="{}incoTermFactura" minOccurs="0"/>
 *                   &lt;element name="lugarIncoTerm" type="{}lugarIncoTerm" minOccurs="0"/>
 *                   &lt;element name="paisOrigen" type="{}paisOrigen" minOccurs="0"/>
 *                   &lt;element name="puertoEmbarque" type="{}puertoEmbarque" minOccurs="0"/>
 *                   &lt;element name="puertoDestino" type="{}puertoDestino" minOccurs="0"/>
 *                   &lt;element name="paisDestino" type="{}paisDestino" minOccurs="0"/>
 *                   &lt;element name="paisAdquisicion" type="{}paisAdquisicion" minOccurs="0"/>
 *                   &lt;element name="tipoIdentificacionComprador" type="{}tipoIdentificacionComprador"/>
 *                   &lt;element name="guiaRemision" type="{}guiaRemision" minOccurs="0"/>
 *                   &lt;element name="razonSocialComprador" type="{}razonSocialComprador"/>
 *                   &lt;element name="identificacionComprador" type="{}identificacionComprador"/>
 *                   &lt;element name="direccionComprador" type="{}direccionComprador" minOccurs="0"/>
 *                   &lt;element name="totalSinImpuestos" type="{}totalSinImpuestos"/>
 *                   &lt;element name="totalSubsidio" type="{}totalSubsidio" minOccurs="0"/>
 *                   &lt;element name="incoTermTotalSinImpuestos" type="{}incoTermTotalSinImpuestos" minOccurs="0"/>
 *                   &lt;element name="totalDescuento" type="{}totalDescuentos"/>
 *                   &lt;element name="codDocReembolso" type="{}codigoDocumentoReembolso" minOccurs="0"/>
 *                   &lt;element name="totalComprobantesReembolso" type="{}totalComprobantesReembolso" minOccurs="0"/>
 *                   &lt;element name="totalBaseImponibleReembolso" type="{}totalBaseImponibleReembolso" minOccurs="0"/>
 *                   &lt;element name="totalImpuestoReembolso" type="{}totalImpuestoReembolso" minOccurs="0"/>
 *                   &lt;element name="totalConImpuestos">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="totalImpuesto" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigo" type="{}codigo"/>
 *                                       &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
 *                                       &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
 *                                       &lt;element name="baseImponible" type="{}baseImponible"/>
 *                                       &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
 *                                       &lt;element name="valor" type="{}valor"/>
 *                                       &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="compensaciones" type="{}compensaciones" minOccurs="0"/>
 *                   &lt;element name="propina" type="{}propina" minOccurs="0"/>
 *                   &lt;element name="fleteInternacional" type="{}fleteInternacional" minOccurs="0"/>
 *                   &lt;element name="seguroInternacional" type="{}seguroInternacional" minOccurs="0"/>
 *                   &lt;element name="gastosAduaneros" type="{}gastosAduaneros" minOccurs="0"/>
 *                   &lt;element name="gastosTransporteOtros" type="{}gastosTransporteOtros" minOccurs="0"/>
 *                   &lt;element name="importeTotal" type="{}importeTotal"/>
 *                   &lt;element name="moneda" type="{}moneda" minOccurs="0"/>
 *                   &lt;element name="pagos" type="{}pagos" minOccurs="0"/>
 *                   &lt;element name="valorRetIva" type="{}valorRetIva" minOccurs="0"/>
 *                   &lt;element name="valorRetRenta" type="{}valorRetRenta" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="detalles">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="detalle" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoPrincipal" type="{}codigoPrincipal" minOccurs="0"/>
 *                             &lt;element name="codigoAuxiliar" type="{}codigoAuxiliar" minOccurs="0"/>
 *                             &lt;element name="descripcion" type="{}descripcion"/>
 *                             &lt;element name="unidadMedida" type="{}unidadMedida" minOccurs="0"/>
 *                             &lt;element name="cantidad" type="{}cantidad"/>
 *                             &lt;element name="precioUnitario" type="{}precioUnitario"/>
 *                             &lt;element name="precioSinSubsidio" type="{}precioSinSubsidio" minOccurs="0"/>
 *                             &lt;element name="descuento" type="{}descuento"/>
 *                             &lt;element name="precioTotalSinImpuesto" type="{}precioTotalSinImpuesto"/>
 *                             &lt;element name="detallesAdicionales" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="detAdicional" maxOccurs="3">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="nombre" use="required">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;pattern value="[^\n]*"/>
 *                                                     &lt;minLength value="1"/>
 *                                                     &lt;maxLength value="300"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="valor" use="required">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;pattern value="[^\n]*"/>
 *                                                     &lt;minLength value="1"/>
 *                                                     &lt;maxLength value="300"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="impuestos">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="reembolsos" type="{}reembolsos" minOccurs="0"/>
 *         &lt;element name="retenciones" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="retencion" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigo" type="{}codigoRetencion"/>
 *                             &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeRetencion"/>
 *                             &lt;element name="tarifa" type="{}tarifaRetencion"/>
 *                             &lt;element name="valor" type="{}valorRetencion"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="infoAdicional" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="campoAdicional" maxOccurs="15">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;>campoAdicional">
 *                           &lt;attribute name="nombre" use="required" type="{}nombre" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="comprobante"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infoTributaria",
    "infoFactura",
    "detalles",
    "reembolsos",
    "retenciones",
    "infoAdicional",
    "signature"
})
@XmlRootElement(name = "factura", namespace = "")
public class Factura {

    @XmlElement(required = true)
    protected InfoTributaria infoTributaria;
    @XmlElement(required = true)
    protected Factura.InfoFactura infoFactura;
    @XmlElement(required = true)
    protected Factura.Detalles detalles;
    protected Reembolsos reembolsos;
    protected Factura.Retenciones retenciones;
    protected Factura.InfoAdicional infoAdicional;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "version")
    @XmlSchemaType(name = "anySimpleType")
    protected String version;

    /**
     * Obtiene el valor de la propiedad infoTributaria.
     * 
     * @return
     *     possible object is
     *     {@link InfoTributaria }
     *     
     */
    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    /**
     * Define el valor de la propiedad infoTributaria.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoTributaria }
     *     
     */
    public void setInfoTributaria(InfoTributaria value) {
        this.infoTributaria = value;
    }

    /**
     * Obtiene el valor de la propiedad infoFactura.
     * 
     * @return
     *     possible object is
     *     {@link Factura.InfoFactura }
     *     
     */
    public Factura.InfoFactura getInfoFactura() {
        return infoFactura;
    }

    /**
     * Define el valor de la propiedad infoFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link Factura.InfoFactura }
     *     
     */
    public void setInfoFactura(Factura.InfoFactura value) {
        this.infoFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad detalles.
     * 
     * @return
     *     possible object is
     *     {@link Factura.Detalles }
     *     
     */
    public Factura.Detalles getDetalles() {
        return detalles;
    }

    /**
     * Define el valor de la propiedad detalles.
     * 
     * @param value
     *     allowed object is
     *     {@link Factura.Detalles }
     *     
     */
    public void setDetalles(Factura.Detalles value) {
        this.detalles = value;
    }

    /**
     * Obtiene el valor de la propiedad reembolsos.
     * 
     * @return
     *     possible object is
     *     {@link Reembolsos }
     *     
     */
    public Reembolsos getReembolsos() {
        return reembolsos;
    }

    /**
     * Define el valor de la propiedad reembolsos.
     * 
     * @param value
     *     allowed object is
     *     {@link Reembolsos }
     *     
     */
    public void setReembolsos(Reembolsos value) {
        this.reembolsos = value;
    }

    /**
     * Obtiene el valor de la propiedad retenciones.
     * 
     * @return
     *     possible object is
     *     {@link Factura.Retenciones }
     *     
     */
    public Factura.Retenciones getRetenciones() {
        return retenciones;
    }

    /**
     * Define el valor de la propiedad retenciones.
     * 
     * @param value
     *     allowed object is
     *     {@link Factura.Retenciones }
     *     
     */
    public void setRetenciones(Factura.Retenciones value) {
        this.retenciones = value;
    }

    /**
     * Obtiene el valor de la propiedad infoAdicional.
     * 
     * @return
     *     possible object is
     *     {@link Factura.InfoAdicional }
     *     
     */
    public Factura.InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Define el valor de la propiedad infoAdicional.
     * 
     * @param value
     *     allowed object is
     *     {@link Factura.InfoAdicional }
     *     
     */
    public void setInfoAdicional(Factura.InfoAdicional value) {
        this.infoAdicional = value;
    }

    /**
     *  Conjunto de datos asociados a la factura que garantizar�n la autor�a y la integridad del mensaje. Se define como opcional para facilitar la verificaci�n y el tr�nsito del fichero. No obstante, debe cumplimentarse este bloque de firma electr�nica para que se considere una factura electr�nica v�lida legalmente frente a terceros.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Define el valor de la propiedad signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="detalle" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoPrincipal" type="{}codigoPrincipal" minOccurs="0"/>
     *                   &lt;element name="codigoAuxiliar" type="{}codigoAuxiliar" minOccurs="0"/>
     *                   &lt;element name="descripcion" type="{}descripcion"/>
     *                   &lt;element name="unidadMedida" type="{}unidadMedida" minOccurs="0"/>
     *                   &lt;element name="cantidad" type="{}cantidad"/>
     *                   &lt;element name="precioUnitario" type="{}precioUnitario"/>
     *                   &lt;element name="precioSinSubsidio" type="{}precioSinSubsidio" minOccurs="0"/>
     *                   &lt;element name="descuento" type="{}descuento"/>
     *                   &lt;element name="precioTotalSinImpuesto" type="{}precioTotalSinImpuesto"/>
     *                   &lt;element name="detallesAdicionales" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="detAdicional" maxOccurs="3">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="nombre" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;pattern value="[^\n]*"/>
     *                                           &lt;minLength value="1"/>
     *                                           &lt;maxLength value="300"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="valor" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;pattern value="[^\n]*"/>
     *                                           &lt;minLength value="1"/>
     *                                           &lt;maxLength value="300"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="impuestos">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "detalle"
    })
    public static class Detalles {

        @XmlElement(required = true)
        protected List<Factura.Detalles.Detalle> detalle;

        /**
         * Gets the value of the detalle property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the detalle property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetalle().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Factura.Detalles.Detalle }
         * 
         * 
         */
        public List<Factura.Detalles.Detalle> getDetalle() {
            if (detalle == null) {
                detalle = new ArrayList<Factura.Detalles.Detalle>();
            }
            return this.detalle;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="codigoPrincipal" type="{}codigoPrincipal" minOccurs="0"/>
         *         &lt;element name="codigoAuxiliar" type="{}codigoAuxiliar" minOccurs="0"/>
         *         &lt;element name="descripcion" type="{}descripcion"/>
         *         &lt;element name="unidadMedida" type="{}unidadMedida" minOccurs="0"/>
         *         &lt;element name="cantidad" type="{}cantidad"/>
         *         &lt;element name="precioUnitario" type="{}precioUnitario"/>
         *         &lt;element name="precioSinSubsidio" type="{}precioSinSubsidio" minOccurs="0"/>
         *         &lt;element name="descuento" type="{}descuento"/>
         *         &lt;element name="precioTotalSinImpuesto" type="{}precioTotalSinImpuesto"/>
         *         &lt;element name="detallesAdicionales" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="detAdicional" maxOccurs="3">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="nombre" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;pattern value="[^\n]*"/>
         *                                 &lt;minLength value="1"/>
         *                                 &lt;maxLength value="300"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="valor" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;pattern value="[^\n]*"/>
         *                                 &lt;minLength value="1"/>
         *                                 &lt;maxLength value="300"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="impuestos">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codigoPrincipal",
            "codigoAuxiliar",
            "descripcion",
            "unidadMedida",
            "cantidad",
            "precioUnitario",
            "precioSinSubsidio",
            "descuento",
            "precioTotalSinImpuesto",
            "detallesAdicionales",
            "impuestos"
        })
        public static class Detalle {

            protected String codigoPrincipal;
            protected String codigoAuxiliar;
            @XmlElement(required = true)
            protected String descripcion;
            protected String unidadMedida;
            @XmlElement(required = true)
            protected BigDecimal cantidad;
            @XmlElement(required = true)
            protected BigDecimal precioUnitario;
            protected BigDecimal precioSinSubsidio;
            @XmlElement(required = true)
            protected BigDecimal descuento;
            @XmlElement(required = true)
            protected BigDecimal precioTotalSinImpuesto;
            protected Factura.Detalles.Detalle.DetallesAdicionales detallesAdicionales;
            @XmlElement(required = true)
            protected Factura.Detalles.Detalle.Impuestos impuestos;

            /**
             * Obtiene el valor de la propiedad codigoPrincipal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoPrincipal() {
                return codigoPrincipal;
            }

            /**
             * Define el valor de la propiedad codigoPrincipal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoPrincipal(String value) {
                this.codigoPrincipal = value;
            }

            /**
             * Obtiene el valor de la propiedad codigoAuxiliar.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoAuxiliar() {
                return codigoAuxiliar;
            }

            /**
             * Define el valor de la propiedad codigoAuxiliar.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoAuxiliar(String value) {
                this.codigoAuxiliar = value;
            }

            /**
             * Obtiene el valor de la propiedad descripcion.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescripcion() {
                return descripcion;
            }

            /**
             * Define el valor de la propiedad descripcion.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescripcion(String value) {
                this.descripcion = value;
            }

            /**
             * Obtiene el valor de la propiedad unidadMedida.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnidadMedida() {
                return unidadMedida;
            }

            /**
             * Define el valor de la propiedad unidadMedida.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnidadMedida(String value) {
                this.unidadMedida = value;
            }

            /**
             * Obtiene el valor de la propiedad cantidad.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getCantidad() {
                return cantidad;
            }

            /**
             * Define el valor de la propiedad cantidad.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setCantidad(BigDecimal value) {
                this.cantidad = value;
            }

            /**
             * Obtiene el valor de la propiedad precioUnitario.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPrecioUnitario() {
                return precioUnitario;
            }

            /**
             * Define el valor de la propiedad precioUnitario.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPrecioUnitario(BigDecimal value) {
                this.precioUnitario = value;
            }

            /**
             * Obtiene el valor de la propiedad precioSinSubsidio.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPrecioSinSubsidio() {
                return precioSinSubsidio;
            }

            /**
             * Define el valor de la propiedad precioSinSubsidio.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPrecioSinSubsidio(BigDecimal value) {
                this.precioSinSubsidio = value;
            }

            /**
             * Obtiene el valor de la propiedad descuento.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDescuento() {
                return descuento;
            }

            /**
             * Define el valor de la propiedad descuento.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDescuento(BigDecimal value) {
                this.descuento = value;
            }

            /**
             * Obtiene el valor de la propiedad precioTotalSinImpuesto.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPrecioTotalSinImpuesto() {
                return precioTotalSinImpuesto;
            }

            /**
             * Define el valor de la propiedad precioTotalSinImpuesto.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPrecioTotalSinImpuesto(BigDecimal value) {
                this.precioTotalSinImpuesto = value;
            }

            /**
             * Obtiene el valor de la propiedad detallesAdicionales.
             * 
             * @return
             *     possible object is
             *     {@link Factura.Detalles.Detalle.DetallesAdicionales }
             *     
             */
            public Factura.Detalles.Detalle.DetallesAdicionales getDetallesAdicionales() {
                return detallesAdicionales;
            }

            /**
             * Define el valor de la propiedad detallesAdicionales.
             * 
             * @param value
             *     allowed object is
             *     {@link Factura.Detalles.Detalle.DetallesAdicionales }
             *     
             */
            public void setDetallesAdicionales(Factura.Detalles.Detalle.DetallesAdicionales value) {
                this.detallesAdicionales = value;
            }

            /**
             * Obtiene el valor de la propiedad impuestos.
             * 
             * @return
             *     possible object is
             *     {@link Factura.Detalles.Detalle.Impuestos }
             *     
             */
            public Factura.Detalles.Detalle.Impuestos getImpuestos() {
                return impuestos;
            }

            /**
             * Define el valor de la propiedad impuestos.
             * 
             * @param value
             *     allowed object is
             *     {@link Factura.Detalles.Detalle.Impuestos }
             *     
             */
            public void setImpuestos(Factura.Detalles.Detalle.Impuestos value) {
                this.impuestos = value;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="detAdicional" maxOccurs="3">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="nombre" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;pattern value="[^\n]*"/>
             *                       &lt;minLength value="1"/>
             *                       &lt;maxLength value="300"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="valor" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;pattern value="[^\n]*"/>
             *                       &lt;minLength value="1"/>
             *                       &lt;maxLength value="300"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "detAdicional"
            })
            public static class DetallesAdicionales {

                @XmlElement(required = true)
                protected List<Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional> detAdicional;

                /**
                 * Gets the value of the detAdicional property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the detAdicional property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getDetAdicional().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional }
                 * 
                 * 
                 */
                public List<Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional> getDetAdicional() {
                    if (detAdicional == null) {
                        detAdicional = new ArrayList<Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional>();
                    }
                    return this.detAdicional;
                }


                /**
                 * <p>Clase Java para anonymous complex type.
                 * 
                 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="nombre" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;pattern value="[^\n]*"/>
                 *             &lt;minLength value="1"/>
                 *             &lt;maxLength value="300"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="valor" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;pattern value="[^\n]*"/>
                 *             &lt;minLength value="1"/>
                 *             &lt;maxLength value="300"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class DetAdicional {

                    @XmlAttribute(name = "nombre", required = true)
                    protected String nombre;
                    @XmlAttribute(name = "valor", required = true)
                    protected String valor;

                    /**
                     * Obtiene el valor de la propiedad nombre.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNombre() {
                        return nombre;
                    }

                    /**
                     * Define el valor de la propiedad nombre.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNombre(String value) {
                        this.nombre = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad valor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValor() {
                        return valor;
                    }

                    /**
                     * Define el valor de la propiedad valor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValor(String value) {
                        this.valor = value;
                    }

                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "impuesto"
            })
            public static class Impuestos {

                @XmlElement(required = true)
                protected List<Impuesto> impuesto;

                /**
                 * Gets the value of the impuesto property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the impuesto property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getImpuesto().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Impuesto }
                 * 
                 * 
                 */
                public List<Impuesto> getImpuesto() {
                    if (impuesto == null) {
                        impuesto = new ArrayList<Impuesto>();
                    }
                    return this.impuesto;
                }

            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="campoAdicional" maxOccurs="15">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;>campoAdicional">
     *                 &lt;attribute name="nombre" use="required" type="{}nombre" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "campoAdicional"
    })
    public static class InfoAdicional {

        @XmlElement(required = true)
        protected List<Factura.InfoAdicional.CampoAdicional> campoAdicional;

        /**
         * Gets the value of the campoAdicional property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the campoAdicional property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCampoAdicional().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Factura.InfoAdicional.CampoAdicional }
         * 
         * 
         */
        public List<Factura.InfoAdicional.CampoAdicional> getCampoAdicional() {
            if (campoAdicional == null) {
                campoAdicional = new ArrayList<Factura.InfoAdicional.CampoAdicional>();
            }
            return this.campoAdicional;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;>campoAdicional">
         *       &lt;attribute name="nombre" use="required" type="{}nombre" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class CampoAdicional {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "nombre", required = true)
            protected String nombre;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad nombre.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * Define el valor de la propiedad nombre.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNombre(String value) {
                this.nombre = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="fechaEmision" type="{}fechaEmision"/>
     *         &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/>
     *         &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
     *         &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
     *         &lt;element name="comercioExterior" type="{}comercioExterior" minOccurs="0"/>
     *         &lt;element name="incoTermFactura" type="{}incoTermFactura" minOccurs="0"/>
     *         &lt;element name="lugarIncoTerm" type="{}lugarIncoTerm" minOccurs="0"/>
     *         &lt;element name="paisOrigen" type="{}paisOrigen" minOccurs="0"/>
     *         &lt;element name="puertoEmbarque" type="{}puertoEmbarque" minOccurs="0"/>
     *         &lt;element name="puertoDestino" type="{}puertoDestino" minOccurs="0"/>
     *         &lt;element name="paisDestino" type="{}paisDestino" minOccurs="0"/>
     *         &lt;element name="paisAdquisicion" type="{}paisAdquisicion" minOccurs="0"/>
     *         &lt;element name="tipoIdentificacionComprador" type="{}tipoIdentificacionComprador"/>
     *         &lt;element name="guiaRemision" type="{}guiaRemision" minOccurs="0"/>
     *         &lt;element name="razonSocialComprador" type="{}razonSocialComprador"/>
     *         &lt;element name="identificacionComprador" type="{}identificacionComprador"/>
     *         &lt;element name="direccionComprador" type="{}direccionComprador" minOccurs="0"/>
     *         &lt;element name="totalSinImpuestos" type="{}totalSinImpuestos"/>
     *         &lt;element name="totalSubsidio" type="{}totalSubsidio" minOccurs="0"/>
     *         &lt;element name="incoTermTotalSinImpuestos" type="{}incoTermTotalSinImpuestos" minOccurs="0"/>
     *         &lt;element name="totalDescuento" type="{}totalDescuentos"/>
     *         &lt;element name="codDocReembolso" type="{}codigoDocumentoReembolso" minOccurs="0"/>
     *         &lt;element name="totalComprobantesReembolso" type="{}totalComprobantesReembolso" minOccurs="0"/>
     *         &lt;element name="totalBaseImponibleReembolso" type="{}totalBaseImponibleReembolso" minOccurs="0"/>
     *         &lt;element name="totalImpuestoReembolso" type="{}totalImpuestoReembolso" minOccurs="0"/>
     *         &lt;element name="totalConImpuestos">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="totalImpuesto" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="codigo" type="{}codigo"/>
     *                             &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
     *                             &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
     *                             &lt;element name="baseImponible" type="{}baseImponible"/>
     *                             &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
     *                             &lt;element name="valor" type="{}valor"/>
     *                             &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="compensaciones" type="{}compensaciones" minOccurs="0"/>
     *         &lt;element name="propina" type="{}propina" minOccurs="0"/>
     *         &lt;element name="fleteInternacional" type="{}fleteInternacional" minOccurs="0"/>
     *         &lt;element name="seguroInternacional" type="{}seguroInternacional" minOccurs="0"/>
     *         &lt;element name="gastosAduaneros" type="{}gastosAduaneros" minOccurs="0"/>
     *         &lt;element name="gastosTransporteOtros" type="{}gastosTransporteOtros" minOccurs="0"/>
     *         &lt;element name="importeTotal" type="{}importeTotal"/>
     *         &lt;element name="moneda" type="{}moneda" minOccurs="0"/>
     *         &lt;element name="pagos" type="{}pagos" minOccurs="0"/>
     *         &lt;element name="valorRetIva" type="{}valorRetIva" minOccurs="0"/>
     *         &lt;element name="valorRetRenta" type="{}valorRetRenta" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fechaEmision",
        "dirEstablecimiento",
        "contribuyenteEspecial",
        "obligadoContabilidad",
        "comercioExterior",
        "incoTermFactura",
        "lugarIncoTerm",
        "paisOrigen",
        "puertoEmbarque",
        "puertoDestino",
        "paisDestino",
        "paisAdquisicion",
        "tipoIdentificacionComprador",
        "guiaRemision",
        "razonSocialComprador",
        "identificacionComprador",
        "direccionComprador",
        "totalSinImpuestos",
        "totalSubsidio",
        "incoTermTotalSinImpuestos",
        "totalDescuento",
        "codDocReembolso",
        "totalComprobantesReembolso",
        "totalBaseImponibleReembolso",
        "totalImpuestoReembolso",
        "totalConImpuestos",
        "compensaciones",
        "propina",
        "fleteInternacional",
        "seguroInternacional",
        "gastosAduaneros",
        "gastosTransporteOtros",
        "importeTotal",
        "moneda",
        "pagos",
        "valorRetIva",
        "valorRetRenta"
    })
    public static class InfoFactura {

        @XmlElement(required = true)
        protected String fechaEmision;
        protected String dirEstablecimiento;
        protected String contribuyenteEspecial;
        @XmlSchemaType(name = "string")
        protected ObligadoContabilidad obligadoContabilidad;
        protected String comercioExterior;
        protected String incoTermFactura;
        protected String lugarIncoTerm;
        protected String paisOrigen;
        protected String puertoEmbarque;
        protected String puertoDestino;
        protected String paisDestino;
        protected String paisAdquisicion;
        @XmlElement(required = true)
        protected String tipoIdentificacionComprador;
        protected String guiaRemision;
        @XmlElement(required = true)
        protected String razonSocialComprador;
        @XmlElement(required = true)
        protected String identificacionComprador;
        protected String direccionComprador;
        @XmlElement(required = true)
        protected BigDecimal totalSinImpuestos;
        protected BigDecimal totalSubsidio;
        protected String incoTermTotalSinImpuestos;
        @XmlElement(required = true)
        protected BigDecimal totalDescuento;
        protected String codDocReembolso;
        protected BigDecimal totalComprobantesReembolso;
        protected BigDecimal totalBaseImponibleReembolso;
        protected BigDecimal totalImpuestoReembolso;
        @XmlElement(required = true)
        protected Factura.InfoFactura.TotalConImpuestos totalConImpuestos;
        protected Compensaciones compensaciones;
        protected BigDecimal propina;
        protected BigDecimal fleteInternacional;
        protected BigDecimal seguroInternacional;
        protected BigDecimal gastosAduaneros;
        protected BigDecimal gastosTransporteOtros;
        @XmlElement(required = true)
        protected BigDecimal importeTotal;
        protected String moneda;
        protected Pagos pagos;
        protected BigDecimal valorRetIva;
        protected BigDecimal valorRetRenta;

        /**
         * Obtiene el valor de la propiedad fechaEmision.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaEmision() {
            return fechaEmision;
        }

        /**
         * Define el valor de la propiedad fechaEmision.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaEmision(String value) {
            this.fechaEmision = value;
        }

        /**
         * Obtiene el valor de la propiedad dirEstablecimiento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDirEstablecimiento() {
            return dirEstablecimiento;
        }

        /**
         * Define el valor de la propiedad dirEstablecimiento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDirEstablecimiento(String value) {
            this.dirEstablecimiento = value;
        }

        /**
         * Obtiene el valor de la propiedad contribuyenteEspecial.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContribuyenteEspecial() {
            return contribuyenteEspecial;
        }

        /**
         * Define el valor de la propiedad contribuyenteEspecial.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContribuyenteEspecial(String value) {
            this.contribuyenteEspecial = value;
        }

        /**
         * Obtiene el valor de la propiedad obligadoContabilidad.
         * 
         * @return
         *     possible object is
         *     {@link ObligadoContabilidad }
         *     
         */
        public ObligadoContabilidad getObligadoContabilidad() {
            return obligadoContabilidad;
        }

        /**
         * Define el valor de la propiedad obligadoContabilidad.
         * 
         * @param value
         *     allowed object is
         *     {@link ObligadoContabilidad }
         *     
         */
        public void setObligadoContabilidad(ObligadoContabilidad value) {
            this.obligadoContabilidad = value;
        }

        /**
         * Obtiene el valor de la propiedad comercioExterior.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComercioExterior() {
            return comercioExterior;
        }

        /**
         * Define el valor de la propiedad comercioExterior.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComercioExterior(String value) {
            this.comercioExterior = value;
        }

        /**
         * Obtiene el valor de la propiedad incoTermFactura.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIncoTermFactura() {
            return incoTermFactura;
        }

        /**
         * Define el valor de la propiedad incoTermFactura.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIncoTermFactura(String value) {
            this.incoTermFactura = value;
        }

        /**
         * Obtiene el valor de la propiedad lugarIncoTerm.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLugarIncoTerm() {
            return lugarIncoTerm;
        }

        /**
         * Define el valor de la propiedad lugarIncoTerm.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLugarIncoTerm(String value) {
            this.lugarIncoTerm = value;
        }

        /**
         * Obtiene el valor de la propiedad paisOrigen.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaisOrigen() {
            return paisOrigen;
        }

        /**
         * Define el valor de la propiedad paisOrigen.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaisOrigen(String value) {
            this.paisOrigen = value;
        }

        /**
         * Obtiene el valor de la propiedad puertoEmbarque.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPuertoEmbarque() {
            return puertoEmbarque;
        }

        /**
         * Define el valor de la propiedad puertoEmbarque.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPuertoEmbarque(String value) {
            this.puertoEmbarque = value;
        }

        /**
         * Obtiene el valor de la propiedad puertoDestino.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPuertoDestino() {
            return puertoDestino;
        }

        /**
         * Define el valor de la propiedad puertoDestino.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPuertoDestino(String value) {
            this.puertoDestino = value;
        }

        /**
         * Obtiene el valor de la propiedad paisDestino.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaisDestino() {
            return paisDestino;
        }

        /**
         * Define el valor de la propiedad paisDestino.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaisDestino(String value) {
            this.paisDestino = value;
        }

        /**
         * Obtiene el valor de la propiedad paisAdquisicion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaisAdquisicion() {
            return paisAdquisicion;
        }

        /**
         * Define el valor de la propiedad paisAdquisicion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaisAdquisicion(String value) {
            this.paisAdquisicion = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoIdentificacionComprador.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoIdentificacionComprador() {
            return tipoIdentificacionComprador;
        }

        /**
         * Define el valor de la propiedad tipoIdentificacionComprador.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoIdentificacionComprador(String value) {
            this.tipoIdentificacionComprador = value;
        }

        /**
         * Obtiene el valor de la propiedad guiaRemision.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGuiaRemision() {
            return guiaRemision;
        }

        /**
         * Define el valor de la propiedad guiaRemision.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGuiaRemision(String value) {
            this.guiaRemision = value;
        }

        /**
         * Obtiene el valor de la propiedad razonSocialComprador.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRazonSocialComprador() {
            return razonSocialComprador;
        }

        /**
         * Define el valor de la propiedad razonSocialComprador.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRazonSocialComprador(String value) {
            this.razonSocialComprador = value;
        }

        /**
         * Obtiene el valor de la propiedad identificacionComprador.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdentificacionComprador() {
            return identificacionComprador;
        }

        /**
         * Define el valor de la propiedad identificacionComprador.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdentificacionComprador(String value) {
            this.identificacionComprador = value;
        }

        /**
         * Obtiene el valor de la propiedad direccionComprador.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDireccionComprador() {
            return direccionComprador;
        }

        /**
         * Define el valor de la propiedad direccionComprador.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDireccionComprador(String value) {
            this.direccionComprador = value;
        }

        /**
         * Obtiene el valor de la propiedad totalSinImpuestos.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalSinImpuestos() {
            return totalSinImpuestos;
        }

        /**
         * Define el valor de la propiedad totalSinImpuestos.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalSinImpuestos(BigDecimal value) {
            this.totalSinImpuestos = value;
        }

        /**
         * Obtiene el valor de la propiedad totalSubsidio.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalSubsidio() {
            return totalSubsidio;
        }

        /**
         * Define el valor de la propiedad totalSubsidio.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalSubsidio(BigDecimal value) {
            this.totalSubsidio = value;
        }

        /**
         * Obtiene el valor de la propiedad incoTermTotalSinImpuestos.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIncoTermTotalSinImpuestos() {
            return incoTermTotalSinImpuestos;
        }

        /**
         * Define el valor de la propiedad incoTermTotalSinImpuestos.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIncoTermTotalSinImpuestos(String value) {
            this.incoTermTotalSinImpuestos = value;
        }

        /**
         * Obtiene el valor de la propiedad totalDescuento.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalDescuento() {
            return totalDescuento;
        }

        /**
         * Define el valor de la propiedad totalDescuento.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalDescuento(BigDecimal value) {
            this.totalDescuento = value;
        }

        /**
         * Obtiene el valor de la propiedad codDocReembolso.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodDocReembolso() {
            return codDocReembolso;
        }

        /**
         * Define el valor de la propiedad codDocReembolso.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodDocReembolso(String value) {
            this.codDocReembolso = value;
        }

        /**
         * Obtiene el valor de la propiedad totalComprobantesReembolso.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalComprobantesReembolso() {
            return totalComprobantesReembolso;
        }

        /**
         * Define el valor de la propiedad totalComprobantesReembolso.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalComprobantesReembolso(BigDecimal value) {
            this.totalComprobantesReembolso = value;
        }

        /**
         * Obtiene el valor de la propiedad totalBaseImponibleReembolso.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalBaseImponibleReembolso() {
            return totalBaseImponibleReembolso;
        }

        /**
         * Define el valor de la propiedad totalBaseImponibleReembolso.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalBaseImponibleReembolso(BigDecimal value) {
            this.totalBaseImponibleReembolso = value;
        }

        /**
         * Obtiene el valor de la propiedad totalImpuestoReembolso.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalImpuestoReembolso() {
            return totalImpuestoReembolso;
        }

        /**
         * Define el valor de la propiedad totalImpuestoReembolso.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalImpuestoReembolso(BigDecimal value) {
            this.totalImpuestoReembolso = value;
        }

        /**
         * Obtiene el valor de la propiedad totalConImpuestos.
         * 
         * @return
         *     possible object is
         *     {@link Factura.InfoFactura.TotalConImpuestos }
         *     
         */
        public Factura.InfoFactura.TotalConImpuestos getTotalConImpuestos() {
            return totalConImpuestos;
        }

        /**
         * Define el valor de la propiedad totalConImpuestos.
         * 
         * @param value
         *     allowed object is
         *     {@link Factura.InfoFactura.TotalConImpuestos }
         *     
         */
        public void setTotalConImpuestos(Factura.InfoFactura.TotalConImpuestos value) {
            this.totalConImpuestos = value;
        }

        /**
         * Obtiene el valor de la propiedad compensaciones.
         * 
         * @return
         *     possible object is
         *     {@link Compensaciones }
         *     
         */
        public Compensaciones getCompensaciones() {
            return compensaciones;
        }

        /**
         * Define el valor de la propiedad compensaciones.
         * 
         * @param value
         *     allowed object is
         *     {@link Compensaciones }
         *     
         */
        public void setCompensaciones(Compensaciones value) {
            this.compensaciones = value;
        }

        /**
         * Obtiene el valor de la propiedad propina.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPropina() {
            return propina;
        }

        /**
         * Define el valor de la propiedad propina.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPropina(BigDecimal value) {
            this.propina = value;
        }

        /**
         * Obtiene el valor de la propiedad fleteInternacional.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFleteInternacional() {
            return fleteInternacional;
        }

        /**
         * Define el valor de la propiedad fleteInternacional.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFleteInternacional(BigDecimal value) {
            this.fleteInternacional = value;
        }

        /**
         * Obtiene el valor de la propiedad seguroInternacional.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSeguroInternacional() {
            return seguroInternacional;
        }

        /**
         * Define el valor de la propiedad seguroInternacional.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSeguroInternacional(BigDecimal value) {
            this.seguroInternacional = value;
        }

        /**
         * Obtiene el valor de la propiedad gastosAduaneros.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getGastosAduaneros() {
            return gastosAduaneros;
        }

        /**
         * Define el valor de la propiedad gastosAduaneros.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setGastosAduaneros(BigDecimal value) {
            this.gastosAduaneros = value;
        }

        /**
         * Obtiene el valor de la propiedad gastosTransporteOtros.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getGastosTransporteOtros() {
            return gastosTransporteOtros;
        }

        /**
         * Define el valor de la propiedad gastosTransporteOtros.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setGastosTransporteOtros(BigDecimal value) {
            this.gastosTransporteOtros = value;
        }

        /**
         * Obtiene el valor de la propiedad importeTotal.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getImporteTotal() {
            return importeTotal;
        }

        /**
         * Define el valor de la propiedad importeTotal.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setImporteTotal(BigDecimal value) {
            this.importeTotal = value;
        }

        /**
         * Obtiene el valor de la propiedad moneda.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMoneda() {
            return moneda;
        }

        /**
         * Define el valor de la propiedad moneda.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMoneda(String value) {
            this.moneda = value;
        }

        /**
         * Obtiene el valor de la propiedad pagos.
         * 
         * @return
         *     possible object is
         *     {@link Pagos }
         *     
         */
        public Pagos getPagos() {
            return pagos;
        }

        /**
         * Define el valor de la propiedad pagos.
         * 
         * @param value
         *     allowed object is
         *     {@link Pagos }
         *     
         */
        public void setPagos(Pagos value) {
            this.pagos = value;
        }

        /**
         * Obtiene el valor de la propiedad valorRetIva.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValorRetIva() {
            return valorRetIva;
        }

        /**
         * Define el valor de la propiedad valorRetIva.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValorRetIva(BigDecimal value) {
            this.valorRetIva = value;
        }

        /**
         * Obtiene el valor de la propiedad valorRetRenta.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValorRetRenta() {
            return valorRetRenta;
        }

        /**
         * Define el valor de la propiedad valorRetRenta.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValorRetRenta(BigDecimal value) {
            this.valorRetRenta = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="totalImpuesto" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="codigo" type="{}codigo"/>
         *                   &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
         *                   &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
         *                   &lt;element name="baseImponible" type="{}baseImponible"/>
         *                   &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
         *                   &lt;element name="valor" type="{}valor"/>
         *                   &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "totalImpuesto"
        })
        public static class TotalConImpuestos {

            @XmlElement(required = true)
            protected List<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto> totalImpuesto;

            /**
             * Gets the value of the totalImpuesto property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the totalImpuesto property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTotalImpuesto().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Factura.InfoFactura.TotalConImpuestos.TotalImpuesto }
             * 
             * 
             */
            public List<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto> getTotalImpuesto() {
                if (totalImpuesto == null) {
                    totalImpuesto = new ArrayList<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto>();
                }
                return this.totalImpuesto;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="codigo" type="{}codigo"/>
             *         &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
             *         &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
             *         &lt;element name="baseImponible" type="{}baseImponible"/>
             *         &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
             *         &lt;element name="valor" type="{}valor"/>
             *         &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "codigo",
                "codigoPorcentaje",
                "descuentoAdicional",
                "baseImponible",
                "tarifa",
                "valor",
                "valorDevolucionIva"
            })
            public static class TotalImpuesto {

                @XmlElement(required = true)
                protected String codigo;
                @XmlElement(required = true)
                protected String codigoPorcentaje;
                protected BigDecimal descuentoAdicional;
                @XmlElement(required = true)
                protected BigDecimal baseImponible;
                protected BigDecimal tarifa;
                @XmlElement(required = true)
                protected BigDecimal valor;
                protected BigDecimal valorDevolucionIva;

                /**
                 * Obtiene el valor de la propiedad codigo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodigo() {
                    return codigo;
                }

                /**
                 * Define el valor de la propiedad codigo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodigo(String value) {
                    this.codigo = value;
                }

                /**
                 * Obtiene el valor de la propiedad codigoPorcentaje.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodigoPorcentaje() {
                    return codigoPorcentaje;
                }

                /**
                 * Define el valor de la propiedad codigoPorcentaje.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodigoPorcentaje(String value) {
                    this.codigoPorcentaje = value;
                }

                /**
                 * Obtiene el valor de la propiedad descuentoAdicional.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getDescuentoAdicional() {
                    return descuentoAdicional;
                }

                /**
                 * Define el valor de la propiedad descuentoAdicional.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setDescuentoAdicional(BigDecimal value) {
                    this.descuentoAdicional = value;
                }

                /**
                 * Obtiene el valor de la propiedad baseImponible.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getBaseImponible() {
                    return baseImponible;
                }

                /**
                 * Define el valor de la propiedad baseImponible.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setBaseImponible(BigDecimal value) {
                    this.baseImponible = value;
                }

                /**
                 * Obtiene el valor de la propiedad tarifa.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTarifa() {
                    return tarifa;
                }

                /**
                 * Define el valor de la propiedad tarifa.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTarifa(BigDecimal value) {
                    this.tarifa = value;
                }

                /**
                 * Obtiene el valor de la propiedad valor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValor() {
                    return valor;
                }

                /**
                 * Define el valor de la propiedad valor.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValor(BigDecimal value) {
                    this.valor = value;
                }

                /**
                 * Obtiene el valor de la propiedad valorDevolucionIva.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValorDevolucionIva() {
                    return valorDevolucionIva;
                }

                /**
                 * Define el valor de la propiedad valorDevolucionIva.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValorDevolucionIva(BigDecimal value) {
                    this.valorDevolucionIva = value;
                }

            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="retencion" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigo" type="{}codigoRetencion"/>
     *                   &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeRetencion"/>
     *                   &lt;element name="tarifa" type="{}tarifaRetencion"/>
     *                   &lt;element name="valor" type="{}valorRetencion"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "retencion"
    })
    public static class Retenciones {

        @XmlElement(required = true)
        protected List<Factura.Retenciones.Retencion> retencion;

        /**
         * Gets the value of the retencion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the retencion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRetencion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Factura.Retenciones.Retencion }
         * 
         * 
         */
        public List<Factura.Retenciones.Retencion> getRetencion() {
            if (retencion == null) {
                retencion = new ArrayList<Factura.Retenciones.Retencion>();
            }
            return this.retencion;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="codigo" type="{}codigoRetencion"/>
         *         &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeRetencion"/>
         *         &lt;element name="tarifa" type="{}tarifaRetencion"/>
         *         &lt;element name="valor" type="{}valorRetencion"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codigo",
            "codigoPorcentaje",
            "tarifa",
            "valor"
        })
        public static class Retencion {

            @XmlElement(required = true)
            protected String codigo;
            @XmlElement(required = true)
            protected String codigoPorcentaje;
            @XmlElement(required = true)
            protected BigDecimal tarifa;
            @XmlElement(required = true)
            protected BigDecimal valor;

            /**
             * Obtiene el valor de la propiedad codigo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigo() {
                return codigo;
            }

            /**
             * Define el valor de la propiedad codigo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigo(String value) {
                this.codigo = value;
            }

            /**
             * Obtiene el valor de la propiedad codigoPorcentaje.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoPorcentaje() {
                return codigoPorcentaje;
            }

            /**
             * Define el valor de la propiedad codigoPorcentaje.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoPorcentaje(String value) {
                this.codigoPorcentaje = value;
            }

            /**
             * Obtiene el valor de la propiedad tarifa.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTarifa() {
                return tarifa;
            }

            /**
             * Define el valor de la propiedad tarifa.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTarifa(BigDecimal value) {
                this.tarifa = value;
            }

            /**
             * Obtiene el valor de la propiedad valor.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValor() {
                return valor;
            }

            /**
             * Define el valor de la propiedad valor.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValor(BigDecimal value) {
                this.valor = value;
            }

        }

    }

}
