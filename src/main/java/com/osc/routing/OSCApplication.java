package com.osc.routing;

import com.osc.annotations.OSCMain;

public class OSCApplication {
  public static void run(Class<?> application, String[] args){
    OSCMain entryPoint = application.getAnnotation(OSCMain.class);
    Class<?>[] controllers = entryPoint.controllers();
    OSCRouter.initialize(controllers);
  }
}
