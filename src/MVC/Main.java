package MVC;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import static MVC.constans.FXMLConstans.*;
import java.io.IOException;
public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(LOGIN_VIEW));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Quản lí hộ khẩu");
        stage.setScene(scene);
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}