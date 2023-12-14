import java.util.Scanner;

public class FractionsQuiz
{
    public static void main(String args[]){
        System.out.print("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int numright = 0;
        int numwrong = 0;
        int numasked = 0;
        while(true){
            Fraction a = new Fraction();
            Fraction b = new Fraction();
            Fraction truanswer = new Fraction();
            int symbol = (int) (Math.random()*4);
            if (symbol == 0){
                truanswer = Fraction.add(a,b);
                System.out.print(a +  " + " + b + " = ");
            }
            if (symbol == 1){
                truanswer = Fraction.subtract(a,b);
                System.out.print(a +  " - " + b + " = ");
            }
            if (symbol == 2){
                truanswer = Fraction.multiply(a,b);
                System.out.print(a +  " x " + b + " = ");
            }
            if (symbol == 3){
                truanswer = Fraction.divide(a,b);
                System.out.print(a +  " / " + b + " = ");
            }
            truanswer.reduce();
            String playeranswer = scanner.nextLine();

            if(playeranswer.equals("quit")){
                if(numasked == 0){
                    System.out.println("Your win/loss ratio was " + numright + "/" + numwrong + ", for a score of 0 percent!");
                    break;
                }
                else{System.out.println("Your win/loss ratio was " + numright + "/" + numwrong + ", for a score of " + (int) numright/numasked + " percent!");
                    break;}
            }

            Fraction playerans = new Fraction(playeranswer);
            if (playerans.equals(truanswer)){
                System.out.println("Correct!");
                numright++;
                numasked = numright+numwrong;
            }
            if (!playerans.equals(truanswer)){
                System.out.println("Wrong, the answer was "+truanswer.toString());
                numwrong++;
                numasked = numright+numwrong;
            }

        }
    }
}
