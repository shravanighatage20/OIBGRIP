import java.util.*;
class BankAcc
{
	Scanner sc = new Scanner(System.in);
	double bal=1000;
	int acc,prevTrans,flag=0;
	String name,id;
	BankAcc()
	{
	}
	BankAcc(String n,String i)
	{
		name = n;
		id = i;
	}
	void login()
	{
		System.out.println("Enter your customer ID:");
		String s = sc.nextLine();
		if(s.equals(id))
		{
			System.out.println("\n\t\tLogged in successfully!\n\t\tWelcome "+name+"!\n");
			menu();
		}
		else
		{
			flag++;
			System.out.println("\tLogin unsuccessful!\n\tTry Again!");
			if(flag<3)
			{
				login();
			}
		}
		if(flag==3)
		{
			System.out.println("You have exceeded number of tries!");
			System.exit(0);
		}	
	}
	public void menu()
	{
		int ch;
		do
		{
			System.out.println("Enter your choice: \n1.Transaction history \n2.Withdraw ");
			System.out.println("3.Deposit \n4.Transfer \n5.View balance \n6.Quit");
			ch = sc.nextInt();
			System.out.println();
			switch(ch)
			{
				case 1:		//transaction history
					getPrevTrans();
					break;
				case 2:		//withdraw
					System.out.println("Enter amount:");
					int amtW = sc.nextInt();
					if(amtW>bal)
					{
						System.out.println("Insufficient balance!");
						break;
					}
					withdraw(amtW);
					break;
				case 3:		//deposit
					System.out.println("Enter amount:");
					int amtD = sc.nextInt();
					deposit(amtD);
					break;
				case 4:		//transfer
					BankAcc b1 = new BankAcc("Phoebe","742");
					System.out.println("Transfeering money to "+b1.name);
					System.out.println();
					System.out.println("Enter amount:");
					double amtT = sc.nextDouble();
					if(amtT>bal)
					{
						System.out.println("Insufficient balance!");
						break;
					}
					transfer(amtT,b1);
					break;
				case 5:		//Balance info
					System.out.println("Your current balanace is: Rs."+bal);
					break;
				case 6:		//quit
					System.out.println("\tSystem exiting! \n\tBye!");
					System.exit(0);
				default:
					System.out.println("Enter a valid choice!");
					break;
			}
		}while(ch!=6);
	}
	void withdraw(int amt)
	{
		bal-=amt;
		prevTrans=-amt;
		System.out.println("Amount withdrawn succuessfully!");
	}
	void deposit(int amt)
	{
		bal+=amt;
		prevTrans=amt;
		System.out.println("Amount deposited successfully!");
	}
	void getPrevTrans()
	{
		if(prevTrans>0)
			System.out.println("You deposited Rs."+prevTrans);
		else if(prevTrans<0)
			System.out.println("You withdrawn Rs."+(-1*prevTrans));
		else
			System.out.println("You have not done any transaction yet");
	}
	void transfer(double amt,BankAcc b1)
	{
		bal-=amt;
		b1.bal+=amt;
		System.out.println("Your balance is Rs."+bal);
		System.out.println(b1.name+"'s balance is Rs."+b1.bal);
	}
}

class ATM
{
	public static void main(String args[])
	{
		BankAcc b = new BankAcc("abc","1234");
		b.login();
	}
}