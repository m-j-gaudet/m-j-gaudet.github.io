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
		int n = 11;
		int M =0;
		int N = 0;

		double l = Math.pow(Math.log(n), 3);
		int a = (int) Math.ceil(n/l);

		M=(int) (2*Math.ceil(n/l));
		double L = Math.log(2*Math.E*M);
		double b = Math.log(10);
		int c = (n+3);
		double d = c*b;
		int e = (int) Math.ceil(d/L);
		N= e;
		System.out.println(M);
		double B = Bpi(n,M,N);
		double C = Cpi(n,M,N);
		System.out.println(B-C-Math.floor(B-C));
		
	}
	public static double Bpi(int n, int M, int N) {
		int a = (int) (4* Math.pow(10, n));
		double b = 0;
		double c = 0;
		double B = 0;
		int m = (M+1);
		int p = 0;
		double x1 = 0;
		for(int i=0; i<m*N; i++) {
			p=2*i+1;
			x1=a%p;

			b=Math.pow(-1,i)*x1;
			c=b/p;
			B=B+c;
		}
		return B;
	}
	public static double Cpi(int n, int M, int N) {
		double C = 0;
		int a = 0;
		double b = 0;
		double x2 = 0;
		double c = 0;
		double B = 0;
		int p = 0;
		int sign = 0;
		double q =0;
		int e = (int) Math.floor(N);
		double y = 0;
		double x1 = 0;
		for(int i=0; i<N; i++) {
			q= 2*M*N+2*i+1;
			//System.out.println(i);
			for(int j=0; j<i; j++) {
				a= 4*choose(e, j);

				b=a%(q);
				x2=x2+b;
			}
			a= (int) Math.pow(5, N-2);
			b= Math.pow(10, n-N+2);
			c=a*b*x2;
			y=c%(q);
			sign = (int) Math.pow(-1,i);
			x1= sign*y/(q);
			C=C+x1;
		}
		return C;
	}
	public static int choose(int total, int choose){
	    if(total < choose)
	        return 0;
	    if(choose == 0 || choose == total)
	        return 1;
	    return choose(total-1,choose-1)+choose(total-1,choose);
	}
}
