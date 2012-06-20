/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restpresenter.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import restpresenter.Language;
import restpresenter.RestPresenter;

/**
 *
 * @author maxbrenn
 */
 @Path("/startrec/{language}")
public class StartRecResource {
     
         // The Java method will process HTTP GET requests
         @GET 
         // The Java method will produce content identified by the MIME Media
         // type "text/plain"
         @Produces("text/plain")
        public String getRecState(@PathParam("language") String _languageString) {
           
             Language language = null;
                     
             if(_languageString=="de") {
                 language = Language.de;
             }
             
             if(_languageString=="en") {
                 language = Language.en;
             }
             
             if(_languageString=="es") {
                 language = Language.es;
             }
             
             
             if(language!=null) {
                 RestPresenter.rpUI.showRecAnimation(10);
                 return "OK";
             } else {
                 return "Wrong language parameter! {de,en,es}";
             }
                
                               
            
        }
       
    
}
