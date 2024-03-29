/*
A class for the nodes that are used in the graph. There is no class for edges, instead each
node has a hashmap containing its neighbours.
 */
import java.util.*;

public class Node {
    private final String name;

    private List<Node> shortestPath = new LinkedList<>();
    //the shortest path from the start to each node
    private Integer distance = Integer.MAX_VALUE;
    //the distance from the source to each node is initially unknown,
    //so every node has a distance of infinity at the start.
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }

    public void addDestination(Node destination, int distance){
        adjacentNodes.put(destination,distance);
        //adds a neighbour to this node
    }

    public Integer getDistance(){
        return distance;
    }

    public void setDistance(Integer newDistance){
        this.distance = newDistance;
    }

    public List<Node> getShortestPath(){
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> newShortestPath){
        this.shortestPath = newShortestPath;
    }

    public Map<Node, Integer> getAdjacentNodes(){
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> newAdjacentNodes) {
        this.adjacentNodes = newAdjacentNodes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
