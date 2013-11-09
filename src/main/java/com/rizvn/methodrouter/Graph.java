package com.rizvn.methodrouter;

import org.apache.commons.collections.keyvalue.MultiKey;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Riz
 */
public abstract class Graph {

  protected String mStart = "node_01";
  protected Map<MultiKey, String> mPaths = new HashMap<MultiKey, String>();
  protected Map<String, Method> mMethodMap;
  List<String> mPathTaken = new ArrayList<String>();

  protected Method findMethodByName(String aMethodName){
    if(mMethodMap == null){
      mMethodMap = new HashMap<String, Method>();
      Method[] methods = this.getClass().getDeclaredMethods();
      for(int i=0; i<methods.length; i++){
        Method method = methods[i];
        mMethodMap.put(method.getName(), method);
      }
    }
    return mMethodMap.get(aMethodName);
  };

  protected String getNextMethodName(String aCurrentMethod, Integer aOutput){
    return mPaths.get(new MultiKey(aCurrentMethod, aOutput));
  }

  public void run(){
     try {
       String node = mStart;
       while(node != null){
           Method method = findMethodByName(node);
           Result result = (Result) method.invoke(this);

           String ranNode = node;
           node = getNextMethodName(node, result.getCode());
           mPathTaken.add("Ran: "+ ranNode +" result: "+ result.getCode() +" next: "+node);
       }
     }
     catch (Exception e) {
       e.printStackTrace();
     }
  }

  public void setStart(String aStartNode){
       mStart = aStartNode;
  }

  public void setPaths(Map<MultiKey, String> aPaths) {
    mPaths = aPaths;
  }

  public void setPaths(JSONArray aJSONArray){
    Map<MultiKey, String> aPaths = new HashMap<MultiKey, String>();
    for(int i=0; i<aJSONArray.length(); i++){
      JSONObject definition = aJSONArray.getJSONObject(i);
      String nodeName = definition.getString("node");
      Integer output = definition.getInt("output");
      String next = definition.getString("next");
      aPaths.put(new MultiKey(nodeName, output), next);
    }
    mPaths = aPaths;
  }

  public List<String> getPathTaken() {
    return mPathTaken;
  }
}
