package input;

import java.util.HashMap;

public interface InputInterface {

	String getS();
	String getG();
	String getUnrootedG();
	HashMap<String,String> getMapping();
	boolean hasNext();
	

	
	
}
