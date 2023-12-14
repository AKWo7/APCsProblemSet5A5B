public class Approximate
{

    public static void Approximate(){
        Fraction MILU = new Fraction( 355, 113 );
        final double EPSILON = Math.abs( Math.PI - MILU.toDouble()); 

        Fraction fraction = new Fraction (1,1);
        while (Math.abs( Math.PI - fraction.toDouble()) >= EPSILON){
            if (fraction.toDouble()<Math.PI){
                fraction.setNum(fraction.getNumerator()+1);

            }
            else {
                fraction.setDenom(fraction.getDenominator()+1);
            }
        }

        System.out.println(fraction.toString());
    }
}
