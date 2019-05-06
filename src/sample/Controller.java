package sample;

import DataModels.GameLevel;
import Scenes.ArcadeGameScene;
import Scenes.SettingsScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class Controller implements Initializable {


    Button playButton, settingsButton;


    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("View is now loaded!");


    }
    /*
    public Controller(MediaView view) {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
    }
*/
    public void playButton(ActionEvent event){

        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(getClass().getResource("/FXMLDeneme/samplex.fxml"));
        System.out.println("play is now loaded!");


        //System.out.println(Controller.class.getResource("/FXMLDeneme/samplex.fxml"));
        //loader.setLocation(Controller.class.getResource("FXMLDeneme/samplex.fxml"));
        //Main.mainStage.setScene(new ArcadeGameScene(new GameLevel()));

    }

    public void settingsButton(ActionEvent event){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/settings.fxml"));
        System.out.println("settings is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage controllerStage = new Stage();
        controllerStage.setScene(scene);
        controllerStage.show();
        //controllerStage.close();

        //System.out.println(Controller.class.getResource("/FXMLDeneme/samplex.fxml"));
        //loader.setLocation(Controller.class.getResource("FXMLDeneme/samplex.fxml"));
        //Main.mainStage.setScene(new ArcadeGameScene(new GameLevel()));

    }



    }




