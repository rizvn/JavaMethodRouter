package com.rizvn.methodrouter;

import com.rizvn.methodrouter.Demo.AnnotatedGraphDemo;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Riz
 */
public class AnnotatedGraphTest {

  @Test
  public void test_findMethodByName(){
    AnnotatedGraphDemo graph = new AnnotatedGraphDemo();
    Method method = graph.findMethodByName("node_01");
    Assert.assertNotNull(method);
  }

  @Test
  public void test_run(){
    AnnotatedGraphDemo graph = new AnnotatedGraphDemo();
    Map<MultiKey, String> paths = new HashMap<MultiKey, String>();
    paths.put(new MultiKey("node_01", 1), "node_02");
    paths.put(new MultiKey("node_02", 1), "node_03");
    paths.put(new MultiKey("node_03", 0), "node_04");
    paths.put(new MultiKey("node_01", 0), "node_04");
    paths.put(new MultiKey("node_02", 0), "node_04");
    paths.put(new MultiKey("node_04", 1), "node_05");

    graph.setPaths(paths);
    graph.setStart("node_01");

    graph.run();
    System.out.println(graph.getPathTaken());
  }
}
