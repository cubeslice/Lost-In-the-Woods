package story;

import java.util.Scanner;

import livingthings.Player;
import mechanics.Combat;
import mechanics.RNG;

public class LostInTheWoodsGame {
	public static void main(String args[]) {

		boolean death = false;
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
		if (opt > 4) {
			opt = 4;
		}
		if (opt < 1) {
			opt = 1;
		}
		mainSwitch: switch (opt) {
		case 1:
			boolean windowfight = false;
			boolean doorfight = false;
			boolean catacombs = false;
			boolean trapdoor = false;
			boolean noKnife = false;
			System.out.println("You head towards the hut, and eventually reach it. It's old and worn down, "
					+ "with a beaten door, cracked windows, and a back garden. Here are your options:");
			System.out.println("\t1. Enter through the door.\n" + "\t2. Enter through a window.\n"
					+ "\t3. Go to the back garden.\n" + "\t4. Circle around the hut.");
			opt = keyboard.nextInt();
			if (opt > 4) {
				opt = 4;
			}
			if (opt < 1) {
				opt = 1;
			}
			switch (opt) {
			case 1:
				doorfight = true;
				break;
			case 2:
				windowfight = true;
				break;
			case 4:
				System.out.println("As you circle around the hut, you walk past an open window. As you do, you make"
						+ " eye contact with a man sitting inside. He springs up, knife in hand, and with \none "
						+ "smooth motion throws it towards your head. The knife enters your eye socket. As "
						+ "you die out, you hear the man laughing.");
				death = true;
				break;
			case 3:
				System.out.println("You go to the back garden. There is a window looking into the hut, along with a"
						+ " door. But you also find a locked trapdoor hidden in the garden. Here are your options:\n"
						+ "\t1. Go through the door. \n" + "\t2. Go through the window. \n"
						+ "\t3. Try to open the trapdoor. \n" + "\t4. Explore the garden more.");
				opt = keyboard.nextInt();
				if (opt > 4) {
					opt = 4;
				}
				if (opt < 1) {
					opt = 1;
				}
				switch (opt) {
				case 1:
					doorfight = true;
					break;
				case 2:
					windowfight = true;
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
					if (opt > 4) {
						opt = 4;
					}
					if (opt < 1) {
						opt = 1;
					}
					switch (opt) {
					case 1:
						noKnife = false;
						System.out.println(
								"You burst through the door with a knife. A man with a knife springs to his feet,"
										+ " ready to fight you.");
						if (Combat.beatEnemy(40, false, false, false)) {
							System.out.println(
									"You remove your knife from the man's throat. You then notice a stairway leading into the "
											+ "darkness. You enter.");
						} else
							death = true;
					case 2:
						windowfight = true;
						break;
					case 3:
						System.out.println("You quickly unlock the trapdoor with the key. ");
						trapdoor = true;
						noKnife = false;
						break;
					case 4:
						doorfight = true;
						break;
					}
					break;
				}
				break;
			}
			if (windowfight == true) {
				System.out.println("You enter through the window. Your arms and legs get cut badly as you "
						+ "climb through the window. A man with a knife awaits you, and you get ready to fight.");
				Player.attack = 10;
				Player.health = 30;
				if (Combat.beatEnemy(40, false, false, false)) {
					System.out.println(
							"As you get off of the man, you see a stairway leading into the darkness. You descend.");
					catacombs = true;
					windowfight = false;
				} else {
					System.out.println(
							"The man thrusts his knife into your throat. As you bleed out, you see him smile.");
					death = true;
					windowfight = false;
				}
			}
			if (doorfight == true) {
				System.out.println("You enter through the door. It makes a loud creak as you open it. "
						+ "A man with a knife awaits you, and you get ready to fight.");

				Player.attack = 10;
				if (Combat.beatEnemy(40, true, false, false)) {
					doorfight = false;
					catacombs = true;
				} else {
					doorfight = false;
					death = true;
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
				if (opt > 4) {
					opt = 4;
				}
				if (opt < 1) {
					opt = 1;
				}
				switch (opt) {
				case 1:
					System.out.println("You ready your knife, and get ready to fight the figure. ");
					if (noKnife) {
						Player.attack = 10;
					}
					if (Combat.beatEnemy(90, false, true, true)) {
						System.out.println(
								"You pull your knife from the figure. You run as far away as you can, until you see "
										+ "daylight. As you step in the sun, you finally feel safe.\nYou have achieved the \"catacombs\" ending.");
					}
					break;
				case 3:
					System.out.println("You slowly step away, avoiding eye contact with the figure. Just as you think "
							+ "you are out of danger, the figure rushes out at you, and as it touches your \nchest, "
							+ "you feel as if it is impossible to breath. As you slowly die, you see the figure "
							+ "fade away into the darkness.");
					death = true;
					break mainSwitch;
				case 4:
					System.out.println("You stand perfectly still, not moving an inch. The figure reaches out, as if"
							+ " to touch your face. With the figure's hand an inch from your face, you try to \nmove, "
							+ "but your body refuses to obey you. As the figure's hand reaches your face, your "
							+ "vision darkens.");
					death = true;
					break mainSwitch;
				case 2:
					System.out
							.println("You sprint away from the figure. You don't get far before the figure grabs you, "
									+ "draining the life from your body.");
					death = true;
					break mainSwitch;
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
			if (opt > 4) {
				opt = 4;
			}
			if (opt < 1) {
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
									+ " the steering wheel, and you experience a sudden stab of pain before you are engulfed by darkness.");
					break;
				case 4:
					System.out.println(
							"You open the door and jump out of the car. However, the creature jumps with you, grabbing your"
									+ " throat as you hit the ground. You struggle for a brief moment, but you are overpowered by the "
									+ "sheer strength \nof the creature. As your vision goes dark, you hear the creature let out a bloodcurdling"
									+ " howl.\nRestart the game.");
					break;
				}
<<<<<<< HEAD
				if (outsidedeath == true) {
					System.out.println("At first the creature does not move. But as you take a step, it charges at you,"
							+ " savagely clawing your throat. You try to resist, but the creature succeeds in \nripping out your throat."
							+ " Before you die, you hear the creature let out a bloodcurdling howl.");
					death = true;
				}
				if (cop == true) {
=======
			}
			if (outsidedeath == true) {
				System.out.println("At first the creature does not move. But as you take a step, it charges at you,"
						+ " savagely clawing your throat. You try to resist, but the creature succeeds in \nripping out your throat."
						+ " Before you die, you hear the creature let out a bloodcurdling howl.\nRestart the game.");
				break;
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
>>>>>>> e860c83024d231094b85790ffc5fc37d41f79d44
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
			if (opt > 4) {
				opt = 4;
			}
			if (opt < 1) {
				opt = 1;
			}
			switch (opt) {
			case 1:
				System.out.println("You pick up the  knife and get ready to fight the wolf.");
				if (Combat.beatEnemy(40, true, false, false)) {
					beatWolf = true;
					break;
				} else
					System.out.println(
							"The wolf lunges and hits the knife out of your hand. It clatters to the floor. Defenseless, you try to kick at "
									+ "the wolf, with no avail. It seems to smirk at you, then launches itself at your face.");
				death = true;
				break mainSwitch;
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
				System.out.println("You allow yourself to catch your breath. After you are ready, you start jogging,"
						+ " careful to dodge the low hanging branches. You enter a clearing where there are very \nfew trees. "
						+ "You can see a relatively clean pickup truck.");
				System.out.println("\t1. Inspect the truck. \n" + "\t2. Sneak past the truck. \n"
						+ "\t3. Run past the truck. \n" + "\t4. Go back into the forest.");
				opt = keyboard.nextInt();
				if (opt > 4) {
					opt = 4;
				}
				if (opt < 1) {
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
					if (opt > 4) {
						opt = 4;
					}
					if (opt < 1) {
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
						if (Combat.beatEnemy(90, false, true, true)) {
							System.out.println(
									"\"Why...\" the man croaks as he falls onto his knees. His body falls onto the floor. You go through his jacket and find the keys "
											+ "to the pickup truck and a map titled \"The Lost Woods.\" You start the car, find where you are on the map, and find your way out of the woods.");
							System.out.println("You have achieved the \"hijack\" ending.");
							break mainSwitch;
						} else {
							System.out.println("Restart the game.");
							break mainSwitch;
						}
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
								"\"Hey! What do you think you are doing!\" says a gruff voice behind you. You slowly and turn around and see the pickup truck driver "
										+ "slowly walking toward you, pistol pointed straight at your heart.\n You hear a loud crack, and a sharp pain shoots through your body. As you fall "
										+ "to the floor, you notice a red substance slowly seeping into the grass. \"Is that... my blood?\" "
										+ "you wonder as your vison fades to black.");
						death = true;
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
							"\"Hey! What do you think you are doing!\" says a gruff voice behind you. You stop running and turn around to see the pickup truck driver "
									+ "slowly walking toward you, pistol pointed straight at your heart.\n You hear a loud crack, and a sharp pain shoots through your body. As you fall "
									+ "to the floor, you notice a red substance\n slowly seeping into the grass. \"Is that... my blood?\" "
									+ "you wonder as your vison fades to black.");
					death = true;
				}
			}
			if (dirtCreature) {
				System.out.println(
						"As you go back into the forest, a chill goes through your spine, and a deep, rumbling sound emanates from the ground."
								+ " The dirt a couple feet in front of you starts shifting, and a dirt creature pops \nout of the ground.");
				if (Combat.beatEnemy(50, false, false, false)) {
					System.out.println(
							"As you pull your knife from the creature, it lets out a strangled scream and disintegrates into dirt. "
									+ "You dust yourself off and go back into the woods. \nYou don't get far before the dirt before you starts"
									+ " to bubble. A deep, loud roar shakes the ground, and a humongous dirt creature rises out of the ground.\n "
									+ "\"Ooh hoo hoo,\" the creature laughs. \"Nooboody passes the dirt gooolem.\"\n"
									+ "\t1. Fight the dirt creature.\n" + "\t2. Run away.\n" + "\t3. Stay still.\n"
									+ "\t4. Try to climb a tree.");
					int opt1 = keyboard.nextInt();
					if (opt1 > 4) {
						opt1 = 4;
					}
					if (opt1 < 1) {
						opt1 = 1;
					}
					switch (opt1) {
					case 1:
						System.out.println("You charge at the dirt golem, a shout on your lips.");
						if (Combat.beatEnemy(70, false, true, true)) {
							System.out.println(
									"As you plunge your knife into the golem, you feel a sudden sharp stab of pain in your arm."
											+ " Looking down, you see that your arm is\n covered by a layer of dirt. The dirt moves from your arm,"
											+ " to your torso, to your head. You look down. You are now completely made of dirt.\n"
											+ " You open your mouth, and a huge, deep roar shakes the forest. With horror, you realize that you are now the dirt golem."
											+ " \n\n You have achieved the \"golem\" ending.");
						} else
							System.out.println(
									"You stumble back from the golem, exhausted. \"Hoo hooo. Sooo cloose, yet soo far,\" it teases. It stomps toward you, your exhausted "
											+ "body refusing to move. \"Bye bye!\" it says cheerfully. The golem laughs as he crushes your skull in.");
						death = true;
						break mainSwitch;
					case 2:
						System.out.println(
								"You try to run away, but the dirt golem shoots a stone projectile at your head."
										+ " You feel a sudden sharp pain near your temple, and everything goes black.");
						death = true;
						break;
					case 3:
						System.out.println(
								"You stay perfectly still, not moving a muscle. With one swing, the golem knocks off your head.");
						death = true;
						break;
					default:
						System.out.println(
								"You try to climb a tree, but the golem grabs you and breaks your back on the very tree that you "
										+ "tried to climb.");
						death = true;
					}
				} else {
					System.out.println(
							"The creature engulfs your body, slowly suffocating you. As your vision slowly fades, you feel yourself"
									+ " sinking into the ground.");
					death = true;
				}
			}
			death = true;
		}
		if (death == true) {
			System.out.println("Restart the game.");
		}
	}
}
