/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.core;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 *
 * @author DragonFly
 */
public class FXMLDialog extends Stage {

    public FXMLDialog(URL fxml, Window owner, DialogController ctrlr) throws IOException {
        this(fxml, owner, ctrlr, StageStyle.DECORATED);
    }

    public FXMLDialog(URL fxml, Window owner, DialogController ctrlr, StageStyle style) throws IOException {
        super(style);
        initOwner(owner);
        initModality(Modality.WINDOW_MODAL);
        FXMLLoader loader = new FXMLLoader(fxml);
        loader.setControllerFactory((Class<?> param) -> ctrlr);
        ctrlr.setDialog(this);
        setScene(new Scene((Parent) loader.load()));
    }

}
