package neuralnet;

public class gradientdescent {
	static NN NN;
	public static double error(double expected) {


	    return 0.5*Math.pow(expected-NN.output(), 2);
	}
	public static double errder(double expected) {


	    return expected-NN.output();
	}
	public static double sigdiff(int src) {


	    return NN.out[src]*(1-NN.out[src]);
	}
	public static void GradientDescent(double expected, neuralnet.NN nN2, double[] input) {
		NN=nN2;
		int length=(NN.Nnodes-NN.inN-NN.outN)/NN.width;
	
			
		double error1=error(expected);
		double error2=0;
		double step=0.1;
		double a =0;
		double b=0;
		double c=0;
		NN.calculate(input);
		double[][] temp= NN.adj;
		error1=error(expected);
		System.out.println("Error 1:  "+error1);
		double[] sigdif= new double[NN.Nnodes];
		for(int i=0;i<NN.Nnodes;i++)
		sigdif[i]=sigdiff(i);
		int k=0;
		while(error1>Math.pow(10, -7)|| k<100) {
			for(int i=NN.Nnodes-1; i>=0;i--) {
				for(int j=NN.Nnodes-1; i>=0;i--) {
					if(NN.N[i][j]) {
						NN.adj[i][j]=temp[i][j]+step*sigdif[j]*NN.out[i]*errder(expected);
						//System.out.println("Change(i,j):  "+NN.adj[i][j]+"("+i+","+j+")");
					}

				}

			}
			k++;
			NN.adj=temp;
			NN.calculate(input);
			error1=error(expected);
			//System.out.println("Error 2:  "+error1+"Error derivative:  "+errder(expected));
		}


		//System.out.println("Output:  "+NN.output());
		
	}
	
	//TODO: Multiple outputs
/*	public static void GradientDescent(double[] expected, neuralnet.NN nN2, double[] input) {
		NN=nN2;
		double[] error1= error(expected);
		double error2=0;
		double step=0.25;
		double a =0;
		double b=0;
		double c=0;
		double length=(NN.Nnodes-NN.inN-NN.outN)/NN.width;
	//	NN.calculate(input);
		System.out.println(NN.output());
		System.out.println("error: "+error(expected));
		for(int h=0;h<1000;h++)
		for(int j=0;j<length;j++)
		for(int i=0;i<NN.width;i++) {
			for(int k=0;k<NN.Nnodes;k++)
			if(NN.N[NN.Nnodes-(j+1)*(NN.width)+i-1][k]==true) {
				a=step*errder(expected);

				b=NN.adj[NN.Nnodes-(j+1)*(NN.width)+i-1][k]-a;
				c=NN.adj[NN.Nnodes-(j+1)*(NN.width)+i-1][k]+a;
				double d=NN.adj[NN.Nnodes-(j+1)*(NN.width)+i][k];
				NN.adj[NN.Nnodes-(j+1)*(NN.width)+i-1][k]=b;
				System.out.println("d: "+d);
				NN.calculate(input);
				System.out.println("error: "+error(expected));
				error2=error(expected);
				if(error2>=error1) {
					NN.adj[NN.Nnodes-(j+1)*(NN.width)+i-1][k]=c;
					System.out.println(":( "+d);
				}
				error1=error2;

			}
		}
		NN.calculate(input);
		
		
	}*/

}
