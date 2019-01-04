package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class GameCode extends Application {

    private long timeStep;
    private boolean scoring;
    private int score;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HBox Experiment 1");

        //Label label = new Label("Not clicked");
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Text txt = new Text(10,0,"Click Score");

        /*button.setOnAction(value ->  {
            label.setText("Clicked!");
        });*/

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (scoring)
                {
                    score++;
                }
                else
                {
                    score--;
                }
            }
        });

        timeStep = System.nanoTime() + 1000000000L;
        new AnimationTimer()
        {
            public void handle(long now)
            {
                if (now > timeStep)
                {
                    timeStep = now + 1000000000L;
                    scoring = !scoring;
                }
                if (!scoring)
                {
                    b1.setText("Don't Click");
                }
                else
                {
                    b1.setText("Click Me!");
                }

                txt.setText("Score: " + Integer.toString(score));
            }
        }.start();

        HBox hbox = new HBox(b1, b2, b3, b4);

        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
