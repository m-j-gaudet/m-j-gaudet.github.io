package neuralnet;

import java.util.Arrays;

public class Matrices {

 static double[] applyoperator(double[][] T, double[] x) {
	 double[] z= new double[T.length] ;
		Arrays.fill(z, 0);
	 for(int i=0; i<T.length;i++) {
		 for(int j=0; j<T.length;j++) {
			 z[i]=z[i]+T[i][j]*x[j];
		 }
	 }
	 return z;
 }
 static double applyoperator(double[][] T, double x, int index) {
	 double[] z= new double[T.length] ;
		Arrays.fill(z, 0);
		z[index-1]=x;
		double[] y= applyoperator(T,z);
		return y[index-1];
 }
 static double[] hammard(double[] x, double[] y) {
	 double[] z= new double[x.length] ;
	 for(int i=0; i<x.length;i++) {
			 z[i]=x[i]*y[i];
	 }
		return z;
 }
 static double[] vectdiff(double[] x, double[] y) {
	 double[] z= new double[x.length] ;
	 for(int i=0; i<x.length;i++) {
			 z[i]=x[i]-y[i];
	 }
		return z;
 }
 static double[] vectdiff(double[] x, double y) {
	 double[] z= new double[x.length] ;
	 for(int i=0; i<x.length;i++) {
			 z[i]=x[i]-y;
	 }
		return z;
 }
 static double[][] hammard(double[][] x, double[][] y) {
	 double[][] z= new double[x.length][x.length] ;
	 for(int i=0; i<x.length;i++) {
		 for(int j=0; j<x.length;j++) {
			 z[i][j]=x[i][j]*y[i][j];
		 }
	 }
		return z;
 }
 public static double[][] transpose(double [][] m){
     double[][] temp = new double[m[0].length][m.length];
     for (int i = 0; i < m.length; i++)
         for (int j = 0; j < m[0].length; j++)
             temp[j][i] = m[i][j];
     return temp;
 }
}
