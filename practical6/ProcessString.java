public class ProcessString {
	String string;
	ProcessString(String string) {
		this.string = string;
	}
	
	public int[] process() {
		int len = string.length();
		int digits = 0;
		int characters = 0;
		int temp[] = new int[2];
		
		for(int i = 0;i < string.length(); i++){
			if(Character.isDigit(string.charAt(i))) {
				digits++;
			}else if(Character.isLetter(string.charAt(i))) {
				characters++;
			}
		}
		temp[0] = digits;
		temp[1] = characters;
		
		return temp;
	}
}