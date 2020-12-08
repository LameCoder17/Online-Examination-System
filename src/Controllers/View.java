package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class View implements Initializable{

	public Label cong;
    public JFXButton home;
    @FXML
	private Label Marks;

	@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
    		String[] no = JavaQuizController.getInstance().calCorrectAnswer();  // Get back String array
    		Marks.setText("Correct Answers - " + no[1] + "\nIncorrect Answers - " + no[2] + "\nMarks scored - " + no[0] + "/10");  //Show how many correct, incorrect answers and marks scored
		}

	public void exit() {
		System.exit(0);
	}
}
