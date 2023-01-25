import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);

        GameScene theScene = new GameScene(pane, 600, 400, true,0,0);

        primaryStage.setScene(theScene);

        primaryStage.show();
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);


    }
}