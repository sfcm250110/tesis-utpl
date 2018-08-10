package ec.edu.utpl.sc.core.servicio.test.util;


import java.io.Serializable;
import org.apache.log4j.Logger;

/*
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
*/

public class HttpCilentSriTest implements Serializable {

	private static final long serialVersionUID = 3103551548610538479L;
	protected static final Logger log = Logger.getLogger(HttpCilentSriTest.class);
	
	/*
	public static void main(String[] agrs) {
        String host = "declaraciones.sri.gob.ec";
        int port = 8080;
        String protocol = "https";
 
        DefaultHttpClient client = new DefaultHttpClient();
 
        try {
            HttpHost httpHost = new HttpHost(host, port, protocol);
            client.getParams().setParameter(ClientPNames.DEFAULT_HOST, httpHost);
 
            HttpGet securedResource = new HttpGet("/tuportal-internet/menusFavoritos.jspa?redireccion=57&idGrupo=55");            
            HttpResponse httpResponse = client.execute(securedResource);
            HttpEntity responseEntity = httpResponse.getEntity();
            String strResponse = EntityUtils.toString(responseEntity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);
 
            System.out.println("Http status code for Unauthenticated Request: " + statusCode);// Statue code should be 200
            System.out.println("Response for Unauthenticated Request: n" + strResponse); // Should be login page
            System.out.println("================================================================n");
 
            HttpPost authpost = new HttpPost("/j_security_check");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("j_username", "1718834342001"));
            nameValuePairs.add(new BasicNameValuePair("j_password", "SANTO1983"));
            authpost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            httpResponse = client.execute(authpost);
            responseEntity = httpResponse.getEntity();
            strResponse = EntityUtils.toString(responseEntity);
            statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);
 
            System.out.println("Http status code for Authenticattion Request: " + statusCode);// Status code should be 302
            System.out.println("Response for Authenticattion Request: n" + strResponse); // Should be blank string
            System.out.println("================================================================n");
 
            httpResponse = client.execute(securedResource);
            responseEntity = httpResponse.getEntity();
            strResponse = EntityUtils.toString(responseEntity);
            statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);
 
            System.out.println("Http status code for Authenticated Request: " + statusCode);// Status code should be 200
            System.out.println("Response for Authenticated Request: n" + strResponse);// Should be actual page
            System.out.println("================================================================n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	/*private List<String> cookies;
	private HttpsURLConnection conn;

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {
		PostMethod postMethod = new PostMethod(baseURL + " /login");
		  postMethod.setDoAuthentication(true);
		  postMethod.addParameter("j_username", username);
		  postMethod.addParameter("j_password", password);
		  int statusCode = client.executeMethod(postMethod);
		  if (statusCode == HttpServletResponse.SC_FORBIDDEN) {
		    throw new Exception("Invalid Username or Password");
		  }
		  String result = new String(postMethod.getResponseBody());
		  if (statusCode != HttpServletResponse.SC_OK)
		    throw new Exception(result);
		
		

		String url = "https://declaraciones.sri.gob.ec/tuportal-internet/";
		String gmail = "https://declaraciones.sri.gob.ec/tuportal-internet/menusFavoritos.jspa?redireccion=57&idGrupo=55";

		HttpCilentSriTest http = new HttpCilentSriTest();

		// make sure cookies is turn on
		CookieHandler.setDefault(new CookieManager());

		// 1. Send a "GET" request, so that you can extract the form's data.
		String page = http.GetPageContent(url);
		String postParams = http.getFormParams(page, "1718834342001", "SANTO1983");

		// 2. Construct above post's content and then send a POST request for
		// authentication
		http.sendPost(url, postParams);

		// 3. success then go to gmail.
		String result = http.GetPageContent(gmail);
		System.out.println(result);
	}

	private void sendPost(String url, String postParams) throws Exception {

		URL obj = new URL(url);
		conn = (HttpsURLConnection) obj.openConnection();

		// Acts like a browser
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		//TODO:conn.setRequestProperty("Host", "accounts.google.com");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		for (String cookie : this.cookies) {
			conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
		}
		conn.setRequestProperty("Connection", "keep-alive");
		//TODO:conn.setRequestProperty("Referer", "https://accounts.google.com/ServiceLoginAuth");
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
		
		System.out.println(response.toString());
	}

	private String GetPageContent(String url) throws Exception {

		URL obj = new URL(url);
		conn = (HttpsURLConnection) obj.openConnection();

		// default is GET
		conn.setRequestMethod("GET");

		conn.setUseCaches(false);

		// act like a browser
		conn.setRequestProperty("User-Agent", USER_AGENT);
		
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
		
		System.out.println(doc.html());

		// Google form id
		Element loginform = doc.getElementsByAttributeValue("name", "loginForm").first();
		//TODO:Element loginform = doc.getElementById("loginForm");
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
	}*/

}
