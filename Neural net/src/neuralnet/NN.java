package neuralnet;

import java.util.Arrays;

public class NN {
	int width;
	int Nnodes;
	int inN;
	int outN;
	boolean weighted;
	boolean directed;
	public static double[][] adj;
	public static double[] out;
	public static double[] in;
	public static boolean[][] N;
	//Defines the NN object as a graph and considers parameters such as is it weighted or directed
	public  NN(int Nnodes, boolean weighted, boolean directed, int width, int inN, int outN) {
	    this.directed = directed;
	    this.outN=outN;
	    this.inN=inN;
	    this.weighted = weighted;
	    this.Nnodes = Nnodes+inN+outN;
	    this.width=width;
		adj= new double[Nnodes+inN+outN] [Nnodes+inN+outN];
		out= new double[Nnodes+inN+outN];
		Arrays.fill(out, 0);
		in= new double[Nnodes+inN+outN];
		Arrays.fill(in, 0);
		N= new boolean[Nnodes+inN+outN] [Nnodes+inN+outN];
	}
	
	//Adds edge to adjacency matrix
	public void addEdge(int source, int destination) {

	    int valueToAdd = 1;

	    if (weighted) {
	        valueToAdd = 0;
	    }

	    adj[source][destination] = valueToAdd;
	    N[source][destination] = true;

	    if (!directed) {
	        adj[destination][source] = valueToAdd;
	        N[destination][source] = true;
	    }
	}
	
	//given input vector calculates output vector
	public void calculate(double[] input) {
		Arrays.fill(in, 0);
		Arrays.fill(out, 0);
		for(int k=0; k<inN; k++)
		out[k]=input[k];
		for(int k=1; k<width+1; k++) {
			for(int i=0; i<inN; i++)
							in[k]=in[k]+inCalc(i,k+inN);

							out[k]=outCalc(k);
			}



				for(int k=1; k<(Nnodes); k++) {
					for(int i=1; i<(Nnodes-2)/width+1; i++) {
						for(int j=1; j<width+1; j++) {

									in[k]=in[k]+inCalc(j+((width)*(i-1)),k);
					             //   System.out.println( "from Node"+(j+((width)*(i-1)) )+" to Node"+(k)+":"+inCalc(j+((width)*(i-1)),k));

					}


				}
					//System.out.println( "Node"+k+":"+in[k]);
					//System.out.println( "Node output "+k+":"+out[k]);
					out[k]=outCalc(k);
			}	

	}
	
	public double inCalc(int source, int destination) {
	    double valueToAdd = adj[source][destination]*out[source];

		if(N[source][destination])
		    return valueToAdd;
		else return 0;


	}
	public double sigdiff(int source) {
		//activation function derivative, probably don't use this, use methods in gradientdescent
			    double valueToAdd = outCalc(source)*(1-outCalc(source));


			    return valueToAdd;
			}
	public double[] sigdiffvec(double[] input) {
		//activation function derivative as a vector, probably don't use this, use methods in gradientdescent
			    double[] valueToAdd =new double[input.length];
			    for(int i = 1; i<input.length; i++) 
			    		valueToAdd[i]=1/(1+Math.exp(input[i]))*(1-1/(1+Math.exp(input[i])));


			    return valueToAdd;
			}
	public double outCalc(int source) {
//activation function
	    double valueToAdd = 1/(1+Math.exp(-in[source]));


	    return valueToAdd;
	}
	public double error(double expected) {


	    return expected-out[Nnodes-1];
	}
	public double output() {


			    return out[Nnodes-1];
			    
			}

	public void printEdges() {
	    for (int i = 0; i < Nnodes; i++) {
	        System.out.print("Node " + i + " is connected to: ");
	        for (int j = 0; j < Nnodes; j++) {
	            if (N[i][j]) {
	                System.out.print(j + " ");
	            }
	        }
	        System.out.println();
	    }
	}
	public void printVals() {
	    for (int i = 0; i < Nnodes; i++) {
	        System.out.print("Node " + i + " has value: ");
	                System.out.println(out[i] + " ");
	        }
	        System.out.println();
	    }
	public void printin() {
	    for (int i = 0; i < Nnodes; i++) {
	        System.out.print("Node " + i + " has value: ");
	                System.out.println(in[i] + " ");
	        }
	        System.out.println();
	    }
	public void printMatrix() {
	    for (int i = 0; i < Nnodes; i++) {
	        for (int j = 0; j < Nnodes; j++) {
	            // We only want to print the values of those positions that have been marked as set
	            if (N[i][j])
	                System.out.format("%8s", String.valueOf(adj[i][j]));
	            else System.out.format("%8s", "0 ");
	        }
	        System.out.println();
	    }
	}
	public void printbMatrix() {
	    for (int i = 0; i < Nnodes; i++) {
	        for (int j = 0; j < Nnodes; j++) {
	            // We only want to print the values of those positions that have been marked as set
	            if (N[i][j])
	                System.out.format("%8s", String.valueOf(1));
	            else System.out.format("%8s", "0 ");
	        }
	        System.out.println();
	    }
	}
	public void addEdge(int source, int destination, double weight) {

	    double valueToAdd = weight;

	    if (!weighted) {
	        valueToAdd = 1;
	    }

	    adj[source][destination] = valueToAdd;
	    N[source][destination] = true;

	    if (!directed) {
	        adj[destination][source] = valueToAdd;
	        N[destination][source] = true;
	    }
	}
	public boolean hasEdge(int source, int destination) {
	    return N[source][destination];
	}

	public double getEdgeValue(int source, int destination) {
	    if (!weighted || !N[source][destination])
	        return 0;
	    return adj[source][destination];
	}
}
