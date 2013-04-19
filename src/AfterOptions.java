
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

public class AfterOptions extends JFrame implements ActionListener 
     {

     private static Scanner scan;
     private ButtonGroup group;
     private JTextArea txtarea;
     public JButton button;
     public int startindex = 0 ;
     public AfterOptions()
         {
         super( "Colorplate v0.3" );
        
         Container c = getContentPane();
         
         JPanel northP = new JPanel();
         
         northP.setLayout( new GridLayout( 8, 1, 0, 2 ) );
         northP.add(new JLabel("Swatch for Superman:"));
         Image image = null;
        try {
            URL url = new URL("https://kuler-api.adobe.com/kuler/themeImages/theme_2216979.png");
            image = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        JLabel swatchimage = new JLabel(new ImageIcon(image));
         northP.add(swatchimage);
         northP.add(new JLabel("Here are your Hexcodes:"));
         txtarea = new JTextArea("ColorCodes",5, 2);
         JScrollPane sp = new JScrollPane(txtarea);
         sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         northP.add(sp);
         button = new JButton("Next match");
         button.setFocusPainted(false);
         northP.add(button);
         
         northP.add(new JLabel("Compile main.less now."));
         c.add( northP, BorderLayout.NORTH );
         JPanel southPanel = new JPanel();
         group = new ButtonGroup();
         c.add( southPanel, BorderLayout.SOUTH );
         setSize( 350, 500 );
show();
     }
    
   public void actionPerformed(ActionEvent e)
    {
}
    
     public static void main( String args[] )
         {
         AfterOptions dx = new AfterOptions();
           dx.addWindowListener( new WindowAdapter() 
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         } );
         }}
    