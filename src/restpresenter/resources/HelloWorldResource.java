package restpresenter.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/hello/{name}")
     public class HelloWorldResource {

         @GET 
         @Produces("text/plain")
        public String getClichedMessage(@PathParam("name") String name) {
           
             System.out.println("hallo welt!" + name);
             
             
            return "OK";
        }
         
         
         
    }