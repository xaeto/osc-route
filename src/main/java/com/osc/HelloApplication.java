package com.osc;

import com.osc.annotations.OSCMain;
import com.osc.controller.PositionController;
import com.osc.exceptions.OSCException;
import com.osc.routing.OSCApplication;
import com.osc.routing.OSCRouter;

import java.lang.reflect.InvocationTargetException;


@OSCMain(controllers = { PositionController.class })
public class HelloApplication {
  public static void main(String[] args) throws OSCException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    OSCApplication.run(HelloApplication.class, args);
    OSCRouter.forward("/placeholder", 1, 2);
  }
}