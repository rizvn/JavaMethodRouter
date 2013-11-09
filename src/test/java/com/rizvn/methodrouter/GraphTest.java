package com.rizvn.methodrouter;

import com.rizvn.methodrouter.Demo.GraphDemo;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Riz
 */
public class GraphTest {

  @Test
  public void test_findMethodByName(){
    Graph graph = new GraphDemo();
    Method method = graph.findMethodByName("node_01");
    Assert.assertNotNull(method);
  }

  @Test
  public void test_getNextMethod(){
    Graph graph = new GraphDemo();
    Map<MultiKey, String> paths = new HashMap<MultiKey, String>();
    paths.put(new MultiKey("node01", 1), "node02");
    paths.put(new MultiKey("node02", 1), "node03");

    graph.setPaths(paths);
    String result = graph.getNextMethodName("node01", 1);
    Assert.assertEquals("node02", result);
  }

  @Test
  public void test_getNextMethodJSON(){
    Graph graph = new GraphDemo();
    JSONArray jsonArray = new JSONArray("[{node: 'node_01', output:1, next:'node_02' }]");

    graph.setPaths(jsonArray);
    String result = graph.getNextMethodName("node_01", 1);
    Assert.assertEquals("node_02", result);
  }

  @Test
  public void test_run(){
    Graph graph = new GraphDemo();
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
