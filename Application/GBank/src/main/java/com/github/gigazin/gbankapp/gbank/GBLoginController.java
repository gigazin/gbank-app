package com.github.gigazin.gbankapp.gbank;

import exceptions.InvalidAccountException;
import gui.utils.Alerts;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class GBLoginController {

    /* ========== Button Area ========== */
    @FXML
    private Button aboutButton; // About

    @FXML
    private Button loginButton; // Login
    /* ========== Button Area ========== */

    /* ========== TextField Area ========== */
    @FXML
    private TextField cpfInput; // Informe seu CPF

    @FXML
    private TextField passwordInput; // Informe sua senha
    /* ========== TextField Area ========== */

    /* ========== Label Area ========== */
    @FXML
    private Label cpfText; // CPF

    @FXML
    private Label passwordText; // Senha

    @FXML
    private Label welcomeText; // Bem-Vindo(a)!

    @FXML
    private Label loginInstText; // Faça seu login.......

    @FXML
    private Label gbText; // GBank Application......
    /* ========== Label Area ========== */

    /* ========== ImageView Area ========== */
    @FXML
    private ImageView gbLogo;
    /* ========== ImageView Area ========== */

    /* ========== Text Area ========== */
    @FXML
    private TextArea loginAccountCredentials;
    /* ========== Text Area ========== */

    /* ========== Control Area ========== */
    @FXML
    protected void onAboutButtonClickAction() throws IOException {
        GBAboutController.display();
        loginAccountCredentials.setVisible(true);
    }

    @FXML
    protected void onLoginButtonClickAction(ActionEvent event) throws IOException {
        if (!cpfInput.getText().equals("758.777.938-75") && !cpfInput.getText().equals("75877793875") || !passwordInput.getText().equals("0713")) {
            Alerts.showAlert("Invalid Account", null, """
                    A conta inserida é inválida. Certifique-se de utilizar as credenciais exibidas na tela.
                                        
                    """ + new InvalidAccountException("Incorrect Account Credentials."), Alert.AlertType.ERROR);
        } else {
            Alerts.showAlert("Logged In", null, "Login realizado com sucesso!", Alert.AlertType.CONFIRMATION);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GB-Main-View.fxml"));
            Parent root = loader.load();
            GBMainController gbMainController = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }

    }
    /* ========== Control Area ========== */

    /* ========== Misc Area ========== */
    public void initialize(URL url, ResourceBundle rb) { // Showing GBank logo at the Login screen.
        Image gb = new Image(getClass().getResourceAsStream("com/github/gigazin/gbankapp/gbank/GBLogo.png"));
        gbLogo.setImage(gb);
    } // Showing GBank logo at the Login screen.
    /* ========== Misc Area ========== */

}