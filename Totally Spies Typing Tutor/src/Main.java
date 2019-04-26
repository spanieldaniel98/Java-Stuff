import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;

import javafx.geometry.HPos;

public class Main extends Application {
	
	int mathiasCounter;
	TitleScreen titleScreen;
	MainMenu mainMenu;
	GameStage gameStage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		mathiasCounter = 0;
		
		titleScreen = new TitleScreen(this);
		mainMenu = new MainMenu(this);
		gameStage = new GameStage(this);
		
		titleScreen.makeTitleScreen(primaryStage);
    }
	
	public TitleScreen getTitleScreen() {
		return this.titleScreen;
	}
	
	public MainMenu getMainMenu() {
		return this.mainMenu;
	}
	
	public int getMathiasCounter() {
		return this.mathiasCounter;
	}
	
	public void incrementMathiasCounter() {
		this.mathiasCounter += 1;
	}
}