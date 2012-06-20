/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restpresenter;

import java.awt.Dimension;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author maxbrenn
 */
public class RestPresenterUI extends javax.swing.JFrame {

    public static boolean isRec = false;

    /**
     * Creates new form RestPresenterUI
     */
    public RestPresenterUI() {
        initComponents();

    }

    public void initiateIntro(Language _language) {


        String introText = "";

        if (_language == Language.de) {
            introText = RestPresenter.props.getProperty("aw.intro.deText");
        }
        if (_language == Language.en) {
            introText = RestPresenter.props.getProperty("aw.intro.enText");
        }
        if (_language == Language.es) {
            introText = RestPresenter.props.getProperty("aw.intro.esText");
        }

        showInstruction(introText, 10);

        wait(12);

    }

    public void initiateInstruction(Instruction _instruction, Language _language, int _readSeconds, int _recSeconds, int _explainSeconds) {




        String instrText = "";
        String explanText = "";

        if (_language == Language.de) {
            instrText = _instruction.deText;
            explanText = RestPresenter.props.getProperty("aw.explan.deText");

        }
        if (_language == Language.en) {
            instrText = _instruction.enText;
            explanText = RestPresenter.props.getProperty("aw.explan.enText");
        }
        if (_language == Language.es) {
            instrText = _instruction.esText;
            explanText = RestPresenter.props.getProperty("aw.explan.esText");
        }


        showExplanation(explanText, _explainSeconds);
        wait(2);
        
        showInstruction(instrText, _readSeconds + _recSeconds);
        wait(_readSeconds);

        showRecAnimation(_recSeconds);
        wait(_recSeconds);

       



    }

    public void initiateThank(Language _language) {


        String thankText = "";

        if (_language == Language.de) {
            thankText = RestPresenter.props.getProperty("aw.thank.deText");
        }
        if (_language == Language.en) {
            thankText = RestPresenter.props.getProperty("aw.thank.enText");
        }
        if (_language == Language.es) {
            thankText = RestPresenter.props.getProperty("aw.thank.esText");
        }

        showInstruction(thankText, 10);



    }

    public void showInstruction(String _instruction, int _duration) {


        _instruction = _instruction.replace("\\n", "<br>");
        _instruction = "<html><center>" + _instruction + "</center></html>";

        final String instruction = _instruction;
        final int duration = _duration;
        
        new Thread() {
            
            public void run(){
        
        instructionLabel.setText(instruction);
                try {
                    sleep(duration*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RestPresenterUI.class.getName()).log(Level.SEVERE, null, ex);
                }

        instructionLabel.setText("");

            }
        }.start();
        
    }

    public void showExplanation(String _explanation, int _duration) {

         
                  
        _explanation = _explanation.replace("\\n", "<br>");
        _explanation = "<html><center>" + _explanation + "</center></html>";

        
        final int duration = _duration;
        final String explanation = _explanation;
        
        new Thread() {

            public void run() {
        
        explanationLabel.setText(explanation);
                try {
                    sleep(duration*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RestPresenterUI.class.getName()).log(Level.SEVERE, null, ex);
                }

        explanationLabel.setText("");

            }
        }.start();

    }

    public void showRecAnimation(int _seconds) {

        final int seconds = _seconds;

        System.out.println("Timer started!");



        new Thread() {

            public void run() {



                boolean isON = true;

                DecimalFormat df = new DecimalFormat("00");


                timerLabel.setVisible(true);
                recLabel.setVisible(true);

                for (int i = seconds; i >= 0; i--) {

                    recLED.setVisible(isON);

                    timerLabel.setText("00:" + df.format(i));
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RestPresenterUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (isON) {
                        isON = false;
                    } else {
                        isON = true;
                    }

                }

                timerLabel.setVisible(false);
                recLabel.setVisible(false);
                recLED.setVisible(false);

            }
        }.start();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recLED = new javax.swing.JLabel();
        recLabel = new javax.swing.JLabel();
        instructionLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        explanationLabel = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setUndecorated(true);
        getContentPane().setLayout(null);

        recLED.setFont(new java.awt.Font("Tahoma", 0, 250)); // NOI18N
        recLED.setForeground(new java.awt.Color(255, 0, 0));
        recLED.setText("•");
        getContentPane().add(recLED);
        recLED.setBounds(858, 11, 114, 133);

        recLabel.setFont(new java.awt.Font("Tahoma", 1, 102)); // NOI18N
        recLabel.setText("REC");
        getContentPane().add(recLabel);
        recLabel.setBounds(978, 28, 205, 124);

        instructionLabel.setFont(new java.awt.Font("Tahoma", 1, 64)); // NOI18N
        instructionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionLabel.setMaximumSize(new java.awt.Dimension(1200, 58));
        instructionLabel.setMinimumSize(new java.awt.Dimension(1200, 58));
        instructionLabel.setPreferredSize(new java.awt.Dimension(1200, 58));
        getContentPane().add(instructionLabel);
        instructionLabel.setBounds(0, 290, 1220, 310);

        timerLabel.setFont(new java.awt.Font("Tahoma", 1, 102)); // NOI18N
        timerLabel.setText("00:00");
        getContentPane().add(timerLabel);
        timerLabel.setBounds(90, 40, 350, 124);

        explanationLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        getContentPane().add(explanationLabel);
        explanationLabel.setBounds(430, 220, 350, 110);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(null);
        getContentPane().add(backgroundPanel);
        backgroundPanel.setBounds(40, 210, 140, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void printMessage(String _message) {

        instructionLabel.setText(_message);

    }

    public void countDown(int _seconds) {
    }

    public void initScreen() {

        recLED.setVisible(false);
        recLabel.setVisible(false);
        timerLabel.setVisible(false);


        recLED.setLocation(RestPresenter.screenWidth - 400, 5);
        recLabel.setLocation(RestPresenter.screenWidth - 270, 25);
        timerLabel.setLocation(50, 25);

        backgroundPanel.setBounds(0, 0, RestPresenter.screenWidth, RestPresenter.screenHeight);

        instructionLabel.setBounds(0, Math.round(RestPresenter.screenHeight / 2) - 200, RestPresenter.screenWidth, Math.round(RestPresenter.screenHeight / 2) + 200);
        explanationLabel.setBounds(100, Math.round(RestPresenter.screenHeight / 2) - 300, RestPresenter.screenWidth - 100, Math.round(RestPresenter.screenHeight / 2) - 200);

    }

    public void wait(int _seconds) {
        try {
            Thread.sleep(_seconds * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestPresenterUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RestPresenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestPresenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestPresenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestPresenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RestPresenterUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel explanationLabel;
    private javax.swing.JLabel instructionLabel;
    private javax.swing.JLabel recLED;
    private javax.swing.JLabel recLabel;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
