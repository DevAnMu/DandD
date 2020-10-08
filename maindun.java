package dungeons_and_dragons;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class scrapdun {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Dungeons and Dragons, please enter your mighty name");
		Scanner scanner = new Scanner (System.in);
		
		String name = scanner.nextLine();
		System.out.println("Greetings young warrior, "+name);
		
		boolean feelingBrave;
		feelingBrave = true;
		
		int score = 0;
		int lvlMax = 16;
		
	while (feelingBrave == true) {  
		
		System.out.println("you are now entering the dungeons");
		
		for (int lvl = 0; lvl < lvlMax; lvl++) {
			
			switch (lvl) {
			
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				
				int point1 = ThreadLocalRandom.current().nextInt(1, 5 + 1);
				int randomNum1 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
				System.out.println("10 doors ahead, a dragon behind one, which door shall you chose");
				
				int doorNum1 = scanner.nextInt();
				
				if (doorNum1 == randomNum1) {
				    System.out.println("DRAGON!");
				    System.out.println("You ran away");
				    feelingBrave = false; 
				   
				}
				else if (doorNum1 > 10 || doorNum1 < 1) {
				    System.out.println("There is no door there, please reenter door number");
				    
				    } 
				else {
				    System.out.println("No dragon, lucky you, move to the next entrance");
				    System.out.println("Along the way you found " + point1 + " gems!");
				    score += point1;
			
			    	}
				
				break; 
				
			case 6:
				
				System.out.println("Nice job, you made it to the second level!");
				
			case 7:
			case 8:
			case 9:
			case 10:
				
				int point2 = ThreadLocalRandom.current().nextInt(5, 15 + 1);
				int randomNum2 = ThreadLocalRandom.current().nextInt(1, 5 + 1);
				System.out.println("5 doors ahead, a dragon behind one, which door shall you chose");
				
				int doorNum2 = scanner.nextInt();
				
				if (doorNum2 == randomNum2) {
				    System.out.println("DRAGON!");
				    System.out.println("You ran away");
				    feelingBrave = false; 
				  
				}
				else if (doorNum2 > 5 || doorNum2 < 1) {
				    System.out.println("There is no door there, please reenter door number");
				    
				    } 
				else {
				    System.out.println("No dragon, lucky you, move to the next entrance");
				    System.out.println("Along the way you found " + point2 + " gems!");
				    score += point2;
			
			    	}
				break;
				
			case 11:
				
				System.out.println("Superb, you are now entering the 3rd dungeon");
				
			case 12:
			case 13:
			case 14:
			case 15: 
				
				int point3 = ThreadLocalRandom.current().nextInt(10, 20 + 1);
				int randomNum3 = ThreadLocalRandom.current().nextInt(1, 3 + 1);
				System.out.println("3 doors ahead, a dragon behind one, which door shall you chose");
				
				int doorNum3 = scanner.nextInt();
				
				if (doorNum3 == randomNum3) {
				    System.out.println("DRAGON!");
				    System.out.println("You ran away");
				    feelingBrave = false; 
			
				}
				else if (doorNum3 > 3 || doorNum3 < 1) {
				    System.out.println("There is no door there, please reenter door number");
				    
				    } 
				else {
				    System.out.println("No dragon, lucky you, move to the next entrance");
				    System.out.println("Along the way you found " + point3 + " gems!");
				    score += point3;
			
			    	}
				break;
				
			case 16: 
				
				System.out.println("You made it out of the dungeons, but the adventure continues...");
				continue; 
				
				}
		
		if (feelingBrave == false) {
			break;
			
			}
		}
	}
   
	String highScoreName = null;
	int highScore = 0;
	    
	try {
	    	FileReader fileName = new FileReader("scorelist.txt");
	        BufferedReader reader = new BufferedReader(fileName);
	        String line = reader.readLine();
	        while (line != null)                 // read the score file line by line
	        {
	            try {
	            	
	             String[] splitStr = line.split(", ");
	            	
	            	if (splitStr.length == 2) {
	            	
	            	highScoreName = splitStr[0];
	            	int points = Integer.parseInt(splitStr[1]);   // parse each line as an int
	                if (points > highScore)                       // and keep track of the largest
	                { 
	                		highScore = points; 
	                	}
	            	}
	           
	            } catch (NumberFormatException e1) {
	                // ignore invalid scores
	                System.err.println("ignoring invalid score: " + line);
	            }
	            line = reader.readLine();
	        }
	        reader.close();
	        
	    }catch (ArrayIndexOutOfBoundsException e2) {
	    	System.err.println("ERROR array index out of bounds");

	    }catch (FileNotFoundException e3) {
	        System.err.println("ERROR file not found");
	    
	    }catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
	    
	    System.out.println("You collected " + score + " gems!");
	 // display the high score
	    if (score > highScore)
	    {    
	        System.out.println("You now have the new high score! The previous high score was " + highScore);
//		     append the last score to the end of the file
	        try {
		        BufferedWriter output = new BufferedWriter(new FileWriter("scorelist.txt", true));
		        output.newLine();
		        output.append(name + ", " + score);
		        output.close();

		    } catch (IOException ex1) {
		        System.out.printf("ERROR writing score to file: %s\n", ex1);
		    }
	    } else if (score == highScore) {
	        System.out.println("You tied the high score!");
	    } else {
	        System.out.println("The all time high score was " + highScore + " by " + highScoreName);
	    }

	}
	       
		
	}
	
	
