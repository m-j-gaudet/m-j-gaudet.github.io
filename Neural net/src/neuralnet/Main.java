package neuralnet;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		/*

		 // This generates neural network of width width and length length with inN inputs and one output neuron
		int width=3;
		int length=5;
		int inN=2;
		int outN=1;//higher orders being implemented in time
		int Nnodes=width*length+inN+outN;
		NN NN= new NN(width*length,true,true,width,inN,outN);
		for(int i=0; i<inN;i++)
		for(int j =1; j<width+1;j++) {
	        NN.addEdge(i, j+inN-1,1);
		}
		for(int i =1; i<length;i++) {
			for(int j =1; j<width+1;j++) {
				for(int k =1; k<width+1;k++) {
			        NN.addEdge(k+(i-1)*(width)+inN-1, j+i*width+inN-1, Math.random());

				}
			}
		}
		for(int i=0; i<outN;i++)
		for(int j =1; j<width+1;j++) {
	        NN.addEdge(j+width*(length-1)+inN-1, width*length+i+inN, Math.random());
		}
		NN.printMatrix();
		double[] input1 = {1,1};
		double[] input2 = {0,0};
		double[] input3 = {1,0};
		double[] input4 = {0,1};
		NN.calculate(input2);
		System.out.println("Output:  "+NN.output());
		gradientdescent.GradientDescent(0, NN, input3);
		gradientdescent.GradientDescent(0.73, NN, input1);
			//gradientdescent.GradientDescent(1, NN, input3);
		//gradientdescent.GradientDescent(0.75, NN, input4);

		System.out.println(NN.output());
		NN.calculate(input1);
		System.out.println(NN.output());
		NN.calculate(input1);
		System.out.println(NN.output());
		NN.calculate(input3);
		System.out.println(NN.output());
		NN.printMatrix();



		*/
		
	/*	DCT a = new DCT(2);
		a.output();
		double[] invec = {1,2};
		double[] outvec = a.apply(invec);
		for(int i = 0; i<2; i++) 
			System.out.println(outvec[i]); */

}
}