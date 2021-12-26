import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("views/LogInForm.fxml"))));
        primaryStage.setTitle("Sipsewana Institute");
        primaryStage.getIcons().add(new Image("assests/icons8-school-50.png"));
        primaryStage.show();
    }
    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    }

