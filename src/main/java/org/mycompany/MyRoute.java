package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {
	
	 @Override
	    public void configure() throws Exception {
	       
		 
	    restConfiguration()
         .enableCORS(true)
         .component("jetty")
         .host("0.0.0.0")
         .port(8989)
         .bindingMode(RestBindingMode.json);



      rest()
         .get("/hello")
         .to("direct:hello");
      
      
     from("direct:hello")
       .setBody(simple("hello Abhishek"));


	    
	 
	 }

}
