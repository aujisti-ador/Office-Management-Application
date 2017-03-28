package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController implements Initializable{
	@FXML
	private Label userlabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setUsername(String user) {
		userlabel.setText(user);
		
	}
	
	public void signOut(ActionEvent event) {
			
		try {
			
			((Node)event.getSource()).getScene().getWindow().hide(); //hide previous window
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/LoginScreen.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void empInfo(ActionEvent event) {
		
		try {
			
			((Node)event.getSource()).getScene().getWindow().hide(); //hide previous window
			
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/EmployeeInfo.fxml").openStream());
			/*MenuController menu = (MenuController)loader.getController();
			menu.setUsername(txtUsername.getText());*/
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
