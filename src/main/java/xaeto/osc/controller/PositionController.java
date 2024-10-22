package xaeto.osc.controller;

import xaeto.osc.annotations.OSCAttribute;
import xaeto.osc.annotations.OSCNamespace;

public class PositionController {
  @OSCNamespace(route = "/placeholder")
  public void placeholder(@OSCAttribute Integer a, @OSCAttribute Integer b){
    System.out.println("Called Placeholder with a (%s) and b (%s)".formatted(a, b));
  }
}
