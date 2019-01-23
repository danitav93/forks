package forks;

import input.InputInterface;
import input.ParameterInterface;
import input.SimpleInput;
import input.SimpleParameter;
import output.OutputInterface;
import output.SimpleOutput;
import structures.RootedTree;
import structures.UnRootedTree;
import utility.Methods;

public class MainUnrooted {
	
	static RootedTree G;
	static RootedTree S;
	static InputInterface input= new SimpleInput();
	static OutputInterface output= new SimpleOutput();

	static ParameterInterface parameters= new SimpleParameter();
	
	public static void main(String[] args) {

		UnRootedTree G= new UnRootedTree(input.getUnrootedG(),input.getMapping());

		S= new RootedTree(input.getS(),input.getMapping());
		
		RootedTree GFirst= G.getFirstG();

		Methods.setForks(GFirst,S);

		Methods.setTops(GFirst);
		
		Methods.generateMapping(GFirst, S, parameters);
				
		Methods.walk(G);
		
		output.printUnrooted(G);
		
		
	}
}
