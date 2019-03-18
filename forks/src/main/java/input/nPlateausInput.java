package input;

import java.util.HashMap;

public class nPlateausInput implements InputInterface {

	private int nbrOfPlateaus;
	
	private int gadgetCount=4;
	
	public  nPlateausInput(int nbrOfPlateaus) {
		
		if (nbrOfPlateaus<2) {
			throw new RuntimeException("n must be at least 2");
		}
		
		this.nbrOfPlateaus=nbrOfPlateaus;	
		
		
	}
	
	@Override
	public String getS() {
		return "(B,(A,C)!H1)!H0";
	}

	@Override
	public String getG() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnrootedG() {
		
		if (nbrOfPlateaus==2) {
			String toReturn="((((";
			toReturn=toReturn+getNextGadget();
			toReturn=toReturn+",a3)!P3,a2)!P2,a1)!P1,b1)!P0";
			return toReturn;
			
		} else {
			gadgetCount++;
			String toReturn="(((((";
			toReturn=toReturn+recursion(nbrOfPlateaus-2);
			toReturn=toReturn+","+getNextGadget()+")!P4,a3)!P3,a2)!P2,a1)!P1,b1)!P0";
			return toReturn;
		}
	}
	
	private String recursion(int indexVariable) {
		
		if (indexVariable==1) {
			
			return getNextGadget();
			
		} else if (indexVariable==2) {
			
			return "("+getNextGadget()+","+getNextGadget()+")!P"+(++gadgetCount);
		
		} else {
			
			return "("+getNextGadget()+",("+getNextGadget()+","+recursion(indexVariable-2)+")!P"+(++gadgetCount)+")!P"+(++gadgetCount);
			
		}
		
	}
	
	
	private String getNextGadget() {
		
		
		
		String toReturn= "(((b"+(gadgetCount+2)+",a"+(gadgetCount+2)+")!P"+(gadgetCount+2)+",a"+(gadgetCount+1)+")!P"+(gadgetCount+1)+",a"+(gadgetCount)+")!P"+gadgetCount;
		
		gadgetCount=gadgetCount+3;
		
		return toReturn;
		
	}

	@Override
	public HashMap<String, String> getMapping() {
		
		HashMap<String, String> map = new HashMap<>();
		
		for (int i=1;i<=nbrOfPlateaus*10;i++) {
			map.put("a"+i, "A");
			map.put("b"+i, "B");
			map.put("c"+i, "C");
		}
		
		
		return map;
	}

	

	
	
}
