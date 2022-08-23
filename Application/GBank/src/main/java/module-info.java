module com.github.gigazin.gbankapp.gbank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.gigazin.gbankapp.gbank to javafx.fxml;
    exports com.github.gigazin.gbankapp.gbank;
}