/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author DragonFly
 */
@Component("fxmlRouteController")
public class FXMLRouteController {

    private Stage primaryStage;

    private ApplicationContext context;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public void showScene(String key) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + key + ".fxml"));
        FXMLController fxmlController = (FXMLController) context.getBean(key + "Controller");
        fxmlController.setStage(primaryStage);
        loader.setControllerFactory((Class<?> param) -> fxmlController);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load \"" + key + "\"!");
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showDialog(String key) {
        Stage dialog = new Stage(StageStyle.DECORATED);
        dialog.initOwner(primaryStage);
        dialog.initModality(Modality.WINDOW_MODAL);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + key + ".fxml"));
        FXMLController fxmlController = (FXMLController) context.getBean(key + "Controller");
        fxmlController.setStage(dialog);
        loader.setControllerFactory((Class<?> param) -> fxmlController);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load \"" + key + "\"!");
        }
        Scene scene = new Scene(root);
        dialog.setScene(scene);
        dialog.show();
    }

}
