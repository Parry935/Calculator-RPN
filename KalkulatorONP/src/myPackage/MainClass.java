package myPackage;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import myController.PaneController;


public class MainClass extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("KalkulatorONP.fxml"));
		Pane stackPane = loader.load();
		PaneController controller = loader.getController();
		Scene scene = new Scene(stackPane);
		
		primaryStage.setScene(scene);
		primaryStage.setMaxHeight(630);
		primaryStage.setMaxWidth(615);
		primaryStage.setTitle("Kalkulator ONP");
		primaryStage.show();	
	}
}
