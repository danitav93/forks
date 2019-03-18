package forks;

import java.util.Scanner;

import input.InputInterface;
import input.ParameterInterface;
import input.SimpleParameter;
import input.nPlateausInput;
import output.GraphOutput;
import output.OutputInterface;
import structures.RootedTree;
import structures.UnRootedTree;
import utility.Methods;

public class MainUnrooted {
	
	static RootedTree G;
	static RootedTree S;
	//static InputInterface input= new SimpleInput();
	static InputInterface input;
	//static OutputInterface output= new SimpleOutput();
	static OutputInterface output= new GraphOutput();

	static ParameterInterface parameters= new SimpleParameter();
	
	public static void main(String[] args) {
		
		System.out.println("Numero di plateaus: ");
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		long startTime = System.currentTimeMillis();
		
		input = new nPlateausInput(n);

		UnRootedTree G= new UnRootedTree(input.getUnrootedG(),input.getMapping());

		S= new RootedTree(input.getS(),input.getMapping());
		
		RootedTree GFirst= G.getFirstG();

		Methods.setForks(GFirst,S);

		Methods.setTops(GFirst);
		
		Methods.generateMapping(GFirst, parameters);
				
		Methods.walk(G,S);
		
		output.printUnrooted(G);
		
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("tempo di esecuzione: "+elapsedTime/1000+"s");
		
		
	}
}
