package Controllers;

import application.Main;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

	    @FXML
	    private AnchorPane anPane;

	    @FXML
	    private JFXButton round1;

	private double xOffset;
	private double yOffset;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { //Draggable Screen
		 anPane.setOnMousePressed(event -> {
	            xOffset = Main.getPrimaryStage().getX() - event.getScreenX();
	            yOffset = Main.getPrimaryStage().getY() - event.getScreenY();
	            anPane.setCursor(Cursor.CLOSED_HAND);
	        });

		 anPane.setOnMouseDragged(event -> {
			 Main.getPrimaryStage().setX(event.getScreenX() + xOffset);
			 Main.getPrimaryStage().setY(event.getScreenY() + yOffset);
	        });
		
		 anPane.setOnMouseReleased(event -> anPane.setCursor(Cursor.DEFAULT));
	}

    @FXML
	  public void roundOneAction() throws IOException {
		    round1.getScene().getWindow().hide();
			Stage signup = new Stage();
			signup.initStyle(StageStyle.UNDECORATED);
			Parent root = FXMLLoader.load(getClass().getResource("/Style/MainQuizView.fxml"));
			Scene scene = new Scene(root);
			signup.setScene(scene);
			signup.show();
			signup.setResizable(false);
	  }

	    @FXML
	    void closeApp() {
	    	System.exit(0); //exit from application
	  }
}
