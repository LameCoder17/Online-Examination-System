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
    		double no = JavaQuizController.getInstance().calCorrectAnswer();
			Marks.setText(no + "/10");  // Setting final score
		}

	public void exit() {
		System.exit(0);
	}
}
