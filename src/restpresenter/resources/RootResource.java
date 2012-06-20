/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restpresenter.resources;

import javax.ws.rs.*;



/**
 *
 * @author maxbrenn
 */
 @Path("/")
public class RootResource {
     
         // The Java method will process HTTP GET requests
         @GET 
         // The Java method will produce content identified by the MIME Media
         // type "text/plain"
         @Produces("text/plain")
        public String getRoot() {
           
            
                 return "Hi there! I'm root!";
            
                
                               
            
        }
       
    
}
