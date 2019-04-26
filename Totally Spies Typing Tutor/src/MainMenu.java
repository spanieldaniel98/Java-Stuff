import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenu {
	
	Main main;
	MediaPlayer mediaPlayer;
	Media sound;
	Button easyButton, mediumButton, hardButton, optionsButton, howToPlayButton, backButton, mathiasModeButton;
	
	public MainMenu(Main main) {
		this.main = main;
	}
	
	public void makeMainMenuScreen(Stage primaryStage) {
		GridPane pane = new GridPane();
		DropShadow dropShadow = new DropShadow();
		dropShadow.setColor(Color.PURPLE);
		
		makeEasyButton(primaryStage, dropShadow);
		makeMediumButton(primaryStage, dropShadow);
        makeHardButton(primaryStage, dropShadow);
        makeOptionsButton(primaryStage, dropShadow);
        makeHowToPlayButton(primaryStage, dropShadow);
        makeBackButton(primaryStage, dropShadow);
        makeMathiasModeButton(primaryStage, dropShadow);

        pane.getChildren().add(easyButton);
        pane.getChildren().add(mediumButton);
        pane.getChildren().add(hardButton);
        pane.getChildren().add(optionsButton);
        pane.getChildren().add(howToPlayButton);
        pane.getChildren().add(backButton);
        if(main.getMathiasCounter() >= 3) {
        	pane.getChildren().add(mathiasModeButton);
        }
        
        Image jerryPic = new Image("jerryPic.jpg");
		ImageView jerryPicView = new ImageView(jerryPic);
		jerryPicView.setFitHeight(380);
		jerryPicView.setFitWidth(380);
		GridPane.setRowIndex(jerryPicView, 1);
        GridPane.setColumnIndex(jerryPicView, 5);
        pane.getChildren().add(jerryPicView);
		
        sound = new Media(new File("woohptheme.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        primaryStage.setScene(new Scene(pane, 700, 420));
        pane.requestFocus();
	}
	
	public void makeEasyButton(Stage primaryStage, DropShadow dropShadow) {
		easyButton = new Button();
		easyButton.setText("Easy");
		easyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	mediaPlayer.stop();
            	sound = new Media(new File("tingu.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            	easyModePlay(primaryStage);
            }
        });
        GridPane.setRowIndex(easyButton, 1);
        GridPane.setColumnIndex(easyButton, 0);
        easyButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new ButtonEnteredHandler(easyButton, dropShadow));
        easyButton.addEventHandler(MouseEvent.MOUSE_EXITED, new ButtonExitedHandler(easyButton));
	}
	
	public void makeMediumButton(Stage primaryStage, DropShadow dropShadow) {
		mediumButton = new Button();
        mediumButton.setText("Medium");
        mediumButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	mediaPlayer.stop();
            	sound = new Media(new File("tingu.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            	mediumModePlay(primaryStage);
            }
        });
        GridPane.setRowIndex(mediumButton, 1);
        GridPane.setColumnIndex(mediumButton, 1);
        mediumButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new ButtonEnteredHandler(mediumButton, dropShadow));
        mediumButton.addEventHandler(MouseEvent.MOUSE_EXITED, new ButtonExitedHandler(mediumButton));
	}
	
	public void makeHardButton(Stage primaryStage, DropShadow dropShadow) {
		hardButton = new Button();
        hardButton.setText("Hard");
        hardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	mediaPlayer.stop();
            	sound = new Media(new File("tingu.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            	hardModePlay(primaryStage);
            }
        });
        GridPane.setRowIndex(hardButton, 1);
        GridPane.setColumnIndex(hardButton, 2);
        hardButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new ButtonEnteredHandler(hardButton, dropShadow));
        hardButton.addEventHandler(MouseEvent.MOUSE_EXITED, new ButtonExitedHandler(hardButton));
	}
	
	public void makeOptionsButton(Stage primaryStage, DropShadow dropShadow) {
		optionsButton = new Button();
        optionsButton.setText("Options");
        optionsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	mediaPlayer.stop();
            	sound = new Media(new File("tingu.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            	optionsMenu(primaryStage);
            }
        });
        GridPane.setRowIndex(optionsButton, 1);
        GridPane.setColumnIndex(optionsButton, 3);
        optionsButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new ButtonEnteredHandler(optionsButton, dropShadow));
        optionsButton.addEventHandler(MouseEvent.MOUSE_EXITED, new ButtonExitedHandler(optionsButton));
	}
	
	public void makeHowToPlayButton(Stage primaryStage, DropShadow dropShadow) {
		howToPlayButton = new Button();
        howToPlayButton.setText("How To Play");
        howToPlayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer.stop();
                sound = new Media(new File("tingu.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                howToPlay(primaryStage);
            }
        });
        GridPane.setRowIndex(howToPlayButton, 1);
        GridPane.setColumnIndex(howToPlayButton, 4);
        howToPlayButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new ButtonEnteredHandler(howToPlayButton, dropShadow));
        howToPlayButton.addEventHandler(MouseEvent.MOUSE_EXITED, new ButtonExitedHandler(howToPlayButton));
	}
	
	public void makeBackButton(Stage primaryStage, DropShadow dropShadow) {
		backButton = new Button();
        backButton.setText("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer.stop();
                sound = new Media(new File("menucancel.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                main.incrementMathiasCounter();

        		main.getTitleScreen().makeTitleScreen(primaryStage);
            }
        });
        GridPane.setRowIndex(backButton, 0);
        GridPane.setColumnIndex(backButton, 0);
        backButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new ButtonEnteredHandler(backButton, dropShadow));
        backButton.addEventHandler(MouseEvent.MOUSE_EXITED, new ButtonExitedHandler(backButton));
	}
	
	public void makeMathiasModeButton(Stage primaryStage, DropShadow dropShadow) {
		mathiasModeButton = new Button();
        mathiasModeButton.setText("Mathias Mode");
        mathiasModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer.stop();
                sound = new Media(new File("tingu.wav").toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                mathiasModePlay(primaryStage);
            }
        });
        GridPane.setRowIndex(mathiasModeButton, 0);
        GridPane.setColumnIndex(mathiasModeButton, 1);
        mathiasModeButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new ButtonEnteredHandler(mathiasModeButton, dropShadow));
        mathiasModeButton.addEventHandler(MouseEvent.MOUSE_EXITED, new ButtonExitedHandler(mathiasModeButton));
	}
	
	public void easyModePlay(Stage primaryStage) {
		
	}
	
	public void mediumModePlay(Stage primaryStage) {
		
	}

	public void hardModePlay(Stage primaryStage) {
	
	}
	
	public void optionsMenu(Stage primaryStage) {
		
	}
	
	public void howToPlay(Stage primaryStage) {
		
	}
	
	public void mathiasModePlay(Stage primaryStage) {
		
	}

class ButtonEnteredHandler implements EventHandler<MouseEvent> {
	
	Button button;
	DropShadow dropShadow;
	
	public ButtonEnteredHandler(Button button, DropShadow dropShadow) {
		this.button = button;
		this.dropShadow = dropShadow;
	}
	
	@Override
    public void handle(MouseEvent e) {
		this.button.setEffect(dropShadow);
		Media sound = new Media(new File("menubeep.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}

class ButtonExitedHandler implements EventHandler<MouseEvent> {
	
	Button button;
	
	public ButtonExitedHandler(Button button) {
		this.button = button;
	}
	
	@Override
    public void handle(MouseEvent e) {
		this.button.setEffect(null);
    }
}

}