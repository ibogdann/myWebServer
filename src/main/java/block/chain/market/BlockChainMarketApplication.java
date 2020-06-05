package block.chain.market;

import java.util.Collections;

import org.freesoftware.admin.soap.webservice.SOAPWebServiceProvider;
import org.freesoftware.admin.soap.webservice.SOAPWebServicePublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import block.chain.market.web.WebDataProvider;
import block.chain.market.web.WebServerApp;
import web.service.ProducingWebServiceApplication;

@SpringBootApplication
public class BlockChainMarketApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BlockChainMarketApplication.class, args);
//		System.out.println("---MOBILE SERVER DEPLOYED---");
//		SpringApplication.run(ProducingWebServiceApplication.class, args);
		
		
		Class[] sources = {BlockChainMarketApplication.class, ProducingWebServiceApplication.class};
		SpringApplication.run(sources, args);
		
		
		
//		String url = "http://localhost:8082/admin";
//		WebDataProvider repo = new WebDataProvider();
//		SOAPWebServiceProvider webServer = new SOAPWebServiceProvider();
//		webServer.begin(repo, url);
		System.out.println("---WEB SERVER DEPLOYED---");
		
	}

}
