package ec.edu.utpl.sc.core.gestor.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.gestor.IHttpGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.DateUtil;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.HTTP_GESTOR)
public class HttpGestor implements IHttpGestor {
	
	@Override
	public InfoRucSri downloadInfoRucSri(String pRucEmisor) throws UtplException {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
	        HttpPost httpPost = new HttpPost(Constantes.URL_CONSULTA_RUC_SRI);
	        
	        List<NameValuePair> arguments = new ArrayList<NameValuePair>(Constantes.I1);
	        arguments.add(new BasicNameValuePair(Constantes.RUC, pRucEmisor));
	        
	        httpPost.setEntity(new UrlEncodedFormEntity(arguments));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            String html = EntityUtils.toString(httpResponse.getEntity());

            Document document = Jsoup.parse(html);
            Element table = document.select(Constantes.ELEMENT_TABLE_INFO_RUC).first();
            Elements rows = table.select(Constantes.ELEMENT_TR);
            InfoRucSri infoRucSri = new InfoRucSri();
            Integer fila = Constantes.I1;
            
            for (Element row : rows) {
            	Element th = row.select(Constantes.ELEMENT_TH).first();
            	Element td = row.select(Constantes.ELEMENT_TD).first();
            	
				if (th != null && td != null) {
					
					if (Constantes.I1.equals(fila)) {
						infoRucSri.setRazonSocial(td.text());
					} else
					
					if (Constantes.I3.equals(fila)) {
						infoRucSri.setRuc(td.text());
					} else
					
					if (Constantes.I6.equals(fila)) {
						infoRucSri.setNombreComercial(td.text());
					} else
					
					if (Constantes.I8.equals(fila)) {
						infoRucSri.setEstadoContribuyente(td.text());
					} else
					
					if (Constantes.I10.equals(fila)) {
						infoRucSri.setClaseContribuyente(td.text());
					} else
					
					if (Constantes.I12.equals(fila)) {
						infoRucSri.setTipoContribuyente(td.text());
					} else
					
					if (Constantes.I14.equals(fila)) {
						infoRucSri.setObligadoContabilidad(td.text());
					} else
					
					if (Constantes.I16.equals(fila)) {
						infoRucSri.setActividadEconomicaPrincipal(td.text());
					} else
					
					if (Constantes.I18.equals(fila)) {
						infoRucSri.setInicioActividades(DateUtil.parseStringToDate(td.text(), Constantes.DD_MM_YYYY_GUION));
					} else
					
					if (Constantes.I20.equals(fila)) {
						infoRucSri.setCeseActividades(DateUtil.parseStringToDate(td.text(), Constantes.DD_MM_YYYY_GUION));
					} else
					
					if (Constantes.I22.equals(fila)) {
						infoRucSri.setReinicioActividades(DateUtil.parseStringToDate(td.text(), Constantes.DD_MM_YYYY_GUION));
					} else
					
					if (Constantes.I24.equals(fila)) {
						infoRucSri.setActualizacion(DateUtil.parseStringToDate(td.text(), Constantes.DD_MM_YYYY_GUION));
					} else
					
					if (Constantes.I26.equals(fila)) {
						infoRucSri.setCategoriaPymes(td.text());
					}
				}
				
				fila = fila + Constantes.I1;
			}
			
			return infoRucSri;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
