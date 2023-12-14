public class FractionsDriver
{
    public static void main(String[] args){
        Fraction half = new Fraction(1,2);
        Fraction third = new Fraction (1,3);
        Fraction sum = Fraction.add(half, third); 
        System.out.println(sum);
    }
}
