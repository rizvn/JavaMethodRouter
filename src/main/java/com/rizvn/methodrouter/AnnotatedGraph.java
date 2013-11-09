package com.rizvn.methodrouter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author Riz
 */
public abstract class AnnotatedGraph extends Graph {

  @Override
  protected Method findMethodByName(String aMethodName){
    if(mMethodMap == null){
      mMethodMap = new HashMap<String, Method>();
      Method[] methods = this.getClass().getDeclaredMethods();

      for(int i=0; i<methods.length; i++){
        Method method = methods[i];

        if(method.isAnnotationPresent(Node.class))
        {
          Node node = getNodeAnnotation(method);
          mMethodMap.put(node.value(), method);
        }
      }
    }
    return mMethodMap.get(aMethodName);
  };

  private Node getNodeAnnotation(Method aMethod){
    Annotation[] annotations = aMethod.getDeclaredAnnotations();
    for(int i=0; i<annotations.length; i++){
      if(annotations[i] instanceof Node){
        return (Node) annotations[i];
      }
    }
    return null;
  };

}
