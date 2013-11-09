package com.rizvn.methodrouter.Demo;

import com.rizvn.methodrouter.Graph;
import com.rizvn.methodrouter.Result;

/**
 * @author Riz
 */
public class GraphDemo extends Graph {
  public Result node_01(){
    return new Result(1);
  };

  public Result node_02(){
    return new Result(1);
  };

  public Result node_03(){
    return new Result(0);
  };

  public Result node_04(){
    return new Result(0);
  };

  public Result node_05(){
    return new Result(1);
  };


}
