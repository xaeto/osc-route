package com.osc.controller;

import com.osc.annotations.OSCAttribute;
import com.osc.annotations.OSCNamespace;

public class LightController {
  @OSCNamespace(name = "/light/test")
  public void test(@OSCAttribute String filter){
    System.out.println("Light Function called with filter: %s".formatted(filter));
  }
}
