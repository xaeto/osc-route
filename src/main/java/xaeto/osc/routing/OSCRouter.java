package xaeto.osc.routing;

import xaeto.osc.annotations.OSCNamespace;
import xaeto.osc.exceptions.OSCException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class OSCRouter {
  private static Map<String, java.lang.reflect.Method> routes = new HashMap<>();
  public static void initialize(Class<?>... classes){
    for(var c : classes){
      var oscMethods = Arrays.stream(c.getMethods())
              .filter(annotation -> annotation.isAnnotationPresent(OSCNamespace.class))
              .toList();

      for(var oscMethod : oscMethods){
        String name = oscMethod.getAnnotation(OSCNamespace.class).route();
        routes.put(name, oscMethod);
      }
    }
  }

  private static Method getMethod(String namespace) throws OSCException {
    if(routes.isEmpty()){
      throw new OSCException("No namespaces registered.");
    }
    if(!routes.containsKey(namespace)){
      throw new OSCException("Namespace: %s not found.".formatted(namespace));
    }

    return routes.get(namespace);
  }

  public static Set<String> getRoutes(){
    return routes.keySet();
  }

  public static void forward(String namespace, Object... params) throws OSCException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    Method m = getMethod(namespace);
    var functionParams = m.getParameterTypes();
    if(m.getParameterCount() != params.length){
      throw new OSCException("Invalid argument count for calling function: %s".formatted(m.getName()));
    }

    var typedClass = m.getDeclaringClass().getDeclaredConstructor();
    for(int i = 0; i < functionParams.length; ++i){
      Object obj = params[i];
      Class<?> type = functionParams[i];
      if(obj != null && !type.isAssignableFrom(obj.getClass())){
        throw new OSCException("Invalid argument at Index: %i".formatted(i));
      }
    }

    var args = new ArrayList<Object>();
    for(int i = 0; i < functionParams.length; ++i){
      Object obj = params[i];
      args.add(obj);
    }

    m.invoke(typedClass.newInstance(), args.toArray());
  }
}
