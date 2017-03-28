package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EmployeeInfoController implements Initializable{
	public LoginModel loginModel = new LoginModel();

	Connection connection=null;
	
	@FXML
	private TextField empName;
	@FXML
	private TextField empPhn;
	@FXML
	private TextField empShift;
	@FXML
	private TextField empSalary;
	@FXML
	private TextField empDOB;
	@FXML
	private TextField empAddress;
	@FXML
	private TextField empID;
	@FXML
	private Label userlabel;
	@FXML
	private Label message;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		if (loginModel.isDbConnected()){
			message.setText("DB Connected");
		}
		else {
			message.setText("Not Connected");
		}
	
		
	}
	
	public void addInfo (ActionEvent event) {
		
		if (empName.getText()!=null)
			
		{
			try {
				connection = SqliteConnection.Connector();
				String query = "INSERT INTO EmployeeInfo (emp_id,emp_name,emp_contact,emp_shift,emp_salary,emp_dob,emp_address) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(query);
				
				if (empID.getText().equals(""))
				{
					pst.setString(1, null);
					
				}
				else {
					pst = connection.prepareStatement(query);
					pst.setString(1, empID.getText());
				}
				
				pst.setString(2, empName.getText());
				pst.setString(3, empPhn.getText());
				pst.setString(4, empShift.getText());
				pst.setString(5, empSalary.getText());
				pst.setString(6, empDOB.getText());
				pst.setString(7, empAddress.getText());
				
				pst.execute();
				pst.close();
				
				message.setText("Data Inserted Successfully");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else {
		message.setText("Fill required fields!");
		}
		
	}

}
