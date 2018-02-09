
public class Bool {
	
	public static boolean HitStand(String player) {
		if (player.equals("hit") || player.equals("stand")) {
			return true;
		}
		return false;
	}

	public static boolean isChoice(String answer) {

		if (answer.equals("yes") || answer.equals("no")) {

			return true;
		}
		if (answer.equals("no")) {
			return false;
		}
		return false;
				
		
	}
	public static boolean isDouble(String answer) {

		if (answer.equals("double") || answer.equals("no")) {

			return true;
		}
				
		return false;
	}

}







