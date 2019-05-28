import java.util.*;

public class Graph {

    /**
     *  HashMap is used for the basic data structure for this assessment.
     *  Every Vertex are stored as "Key", "Value" is another 'Map' format in which stored it's adjacency Vertexes and it's weights of the edge.
     */
    private final Map<Vertex, Map<Vertex, Integer>> irishRailStationsInfoMap = new HashMap<>();

    public Map<Vertex, Map<Vertex, Integer>> getIrishRailStationsInfoMap() {
        return irishRailStationsInfoMap;
    }

    public Graph() {
        // empty constructor.
    }

    public void addStation(Vertex station) {
        irishRailStationsInfoMap.putIfAbsent(station, new HashMap<>());
    }

    public void removeStation(Vertex station) {
        irishRailStationsInfoMap.remove(station);
        irishRailStationsInfoMap.values().stream().forEach(map -> map.remove(station));
    }

    public void addWeightedEdge(Vertex source, Vertex destination, int distance) {
        irishRailStationsInfoMap.get(source).put(destination, distance);
    }

    public void removeWeightedEdge(Vertex source, Vertex destination) {
        irishRailStationsInfoMap.get(source).remove(destination);
    }
    
}