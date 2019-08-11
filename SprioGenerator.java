import java.util.Map;
import java.util.TreeMap;

public class SprioGenerator
{

	public static void main(String[] args){
		
		// Declaring the parameters for calling SpiroPoint function
		double scale = 0.0001;
		int nRev = 17;
		int R = 8;
		int r = 1;
		int a = 4;
		
		// Declaring the center around which the spirograph is to be created
		TreeMap<String, java.lang.Double> SGM123 = new TreeMap<String, java.lang.Double>();
		SGM123.put("latitude", 34.021160099);
		SGM123.put("longitude", -118.2891709 );
		
		// As the loop traverses, it prints the longitude,latitude values of the points which together form a SpiroGraph.
		for (double t = 0; t < Math.PI * nRev; t += 0.1) {
			Map<String, java.lang.Double> point = SpiroPoint(scale, R, r, a, t, SGM123);
			System.out.println(point.get("longitude") + "," + point.get("latitude"));
		}
		
	}
	
	/**
	 * Function to compute Spirograph Points
	 * @param scale scaling parameter to scale the graph
	 * @param R Large Circle Radius
	 * @param r Small Circle Radius
	 * @param a Height
	 * @param t Angle
	 * @param center
	 * @return TreeMap with latitude and longitude values.
	 */
	
	public static Map<String, java.lang.Double> SpiroPoint(double scale, int R, int r, int a, double t,  TreeMap<String, java.lang.Double> center) {
		double lat = center.get("latitude") + scale * ((R+r) * Math.cos(((double) r/R)*t) - a * Math.cos((1+((double) r/R))*t));
		double lng = center.get("longitude") + scale * ((R+r) * Math.sin(((double) r/R)*t) - a * Math.sin((1+((double) r/R))*t));
		
		Map<String, java.lang.Double> spiroPoint = new TreeMap<String, java.lang.Double>();
		
		spiroPoint.put("latitude", lat);
		spiroPoint.put("longitude", lng);
		
		return spiroPoint;
		
	}

	  
   
	
}

	
