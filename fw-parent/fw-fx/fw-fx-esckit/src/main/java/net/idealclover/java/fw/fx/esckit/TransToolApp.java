/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit;

import javafx.application.Application;

import javafx.stage.Stage;
import net.idealclover.java.fw.fx.esckit.core.FXMLRouteController;
import net.idealclover.java.fw.fx.esckit.service.IDocService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 主页面入口
 *
 * @author DragonFly
 */
public class TransToolApp extends Application {

    private static final Logger log = Logger.getLogger(TransToolApp.class);

    @Autowired
    private IDocService docService;

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        FXMLRouteController route = (FXMLRouteController) context.getBean("fxmlRouteController");

        route.setPrimaryStage(stage);
        route.setContext(context);

        route.showDialog("login");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
