package com.github.gigazin.gbankapp.gbank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GB-Login-View.fxml"));
        Scene login = new Scene(fxmlLoader.load());
        stage.setTitle("GBank Application for development testing");
        stage.setScene(login);
        stage.show();
    }

    public static void main(String[] args) {
        Client testUser = new Client("Usuário", "75877793875");
        Agency testAgency = new Agency("77770");
        CurrentAccount testAccount = new CurrentAccount("776870", 1000, testUser, testAgency);
        launch();
    }
}