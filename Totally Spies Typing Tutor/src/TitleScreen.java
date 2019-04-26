import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class TitleScreen {
	
	Main main;
	MediaPlayer mediaPlayer;
	Media sound;
	Button button;
	
	public TitleScreen(Main main) {
		this.main = main;
	}
	
	public void makeTitleScreen(Stage primaryStage) {
		GridPane pane = new GridPane();
		
		Image titlePic = new Image("titlePic.png");
		ImageView titlePicView = new ImageView(titlePic);
		titlePicView.setFitHeight(380);
		titlePicView.setFitWidth(380);
		GridPane.setRowIndex(titlePicView, 0);
        GridPane.setColumnIndex(titlePicView, 1);

        makeButton(primaryStage); 
        
        pane.getChildren().add(titlePicView);
        pane.getChildren().add(button);

        sound = new Media(new File("herewego.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        primaryStage.setTitle("Totally Spies Typing Tutor");
        primaryStage.setScene(new Scene(pane, 420, 420));
        primaryStage.show();
	}
	
	public void makeButton(Stage primaryStage) {
		button = new Button();
        button.setText("Start");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	mediaPlayer.stop();
            	sound = new Media(new File("start.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                
            	main.getMainMenu().makeMainMenuScreen(primaryStage);
            }
        });
        GridPane.setRowIndex(button, 1);
        GridPane.setColumnIndex(button, 1);
        GridPane.setHalignment(button, HPos.CENTER); 
	}
}