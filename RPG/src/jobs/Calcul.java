package jobs;

public class Calcul {
	

	public void printSkillMenu(Character character) {
		final int reset = 1;
		final int distributeRemaining = 2;
		
		System.out.println("Select an option\n" +
						   reset + " - reset skill points\n" +
						   distributeRemaining + " - distribute remaining skill points");
		
		//Take user input
		
		if (choice == reset) {
		
		} else if (choice == distributeRemaining) {
			distributeSkillPoints(character.getSkillTree());
		}
	}

	public void resetSkillPoints(Character character) {
	}

	public void distributeSkillPoints(int skillTree) {
		for (int remaining = skillTree.getRemainingPoints(); remaining > 0;) {
			Skill skill = chooseSkill(skillTree);
			int points = getPointsToDistribute(skill);
			skill.increase(points);
			remaining -= points;
		}
	}

	public int chooseSkill(int skillTree) {
		//Print the available skills
		//let the user choose a skill
		//return the chosen skill
	}

	public int getPointsToDistribute(int skill) {
		//Get how many points we should put into this skill
	}

	public static void main (String args[]){
		
	}
}