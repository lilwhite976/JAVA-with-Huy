package toanroirac;
import java.util.*;


	class Edge {
	    int source, dest, weight;
	    Edge(int source, int dest, int weight) {
	        this.source = source;
	        this.dest = dest;
	        this.weight = weight;
	    }
	}

	class Graph {
	    int vertices;
	    LinkedList<Edge>[] adjacencyList;

	    Graph(int vertices) {
	        this.vertices = vertices;
	        adjacencyList = new LinkedList[vertices];
	        for (int i = 0; i < vertices; i++)
	            adjacencyList[i] = new LinkedList<>();
	    }

	    void addEdge(int source, int dest, int weight) {
	        adjacencyList[source].add(new Edge(source, dest, weight));
	        adjacencyList[dest].add(new Edge(dest, source, weight)); // vì đồ thị vô hướng
	    }

	    void primMST() {
	        boolean[] visited = new boolean[vertices];
	        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
	        visited[0] = true;
	        pq.addAll(adjacencyList[0]);

	        List<Edge> mst = new ArrayList<>();

	        while (!pq.isEmpty()) {
	            Edge edge = pq.poll();
	            if (visited[edge.dest]) continue;

	            visited[edge.dest] = true;
	            mst.add(edge);
	            for (Edge nextEdge : adjacencyList[edge.dest]) {
	                if (!visited[nextEdge.dest])
	                    pq.add(nextEdge);
	            }
	        }

	        System.out.println("Cây khung nhỏ nhất:");
	        for (Edge e : mst)
	            System.out.println(e.source + " - " + e.dest + " : " + e.weight);
	    }
	}

	public class PrimAlgorithm {
	    public static void main(String[] args) {
	        Graph graph = new Graph(4);
	        graph.addEdge(0, 1, 10);
	        graph.addEdge(0, 2, 6);
	        graph.addEdge(0, 3, 5);
	        graph.addEdge(1, 3, 15);
	        graph.addEdge(2, 3, 4);

	        graph.primMST();
	    }
	}


