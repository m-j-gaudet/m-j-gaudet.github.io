package neuralnet;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */

/**
 * @author Mitchell Gaudet
 *
 */


	/**
	 * 
	 */
	public class WDGraph {
		static class Edge{
			int src, dest;
			double weight;
			Edge(int src, int dest, double weight){
				this.src = src;
				this.dest=dest;
				this.weight=weight;
			}
		};
		static class Node{
			int value;
			double weight;
			Node(int value, double weight){
				this.value=value;
				this.weight=weight;
			}
		};
		List<List<Node>> adj = new ArrayList<>();
		
			WDGraph(List<Edge> edges) {
			for(int i =0; i<edges.size();i++) {
				adj.add(i, new ArrayList<Node>());
			}
			for(Edge e:edges) {
				adj.get(e.src).add(new Node(e.dest, e.weight));
			}
		}
		static void PrintGraph(WDGraph graph) {
			int src=0;
			int n= graph.adj.size();
			while(src<n) {
				for(Node edge: graph.adj.get(src)) {
					System.out.print(src+"-->"+edge.value+"("+edge.weight+")");
				}
				System.out.println("");
				src++;
			}

		}

	}


