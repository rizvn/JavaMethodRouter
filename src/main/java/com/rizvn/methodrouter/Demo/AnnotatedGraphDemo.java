package com.rizvn.methodrouter.Demo;

import com.rizvn.methodrouter.AnnotatedGraph;
import com.rizvn.methodrouter.Node;
import com.rizvn.methodrouter.Result;

/**
 * @author Riz
 */
public class AnnotatedGraphDemo extends AnnotatedGraph {

  @Node("node_01")
  public Result method1(){
    return new Result(1);
  };

  @Node("node_02")
  public Result method2(){
    return new Result(0);
  };

  @Node("node_03")
  public Result method3(){
    return new Result(0);
  };

  @Node("node_04")
  public Result method4(){
    return new Result(0);
  };

  @Node("node_05")
  public Result method5(){
    return new Result(0);
  };
}
