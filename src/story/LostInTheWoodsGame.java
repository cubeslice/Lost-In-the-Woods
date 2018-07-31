package story;

import java.util.Scanner;

import livingthings.*;
import mechanics.Combat;
import mechanics.RNG;

import java.util.Random;

public class LostInTheWoodsGame {
	public static void main(String args[]) {
		
		Combat x = new Combat();
		Player.health=90;
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Instructions:\n"
				+ "Input only the given integers. Anything else will not work. Put your integer at the bottom "
				+ "of the console. Some options are probability based. \nIf your answer is not processed at "
				+ "first, press enter again. Now, on to the game.");
		System.out.println("You are lost in the deep, dark, woods. "
				+ "You see a hut, an old car, and a worn down bike. Here are your options:");
		System.out.println("1- Walk towards the hut.\n" + "2- Get in the car.\n" + "3- Get on the bike. \n"
				+ "4- Head deeper into the woods.");
		int option1 = keyboard.nextInt();
		if (option1 == 1) {
			boolean windowdeath = false;
			boolean doorfight = false;
			boolean catacombs = false;
			boolean trapdoor = false;
			System.out.println("You head towards the hut, and eventually reach it. It's old and worn down, "
					+ "with a beaten door, cracked windows, and a back garden. Here are your options:");
			System.out.println("1- Enter through the door.\n" + "2- Enter through a window.\n"
					+ "3- Go to the back garden.\n" + "4- Circle around the hut.");
			int option2 = keyboard.nextInt();
			if (option2 == 1) {
				doorfight = true;
			}
			if (option2 == 2) {
				windowdeath = true;
			}
			if (option2 == 4) {
				System.out.println("As you circle around the hut, you walk past an open window. As you do, you make"
						+ " eye contact with a man sitting inside. He springs up, knife in hand, and with \none "
						+ "smooth motion throws it towards your head. The knife enters your eye socket. As "
						+ "you die out, you hear the man laughing.\nRestart the game.");
			}
			if (option2 == 3) {
				System.out.println("You go to the back garden. There is a window looking into the hut, along with a"
						+ " door. But you also find a locked trapdoor hidden in the garden. Here are your options:\n"
						+ "1- Go through the door. \n" + "2- Go through the window. \n"
						+ "3- Try to open the trapdoor. \n" + "4- Explore the garden more.");
				int option3 = keyboard.nextInt();
				if (option3 == 1) {
					doorfight = true;
				}
				if (option3 == 2) {
					windowdeath = true;
				}
				if (option3 == 3) {
					Random rand = new Random();
					int a = rand.nextInt(5) + 1;
					if (a == 1) {
						System.out.println("After yanking on the lock, you manage to break it open. ");
						trapdoor = true;
					} else {
						System.out.println("You go to the trapdoor. You try to open it, but it is locked. As "
								+ "you strain against the trapdoor, you hear footsteps behind you. "
								+ "As you turn around, a man\n"
								+ "with a knife thrusts his weapon into your chest. He laughs as you bleed out.\n"
								+ "Restart the game.");
					}
				}
				if (option3 == 4) {
					System.out.println("As you explore the garden, you find a key and a knife hidden in a "
							+ "potted plant. Here are your options:\n" + "1- Go through the door with the knife.\n"
							+ "2- Go through the window with the knife.\n"
							+ "3- Unlock the trapdoor with the key and enter with the knife.\n"
							+ "4- Leave both and go through the door.");
					int option4;
					option4 = keyboard.nextInt();
					if (option4 == 1) {
						System.out.println("You burst through the door, knife in hand. You see a man sitting on"
								+ " a chair inside. He springs to his feet, wielding a knife of his own. "
								+ "\nHere are your options:\n" + "1- Slash at his head.\n"
								+ "2- Thrust at his stomach.\n" + "3- Feint left, go right.\n" + "4- Run away.");
						int option5 = keyboard.nextInt();
						if (option5 == 1) {
							Random rand = new Random();
							int a = rand.nextInt(10) + 1;
							if (a == 1) {
								System.out.println("You slash at his head. The man tries to dodge, but you manage "
										+ "to cut his throat. As you lay there panting, you  notice a stairwell "
										+ "descending \ninto the darkness, with the scent of death in the air."
										+ " You descend.");
								catacombs = true;
							} else {
								System.out.println("You slash at his head. The man easily avoids your attack, "
										+ "and thrusts his knife into your chest. As you bleed out, you hear "
										+ "his laughter.\n Restart the game.");
							}
						}
						if (option5 == 2) {
							Random rand = new Random();
							int a = rand.nextInt(4) + 1;
							if (a == 1) {
								System.out.println("You thrust at his stomach. The man tries to dodge, but you manage "
										+ "to stab him. As you lay there panting, you notice a stairwell "
										+ "descending \ninto the darkness, with the scent of death in the air. "
										+ "You descend.");
								catacombs = true;
							} else {
								System.out.println("You thrust at his stomach. The man easily avoids your attack, "
										+ "and thrusts his knife into your chest. As you bleed out, you hear "
										+ "his laughter.\n Restart the game.");
							}
						}
						if (option5 == 3) {
							Random rand = new Random();
							int a = rand.nextInt(2) + 1;
							if (a == 1) {
								System.out.println("You feint left. As you do, the man dodges right, and your "
										+ "follow up cut catches him in the neck. As you lay there panting, you"
										+ "notice a stairwell descending \ninto the darkness, with the scent of "
										+ "death in the air. You descend.");
								catacombs = true;
							}
						}
						if (option5 == 4) {
							System.out.println("You try to run away, but the man chases you down, tackling "
									+ "you to the ground. He stabs you in the chest. As you bleed out, "
									+ "you hear his laughter.\nRestart the game.");
						}
					}
					if (option4 == 2) {
						windowdeath = true;
					}
					if (option4 == 3) {
						System.out.println("You quickly unlock the trapdoor with the key. ");
						trapdoor = true;
					}
					if (option4 == 4) {
						doorfight = true;
					}
				}
			}
			if (windowdeath == true) {
				System.out.println("You enter through the window. Your arms and legs get cut badly as you "
						+ "climb through the window. A man with a knife awaits you, and plunges his weapon \ninto"
						+ " your throat. You see him smile as you begin to lose your grip on life.\n"
						+ "Restart the game.");
			}
			if (doorfight == true) {
				System.out.println("You enter through the door. It makes a loud creak as you open it. "
						+ "A man with a knife awaits you, and you get ready to fight.");
				x.beatEnemy();
				if (x.beatEnemy()) {
					catacombs = true;
				}
				else System.out.println("Restart the game");
			}
			if (trapdoor == true) {
				System.out.println("As you open the trapdoor, you are greeted by air that reeks of death. Steeling"
						+ " yourself, you jump in.");
				catacombs = true;
			}
			if (catacombs == true) {
				System.out.print("As you enter, a feeling of dread creeps through your bones. You are surrounded"
						+ " by tombs of the dead, the only light being from a few well-spaced torches. \nYou walk "
						+ "down a hallway for what seems like forever, when suddenly you feel a cold numbness in "
						+ "your arm. You turn around, and come face to face with a pale, "
						+ "\ntransluscent figure. Here are your options:\n" + "1- Attack the figure.\n"
						+ "2- Run away.\n" + "3- Slowly step away.\n" + "4- Do nothing.\n");
				int option6 = keyboard.nextInt();
				if (option6 == 1) {
					System.out.println("You strike at the figure with your knife. It passes through harmlessly. The"
							+ "figure grabs your head, and everything turns black.\nRestart the game.");
				}
				if (option6 == 3) {
					System.out.println("You slowly step away, avoiding eye contact with the figure. Just as you think "
							+ "you are out of danger, the figure rushes out at you, and as it touches your \nchest, "
							+ "you feel as if it is impossible to breath. As you slowly die, you see the figure "
							+ "fade away into the darkness.\nRestart the game.");
				}
				if (option6 == 4) {
					System.out.println("You stand perfectly still, not moving an inch. The figure reaches out, as if"
							+ " to touch your face. With the figure's hand an inch from your face, you try to \nmove, "
							+ "but your body refuses to obey you. As the figure's hand reaches your face, your "
							+ "vision darkens.\nRestart the game.");
				}
				if (option6 == 2) {
					System.out.println("You sprint away from the figure. When you cannot see the figure anymore, you"
							+ " catch your breath. Looking ahead, you see daylight, and with that, safety.\n"
							+ "You have achieved the catacombs ending.");
				}
			}
		}
		if (option1 == 2) {
			boolean outsidedeath = false;
			boolean cop = false;
			System.out.println(
					"You try to enter the car, but it's locked. Here are your options:\n" + "1- Bang on the door.\n"
							+ "2- Break the window.\n" + "3- Look around the car.\n" + "4- Run away from the car.");
			int option2 = keyboard.nextInt();
			if (option2 == 1) {
				System.out.println("You bang on the door of the car. The sound attracts a hunched creature. ");
				outsidedeath = true;
			}
			if (option2 == 3) {
				System.out.println(
						"You look around the car. As you do, you notice a hunched creature waiting in the darkness.");
				outsidedeath = true;
			}
			if (option2 == 4) {
				System.out.println("You try to run away from the car, but come face to face with a hunched creature. ");
				outsidedeath = true;
			}
			if (option2 == 2) {
				System.out.println("You break the window, and unlock the car door through the broken window. You then"
						+ " sit in the drivers seat. As you turn the ignition, in the rearview mirror you see \na "
						+ "hunched creature running toward you. You quickly press the accelerator, but the creature "
						+ "jumps on the car. Here are your options:\n" + "1- Keep driving.\n"
						+ "2- Drive left and right.\n" + "3- Brake.\n" + "4- Jump out of the car.");
				int option3 = keyboard.nextInt();
				if (option3 == 1) {
					System.out.println("You keep driving, too scared to do anything else. ");
					Random rand = new Random();
					int a = rand.nextInt(3) + 1;
					if (a == 1) {
						System.out.println("Eventually, you see the creature let go. ");
						cop = true;
					}
					else
						System.out.print(
								"The creature crawls aross the top of the car. When it is right above you, the creature "
										+ "reaches through the window and grabs your throat. You try to break its grip, but its rough "
										+ "hand would not let go. Just as \nyou think you might escape from its grip, you crash into a tree."
										+ "\nRestart the game.");
				}
				if (option3 == 2) {
					System.out.println("By driving left and right, you manage to shake the creature off your car. ");
					cop = true;
				}
				if (option3 == 3) {
					System.out.println(
							"You slam the break. However, you are not wearing a seat belt. Your head cracks against"
									+ " the steering wheel, and you experience a sudden stab of pain before you are engulfed by darkness."
									+ "\nRestart the game.");
				}
				if (option3==4) {
					System.out.println("You open the door and jump out of the car. However, the creature jumps with you, grabbing your"
							+ " throat as you hit the ground. You struggle for a brief moment, but you are overpowered by the "
							+ "sheer strength \nof the creature. As your vision goes dark, you hear the creature let out a bloodcurdling"
							+ " howl.\nRestart the game.");
				}
				if (outsidedeath == true) {
					System.out.println("At first the creature does not move. But as you take a step, it charges at you,"
							+ " savagely clawing your throat. You try to resist, but the creature succeeds in \nripping out your throat."
							+ " Before you die, you hear the creature let out a bloodcurdling howl.\nRestart the game.");
				}
				if (cop == true) {
					System.out.println("You keep driving, lookng for any sign of civilization. After what seems like an eternity, you "
							+ "see a silhouetted man wearing what seems to be blue clothes. Here are your options:\n"
							+ "1- Run him over.\n"
							+ "2- Drive around him.\n"
							+ "3- Stop the car and see who he is.\n"
							+ "4- Find a different route.");
					int option4 = keyboard.nextInt();
					if (option4 == 1) {
						System.out.println("You keep driving, determined to run the man. You hear him yell, \"Stop!\" but you continue "
								+ "heading towards him. The man pulls out a gun and aims it at your head. Before you have time "
								+ "to process anything \nelse, he fires his gun, and you feel a piercing pain in your head.\nRestart "
								+ "the game.");
					}
					if (option4 == 2) {
						System.out.println("You try to drive around him, but he yells \"Stop!\" as you pass him. You keep going,"
								+ " not wanting to slow down. The man takes out a gun, and seeing this, you hesitate for a "
								+ "second before you crash into a tree.\nRestart the game.");
					}
					if (option4 == 3) {
						System.out.println("You stop the car and get out. The man comes closer, and you see that he is a cop."
								+ " He asks \"Is everything all right?\" And for the first time in a while, you feel safe.\n"
								+ "You have achieved the car ending.");
					}
					if (option4 == 4) {
						System.out.println("You put the car in reverse, trying to find a different route. You hear the man"
								+ " yell \"Stop!\" before pulling out a gun. Panicked, you try to drive away, but you"
								+ " notive");
					}
				}
			}
		}
		if (option1 == 3) {
			System.out.println("You get on the bike. As you start pedaling, you hear a rustling of leaves. You ignore it, "
					+ "but soon after, a hunched creature tackles you off the bike. Pinning you to the ground, it tears "
					+ "out your throat, \nbefore letting out a bloodcurdling howl.\nRestart the game.");
		}
	}
}
