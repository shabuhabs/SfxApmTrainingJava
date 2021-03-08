package com.signalfx.training;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;


public class SfxCurrencyConverterServerAuto extends AbstractHandler {
	
	public void handle(String target, org.eclipse.jetty.server.Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		MultipleMethodTest testIt = new MultipleMethodTest();
		testIt.display();
		     
		String amount = request.getParameter("amt");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		SfxCurrencyConverterAuto converter = new SfxCurrencyConverterAuto();
		converter.convertMyAmount(new BigDecimal(amount));
		for (Iterator<String> it = converter.getResults().iterator() ; it.hasNext() ; ) {
			response.getWriter().println(it.next());
		}
		
		  try {
			  // APIM test.
            //URL url = new URL(" https://shabuhabsapi.azure-api.net/shabuhabs-foo/Foo?name=" + "TheJoker");
			  //Azure Function Test.
			URL url = new URL("https://shabuhabs-foo.azurewebsites.net/api/Foo?name=" + "Batman");
 			  //URL url = new URL("http://localhost:7071/api/Foo?name=" + "Connected");
               HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

               InputStream in = new BufferedInputStream(httpCon.getInputStream());
               //readStream(in);
               httpCon.disconnect();
 		  } catch(Exception e) {

 		  }
	
	}
	
	 public static void main(String[] args) throws Exception {
	   
		 Server server = new Server(8888);
	     server.setHandler(new SfxCurrencyConverterServerAuto());
	     server.start();
	     server.join();	    	
	 }
}
