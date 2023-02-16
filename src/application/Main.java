package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		AnchorPane	p = new AnchorPane();
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Main.class.getResource("/View/LoadingPage.fxml"));
		p=loader.load();
		//AnchorPane root=FXMLLoader.load(getClass().getResource("/View/DemarrageView.fxml"));
		Scene scene = new Scene(p);
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		//scene.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
			

	}
	public static void main(String[] args) {
		launch(args);
	}
}
