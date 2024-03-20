import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static int point = 0;
    public static Random die1 = new Random();
    public static Random die2 = new Random();
    public static int total;

    public static int rollDice() {
        int d1Value = die1.nextInt(6) + 1;
        int d2Value = die2.nextInt(6) + 1;
        total = d1Value + d2Value;
        System.out.printf("%d and %d equals %d\n", d1Value, d2Value, total);
        return total;
    }

    public static void FirstRoll() {
        do {
            int d1Value = die1.nextInt(6) + 1;
            int d2Value = die2.nextInt(6) + 1;
            total = d1Value + d2Value;
            System.out.printf("%d and %d equals %d\n", d1Value, d2Value, total);

            switch (total) {
                case 2:
                case 3:
                case 12:
                    System.out.println(total + "you lose:(");
                    break;
                case 7:
                case 11:
                    System.out.println(total + "you win:");
                    break;
                default:
                    point = total;
                    break;
            }
        } while (point == 0);
    }

    public static void TheGame() {
        do {
            total = rollDice();
            if (total == 7) {
                System.out.println("7 - You lose :(");
            } else if (total == point) {
                System.out.println("Point - You win!");
            } else {
                System.out.println("Keep Rolling");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        } while (point != total);
    }


    public static void main(String[] args) throws Exception {
        String keepPlaying = "yes";
        Scanner keyboard = new Scanner(System.in);

        while (keepPlaying.equalsIgnoreCase("yes")) {
            FirstRoll();
            System.out.println("The point is" + point);
            TheGame();
            System.out.println("Do you want to keep playing? Yes/No");
            keepPlaying = keyboard.nextLine();
        }
        keyboard.close();
        System.out.println("Thanks for playing. I hope you won!");
    }
}
