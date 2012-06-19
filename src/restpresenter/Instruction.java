/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restpresenter;

/**
 *
 * @author maxbrenn
 */
public class Instruction {
    int id;
    int prio;
    String name;
    String deText;
    String enText;
    String esText;
    int personen;
    
    
    public Instruction( int _id, String _name, String _deText, String _enText, String _esText ) {
        
        id = _id;
        name = _name;
        deText = _deText;
        enText = _enText;
        esText = _esText;
        
               
    }
}

