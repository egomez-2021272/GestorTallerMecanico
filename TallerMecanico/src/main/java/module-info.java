module org.estuardogomez.system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens org.estuardogomez.system to javafx.fxml;
    exports org.estuardogomez.system;
    exports org.estuardogomez.controller;
    exports org.estuardogomez.db;
    //requires mysql.connector.j;
}
