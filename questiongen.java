package questionbank;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class questiongen {
	// extends javax.swing.JFrame

	private static final Object[] String = null;
	static net.didion.jwnl.dictionary.Dictionary dict;
	File file;
	String text =null;
	String textt=null;
//	Hashtable<String, String> my_dict = new Hashtable<String, String>();
//	private static String [] nouns;
	
	public static void main(String[] args) throws JWNLException, FileNotFoundException{
		
		
		
		net.didion.jwnl.dictionary.Dictionary dict;
	    File file = new File("jwnl14-rc2/jwnl14-rc2/config/file_properties.xml");
	    JWNL.initialize(new FileInputStream(file));
	    dict = net.didion.jwnl.dictionary.Dictionary.getInstance();
		
		////////////////////////GUI///////////////////////
		Questioninterface wind = new Questioninterface();
		File filee=wind.file;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questioninterface window = new Questioninterface();
					window.frmQuestionGeneration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}
		

	//	private final JFileChooser openFileChooser; 
		

	//	Questioninterface qi = new Questioninterface();
	      /*
		POS pos;
		String posvalue;
		String Op2 = null;
		String Letter[]= {"Action Language For Foundational UML","AtlanMod Transformation Language","Business Process Modeling Notation",
				"Conceptual Modeling","Conceptual Model","Conceptual Schema","Conformance","Content model", "Diagram","Domain Specific Language",
				"Domain Specific Modeling Language", "Eclipse Modeling Framework", "Extended Entity Relationship language",
				"Entity Relationship", "Entity Type", "Entity", "Executable UML", "Extended Entity Relationship","Entity Relationship language",
				"Foundational UML", "fUML", "Graph Transformation", "In-place Transformation", "Kernel Meta Meta Model", "KM3",
				"Model", "MDA", "MDD", "MDE","Model-Driven Architecture", "Model-Driven Development", "Model-Driven Engineering", "Metamodel",
				"Model migration", "Modeling Language", "Navigation model", "Object Constraint Language", "OCL", "OMG", "Object Management Group",
				"MOF", "Presentation model", "QVT", "QVT Relations", "QVT Operational Language", "QVT Core", "refactoring", "Software Language",
				"Transformation", "UML", "Unified Modeling Language", "UML specification", "Universal Modeling Language", "Executable UML",
				"xUML"};

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

//PDDocument document = PDDocument.load(new File("D:/second semester/SDA/lectures/LEC-3.pdf"));
	//	PDDocument document = PDDocument.load(new File("D:/3rd Semester/MDSE/lectures/lec01.pdf"));// MDSE
		PDDocument document = PDDocument.load(new File("D:/second semester/SDA/lectures/LEC-1.pdf")); // SDA
	//	PDDocument document = PDDocument.load(new File("D:/IST SEMESTER/SRE/lec3.pdf")); // SRE
		
	//	PDDocument document = PDDocument.load(wind.file);
		// ‪D:\IST SEMESTER\SRE\lec1.pdf
		//Get the text from doc using PDFTextStripper
		
        String text = new PDFTextStripper().getText(document);
       //  String text = wind.text;
		//String text = " We are workin    g on this     text now";
		
		System.out.println("Text in PDF  main wala\n---------------------------------");
      System.out.println(wind.textt);
		
	//	}catch (IOException e) {
    //        e.printStackTrace();
    //    }

	  // Now this text will be used by the algorithm to generate questions
		
		

	//RULE The_DT most_RBS important_JJ characteristic_NN of_IN transformation_NN definition_NN is_VBZ that_IN	
		
			//	text = text.replaceAll("[^a-zA-Z0-9]", " ");  
				text = text.replaceAll("[-:+^0-9]*", "");
				System.out.println("I m here 1" +text); 
				//-
		//	text = text.replaceAll("(\\r|\\n)*.*(\\r|\\n)", ".");
	//	text = text.replaceAll("\\r?\\n(?=[A-Z])", ".");
		//	text = text.replaceAll("\\n/>(?=[A-Z])", ".");
		//	text = text.replaceAll("\\$+", "........");
			text = text.replaceAll("\\+", ".");
			text = text.replaceAll("\\+", ".");
		//	text = text.replaceAll("\\+", ".");
			text = text.replaceAll("\\•+", ".");
		    text = text.replaceAll("(?:\\r?\\n(?=[A-Z]))", ".");
		//    text = text.replaceAll("(?:\\r?\\n(?=[A-Z]))", "..........");
		    text = text.replaceAll("(?:\\r?\\n){2}", ".");
			
			
		    System.out.println("I m here 2" +text); 
		 /////////////////////// Passing string for POS TAGGING ///////////////////////////////////////		     
			MaxentTagger tagger =  new MaxentTagger("stanford-tagger-4.2.0/stanford-postagger-full-2020-11-17/models/english-left3words-distsim.tagger.");

					 /////////////////////// Splitting string into sentences ///////////////////////////////////////	
				//     \\s{2,}
				   //  String[] tagged = tagger.tagString(text).split("\\.+|\\?+|\\:+|\\R|\\•+");
		    String[] tagged = tagger.tagString(text).split("\\.+|\\?+|\\:+|\\•+|\\+| (?:\\r?\\n){2} | \\n(?=[A-Z])");
				   for (int j=0; j< tagged.length; j++)
				   {
				            System.out.println(tagged[j]);  
				       }   
				   

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
				    		String pattern2 = "\\w+CD\\b";
					         Pattern r2 = Pattern.compile(pattern2);
					         Matcher m2 = r2.matcher(tagged[k]); 
					     
					         ///////////////////pattern 3////////////////////////////	  
							  String pattern3 = "\\w+NN\\b.\\w+NN\\b.\\w+VBZ\\b";
						     //    String pattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // NN CHAYE 2 HON YA 3 UN K AGY AGR VBZ HAI TW QUESTION
						         Pattern r3 = Pattern.compile(pattern3);
						         Matcher m3 = r3.matcher(tagged[k]); 
				            ///////////////////pattern 4////////////////////////////	    
							       String pattern4 ="\\w+NNP\\b?.\\w+NNS\\b.\\w+VBP\\b.";
							       Pattern r4 = Pattern.compile(pattern4);
							       Matcher m4 = r4.matcher(tagged[k]);   
							       
					///////////////////pattern 5////////////////////////////	      
					        	   
							       String pattern5 = "\\w+NNP\\b.\\(";
							         Pattern r5 = Pattern.compile(pattern5);
							         Matcher m5 = r5.matcher(tagged[k]);     
							         
					///////////////////pattern 6////////////////////////////	
						               
						       String pattern6 = " \\b(\\w+NNS\\b|\\w+VBP\\b)(?:\\W+\\w+){0,0}?\\W+(\\w+NNS\\b|\\w+VBP\\b)\\b" ;// two consecutive NNS AND VBP
							    Pattern r6 = Pattern.compile(pattern6);
								Matcher m6 = r6.matcher(tagged[k]);   	
				///////////////////pattern 7////////////////////////////			
						        String pattern7 = "\\w+DT\\b.\\w+JJ\\b.\\w+VBZ\\b";
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
						         String pattern10 = "\\w+VBN\\b.\\w+NN\\b.\\w+IN\\b.\\w+DT\\b";
						         Pattern r10 = Pattern.compile(pattern10);
						         Matcher m10 = r10.matcher(tagged[k]);   
						         
					///////////////////pattern 11////////////////////////////	
						         String pattern11 = "\\w+NN|NNS|NNP\\b.\\–";
						         Pattern r11 = Pattern.compile(pattern11);
						         Matcher m11 = r11.matcher(tagged[k]);   
							         
				//////////// first ka matcher			         
				          Matcher m = r.matcher(tagged[k]);   
if (m.find( )) {
				        mainElement =xmlDoc.createElement("QUESTION"+k);
				        System.out.println("Found pattern1, noun awr verb k sath wala");
				        String p=m.group(0).replaceAll("\\w+VBZ\\b", "");    
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
				          s = m.replaceAll("................");
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
		} //1st pattern if
			
			///// pattern 2 now

		else if (m2.find( )) {
		        	   mainElement =xmlDoc.createElement("QUESTION"+k);
		        	   	System.out.println(" CD ");
		        String p=m2.group(0);          
		       System.out.println("****************Question*****************\n");
		         String s2= m2.replaceFirst("............");
		        System.out.println(s2.replaceAll("_\\S+", "")+"?\n");
		        mainElement =xmlDoc.createElement("QUESTION"+k);
		        que= xmlDoc.createTextNode(s2.replaceAll("_\\S+", "")+"?\n");
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
		  
else  if (m3.find( )) {
		    	System.out.println("Found pattern3, noun awr verb k sath wala");
		        mainElement =xmlDoc.createElement("QUESTION"+k);
		        
		        String subpattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // sirf NN extract krne k liye ye if lagaya a 
			    Pattern subr3 = Pattern.compile(subpattern3);
			    Matcher subm3 = subr3.matcher(tagged[k]);   
			      if (subm3.find( )) {
		        
		        String p=m3.group(0).replaceAll("\\w+VBZ\\b", "");  
		        
		        System.out.println("ye hai"+p);
		        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
		        System.out.println("****************Question*****************\n");
		      
		    	  String s3= subm3.replaceFirst("................");
		    	 
		         mainElement =xmlDoc.createElement("QUESTION"+k);
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
		      
else if (m4.find( )) {
		         mainElement =xmlDoc.createElement("QUESTION"+k);
		         System.out.println("p4 NN VBZ");
		         String subpattern4 = "\\w+NN\\b.?(?=\\w+VBP\\b)";// sirf NN extract krne k liye ye if lagaya a 
				    Pattern subr4 = Pattern.compile(subpattern4);
				         Matcher subm4 = subr4.matcher(tagged[k]);   
				      if (subm4.find( )) {
		        
		         String p=subm4.group(0);
		         System.out.println(""+p);
		         System.out.println("\n****************Question*****************\n");
		         String s= subm4.replaceFirst(".............");
		         System.out.println(s.replaceAll("_\\S+", "")+"\n");
		         
		         mainElement =xmlDoc.createElement("QUESTION"+k);
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
		  
		    
else if (m5.find( )) {  /////////// abbreviation wala pattern  /////////
		          mainElement =xmlDoc.createElement("QUESTION"+k);
		         
		        // System.out.println(m5.group(0).replaceAll("_\\S+.*", ""));
		         String isuppercase= m5.group(0).replaceAll("_\\S+.*", "");
		         
		     if(isStringUpperCase(isuppercase)==true)
		         {
		         System.out.println("Found value: p5 abbreviation wala");
		         String p=m5.group(0); 
		         String s= m5.group(0).replaceAll("\\(", "?");
		         System.out.println("\n****************Question*****************\n");
		         mainElement =xmlDoc.createElement("QUESTION"+k);
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
else  if (m6.find( )) {
		    	  System.out.println("Found pattern6, ...........................................");
		        mainElement =xmlDoc.createElement("QUESTION"+k);
		        
		        String subpattern6 = "\\w+NNS\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
			    Pattern subr6 = Pattern.compile(subpattern6);
			         Matcher subm6 = subr6.matcher(tagged[k]);   
			      if (subm6.find( )) {
		        
		        String p=subm6.group(0);  
		        
		        System.out.println("ye hai"+p);
		        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
		        System.out.println("****************Question*****************\n");
		      
		    	  String s3= subm6.replaceFirst("................");
		    	 
		         mainElement =xmlDoc.createElement("QUESTION"+k);
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
		      
else if (m7.find( )) {
	    	  System.out.println("Found pattern7, noun awr verb k sath wala");
	        mainElement =xmlDoc.createElement("QUESTION"+k);
	        
	        String subpattern7 = "\\w+JJ\\b.*?(?=\\w+VBZ\\b|\\w+VBP\\b)";// sirf NN extract krne k liye ye if lagaya a 
		    Pattern subr7 = Pattern.compile(subpattern7);
		         Matcher subm7 = subr7.matcher(tagged[k]);   
		      if (subm7.find( )) {
	        
	        String p=subm7.group(0);  
	        
	        System.out.println("ye hai"+p);
	        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
	        System.out.println("****************Question*****************\n");
	      
	    	  String s3= subm7.replaceFirst("................");
	    	 
	         mainElement =xmlDoc.createElement("QUESTION"+k);
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
else if (m8.find( )) {
   	  System.out.println("Found pattern8, NNS CC NNS");
       mainElement =xmlDoc.createElement("QUESTION"+k);
       
       String subpattern8 = "\\w+NNS\\b.?(?=\\w+CC\\b)";// sirf NN extract krne k liye ye if lagaya a 
	    Pattern subr8 = Pattern.compile(subpattern8);
	         Matcher subm8 = subr8.matcher(tagged[k]);   
	      if (subm8.find( )) {
       
       String p=subm8.group(0);  
       
       System.out.println("ye hai"+p);
       System.out.println("ye hai"+tagged[k].replaceAll("", ""));
       System.out.println("****************Question*****************\n");
     
   	  String s3= subm8.replaceFirst("................");
   	 
        mainElement =xmlDoc.createElement("QUESTION"+k);
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
 else if (m9.find( )) {
	  System.out.println("Found pattern9, noun awr verb k sath wala");
   mainElement =xmlDoc.createElement("QUESTION"+k);
   
   String subpattern9 = "\\w+NNS\\b.?(?=\\w+MD\\b)";// sirf NN extract krne k liye ye if lagaya a 
   Pattern subr9 = Pattern.compile(subpattern9);
        Matcher subm9 = subr9.matcher(tagged[k]);   
     if (subm9.find( )) {
   
   String p=subm9.group(0);  
   
   System.out.println("ye hai"+p);
   System.out.println("ye hai"+tagged[k].replaceAll("", ""));
   System.out.println("****************Question*****************\n");
 
	  String s3= subm9.replaceFirst("................");
	 
    mainElement =xmlDoc.createElement("QUESTION"+k);
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
 else if (m10.find( )) {
System.out.println("Found pattern10, noun awr verb k sath wala");
mainElement =xmlDoc.createElement("QUESTION"+k);

String subpattern10 = "\\w+VBN\\b.\\w+NN\\b*?(?=\\w+IN\\b)";// sirf NN extract krne k liye ye if lagaya a 
Pattern subr10 = Pattern.compile(subpattern10);
    Matcher subm10 = subr10.matcher(tagged[k]);   
 if (subm10.find( )) {

String p=subm10.group(0);  

System.out.println("ye hai"+p);
System.out.println("ye hai"+tagged[k].replaceAll("", ""));
System.out.println("****************Question*****************\n");

String s3= subm10.replaceFirst("................");

mainElement =xmlDoc.createElement("QUESTION"+k);
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

 else if (m11.find( )) {
System.out.println("Found pattern11, hyphen wala");
mainElement =xmlDoc.createElement("QUESTION"+k);

String subpattern11 = ".*?(?=\\–)";// sirf NN extract krne k liye ye if lagaya a 
Pattern subr11 = Pattern.compile(subpattern11);
    Matcher subm11 = subr11.matcher(tagged[k]);   
 if (subm11.find( )) {

String p=subm11.group(0);  

System.out.println("ye hai"+p);
System.out.println("ye hai"+tagged[k].replaceAll("", ""));
System.out.println("****************Question*****************\n");

String s3= subm11.replaceFirst("................refers to");

mainElement =xmlDoc.createElement("QUESTION"+k);
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
                       rootElement.appendChild(mainElement); 
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
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			      
			//   }
				      }
			     catch (ParserConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			     catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} */
		
	

	public String questionbank(File filee) throws FileNotFoundException, JWNLException
	{
		POS pos;
		String display_que_ans="";
		int count=0;
		String posvalue;
		String Op2 = null;
		String Letter[]= {"Action Language For Foundational UML","AtlanMod Transformation Language","Business Process Modeling Notation",
				"Conceptual Modeling","Conceptual Model","Conceptual Schema","Conformance","Content model", "Diagram","Domain Specific Language",
				"Domain Specific Modeling Language", "Eclipse Modeling Framework", "Extended Entity Relationship language",
				"Entity Relationship", "Entity Type", "Entity", "Executable UML", "Extended Entity Relationship","Entity Relationship language",
				"Foundational UML", "fUML", "Graph Transformation", "In-place Transformation", "Kernel Meta Meta Model", "KM3",
				"Model", "MDA", "MDD", "MDE","Model-Driven Architecture", "Model-Driven Development", "Model-Driven Engineering", "Metamodel",
				"Model migration", "Modeling Language", "Navigation model", "Object Constraint Language", "OCL", "OMG", "Object Management Group",
				"MOF", "Presentation model", "QVT", "QVT Relations", "QVT Operational Language", "QVT Core", "refactoring", "Software Language",
				"Transformation", "UML", "Unified Modeling Language", "UML specification", "Universal Modeling Language", "Executable UML",
				"xUML"};

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

//PDDocument document = PDDocument.load(new File("D:/second semester/SDA/lectures/LEC-3.pdf"));
	//	PDDocument document = PDDocument.load(new File("D:/3rd Semester/MDSE/lectures/lec01.pdf"));// MDSE
	//	PDDocument document = PDDocument.load(new File("D:/second semester/SDA/lectures/LEC-1.pdf")); // SDA
	//	PDDocument document = PDDocument.load(new File("D:/IST SEMESTER/SRE/lec3.pdf")); // SRE
		
		PDDocument document = PDDocument.load(filee);
		// ‪D:\IST SEMESTER\SRE\lec1.pdf
		//Get the text from doc using PDFTextStripper
		
        String text = new PDFTextStripper().getText(document);
       //  String text = wind.text;
		//String text = " We are workin    g on this     text now";
		
		System.out.println("Text in PDF  main wala\n---------------------------------");
    //  System.out.println(wind.textt);
		
	//	}catch (IOException e) {
    //        e.printStackTrace();
    //    }

	  // Now this text will be used by the algorithm to generate questions
		
		

	//RULE The_DT most_RBS important_JJ characteristic_NN of_IN transformation_NN definition_NN is_VBZ that_IN	
		
			//	text = text.replaceAll("[^a-zA-Z0-9]", " ");  
				text = text.replaceAll("[-:+^0-9]*", "");
			//	text = text.replaceAll("[-:+^]*", "");
				System.out.println("I m here 1" +text); 
				//-
		//	text = text.replaceAll("(\\r|\\n)*.*(\\r|\\n)", ".");
	//	text = text.replaceAll("\\r?\\n(?=[A-Z])", "."); 
		//	text = text.replaceAll("\\n/>(?=[A-Z])", ".");
		//	text = text.replaceAll("\\$+", "........");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\+", "?");
			text = text.replaceAll("\\ ◼+", "?");
			text = text.replaceAll("\\•+", "?");
		    text = text.replaceAll("(?:\\r?\\s{4,}(?=[A-Z]))", "?");
		  //  text = text.replaceAll("(?:\\r?\\n(?=[A-Z]))", ".");// new line mn capital letter se break
	     //  text = text.replaceAll("(/\n[\n]+/g)", ".");
		//   text = text.replaceAll("(?:\\r?\\n\\n)", "."); // new line  se break or split
		    text = text.replaceAll("(?:\\r?\\n{2,})", "?"); 
		   // text = text.replaceAll("\\.(?=[A-Z])", "?");
		   text = text.replaceAll("\\.[A-Z]?", "?");
		 //  text = text.replaceAll("\\s{4}", "?");
			
		//  r'\s{2,}'
		// by_IN an_DT OpaqueExpression_NNP 	
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
				          String q1=s.replaceAll("_\\S+", "")+"?\n";
				          
				          
				          
				         System.out.println(s.replaceAll("_\\S+", "")+"?\n");
				         que= xmlDoc.createTextNode(s.replaceAll("_\\S+", "")+"?");
				         question.appendChild(que);
				         String a1=p.replaceAll("_\\S+", "");
				         
				     
				         
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
			   ///////// Display in GUI       
			           display_que_ans=display_que_ans.concat("\n*****************************************\n");
			           display_que_ans=display_que_ans.concat("Q#"+count+q1);
				       display_que_ans=display_que_ans.concat("\n");
				       display_que_ans=display_que_ans.concat(a1);
				       display_que_ans=display_que_ans.concat("\n*****************************************\n");
				       display_que_ans=display_que_ans.concat("\n");
				       display_que_ans=display_que_ans.concat("\n");
			           
		} 
	      
}//1st pattern if
			
			///// pattern 2 now
/*
		else if (m2.find( )) {
		        	 //  mainElement =xmlDoc.createElement("QUESTION"+count++);
		        	   	System.out.println(" CD ");
		        String p=m2.group(0);          
		       System.out.println("****************Question*****************\n");
		         String s2= m2.replaceFirst("............");
		        System.out.println(s2.replaceAll("_\\S+", "")+"?\n");
		        mainElement =xmlDoc.createElement("QUESTION"+count++);
		        que= xmlDoc.createTextNode(s2.replaceAll("_\\S+", "")+"?\n");
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
		           
		           
		           */
		  
else if(m3.find( )) {
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
		    	  String q3=s3.replaceAll("_\\S+", "")+"?\n";
		    	  String a3=p.replaceAll("_\\S+", "");
		    	  
		    	  
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
		     /////// display answer in GUI	     		        
				   ///////// Display in GUI       
		           display_que_ans=display_que_ans.concat("\n*****************************************\n");
		           display_que_ans=display_que_ans.concat("Q#"+count+q3);
			       display_que_ans=display_que_ans.concat("\n");
			       display_que_ans=display_que_ans.concat(a3);
			       display_que_ans=display_que_ans.concat("\n*****************************************\n");
			       display_que_ans=display_que_ans.concat("\n");
			       display_que_ans=display_que_ans.concat("\n");

		      }  
		      }
		    
  else if (m5.find( )) {  /////////// abbreviation wala pattern  /////////
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
	                	System.out.println("ye hai"+tagged[k].replaceAll("", ""));
	                	mainElement =xmlDoc.createElement("QUESTION"+k);
	                //	System.out.println("p5 ka dosra pattern  matched"); 
				    
				         System.out.println("1.");
				         System.out.println("2."+m0.group().replaceAll("_\\S+", ""));
				         opt2= xmlDoc.createTextNode(m0.group().replaceAll("_\\S+", ""));
			    		 Option2.appendChild(opt2);
				         System.out.println("3.");
				         System.out.println("4.None of the Above");
				         System.out.println("\n*****************************************\n");
				      
				          String q5=s.replaceAll("_\\S+", "")+"?\n";
				        
				         String a5=p.replaceAll("_\\S+", "");
				         
				         ///////// Display in GUI       
				           display_que_ans=display_que_ans.concat("\n*****************************************\n");
				           display_que_ans=display_que_ans.concat("Q#"+count+q5);
					       display_que_ans=display_que_ans.concat("\n");
					       display_que_ans=display_que_ans.concat(a5);
					       display_que_ans=display_que_ans.concat("\n*****************************************\n");
					       display_que_ans=display_que_ans.concat("\n");
					       display_que_ans=display_que_ans.concat("\n");
			//////display in xml	         
                          mainElement.appendChild(question); 
					       question.appendChild(Option1);
				           question.appendChild(Option2);
				           question.appendChild(Option3);
				           question.appendChild(Option4); 
				           rootElement.appendChild(mainElement); 
				           
				           
				           
				          
                    }
		         }
		         
	                 }
  else if (m6.find( )) {
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
		         
		         
		          String q6=s3.replaceAll("_\\S+", "")+"?\n";
		        
		         String a6=p.replaceAll("_\\S+", "");
		         
		         ///////// Display in GUI       
		           display_que_ans=display_que_ans.concat("\n*****************************************\n");
		           display_que_ans=display_que_ans.concat("Q#"+count+q6);
			       display_que_ans=display_que_ans.concat("\n");
			       display_que_ans=display_que_ans.concat(a6);
			       display_que_ans=display_que_ans.concat("\n*****************************************\n");
			       display_que_ans=display_que_ans.concat("\n");
			       display_que_ans=display_que_ans.concat("\n");
			       
		         mainElement.appendChild(question); 
			       question.appendChild(Option1);
		           question.appendChild(Option2);
		           question.appendChild(Option3);
		           question.appendChild(Option4);  
		           rootElement.appendChild(mainElement); 
		           
		        
		      }  
		      }
		      
  else if (m7.find( )) {
	    	  System.out.println("Found pattern7");
	          String subpattern7 = "\\w+NNP\\b.*?(?=\\w+VBZ\\b|\\w+VBP\\b)";// sirf NN extract krne k liye ye if lagaya a 
		      Pattern subr7 = Pattern.compile(subpattern7);
		      Matcher subm7 = subr7.matcher(tagged[k]);   
		      if (subm7.find( ) && countWords(tagged[k])>7){
	          String p=subm7.group(0);  
	        
	          System.out.println(" "+p);
	          System.out.println(" "+tagged[k].replaceAll("", ""));
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
	         
	         
	         
	          String q7=s3.replaceAll("_\\S+", "")+"?\n";
	        
	         String a7=p.replaceAll("_\\S+", "");
	         ///////// Display in GUI       
	           display_que_ans=display_que_ans.concat("\n*****************************************\n");
	           display_que_ans=display_que_ans.concat("Q#"+count+q7);
		       display_que_ans=display_que_ans.concat("\n");
		       display_que_ans=display_que_ans.concat(a7);
		       display_que_ans=display_que_ans.concat("\n*****************************************\n");
		       display_que_ans=display_que_ans.concat("\n");
		       display_que_ans=display_que_ans.concat("\n");
	         
	         mainElement.appendChild(question); 
		       question.appendChild(Option1);
	           question.appendChild(Option2);
	           question.appendChild(Option3);
	           question.appendChild(Option4);  
	           rootElement.appendChild(mainElement); 
	           
	           
	      }  
	      }

  else if (m4.find( )) {
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
      
      
      
      String q4=s.replaceAll("_\\S+", "")+"?\n";
    
     String a4=p.replaceAll("_\\S+", "");
 
     ///////// Display in GUI       
     display_que_ans=display_que_ans.concat("\n*****************************************\n");
     display_que_ans=display_que_ans.concat("Q#"+count+q4);
     display_que_ans=display_que_ans.concat("\n");
     display_que_ans=display_que_ans.concat(a4);
     display_que_ans=display_que_ans.concat("\n*****************************************\n");
     display_que_ans=display_que_ans.concat("\n");
     display_que_ans=display_que_ans.concat("\n");
    
      
      mainElement.appendChild(question); 
	       question.appendChild(Option1);
        question.appendChild(Option2);
        question.appendChild(Option3);
        question.appendChild(Option4); 
        rootElement.appendChild(mainElement); 
        
        
        }			                    
        }


  else if (m8.find( )) {
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
        
        
        String q8=s3.replaceAll("_\\S+", "")+"?\n";
      
       String a8=p.replaceAll("_\\S+", "");
       
       ///////// Display in GUI       
       display_que_ans=display_que_ans.concat("\n*****************************************\n");
       display_que_ans=display_que_ans.concat("Q#"+count+q8);
       display_que_ans=display_que_ans.concat("\n");
       display_que_ans=display_que_ans.concat(a8);
       display_que_ans=display_que_ans.concat("\n*****************************************\n");
       display_que_ans=display_que_ans.concat("\n");
       display_que_ans=display_que_ans.concat("\n");
       
        mainElement.appendChild(question); 
	       question.appendChild(Option1);
          question.appendChild(Option2);
          question.appendChild(Option3);
          question.appendChild(Option4);  
          rootElement.appendChild(mainElement); 
          
         
     }  
     }
  else if (m9.find( )) {
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
    
    
    String q9=s3.replaceAll("_\\S+", "")+"?\n";
  
   String a9=p.replaceAll("_\\S+", "");
   ///////// Display in GUI       
   display_que_ans=display_que_ans.concat("\n*****************************************\n");
   display_que_ans=display_que_ans.concat("Q#"+count+q9);
   display_que_ans=display_que_ans.concat("\n");
   display_que_ans=display_que_ans.concat(a9);
   display_que_ans=display_que_ans.concat("\n*****************************************\n");
   display_que_ans=display_que_ans.concat("\n");
   display_que_ans=display_que_ans.concat("\n");
   
    mainElement.appendChild(question); 
      question.appendChild(Option1);
      question.appendChild(Option2);
      question.appendChild(Option3);
      question.appendChild(Option4);  
      rootElement.appendChild(mainElement); 
      
     
 }  
 }
  else if (m10.find( )) {
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


String q10=s3.replaceAll("_\\S+", "")+"?\n";

String a10=p.replaceAll("_\\S+", "");
///////// Display in GUI       
display_que_ans=display_que_ans.concat("\n*****************************************\n");
display_que_ans=display_que_ans.concat("Q#"+count+q10);
display_que_ans=display_que_ans.concat("\n");
display_que_ans=display_que_ans.concat(a10);
display_que_ans=display_que_ans.concat("\n*****************************************\n");
display_que_ans=display_que_ans.concat("\n");
display_que_ans=display_que_ans.concat("\n");


mainElement.appendChild(question); 
  question.appendChild(Option1);
 question.appendChild(Option2);
 question.appendChild(Option3);
 question.appendChild(Option4);  
 rootElement.appendChild(mainElement); 
 

}  
}

if (m11.find( )) {
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


String q11=s3.replaceAll("_\\S+", "")+"?\n";

String a11=p.replaceAll("_\\S+", "");


///////// Display in GUI       
display_que_ans=display_que_ans.concat("\n*****************************************\n");
display_que_ans=display_que_ans.concat("Q#"+count+q11);
display_que_ans=display_que_ans.concat("\n");
display_que_ans=display_que_ans.concat(a11);
display_que_ans=display_que_ans.concat("\n*****************************************\n");
display_que_ans=display_que_ans.concat("\n");
display_que_ans=display_que_ans.concat("\n");

mainElement.appendChild(question); 
  question.appendChild(Option1);
 question.appendChild(Option2);
 question.appendChild(Option3);
 question.appendChild(Option4);  
 rootElement.appendChild(mainElement); 
 }  
}
/*
 else if (m4.find( )) {
     //  mainElement =xmlDoc.createElement("QUESTION"+count++);
       System.out.println("p4 NN VBZ");
       String subpattern4 = "\\w+NN\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
		    Pattern subr4 = Pattern.compile(subpattern4);
		         Matcher subm4 = subr4.matcher(tagged[k]);   
		      if (subm4.find( )) {
      
       String p=subm4.group(0);
       System.out.println(""+p);
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

*/
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
		return display_que_ans;
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


		
		
		
		
		
		
		/*
		// TODO Auto-generated method stub
		POS pos;
		String posvalue;
	//	String keyoption;
		String Op2 = null;
		String Letter[]= {"Action Language For Foundational UML","AtlanMod Transformation Language","Business Process Modeling Notation",
				"Conceptual Modeling","Conceptual Model","Conceptual Schema","Conformance","Content model", "Diagram","Domain Specific Language",
				"Domain Specific Modeling Language", "Eclipse Modeling Framework", "Extended Entity Relationship language",
				"Entity Relationship", "Entity Type", "Entity", "Executable UML", "Extended Entity Relationship","Entity Relationship language",
				"Foundational UML", "fUML", "Graph Transformation", "In-place Transformation", "Kernel Meta Meta Model", "KM3",
				"Model", "MDA", "MDD", "MDE","Model-Driven Architecture", "Model-Driven Development", "Model-Driven Engineering", "Metamodel",
				"Model migration", "Modeling Language", "Navigation model", "Object Constraint Language", "OCL", "OMG", "Object Management Group",
				"MOF", "Presentation model", "QVT", "QVT Relations", "QVT Operational Language", "QVT Core", "refactoring", "Software Language",
				"Transformation", "UML", "Unified Modeling Language", "UML specification", "Universal Modeling Language", "Executable UML",
				"xUML"};
		// Distractors Generations
		//1. synonym generation
		//1. Antynoym generation
		//1. random nouns picking generation (String mn se aas paas noun random utha lo), like take a string array
		// and insert all the nouns and for distractors choose a random noun and fit it.
		//otherwise think other methods as well lolz and yes for capital words you can store all the capital words in an array and use them for distractors.
		//wordnet shyd abbreviation b dhoond leta a
		// har dfa optionkey value ka sequence change krne k liye sare options ko aik array mn dal k ap random function b laga skty
		//.. The commonly used dictionaries are HowNet, WordNet and Thesaurus.
		//word sense disambiguation parhooooooo
		//dictionary macmillen dictionary
		//Coronaviruses belong to a group of RNA viruses that cause diseases in mammals and birds
		//Answer: RNA viruses
		//POS similarity. Ensuring the POS tags are same. Distractors and correct answer are all noun or verb.
		//zhang chinese ka ppr parho for distractor
		// distractor k liye prefix and suffix change kr lo for abbreviation wale words
		//  They picked the keywords using topic-word and named-entity and applied a gazetteer list-based approach to select distractors
		
		
		//////RULES
		////and k ird gird jo nouns aty hyn un mn se phle k bare mn poch skty
		/// brackets k ander jo noun ka synonym use hta us ko ye poch skty k either ye same concept hyn k nhi?
		// shuru mn NN ho dosra word VBZ beshaq na ho, jo marzi ho wo b question ban skta a
		
		// IN k agy peche agr NN ata hai, ya JJ ya NNS maybe with VBZ , do consider it as question.
		// can be and by k agy peche b question ban skta a
		// IN NN IN
		// jis mn that ata hai wo b dakh lo IDL interfaces define the methods that a server 
		//object supports, along with the parameter and return types.
		
		
		
		///////////////////////// to pick random words from a string/////////////////////////
	      // String threeLetterWords = "cat nat cat bat cat sat cat fat cat cat ";
	       String threeLetterWords = "cat nat cat cat cat ";
           String [] arr = threeLetterWords.split(" ");
           Random randomWord = new Random();
           String teeto=arr[randomWord.nextInt(arr.length)];
           //System.out.print(teeto);
          
          // System.out.print("Printing a random substring: " + arr[randomWord.nextInt(arr.length)]);

           //////////////////////////Installing dictionary for synonyms////////////////////////
		net.didion.jwnl.dictionary.Dictionary dict;
	    File file = new File("jwnl14-rc2/jwnl14-rc2/config/file_properties.xml");
	    JWNL.initialize(new FileInputStream(file));
	    dict = net.didion.jwnl.dictionary.Dictionary.getInstance();
	    
	    
	 //   Synset synonym=getCommonSynset1(" word", POS.NOUN);
			   String lemma=getLemma1( "human", POS.NOUN);
			   String syno []=getSynonyms( "Programming language", POS.NOUN);
					   //getCompoundLemma(" modelling language", POS.NOUN);
			   //getLemma1( "human", POS.NOUN);
			   for(int t=0; t<syno.length; t++)
			   {
	   System.out.println(" "+syno [t]);
			   }
	    java.lang.String key = null;
		   IndexWord indexWord = dict.getIndexWord(POS.NOUN , "Programming Language");
		   Synset[] senses = indexWord.getSenses();
	   for(int i=0;i<senses.length;i++){
		    
		        Synset set= senses[i]; 
		            Word[] words=set.getWords();
		     for(int k=0;k<words.length;k++){
		            System.out.println(words[k].getLemma());
		            break;
		        } 

	   }
						
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
		
		
		String sentencet = "UML remains a unifying language for software modeling.\n" +
				"             In MDA, the core activity is the conceptualization phase, which is the way analysis is conducted: first, requirements are codified as a PIM (or even CIM), and then the actual design of the application must be performed.\n" +
				"              The PSM is transformed into the running code, possibly requiring additional programming.\n" +
				"             UML (Unified Modeling Language), which is often perceived as a suite of languages, as it actually allows designers to specify their applications through a set of several different diagram types.\n" +
				"             The PSM is transformed into the running code, possibly requiring additional programming.\n" +
				"             The CIM is often referred to as a business model or domain model because it uses a vocabulary that is familiar to the subject matter experts (SMEs).\n" +
				"              The main goal of MDRE is to offer a better support for the comprehension of existing systems thanks to the use of model-based representations of those systems.\n" +
				"             Business modelling is concerned with what the business does.\n" +
				"             This is essentially an external view of the solution and shows how the users interact with the application, its look and feel, and the business abstractions (objects) that are represented by the application. \n" +
				"             Application modelling is where functional requirements are addressed.\n" +
				"             A process is a well-defined collection of activities, each undertaken by possibly a different participant, which takes one or more inputs and produces one or more outputs."+
				  "This section aims at providing an overview on the Unified Modeling Language (UML).5 Besides being widely known and adopted, the UML example is interesting for discussing the features and aspects presented so far as general characteristics for modeling languages."
				             + " Indeed, UML is a full- fledged language suite, since it comprises a set of different diagrams for describing a system from different perspectives. Figure 6.2 shows the taxonomy of UML diagrams: 7 different diagrams can be used for describing the static (structural) aspects of the system, while other 7 diagrams can be used for describing the dynamic aspects."
				             + " As shown in Figure 6.3, some of these diagrams describe characteristics of classes (i.e., abstract concepts), while others are used for describing features and behavior of individual items (i.e., instances). Some diagrams can be used for describing both levels. "
				             + "Notice that UML is just a modeling language, and does not enforce any particular development method."
				             + " UML is often mentioned together with the Unified Process (UP), best known in its specialization called Rational Unified Process (RUP), an iterative software development process framework created by Rational Software Corporation (now a division of IBM). "
				             + "While RUP and UML work very well together, the adoption of RUP is not necessary for using UML. ";
		
		
		//try {
		// Load the pdf file into PDDocument
		//File filee = new File("D:/second semester/SDA/lectures/LEC-1.pdf");
		//PDDocument document = Loader.loadPDF(filee);
//PDDocument document = PDDocument.load(new File("D:/second semester/SDA/lectures/LEC-3.pdf"));
	//	PDDocument document = PDDocument.load(new File("D:/3rd Semester/MDSE/lectures/LEC-1.pdf"));// MDSE
		PDDocument document = PDDocument.load(new File("D:/second semester/SDA/lectures/LEC-1.pdf")); // SDA
	//	PDDocument document = PDDocument.load(new File("D:/IST SEMESTER/SRE/lec1.pdf")); // SRE
		// ‪D:\IST SEMESTER\SRE\lec1.pdf
		//Get the text from doc using PDFTextStripper

		String text = new PDFTextStripper().getText(document);
		//String text = " We are workin    g on this     text now";
		
		System.out.println("Text in PDF\n---------------------------------");
   //     System.out.println(text);
		
	//	}catch (IOException e) {
    //        e.printStackTrace();
    //    }

	  // Now this text will be used by the algorithm to generate questions
		
		


       
	
		String sentence="Process View\r\n" + 
				" Addresses non-functional requirements such as \r\n" + 
				"performance, scalability, throughput, concurrency, \r\n" + 
				"and fault tolerance.\r\n" + 
				" Decomposes system processes into tasks.\r\n" + 
				" Implementation (Development) View Maps structural components from the Logical View to \r\n" + 
				"processes and threads that represent tasks.Architectural patterns define the structure of the solution \r\n" + 
				"at the highest level. These patterns influence the entire \r\n" + 
				"system and require all the parts of the system that are \r\n" + 
				"touched by the pattern to participate in its design. MVC \r\n" + 
				"is one of the example. \r\n" + 
				"Design patterns solve individual design problems within \r\n" + 
				"a particular context. In the pattern scope hierarchy, \r\n" + 
				"design patterns are the medium-scale patterns. \r\n" + 
				"•For example, MVC (Chapter 13) may introduce a tight \r\n" + 
				"coupling, creating problem if there are many views \r\n" + 
				"and controllers. The design pattern Command \r\n" + 
				"Processor, discussed in Chapter 20, addresses this \r\n" + 
				"problem.The PSM is transformed into the running code, possibly requiring additional programming.Within MDA the software \r\n" + 
				"A transformation is the automatic generation of a target model\r\n" + 
				"from a source model, according to a transformation definition.  A transformation definition is a set of transformation rules that \r\n" + 
				"together describe how a model in the source language can be \r\n" + 
				"transformed into a model in the target language.\r\n" + 
				" A transformation rule is a description of how one or more \r\n" + 
				"constructs in the source language can be transformed into \r\n" + 
				"one or more constructs in the target language.The OMG uses a four-layered architecture for its \r\n" + 
				"standards. In OMG terminology these layers are called \r\n" + 
				"M0, M1, M2, and M3 : -  Layer M3: The Model of M2\r\n" + 
				" Layer M2: The Model of the Model\r\n" + 
				" Layer M1: The Model of the System\r\n" + 
				" Layer M0: The Instances.Ecore is EMF’s (Eclipse Modeling Framework ) metametamodel.\r\n" + 
				" Ecore is approximately same as EMOF.\r\n" + 
				" It provides following specs of an application’s data: -  Attributes\r\n" + 
				" Relationships (Associations) between objects.\r\n" + 
				" Operations available on each object.\r\n" + 
				" Simple constraints (e.g.: cardinality) on objects and relationships.\r\n" + 
				"An invariant is a constraint that must be true for an object \r\n" + 
				"during its complete lifetime.The UML uses mostly graphical notations to express the OO analysis and design of software projects.Profile diagram is structure diagram which \r\n" + 
				"describes lightweight extension mechanism to the \r\n" + 
				"UML by defining custom stereotypes, tagged values, \r\n" + 
				"and constraints. \r\n" + 
				" Profiles allow adaptation of the UML metamodel for \r\n" + 
				"different: -  platforms (such as J2EE or .NET), or\r\n" + 
				" domains (such as real-time or business process modeling).\r\n" + 
				" Profile only allows adaptation or customization of an \r\n" + 
				"existing UML metamodel. Do not modify existing \r\n" + 
				"concepts.The Device Concept has been adapted to Server concept by \r\n" + 
				"providing three tagged values.Package diagram is UML structure diagram which shows structure of the designed system at the level of packages. \r\n" + 
				"• The following elements are typically drawn in a \r\n" + 
				"package diagram:\r\n" + 
				"– package, packageable element, \r\n" + 
				"dependency, element import, package \r\n" + 
				"import, package merge.        Model diagram is UML auxiliary structure diagram which \r\n" + 
				"shows some abstraction or specific view of a system, to \r\n" + 
				"describe some architectural, logical or behavioral aspects of \r\n" + 
				"the system. • The drawing (next slide) shows some major elements of the \r\n" + 
				"model diagram. \r\n" + 
				"• Package diagram is used to create model diagram.You can also show properties, which are referenced through association and \r\n" + 
				"therefore may be shared with other classes in the system\r\n" + 
				"• The notation for properties and parts is identical except for the dashed versus.\r\n" + 
				"solid rectangle outlines: you specify roles, types, and multiplicity the same way. \r\n" + 
				"• As with parts, properties can be connected to other properties or parts using connectors.Information flow diagram is UML behavior diagram which shows exchange of information \r\n" + 
				"between system entities at some high levels of \r\n" + 
				"abstraction. \r\n" + 
				"• Information flows may be useful to describe circulation of information through a system by \r\n" + 
				"representing aspects of models not yet fully specified or with less details. \r\n" + 
				"• Useful for architectural modeling. • Information flows do not specify the nature of the \r\n" + 
				"information, mechanisms by which it is conveyed, sequences of exchange, or any control conditions.Expansion regions allow \r\n" + 
				"operations on collections and \r\n" + 
				"operations on individual elements \r\n" + 
				"of the collections to be shown on \r\n" + 
				"the same diagram, without the \r\n" + 
				"need to show all of the detailed \r\n" + 
				"but straightforward iteration.A substate is a state \r\n" + 
				"that's nested inside \r\n" + 
				"another state called \r\n" + 
				"Composite State.\r\n" + 
				" The substates here are called disjoint substates, because the \r\n" + 
				"object is said to be in the composite state and in only one of those substates at a time.\r\n" + 
				" An elegant way to model cancel behavior, if user cancels from any of the substate, will go to Idle state.You can also show properties, which are referenced through association and \r\n" + 
				"therefore may be shared with other classes in the system.\r\n" + 
				"• The notation for properties and parts is identical except for the dashed versus.\r\n" + 
				"solid rectangle outlines: you specify roles, types, and multiplicity the same way. \r\n" + 
				"• As with parts, properties can be connected to other properties or parts using connectors.There are implicit and explicit\r\n" + 
				"fork and join in Fig 22-8 • Explicit Fork: on diagnosis\r\n" + 
				"event\r\n" + 
				"• Implicit Fork: on maintain event\r\n" + 
				"14\r\n" + 
				"• Explicit Join: on disconnect event (only works if Testing devices & \r\n" + 
				"Final [not continue] states are active)\r\n" + 
				"• Implicit Join: error event (will terminate the whole composite state, \r\n" + 
				"i.e., any active substates of both the orthogonal regions).\r\n" + 
				"• A final state is a real state and can be the target of a transition.Interaction overview diagrams provide overview of the flow of control where nodes of the flow \r\n" + 
				"are interactions or interaction uses. • Interaction overview diagrams do look like activity diagrams that can only have inline \r\n" + 
				"interactions or interaction uses instead of invocation actions.\r\n" + 
				"• UML interaction overview diagram combines elements from activity and interaction diagrams.Communication diagram (called collaboration diagram in UML 1.x) is an interaction diagram which shows interactions between \r\n" + 
				"objects and/or parts(represented as lifelines) using sequenced messages in a free-form \r\n" + 
				"arrangement. • Communication diagram corresponds (could be \r\n" + 
				"converted to/from or replaced by) tosimple sequence diagram.Façade Controller\r\n" + 
				"• Suitable when there are not too many system events.\r\n" + 
				"• This could be an abstraction of the overall physical unit, such as PhoneSwitch, CashRegister, etc.Bloated Controller\r\n" + 
				"• There is only one and it handles too many events.\r\n" + 
				"• The controller performs the work rather than delegating it.\r\n" + 
				"• Controller has many attributes and maintains significant system or domain info.Measure of the degree of “relatedness” that elements \r\n" + 
				"within a module share. \r\n" + 
				"• Degree to which the tasks performed by a single module \r\n" + 
				"are functionally related.\r\n" + 
				"• A class with low cohesion does many unrelated things or does too much work. \r\n" + 
				"• Such classes are undesirable; they suffer from the following problems: - – hard to comprehend\r\n" + 
				"– hard to reuse\r\n" + 
				"– hard to maintain\r\n" + 
				"– delicate; constantly affected by change.There are four different possible cardinalities:\r\n" + 
				" exactly one (the default, no operator)  zero or one (operator ?)  zero or more (operator *)  one or more (operator +)                                       There are three different assignment operators, each with different semantics.\r\n" + 
				" The simple equal sign = is the straightforward assignment, and is used \r\n" + 
				"for features which take only one element.\r\n" + 
				" The += sign (the add operator) expects a multi-valued feature and adds \r\n" + 
				"the value on the right hand side to that feature, which is a list feature.\r\n" + 
				" The ?= sign (boolean assignment operator) expects a feature of type \r\n" + 
				"EBoolean and sets it to true if the right hand side was consumed, \r\n" + 
				"independently from the concrete value of the right hand side.Inheritance can be defined as the process where one object acquires the properties of another. Inheritance makes the information manageable in a hierarchical order.\r\n" + 
				" Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.  Encapsulation is the technique of making the fields in a class private\r\n" + 
				"and providing access to the fields via public methods.  Abstraction is a process of hiding the implementation details from the user.\r\n" + 
				" Overriding means to override the functionality of an existing method. \r\n" + 
				"The benefit of overriding is: ability to define a behavior that's specific to the subclass type.Singleton pattern is categorized under creational design patterns.\r\n" + 
				" It is one of the simplest design pattern in terms of the modelling.\r\n" + 
				" Singleton pattern ensures that only one instance of a class is created.\r\n" + 
				" Example Use: Singletons can be used to create a Connection Pool. \r\n" + 
				" If programmers create a new connection object in every class that requires it, then its clear waste of resources. \r\n" + 
				" In this scenario by using a singleton connection class we can maintain a single connection object which can be used throughout the application.\r\n" + 
				" Example Use: Factory patterns are also often created as singleton.It could happen that the access method may be called twice from 2 different classes at the same time and hence more than one object \r\n" + 
				"being created. \r\n" + 
				" This could violate the design pattern principle. \r\n" + 
				" In order to prevent the simultaneous invocation of the getter method by 2 threads or classes simultaneously we add the synchronized keyword to the method declaration.Middleware is the plumbing or wiring of IT applications\r\n" + 
				" Middleware Provides applications with fundamental \r\n" + 
				"services for distributed computing\r\n" + 
				" Middleware provides ready-to-use infrastructure for \r\n" + 
				"connecting software components.\r\n" + 
				" Lots of middleware exist with: -  Different purposes\r\n" + 
				" Different vendors\r\n" + 
				" Different standards and proprietary technologies.The transport layer represents the basic pipes for sending requests and moving data between software components.\r\n" + 
				"• These pipes provide simple facilities and mechanisms that make exchanging data straightforward in distributed application architectures. Application servers are typically built on top of the basic \r\n" + 
				"transport services.\r\n" + 
				"• They provide additional capabilities such as transaction, security and directory services. \r\n" + 
				"• They also support a programming model for building \r\n" + 
				"multithreaded server-based applications that exploit these additional services.   Message brokers exploit either a basic transport service and/or application servers and add a specialized message processing engine. \r\n" + 
				"• This engine provides features for fast message \r\n" + 
				"transformation and high-level programming features.      Business process orchestrators (BPOs) augment \r\n" + 
				"message broker features to support workflow-style\r\n" + 
				"applications. \r\n" + 
				"• In such applications, business processes may take many \r\n" + 
				"hours or days to comp.An industry standard developed by OMG to help in \r\n" + 
				"distributed programming\r\n" + 
				" A specification for creating and using distributed \r\n" + 
				"objects\r\n" + 
				" A tool for enabling multi-language, multi-platform \r\n" + 
				"communication.\r\n" + 
				" A CORBA based-system is a collection of objects \r\n" + 
				"that isolates the requestors of services (clients) from \r\n" + 
				"the providers of services (servers) by an \r\n" + 
				"encapsulating interface.IDL is purely a declarative language\r\n" + 
				" IDL is able to completely define an object’s \r\n" + 
				"contract.\r\n" + 
				" IDL description is sufficient to develop a contract provider (server) and a contract requestor (client).";
		
		String sentencce= "Each process has critical section segment of code.\r\n" + 
				"Process may be changing common variables, updating table, writing file, etc.\r\n" + 
				"When one process in critical section, no other may be in its critical section.\r\n" + 
				"Critical section problem is to design protocol to solve this.\r\n" + 
				"Each process must ask permission to enter critical section in entry section, may follow critical section with exit section, then remainder section\r\n" + 
				"Many systems provide hardware support for implementing the critical section code.\r\n" + 
				"All solutions below based on idea of locking.\r\n" + 
				"Protecting critical regions via locks.\r\n" + 
				"Uniprocessors – could disable interrupts.\r\n" + 
				"Currently running code would execute without preemption.\r\n" + 
				"Generally too inefficient on multiprocessor systems.\r\n" + 
				"Operating systems using this not broadly scalable.\r\n" + 
				"Modern machines provide special atomic hardware instructions.Communication diagram (called collaboration diagram in UML 1.x) is an interaction diagram which shows interactions between \r\n" + 
				"objects and/or parts(represented as lifelines) using sequenced messages in a free-form \r\n" + 
				"arrangement. • Communication diagram corresponds (could be \r\n" + 
				"converted to/from or replaced by) tosimple sequence diagram.";
	//RULE The_DT most_RBS important_JJ characteristic_NN of_IN transformation_NN definition_NN is_VBZ that_IN	
		
			//	text = text.replaceAll("[^a-zA-Z0-9]", " ");  
				text = text.replaceAll("[-:+^0-9]*", "");
				System.out.println("I m here 1" +text); 
				//-
		//	text = text.replaceAll("(\\r|\\n)*.*(\\r|\\n)", ".");
	//	text = text.replaceAll("\\r?\\n(?=[A-Z])", ".");
		//	text = text.replaceAll("\\n/>(?=[A-Z])", ".");
		//	text = text.replaceAll("\\$+", "........");
			text = text.replaceAll("\\+", ".");
			text = text.replaceAll("\\+", ".");
		//	text = text.replaceAll("\\+", ".");
			text = text.replaceAll("\\•+", ".");
		    text = text.replaceAll("(?:\\r?\\n(?=[A-Z]))", ".");
		//    text = text.replaceAll("(?:\\r?\\n(?=[A-Z]))", "..........");
		    text = text.replaceAll("(?:\\r?\\n){2}", ".");
			
			
		    System.out.println("I m here 2" +text); 
		 /////////////////////// Passing string for POS TAGGING ///////////////////////////////////////		     
			MaxentTagger tagger =  new MaxentTagger("stanford-tagger-4.2.0/stanford-postagger-full-2020-11-17/models/english-left3words-distsim.tagger.");

					 /////////////////////// Splitting string into sentences ///////////////////////////////////////	
				//     \\s{2,}
				   //  String[] tagged = tagger.tagString(text).split("\\.+|\\?+|\\:+|\\R|\\•+");
		    String[] tagged = tagger.tagString(text).split("\\.+|\\?+|\\:+|\\•+|\\+| (?:\\r?\\n){2} | \\n(?=[A-Z])");
				   for (int j=0; j< tagged.length; j++)
				   {
				            System.out.println(tagged[j]);  
				       }   
				   

					 /////////////////////// Splitting string into words ///////////////////////////////////////		   
				   String [] wordbreak= tagger.tagString(sentence).split(" ");
		  
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
				   
				          Matcher m = r.matcher(tagged[k]);   
				           if (m.find( )) {
				        mainElement =xmlDoc.createElement("QUESTION"+k);
				        System.out.println("Found pattern1, noun awr verb k sath wala");
				        String p=m.group(0).replaceAll("\\w+VBZ\\b", "");    
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
				          s = m.replaceAll("................");
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
			else {
				               
				      
				         String pattern2 = "\\w+CD\\b";
				         Pattern r2 = Pattern.compile(pattern2);
				         Matcher m2 = r2.matcher(tagged[k]);   
				   if (m2.find( )) {
				        	   mainElement =xmlDoc.createElement("QUESTION"+k);
				        	   	System.out.println(" CD ");
				        String p=m2.group(0);          
				       System.out.println("****************Question*****************\n");
				         String s2= m2.replaceFirst("............");
				        System.out.println(s2.replaceAll("_\\S+", "")+"?\n");
				        mainElement =xmlDoc.createElement("QUESTION"+k);
				        que= xmlDoc.createTextNode(s2.replaceAll("_\\S+", "")+"?\n");
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
				  else
				               
				           {  
				       //  String pattern3 = "\\w+DT\\b?.\\w+NNP\\b.\\w+VBZ\\b";
					  
					  String pattern3 = "\\w+NN\\b.\\w+NN\\b.\\w+VBZ\\b";
				     //    String pattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // NN CHAYE 2 HON YA 3 UN K AGY AGR VBZ HAI TW QUESTION
				         Pattern r3 = Pattern.compile(pattern3);
				         Matcher m3 = r3.matcher(tagged[k]);   
				      if (m3.find( )) {
				    	System.out.println("Found pattern3, noun awr verb k sath wala");
				        mainElement =xmlDoc.createElement("QUESTION"+k);
				        
				        String subpattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // sirf NN extract krne k liye ye if lagaya a 
					    Pattern subr3 = Pattern.compile(subpattern3);
					    Matcher subm3 = subr3.matcher(tagged[k]);   
					      if (subm3.find( )) {
				        
				        String p=m3.group(0).replaceAll("\\w+VBZ\\b", "");  
				        
				        System.out.println("ye hai"+p);
				        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
				        System.out.println("****************Question*****************\n");
				      
				    	  String s3= subm3.replaceFirst("................");
				    	 
				         mainElement =xmlDoc.createElement("QUESTION"+k);
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
				       //  String pattern4 = "(\\w+NN|NNP|NNS\\b.*(?:\\W+\\W+){0,0}?\\w+VBZ\\b.*\\W+(?:\\w+\\W+){0,0}?\\w+VBN\\b..*\\W+(?:\\w+\\W+){0,0}?\\w+IN\\b.*\\W+(?:\\w+\\W+){0,0}?\\w+NN\\b)";
				      //  String pattern4 = "(\\w+NNP|NN\\b.(?:\\W+\\W+){0,0}?\\w+VBZ\\b.\\W+(?:\\w+\\W+){0,0}?\\w+JJ.*\\b)";
				       String pattern4 ="\\w+NNP\\b?.\\w+NNS\\b.\\w+VBP\\b.";
				        
				         Pattern r4 = Pattern.compile(pattern4);
				         Matcher m4 = r4.matcher(tagged[k]);   
				           if (m4.find( )) {
				       //  mainElement =xmlDoc.createElement("QUESTION"+k);
				         System.out.println("p4 NN VBZ");
				         String subpattern4 = "\\w+NN\\b.?(?=\\w+VBP\\b)";// sirf NN extract krne k liye ye if lagaya a 
						    Pattern subr4 = Pattern.compile(subpattern4);
						         Matcher subm4 = subr4.matcher(tagged[k]);   
						      if (subm4.find( )) {
				        
				         String p=subm4.group(0);
				         System.out.println(""+p);
				         System.out.println("\n****************Question*****************\n");
				         String s= subm4.replaceFirst(".............");
				         System.out.println(s.replaceAll("_\\S+", "")+"\n");
				         
				         mainElement =xmlDoc.createElement("QUESTION"+k);
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
				  else /////////// abbreviation wala pattern  /////////
				                {
				        	   
				       String pattern5 = "\\w+NNP\\b.\\(";
				         Pattern r5 = Pattern.compile(pattern5);
				         Matcher m5 = r5.matcher(tagged[k]);   
				           if (m5.find( )) {
				          mainElement =xmlDoc.createElement("QUESTION"+k);
				         
				        // System.out.println(m5.group(0).replaceAll("_\\S+.*", ""));
				         String isuppercase= m5.group(0).replaceAll("_\\S+.*", "");
				         
				     if(isStringUpperCase(isuppercase)==true)
				         {
				         System.out.println("Found value: p5 abbreviation wala");
				         String p=m5.group(0); 
				         String s= m5.group(0).replaceAll("\\(", "?");
				         System.out.println("\n****************Question*****************\n");
				         mainElement =xmlDoc.createElement("QUESTION"+k);
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
  else
				               
				           {  
				       //  String pattern3 = "\\w+DT\\b?.\\w+NNP\\b.\\w+VBZ\\b";
					  
					//  String pattern6 = "\\w+NNS\\b?|\\w+NN\\b?|\\w+NNP\\b?.\\w+VBP\\b|\\w+VBZ\\b";
	                //    String pattern6 = "\\w+NNS\\b.|\\w+NN.\\w+VBP\\b.|\\w+VBZ\\b.";
	                    
	                    String pattern6 = " \\b(\\w+NNS\\b|\\w+VBP\\b)(?:\\W+\\w+){0,0}?\\W+(\\w+NNS\\b|\\w+VBP\\b)\\b" ;// two consecutive NNS AND VBP
	                    
				    //     String pattern6 = "\\w+NNS\\b.\\w+VBP\\b"; // NN CHAYE 2 HON YA 3 UN K AGY AGR VBZ HAI TW QUESTION
				         Pattern r6 = Pattern.compile(pattern6);
				         Matcher m6 = r6.matcher(tagged[k]);   
				      if (m6.find( )) {
				    	  System.out.println("Found pattern6, ...........................................");
				        mainElement =xmlDoc.createElement("QUESTION"+k);
				        
				        String subpattern6 = "\\w+NNS\\b.(?=\\w+VBZ\\b|\\w+VBP\\b|\\w+VBN\\b)";// sirf NN extract krne k liye ye if lagaya a 
					    Pattern subr6 = Pattern.compile(subpattern6);
					         Matcher subm6 = subr6.matcher(tagged[k]);   
					      if (subm6.find( )) {
				        
				        String p=subm6.group(0);  
				        
				        System.out.println("ye hai"+p);
				        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
				        System.out.println("****************Question*****************\n");
				      
				    	  String s3= subm6.replaceFirst("................");
				    	 
				         mainElement =xmlDoc.createElement("QUESTION"+k);
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
			        String pattern7 = "\\w+DT\\b.\\w+JJ\\b.\\w+VBZ\\b";
			         Pattern r7 = Pattern.compile(pattern7);
			         Matcher m7 = r7.matcher(tagged[k]);   
			      if (m7.find( )) {
			    	  System.out.println("Found pattern7, noun awr verb k sath wala");
			        mainElement =xmlDoc.createElement("QUESTION"+k);
			        
			        String subpattern7 = "\\w+JJ\\b.*?(?=\\w+VBZ\\b|\\w+VBP\\b)";// sirf NN extract krne k liye ye if lagaya a 
				    Pattern subr7 = Pattern.compile(subpattern7);
				         Matcher subm7 = subr7.matcher(tagged[k]);   
				      if (subm7.find( )) {
			        
			        String p=subm7.group(0);  
			        
			        System.out.println("ye hai"+p);
			        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
			        System.out.println("****************Question*****************\n");
			      
			    	  String s3= subm7.replaceFirst("................");
			    	 
			         mainElement =xmlDoc.createElement("QUESTION"+k);
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
		          String pattern8 = "\\w+NNS\\b.\\w+CC\\b.\\w+NNS\\b";
		         Pattern r8 = Pattern.compile(pattern8);
		         Matcher m8 = r8.matcher(tagged[k]);   
		      if (m8.find( )) {
		    	  System.out.println("Found pattern8, NNS CC NNS");
		        mainElement =xmlDoc.createElement("QUESTION"+k);
		        
		        String subpattern8 = "\\w+NNS\\b.?(?=\\w+CC\\b)";// sirf NN extract krne k liye ye if lagaya a 
			    Pattern subr8 = Pattern.compile(subpattern8);
			         Matcher subm8 = subr8.matcher(tagged[k]);   
			      if (subm8.find( )) {
		        
		        String p=subm8.group(0);  
		        
		        System.out.println("ye hai"+p);
		        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
		        System.out.println("****************Question*****************\n");
		      
		    	  String s3= subm8.replaceFirst("................");
		    	 
		         mainElement =xmlDoc.createElement("QUESTION"+k);
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
	               
	           { // Factory_NNP patterns_NNS are_VBP
	       //  String pattern3 = "\\w+DT\\b?.\\w+NNP\\b.\\w+VBZ\\b";
		  
		//  String pattern9 = "\\w+NNS|\\w+NN\\b?\\w+MD\\b\\w+VB\\b\\w+VBN|VBZ\\b";
	  String pattern9 = "\\w+NNS\\b.\\w+MD\\b.\\w+VB\\b.\\w+VBN\\b|VBZ\\b";
	//	  String pattern9 = " \\b(\\w+NNS\\b.\\w+MD\\b.\\w+VB\\b.\\w+VBN\\b|VBZ\\b)(?:\\W+\\w+\\w+\\w+){0,0}?\\W+(\\w+NNS\\b.\\w+MD\\b.\\w+VB\\b.\\w+VBN\\b|VBZ\\b)\\b" ;
	     //    String pattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // NN CHAYE 2 HON YA 3 UN K AGY AGR VBZ HAI TW QUESTION
	         Pattern r9 = Pattern.compile(pattern9);
	         Matcher m9 = r9.matcher(tagged[k]);   
	      if (m9.find( )) {
	    	  System.out.println("Found pattern9, noun awr verb k sath wala");
	        mainElement =xmlDoc.createElement("QUESTION"+k);
	        
	        String subpattern9 = "\\w+NNS\\b.*?(?=\\w+MD\\b)";// sirf NN extract krne k liye ye if lagaya a 
		    Pattern subr9 = Pattern.compile(subpattern9);
		         Matcher subm9 = subr9.matcher(tagged[k]);   
		      if (subm9.find( )) {
	        
	        String p=subm9.group(0);  
	        
	        System.out.println("ye hai"+p);
	        System.out.println("ye hai"+tagged[k].replaceAll("", ""));
	        System.out.println("****************Question*****************\n");
	      
	    	  String s3= subm9.replaceFirst("................");
	    	 
	         mainElement =xmlDoc.createElement("QUESTION"+k);
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
              
          { // Factory_NNP patterns_NNS are_VBP
      //  String pattern3 = "\\w+DT\\b?.\\w+NNP\\b.\\w+VBZ\\b";
	  
	  String pattern10 = "\\w+VBN\\b.\\w+NN\\b.\\w+IN\\b.\\w+DT\\b";
    //    String pattern3 = "\\w+NN\\b.*?(?=\\w+VBZ\\b)"; // NN CHAYE 2 HON YA 3 UN K AGY AGR VBZ HAI TW QUESTION
        Pattern r10 = Pattern.compile(pattern10);
        Matcher m10 = r10.matcher(tagged[k]);   
     if (m10.find( )) {
   	  System.out.println("Found pattern10, noun awr verb k sath wala");
       mainElement =xmlDoc.createElement("QUESTION"+k);
       
       String subpattern10 = "\\w+VBN\\b.\\w+NN\\b*?(?=\\w+IN\\b)";// sirf NN extract krne k liye ye if lagaya a 
	    Pattern subr10 = Pattern.compile(subpattern10);
	         Matcher subm10 = subr10.matcher(tagged[k]);   
	      if (subm10.find( )) {
       
       String p=subm10.group(0);  
       
       System.out.println("ye hai"+p);
       System.out.println("ye hai"+tagged[k].replaceAll("", ""));
       System.out.println("****************Question*****************\n");
     
   	  String s3= subm10.replaceFirst("................");
   	 
        mainElement =xmlDoc.createElement("QUESTION"+k);
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
	      
		      
				           
			             }
				          

			           }
				          
						      // XML 
								//           mainElement.appendChild(Option1);
									      
									      
								 //          mainElement.appendChild(Option3);
								 //          mainElement.appendChild(Option4);
			
			 }
				                   
				     	     
			}
				         /*  mainElement.appendChild(question); 
				           question.appendChild(Option2);  
				           question.appendChild(Option2);     
							 	       
		}}}}}}
				      rootElement.appendChild(mainElement); 
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
					} catch (TransformerException e) {
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
	
////////////////// i will use it later for array conversion from list
	   public static String[] GetStringArray(ArrayList<String> arr)
	    {
	  
	        // declaration and initialise String Array
	        String str[] = new String[arr.size()];
	  
	        // ArrayList to Array Conversion
	        for (int j = 0; j < arr.size(); j++) {
	  
	            // Assign each value to String array
	            str[j] = arr.get(j);
	        }
	  
	        return str;
	    }
	
	///// not in used in future maybe
	public static String getLemma(String word, POS pos) {
		if (dict == null) return null;
		
		IndexWord indexWord = null;
		try {
			indexWord = dict.lookupIndexWord(pos, word);
		} catch (JWNLException e) {}
		if (indexWord == null) return null;
		
		String lemma = indexWord.getLemma();
		lemma = lemma.replace("_", " ");
		
		return lemma;
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
	}
	
///// not in used in future maybe
	private static String Synonym (String word, POS pos) throws JWNLException, NullPointerException, FileNotFoundException {
		 File file = new File("jwnl14-rc2/jwnl14-rc2/config/file_properties.xml");
		    JWNL.initialize(new FileInputStream(file));
		    dict = net.didion.jwnl.dictionary.Dictionary.getInstance();
		
		String temp = null;
		//String tempo;
		IndexWord indexWord=null;
		Synset[] senses=null;
		String key []= null; 
		//System.out.print(word);
		//System.out.print(pos);
		try {
		indexWord = dict.getIndexWord(pos, word);
	   // indexWord = dict.getIndexWord(pos, "bad");
	    if(	    indexWord!=null)
	    {
	    senses = indexWord.getSenses();

	 //   System.out.println(senses.length);
	   for(int i=0;i<senses.length;i++){
	    
	        Synset set= senses[i]; 
	            Word[] words=set.getWords();
	       for(int k=0;k<words.length;k++){
	    	   if(words[k]!=null)
	    	   key [k]= words[k].getLemma();
	        }

	    }
	    
	   Random randomWord = new Random();
        temp = key[randomWord.nextInt(key.length)];
       System.out.print("Printing a random substring: " + key[randomWord.nextInt(key.length)]);
 
    	   return temp;
    	   
       }
       else
       {
    	   //System.out.print("no synonym");
    	   return temp;
    	   // randomWord = new Random();
           //String tempo = nouns[randomWord.nextInt(nouns.length)];
       }
		}
		catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
	 
       
	return temp;
	}
	
	
	///// in use for checking POS of KEYOPTION
	 private static POS generatePOSvalue(String pos) {
	String lemma;
	POS Pos=null;
	//String pos;
	Object text;
//	if (pos.equals("NNP") || pos.equals("NNS") || pos.equals("NN")) {
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
//	} else if (pos.startsWith("VBZ") || pos.startsWith("VBN") || pos.startsWith("VBP") ||  pos.startsWith("VBG")) {
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
	///// not in used in future maybe 
		public static String getLemma1(String word, POS pos) {
			dict = net.didion.jwnl.dictionary.Dictionary.getInstance();
			if (dict == null) return null;
			
			IndexWord indexWord = null;
			try {
				indexWord = dict.lookupIndexWord(pos, word);
			} catch (JWNLException e) {}
			if (indexWord == null) return null;
			
			String lemma = indexWord.getLemma();
			lemma = lemma.replace("_", " ");
			
			return lemma;
		}
	///// using for getting synonyms of words
		public static String[] getSynonyms(String word, POS pos) {
			Synset synset = getCommonSynset(word, pos);
			if (synset == null) return null;
			
			return getLemm(synset);
		}
	
		///// not in used in future maybe	
		public static String getCompoundLemma(String word, POS pos) {
			// do not look up words with special characters other than '.'
			if (word.matches(".*?[^\\w\\s\\.].*+")) return null;
			
			String lemma = getLemma(word, pos);
			if (lemma == null) return null;
			
			// ensure that the word, and not just a substring, was found in WordNet
			int wordTokens = word.split("\\s", -1).length;
			int wordDots = word.split("\\.", -1).length;
			int lemmaTokens = lemma.split("\\s", -1).length;
			int lemmaDots = lemma.split("\\.", -1).length;
			if (wordTokens != lemmaTokens || wordDots != lemmaDots) return null;
			
			return lemma;
		}
	///// not in used in future maybe
		private static Synset getCommonSynset1(String word, POS pos) {
			dict = net.didion.jwnl.dictionary.Dictionary.getInstance();
			if (dict == null) return null;
			
			Synset synset = null;
			try {
				IndexWord indexWord = dict.lookupIndexWord(pos, word);
				if (indexWord == null) return null;
				synset = indexWord.getSense(1);
			} catch (JWNLException e) {}
			
			return synset;
		}
		
	
	/* private void generateLemma() {
		String lemma;
		String pos;
		Object text;
		if (pos.startsWith("VB")) {
			// lemmatize verbs that are in WordNet
			lemma = WordNet.getLemma(text, POS.VERB);
		} else if (pos.startsWith("JJ")) {
			// lemmatize adjectives that are in WordNet
			lemma = WordNet.getLemma(text, POS.ADJECTIVE);
		} else if (pos.startsWith("RB")) {
			// lemmatize adverbs that are in WordNet
			lemma = WordNet.getLemma(text, POS.ADVERB);
		} else {
			// lemmatize nouns that are in WordNet
			if (pos.startsWith("COMPOUND"))
				lemma = WordNet.getCompoundLemma(text, POS.NOUN);  // compound
			else
				lemma = WordNet.getLemma(text, POS.NOUN);  // single token
		}
		if (lemma == null) lemma = text;
		
		setLemma(lemma);
	}    */
	
//} */


				
			
				

