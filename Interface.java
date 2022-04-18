package questionbank;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.directory.SearchResult;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
/*
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;   */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

//import org.w3c.dom.Element;
//import org.w3c.dom.Text;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
//import edu.stanford.nlp.util.Index;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;

import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;


import net.didion.jwnl.data.PointerUtils;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;

public class Interface {


	
	public JFrame frmQuestionGeneration;
	JButton btnNewButton;
	JLabel lblNewLabel;
	questiongen qg=new questiongen();
	JTextField textField;
	
	
	private static final Object[] String = null;
	static net.didion.jwnl.dictionary.Dictionary dict;
	File file;
	String text =null;
	String textt=null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmQuestionGeneration.setVisible(true);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuestionGeneration = new JFrame();
		frmQuestionGeneration.setTitle("Question Bank Generation Tool");
		frmQuestionGeneration.setBounds(100, 100, 634, 381);
		frmQuestionGeneration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Upload_file = new JButton("PDF file");
		Upload_file.setBounds(421, 11, 89, 39);
		Upload_file.setBackground(Color.PINK);
		Upload_file.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		Upload_file.setToolTipText("");
		Upload_file.addActionListener(new ActionListener() {
			
		         public void actionPerformed(ActionEvent e) {
		            JFileChooser fileChooser = new JFileChooser();
		            
		            ///////
		          //  fileChooser.setDialogTitle("save file");
		            /////////
		          //  int result= fileChooser.showSaveDialog(null);
		         //   fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		           // int option = fileChooser.showOpenDialog(frmQuestionGeneration);
		            int option = fileChooser.showDialog(frmQuestionGeneration, null);
		            if(option == JFileChooser.APPROVE_OPTION){
		                file = fileChooser.getSelectedFile();
		               textField.setText("Folder Selected: " + file.getName());
		              }else{
		            	textField.setText("Open command canceled");
		            }
		            
		               
			           //////////////////////
			       		PDDocument document = null;
			    		try {
			    			document = PDDocument.load(file);
			    		} catch (IOException e1) {
			    			// TODO Auto-generated catch block
			    			e1.printStackTrace();
			    		}
			    		try {
			    			 text = new PDFTextStripper().getText(document);
			    			 System.out.println("Text in PDF\n---------------------------------");
			    		     System.out.println(text);
			    		} catch (IOException e1) {
			    			// TODO Auto-generated catch block
			    			e1.printStackTrace();
			    		} //Get the text from doc using PDFTextStripper 
			    		finally {
			    			try {
								document.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    		}
		         } 
		      });
	
		 textt=text;
		frmQuestionGeneration.getContentPane().setLayout(null);
		frmQuestionGeneration.getContentPane().add(Upload_file);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(55, 195, 553, 147);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setText("OUTPUT");
		frmQuestionGeneration.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Please choose a pdf file for question generation");
		lblNewLabel_1.setBounds(111, 42, 306, 14);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		frmQuestionGeneration.getContentPane().add(lblNewLabel_1);
		
		JButton Output_Questions = new JButton("Output Questions");
		Output_Questions.setBounds(430, 143, 149, 35);
		Output_Questions.setBackground(Color.PINK);
		Output_Questions.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		Output_Questions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				try {
					
					String ques=qg.questionbank(file);
					
					textArea.setText(ques);
				
				} catch (FileNotFoundException | JWNLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		
				/*
				
				try {
					qg.questionbank(file);
			
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JWNLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				FileReader f;
				try {
					f = new FileReader("mcqs.xml");
					BufferedReader b = new BufferedReader(f);
					
					boolean eof = false;
					  
					while(! eof)
					  {
					  String lineIn;
					try {
						lineIn = b.readLine();
						 if(lineIn == null)
						    {
						    eof = true;
						    }
						  else
						    {
							  textArea.append(lineIn + System.getProperty("line.separator"));
					} 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 } }catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  */
				
			}
		});
		frmQuestionGeneration.getContentPane().add(Output_Questions);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Click a button from menu");
		lblNewLabel_2.setBounds(240, 87, 306, 28);
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		frmQuestionGeneration.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(103, 21, 308, 20);
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.LIGHT_GRAY);
		frmQuestionGeneration.getContentPane().add(textField);
		textField.setColumns(10);		
		
		JButton Pos_tagging = new JButton("POS Tagging");
		Pos_tagging.setBounds(72, 143, 133, 35);
		Pos_tagging.setBackground(Color.PINK);
		Pos_tagging.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		Pos_tagging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
			
		           // System.out.println(tagged[j]);  
						  try {
							textArea.setText(POS_tagging());
						} catch (JWNLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			}
		});
		frmQuestionGeneration.getContentPane().add(Pos_tagging);
		
		JButton Extracted_text = new JButton("Extracted Text ");
		Extracted_text.setBounds(72, 97, 133, 35);
		Extracted_text.setBackground(Color.PINK);
		Extracted_text.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		Extracted_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				textArea.setText(text);
			}
			
		});
		frmQuestionGeneration.getContentPane().add(Extracted_text);
		
		JButton Selected_sentences = new JButton("Selected Sentences");
		Selected_sentences.setBounds(431, 97, 148, 35);
		Selected_sentences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				try {
					textArea.setText(Selected_sentences ());
				} catch (JWNLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Selected_sentences.setBackground(Color.PINK);
		Selected_sentences.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		frmQuestionGeneration.getContentPane().add(Selected_sentences);
		
		JButton btnNewButton_1 = new JButton("Download Output File");
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		     
		     
		     
		     try
		     {
		     String s=textArea.getText();
		     if(s.length()>0)
		     {
		     FileDialog fd= new FileDialog(frmQuestionGeneration,"Save File As",FileDialog.SAVE);
		     fd.setFile("temp.txt");
		     fd.setDirectory("c:\\windows\\temp");
		     fd.setVisible(true);
		     String path=fd.getDirectory()+fd.getFile();

		     FileOutputStream fos=new FileOutputStream(path);
		     System.out.println(s);
		     byte[] b=s.getBytes();
		     fos.write(b);
		     fos.close();
		     }
		     }catch(Exception e1){System.out.println(e1);}

			}	
		});
		btnNewButton_1.setBounds(240, 161, 133, 28);
		frmQuestionGeneration.getContentPane().add(btnNewButton_1);
	}
	

	
	public String Text_Extraction(File filee) throws JWNLException, IOException
	{
	
	PDDocument document = PDDocument.load(filee);		
    String text = new PDFTextStripper().getText(document);
    return text;
	}
    /// Preprocessing////////
	public String Preprocessing () throws JWNLException, IOException
	{
			text = text.replaceAll("[-:+^0-9]*", "");
		//	text = text.replaceAll("[-:+^]*", "");
			System.out.println("I m here 1" +text); 
		text = text.replaceAll("\\+", "?");
		text = text.replaceAll("\\+", "?");
		text = text.replaceAll("\\+", "?");
		text = text.replaceAll("\\+", "?");
		text = text.replaceAll("\\ ◼+", "?");
		text = text.replaceAll("\\•+", "?");
	    text = text.replaceAll("(?:\\r?\\s{4,}(?=[A-Z]))", "?");
	    text = text.replaceAll("(?:\\r?\\n{2,})", "?"); 
	   // text = text.replaceAll("\\.(?=[A-Z])", "?");
	   text = text.replaceAll("\\.[A-Z]?", "?");	
	    System.out.println("I m here 2" +text); 
	    return text;
	}
	 /////////////////////// Passing string for POS TAGGING ///////////////////////////////////////	
	public String POS_tagging () throws JWNLException, IOException
	{
		//PDDocument document = PDDocument.load(file);		
	   // String text = new PDFTextStripper().getText(document);
	    
		MaxentTagger tagger =  new MaxentTagger("stanford-tagger-4.2.0/stanford-postagger-full-2020-11-17/models/english-left3words-distsim.tagger.");
	    String tagged = tagger.tagString(text);
	    StringBuilder sb = new StringBuilder ();
	   // System.out.println("I m here 2" +tagged); 
	     return tagged;
}
	
	public void questionbank(File filee) throws FileNotFoundException, JWNLException
	{
		POS pos;
		int count=0;
		String posvalue;
		String Op2 = null;
		Random randomWord = new Random();

           //////////////////////////Installing dictionary for synonyms////////////////////////
		net.didion.jwnl.dictionary.Dictionary dict;
	    File file = new File("jwnl14-rc2/jwnl14-rc2/config/file_properties.xml");
	    JWNL.initialize(new FileInputStream(file));
	    dict = net.didion.jwnl.dictionary.Dictionary.getInstance();
	    

						
	/////////////////////////////XML VARIABLES//////////////////////////////////////////	
		Element mainElement = null;
		Element rootElement=null;
		Element question=null;
		Element Option1=null;
		Element Option2=null;
		Element Option3=null;
		Element Option4=null;
	//	Text opt1= null;
		Text opt2= null;
		Text que= null;
	//	Text opt3= null;
	//	Text opt4= null;
		
//      Addressing towards XML file 
		File xmlfile =new File("mcqs.xml");
		if(xmlfile.exists())
		{
			//DocumentBUILDERfACTORY
			DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
			try {
			//DocumentBuilder
				DocumentBuilder docBuilder= docFactory.newDocumentBuilder();
				Document xmlDoc= docBuilder.newDocument();
				//create rootnode
				rootElement =xmlDoc.createElement("QUESTIONS");
				
			
		//********************************************** XML  *************************************************************** 

		
		PDDocument document = PDDocument.load(filee);		
        String text = new PDFTextStripper().getText(document);

        /// Preprocessing////////
				text = text.replaceAll("[-:+^0-9]*", "");
			//	text = text.replaceAll("[-:+^]*", "");
				System.out.println("I m here 1" +text); 
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\ ◼+", "?");
			text = text.replaceAll("\\•+", "?");
		    text = text.replaceAll("(?:\\r?\\s{4,}(?=[A-Z]))", "?");
		    text = text.replaceAll("(?:\\r?\\n{2,})", "?"); 
		   // text = text.replaceAll("\\.(?=[A-Z])", "?");
		   text = text.replaceAll("\\.[A-Z]?", "?");	
		    System.out.println("I m here 2" +text); 
		 /////////////////////// Passing string for POS TAGGING ///////////////////////////////////////		     
			MaxentTagger tagger =  new MaxentTagger("stanford-tagger-4.2.0/stanford-postagger-full-2020-11-17/models/english-left3words-distsim.tagger.");

					 /////////////////////// Splitting string into sentences ///////////////////////////////////////	
				//     \\s{2,}
				   //  String[] tagged = tagger.tagString(text).split("\\.+|\\?+|\\:+|\\R|\\•+");
		    String[] tagged = tagger.tagString(text).split("\\.+(?=[A-Z])|\\?+|\\:+|\\•+|\\+| (?:\\r?\\n){2} | \\n(?=[A-Z]) | \\◼+");
		 //   String[] tagged = tagger.tagString(text).split("\\?+|\\:+|\\•+|\\+| (?:\\r?\\n){2} | \\n(?=[A-Z])");
				   for (int j=0; j< tagged.length; j++)
				   {
				            System.out.println(tagged[j]);  
				       }   
				   

				   String selected_sentences = null;
				   
					 /////////////////////// Splitting string into words ///////////////////////////////////////		   
				   String [] wordbreak= tagger.tagString(text).split(" ");
		  
				   /////putting all the NNP nouns in nouns array but first here added into list
				    ArrayList<String> list = new ArrayList<String>();
				    int n=0;
				   for (int j=0; j< wordbreak.length; j++)
				   {
					   String nnpfinder = "\\w+NNP\\b";
					   Pattern r = Pattern.compile(nnpfinder);
					   Matcher m = r.matcher(wordbreak[j]);   
				           if (m.find( )) 
				       {
				        	  list.add( wordbreak[j]) ;
				       } 
				   
				   }
				////// INitilializing nouns array of list size   
				   String[] nouns = new String[ list.size() ];
				   // Convert ArrayList to object array
				   Object[] objArr = list.toArray();
				   // Iterating and converting to String
			        int i = 0;
			        for (Object obj : objArr) {
			            nouns[i++] = (String)obj; //// here nouns array is ready containing all the nouns NNP
			        }
				   
				   
				   System.out.println("***********NOUNS**************"); 
				   for( int j = 0; j < nouns.length; j++ )
					   System.out.println(nouns[j]); 
					   
					   
	            ////////////////NOW Regular Expressions for Question Generation//////////////////
				 /////////////// Pattern 1/////////////////////////////////////////////
				 /////////////////regex for two consecutive words///////////////
				   String patternn = "\\w+NNP\\b.\\w+VBZ\\b";
				//   String ptrn = "\\w+NN\\b.\\w+VBZ\\b.\\w+VBN\\b.\\w+IN\\b.\\w+NN\\b"; 
				   
				      // Create a Pattern object
				      Pattern r = Pattern.compile(patternn);
				      
					 
				          // Now create matcher object.
				  
		for (int k=0; k< tagged.length; k++)
	{  
				    	  System.out.println("****************"+k+"*****************");
				    	  ////// XML OBjects created in the loop so that in every iteration they will be formed
				    	  question =xmlDoc.createElement("question");
				    	  Option1 =xmlDoc.createElement("option1");
				    	  Option2 =xmlDoc.createElement("option2");
				          Option3 =xmlDoc.createElement("option3");		
				    	  Option4 =xmlDoc.createElement("option4");	  
				    	  ///////////////////pattern 2////////////////////////////
				    	//	String pattern2 = "\\w+CD\\b";
					     //    Pattern r2 = Pattern.compile(pattern2);
					    //    Matcher m2 = r2.matcher(tagged[k]); 
					     
					         ///////////////////pattern 3////////////////////////////	  
							  String pattern3 = "\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b|\\w+VBP\\b)";
						     //    String pattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // NN CHAYE 2 HON YA 3 UN K AGY AGR VBZ HAI TW QUESTION
						         Pattern r3 = Pattern.compile(pattern3);
						         Matcher m3 = r3.matcher(tagged[k]); 
				            ///////////////////pattern 4////////////////////////////	    
							     //  String pattern4 ="\\w+NNP\\b?.\\w+NNS\\b.\\w+VBP\\b.";
							       String pattern4 ="\\w+NN\\b.(?=\\w+VBZ\\b|\\w+VBP\\b)";
							      // String pattern4 ="\\w+NN\\b | \\w+NNP\\b | \\w+NNS\\b {1,}(?=\\w+VBZ\\b|\\w+VBP\\b)";
							       Pattern r4 = Pattern.compile(pattern4);
							       Matcher m4 = r4.matcher(tagged[k]);   
							       
					///////////////////pattern 5////////////////////////////	      
					        	   
							       String pattern5 = "\\w+NNP\\b.\\(";
							         Pattern r5 = Pattern.compile(pattern5);
							         Matcher m5 = r5.matcher(tagged[k]);     
							         
					///////////////////pattern 6////////////////////////////	
						       /////////it_PRP should_MD also_RB have_VB a_DT default_NN value_NN        
						       String pattern6 = " \\b(\\w+NNS\\b|\\w+VBP\\b)(?:\\W+\\w+){0,0}?\\W+(\\w+NNS\\b|\\w+VBP\\b)\\b" ;// two consecutive NNS AND VBP
							    Pattern r6 = Pattern.compile(pattern6);
								Matcher m6 = r6.matcher(tagged[k]);   	
				///////////////////pattern 7////////////////////////////			
						        String pattern7 = "\\w+NNP\\b.\\w+NN\\b.\\w+VBZ\\b"; // is_VBZ known_VBN as_IN reliability_NN 
						         Pattern r7 = Pattern.compile(pattern7);
						         Matcher m7 = r7.matcher(tagged[k]);  
				///////////////////pattern 8////////////////////////////		         
						         String pattern8 = "\\w+NNS\\b.\\w+CC\\b.\\w+NNS\\b";
						         Pattern r8 = Pattern.compile(pattern8);
						         Matcher m8 = r8.matcher(tagged[k]);   
						         
				///////////////////pattern 9////////////////////////////	
						         String pattern9 = "\\w+NNS\\b.\\w+MD\\b.\\w+VB\\b.\\w+VBN\\b|VBZ\\b";
						         Pattern r9 = Pattern.compile(pattern9);
						         Matcher m9 = r9.matcher(tagged[k]);  
						         
				///////////////////pattern 10////////////////////////////	
						         String pattern10 = "\\w+NN\\b.\\w+NN\\b.\\w+NNS\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";
						         Pattern r10 = Pattern.compile(pattern10);
						         Matcher m10 = r10.matcher(tagged[k]);   
						         
					///////////////////pattern 11////////////////////////////	
						     //    String pattern11 = "\\w+NN|NNS|NNP\\b.\\–";
						         
						      //   String pattern11 = "(?=\\w+NN\\b|\\w+NNS\\b|\\w+NNP\\b).\\–";
						         String pattern11 = "\\w+NN\\b.\\–|\\:";
						         Pattern r11 = Pattern.compile(pattern11);
						         Matcher m11 = r11.matcher(tagged[k]);   
							         
				//////////// first ka matcher			         
				          Matcher m = r.matcher(tagged[k]);   
if (m.find( )) {
	
	selected_sentences+=tagged[k];
 	System.out.println("Found pattern3, noun awr verb k sath wala");
    //  mainElement =xmlDoc.createElement("QUESTION"+count++);
      
      String subpattern1 = "\\w+NNP\\b.*?(?=\\w+VBZ\\b)"; // sirf NN extract krne k liye ye if lagaya a 
	    Pattern subr1 = Pattern.compile(subpattern1);
	    Matcher subm1 = subr1.matcher(tagged[k]);   
	      if (subm1.find( ) && countWords(tagged[k])>7) {
				        mainElement =xmlDoc.createElement("QUESTION"+count++);
				        System.out.println("Found pattern1, noun awr verb k sath wala");
				        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
				        
				       String p=subm1.group(0);
				    		   //.replaceAll("\\w+VBZ\\b", "");    
				      //  String p=m.group(0).replaceAll("", "");  
				        posvalue=p.replaceAll("\\S+_", " ");
				         

				        String chwl=null;
				        String keyoption=null;
				         keyoption= p.replaceAll("_\\S+.*", "");
				        System.out.print("key option is "+keyoption);
				       
				        
				        
				        // If answer is an acronym, there would not be synonym of it, so pick randomly uppercase nouns from the String
				        
				        if(isStringUpperCase(keyoption)==true)
				         {
				        	System.out.print("it is uppercase");
				   		 do {
		        			 
			        		 randomWord = new Random();
						     Op2=nouns[randomWord.nextInt(nouns.length)];
					         chwl=Op2.replaceAll("_\\S+.*", "");
					         System.out.println(keyoption.trim()+"==========="+chwl);
			        		 } while(chwl.equals(keyoption.trim()) || isStringUpperCase(chwl.trim())==false); 
				         }
				        
				        else {
				        	
				        try
				        {
				        	System.out.print("it is not uppercase so finding for synonyms\n");
				        	pos= generatePOSvalue(posvalue);
				        	System.out.print("\n pos value"+pos);
				        	if(pos!=null)
				        	{
				        		
				        	  String synonym []=null;
				              synonym =getSynonyms( keyoption, pos);
				              if(synonym !=null)
				             {
				             for(int s=0; s<synonym.length ; s++)
				             {
				            	 System.out.print(" \n"+synonym [s]);
				             }
				        	 do {
				        		 
				        		 randomWord = new Random();
							     Op2=synonym[randomWord.nextInt(synonym.length)];
						         chwl=Op2.replaceAll("_\\S+", "");
						         System.out.println("chwl ki value"+chwl);
				               }while(chwl==keyoption);
				             }
				             else {
				            	
				        		 do {
				        			 
				        		 randomWord = new Random();
							     Op2=nouns[randomWord.nextInt(nouns.length)];
						         chwl=Op2.replaceAll("_\\S+", "");
						         System.out.println(keyoption.trim()+"==========="+chwl);
				        		 } while(chwl.equals(keyoption.trim())); 
				        		  }
				        	 System.out.print("synonym null anay k bad, random value "+chwl);
				             }
				        }catch(NullPointerException e ){
				        	e.printStackTrace();
				        }
				       
				        }
				       System.out.println("****************Question*****************\n");
				         String s;
				          s = subm1.replaceAll("................");
				         System.out.println(s.replaceAll("_\\S+", "")+"?\n");
				         que= xmlDoc.createTextNode(s.replaceAll("_\\S+", "")+"?");
				         question.appendChild(que);
				         
				         System.out.println("1."+chwl);
				         System.out.println("2."+p.replaceAll("_\\S+", ""));
				         opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
			    		 Option2.appendChild(opt2);
				         System.out.println("3.");
				         System.out.println("4. None of the Above");
				       System.out.println("\n*****************************************\n");
				       mainElement.appendChild(question); 
				       question.appendChild(Option1);
			           question.appendChild(Option2);
			           question.appendChild(Option3);
			           question.appendChild(Option4);
			           rootElement.appendChild(mainElement); 
			           
			           
		} 
	      
}
		  
  if (m3.find( )) {
	  selected_sentences+=tagged[k];
		    	System.out.println("Found pattern3, noun awr verb k sath wala");
		      //  mainElement =xmlDoc.createElement("QUESTION"+count++);
		        
		        String subpattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // sirf NN extract krne k liye ye if lagaya a 
			    Pattern subr3 = Pattern.compile(subpattern3);
			    Matcher subm3 = subr3.matcher(tagged[k]);   
			      if (subm3.find( ) && countWords(tagged[k])>7) {
		        
		        String p=m3.group(0).replaceAll("\\w+VBZ\\b", "");  
		        
		        System.out.println("ye hai"+p);
		        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
		        System.out.println("****************Question*****************\n");
		      
		    	  String s3= subm3.replaceFirst("................");
		    	 
		         mainElement =xmlDoc.createElement("QUESTION"+count++);
		         System.out.println(s3.replaceAll("_\\S+", "")+"?\n");
		         que= xmlDoc.createTextNode(s3.replaceAll("_\\S+", "")+"?\n");
		         question.appendChild(que);
		         
		         System.out.println("1.");
		         System.out.println("2."+p.replaceAll("_\\S+", ""));
		         opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
	    		 Option2.appendChild(opt2);
		         System.out.println("3.");
		         System.out.println("4.None of the Above");
		         System.out.println("\n*****************************************\n");
		         mainElement.appendChild(question); 
			       question.appendChild(Option1);
		           question.appendChild(Option2);
		           question.appendChild(Option3);
		           question.appendChild(Option4);  
		           rootElement.appendChild(mainElement); 
		           
		          
		      }  
		      }
		    
if (m5.find( )) { 
	selected_sentences+=tagged[k];
	/////////// abbreviation wala pattern  /////////
		        //  mainElement =xmlDoc.createElement("QUESTION"+count++);
		         
		        // System.out.println(m5.group(0).replaceAll("_\\S+.*", ""));
		         String isuppercase= m5.group(0).replaceAll("_\\S+.*", "");
		         
		     if(isStringUpperCase(isuppercase)==true)
		         {
		         System.out.println("Found value: p5 abbreviation wala");
		         String p=m5.group(0); 
		         String s= m5.group(0).replaceAll("\\(", "?");
		         System.out.println("\n****************Question*****************\n");
		         mainElement =xmlDoc.createElement("QUESTION"+count++);
			     System.out.println("what is the abbreviation of "+s.replaceAll("_\\S+", "")+"\n");
			     que= xmlDoc.createTextNode("what is the abbreviation of "+s.replaceAll("_\\S+", "")+"\n");
		         question.appendChild(que);
			     
		         String subpattern5 = "(?<=\\().*?(?=\\))";
		       //  String subpattern5 = ".*";
		         Pattern subr5 = Pattern.compile(subpattern5);
	             Matcher m0 = subr5.matcher(tagged[k]);  
	                if (m0.find( )) 
	                {
	                	mainElement =xmlDoc.createElement("QUESTION"+k);
	                //	System.out.println("p5 ka dosra pattern  matched"); 
				    
				         System.out.println("1.");
				         System.out.println("2."+m0.group().replaceAll("_\\S+", ""));
				         opt2= xmlDoc.createTextNode(m0.group().replaceAll("_\\S+", ""));
			    		 Option2.appendChild(opt2);
				         System.out.println("3.");
				         System.out.println("4.None of the Above");
				         System.out.println("\n*****************************************\n");
				         mainElement.appendChild(question); 
					       question.appendChild(Option1);
				           question.appendChild(Option2);
				           question.appendChild(Option3);
				           question.appendChild(Option4); 
				           rootElement.appendChild(mainElement); 
				           
				          
                    }
		         }
		         
	                 }
if (m6.find( )) {
	selected_sentences+=tagged[k];
		    	  System.out.println("Found pattern6, ...........................................");
		    	  System.out.println("ye hai"+tagged[k].replaceAll("", ""));
		     //   mainElement =xmlDoc.createElement("QUESTION"+count++);
		        
		        String subpattern6 = "\\w+NN\\b.?\\w+NNS\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
			    Pattern subr6 = Pattern.compile(subpattern6);
			         Matcher subm6 = subr6.matcher(tagged[k]);   
			      if (subm6.find( ) && countWords(tagged[k])>7) {
		        
		        String p=subm6.group(0);  
		        
		        System.out.println("ye hai"+p);
		        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
		        System.out.println("****************Question*****************\n");
		      
		    	  String s3= subm6.replaceFirst("................");
		    	 
		         mainElement =xmlDoc.createElement("QUESTION"+count++);
		         System.out.println(s3.replaceAll("_\\S+", "")+"?\n");
		         que= xmlDoc.createTextNode(s3.replaceAll("_\\S+", "")+"?\n");
		         question.appendChild(que);
		         
		         System.out.println("1.");
		         System.out.println("2."+p.replaceAll("_\\S+", ""));
		         opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
	    		 Option2.appendChild(opt2);
		         System.out.println("3.");
		         System.out.println("4.None of the Above");
		         System.out.println("\n*****************************************\n");
		         mainElement.appendChild(question); 
			       question.appendChild(Option1);
		           question.appendChild(Option2);
		           question.appendChild(Option3);
		           question.appendChild(Option4);  
		           rootElement.appendChild(mainElement); 
		           
		        
		      }  
		      }
		      
if (m7.find( )) {
	selected_sentences+=tagged[k];
	    	  System.out.println("Found pattern7, noun awr verb k sath wala");
	      //  mainElement =xmlDoc.createElement("QUESTION"+count++);
	        
	        String subpattern7 = "\\w+NNP\\b.*?(?=\\w+VBZ\\b|\\w+VBP\\b)";// sirf NN extract krne k liye ye if lagaya a 
		    Pattern subr7 = Pattern.compile(subpattern7);
		         Matcher subm7 = subr7.matcher(tagged[k]);   
		      if (subm7.find( ) && countWords(tagged[k])>7){
	        
	        String p=subm7.group(0);  
	        
	        System.out.println("ye hai"+p);
	        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
	        System.out.println("****************Question*****************\n");
	      
	    	  String s3= subm7.replaceFirst("................");
	    	 
	         mainElement =xmlDoc.createElement("QUESTION"+count++);
	         System.out.println(s3.replaceAll("_\\S+", "")+"?\n");
	         que= xmlDoc.createTextNode(s3.replaceAll("_\\S+", "")+"?\n");
	         question.appendChild(que);
	         
	         System.out.println("1.");
	         System.out.println("2."+p.replaceAll("_\\S+", ""));
	         opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
   		 Option2.appendChild(opt2);
	         System.out.println("3.");
	         System.out.println("4.None of the Above");
	         System.out.println("\n*****************************************\n");
	         mainElement.appendChild(question); 
		       question.appendChild(Option1);
	           question.appendChild(Option2);
	           question.appendChild(Option3);
	           question.appendChild(Option4);  
	           rootElement.appendChild(mainElement); 
	           
	           
	      }  
	      }

if (m4.find( )) {
	selected_sentences+=tagged[k];
    //  mainElement =xmlDoc.createElement("QUESTION"+count++);
      System.out.println("p4 NN VBZ");
    String subpattern4 = "\\w+NN\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
   //   String subpattern4 = ".*(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";
		    Pattern subr4 = Pattern.compile(subpattern4);
		         Matcher subm4 = subr4.matcher(tagged[k]);   
		      if (subm4.find( ) && countWords(tagged[k])>7) {
     
      String p=subm4.group(0);
      System.out.println(""+p);
      System.out.println("ye hai"+tagged[k].replaceAll("", ""));
      System.out.println("\n****************Question*****************\n");
      String s= subm4.replaceFirst(".............");
      System.out.println(s.replaceAll("_\\S+", "")+"\n");
      
      mainElement =xmlDoc.createElement("QUESTION"+count++);
      que= xmlDoc.createTextNode(s.replaceAll("_\\S+", "")+"?\n");
      question.appendChild(que);
      
      System.out.println("1.");
      System.out.println("2."+p.replaceAll("_\\S+", ""));
      opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
		 Option2.appendChild(opt2);
      System.out.println("3.");
      System.out.println("4.None of the Above");
      System.out.println("\n*****************************************\n");
      mainElement.appendChild(question); 
	       question.appendChild(Option1);
        question.appendChild(Option2);
        question.appendChild(Option3);
        question.appendChild(Option4); 
        rootElement.appendChild(mainElement); 
        
        
        }			                    
        }


if (m8.find( )) {
	selected_sentences+=tagged[k];
   	  System.out.println("Found pattern8, NNS CC NNS");
    //   mainElement =xmlDoc.createElement("QUESTION"+count++);
       
       String subpattern8 = "\\w+NNS\\b.?(?=\\w+CC\\b)";// sirf NN extract krne k liye ye if lagaya a 
	    Pattern subr8 = Pattern.compile(subpattern8);
	         Matcher subm8 = subr8.matcher(tagged[k]);   
	      if (subm8.find( ) && countWords(tagged[k])>10) {
       
       String p=subm8.group(0);  
       System.out.println("lengthhhhhhhhhh    "+tagged[k].length());
       System.out.println("ye hai"+p);
       System.out.println("ye hai"+tagged[k].replaceAll("", ""));
       System.out.println("****************Question*****************\n");
     
   	  String s3= subm8.replaceFirst("................");
   	 
        mainElement =xmlDoc.createElement("QUESTION"+count++);
        System.out.println(s3.replaceAll("_\\S+", "")+"?\n");
        que= xmlDoc.createTextNode(s3.replaceAll("_\\S+", "")+"?\n");
        question.appendChild(que);
        
        System.out.println("1.");
        System.out.println("2."+p.replaceAll("_\\S+", ""));
        opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
		 Option2.appendChild(opt2);
        System.out.println("3.");
        System.out.println("4.None of the Above");
        System.out.println("\n*****************************************\n");
        mainElement.appendChild(question); 
	       question.appendChild(Option1);
          question.appendChild(Option2);
          question.appendChild(Option3);
          question.appendChild(Option4);  
          rootElement.appendChild(mainElement); 
          
         
     }  
     }
 if (m9.find( )) {
	 selected_sentences+=tagged[k];
	  System.out.println("Found pattern9, noun awr verb k sath wala");
  // mainElement =xmlDoc.createElement("QUESTION"+count++);
   
 String subpattern9 = "\\w+NNS\\b.?(?=\\w+MD\\b)";// sirf NN extract krne k liye ye if lagaya a 
  //// nooooooooo String subpattern9 = ".*(?=\\w+MD\\b)";
   Pattern subr9 = Pattern.compile(subpattern9);
        Matcher subm9 = subr9.matcher(tagged[k]);   
     if (subm9.find( ) && countWords(tagged[k])>10) {
   
   String p=subm9.group(0);  
   
   System.out.println("ye hai"+p);
   System.out.println("ye hai"+tagged[k].replaceAll("", ""));
   System.out.println("****************Question*****************\n");
 
	  String s3= subm9.replaceFirst("................");
	 
    mainElement =xmlDoc.createElement("QUESTION"+count++);
    System.out.println(s3.replaceAll("_\\S+", "")+"?\n");
    que= xmlDoc.createTextNode(s3.replaceAll("_\\S+", "")+"?\n");
    question.appendChild(que);
    
    System.out.println("1.");
    System.out.println("2."+p.replaceAll("_\\S+", ""));
    opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
	 Option2.appendChild(opt2);
    System.out.println("3.");
    System.out.println("4.None of the Above");
    System.out.println("\n*****************************************\n");
    mainElement.appendChild(question); 
      question.appendChild(Option1);
      question.appendChild(Option2);
      question.appendChild(Option3);
      question.appendChild(Option4);  
      rootElement.appendChild(mainElement); 
      
     
 }  
 }
if (m10.find( )) {
	selected_sentences+=tagged[k];
System.out.println("Found pattern10, noun awr verb k sath wala");
//mainElement =xmlDoc.createElement("QUESTION"+count++);

String subpattern10 = "\\w+NN\\b.*?(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
Pattern subr10 = Pattern.compile(subpattern10);
    Matcher subm10 = subr10.matcher(tagged[k]);   
 if (subm10.find( )) {

String p=subm10.group(0);  

System.out.println("ye hai"+p);
System.out.println("ye hai"+tagged[k].replaceAll("", ""));
System.out.println("****************Question*****************\n");

String s3= subm10.replaceFirst("................");

mainElement =xmlDoc.createElement("QUESTION"+count++);
System.out.println(s3.replaceAll("_\\S+", "")+"?\n");
que= xmlDoc.createTextNode(s3.replaceAll("_\\S+", "")+"?\n");
question.appendChild(que);

System.out.println("1.");
System.out.println("2."+p.replaceAll("_\\S+", ""));
opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
Option2.appendChild(opt2);
System.out.println("3.");
System.out.println("4.None of the Above");
System.out.println("\n*****************************************\n");
mainElement.appendChild(question); 
  question.appendChild(Option1);
 question.appendChild(Option2);
 question.appendChild(Option3);
 question.appendChild(Option4);  
 rootElement.appendChild(mainElement); 
 

}  
}

if (m11.find( )) {
	selected_sentences+=tagged[k];
System.out.println("Found pattern11, hyphen wala");
//mainElement =xmlDoc.createElement("QUESTION"+count++);

String subpattern11 = ".*?(?=\\–)";// sirf NN extract krne k liye ye if lagaya a 
Pattern subr11 = Pattern.compile(subpattern11);
    Matcher subm11 = subr11.matcher(tagged[k]);   
 if (subm11.find( )) {

String p=subm11.group(0);  

System.out.println("ye hai"+p);
System.out.println("ye hai"+tagged[k].replaceAll("", ""));
System.out.println("****************Question*****************\n");

String s3= subm11.replaceFirst("................refers to");

mainElement =xmlDoc.createElement("QUESTION"+count++);
System.out.println(s3.replaceAll("_\\S+", "")+"?\n");
que= xmlDoc.createTextNode(s3.replaceAll("_\\S+", "")+"?\n");
question.appendChild(que);

System.out.println("1.");
System.out.println("2."+p.replaceAll("_\\S+", ""));
opt2= xmlDoc.createTextNode(p.replaceAll("_\\S+", ""));
Option2.appendChild(opt2);
System.out.println("3.");
System.out.println("4.None of the Above");
System.out.println("\n*****************************************\n");
mainElement.appendChild(question); 
  question.appendChild(Option1);
 question.appendChild(Option2);
 question.appendChild(Option3);
 question.appendChild(Option4);  
 rootElement.appendChild(mainElement); 
 }  
}

 else
 {
	 System.out.println("4.None of the Above"); 
 }


	}			
                     //  rootElement.appendChild(mainElement); 
				      xmlDoc.appendChild(rootElement);
					 DOMSource source= new DOMSource(xmlDoc);
					Result result= new StreamResult(xmlfile);
				    FileOutputStream oustream = new FileOutputStream(xmlfile);
			        TransformerFactory transformerFactory= TransformerFactory.newInstance();
					  Transformer transformer;
			try {
						transformer = transformerFactory.newTransformer();
						transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
						transformer.setOutputProperty(OutputKeys.INDENT, "no");
						transformer.transform(source, result);
				} catch (TransformerConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			
			
			catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			      
		
				      }
			
			     catch (ParserConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			     catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	public String Selected_sentences () throws JWNLException, IOException
	{
		PDDocument document = PDDocument.load(file);		
        String text = new PDFTextStripper().getText(document);

        /// Preprocessing////////
				text = text.replaceAll("[-:+^0-9]*", "");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\ ◼+", "?");
			text = text.replaceAll("\\•+", "?");
		    text = text.replaceAll("(?:\\r?\\s{4,}(?=[A-Z]))", "?");
		    text = text.replaceAll("(?:\\r?\\n{2,})", "?"); 
		   text = text.replaceAll("\\.[A-Z]?", "?");	
		 /////////////////////// Passing string for POS TAGGING ///////////////////////////////////////		     
			MaxentTagger tagger =  new MaxentTagger("stanford-tagger-4.2.0/stanford-postagger-full-2020-11-17/models/english-left3words-distsim.tagger.");

					 /////////////////////// Splitting string into sentences ///////////////////////////////////////	

		    String[] tagged = tagger.tagString(text).split("\\.+(?=[A-Z])|\\?+|\\:+|\\•+|\\+| (?:\\r?\\n){2} | \\n(?=[A-Z]) | \\◼+");

		     String selected_sentences = "";
				   
		
	            ////////////////NOW Regular Expressions for Question Generation//////////////////
				 /////////////// Pattern 1/////////////////////////////////////////////
				 /////////////////regex for two consecutive words///////////////
				   String patternn = "\\w+NNP\\b.\\w+VBZ\\b";
				//   String ptrn = "\\w+NN\\b.\\w+VBZ\\b.\\w+VBN\\b.\\w+IN\\b.\\w+NN\\b"; 
				   
				      // Create a Pattern object
				      Pattern r = Pattern.compile(patternn);
				      
					 
				          // Now create matcher object.
				  
		for (int k=0; k< tagged.length; k++)
	{ 
					         ///////////////////pattern 3////////////////////////////	  
							  String pattern3 = "\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b|\\w+VBP\\b)";
						     //    String pattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // NN CHAYE 2 HON YA 3 UN K AGY AGR VBZ HAI TW QUESTION
						         Pattern r3 = Pattern.compile(pattern3);
						         Matcher m3 = r3.matcher(tagged[k]); 
				            ///////////////////pattern 4////////////////////////////	    
							     //  String pattern4 ="\\w+NNP\\b?.\\w+NNS\\b.\\w+VBP\\b.";
							       String pattern4 ="\\w+NN\\b.(?=\\w+VBZ\\b|\\w+VBP\\b)";
							      // String pattern4 ="\\w+NN\\b | \\w+NNP\\b | \\w+NNS\\b {1,}(?=\\w+VBZ\\b|\\w+VBP\\b)";
							       Pattern r4 = Pattern.compile(pattern4);
							       Matcher m4 = r4.matcher(tagged[k]);   
							       
					///////////////////pattern 5////////////////////////////	      
					        	   
							       String pattern5 = "\\w+NNP\\b.\\(";
							         Pattern r5 = Pattern.compile(pattern5);
							         Matcher m5 = r5.matcher(tagged[k]);     
							         
					///////////////////pattern 6////////////////////////////	
						       /////////it_PRP should_MD also_RB have_VB a_DT default_NN value_NN        
						       String pattern6 = " \\b(\\w+NNS\\b|\\w+VBP\\b)(?:\\W+\\w+){0,0}?\\W+(\\w+NNS\\b|\\w+VBP\\b)\\b" ;// two consecutive NNS AND VBP
							    Pattern r6 = Pattern.compile(pattern6);
								Matcher m6 = r6.matcher(tagged[k]);   	
				///////////////////pattern 7////////////////////////////			
						        String pattern7 = "\\w+NNP\\b.\\w+NN\\b.\\w+VBZ\\b"; // is_VBZ known_VBN as_IN reliability_NN 
						         Pattern r7 = Pattern.compile(pattern7);
						         Matcher m7 = r7.matcher(tagged[k]);  
				///////////////////pattern 8////////////////////////////		         
						         String pattern8 = "\\w+NNS\\b.\\w+CC\\b.\\w+NNS\\b";
						         Pattern r8 = Pattern.compile(pattern8);
						         Matcher m8 = r8.matcher(tagged[k]);   
						         
				///////////////////pattern 9////////////////////////////	
						         String pattern9 = "\\w+NNS\\b.\\w+MD\\b.\\w+VB\\b.\\w+VBN\\b|VBZ\\b";
						         Pattern r9 = Pattern.compile(pattern9);
						         Matcher m9 = r9.matcher(tagged[k]);  
						         
				///////////////////pattern 10////////////////////////////	
						         String pattern10 = "\\w+NN\\b.\\w+NN\\b.\\w+NNS\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";
						         Pattern r10 = Pattern.compile(pattern10);
						         Matcher m10 = r10.matcher(tagged[k]);   
						         
					///////////////////pattern 11////////////////////////////	
						         String pattern11 = "\\w+NN\\b.\\–|\\:";
						         Pattern r11 = Pattern.compile(pattern11);
						         Matcher m11 = r11.matcher(tagged[k]);   
							         
				//////////// first ka matcher			         
				          Matcher m = r.matcher(tagged[k]);   
if (m.find( )) { 
      String subpattern1 = "\\w+NNP\\b.*?(?=\\w+VBZ\\b)"; // sirf NN extract krne k liye ye if lagaya a 
	    Pattern subr1 = Pattern.compile(subpattern1);
	    Matcher subm1 = subr1.matcher(tagged[k]);   
	      if (subm1.find( ) && countWords(tagged[k])>7) {
	    	  
	    	  
	    	  String p=subm1.group(0); 
	    	  String SS=tagged[k].replaceAll("_\\S+", "");
	    		selected_sentences=selected_sentences.concat(SS);  
	    		selected_sentences=selected_sentences.concat("\n");  
	    		System.out.println(p+"\n");
	    		System.out.println(selected_sentences);
		} 
	      
}
		  
  if (m3.find( )) {
		        String subpattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // sirf NN extract krne k liye ye if lagaya a 
			    Pattern subr3 = Pattern.compile(subpattern3);
			    Matcher subm3 = subr3.matcher(tagged[k]);   
			      if (subm3.find( ) && countWords(tagged[k])>7) {
			   
			    	  String p=subm3.group(0); 
			    	  p.replaceAll("_\\S+", "");
			    	  String SS=tagged[k].replaceAll("_\\S+", "");
			    		selected_sentences=selected_sentences.concat(SS);  
			    		selected_sentences=selected_sentences.concat("\n");   
			    		
			    		System.out.println(p+"\n");
			    		System.out.println(selected_sentences);
		      }  
		      }
		    
if (m5.find( )) { 
	
		         String isuppercase= m5.group(0).replaceAll("_\\S+.*", "");
		         
		     if(isStringUpperCase(isuppercase)==true)
		         {
		         String p=m5.group(0); 
		         String s= m5.group(0).replaceAll("\\(", "?");
			 	 String subpattern5 = "(?<=\\().*?(?=\\))";
		         Pattern subr5 = Pattern.compile(subpattern5);
	             Matcher m0 = subr5.matcher(tagged[k]); 
	             
	                if (m0.find( )) 
	                {
	                	 String s1=m0.group(0); 
	                	  String SS=tagged[k].replaceAll("_\\S+", "");
	      	    		selected_sentences=selected_sentences.concat(SS);  
	      	    		selected_sentences=selected_sentences.concat("\n");   
				    		
				    		System.out.println(s1+"\n");
				    		System.out.println(selected_sentences);
                    }
		         }
		         
	                 }
if (m6.find( )) {
		        String subpattern6 = "\\w+NN\\b.?\\w+NNS\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
			    Pattern subr6 = Pattern.compile(subpattern6);
			         Matcher subm6 = subr6.matcher(tagged[k]);   
			      if (subm6.find( ) && countWords(tagged[k])>7) {
			    	  String p=subm6.group(0); 
			    	  p.replaceAll("_\\S+", "");
			    	  String SS=tagged[k].replaceAll("_\\S+", "");
			    		selected_sentences=selected_sentences.concat(SS);  
			    		selected_sentences=selected_sentences.concat("\n");    
			    		
			    		System.out.println(p+"\n");
			    		System.out.println(selected_sentences);
		      }
		      
if (m7.find( )) {
	        String subpattern7 = "\\w+NNP\\b.*?(?=\\w+VBZ\\b|\\w+VBP\\b)";// sirf NN extract krne k liye ye if lagaya a 
		    Pattern subr7 = Pattern.compile(subpattern7);
		         Matcher subm7 = subr7.matcher(tagged[k]);   
		      if (subm7.find( ) && countWords(tagged[k])>7){  
		    	  String p=subm7.group(0); 
		    	  p.replaceAll("_\\S+", "");
		    	  String SS=tagged[k].replaceAll("_\\S+", "");
		    		selected_sentences=selected_sentences.concat(SS);  
		    		selected_sentences=selected_sentences.concat("\n");       
		    		
		    		System.out.println(p+"\n");
		    		System.out.println(selected_sentences);
	      }  
	      }

if (m4.find( )) {
     
    String subpattern4 = "\\w+NN\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
		    Pattern subr4 = Pattern.compile(subpattern4);
		         Matcher subm4 = subr4.matcher(tagged[k]);   
		      if (subm4.find( ) && countWords(tagged[k])>7) {
		    	  String p=subm4.group(0); 
		    	  p.replaceAll("_\\S+", "");
		    	  String SS=tagged[k].replaceAll("_\\S+", "");
		    		selected_sentences=selected_sentences.concat(SS);  
		    		selected_sentences=selected_sentences.concat("\n");  
		    		
		    		System.out.println(p+"\n");
		    		System.out.println(selected_sentences);
        }			                    
        }


if (m8.find( )) {
       String subpattern8 = "\\w+NNS\\b.?(?=\\w+CC\\b)";// sirf NN extract krne k liye ye if lagaya a 
	    Pattern subr8 = Pattern.compile(subpattern8);
	         Matcher subm8 = subr8.matcher(tagged[k]);   
	      if (subm8.find( ) && countWords(tagged[k])>10) {
	    	  String p=subm8.group(0); 
	    	  p.replaceAll("_\\S+", "");
	    	  String SS=tagged[k].replaceAll("_\\S+", "");
	    		selected_sentences=selected_sentences.concat(SS);  
	    		selected_sentences=selected_sentences.concat("\n");   
	    		System.out.println(p+"\n");
	    		System.out.println(selected_sentences);
     }  
     }
 if (m9.find( )) {
 String subpattern9 = "\\w+NNS\\b.?(?=\\w+MD\\b)";// sirf NN extract krne k liye ye if lagaya a 
   Pattern subr9 = Pattern.compile(subpattern9);
        Matcher subm9 = subr9.matcher(tagged[k]);   
     if (subm9.find( ) && countWords(tagged[k])>10) {
    	 String p=subm9.group(0); 
   	  p.replaceAll("_\\S+", "");
   	  String SS=tagged[k].replaceAll("_\\S+", "");
		selected_sentences=selected_sentences.concat(SS);  
		selected_sentences=selected_sentences.concat("\n");     
   		
   		System.out.println(p+"\n");
		System.out.println(selected_sentences);
 }  
 }
if (m10.find( )) {
	String subpattern10 = "\\w+NN\\b.*?(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
	Pattern subr10 = Pattern.compile(subpattern10);
	    Matcher subm10 = subr10.matcher(tagged[k]);   
	 if (subm10.find( )) {

	String p=subm10.group(0);  
	tagged[k].replaceAll("_\\S+", "");
	
	  String SS=tagged[k].replaceAll("_\\S+", "");
		selected_sentences=selected_sentences.concat(SS);  
		selected_sentences=selected_sentences.concat("\n");  
	
	
	System.out.println(p+"\n");
	System.out.println(selected_sentences);
}
}
else 
{
	System.out.println("");
}
}}
		System.out.println(selected_sentences);
		selected_sentences.replaceAll("_\\S+", "");
		return selected_sentences;
		
		
	}
	
	
	
	
	private static int countWords(String input)
	{ 
		if (input == null || input.isEmpty()) 
		{ return 0; }
		
		String[] words = input.split("\\s+"); 
		return words.length; }


	

///// not in used
private static Collection<? extends Synset> getAllSynset(String string, POS p) {
// TODO Auto-generated method stub
return null;
}

////// I am using it for checking upper case letter
private static boolean isStringUpperCase(String isuppercase) {
// TODO Auto-generated method stub
  //convert String to char array
char[] charArray = isuppercase.toCharArray();

for(int i=0; i < charArray.length; i++){
    
    //if any character is not in upper case, return false
    if( !Character.isUpperCase( charArray[i] ))
        return false;
}

return true;
}	
		
///// in use for checking POS of KEYOPTION
private static POS generatePOSvalue(String pos) {
String lemma;
POS Pos=null;
//String pos;
Object text;
//if (pos.equals("NNP") || pos.equals("NNS") || pos.equals("NN")) {
if (pos.contains("NN")) {
	// lemmatize verbs that are in WordNet
	//System.out.print("found");
	 Pos= POS.NOUN;
	 return Pos;
	
} else if (pos.contains("JJ")) {
	// lemmatize adjectives that are in WordNet
	 Pos= POS.ADJECTIVE;
	// return POS.ADJECTIVE;
	return Pos;
//} else if (pos.startsWith("VBZ") || pos.startsWith("VBN") || pos.startsWith("VBP") ||  pos.startsWith("VBG")) {
} else if (pos.contains("VB")) {
	// lemmatize adverbs that are in WordNet
	 Pos= POS.VERB;
	// return POS.VERB;
	 return Pos;
	//return Pos;
} else {
	// lemmatize nouns that are in WordNet
	System.out.println();
	return null;
	}
}
///// using for getting synonyms of words
public static String[] getSynonyms(String word, POS pos) {
	Synset synset = getCommonSynset(word, pos);
	if (synset == null) return null;
	
	return getLemm(synset);
}
///// not in used in future maybe
private static String[] getLemm(Synset synset) {
	Word[] words = synset.getWords();
	String[] lemmas = new String[words.length];
	
	for (int i = 0; i < words.length; i++) {
		lemmas[i] = words[i].getLemma();
		lemmas[i] = lemmas[i].replace("_", " ");
	}
	
	return lemmas;
}


////// in used in getSynonyms() function below
private static Synset getCommonSynset(String word, POS pos) {
	if (dict == null) return null;
	
	Synset synset = null;
	try {
		IndexWord indexWord = dict.lookupIndexWord(pos, word);
		if (indexWord == null) return null;
		synset = indexWord.getSense(1);
	} catch (JWNLException e) {}
	
	return synset;
}}



