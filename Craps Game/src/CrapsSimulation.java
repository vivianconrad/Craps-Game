import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CrapsSimulation
	{
		static String name;
		static Scanner userInputStrings = new Scanner(System.in);
		static int userBank;
		static int wager;
		static int point;
		static int totalDice;
		static int die1;
		static int die2;
		static Scanner userInputInts = new Scanner (System.in);
		private static final long serialVersionUID = 1L;
		static JFrame frame = new JFrame();
		public static void main (String[] args)
			{
				greetPlayer();
				gameRules ();
				userStartingBank ();
				userWager ();
				playingGame ();
				playAgain ();
			}		
		public static void greetPlayer()
			{
				name = JOptionPane.showInputDialog("Hello! What is your name?");  
				JOptionPane.showMessageDialog(frame, "Hi, " + name);
				name = name.toLowerCase();
				if (name.equals("dwight"))
					{
						playerDwight();
					}
				else if (name.equals("jim"))
					{
						playerJim();
					}
				else if (name.contains("v"))
					{
						playerAdvantage();
					}
			}
		private static void playerJim()
			{
				gameRules();
				userBank = 1000;
				JOptionPane.showMessageDialog(frame, "You start with $1000 in your pocket.");
				userWager();
				playingGameWell();
				playAgain();
			}
		private static void playerDwight()
			{
				gameRules();
				userBank = 1;
				JOptionPane.showMessageDialog(frame, "You start with $1 in your pocket.");
				userWager();
				playingGamePoorly();
			}
		private static void playerAdvantage()
			{
				gameRules();
				userBank = 500;
				JOptionPane.showMessageDialog(frame, "You start with $500 in your pocket.");
				userWager();
				playingGameWell();
				playAgain();
			}
		public static void gameRules()
			{
				Object[] options = {"Yes", "No"};
				int rules = JOptionPane.showOptionDialog(frame, "Let's play some craps! Do you need the rules of the game?",
						"Rules",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, options, options[1]);
				if (rules==0)
					{ 
						JOptionPane.showMessageDialog(frame, "Craps is a betting game. If on your first roll, the sum of your two dice is 7 or 11, you win instantly.");
						JOptionPane.showMessageDialog(frame, "If not, the number you rolled becomes the point. Then you roll until you get your point and win or a 7 and lose");
					}
				else if (rules==1)
					{
						JOptionPane.showMessageDialog(frame, "Okay. Warning: the house always wins");
					}
			}
		public static void userStartingBank()
			{
				userBank = 100;
				JOptionPane.showMessageDialog(frame, "You start with "+ userBank + " in your pocket.");
			}
		public static void userWager ()
			{
				String wager1 = JOptionPane.showInputDialog("How much do you want to wager?");
				wager = Integer.parseInt(wager1);
				JOptionPane.showMessageDialog(frame, "You're betting " + wager + " dollars.");
				if (wager > userBank)
					{
							JOptionPane.showMessageDialog(frame, "You can't bet more money than you have!");
							userWager ();
						}
					else if (wager < 0)
						{
							JOptionPane.showMessageDialog(frame, "You can't bet a negative number!");
							userWager ();
						}
				}
		public static void playingGame ()
			{
				die1 = (int)(Math.random()*6)+1;
				die2 = (int)(Math.random()*6)+1;
				int totalDice = die1 + die2;
				int point = 0;
				JOptionPane.showMessageDialog(frame, "You rolled " + die1 + " and a " + die2 + " for a total of " + totalDice);
				if (totalDice == 7 || totalDice ==11)
					{
						JOptionPane.showMessageDialog(frame, "Congrats! You win!!");
						userBank = userBank + wager;
						JOptionPane.showMessageDialog(frame, "You won " + wager + " dollars! You now have " + userBank + " dollars!");
					}
				else if (totalDice == 2 || totalDice ==12)
					{
						JOptionPane.showMessageDialog(frame, "You lost");
						userBank = userBank - wager;
						JOptionPane.showMessageDialog(frame, "You lost " + wager + " dollars! You now have " + userBank + " dollars!");
					}
				else 
					{
						point = totalDice;
						JOptionPane.showMessageDialog(frame,"Your point is " + point);
						JOptionPane.showMessageDialog(frame, "Roll again?");
						boolean crapsPart2 = true;
						while (crapsPart2)
							{
								int die3 = (int)(Math.random()*6)+1;
								int die4 = (int)(Math.random()*6)+1;
								int totalDie2 = die3 + die4;
								JOptionPane.showMessageDialog(frame, "You rolled " + die3 + " and " + die4 + " for a total of " + totalDie2);
								if (totalDie2 == point)
									{
										crapsPart2 = false;
										JOptionPane.showMessageDialog(frame, "You rolled your point of " + point + " and win! Congrats " + name);
										userBank = userBank + wager;
										JOptionPane.showMessageDialog(frame, "You won " + wager + " dollars! You now have " + userBank + " dollars!");
									}
								else if (totalDie2 == 7)
									{
										crapsPart2 = false;
										JOptionPane.showMessageDialog(frame, "You lost " + name );
										userBank = userBank - wager;
										JOptionPane.showMessageDialog(frame, "You lost " + wager + " dollars! You now have " + userBank + " dollars!");
									}
								else
									{
										JOptionPane.showMessageDialog(frame, "Roll again?");
										crapsPart2 = true;
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
			JOptionPane.showMessageDialog(frame, "You rolled " + die1 + " and a " + die2 + " for a total of " + totalDice);
			if (totalDice == 7 || totalDice ==11)
				{
					JOptionPane.showMessageDialog(frame,"Congrats! You win!!");
					userBank = userBank + wager;
					JOptionPane.showMessageDialog(frame, "You won " + wager + " dollars! You now have " + userBank + " dollars!");
				}
			else if (totalDice == 2 || totalDice ==12)
				{
					JOptionPane.showMessageDialog(frame, "You lost");
					userBank = userBank - wager;
					JOptionPane.showMessageDialog(frame, "You lost " + wager + " dollars! You now have " + userBank + " dollars!");
				}
			else 
				{
					point = totalDice;
					JOptionPane.showMessageDialog(frame, "Your point is " + point);
					JOptionPane.showMessageDialog(frame,"Roll again?");
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
							JOptionPane.showMessageDialog(frame, "You rolled " + die3 + " and " + die4 + " for a total of " + totalDie2);
							if (totalDie2 == point)
								{
									crapsPart2 = false;
									JOptionPane.showMessageDialog(frame, "You rolled your point of " + point + " and win! Congrats " + name);
									userBank = userBank + wager;
									JOptionPane.showMessageDialog(frame,"You won " + wager + " dollars! You now have " + userBank + " dollars!");
								}
							else if (totalDie2 == 7)
								{
									crapsPart2 = false;
									JOptionPane.showMessageDialog(frame, "You lost " + name );
									userBank = userBank - wager;
									JOptionPane.showMessageDialog(frame, "You lost " + wager + " dollars! You now have " + userBank + " dollars!");
								}
							else
								{
									JOptionPane.showMessageDialog(frame, "Roll again?");
									crapsPart2 = true; 
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
			JOptionPane.showMessageDialog(frame,"You rolled " + die1 + " and a " + die2 + " for a total of " + totalDice);
			if (totalDice ==12)
				{
					JOptionPane.showMessageDialog(frame, "You lost");
					userBank = userBank - wager;
					JOptionPane.showMessageDialog(frame, "You lost " + wager + " dollars! You now have " + userBank + " dollars!");
				}
			JOptionPane.showMessageDialog(frame, "You have no more money and have been kicked out of the Casino. Goodbye");
			System.exit(0);
		}
		public static void playAgain ()
			{
				Object[] options = {"Yes", "No"};
				int playAgain = JOptionPane.showOptionDialog(frame, "Play again?",
						"Play Again",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, options, options[0]);
					if (playAgain == 0)
						{
							if (userBank==0)
								{
									JOptionPane.showMessageDialog(frame, "You have no more money and have been kicked out of the Casino. Goodbye");
									System.exit(0);
								}
							if (name.toLowerCase().equals("jim"))
								{
									userWager();
									playingGameWell();
								}
							if (name.toLowerCase().contains("v"))
								{
									userWager();
									playingGameWell();
								}
							if (name.toLowerCase().contains("E"))
								{
									userWager();
									playingGamePoorly();
								}
							else
								{
									userWager ();
									playingGame ();
								}
						}
					else if (playAgain== 1)
						{
							JOptionPane.showMessageDialog(frame, "Thanks for playing " + name + ". Go do something more entertaining, I guess.");
							System.exit(0);
						}
					else 
						{
							userWager ();
							playingGame();
						}
			}
		}

