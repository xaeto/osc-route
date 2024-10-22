module xaeto.osc {
  requires javafx.controls;
  requires javafx.fxml;


  opens xaeto.osc to javafx.fxml;
  exports xaeto.osc;
  exports xaeto.osc.controller;
  opens xaeto.osc.controller to javafx.fxml;
  exports xaeto.osc.annotations;
  opens xaeto.osc.annotations to javafx.fxml;
  exports xaeto.osc.exceptions;
  opens xaeto.osc.exceptions to javafx.fxml;
  exports xaeto.osc.routing;
  opens xaeto.osc.routing to javafx.fxml;
}