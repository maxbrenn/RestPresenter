/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restpresenter;

     // The Java class will be hosted at the URI path "/helloworld"


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


    @Path("/hello/{name}")
     public class HelloWorldResource {
     
         // The Java method will process HTTP GET requests
         @GET 
         // The Java method will produce content identified by the MIME Media
         // type "text/plain"
         @Produces("text/plain")
        public String getClichedMessage(@PathParam("name") String name) {
           
             System.out.println("hallo welt!");
             RestPresenter.rpUI.printMessage("Hallo " + name);
             
             
            return "OK";
        }
         
         
         
    }