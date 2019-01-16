package structures;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import constants.ForksConstant;

public class Mapping {


	private Map center_fork_map= new Map();
	private Map top_fork_map= new Map();
	private Map left_fork_map= new Map();
	private Map right_fork_map= new Map();




	public Map getCenter_fork_map() {
		return center_fork_map;
	}




	public void setCenter_fork_map(Map center_fork_map) {
		this.center_fork_map = center_fork_map;
	}




	public Map getTop_fork_map() {
		return top_fork_map;
	}




	public void setTop_fork_map(Map top_fork_map) {
		this.top_fork_map = top_fork_map;
	}




	public Map getLeft_fork_map() {
		return left_fork_map;
	}




	public void setLeft_fork_map(Map left_fork_map) {
		this.left_fork_map = left_fork_map;
	}




	public Map getRight_fork_map() {
		return right_fork_map;
	}




	public void setRight_fork_map(Map right_fork_map) {
		this.right_fork_map = right_fork_map;
	}




	public class Map {

		//costo per andare in quel nodo
		private float costo;

		//quale nodo è mappato
		private Node nodo;

		//il nodo dove vengono mappati i figli
		private int mapLeft;
		private int mapRight;


		public float getCosto() {
			return costo;
		}
		public void setCosto(float costo) {
			this.costo = costo;
		}
		public Node getNodo() {
			return nodo;
		}
		public void setNodo(Node nodo) {
			this.nodo = nodo;
		}
		public int getMapLeft() {
			return mapLeft;
		}
		public void setMapLeft(int mapLeft) {
			this.mapLeft = mapLeft;
		}
		public int getMapRight() {
			return mapRight;
		}
		public void setMapRight(int mapRight) {
			this.mapRight = mapRight;
		}


	}



	/**
	 * ritorna il costo minimo+loss
	 * @param node il nodo da cui si deve calcolare la distanza
	 * @return
	 */
	public float getMinimumPlusDistance(Node node, float Cl,AtomicInteger point) {

		float center_cost= center_fork_map.getCosto()+(center_fork_map.getNodo().getComparableDistance(node)*Cl);

		float top_cost= top_fork_map.getCosto()+(top_fork_map.getNodo().getComparableDistance(node)*Cl);

		float left_cost= left_fork_map.getCosto()+(left_fork_map.getNodo().getComparableDistance(node)*Cl);

		float right_cost= right_fork_map.getCosto()+(right_fork_map.getNodo().getComparableDistance(node)*Cl);
		
		if (center_cost<=top_cost && center_cost<=left_cost && center_cost<=right_cost) {
			point.set(ForksConstant.CENTER);
			return center_cost;
		}
		
		if (top_cost<=center_cost && top_cost<=left_cost && top_cost<=right_cost) {
			point.set(ForksConstant.TOP);
			return top_cost;
		}
		
		if (left_cost<=top_cost && left_cost<=center_cost && left_cost<=right_cost) {
			point.set(ForksConstant.LEFT);
			return left_cost;
		}
		
		if (right_cost<=top_cost && right_cost<=left_cost && right_cost<=center_cost) {
			point.set(ForksConstant.RIGHT);
			return right_cost;
		}

		throw new RuntimeException();

	}




	public float getMinimumPlusDistanceSpeciazione(Node node, float Cl,AtomicInteger point) {

		float center_cost= center_fork_map.getCosto()+((center_fork_map.getNodo().getComparableDistance(node)-1)*Cl);

		float top_cost= top_fork_map.getCosto()+((top_fork_map.getNodo().getComparableDistance(node)-1)*Cl);

		float left_cost= left_fork_map.getCosto()+((left_fork_map.getNodo().getComparableDistance(node)-1)*Cl);

		float right_cost= right_fork_map.getCosto()+((right_fork_map.getNodo().getComparableDistance(node)-1)*Cl);

		if (center_cost<=top_cost && center_cost<=left_cost && center_cost<=right_cost) {
			point.set(ForksConstant.CENTER);
			return center_cost;
		}
		
		if (top_cost<=center_cost && top_cost<=left_cost && top_cost<=right_cost) {
			point.set(ForksConstant.TOP);
			return top_cost;
		}
		
		if (left_cost<=top_cost && left_cost<=center_cost && left_cost<=right_cost) {
			point.set(ForksConstant.LEFT);
			return left_cost;
		}
		
		if (right_cost<=top_cost && right_cost<=left_cost && right_cost<=center_cost) {
			point.set(ForksConstant.RIGHT);
			return right_cost;
		}

		throw new RuntimeException();

	}




	public float getBetter() {

		return Collections.min(Arrays.asList(new Float[] {center_fork_map.getCosto(),top_fork_map.getCosto(),left_fork_map.getCosto(),right_fork_map.getCosto()}));
	}



	/**
	 * Questo metodo ci dice quale è il nodo dove siamo mappati nel migliore dei casi
	 * @return
	 */
	public int getBestNode() {

		if (center_fork_map.getCosto()<=top_fork_map.getCosto() && center_fork_map.getCosto()<=left_fork_map.getCosto() && center_fork_map.getCosto()<=right_fork_map.getCosto()) {
			return ForksConstant.CENTER;
		}
		if (top_fork_map.getCosto()<=center_fork_map.getCosto() && top_fork_map.getCosto()<=left_fork_map.getCosto() && top_fork_map.getCosto()<=right_fork_map.getCosto()) {
			return ForksConstant.TOP;
		}
		if (left_fork_map.getCosto()<=center_fork_map.getCosto() && left_fork_map.getCosto()<=top_fork_map.getCosto() && left_fork_map.getCosto()<=right_fork_map.getCosto()) {
			return ForksConstant.LEFT;
		}

		return ForksConstant.RIGHT;

	}



	/**
	 * ritorna il nodo migliore a seconda di top, bottom, left, right
	 * @return
	 */
	public Node getNodeByCode(int forkPoint) {
		switch	(forkPoint) {
		case ForksConstant.CENTER:
			return center_fork_map.getNodo();
		case ForksConstant.TOP:
			return top_fork_map.getNodo();
		case ForksConstant.LEFT:
			return left_fork_map.getNodo();
		case ForksConstant.RIGHT:
			return right_fork_map.getNodo();
		}
		return null;
	}



	/**
	 * Questo metodo ritorna il codice di dove veniva mappato il figlio sinistro fissato il mapping di questo nodo
	 * @param code
	 * @return
	 */
	public int getCodeLeftChildByCode(int forkPoint) {
		switch	(forkPoint) {
		case ForksConstant.CENTER:
			return center_fork_map.getMapLeft();
		case ForksConstant.TOP:
			return top_fork_map.getMapLeft();
		case ForksConstant.LEFT:
			return left_fork_map.getMapLeft();
		case ForksConstant.RIGHT:
			return right_fork_map.getMapLeft();
		}
		return 0;
	}
	
	/**
	 * Questo metodo ritorna il codice di dove veniva mappato il figlio destro fissato il mapping di questo nodo
	 * @param code
	 * @return
	 */
	public int getCodeRightChildByCode(int forkPoint) {
		switch	(forkPoint) {
		case ForksConstant.CENTER:
			return center_fork_map.getMapRight();
		case ForksConstant.TOP:
			return top_fork_map.getMapRight();
		case ForksConstant.LEFT:
			return left_fork_map.getMapRight();
		case ForksConstant.RIGHT:
			return right_fork_map.getMapRight();
		}
		return 0;
	}




	public float getCostByCode(int forkPoint) {
		switch	(forkPoint) {
		case ForksConstant.CENTER:
			return center_fork_map.getCosto();
		case ForksConstant.TOP:
			return top_fork_map.getCosto();
		case ForksConstant.LEFT:
			return left_fork_map.getCosto();
		case ForksConstant.RIGHT:
			return right_fork_map.getCosto();
		}
		return -1;
	}


}
