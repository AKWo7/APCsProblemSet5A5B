public class Fraction
{
    private int numerator;
    private int denominator;

    /**
     * Creates a default fraction.
     * The fraction is 1/2.
     */
    public Fraction(){
        numerator = (int) (Math.random()*10);
        denominator = (int) (Math.random()*9+1);
    }

    /**
     * Takes two integer parameters and sets the numerator to the num parameter and the denominator to the denom paramenter as long as it is not equal to 0.
     * @param num The numerator.
     * @param denom The denominator.
     */
    public Fraction(int num, int denom){
        if (denom == 0){
            System.out.println("Denominator cannot be equal to 0 and will be set to 1.");
            denominator = 1;
        }
        else if (denom != 0){
            numerator = num;
            denominator = denom; 
        }
    }

    /**
     * Takes a String parameter and sets the numerator to the values before the slash and the denominator to the values after the slash. If they do not include a /, it sets numerator and denominator to 1 and sends an error message.
     * @param fraction A string in the form "a/b".
     */
    public Fraction(String fraction){
        int slash = fraction.indexOf("/");
        if(slash>0){
            numerator = Integer.parseInt(fraction.substring(0,fraction.indexOf("/")));
            denominator = Integer.parseInt(fraction.substring(fraction.indexOf("/")+1));
            if(denominator == 0){
                System.out.println("Denominator cannot be equal to 0 and will be set to 1.");
                denominator = 1;
            }
        }
        else if(slash<0){
            System.out.println("Please include it in the proper format.");
            denominator = 1;
            numerator = 1;
        }
    }

    /**
     * Takes a Fraction object and creates new fraction with the same numerator and denominator.
     * @param fraction The fraction object.
     */
    public Fraction(Fraction fraction){
        numerator = fraction.numerator; 
        denominator = fraction.denominator; 
    }

    /**
     * @return The numerator of the fraction.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * @return The denominator of the fraction.
     */
    public int getDenominator(){
        return denominator; 
    }

    /**
     * @return The fraction is returned as a String.
     */
    public String toString(){
        return ""+numerator+"/"+denominator;
    }

    /**
     * @return The fraction as a decimal number or double. 
     */
    public double toDouble(){
        return (double) numerator/ (double) denominator;
    }

    /**
     * Takes two numbers, and keeps subtracting them until they equal each other to find the Greatest Common Factor.
     * @param a The first number.
     * @param b The second number.
     * @return The Greatest Common Factor.
     */
    private int gcf(int a, int b){
        if ( a == 0 || b == 0){
            return 1;
        }
        while(a!=b){
            if(a>b){
                a-=b;
            }
            if(b>a){
                b-=a;
            }
        }
        return b;
    }

    /**
     * Reduces the fraction to its lowest values. 
     */
    public void reduce(){
        int divide = gcf(numerator, denominator);
        numerator /= divide;
        denominator /= divide;
        if(denominator<0){
            numerator = -1*numerator;
            denominator = -1*denominator;
        }
        if(denominator<0&&numerator<0){
            numerator = -1*numerator;
            denominator = -1*denominator;
        }
    }

    /**
     * Sets the numerator to a value.
     * @param newNum The new numerator.
     */
    public void setNum(int newNum){
        numerator = newNum;
    }

    /**
     * Sets the denominator to a value that is not 0.
     * @param newDenom The new denominator.
     */
    public void setDenom(int newDenom){
        if (newDenom == 0){
            System.out.println("Denominator cannot be set to 0 and will be set to 1.");
            denominator = 1;
        }
        else denominator = newDenom;
    }

    /**
     * Multiplies Fraction a with Fraction b.
     * @param a The first Fraction.
     * @param b The second Fraction.
     * @return The new Fraction after multiplication.
     */
    public static Fraction multiply(Fraction a, Fraction b){
        return new Fraction(a.numerator*b.numerator, a.denominator*b.denominator);
    }

    /**
     * Divides Fraction a with Fraction b.
     * @param a The first Fraction.
     * @param b The second Fraction.
     * @return The new Fraction after division.
     */
    public static Fraction divide(Fraction a, Fraction b){
        return new Fraction(a.numerator*b.denominator, a.denominator*b.numerator);
    }

    /**
     * Adds Fraction a with Fraction b.
     * @param a The first Fraction.
     * @param b The second Fraction.
     * @return The new Fraction after addition.
     */
    public static Fraction add(Fraction a, Fraction b){
        return new Fraction((a.numerator*b.denominator)+(b.numerator*a.denominator), b.denominator*a.denominator);
    }

    /**
     * Subtracts Fraction a with Fraction b.
     * @param a The first Fraction.
     * @param b The second Fraction.
     * @return The new Fraction after subtraction.
     */
    public static Fraction subtract(Fraction a, Fraction b){
        return new Fraction((a.numerator*b.denominator)-(b.numerator*a.denominator), b.denominator*a.denominator);
    }

    /**
     * Returns true if Fraction f is identical to this fraction. It does not take into
     * account if two fractions are equal in value, just if the numerators and
     * denominators are the same.
     *
     * @param f	  The fraction to compare with
     * @return    A boolean value that represents whether f was equal to this Fraction
     */
    public boolean equals(Fraction f){
        return f.getDenominator() == denominator && f.getNumerator() == numerator;
    }

}
