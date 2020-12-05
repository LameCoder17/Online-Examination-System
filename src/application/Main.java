package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.File;
import java.util.Scanner;
import settings.settings;

public class Main extends Application {
	private static Stage primaryStageObj;
	@Override
	public void start(Stage primaryStage) {
		try {
			File myObj = new File("settings.txt");
			Scanner myReader = new Scanner(myObj);

			settings.time = Integer.parseInt(myReader.nextLine());
			settings.negativeMarking = Double.parseDouble(myReader.nextLine());
			settings.rollback = Integer.parseInt(myReader.nextLine());

			myReader.close();

			primaryStageObj = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/Style/MainView.fxml"));			
			Scene scene = new Scene(root);
		    primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
		launch(args);
	}

    public static Stage getPrimaryStage() {
		return primaryStageObj;
	 }

}
