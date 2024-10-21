package com.osc.controller;

import com.osc.annotations.OSCAttribute;
import com.osc.annotations.OSCNamespace;

public class PositionController {
  @OSCNamespace(name = "/placeholder")
  public void placeholder(@OSCAttribute Integer a, @OSCAttribute Integer b){
    System.out.println("Called Placeholder with a (%s) and b (%s)".formatted(a, b));
  }
}
