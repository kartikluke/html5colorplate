
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import org.xml.sax.SAXException;

public class AfterOptions extends JFrame implements ActionListener 
     {
     private static Scanner scan;
     private ButtonGroup group;
     private JButton button;
     private JTextField txtfld;
     private JLabel label;
     public int startindex = 0 ;
     private JLabel label2;
     public AfterOptions()
         {
         super( "Colorplate v0.3 - Generated Hex!" );
         setSize( 300, 250 );
show();

     }
    
   public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button) {

    }}
    
     public static void main( String args[] )
         {
         AfterOptions dx = new AfterOptions();
         }}
    