import java.util.Scanner;

public class CrapsSimulation
	{
		static String name;
		static Scanner userInput = new Scanner(System.in);
		static int userBank;
		static int wager;
		static int point;
		static int totalDice;
		static int die1;
		static int die2;
		static Scanner userInput2 = new Scanner (System.in);
		public static void main (String[] args)
			{
				greetPlayer();
				gameRules ();
				beginGame ();
				userStartingBank ();
				userWager ();
				playingGame ();
				playAgain ();
			}		
		public static void greetPlayer()
			{
				Scanner userInput = new Scanner(System.in);
				System.out.println("Hello! What's your name?");
				name = userInput.nextLine();
				System.out.println("Hi there " + name + "!");
				name = name.toLowerCase();
				if (name.equals("dwight"))
					{
						playerDwight();
					}
				else if (name.equals("jim"))
					{
						playerJim();
					}
			}
		private static void playerJim()
			{
				gameRules();
				beginGame();
				userBank = 1000;
				System.out.println("You start with $1000 in your pocket.");
				userWager();
				playingGameWell();
				playAgain();
			}
		private static void playerDwight()
			{
				gameRules();
				beginGame();
				userBank = 1;
				System.out.println("You start with $1 in your pocket.");
				userWager();
				playingGamePoorly();
			}
		public static void gameRules()
			{
				System.out.println("Let's play some craps!");
				System.out.println("Do you need the rules of the game " + name + "?");
				String rules = userInput.nextLine();
				if (rules.toLowerCase().equals("yes"))
					{ 
						System.out.println("Craps is a betting game. If on your first roll, the sum of your two dice is 7 or 11, you win instantly.");
						System.out.println("If not, the number you rolled becomes the point. Then you roll until you get your point and win or a 7 and lose");
					}
				else 
					{
						System.out.println("Okay. Warning: the house always wins");
					}
			}
		public static void beginGame()
			{
				System.out.println("Ready to begin?");
				String answer = userInput.nextLine();
				if (answer.equals ("yes"))
					{
						System.out.println("Okay! Let's begin");
					}
				else if (answer.equals("no"))
					{
						System.out.println("Too bad! Let's begin!");
					}
				else if (answer.equals("okay"))
					{
						System.out.println("Awesome!");
					}
				else
					{
						System.out.println("Let's get started.");
					}
			}
		public static void userStartingBank()
			{
				userBank = 100;
				System.out.println("You start with "+ userBank + " in your pocket.");
			}
		public static void userWager ()
			{
				System.out.println("How much do you want to wager?");
					wager = userInput.nextInt();
					System.out.println("You're betting " + wager + " dollars.");
					if (wager > userBank)
						{
							System.out.println("You can't bet more money than you have!");
							userWager ();
						}
					else if (wager < 0)
						{
							System.out.println("You can't bet a negative number!");
							userWager ();
						}
				}
		public static void playingGame ()
			{
				die1 = (int)(Math.random()*6)+1;
				die2 = (int)(Math.random()*6)+1;
				int totalDice = die1 + die2;
				int point = 0;
				System.out.println("You rolled " + die1 + " and a " + die2 + " for a total of " + totalDice);
				if (totalDice == 7 || totalDice ==11)
					{
						System.out.println("Congrats! You win!!");
						userBank = userBank + wager;
						System.out.println("You won " + wager + " dollars! You now have " + userBank + " dollars!");
					}
				else if (totalDice == 2 || totalDice ==12)
					{
						System.out.println("You lost");
						userBank = userBank - wager;
						System.out.println("You lost " + wager + " dollars! You now have " + userBank + " dollars!");
					}
				else 
					{
						point = totalDice;
						System.out.println("Your point is " + point);
						System.out.println("Roll again?");
						String roll = userInput.nextLine();
						boolean crapsPart2 = true;
						while (crapsPart2)
							{
								int die3 = (int)(Math.random()*6)+1;
								int die4 = (int)(Math.random()*6)+1;
								int totalDie2 = die3 + die4;
								System.out.println("You rolled " + die3 + " and " + die4 + " for a total of " + totalDie2);
								if (totalDie2 == point)
									{
										crapsPart2 = false;
										System.out.println("You rolled your point of " + point + " and win! Congrats " + name);
										userBank = userBank + wager;
										System.out.println("You won " + wager + " dollars! You now have " + userBank + " dollars!");
									}
								else if (totalDie2 == 7)
									{
										crapsPart2 = false;
										System.out.println("You lost " + name );
										userBank = userBank - wager;
										System.out.println("You lost " + wager + " dollars! You now have " + userBank + " dollars!");
									}
								else
									{
										System.out.println("Roll again?");
										String roll2 = userInput.nextLine();
									}
							}
					}
			}
		public static void playingGameWell ()
		{
			die1 = (int)(Math.random()*5)+1;
			die2 = (int)(Math.random()*6)+1;
			int totalDice = die1 + die2;
			int point = 0;
			System.out.println("You rolled " + die1 + " and a " + die2 + " for a total of " + totalDice);
			if (totalDice == 7 || totalDice ==11)
				{
					System.out.println("Congrats! You win!!");
					userBank = userBank + wager;
					System.out.println("You won " + wager + " dollars! You now have " + userBank + " dollars!");
				}
			else if (totalDice == 2 || totalDice ==12)
				{
					System.out.println("You lost");
					userBank = userBank - wager;
					System.out.println("You lost " + wager + " dollars! You now have " + userBank + " dollars!");
				}
			else 
				{
					point = totalDice;
					System.out.println("Your point is " + point);
					System.out.println("Roll again?");
					String roll = userInput.nextLine();
					boolean crapsPart2 = true;
					int die3 = 0;
					int die4 = 0;
					while (crapsPart2)
						{
							if (point<= 6)
								{
									die3 = point-1;
									die4 = 1;
								}
							else if (point>6 && point<9)
								{
									die3 = point-4;
									die4 = 4;
								}
							else if (point>9 && point<12)
								{
									die3 = point - 6;
									die4 = 6;
								}
							int totalDie2 = die3 + die4;
							System.out.println("You rolled " + die3 + " and " + die4 + " for a total of " + totalDie2);
							if (totalDie2 == point)
								{
									crapsPart2 = false;
									System.out.println("You rolled your point of " + point + " and win! Congrats " + name);
									userBank = userBank + wager;
									System.out.println("You won " + wager + " dollars! You now have " + userBank + " dollars!");
								}
							else if (totalDie2 == 7)
								{
									crapsPart2 = false;
									System.out.println("You lost " + name );
									userBank = userBank - wager;
									System.out.println("You lost " + wager + " dollars! You now have " + userBank + " dollars!");
								}
							else
								{
									System.out.println("Press enter to roll again");
									String roll2 = userInput.nextLine();
								}
						}
				}
		}
		public static void playingGamePoorly ()
		{
			die1 = 6;
			die2 = 6;
			int totalDice = die1 + die2;
			int point = 0;
			System.out.println("You rolled " + die1 + " and a " + die2 + " for a total of " + totalDice);
			if (totalDice == 2 || totalDice ==12)
				{
					System.out.println("You lost");
					userBank = userBank - wager;
					System.out.println("You lost " + wager + " dollars! You now have " + userBank + " dollars!");
				}
		}
		public static void playAgain ()
			{
				System.out.println("Play again?");
				System.out.println("Yes or no?");
				String playAgain = userInput2.nextLine();
					if (playAgain.toLowerCase().equals("yes"))
						{
							userWager ();
							playingGame ();
						}
					else if (playAgain.toLowerCase().equals("no"))
						{
							System.out.println("Thanks for playing " + name + ". Go do something more entertaining, I guess.");
						}
					else 
						{
							userWager ();
							playingGame();
						}
			}
		}

