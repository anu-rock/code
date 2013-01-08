/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pclient;
import javax.swing.UIManager;
/**
 *
 * @author GAGAN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    System.out.println(UIManager.getSystemLookAndFeelClassName());
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                new clientframe().setVisible(true);
            }
        });
    // TODO code application logic here
    }
}
