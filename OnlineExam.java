import java.util.*;
class OnlineExam
{
	Scanner sc = new Scanner(System.in);
	HashMap<String,Integer> info = new HashMap<String,Integer>();
	public void login()
	{
		info.put("user1",1212);
		info.put("user2",2323);
		info.put("user3",3434);
		info.put("user4",4545);
		info.put("user5",5656);
		String id;
		int pwd;
		System.out.println("Login to your account!");
		System.out.println("Enter your user ID:");
		id = sc.next();
		System.out.println("Enter your password:");
		pwd = sc.nextInt();
		if(info.containsKey(id) && info.get(id)==pwd)
		{
			System.out.println("\nLogin successful!");
			menu();
		}
		else
		{
			System.out.println("\nIncorrest user ID or password!\nTry again!\n");
			login();
		}
	}
	public void menu()
	{
		int ch;
		System.out.println("\nEnter your choice:");
		System.out.println("1.Update profile \n2.Start exam \n3.Logout");
		ch = sc.nextInt();
		switch(ch)
		{
			case 1:
				info = update();
				menu();
				break;
			case 2:
				startExam();
				menu();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Choose a valid operation!");
		}
	}
	public HashMap<String,Integer> update()
	{
		String update_id;
		int update_pwd;
		System.out.println("Enter your username:");
		update_id = sc.next();
		System.out.println("Enter your old password:");
		update_pwd = sc.nextInt();
		if(info.containsKey(update_id) && info.get(update_id)==update_pwd)
		{
			System.out.println("Enter new password:");
			update_pwd = sc.nextInt();
			info.replace(update_id,update_pwd);
			System.out.println("Password reset successfully!");
		}
		else
		{
			System.out.println("User record not found!\n");
		}
		return info;
	}
	public void startExam()
	{
		long startTime = System.currentTimeMillis();
		long endTime = startTime + 30;
		int score = 0,ans;
		
		System.out.println("Instructions:");
		System.out.println("1. There are 5 questions in this exam");
		System.out.println("2. All questions are compulsory");
		System.out.println("3. For each correct answer you will get 5 marks");
		System.out.println("4. For each wrong answer 1 mark will be reduced from your obtained marks");
		System.out.println("5. Time limit to complete the exam is 5 minutes");
		System.out.println("\n All The Best!\n");
		System.out.println("**********************Exam has started**********************");
		while(System.currentTimeMillis()<endTime)
		{
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q1.Which of the following is not an operating system?");
			System.out.println("1.Windows \t2.Linux \t3.Oracle\t4.DOS");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 3)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q2.What is maximum length of the filename in DOS?");
			System.out.println("1.4\t2.5\t3.12\t4.8");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 4)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q3.When was the first operating system developed?");
			System.out.println("1.1950\t2.1948\t3.1949\t4.1951");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 1)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q4.When were MS windows operating systems proposed?");
			System.out.println("1.1994\t2.1985\t3.1990\t4.1992");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 2)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q5.What else is the command interpreter called");
			System.out.println("1.prompt\t2.kernel\t3.shell\t4.command");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 3)
				score+=5;
			else
				score--;
			System.out.println("-------------------------------------------------------------");
			break;
		}
		System.out.println("Your exam has ended.");
		System.out.println();
		System.out.println("Your score is "+score);
		if(score>10)
			System.out.println("Congratulations!");
		else
			System.out.println("Better Luck Next Time!");
	}
	public static void main(String args[])
	{
		OnlineExam obj = new OnlineExam();
		obj.login();
	}
}