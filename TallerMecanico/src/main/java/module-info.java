module org.estuardogomez.system {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.estuardogomez.system to javafx.fxml;
    exports org.estuardogomez.system;
    exports org.estuardogomez.controller;
}
