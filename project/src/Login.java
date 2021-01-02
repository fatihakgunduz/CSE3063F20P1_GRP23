import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	private String password;
	private String username;
	
	public Login() {
		super();
	}

	public void loginInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("USERNAME?\t");
		this.username = sc.nextLine();  // Read user input
		System.out.println();
		System.out.print("PASSWORD?\t");
		this.password = sc.nextLine();
	}
	
	public void loginInputAgain() {
		System.out.println("You entered a wrong username or password! Please try again.");
		Scanner sc = new Scanner(System.in);
		System.out.print("Username?\t");
		this.username = sc.nextLine();  // Read user input
		System.out.println();
		System.out.print("Password?\t");
		this.password = sc.nextLine();
	}
	
	public long loginCheck(ArrayList<User> userList) {
		int strlen = username.length();
		int strlenP = password.length();
		
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i) instanceof HumanUser) {
				if(userList.get(i).getUserName().equals(username) && userList.get(i).getPassword().equals(password)) {
					return userList.get(i).getId();
				}
			}
		}
		if(strlen == 0 && strlenP == 0) {
			return -1;
		}
		return 0;
	}
}
