
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class HexParser extends JFrame implements ActionListener 
     {
     private static Scanner scan;
     private UIManager.LookAndFeelInfo looks[];
     private ButtonGroup group;
     private JButton button;
     private JTextField txtfld;
     private JLabel label;
     public int startindex = 0 ;
     private JLabel label2;
     public HexParser()
         {
         super( "Colorplate v0.3" );
        
         Container c = getContentPane();
        
         JPanel northPanel = new JPanel();
         northPanel.setLayout( new GridLayout( 4, 1, 0, 30 ) );
         northPanel.add(new JLabel(""));
         txtfld = new JTextField("Enter a search string, Eg:Superman", 10);
         northPanel.add(txtfld);
         button = new JButton( "Generate" );
         button.setFocusPainted(false);
         northPanel.add( button );
         button.addActionListener(this);
         label = new JLabel( "Colorplate is in BETA. Use at your own risk!", SwingConstants.CENTER );
         northPanel.add( label );
         c.add( northPanel, BorderLayout.NORTH );
         JPanel southPanel = new JPanel();
         group = new ButtonGroup();
         c.add( southPanel, BorderLayout.SOUTH );
     
         setSize( 300, 250 );
show();

     }
    
   public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button) {
            String data = txtfld.getText(); 
            try{
            doParse(data);
            }
            catch(IOException fe){}
            catch(SAXException fe){}
            catch(InterruptedException fe){}
        }
    }
    
     public static void main( String args[] )
         {
         HexParser dx = new HexParser();
        
         dx.addWindowListener( new WindowAdapter() 
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         } );
     }
    

                public void doParse(String qtemp) throws IOException, SAXException, InterruptedException {
		XMLReader xml = XMLReaderFactory.createXMLReader();
		xml.setContentHandler(new XMLParserKuler());
		scan = new Scanner(System.in);
		xml.parse(new InputSource(new URL("https://kuler-api.adobe.com/rss/search.cfm?searchQuery="+qtemp+"&key=F92EDA09832AF73ED0217B09E9C98F1C&itemsPerPage=1&startIndex="+startindex).openStream()));
		
		
		File file1 = new File("./htmlcss/css/colors.less");
		File file2 = new File("./htmlcss/css/colors.less");
		try{
			 
    	
    		
    		if(file1.delete()){
    			System.out.println(file1.getName() + " deleted!");
    		}else{
    			System.out.println("Existing colors.less not found, creating new .");
    		}
    		
    		if (file2.createNewFile()){
    	        System.out.println("File is created!");
    	      }else{
    	        System.out.println("File already exists.");
    	    }
 
    	}catch(Exception e){ e.printStackTrace(); }
		
		SwatchAcceptor sb = new SwatchAcceptor();
		String colors[] = sb.getColors();
		
		FileWriter fw = new FileWriter(file2.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=1;i<6;i++){
			String str="@color"+i+": #"+colors[i-1]+";";
			bw.write(str);
			bw.newLine();
			System.out.println(str);
		}
		bw.close();
                AfterLogic();
	}

                
                public void AfterLogic()
                {
                AfterOptions afteroptions = new AfterOptions();
                }
     
}


