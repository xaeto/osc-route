module com.example.osc {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.osc to javafx.fxml;
  exports com.osc;
  exports com.osc.controller;
  opens com.osc.controller to javafx.fxml;
  exports com.osc.annotations;
  opens com.osc.annotations to javafx.fxml;
  exports com.osc.exceptions;
  opens com.osc.exceptions to javafx.fxml;
  exports com.osc.routing;
  opens com.osc.routing to javafx.fxml;
}