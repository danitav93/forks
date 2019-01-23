package structures;

import java.util.HashMap;

public class UnRootedTree {

	//albero radicato al quale poi appendiamo il nodo da appendere per ottenere il non radicato (come da format input)
	private RootedTree firstG;
	

	public UnRootedTree(String unrootedG, HashMap<String, String> mapping) {

		firstG=new RootedTree(unrootedG, mapping);
	
	}

	

	public RootedTree getFirstG() {
		return firstG;
	}

	

}
