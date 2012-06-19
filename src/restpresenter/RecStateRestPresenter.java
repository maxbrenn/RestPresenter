/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restpresenter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author maxbrenn
 */
 @Path("/rec/{state}")
public class RecStateRestPresenter {
     
         // The Java method will process HTTP GET requests
         @GET 
         // The Java method will produce content identified by the MIME Media
         // type "text/plain"
         @Produces("text/plain")
        public String getRecState(@PathParam("state") String recState) {
           
             if(recState.equalsIgnoreCase("on")) {
                 RestPresenter.rpUI.startRec();
             }
             
              if(recState.equalsIgnoreCase("off")) {
                 RestPresenter.rpUI.stopRec();
             }
             
                  
            return "OK";
        }
       
    
}
