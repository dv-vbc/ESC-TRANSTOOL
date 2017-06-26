/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.controller;

import java.net.URI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import net.idealclover.java.fw.fx.esckit.core.FXMLController;
import net.idealclover.java.fw.fx.esckit.core.FXMLRouteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author DragonFly
 */
@Controller("aboutController")
public class AboutController implements FXMLController {

    @Autowired
    private FXMLRouteController fxmlRouteController;

    private Stage stage;

    private final String title = "About ETL Tool for KB Platform";

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void initialize() {
        stage.setResizable(false);
        stage.setTitle(this.title);
    }

    @FXML
    public void done() {
        stage.close();
    }

    @FXML
    public void email() {
        try {
            java.awt.Desktop.getDesktop().mail(new URI("mailto:service@idealclover.net?subject=Counselling%20service%20about%20the%20ETL%20Tool%20for%20KB%20Platform"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
