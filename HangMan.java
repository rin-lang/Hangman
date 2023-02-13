package com.mycompany.hangman;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class HangMan {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        //Level of Diffiulty
        //User can choose between easy, medium, hard, and expert modes for hang man
        //Easy = 1-6 characters, medium = 7-10 characters, hard = 11-15 characters, expert = 16+ 
        
        Scanner s = new Scanner(System.in);
        int difficulty = 0;
        boolean play = true;
        while(play){
        do{
                System.out.println("""
                                   Choose difficulty of game:
                                   Easy (1-6 letters)
                                   Medium (7-10 letters)
                                   Hard (11-15 letters)
                                   Expert (16+ letters)""");
                String userInput1 = s.nextLine();

                if(userInput1.equalsIgnoreCase("easy")){
                    difficulty = 1;
                    break;
                }
                else if(userInput1.equalsIgnoreCase("medium")){
                    difficulty = 2;
                    break;
                }
                else if(userInput1.equalsIgnoreCase("hard")){
                    difficulty = 3;
                    break;
                }
                else if(userInput1.equalsIgnoreCase("expert")){
                    difficulty = 4;
                    break;
                }
                else{
                    System.out.println("That mode of difficulty does not currently exist." + "\n");
                }
        }while(true);//end of diffculty selection while loop
       
        //Word Generation
        
        String word = HangManMethods.randomWord(difficulty);//generate a random word
        
        //Array and variable Creation
        
        int tracker = 10; //keeps track of how many times the user has guessed
        //String[] fullWordLetters = HangManMethods.separateLetters(fullWord);//separate the random word given by the letters and put each letter into its own spot
        String[] fullWord = new String[word.length()];
        for(int q = 0; q < fullWord.length; q++){
            fullWord[q] = (Character.toString(word.charAt(q)));
        }
        String[] answerGiven = new String[word.length()];//create a blank array whose length is same as the word length
        for(int i = 0; i < answerGiven.length; i++){
            answerGiven[i] = "_ ";
        }
        ArrayList<String> lettersGuessed = new ArrayList<>();//an array list of letters the user has guessed
        
        
        
        
            //dealing with user guesses
            while (HangManMethods.checkPoint(fullWord, answerGiven) && tracker > 0){
                System.out.println( "\n" + "Enter your guess: ");
                HangManMethods.displayHangMan(tracker);
                
                for( String answerGiven1: answerGiven){
                    System.out.print(answerGiven1);
                }
                String userInput2 = s.nextLine();
                System.out.println("\n" + "Your Guess: " + userInput2);

                //check if it's a possible guess, then check if it's been guessed before, then check if it's a correct guess
                if(HangManMethods.possibleGuesses(userInput2)){
                    if(HangManMethods.userGuessed(userInput2, lettersGuessed)){
                        System.out.println("You guessed that already, try something else." + "\n" + "You've Guessed: " + lettersGuessed + "\n");
                    }
                    else{
                        if(HangManMethods.isItCorrect(userInput2, word)){
                            System.out.println("That's right!" + "\n" + "You've Guessed: " + lettersGuessed + "\n" + "Lives Left: " + tracker);
                            HangManMethods.displayHangMan(tracker);
                            answerGiven = HangManMethods.wordDisplay(userInput2, word, answerGiven);
                            for (String answerGiven1 : answerGiven) {
                                System.out.print(answerGiven1);
                            }
                           // System.out.println("\t"+ word);
                        }//end of if it's a right guess
                        else{
                            tracker--;
                            System.out.println("That's wrong!" + "\n" + "You've Guessed: " + lettersGuessed + "\n" +"Lives Left: " + tracker);
                            HangManMethods.displayHangMan(tracker);
                            answerGiven = HangManMethods.wordDisplay(userInput2, word, answerGiven);
                            for (String answerGiven1 : answerGiven) {
                                System.out.print(answerGiven1);
                            }
                          //  System.out.println("\t"+word);
                        }
                    }//end of if it's a wrong guess
                }//end of if it is a letter
                else{
                    System.out.println("That's not a letter ... try again." +"\n");
                }//end of if it isn't a letter

            }//end of while loop for guesses
        if(Arrays.toString(fullWord).equals(Arrays.toString(answerGiven))){
            System.out.println("\nYou win! The word was " + word + ".");
        }
        else if(tracker == 0){
            System.out.println("\nGame Over..." + "\n" + "The word was " + word + ".");
        }
        
        
        System.out.println("Would you like to play again? [y/n]");
        Scanner t = new Scanner(System.in);
       
        while(true){
        String playAgain = t.nextLine();
        if(playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")){
            play = true;
            
            break;
        }
        else if(playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n")){
            play = false;
            break;
        }
        else{
            System.out.println("That's not an answer, please type \"y\" for yes or \"n\" for no.");
        }
        }//end of asking to play again while loop
    }//end of play again
    }//end of main method
/*

________
|      |
|      O
|     /|\
|     / \
|
_ _ _ _ _ _ 
    
*/
   
    
}//end of class



/*  while(true){
            System.out.println("Enter a single letter, uppercase or lowercase, to guess.");
            String userInput = s.nextLine();
            
            
            
           for(int i = 0; i < 26; i++){
                if(userInput.equalsIgnoreCase(possibleGuesses[i])){
                    //lettersGuessed[]
                    for(int j = 0; i < wordLength; i++){
                        if(userInput.equalsIgnoreCase(fullWordLetters[i])){
                            answerGiven[i] = userInput;
                        }//end of inner if
                    }//end of inner for while loop
                }
                else{
                    System.out.println("Hey, I told you to enter a single letter, upper or lower case, not " + userInput + ".");
                }//end of outter if else    
            }//end of outer for while loop 
        }//end of while loop */






