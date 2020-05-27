package org.freesoftware.admin.soap.webservice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.freesoftware.admin.soap.webservice.data.WebServiceDataProvider;
import org.freesoftware.admin.soap.webservice.product.Product;

public class OrderMessageCompiler {

	private int i;
	private WebServiceDataProvider dataProvider;
	
	public OrderMessageCompiler(WebServiceDataProvider dataProvider)
	{
		this.dataProvider=dataProvider;
	}
	
	public String compile(List<Product> products, List<Integer> quantities)
	{
		String message = "";
		for(i=0;i<products.size();i++)
		{
			message +=products.get(i).getName()+"/"+quantities.get(i)+"|";
		}
		return message;
	}
	
	public Map<Product, Integer> decompile(String message)
	{
		Map<Product, Integer> resultMap = new HashMap<>();
		List<String> productsNames = new ArrayList<>();
		List<Integer> quantities = new ArrayList<>();
		String r="";
		while(message.contains("|"))
		{
			i=message.indexOf("|");
			r=message.substring(0,i);
			message=message.substring(i+1,message.length());
			i=r.indexOf("/");
			productsNames.add(r.substring(0,i));
			quantities.add(Integer.valueOf(r.substring(i+1,r.length())));
		}
		List<Product> products = dataProvider.getAllProducts();
		for(Product p:products)
		{
			if(productsNames.contains(p.getName()))
			{
				resultMap.put(p,quantities.get(productsNames.indexOf(p.getName())));
			}
		}
		return resultMap;
	}
}
