package xaeto.osc;

import xaeto.osc.annotations.OSCMain;
import xaeto.osc.controller.PositionController;
import xaeto.osc.exceptions.OSCException;
import xaeto.osc.routing.OSCApplication;
import xaeto.osc.routing.OSCRouter;

import java.lang.reflect.InvocationTargetException;


@OSCMain(controllers = { PositionController.class })
public class HelloApplication {
  public static void main(String[] args) throws OSCException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    OSCApplication.run(HelloApplication.class, args);
    OSCRouter.forward("/placeholder", 1, 2);
  }
}