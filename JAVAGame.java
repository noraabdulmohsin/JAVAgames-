
package javagame;
import java.util.Random;
 import java.util.Scanner;
public class JAVAGame {
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Choose difficulty (1 = Easy, 2 = Hard): ");
        int difficulty = input.nextInt();

        Game game = new Game(name, difficulty);
        game.start();
    }
} 

// player class 
class player {
    String name ; 
    int attempts ; 
   public  player(String name , int attempts ) {
   this.name = name ; 
   this.attempts=attempts;
}
   public void    setName (String name){
    this.name=name ; 
   }
   public String getName() {
    return name; 
}
   public void addAttempt() {
    attempts++;
}

public int getAttempts() {
    return attempts;
}
}
// Guessing number class 

class NumberGenerator {
private int number ; 

    public NumberGenerator(int max) {
        Random rand = new Random();
        number = rand.nextInt(max) + 1;
    }

    public int getNumber() {
        return number;
    }
}
     class Game {
    private player player;
    private NumberGenerator generator;
    private int maxAttempts;

    public Game(String playerName, int difficulty) {
        player = new player(playerName, 0);

        if (difficulty == 1) {
            generator = new NumberGenerator(50);
            maxAttempts = 10;
        } else {
            generator = new NumberGenerator(100);
            maxAttempts = 5;
        }
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        int guess;

        System.out.println("Game started!");
        System.out.println("Welcome " + player.getName() + "!");

        while (player.getAttempts() < maxAttempts) {
            System.out.print("guess a number between 1 and 100 ");
            System.out.print("Enter guess: ");
            guess = input.nextInt();
            player.addAttempt();

            if (guess > generator.getNumber()) {
                System.out.println("Too high");
            } else if (guess < generator.getNumber()) {
                System.out.println("Too low");
            } else {
                System.out.println("You win  in " + player.getAttempts() + " attempts!");
                return;
            }
        }

        System.out.println("You lost The number was: " + generator.getNumber());
    }
}
    
    
    
    
    
    
    
    
    
    
    
