
import java.awt.*;
import java.awt.event.*;

/**
 * This is a skeleton for realizing a very simple database user interface in java. 
 * The interface is an Applet, and it implements the interface ActionListener. 
 * If the user performs an action (for example he presses a button), the procedure actionPerformed 
 * is called. Depending on his actions, one can implement the database connection (disconnection), 
 * querying or insert. 
 * 
 * @author zmiklos
 *
 */
public class DatabaseUserInterface extends java.applet.Applet implements ActionListener {

 private TextField mStat, m1, m2, m3;
TextArea mRes;
 private Button b1, b2, b3, b4;
 private static final long serialVersionUID = 1L; 
 
 
 /**
  * This procedure is called when the Applet is initialized.
  * 
  */
 public void init ()
 {    
	 /**
	  * Definition of text fields
	  */
     //m1 = new TextField(80);
     //m1.setText("What are you going to do when the light is:");
     //m1.setEditable(false);
     mStat = new TextField(150);
     mStat.setEditable(false);
     m1 = new TextField(150);
     m2 = new TextField(150);
     m3 = new TextField(150);
     mRes = new TextArea(10,150);
     mRes.setEditable(false);
//    this.setSize(600, 500);
     
     /**
      * First we define the buttons, then we add to the Applet, finally add and ActionListener 
      * (with a self-reference) to capture the user actions.  
      */
     b1 = new Button("CONNECT");
     b2 = new Button("DISCONNECT");
     b3 = new Button("QUERY");
     b4 = new Button("INSERT");
     add(b1) ;
     add(b2) ;
     add(b3) ;
     add(b4);
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     b4.addActionListener(this);
     
     add(mStat);
     add(new Label("Input fields: ", Label.CENTER));
     add(m1);
     add(m2);
     add(m3);
     m1.setText("Name (e.g. John Smith) - Please enter here!");  //According to the database schema
     m2.setText("Age (e.g. 23)  - Please enter here!"); //According to the database schema
     m3.setText("Color of the eye (e.g. green) - Please enter here!");  //According to the database schema
     add(new Label("Query results: ", Label.CENTER));
     add(mRes);
     mRes.setText("Query results");
     
     setStatus("Waiting for user actions.");
 }
 
 
 /**
  * This procedure is called upon a user action.
  * 
  *  @param event The user event. 
  */
  public void actionPerformed(ActionEvent event)
 {
  
	 // Extract the relevant information from the action (i.e. which button is pressed?)
	 Object cause = event.getSource();

	 // Act depending on the user action
	 // Button CONNECT
     if (cause == b1)
     {
        connectToDatabase();
     }
     
     // Button DISCONNECT
     if (cause == b2)
     {
    	 disconnectFromDatabase();
     }
     
     //Button QUERY
     if (cause == b3)
     {
    	 queryDatabase();
     }
     
     //Button INSERT
     if (cause == b4)
     {
         insertDatabase();
     }
 }
 

/**
 * Set the status text. 
 * 
 * @param text The text to set. 
 */
private void setStatus(String text){
	    mStat.setText("Status: " + text);
  }

/**
 * Procedure, where the database connection should be implemented. 
 */
private void connectToDatabase(){
	try{
	setStatus("Connected to the database");
	} catch(Exception e){
		System.err.println(e.getMessage());
		setStatus("Connection failed");
	}
}


/**
 * Procedure, where the database connection should be implemented. 
 */
private void disconnectFromDatabase(){
	try{
	setStatus("Disconnected from the database");
	} catch(Exception e){
		System.err.println(e.getMessage());
		setStatus("Disconnection failed");
	}
}

/**
 * Execute a query and display the results. Implement the database querying and the 
 * display of the results here 
 */
private void queryDatabase(){
	setStatus("Querying the database");
	mRes.setText("The query result is presented here.\n");
	mRes.append("Joe\n");
	mRes.append("John\n");
	mRes.append("...\n");
}

/**
 * Insert tuples to the database. 
 */
private void insertDatabase(){
	try{
		String name = m1.getText();
		String age = m2.getText();
		String color = m3.getText();
		setStatus("Inserting --( " + name + ", " + age + ", " + color + " )-- to the database");
		} catch(Exception e){
			System.err.println(e.getMessage());
			setStatus("Insertion failed");
		}
	
}


}