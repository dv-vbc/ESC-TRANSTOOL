/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.idealclover.java.fw.fx.esckit.core.FXMLController;
import net.idealclover.java.fw.fx.esckit.core.FXMLRouteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

/**
 *
 * @author DragonFly
 */
@Controller("loginController")
public class LoginController implements FXMLController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FXMLRouteController fxmlRouteController;

    private Stage stage;

    private final String title = "Login the Platform";

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    Label header;
    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    protected void initialize() {
        stage.setResizable(false);
        stage.setTitle(this.title);
    }

    @FXML
    public void login() {
        Authentication authToken = new UsernamePasswordAuthenticationToken(username.getText(), password.getText());
        try {
            authToken = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authToken);
        } catch (AuthenticationException e) {
            header.setText("Login failure, please try again:");
            header.setTextFill(Color.DARKRED);
            return;
        }
        stage.close();
        fxmlRouteController.showScene("main");
    }

    @FXML
    public void employee() {
        username.setText("employee");
        password.setText("lol");
    }

    @FXML
    public void manager() {
        username.setText("manager");
        password.setText("password");
    }
}
