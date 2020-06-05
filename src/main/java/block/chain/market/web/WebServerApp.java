package block.chain.market.web;

import org.freesoftware.admin.soap.webservice.SOAPWebServiceProvider;

public class WebServerApp {

	public static void main(String[] args)
	{
		String url = "http://localhost:8082/admin";
		WebDataProvider repo = new WebDataProvider();
		SOAPWebServiceProvider webServer = new SOAPWebServiceProvider();
		webServer.begin(repo, url);
		System.out.println("---WEB SERVER DEPLOYED---");
	}
}
