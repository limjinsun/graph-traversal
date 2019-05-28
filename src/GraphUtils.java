import java.util.*;

public class GraphUtils {

    private Map<Vertex, Map<Vertex, Integer>> irishRailStationsInfoMap;

    public GraphUtils(HashMap map){
        this.irishRailStationsInfoMap = map;
    }

    // Since "getNumberOfTripsMaxHop" method is recursive, this should be global variable. - Depth First Search
    private ArrayList<String> routes = new ArrayList<>();


    // Return boolean value if two vertexes Connected.
    public boolean isConnected(Vertex source, Vertex destination) {
        if (irishRailStationsInfoMap.containsKey(source)) {
            return irishRailStationsInfoMap.get(source).containsKey(destination);
        } else {
            return false;
        }
    }



    // Get distance of two vertex(station). If there is no route, -1 return.
    public int getDistanceOfVT (Vertex source, Vertex destination) {
        int result = 0;
        if (isConnected(source, destination)) {
            result = irishRailStationsInfoMap.get(source).get(destination);
        } else {
            result = -1; // There is no route.- edge case
        }
        return result;
    }



    // Take String input as "A-D-C", return distances. If no route, "No such a route" return.
    public String getDistanceOfROUTE (String str) {
        // Input validation. "A-B-C" format only allowed.
        if (!str.matches("\\b[^\\d\\W]+(\\-\\b[^\\d\\W]+)+\\b")) {
            return "Process Fail! Try again with right input format...";
        }

        String[] strArray = str.toUpperCase().split("-");
        int arrayLength = strArray.length;

        int result = 0;

        for (int i = 0; i < arrayLength - 1; i++) {
            Vertex v1 = new Vertex(strArray[i]);
            Vertex v2 = new Vertex(strArray[i + 1]);

            if (getDistanceOfVT(v1, v2) != -1) { // If result is '-1' then, There is no route.
                result += getDistanceOfVT(v1, v2);
            } else {
                return "No such a route";
            }
        }
        return String.valueOf(result);
    }



    // Take 2 vertexes and Maximum number of hop as integer, Return How many routes possible. DFS used.
    public int getNumberOfTripsMaxHop(Vertex start, Vertex end, LinkedList<Vertex> visited, int maximumHop) {

        Vertex temp = start;
        if(visited.size() < 1){
            routes.clear();
            visited.add(temp); // Add it, only when method provoked very first time.
        }

        // Populate current vertex's neighbor into the list.
        List<Vertex> nextStopList = new LinkedList<>();
        irishRailStationsInfoMap.get(temp).entrySet().forEach(e -> nextStopList.add(e.getKey()));

        // Repeat till every vertex visited. using recursive.
        for (Vertex v : nextStopList) {
        	
            if(!visited.contains(v) && visited.size() < maximumHop + 1) { // not allow to visit to visited vertex.
                visited.add(v);
                getNumberOfTripsMaxHop(v, end, visited, maximumHop); // recursive
                visited.removeLast(); // important* - removing vertex -> to make it visit previous options in the nextStopList.
            }

            /*  Filtering selected paths.
                condition 1. Current vertex should be same to END vertex.
                condition 2. Travel count should not exceed maximum number of hops. */
            if (v.equals(end) && visited.size() < maximumHop + 1){
                LinkedList<Vertex> temporaryList = new LinkedList<>();
                temporaryList.addAll(visited); // Adding whole path from visited list.
                temporaryList.addLast(v); // Add last stop - which is current vertex.
                routes.add(temporaryList.toString()); // Store in global variable.
                printList(temporaryList);
            }
        }
        return routes.size();
    }



    // Almost identical with getNumberOfTripsMaxHop(), if( condition ) is different.
    public int getNumberOfTripExactHop(Vertex start, Vertex end, LinkedList<Vertex> visited, int exactHob) {

        Vertex temp = start;
        if(visited.size() < 1){
            routes.clear();
            visited.add(temp); // Add it, only when method provoked very first time.
        }

        List<Vertex> nextStopList = new LinkedList<>();
        irishRailStationsInfoMap.get(temp).entrySet().forEach(e -> nextStopList.add(e.getKey()));

        for (Vertex v : nextStopList) {

            if (visited.size() < exactHob) { // Limiting the size of list - preventing stack overflow.
                visited.add(v);
                getNumberOfTripExactHop(v, end, visited, exactHob); // recursive
                visited.removeLast(); // important* - removing vertex from visited list -> to make it visit previous options.
            }

            if (v.equals(end) && visited.size() == exactHob){ // Hop has to be match.
                LinkedList<Vertex> temporaryList = new LinkedList<>();
                temporaryList.addAll(visited); // Adding whole path from visited list.
                temporaryList.addLast(v); // Add last stop - which is current vertex.
                routes.add(temporaryList.toString());
                printList(temporaryList);
            }
        }
        return routes.size();
    }


    
    // Getting shortest path between to Vertex.
    // Dijkstra’s – Shortest Path Algorithm Used. - https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
    public String getShortestPath(Vertex start, Vertex end) {

        // populate result map with every Vertexes.
        HashMap<Vertex, Integer> dijkstraMap = new HashMap<>();
        irishRailStationsInfoMap.entrySet().stream().forEach(e -> dijkstraMap.put(e.getKey(), Integer.MAX_VALUE));

        Comparator<Vertex> dijkstraSorter = Comparator.comparing(Vertex::getDijkstraValue);
        PriorityQueue que = new PriorityQueue( dijkstraSorter );

        HashSet<Vertex> bin = new HashSet<>();

        // Start vertex's value set to 0.
        Vertex temp = start;
        dijkstraMap.put(temp, 0);

        temp.dijkstraValue = 0;
        que.add(temp);

        List<Vertex> nextStopList = new ArrayList<Vertex>();

        // Repeat it till every vertex will be effected.
        while (bin.size() != irishRailStationsInfoMap.size()){
            nextStopList.clear();
            // Get Adjacency stop of current vertex. store into List.
            irishRailStationsInfoMap.get(temp).entrySet().forEach(e -> nextStopList.add(e.getKey()));

            for(Vertex v : nextStopList){
                // Change value for shortest path, according to Dijkstra’s algorithm. - https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
                if (dijkstraMap.get(v) > dijkstraMap.get(temp) + getDistanceOfVT(temp,v) && getDistanceOfVT(temp,v) != -1 && !bin.contains(v)){
                    dijkstraMap.put(v,dijkstraMap.get(temp) + getDistanceOfVT(temp,v));
                    v.dijkstraValue = dijkstraMap.get(temp) + getDistanceOfVT(temp,v);
                    que.add(v);
                // If vertex is temp (== Start vertex) (dijkstraMap.put(temp, 0)), Force to get distance of multiple trip (if possible) 
                } else if (dijkstraMap.get(v) == 0){ 
                    dijkstraMap.put(v,dijkstraMap.get(temp) + getDistanceOfVT(temp,v));
                    v.dijkstraValue = dijkstraMap.get(temp) + getDistanceOfVT(temp,v);
                }
            }
            temp = (Vertex) que.poll(); // one pitfall. Sometimes que will be incidentally empty. so I worked around with HashMap
            bin.add(temp);
        }
        dijkstraMap.entrySet().stream().forEach(e -> System.out.println("FROM " + start.toString() + " as a starting point, " + e.getKey().toString() + "'s shortest route is : " + e.getValue()));

        if(dijkstraMap.get(end) == 2147483647){
            // Integer.MAX value
            return "There is no route to the destination. sorry..";
        }
        return dijkstraMap.get(end).toString();

    }

    
    private HashSet<String> routeSet = new HashSet<>();
    
	// Get Number of EveryTrip 
    public int getNumberOfEveryTrip (Vertex start, Vertex end, LinkedList<Vertex> visited, int maximumCost) {
        Vertex temp = start;

        if(visited.size() == 0){
            visited.add(temp);
        }

        LinkedList<Vertex> nextStopList = new LinkedList<>();
        irishRailStationsInfoMap.get(temp).entrySet().stream().forEach(e -> nextStopList.add(e.getKey()));

        for (Vertex v : nextStopList){
        	
        	// Limited trip to 20 hops, can't be infinite. 
            	if(visited.size() < 20) {
            		visited.add(v);
                getNumberOfEveryTrip(v, end, visited, maximumCost);
                visited.removeLast();
            	}
            	
            	// If last vertex is matched with 'End' and not a 'Start' vertex.
            	if (visited.size() > 1 && visited.getLast().equals(end)) {
                int totalCost = 0;
            		for (int x = 0; x < visited.size() - 1 ; x++) {
            			totalCost += getDistanceOfVT(visited.get(x),visited.get(x+1));
            		}
            		if (totalCost < maximumCost) { 
            			if(routeSet.add(visited.toString())) {
            				printList(visited);
            			};
            		}
            }
        }
        
        return routeSet.size();
    }
    
    
    
    
    /*****************/
    // helper method.
    void printList (LinkedList<Vertex> list)  {
        for(Vertex v : list) {
            System.out.print(v.station + " ");
        }
        System.out.println();
    }



	public HashSet<String> getRouteSet() {
		return routeSet;
	}
   

}
