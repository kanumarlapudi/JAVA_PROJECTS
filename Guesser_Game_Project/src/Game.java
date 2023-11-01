import java.util.Scanner;
import java.lang.Math;

//guesser method
class Guesser {
	int guesser_num;

	public int guess_num() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Guesser - Please Enter the number between 1 to 10 : ");
		guesser_num = scan.nextInt();
		while (guesser_num > 10) {
			System.out.println("The number is Greater than 10 - please Enter the number between 0 to 10 ");
			guesser_num = scan.nextInt();
		}
		return guesser_num;

	}
}

//player1 method
class Player1 {
	int player1_num;

	public int player1_num() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player1 - Please Enter the number between 1 to 10 : ");
		player1_num = scan.nextInt();
		while (player1_num > 10) {
			System.out.println(
					"The number is Greater than 10, You will be out of the game - please Enter the number between 0 to 10 ");
			player1_num = scan.nextInt();
		}
		return player1_num;
	}
}

//player2 method
class Player2 {
	int player2_num;

	public int player2_num() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player2 - Please Enter the number between 1 to 10 : ");
		player2_num = scan.nextInt();
		while (player2_num > 10) {
			System.out.println(
					"The number is Greater than 10, You will be out of the game - please Enter the number between 0 to 10 ");
			player2_num = scan.nextInt();
		}
		return player2_num;
	}
}

//player3 method
class Player3 {
	int player3_num;

	public int player3_num() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player3 - Please Enter the number between 1 to 10 : ");
		player3_num = scan.nextInt();
		while (player3_num > 10) {
			System.out.println(
					"The number is Greater than 10, You will be out of the game - please Enter the number between 0 to 10 ");
			player3_num = scan.nextInt();
		}
		return player3_num;
	}
}

//Umpire method
class Umpire {
	public void game() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lets start the Game - Be Ready");
		Guesser guess = new Guesser();
		guess.guess_num();

		Player1 p1 = new Player1();
		p1.player1_num();

		Player2 p2 = new Player2();
		p2.player2_num();

		Player3 p3 = new Player3();
		p3.player3_num();

		// All player guesses the right answer, but they can play again because there
		// can be only one winner
		if ((guess.guesser_num == p1.player1_num) && (guess.guesser_num == p2.player2_num)
				&& (guess.guesser_num == p3.player3_num)) {
			System.out.println("All Players won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
			System.out.println();
			System.out.println("But the game is tie, There can be only one winner ----   ");
			System.out.println();
			String answer; // to get the answer
			System.out.println("Are you ready to play again:  yes or no: ");
			answer = scan.nextLine();
			if (answer.toLowerCase().equals("yes")) {
				game();
				System.out.println();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Entered wrong This is the last chance, please enter only yes or no: ");
				answer = scan.nextLine();

				if (answer.toLowerCase().equals("yes")) {
					game();
					System.out.println();
				} else if (answer.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Game is Over--------");
				}
			}

		}

		// player1 and player2 gives right answer
		else if ((guess.guesser_num == p1.player1_num) && (guess.guesser_num == p2.player2_num)) {
			System.out.println("Player1 and player2 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
			System.out.println();
			System.out.println("But the game is tie, There can be only one winner ----   ");
			System.out.println();
			String answer; // to get the answer
			System.out.println("Are you ready to play again:  yes or no: ");
			answer = scan.nextLine();

			if (answer.toLowerCase().equals("yes")) {
				Player1Player2Tie pp1 = new Player1Player2Tie();
				pp1.Player1andPlayer2Tied();
				System.out.println();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Entered wrong This is the last chance, please enter only yes or no: ");
				answer = scan.nextLine();

				if (answer.toLowerCase().equals("yes")) {
					Player1Player2Tie pp1 = new Player1Player2Tie();
					pp1.Player1andPlayer2Tied();
					System.out.println();
				} else if (answer.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Game is Over--------");
				}
			}
		}

		// player2 and player3 gives right answer
		else if ((guess.guesser_num == p2.player2_num) && (guess.guesser_num == p3.player3_num)) {
			System.out.println("Player2 and player3 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);

			System.out.println();
			System.out.println("But the game is tie, There can be only one winner ----   ");
			System.out.println();
			String answer; // to get the answer
			System.out.println("Are you ready to play again:  yes or no: ");
			answer = scan.nextLine();

			if (answer.toLowerCase().equals("yes")) {
				Player2Player3Tie pp2 = new Player2Player3Tie();
				pp2.Player2andPlayer3Tied();
				System.out.println();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Entered wrong This is the last chance, please enter only yes or no: ");
				answer = scan.nextLine();

				if (answer.toLowerCase().equals("yes")) {
					Player2Player3Tie pp2 = new Player2Player3Tie();
					pp2.Player2andPlayer3Tied();
					System.out.println();
				} else if (answer.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Game is Over--------");
				}
			}
		}

		// player1 and player3 gives right answer
		else if ((guess.guesser_num == p1.player1_num) && (guess.guesser_num == p3.player3_num)) {
			System.out.println("Player1 and player3 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);

			System.out.println();
			System.out.println("But the game is tie, There can be only one winner ----   ");
			System.out.println();
			String answer; // to get the answer
			System.out.println("Are you ready to play again:  yes or no: ");
			answer = scan.nextLine();

			if (answer.toLowerCase().equals("yes")) {
				Player1Player3Tie pp3 = new Player1Player3Tie();
				pp3.Player1andPlayer3Tied();
				System.out.println();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Entered wrong This is the last chance, please enter only yes or no: ");
				answer = scan.nextLine();

				if (answer.toLowerCase().equals("yes")) {
					Player1Player3Tie pp3 = new Player1Player3Tie();
					pp3.Player1andPlayer3Tied();
					System.out.println();
				} else if (answer.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Game is Over--------");
				}
			}
		}

		// player1 gives right answer
		else if ((guess.guesser_num == p1.player1_num)) {
			System.out.println("Player1 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		}

		// player2 gives right answer
		else if ((guess.guesser_num == p2.player2_num)) {
			System.out.println("Player2 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		}

		// player3 gives right answer
		else if ((guess.guesser_num == p3.player3_num)) {
			System.out.println("Player3 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		}

		else {
			System.out.println("All players lost the game");
			System.out.println("The Correct number is  " + guess.guesser_num);
		}
	}
}

//the method calls if player1 and player2 game ties
class Player1Player2Tie {
	public void Player1andPlayer2Tied() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lets start the Game - Be Ready");

		Guesser guess = new Guesser();
		guess.guess_num();

		Player1 p1 = new Player1();
		p1.player1_num();

		Player2 p2 = new Player2();
		p2.player2_num();

		if ((guess.guesser_num == p1.player1_num) && (guess.guesser_num == p2.player2_num)) {
			System.out.println("Player1 and player2 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
			System.out.println();
			System.out.println("But the game is tie, There can be only one winner ----   ");
			System.out.println();
			String answer; // to get the answer
			System.out.println("Are you ready to play again:  yes or no: ");
			answer = scan.nextLine();

			if (answer.toLowerCase().equals("yes")) {
				Player1Player2Tie pp1 = new Player1Player2Tie();
				pp1.Player1andPlayer2Tied();
				System.out.println();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Entered wrong This is the last chance, please enter only yes or no: ");
				answer = scan.nextLine();

				if (answer.toLowerCase().equals("yes")) {
					Player1Player2Tie pp1 = new Player1Player2Tie();
					pp1.Player1andPlayer2Tied();
					System.out.println();
				} else if (answer.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Game is Over--------");
				}
			}
		} else if ((guess.guesser_num == p1.player1_num)) {
			System.out.println("Player1 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		}

		// player2 gives right answer
		else if ((guess.guesser_num == p2.player2_num)) {
			System.out.println("Player2 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		} else {
			System.out.println("All players lost the game");
			System.out.println("The Correct number is  " + guess.guesser_num);
		}

	}
}

//the method calls if player2 and player3 game ties
class Player2Player3Tie {
	public void Player2andPlayer3Tied() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lets start the Game - Be Ready");

		Guesser guess = new Guesser();
		guess.guess_num();

		Player2 p2 = new Player2();
		p2.player2_num();

		Player3 p3 = new Player3();
		p3.player3_num();

		if ((guess.guesser_num == p2.player2_num) && (guess.guesser_num == p3.player3_num)) {
			System.out.println("Player2 and player3 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
			System.out.println();
			System.out.println("But the game is tie, There can be only one winner ----   ");
			System.out.println();
			String answer; // to get the answer
			System.out.println("Are you ready to play again:  yes or no: ");
			answer = scan.nextLine();

			if (answer.toLowerCase().equals("yes")) {
				Player2Player3Tie pp2 = new Player2Player3Tie();
				pp2.Player2andPlayer3Tied();
				System.out.println();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Entered wrong This is the last chance, please enter only yes or no: ");
				answer = scan.nextLine();

				if (answer.toLowerCase().equals("yes")) {
					Player2Player3Tie pp2 = new Player2Player3Tie();
					pp2.Player2andPlayer3Tied();
					System.out.println();
				} else if (answer.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Game is Over--------");
				}
			}
		}
		// player2 gives right answer
		else if ((guess.guesser_num == p2.player2_num)) {
			System.out.println("Player2 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		}

		// player3 gives right answer
		else if ((guess.guesser_num == p3.player3_num)) {
			System.out.println("Player3 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		} else {
			System.out.println("All players lost the game");
			System.out.println("The Correct number is  " + guess.guesser_num);
		}

	}
}

//the method calls if player1 and player3 game ties
class Player1Player3Tie {
	public void Player1andPlayer3Tied() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lets start the Game - Be Ready");

		Guesser guess = new Guesser();
		guess.guess_num();

		Player1 p1 = new Player1();
		p1.player1_num();

		Player3 p3 = new Player3();
		p3.player3_num();

		if ((guess.guesser_num == p1.player1_num) && (guess.guesser_num == p3.player3_num)) {
			System.out.println("Player1 and player3 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
			System.out.println();
			System.out.println("But the game is tie, There can be only one winner ----   ");
			System.out.println();
			String answer; // to get the answer
			System.out.println("Are you ready to play again:  yes or no: ");
			answer = scan.nextLine();

			if (answer.toLowerCase().equals("yes")) {
				Player1Player3Tie pp3 = new Player1Player3Tie();
				pp3.Player1andPlayer3Tied();
				System.out.println();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Entered wrong This is the last chance, please enter only yes or no: ");
				answer = scan.nextLine();

				if (answer.toLowerCase().equals("yes")) {
					Player1Player3Tie pp3 = new Player1Player3Tie();
					pp3.Player1andPlayer3Tied();
					System.out.println();
				} else if (answer.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Game is Over--------");
				}
			}
		}
		// player2 gives right answer
		else if ((guess.guesser_num == p1.player1_num)) {
			System.out.println("Player1 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		}

		// player3 gives right answer
		else if ((guess.guesser_num == p3.player3_num)) {
			System.out.println("Player3 won the game ");
			System.out.println("The Correct guessed number is  " + guess.guesser_num);
		} else {
			System.out.println("All players lost the game");
			System.out.println("The Correct number is  " + guess.guesser_num);
		}

	}
}

class CodeCaptcha {
	public void disp() {
		Scanner scan = new Scanner(System.in);
		int max = 9999;
		int min = 1000;
		int range = max - min + 1;

		// generate random numbers within 1 to 10
		// for (int i = 1000; i < 9999; i++) {

		int rand = (int) (Math.random() * range) + min;
		// Output is different everytime this code is executed
		System.out.println(rand);
		System.out.println("Please Enter the code shown above to start the game: ");
		int code = scan.nextInt();
		if (rand == code) {
			Umpire u = new Umpire();
			u.game();
		} else if (rand != code) {
			System.out.println("Code is Wrong ---   Are You ready to play game yes or no: ");
			String answer = scan.next();
			if (answer.toLowerCase().equals("yes")) {
				disp();
			} else if (answer.toLowerCase().equals("no")) {
				System.out.println("Thank You For Playing");
			} else {
				System.out.println("Invalid please Enter Yes or No only : ");
				String answer1 = scan.next();
				if (answer1.toLowerCase().equals("yes")) {
					disp();
				} else if (answer1.toLowerCase().equals("no")) {
					System.out.println("Thank You For Playing");
				} else {
					System.out.println("Thank You For Playing");
				}
			}
		}
	}
}

//main method
public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CodeCaptcha c = new CodeCaptcha();
		c.disp();

	}
}