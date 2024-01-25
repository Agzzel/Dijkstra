import java.util.*;

public class Graph {
    private final Set<Node> nodes = new HashSet<>();

    public void add(Node node) {
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public static Graph dijkstra(Graph graph, Node startNode){
        startNode.setDistance(0);
        Set<Node> visited = new HashSet<>();
        Set<Node> unvisited = new HashSet<>();

        unvisited.add(startNode);

        while(unvisited.size() != 0){// så länge det finns obesökta noder
            Node currentNode = getNodeWithLowestDistance(unvisited);
            unvisited.remove(currentNode);

            //för varje granne (nod med vikt) till current
            for(Map.Entry<Node,Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()){
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                if(!visited.contains(adjacentNode)){
                    calculateDistance(adjacentNode,edgeWeight,currentNode);
                    unvisited.add(adjacentNode);
                    //denna grann-nod läggs in i unvisited och kommer besökas senare
                }
            }
            visited.add(currentNode);
        }
        return graph;
    }

    private static Node getNodeWithLowestDistance(Set<Node> unvisitedNodes){
        Node lowestDistanceNode = null; // noden med den lägsta distansen från start är okänd
        int lowestDistance = Integer.MAX_VALUE;
        for(Node n : unvisitedNodes){
            int nodeDistance = n.getDistance();
            if(nodeDistance < lowestDistance){
                lowestDistance = nodeDistance;
                lowestDistanceNode = n;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode){
        Integer sourceDistance = sourceNode.getDistance();
        if(sourceDistance + edgeWeight < evaluationNode.getDistance()){
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}