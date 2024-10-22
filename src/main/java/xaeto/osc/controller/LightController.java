package xaeto.osc.controller;

import xaeto.osc.annotations.OSCAttribute;
import xaeto.osc.annotations.OSCNamespace;

public class LightController {
  @OSCNamespace(route = "/light/test")
  public void test(@OSCAttribute String filter){
    System.out.println("Light Function called with filter: %s".formatted(filter));
  }
}
