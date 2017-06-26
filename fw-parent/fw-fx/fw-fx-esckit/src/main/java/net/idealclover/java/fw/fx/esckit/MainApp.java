/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.idealclover.java.fw.fx.esckit.service.IDocService;
import net.idealclover.java.fw.fx.esckit.vo.DocVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 主页面入口
 *
 * @author DragonFly
 */
public class MainApp extends Application {

    Logger log = Logger.getLogger(MainApp.class);

    @Autowired
    private IDocService docService;

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        BorderPane root = new BorderPane();
//        Scene scene = new Scene(root, 400, 400);
//        scene.getStylesheets().add(getClass().getResource("/styles/application.css").toExternalForm());
//        stage.setScene(scene);
//        stage.show();
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MyScence.fxml"));

            stage.setTitle("My Application");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
