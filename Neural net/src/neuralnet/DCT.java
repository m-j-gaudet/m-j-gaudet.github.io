package neuralnet;
import java.util.*;
public class DCT {
	int size;
	double TransMat[][];
	public DCT(int size) {
		this.size= size;
		TransMat = new double[size][size];
		TransMat=compute(size);
	}
	
	public double[] apply(double[] invec) {
		double[] outvec = new double[size];
		Arrays.fill(outvec, 0);
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				outvec[i]=+invec[j]*TransMat[i][j];
			}
		}
		return outvec;
		
	}
	
	public void output() {
		for(int i = 0; i<size; i++) {
			System.out.println();
			for(int j = 0; j<size; j++) {
				System.out.print(TransMat[i][j]+"\t");
			}
		}
		System.out.println();
	}
	 double[][] compute(int size){
		double[][] Temp = new double[size][size];
		double scale = Math.PI/size;
		double n = 0;
		double k  = 0;
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				n=i;
				k=j+0.5;
				Temp[i][j]=Math.cos(scale*n*k);
			}
		}
		return Temp;
	}
}
