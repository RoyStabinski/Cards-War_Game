package Q1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Q1 extends Application{
	public void start(Stage stage)throws Exception{
		Parent root = (Parent)
	FXMLLoader.load(getClass().getResource("MyProjectNew.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("MyProjectNew");
		stage.setScene(scene);
		stage.show();
	
	}
	
	public static void main(String[]args) {
		launch(args);
		System.out.println();
	}

}
