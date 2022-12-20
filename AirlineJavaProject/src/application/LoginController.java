package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


public class LoginController {
	

    @FXML
    private Text message_text;
    
    @FXML
    private ImageView background_img;

    @FXML
    private Button login_button;

    @FXML
    private AnchorPane main_anchor;

    @FXML
    private PasswordField password_passwordfield;

    @FXML
    private Text password_text;

    @FXML
    private Text title_text;

    @FXML
    private Text username_text;

    @FXML
    private TextField username_textfield;

    @FXML
    void login_function(ActionEvent event) {
    	
    	//get GUI inputs
    	String username = username_textfield.getText().toString();
    	String password = password_passwordfield.getText().toString();
    	
    	
    	//connect database
    	DatabaseConnection connectNow = new DatabaseConnection();
        
        Connection connectDB = connectNow.getConnection();
        
        String connectQuery = "SELECT * FROM user";
        
        //if any of the fields is left blank
    	if(username.equals("") | password.equals("")) {
    		message_text.setText("Please fill all the required fields!");
    	}else {
    		try {
            	
            	Statement statement = connectDB.createStatement();
            	ResultSet queryOutput = statement.executeQuery(connectQuery); 
            	
            	
            	
            	while(queryOutput.next()) {
            		
                    
                	//if both fields contain text--> get correct username and password from database
            		
            		String databaseUsername = queryOutput.getString("username");
                	String databasePassword = queryOutput.getString("password");
            		
            		
                	if(username.equals(databaseUsername)) {
                		//username exits (account exists)
                		//So check password
                		
                		if(password.equals(databasePassword)) {
                			//if password correct
                			message_text.setText("Login successful!");
                			
                			Stage stage = (Stage) message_text.getScene().getWindow();
                            Parent root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setTitle("Home Page");
                            stage.show();
                            
                			break;
                			
                		}else {
                			//if password wrong
                			message_text.setText("Wrong password!");
                			break;
                		}
                		
                		
                	}else {
                		//username does not exist
                		message_text.setText("This username does not exist!");
                	}
                	
            	}

            	
            }catch(Exception e) {
            	e.printStackTrace();
            }
        	
        	
        }
    	}
    	
       
        
    
    
    
}
