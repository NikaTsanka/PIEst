

public class Q2 {
	
	private final static double RADIUS = 1.0;
	private static double areaOfCircle = 0;


	public static void main(String[] args) {
		
		//Area of the top right quadrant of the circle.
		areaOfCircle = (Math.PI * Math.pow(RADIUS, 2.0)) / 4;

		
		System.out.println(areaOfCircle);

	}

}
