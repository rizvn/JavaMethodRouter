Java Method Router
================

A simple method routing library for java using reflection


###Usage
Create a graph by extending the Graph class.
Each method in child class can be used to represent a node in the graph.

     public class GraphDemo extends Graph {...}

Each node in the graph can be represented by a method which returns an instance of Result. The method are just ordinary java methods so you can code any logic in here.

    public Result node_01(){
        //do some stuff here
        return new Result(1);
    };

    public Result node_02(){
        if(something){
          return new Result(1);
        }
        else if(something else){
          return new Result(2, "Some message");
        }
        else{
          //error condition
          return new Result(-2, "some error has occurred");
        }
    };

Connect the nodes using method names using a json array. Below means run node_01 and if output (result) is 1 then run node_02. **If no path with output is specified the graph will end.**

    Graph graph = new GraphDemo(); //create an instance
    JSONArray jsonArray = new JSONArray("[{node: 'node_01', output:1, next:'node_02' }]");
    graph.setPaths(jsonArray);

Alternatively connect the nodes using a map

    Graph graph = new GraphDemo()
    Map<MultiKey, String> paths = new HashMap<MultiKey, String>();
    paths.put(new MultiKey("node_01", 1), "node_02");
    paths.put(new MultiKey("node_02", 1), "node_03");
    paths.put(new MultiKey("node_03", 0), "node_04");
    paths.put(new MultiKey("node_01", 0), "node_04");
    paths.put(new MultiKey("node_02", 0), "node_04");
    paths.put(new MultiKey("node_04", 1), "node_05");
    graph.setPaths(paths);

Once the graph has run you can see the paths taken though:

    graph.getPathTaken())


####Annotated Graph
If you don't want to use method names as node names there is also an **AnnotatedGraph that can be used**. This implementation allows you to use any method name as long as its is annotated by @Node with the correct name. The configuration of paths for this graph is the same as above.

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


> See the Demos package and Tests for examples
