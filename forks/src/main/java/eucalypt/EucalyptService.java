package eucalypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import structures.RootedTree;

public class EucalyptService {
	
	private static String PATH="C:\\Users\\Daniele\\Desktop\\daniele\\documenti\\biologia";
	
	private static int i=0;
	
	private static String inputNameToRun;

	public static float getOptimumReconciliationWeight(RootedTree S, RootedTree G) throws IOException {
		
		generateInputFile(S,G);
		
		float cost = runEucalypt();
				
		return cost;
	}

	

	private static float runEucalypt() throws IOException {
		
		// Run a java app in a separate system process
		Process proc = Runtime.getRuntime().exec("java -jar "+PATH+"\\Eucalypt-1.0.4\\Eucalypt.jar -i "+PATH+"\\"+inputNameToRun+" -task 1 -cc 0 -cd 1 -ch 3 -cl 2 -j 2");
		
		// Then retreive the process output
		InputStream in = proc.getInputStream();
		
		String outputConsole="";
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			outputConsole= br.lines().collect(Collectors.joining(System.lineSeparator()));
		} 
		
		InputStream err = proc.getErrorStream();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(err))) {
			String errore=br.lines().collect(Collectors.joining(System.lineSeparator()));
			if (!errore.isEmpty()) {
				System.out.println("ERRORE: "+errore);
				throw(new RuntimeException());
			}
		}
		
		int indexOfOptimumCost= outputConsole.indexOf("Optimum cost");
		int indexOfOptimumCostEndLine= outputConsole.substring(indexOfOptimumCost).indexOf("\r");
		
		String costString= outputConsole.substring(indexOfOptimumCost+15, indexOfOptimumCost+indexOfOptimumCostEndLine);
		
		return Float.parseFloat(costString);
		
	}

	private static void generateInputFile(RootedTree S,RootedTree G) throws IOException {
		
		String toWrite = "#NEXUS\n";
		toWrite=toWrite+"BEGIN HOST;\n";
		toWrite=toWrite+"	TREE * Host = ";
		toWrite=toWrite+S.getDescription(S.getRoot())+";\n";
		toWrite=toWrite+"ENDBLOCK;\n";
		toWrite=toWrite+"\n";
		toWrite=toWrite+"BEGIN PARASITE;\n";
		toWrite=toWrite+"	TREE * Parasite = "+G.getDescription(G.getRoot())+";\n";
		toWrite=toWrite+"ENDBLOCK;\n";
		toWrite=toWrite+"\n";
		toWrite=toWrite+"BEGIN DISTRIBUTION;\n";
		toWrite=toWrite+"	RANGE\n";
		toWrite=toWrite+getMappingDescription(G)+"\n	;\n";
		toWrite=toWrite+"END;";
		
		inputNameToRun="input"+(++i);
		
	    Path path = Paths.get(PATH+"\\"+inputNameToRun);
	    
	    byte[] strToBytes = toWrite.getBytes();
	 
	    Files.write(path, strToBytes);
	 
		
		
		
	}

	private static String getMappingDescription(RootedTree G) {
		
		String toReturn="";
		
		for (String key: G.getMappingDescription().keySet()) {
			toReturn=toReturn+"		"+key+": "+ G.getMappingDescription().get(key)+",\n";
		}
		
		//tolgo la virgola finale
		toReturn=toReturn.substring(0,toReturn.length()-2);
		
		return toReturn;
	}

	

}
