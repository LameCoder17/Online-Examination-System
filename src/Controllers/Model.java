package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import settings.settings;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Model implements Initializable {

    @FXML
    private AnchorPane quizView;

    @FXML
    private JFXButton q1;

    @FXML
    private JFXButton q4;

    @FXML
    private JFXButton q3;

    @FXML
    private JFXButton q2;

    @FXML
    private JFXButton q5;

    @FXML
    private JFXButton q6;

    @FXML
    private JFXButton q7;

    @FXML
    private JFXButton q8;

    @FXML
    private JFXButton q9;

    @FXML
    private JFXButton q10;
    @FXML
    private AnchorPane countDown;

    @FXML
	private static Model instance;

    public Model()
	{
		instance = this;
	}

    public static Model getInstance()
	{
		return instance;
	}	
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.createPage("/Style/JavaQuizView.fxml");
		CountDown count = new CountDown();
		countDown.getChildren().add(count.setCountdown());
	}

    public void setNode(Node node){ // Adds JavaQuizView fxml in MainView
		quizView.getChildren().clear();
		quizView.getChildren().add(node);
	}

	public void createPage(String loc) {
		try {
			AnchorPane homeN = FXMLLoader.load(getClass().getResource(loc));
			setNode(homeN);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
	 public void q1Action() {
    	if(settings.rollback == 1){
			JavaQuizController.getInstance().readQA(0);
			JavaQuizController.getInstance().setQuestionNO(0);
			JavaQuizController.getInstance().setQid(0);
		}
    }

	    @FXML
	    void q2Action() {
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(1);
				JavaQuizController.getInstance().setQuestionNO(1);
				JavaQuizController.getInstance().setQid(1);
			}
	    }

	    @FXML
	    void q3Action() {
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(2);
				JavaQuizController.getInstance().setQuestionNO(2);
				JavaQuizController.getInstance().setQid(2);
			}
	    }

	    @FXML
	    void q4Action() {
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(3);
				JavaQuizController.getInstance().setQuestionNO(3);
				JavaQuizController.getInstance().setQid(3);
			}
	    }

	    @FXML
	    void q5Action(){
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(4);
				JavaQuizController.getInstance().setQuestionNO(4);
				JavaQuizController.getInstance().setQid(4);
			}
	    }

	    @FXML
	    void q6Action(){
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(5);
				JavaQuizController.getInstance().setQuestionNO(5);
				JavaQuizController.getInstance().setQid(5);
			}
	    }

	    @FXML
	    void q7Action() {
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(6);
				JavaQuizController.getInstance().setQuestionNO(6);
				JavaQuizController.getInstance().setQid(6);
			}
	    }

	    @FXML
	    void q8Action() {
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(7);
				JavaQuizController.getInstance().setQuestionNO(7);
				JavaQuizController.getInstance().setQid(7);
			}
	    }

	    @FXML
	    void q9Action() {
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(8);
				JavaQuizController.getInstance().setQuestionNO(8);
				JavaQuizController.getInstance().setQid(8);
			}
	    }
      
	    @FXML
	    void q10Action() {
			if(settings.rollback == 1){
				JavaQuizController.getInstance().readQA(9);
				JavaQuizController.getInstance().setQuestionNO(9);
				JavaQuizController.getInstance().setQid(9);
			}
	    }

    public void setColorGreen(int qaID, boolean value){
	    	if(Objects.equals(value, true)){
	    		if(Objects.equals(qaID, 0)){
	    			q1.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    			
	    		}
	    		else if(Objects.equals(qaID, 1)){
	    			q2.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 2)){
	    			q3.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 3)){
	    			q4.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 4)){
	    			q5.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 5)){
	    			q6.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 6)){
	    			q7.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 7)){
	    			q8.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 8)){
	    			q9.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 9)){
	    			q10.setStyle("-fx-background-color: #29a827; -fx-text-fill: white;");
	    		}
	    	}
	    }

    public void setColorRed(int qaID, boolean value){
	    	if(Objects.equals(value, true)){
	    		if(Objects.equals(qaID, 0)){
	    			q1.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 1)){
	    			q2.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 2)){
	    			q3.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 3)){
	    			q4.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 4)){
	    			q5.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 5)){
	    			q6.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 6)){
	    			q7.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 7)){
	    			q8.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 8)){
	    			q9.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    		else if(Objects.equals(qaID, 9)){
	    			q10.setStyle("-fx-background-color: #eb3b3b; -fx-text-fill: white;");
	    		}
	    	}
	    }
}
