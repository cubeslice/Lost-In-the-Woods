package story;

import java.util.Scanner;
import mechanics.Combat;
import mechanics.RNG;

public class LostInTheWoodsGame {
	public static void main(String args[]) {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Instructions:\n"
				+ "Input only the given integers. Anything else will not work. Put your integer at the bottom "
				+ "of the console. Some options are probability based. \nIf your answer is not processed at "
				+ "first, press enter again. Now, on to the game.");
		System.out.println(
				"You are lost in the deep, dark, woods. " + "You see a hut, an old car, and a worn down bike.");
		System.out.println("\t1. Walk towards the hut.\n" + "\t2. Get in the car.\n" + "\t3. Get on the bike. \n"
				+ "\t4. Head deeper into the woods.");
		int opt = keyboard.nextInt();
		if(opt>4) {
			opt = 4;
		}
		if(opt<1) {
			opt = 1;
		}
		switch (opt) {
		case 1:
			boolean windowdeath = false;
			boolean doorfight = false;
			boolean catacombs = false;
			boolean trapdoor = false;
			System.out.println("You head towards the hut, and eventually reach it. It's old and worn down, "
					+ "with a beaten door, cracked windows, and a back garden. Here are your options:");
			System.out.println("\t1. Enter through the door.\n" + "\t2. Enter through a window.\n"
					+ "\t3. Go to the back garden.\n" + "\t4. Circle around the hut.");
			opt = keyboard.nextInt();
			if(opt>4) {
				opt = 4;
			}
			if(opt<1) {
				opt = 1;
			}
			switch (opt) {
			case 1:
				doorfight = true;
				break;
			case 2:
				windowdeath = true;
				break;
			case 4:
				System.out.println("As you circle around the hut, you walk past an open window. As you do, you make"
						+ " eye contact with a man sitting inside. He springs up, knife in hand, and with \none "
						+ "smooth motion throws it towards your head. The knife enters your eye socket. As "
						+ "you die out, you hear the man laughing.\nRestart the game.");
				break;
			case 3:
				System.out.println("You go to the back garden. There is a window looking into the hut, along with a"
						+ " door. But you also find a locked trapdoor hidden in the garden. Here are your options:\n"
						+ "\t1. Go through the door. \n" + "\t2. Go through the window. \n"
						+ "\t3. Try to open the trapdoor. \n" + "\t4. Explore the garden more.");
				opt = keyboard.nextInt();
				if(opt>4) {
					opt = 4;
				}
				if(opt<1) {
					opt = 1;
				}
				switch (opt) {
				case 1:
					doorfight = true;
					break;
				case 2:
					windowdeath = true;
					break;
				case 3:
					int a = RNG.randomNumber(5) + 1;
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
					break;
				case 4:
					System.out.println("As you explore the garden, you find a key and a knife hidden in a "
							+ "potted plant. Here are your options:\n" + "\t1. Go through the door with the knife.\n"
							+ "\t2. Go through the window with the knife.\n"
							+ "\t3. Unlock the trapdoor with the key and enter with the knife.\n"
							+ "\t4. Leave both and go through the door.");
					opt = keyboard.nextInt();
					if(opt>4) {
						opt = 4;
					}
					if(opt<1) {
						opt = 1;
					}
					switch (opt) {
					case 1:
						System.out.println("You burst through the door, knife in hand. You see a man sitting on"
								+ " a chair inside. He springs to his feet, wielding a knife of his own. "
								+ "\nHere are your options:\n" + "\t1. Slash at his head.\n"
								+ "\t2. Thrust at his stomach.\n" + "\t3. Feint left, go right.\n" + "\t4. Run away.");
						opt = keyboard.nextInt();
						if(opt>4) {
							opt = 4;
						}
						if(opt<1) {
							opt = 1;
						}
						switch (opt) {
						case 1:
							a = RNG.randomNumber(10) + 1;
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
							break;
						case 2:
							a = RNG.randomNumber(4) + 1;
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
							break;
						case 3:
							a = RNG.randomNumber(2) + 1;
							if (a == 1) {
								System.out.println("You feint left. As you do, the man dodges right, and your "
										+ "follow up cut catches him in the neck. As you lay there panting, you"
										+ "notice a stairwell descending \ninto the darkness, with the scent of "
										+ "death in the air. You descend.");
								catacombs = true;
							}
							break;
						case 4:
							System.out.println("You try to run away, but the man chases you down, tackling "
									+ "you to the ground. He stabs you in the chest. As you bleed out, "
									+ "you hear his laughter.\nRestart the game.");
							break;
						}
						break;
					case 2:
						windowdeath = true;
						break;
					case 3:
						System.out.println("You quickly unlock the trapdoor with the key. ");
						trapdoor = true;
						break;
					case 4:
						doorfight = true;
						break;
					}
					break;
				}
				break;
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
				if (Combat.beatEnemy(40, true)) {
					doorfight = false;
					catacombs = true;
				} else {
					System.out.println("Restart the game");
					doorfight = false;
				}
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
						+ "\ntransluscent figure. Here are your options:\n" + "\t1. Attack the figure.\n"
						+ "\t2. Run away.\n" + "\t3. Slowly step away.\n" + "\t4. Do nothing.\n");
				opt = keyboard.nextInt();
				if(opt>4) {
					opt = 4;
				}
				if(opt<1) {
					opt = 1;
				}
				switch (opt) {
				case 1:
					System.out.println("You strike at the figure. It passes through harmlessly. The"
							+ "figure grabs your head, and everything turns black.\nRestart the game.");
					break;
				case 3:
					System.out.println("You slowly step away, avoiding eye contact with the figure. Just as you think "
							+ "you are out of danger, the figure rushes out at you, and as it touches your \nchest, "
							+ "you feel as if it is impossible to breath. As you slowly die, you see the figure "
							+ "fade away into the darkness.\nRestart the game.");
					break;
				case 4:
					System.out.println("You stand perfectly still, not moving an inch. The figure reaches out, as if"
							+ " to touch your face. With the figure's hand an inch from your face, you try to \nmove, "
							+ "but your body refuses to obey you. As the figure's hand reaches your face, your "
							+ "vision darkens.\nRestart the game.");
					break;
				case 2:
					System.out.println("You sprint away from the figure. When you cannot see the figure anymore, you"
							+ " catch your breath. Looking ahead, you see daylight, and with that, safety.\n"
							+ "You have achieved the catacombs ending.");
					break;
				}
			}
			break;
		case 2:
			boolean outsidedeath = false;
			boolean cop = false;
			System.out.println("You try to enter the car, but it's locked. Here are your options:\n"
					+ "\t1. Bang on the door.\n" + "\t2. Break the window.\n" + "\t3. Look around the car.\n"
					+ "\t4. Run away from the car.");
			opt = keyboard.nextInt();
			if(opt>4) {
				opt = 4;
			}
			if(opt<1) {
				opt = 1;
			}
			switch (opt) {
			case 1:
				System.out.println("You bang on the door of the car. The sound attracts a hunched creature. ");
				outsidedeath = true;
				break;
			case 3:
				System.out.println(
						"You look around the car. As you do, you notice a hunched creature waiting in the darkness.");
				outsidedeath = true;
				break;
			case 4:
				System.out.println("You try to run away from the car, but come face to face with a hunched creature. ");
				outsidedeath = true;
				break;
			case 2:
				System.out.println("You break the window, and unlock the car door through the broken window. You then"
						+ " sit in the drivers seat. As you turn the ignition, in the rearview mirror you see \na "
						+ "hunched creature running toward you. You quickly press the accelerator, but the creature "
						+ "jumps on the car. Here are your options:\n" + "\t1. Keep driving.\n"
						+ "\t2. Drive left and right.\n" + "\t3. Brake.\n" + "\t4. Jump out of the car.");
				int option3 = keyboard.nextInt();
				switch (option3) {
				case 1:
					System.out.println("You keep driving, too scared to do anything else. ");
					int a = RNG.randomNumber(3) + 1;
					if (a == 1) {
						System.out.println("Eventually, you see the creature let go. ");
						cop = true;
					} else
						System.out.print(
								"The creature crawls aross the top of the car. When it is right above you, the creature "
										+ "reaches through the window and grabs your throat. You try to break its grip, but its rough "
										+ "hand would not let go. Just as \nyou think you might escape from its grip, you crash into a tree."
										+ "\nRestart the game.");
					break;
				case 2:
					System.out.println("By driving left and right, you manage to shake the creature off your car. ");
					cop = true;
					break;
				case 3:
					System.out.println(
							"You slam the break. However, you are not wearing a seat belt. Your head cracks against"
									+ " the steering wheel, and you experience a sudden stab of pain before you are engulfed by darkness."
									+ "\nRestart the game.");
					break;
				case 4:
					System.out.println(
							"You open the door and jump out of the car. However, the creature jumps with you, grabbing your"
									+ " throat as you hit the ground. You struggle for a brief moment, but you are overpowered by the "
									+ "sheer strength \nof the creature. As your vision goes dark, you hear the creature let out a bloodcurdling"
									+ " howl.\nRestart the game.");
					break;
				}
				if (outsidedeath == true) {
					System.out.println("At first the creature does not move. But as you take a step, it charges at you,"
							+ " savagely clawing your throat. You try to resist, but the creature succeeds in \nripping out your throat."
							+ " Before you die, you hear the creature let out a bloodcurdling howl.\nRestart the game.");
				}
				if (cop == true) {
					System.out.println(
							"You keep driving, lookng for any sign of civilization. After what seems like an eternity, you "
									+ "see a silhouetted man wearing what seems to be blue clothes. Here are your options:\n"
									+ "\t1. Run him over.\n" + "\t2. Drive around him.\n"
									+ "\t3. Stop the car and see who he is.\n" + "\t4. Find a different route.");
					int option4 = keyboard.nextInt();
					switch (option4) {
					case 1:
						System.out.println(
								"You keep driving, determined to run the man. You hear him yell, \"Stop!\" but you continue "
										+ "heading towards him. The man pulls out a gun and aims it at your head. Before you have time "
										+ "to process anything \nelse, he fires his gun, and you feel a piercing pain in your head.\nRestart "
										+ "the game.");
						break;
					case 2:
						System.out.println(
								"You try to drive around him, but he yells \"Stop!\" as you pass him. You keep going,"
										+ " not wanting to slow down. The man takes out a gun, and seeing this, you hesitate for a "
										+ "second before you crash into a tree.\nRestart the game.");
						break;
					case 3:
						System.out.println(
								"You stop the car and get out. The man comes closer, and you see that he is a cop."
										+ " He asks \"Is everything all right?\" And for the first time in a while, you feel safe.\n"
										+ "You have achieved the car ending.");
						break;
					case 4:
						System.out.println(
								"You put the car in reverse, trying to find a different route. You hear the man"
										+ " yell \"Stop!\" before pulling out a gun. Panicked, you try to drive away, but you"
										+ " your car crashes into a large tree.\nRestart the game.");
						break;
					}
				}
				break;
			}
			break;
		case 3:
			System.out.println(
					"You get on the bike. As you start pedaling, you hear a rustling of leaves. You ignore it, "
							+ "but soon after, a hunched creature tackles you off the bike. Pinning you to the ground, it tears "
							+ "out your throat, \nbefore letting out a bloodcurdling howl.\nRestart the game.");
			break;
		case 4:
			boolean beatWolf = false;
			boolean runPassedDriver = false;
			boolean sneakPassedDriver = false;
			boolean dirtCreature = false;
			System.out.println(
					"You start wandering aimlessly through the forest. While doing so, you head towards a worn and beaten down path. "
							+ "You see a knife left just left of the path. As you reach for the knife, \nyou see a vicious wolf, its eyes "
							+ "trained on yours. Here are your options:\n");
			System.out.println("\t1. Pick up the knife. \n" + "\t2. Hide behind the tree to your right. \n"
					+ "\t3. Yell at the wolf. \n" + "\t4. Freeze in place.");
			opt = keyboard.nextInt();
			if(opt>4) {
				opt = 4;
			}
			if(opt<1) {
				opt = 1;
			}
			switch (opt) {
			case 1:
				System.out.println("You pick up the  knife and get ready to fight the wolf.");
				if (Combat.beatEnemy(40, true)) {
					beatWolf = true;
				}
				break;
			case 2:
				System.out.println("You scamper to the right, only to realize there was no tree there. The last thing "
						+ "you see are the green, glowing eyes of the wolf as it jumps on you.");
				System.out.println("Restart the game.");
				break;
			case 3:
				System.out.println(
						"\"Stay away!\" you yell. The wolf is unphased by your words. You back up slowly as it crawls toward you, step by step, "
								+ "until your back hits the trunk of a large tree.\n As it gets closer, you notice the fresh blood coating its fur. It snorts "
								+ ", as if laughing at your futile effort to get away, then rips your throat out.");
				System.out.println("Restart the game.");
				break;
			case 4:
				System.out.println(
						"You freeze in place, hoping the wolf would think you were just a sillhouette in the darkness. The wolf sniffs the air, then "
								+ "starts walking toward you. He stops at your feet, and your\neyes widen as the wolf's glowing, green eyes look straight into yours. It tackles you to the ground "
								+ "and you break your skull on a large rock behind you.");
				System.out.println("Restart the game.");
				break;
			}
			if (beatWolf) {
				System.out.println(
						"You allow yourself to catch your breath. After you are ready, you start jogging,"
								+ " careful to dodge the low hanging branches. You enter a clearing where there are very \nfew trees. "
								+ "You can see a relatively clean pickup truck.");
				System.out.println("\t1. Inspect the truck. \n" + "\t2. Sneak past the truck. \n"
						+ "\t3. Run past the truck. \n" + "\t4. Go back into the forest.");
				opt = keyboard.nextInt();
				if(opt>4) {
					opt = 4;
				}
				if(opt<1) {
					opt = 1;
				}
				switch (opt) {
				case 1:
					System.out.println(
							"You cautiously walk up to the truck and look through the driver seat window. You see a large man with a blindfold on, snoring away. "
									+ "Do you:");
					System.out.println("\t1. Knock on the window. \n" + "\t2. Break the window. \n"
							+ "\t3. Sneak past the truck." + "\n\t4. Run past the truck.");
					opt = keyboard.nextInt();
					if(opt>4) {
						opt = 4;
					}
					if(opt<1) {
						opt = 1;
					}
					switch (opt) {
					case 1:
						System.out.println(
								"The man is jolted out of his sleep. He lifts his blindfold and his face finds yours. His face contorts with confusion as "
										+ "he rolls down the window. \"What is someone like you doing in the\n dangerous woods?\" he asks. \"I got lost,\" you reply. \"What?? How?\" He looks "
										+ "at you, obviously confused. \"Nevermind then. Do you need a ride out of here?\" Relief fills your body. \"Yes. Thanks man.\"");
						System.out.println("You have achieved the pickup truck ending.");
						break;
					case 2:
						System.out.println(
								"Slowly, you take a large piece of wood and smash the window. The sound of shattered glass pierces the air. The man "
										+ "jumps out of the driver's seat, hand grasping his knife. \"What in the world do you think you are doing?\" he shouts.");
						if (Combat.beatEnemy(60, false)) {
							System.out.println(
									"\"Why...\" the man croaks as he falls onto his knees. His body falls onto the floor. You go through his jacket and find the keys "
											+ "to the pickup truck and a map titled \"The Lost Woods.\" You start the car, find where you are on the map, and find your way out of the woods.");
							System.out.println("You have achieved the \"hijack\" ending.");
						}
						break;
					case 3:
						sneakPassedDriver = true;
						break;
					case 4:
						runPassedDriver = true;
						break;
					}
				case 2:
					sneakPassedDriver = true;
					break;
				case 3:
					runPassedDriver = true;
					break;
				case 4:
					dirtCreature = true;
					System.out.println("You head back into the forest.");
					break;
				}
				if (sneakPassedDriver) {
					int a = RNG.randomNumber(8);
					if (a <= 2) {
						System.out.println(
								"\"Hey! What do you think you are doing!\" says a gruff voice behind you. You stop running and turn around and see the pickup truck driver "
										+ "slowly walking toward you, pistol pointed straight at your heart.\n You hear a loud crack, and a sharp pain shoots through your body. As you fall "
										+ "to the floor, you notice a red substance slowly seeping into the grass. \"Is that... my blood?\" you wonder as your vison fades to black.");
					} else {
						System.out.println("You get by the truck without the driver noticing. ");
						dirtCreature = true;
					}
		
				}
			}
			if (runPassedDriver) {
				int a = RNG.randomNumber(1);
				if (a == 0) {
					System.out.println(
							"\"Hey! What do you think you are doing!\" says a gruff voice behind you. You slowly turn around and see the pickup truck driver "
									+ "slowly walking toward you, pistol pointed straight at your heart.\n You hear a loud crack, and a sharp pain shoots through your body. As you fall "
									+ "to the floor, you notice a red substance\n slowly seeping into the grass. \"Is that... my blood?\" you wonder as your vison fades to black.");
				}
			}
			if (dirtCreature) {
				System.out.println(
						"As you go back into the forest, a chill goes through your spine, and a deep, rumbling sound emanates from the ground."
								+ " The dirt a couple feet in front of you starts shifting, and a dirt creature pops out of the ground.");
				if (Combat.beatEnemy(50, false)) {
					System.out.println(
							"As you pull your knife from the creature, it lets out a strangled scream and disintegrates into dirt. "
									+ "You dust yourself off and go back into the woods. ");
				}

			}
		}
	}
}
