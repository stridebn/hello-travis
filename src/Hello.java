
public class Hello {

	public static void main(String[] args) {
		if (args == null || args.length == 0)
			defaultMessage();
		else {
			personalizedMessage(args[0]);
		}
	}
	static void defaultMessage() {
		System.out.println("Hello, Jay.");
	}
	static void personalizedMessage(String person) {
		System.out.println("Hello, " + person + ".");
	}
}
