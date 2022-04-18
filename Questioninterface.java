package questionbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import net.didion.jwnl.JWNLException;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JMenu;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

public class Questioninterface {

	private static final String String = null;
	public JFrame frmQuestionGeneration;
	JButton btnNewButton;
	JLabel lblNewLabel;
	File file;
	String text =null;
	String textt=null;
	questiongen qg=new questiongen();
	JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	 
	 
	 
	/*public static void main(String[] args) {
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
	}   */

	/**
	 * Create the application.
	 */
	public Questioninterface() {
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
		frmQuestionGeneration.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("PDF file");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNewButton.setToolTipText("");
		
	//	btnNewButton.addActionListener(new questiongen() );
	

		
		btnNewButton.addActionListener(new ActionListener() {
			
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
		         } 
		      });
	
		 textt=text;
	/*	
		PDDocument document = null;
		try {
			document = PDDocument.load(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 text = new PDFTextStripper().getText(document);
			 System.out.println("Text in PDF interface wala\n---------------------------------");
		     System.out.println(text);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //Get the text from doc using PDFTextStripper 
		*/
		
		
		btnNewButton.setBounds(421, 11, 89, 39);
		frmQuestionGeneration.getContentPane().add(btnNewButton);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setText("OUTPUT");
		textArea.setBounds(55, 195, 553, 147);
		frmQuestionGeneration.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Please choose a pdf file for question generation");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(111, 42, 306, 14);
		frmQuestionGeneration.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Output Questions");
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				
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
				}
				
			}
		});
		
		
		btnNewButton_1.setBounds(430, 143, 149, 35);
		frmQuestionGeneration.getContentPane().add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Click a button from menu");
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(247, 127, 306, 28);
		frmQuestionGeneration.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(103, 21, 308, 20);
		frmQuestionGeneration.getContentPane().add(textField);
		textField.setColumns(10);		
		
		JButton btnNewButton_2 = new JButton("POS Tagging");
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				
				
			}
		});
		btnNewButton_2.setBounds(72, 143, 133, 35);
		frmQuestionGeneration.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Extracted Text ");
		btnNewButton_3.setBackground(Color.PINK);
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				textArea.setText(text);
			}
			
		});
		btnNewButton_3.setBounds(72, 97, 133, 35);
		frmQuestionGeneration.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Selected Sentences");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
			}
		});
		btnNewButton_4.setBackground(Color.PINK);
		btnNewButton_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNewButton_4.setBounds(431, 97, 148, 35);
		frmQuestionGeneration.getContentPane().add(btnNewButton_4);
	}
	
	
	private class buttonlistner implements ActionListener
	
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	}

