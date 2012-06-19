/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restpresenter;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author maxbrenn
 */
public class RestPresenter {
    
    public static RestPresenterUI rpUI;
    public static Properties props;
    public static List<Instruction> instructions;
    public static int selectionCount;
    public static int readSeconds;
    public static int recSeconds;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
       
        
               props = loadProperties("properties.xml");
               
               
               if(props.getProperty("selection.count")!=null) {
                   selectionCount = Integer.parseInt(props.getProperty("selection.count"));
               } else {
                   System.out.println("please set property selection.count=n");
               }
               
                if(props.getProperty("read.seconds")!=null) {
                   readSeconds = Integer.parseInt(props.getProperty("read.seconds"));
               } else {
                   System.out.println("please set property read.seconds=n");
               }
                if(props.getProperty("rec.seconds")!=null) {
                   recSeconds = Integer.parseInt(props.getProperty("rec.seconds"));
               } else {
                   System.out.println("please set property rec.seconds=n");
               }
               
                
               instructions = parseInstructions(props);
               printInstructions(instructions);
        
        
        
         final String baseUri = "http://localhost:8080/";
             final Map<String, String> initParams = new HashMap<String, String>();
 
             initParams.put("com.sun.jersey.config.property.packages", 
                     "restpresenter");

            System.out.println("Starting grizzly...");
        try {
            SelectorThread threadSelector = GrizzlyWebContainerFactory.create(
                    baseUri, initParams);
        } catch (IOException ex) {
            System.out.println(ex);
        }
            System.out.println("Jersey app started with WADL available at " + baseUri);
            
                    
            
            rpUI = new RestPresenterUI();
            rpUI.cleanScreen();
            rpUI.setVisible(true);
            rpUI.setExtendedState(rpUI.getExtendedState() | JFrame.MAXIMIZED_BOTH);
      
            runRecordingSession(Language.de);
            
    }       
     

    public static int[] getInstructionSelection() {
        
        int[] returnChoice = new int[selectionCount];
        
        int choice = 0;
        int randomInt = 0;
        Random random = new Random();
        
        for(int i = 0; i < returnChoice.length; i++) {
            
            randomInt = random.nextInt(5);
            if(randomInt==0) {
                randomInt = 1;
            }
            
            choice = choice + randomInt;
            
            returnChoice[i] = choice;
            
        }
        
        
        
        return returnChoice;
    }
    
    
    public static Instruction getInstruction(int _id) {
        
        for(Instruction instr:instructions) {
            
            if(instr.id == _id) {
                return instr;
            }
            
        }
        return null;
            
        
    }
    public static Properties loadProperties(String _filename) {
       
        System.out.println("loading properties...");
         
           
            Properties props = new Properties();
            File propsfile = new File(_filename);
            
            if(propsfile.exists()) {
            try {
                System.out.println("properties file found... ");
                props.loadFromXML(new FileInputStream(_filename));
           
            } catch (IOException ex) {
                System.out.println(ex);
            }
            }
            
            return props;
            
    }
     public static List<Instruction> parseInstructions(Properties _props)  {
        List<Instruction> returnInstructions = new ArrayList<Instruction>();
         
          int awCount = 0;
            
            if(_props.getProperty("aw.count")!=null) {
                awCount = Integer.parseInt(_props.getProperty("aw.count"));
            } else {
                System.out.println("please set property: aw.count=n");
            }
            
            for(int i = 1; i <= awCount; i++ ) {
                
                
                returnInstructions.add(new Instruction(i,_props.getProperty("aw." + i + ".name"),_props.getProperty("aw." + i + ".deText"),_props.getProperty("aw." + i + ".enText"),_props.getProperty("aw." + i + ".esText")));
                
               }
            
            
            
       return returnInstructions;
        
    }
    
     
     public static void printInstructions(List<Instruction> _instructions) {
         
         for(Instruction instr:_instructions) {
             
             System.out.println(instr.id + " " + instr.deText + " " + instr.enText + " " + instr.esText);
                 
             }
             
         }
     
     public static void runRecordingSession(Language _language) {
         
         
         System.out.println("Start Recording Session!");
         
         System.out.println("Show Introduction!");
         
         wait(5);
         
          int[] instrSelect = getInstructionSelection();
            
        for(int i : instrSelect) {
            rpUI.initiateInstruction(getInstruction(i), _language , readSeconds, recSeconds);
        } 
         
        System.out.println("Show Thanks!");
         
     }
         
     
     public static void wait(int _seconds) {
        try {
            Thread.sleep(_seconds*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
        
}
