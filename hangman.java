import java.util.Scanner;
import java.util.Random;
public class hangman{
	static String country;
	static String guessed="";
	public static void main(String[] args)
	{	String p="again";
		String guess="";
		String miss="";

		Scanner k= new Scanner(System.in);
		while(p.equals("again")){
		int chance=1;
		guessed="";
		miss="";
		System.out.println("Welcome to Hangman! Guess the name of a country by choosing an alphabet! You get 7 chances!");
		country=country();		
		display("");
		while(chance<8  && !won(guessed)){
		System.out.print("Guess: ");
		
		guess = k.next();

		if (country.contains(guess)){display(guess);}
		else {miss= miss + guess; display("");}
		System.out.println("Miss: "+miss);
		chance++;
		System.out.println(Integer.toString(8-chance)+" guesses left!");

		}
		if(chance>=8){System.out.println("The answer was: "+country);}
		System.out.println("Play \"again\" or \"quit\"?");
		p= k.next();}
		System.out.println("Okay bye!");
		
	}
	public static String country(){//randomly choosing a country's name
		Random r= new Random();
		int n= r.nextInt(10);
		String[] lis= {"america","india","france","portugal","britain","spain","mexico","greece","zimbabwe","japan"};
		return lis[n];
	}
	public static void display(String guess){//dash representation of puzzle. call won function too
		if(guessed.equals("")){
		for(int i=0; i<country.length(); i++)
		{
			guessed= guessed+"-";
			
		}}
		if(!guess.equals("")){
			// find all occurrences forward
			char[] garray= guessed.toCharArray();
			for (int j = -1; (j = country.indexOf(guess, j + 1)) != -1; ) {
   			 
				garray[j]=guess.charAt(0);
			}	
			guessed=String.valueOf(garray);
		}
		System.out.println(guessed);
		if(won(guessed)){System.out.println("You got it!!");};//make a string inplay jo common ho, and initially equal to _ _ country name k acc, baad me add characters to it as per the guess
		
	}
	public static boolean won(String g){//to check if player won
		if (g.equals(country)){return true;}
		else {return false;}
	}
}