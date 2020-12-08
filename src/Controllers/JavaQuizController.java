package Controllers;

import JavaQuiz.quiz;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import settings.settings;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class JavaQuizController implements Initializable{

	public JFXButton nextButton;
	@FXML
	    private JFXRadioButton b1;

	    @FXML
	    private JFXRadioButton b4;

	    @FXML
	    private JFXRadioButton b3;

	    @FXML
	    private JFXRadioButton b2;

	    @FXML
	    private JFXButton submit;
	    
	    @FXML
	    private Text qNo;
	   
	    @FXML
	    private Text questions;

	    String[][] qpa;
	    String[][] qca;
	    public static int qaID;
	    HashMap<Integer, String> map;
	    public static String chk;
	    private static JavaQuizController instance;
     	
    
    public JavaQuizController() {
     		instance = this;
     	}

    public static JavaQuizController getInstance() {
     		return instance;
     	}	
         
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			ToggleGroup tgGroup = new ToggleGroup();
			b1.setToggleGroup(tgGroup);
			b2.setToggleGroup(tgGroup);
			b3.setToggleGroup(tgGroup);
			b4.setToggleGroup(tgGroup);

			qpa = new String[10][5];
			qca = new String[10][2];
			qpa = quiz.setQuiz();
			qca = quiz.setAnswer();

			map = new HashMap<>();
			readQA(qaID);
    }

    public void readQA(int i){

    		Color textColor = Color.rgb(173,239,209);
		        		       
    		questions.setText(qpa[i][0]);
    		questions.setFill(textColor);

    		b1.setText("A) " + qpa[i][1]);
    		b1.setTextFill(textColor);
    		b2.setText("B) " + qpa[i][2]);
    		b2.setTextFill(textColor);
    		b3.setText("C) " + qpa[i][3]);
    		b3.setTextFill(textColor);
    		b4.setText("D) " + qpa[i][4]);
    		b4.setTextFill(textColor);

	       String btn = selectedToggle(i,b1,b2,b3,b4);
	        
	       if(Objects.equals(btn, "b1")){
	    	   b1.setSelected(true);
	       }
	       else if(Objects.equals(btn, "b2")){
	    	   b2.setSelected(true);
	       }
	       else if(Objects.equals(btn, "b3")){
	    	   b3.setSelected(true);
	       }
	       else if(Objects.equals(btn, "b4")){
	    	   b4.setSelected(true);
	       }
	       else{
	    	   b1.setSelected(false);
	    	   b2.setSelected(false);
	    	   b3.setSelected(false);
	    	   b4.setSelected(false);
	       }
	    }	

    public void setQid(int i){
			qaID =  i;
		 }

		 //Option selection
    public String selectedToggle(int qa, JFXRadioButton r1, JFXRadioButton r2, JFXRadioButton r3, JFXRadioButton r4){  //For the selection toggle
			String temp = map.get(qa);
			String sel = null;
			
			if(Objects.equals(temp, r1.getText().substring(4))){
			    sel = "b1";
			}
			else if(Objects.equals(temp, r2.getText().substring(4))){
				sel = "b2";
			}
			else if(Objects.equals(temp, r3.getText().substring(4))){
				sel = "b3";
			}
			else if(Objects.equals(temp, r4.getText().substring(4))){
				sel = "b4";
			}
			 return sel;
		 }

    public String getSelection(){
			 return chk;
         }

    public void setQuestionNO(int i){  //To get the question number
			 int qN = i;
			 qN++;
			 qNo.setText("Q."+qN+" |");
		 }

    @FXML
	public void groupAction(){  //For the select action

		  if(b1.isSelected()){
			  chk = b1.getText().substring(4);
		  }
		  else if(b2.isSelected()){
			  chk = b2.getText().substring(4);
		  }
		  else if(b3.isSelected()){
			  chk = b3.getText().substring(4); 
		  }
		  else if(b4.isSelected()){
			  chk = b4.getText().substring(4);
		  }
		}

    @FXML	 
	public void btnNext() throws IOException{  //For the next button
    	if(qaID < 10){
             map.put(qaID,getSelection());
             if(Objects.equals(getSelection(), null)){
            	 Model.getInstance().setColorRed(qaID, true);
             }
             else{
            	 Model.getInstance().setColorGreen(qaID, true);
             }
             if(Objects.equals(qaID, 9)){
                 setQuestionNO(qaID);
                 readQA(qaID);
                 qaID++;
             }
             else{
            	 qaID++;
            	 chk = null;
                 setQuestionNO(qaID);
                 readQA(qaID);
              }
           }
	  else{
	  	this.setDialogBox();
         }
      }

    public void setDialogBox() throws IOException{  //For the submission box
		 Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Confirmation");
		 alert.setContentText(" Are you sure you want to submit ?");

		 Optional<javafx.scene.control.ButtonType> action = alert.showAndWait();

		 if ((action.isPresent()) && (action.get() ==javafx.scene.control.ButtonType.OK)){
		 	this.submit();
		 	System.gc();
		 }
		 else{
		 	qaID--;
		 }
	 }

    public String[] calCorrectAnswer() {  //Calculates number of correct/incorrect answers and marks at the end
		int qNum = 10;
		int correct = 0, incorrect = 0;
		double count = 0;
		for (int qid = 0; qid < qNum; qid++){
			if (qca[qid][1].substring(1).equals(map.get(qid))) {
				count++;
				correct++;
			} else if ((settings.negativeMarking != 0) && (map.get(qid) != null)) {
				count -= settings.negativeMarking;
				incorrect++;
			}
		}
		return new String[]{String.valueOf(count), String.valueOf(correct), String.valueOf(incorrect)};
     }

    @FXML
	 public void submitQuiz() throws IOException {
    	this.setDialogBox();
	  }

    public void submit() throws IOException{
		  qaID = 0;
		  submit.getScene().getWindow().hide();
			
		  Stage Result = new Stage();
		  Parent root = FXMLLoader.load(getClass().getResource("/Style/JavaLangFinaReport.fxml"));

		  Scene scene = new Scene(root);
		  Result.initStyle(StageStyle.UNDECORATED);
		  Result.setScene(scene);
		  Result.show();
		  Result.setResizable(false);
	 }
}


