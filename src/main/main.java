package main;
// This arose as part of my solution to showing that if del u = -u^5  then u is bounded
import java.util.Scanner;
public class main {

 public static void main(String[] args) {
      System.out.println("Holder? Y/N"); // Do you want to check if the function is holder continuous?
      boolean Holder = false;
     Scanner scanner = new Scanner(System.in);
     Holder = scanner.nextBoolean();
     System.out.println("Critical exponent?"); // Is the exponent critical?
     boolean Crit = scanner.nextBoolean();
     if (Holder == true){
     System.out.println("Input sobolev spaces: k,p");
     int Sin1 = scanner.nextInt();
     double  Sin2 = scanner.nextDouble();
     System.out.println("Dimension:"); // Dimension of source space/domain
     int Dim = scanner.nextInt();
     if (Sin1*Sin2>Dim){
     System.out.println("True");
     }
     else{
     System.out.println("False");  
     }

     }
     else if (Crit== false){
     System.out.println("Is the domain bounded: Y/N"); // If the function is defined in a bounded domain then it could be in more sobolev spaces thanks to Holder's inequality
     boolean domain = scanner.nextBoolean();
     System.out.println("Input sobolev spaces: k,p");
     int Sin1 = scanner.nextInt();
     double  Sin2 = scanner.nextDouble();
     System.out.println("Output sobolev spaces: k,p");
     int Sout1 = scanner.nextInt();
     double  Sout2 = scanner.nextDouble();
     System.out.println("Dimension:");
     int Dim = scanner.nextInt();
     if (domain == true && 1/Sin2-Sin1/Dim<1/Sout2-Sout1/Dim)  {
                 System.out.println("True");
     }
             else{
     System.out.println("False");  
     }
     }
     else{
          System.out.println("Input sobolev spaces: k,p");
     int Sin1 = scanner.nextInt();
     double  Sin2 = scanner.nextDouble();
     System.out.println("Output sobolev differentiability: k");
     int Sout1 = scanner.nextInt();
     System.out.println("Dimension:");
     int Dim = scanner.nextInt();
     double intermediate1 = Sout1-Sin1;
     double intermediate2 = intermediate1/Dim;
     double intermediate3 = 1/Sin2;
     double intermediate4 = intermediate3+intermediate2/Dim;
     double last = 1/intermediate4;
     System.out.println(last);
     
     
     System.out.println("Bootstrap? true/false"); // Can you use an elliptic bootstrap method to get regularity, only works for less than critical exponent.
     boolean elliptic = scanner.nextBoolean();
     if (elliptic == true) {
         System.out.println("Exponent");
         Double exponent = scanner.nextDouble();
         if(last>Sin2*exponent) {
        	 System.out.println("true");
         }
         else {
             System.out.println("failed");
         }
     }
     }
     

 }
}

