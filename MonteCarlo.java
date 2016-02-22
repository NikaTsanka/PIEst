import java.math.*;
import java.util.Random;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/*
 * PI estimation simulation. AKA "Monte Carlo method"
 */
public class Q2 {
	//Random Variable.
	private static Random rnd;

	//BigInteger Variables.
	private static BigInteger INARC;
	private static BigInteger bigNum;
	private static BigInteger i;

	//BigDecimal Variables.
	private static BigDecimal INARC0;
	private static BigDecimal bigNum0;
	private static BigDecimal FOUR;
	private static BigDecimal result;

	//String Variables.
	private static String INARCToString;
	private static String bigNumToString;

	//Double Variables - Initialized.
	private static double x = 0, y = 0, rNum = 0;

	public static void main(String[] args) {
		//Timer
		long startTime = System.nanoTime();

		//Initialize Random. Range will be 0 to 1; 0 inclusive.
		rnd = new Random();

		//Initialize BigIntegers.
		INARC = BigInteger.ZERO;
		bigNum = new BigInteger("4000000000");
		i = BigInteger.ZERO;

		while ((i.compareTo(bigNum) == -1)) {

			x = rnd.nextDouble();
			y = rnd.nextDouble();

			rNum = ((x * x) + (y * y));

			/*
			 * Didn't notice that BigInteger and BigDecimal
			 * were immutable even though it clearly said in
			 * the book. So I was doing something like
			 * INARC.add(BigInteger.ONE) and it didn't work.
			 * But now I know. :)
			 */
			if (rNum <= 1.0) {
				INARC = INARC.add(BigInteger.ONE);
			}
			i = i.add(BigInteger.ONE);

		}
		//Set Strings.
		INARCToString = INARC.toString();
		bigNumToString = bigNum.toString();

		//Set BigDecimals.
		INARC0 = new BigDecimal(INARCToString);
		bigNum0 = new BigDecimal(bigNumToString);
		FOUR = new BigDecimal("4.0");

		//Calculate. 10 digits after the decimal point should be good.
		result = INARC0.multiply(FOUR).divide(bigNum0, 10, 
				BigDecimal.ROUND_UP);

		out.println("PI = " + result);

		//Timer
		long estimatedTime = System.nanoTime() - startTime;

		//I knew how to get the time but this way is better. :)
		//http://stackoverflow.com/questions/924208/how-to-convert-nanoseconds-to-seconds-using-the-timeunit-enum
		out.println("Estimation time: " +
				NANOSECONDS.toMinutes(estimatedTime) + " minutes and " + 
				(NANOSECONDS.toMinutes(estimatedTime) % 60) + " seconds." );
	}

}
