package com.github.gigazin.gbankapp.gbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GBAboutController {

    /* ========== ImageView Area ========== */
    @FXML
    private ImageView gbLogo;
    /* ========== ImageView Area ========== */

    /* ========== Text Area ========== */
    @FXML
    private TextArea txtAbout;
    /* ========== Text Area ========== */

    /* ========== Label Area ========== */
    @FXML
    private Label gbText;
    /* ========== Label Area ========== */

    /* ========== Scene Area ========== */
    public static void display() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GB-About-View.fxml"));
        Scene about = new Scene(fxmlLoader.load());
        Stage aboutStage = new Stage();
        Button goBackButton = new Button("Voltar");
        goBackButton.setAlignment(Pos.BOTTOM_CENTER);
        goBackButton.setOnAction(e -> aboutStage.close());
        aboutStage.initModality(Modality.APPLICATION_MODAL);
        aboutStage.setTitle("About GBank");
        aboutStage.setScene(about);
        aboutStage.showAndWait();
    }
    /* ========== Scene Area ========== */

    /* ========== Misc Area ========== */
    public void initialize(URL url, ResourceBundle rb) { // Showing GBank logo at the About screen.
        Image gb = new Image(getClass().getResourceAsStream("com/github/gigazin/gbankapp/gbank/GBLogo.png"));
        gbLogo.setImage(gb);
    } // Showing GBank logo at the About screen.
    /* ========== Misc Area ========== */
}
