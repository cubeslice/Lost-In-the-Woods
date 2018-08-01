package mechanics;

import java.util.Scanner;

import livingthings.*;

public class Combat {
	public static boolean beatEnemy(int power){ //Combat.beatEnemy(powerlevel)
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int playerHealth = (Player.health);
		int playerAttack = (Player.attack);
		int enemyHealth = RNG.randomNumber(power - 5, power + 5);
		int enemyAttack = RNG.randomNumber(power - 20, power - 5);
		int chance;
		while (enemyHealth > 0 && playerHealth > 0) {
			System.out.println("----------------------------------------------");
			System.out.println("\tYour Health: " + playerHealth);
			System.out.println("\tEnemy Health: " + enemyHealth);
			System.out.println("\n\tWhat would you like to do?");
			System.out.println("\t1. Attack");
			System.out.println("\t2. Heal");
			System.out.println("\t3. Run!");
			System.out.println("----------------------------------------------");
			int opt = keyboard.nextInt();
			switch (opt) {
			case 1:
				chance = RNG.randomNumber(20);
				if (chance <= 2) {
					System.out.println("You missed!");
				} else {
					int realAttack = RNG.randomNumber(playerAttack - 10, playerAttack + 10);
					enemyHealth -= realAttack;
					System.out.println("You have hit the enemy for " + realAttack + " damage.");
				}
				break;
			case 2:
				chance = RNG.randomNumber(20);
				if (chance <= 2) {
					System.out.println("You couldn't heal!");
				} else {
					int heal = RNG.randomNumber(20, 30);
					playerHealth += heal;
					if (playerHealth > 100)
						playerHealth = 100;
					System.out.println(heal + " HP has been restored to your health!");
				}
				break;
			case 3:
				chance = RNG.randomNumber(20);
				if (chance == 1) {
					System.out.println("You have successfully run away!");
					enemyHealth = 0;
					break;
				} else {
					System.out.println("You couldn't run away!");
				}
				break;
			default:
				System.out.println("That is an invalid input. The enemy gets a free hit.");
			}
			if (enemyHealth > 0) {
				int realEnemyAttack = RNG.randomNumber(enemyAttack - 5, enemyAttack + 5);
				playerHealth -= realEnemyAttack;
				System.out.println("The enemy has hit you for " + realEnemyAttack + " damage.");
			}
		}
		if (playerHealth > 0) {
			System.out.println("You have bested the enemy!");
			System.out.println("----------------------------------------------");
			return true;
		} else {
			System.out.println("You died.");
			System.out.println("----------------------------------------------");
			return false;
		}
	}
}
