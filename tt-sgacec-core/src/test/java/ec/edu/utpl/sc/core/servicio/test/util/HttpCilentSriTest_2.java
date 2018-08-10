package ec.edu.utpl.sc.core.servicio.test.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpCilentSriTest_2 implements Serializable {

	private static final long serialVersionUID = 3103551548610538479L;
	protected static final Logger log = Logger.getLogger(HttpCilentSriTest_2.class);

	private List<String> cookies;
	private HttpsURLConnection conn;
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {
		String url = "https://declaraciones.sri.gob.ec/tuportal-internet/j_security_check";
		//TODO:String url = "https://declaraciones.sri.gob.ec/tuportal-internet/verificaEmail.jspa";
		//TODO:String gmail = "https://declaraciones.sri.gob.ec/tuportal-internet/";
		String gmail = "https://declaraciones.sri.gob.ec/comprobantes-electronicos-internet/pages/solicitud/menu.jsf?&contextoMPT=https://declaraciones.sri.gob.ec/tuportal-internet&pathMPT=Facturaci%F3n%20Electr%F3nica%20%2F%20Producci%F3n&actualMPT=Autorizaci%F3n%20&linkMPT=%2Fcomprobantes-electronicos-internet%2Fpages%2Fsolicitud%2Fmenu.jsf%3F&esFavorito=S";

		HttpCilentSriTest_2 http = new HttpCilentSriTest_2();

		// make sure cookies is turn on
		CookieHandler.setDefault(new CookieManager());

		// 1. Send a "GET" request, so that you can extract the form's data.
		String page = http.getPageContent(url);
		String postParams = http.getFormParams(page, "1718834342001", "SANTO1983");

		// 2. Construct above post's content and then send a POST request for
		// authentication
		http.sendPost(url, postParams);

		// 3. success then go to gmail.
		String result = http.getPageContent(gmail);
		System.out.println(result);
	}

	private void sendPost(String url, String postParams) throws Exception {
		URL obj = new URL(url);
		conn = (HttpsURLConnection) obj.openConnection();

		// Acts like a browser
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Host", "declaraciones.sri.gob.ec");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "es-ES,es;q=0.9,en;q=0.8,gl;q=0.7");
		
		for (String cookie : this.cookies) {
			conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
		}
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("Referer", url);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));

		conn.setDoOutput(true);
		conn.setDoInput(true);

		// Send post request
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + postParams);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// System.out.println(response.toString());

	}

	private String getPageContent(String url) throws Exception {
		URL obj = new URL(url);
		conn = (HttpsURLConnection) obj.openConnection();

		// default is GET
		conn.setRequestMethod("GET");

		// act like a browser
		conn.setUseCaches(false);
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		if (cookies != null) {
			for (String cookie : this.cookies) {
				conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			}
		}
		
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Get the response cookies
		setCookies(conn.getHeaderFields().get("Set-Cookie"));

		return response.toString();
	}

	public String getFormParams(String html, String username, String password) throws UnsupportedEncodingException {
		System.out.println("Extracting form's data...");
		Document doc = Jsoup.parse(html);

		// Google form id
		Element loginform = doc.getElementsByAttributeValue("name", "loginForm").first();
		Elements inputElements = loginform.getElementsByTag("input");
		List<String> paramList = new ArrayList<String>();
		
		for (Element inputElement : inputElements) {
			String key = inputElement.attr("name");
			String value = inputElement.attr("value");

			if (key.equals("j_username"))
				value = username;
			else if (key.equals("j_password"))
				value = password;
			paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
		}

		// build parameters list
		StringBuilder result = new StringBuilder();
		for (String param : paramList) {
			if (result.length() == 0) {
				result.append(param);
			} else {
				result.append("&" + param);
			}
		}
		
		return result.toString();
	}

	public List<String> getCookies() {
		return cookies;
	}

	public void setCookies(List<String> cookies) {
		this.cookies = cookies;
	}

}