//*************************************
//
//  WordLists.java
//
//  Class to aid with Scrabble
//  Programming Project 5, COMS W1004
//
//
//  Your Name: Tiffany Neumann
//  Your Uni:  tjn2124
//**************************************

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class WordLists{ 
    private File inFile;
    private ArrayList<String> list;
    
    //this converts the dictionary into an arraylist using scanner 
    public WordLists(String fileName) throws FileNotFoundException { 
        File inFile = new File(fileName);
        list = new ArrayList<String>();
        Scanner input = new Scanner(inFile);
        while (input.hasNextLine()) {
            list.add(input.nextLine());
        }
        input.close();
    }

    //returns an ArrayList of all length n words (Strings)
    // from the list ArrayList, converts the argument to a 
    //char to check if its a integer or not
    public ArrayList<String> lengthN(int n) throws IllegalArgumentException{
        if (n < 0) {
            throw new IllegalArgumentException("n can't be less than 0");
        }
        ArrayList<String> nWords = new ArrayList<String>();
        for(String x: list){
            if (x.length()==n){
                nWords.add(x);
            }
        }
        return nWords;
    }
     //returns an ArrayList of words of length n ending with the letter lastLetter
    //accounts for all inputs that aren't lower case or a postive int by
    //Checks the lexigraphic order of the letter entered
    public ArrayList<String> endsWith(char lastLetter, int n) throws IllegalArgumentException{
        if  (n<0){
            String e  = "n can't be less than 0, in endsWith arg";
            throw new IllegalArgumentException(e);
        }
        else if (Character.isLetter(lastLetter)==false) {
            String e = "lastLetter arg must be a char for endsWith arg";
            throw new IllegalArgumentException(e);
        }
        else if (lastLetter >= 'A' && lastLetter <= 'Z')  {
            String e  = "Please enter a lowerCase letter for endsWith arg";
            throw new IllegalArgumentException(e);
        }
        else if ((lastLetter < 'a') || (lastLetter > 'z')) {
            String e  = "Please enter a lowerCase letter for endsWith arg";
            throw new IllegalArgumentException(e);
        }
        ArrayList<String> lastChar = new ArrayList<String>();
        for(String elem: list){
            char newChar = elem.charAt(elem.length()-1);
            if ((elem.length()==n)&& newChar==lastLetter){
                lastChar.add(elem);
            }
        }
        return lastChar;
    }

//returns an ArrayList of words of length n
// containing the letter included at position index.
    public ArrayList<String> containsLetter(char included, int index, int n) throws IllegalArgumentException{
        if  (n<0 || index<0){
            String e  = "n and index can't be less than 0 in containsLetter";
            throw new ArrayIndexOutOfBoundsException(e);
        }
        else if (Character.isLetter(included)==false) {
            throw new IllegalArgumentException("included arg must be a char.");
        }
        else if (included >= 'A' && included <= 'Z')  {
            String e  = "Input must be lowerCase letter in containsLetter arg";
            throw new IllegalArgumentException(e);
        }
        else if ((included < 'a') || (included > 'z')){
            String e ="Input must be lower case letter for containsLetter arg";
            throw new IllegalArgumentException(e);
        }
        else if (n<=index)  {
            String e="Index must be less than word length in containsLetter arg";
            throw new ArrayIndexOutOfBoundsException(e);
        }
        ArrayList<String> hasLetter = new ArrayList<String>();
        for (int i = 0; i<list.size();i++){
            String word = list.get(i);
            if ((word.length()==n) && word.charAt(index)==included){
                hasLetter.add(word);
            }
        }
        return hasLetter;
    }
//  returns an ArrayList of words with at least m occurrences 
//  of the letter included.
    public ArrayList<String> multiLetter(int m, char included) throws IllegalArgumentException{
        char n = (char)(m+'0');
        if  (m<0){
            throw new IllegalArgumentException("n can't be less than 0");
        }
        else if (Character.isLetter(included)==false) {
            throw new IllegalArgumentException("argument 'included' must be a char.");
        }
        else if (included >= 'A' && included <= 'Z')  {
            String e = "Please enter lowercase letter for multiletter argument";
            throw new IllegalArgumentException(e);
        }
        else if ((included < 'a') || (included > 'z')){
            String e = "Please enter a lowercase letter for multiletter argument";
            throw new IllegalArgumentException(e);
        }
        ArrayList<String> multiLetters = new ArrayList<String>();
        for(String elem: list){
            int counter = 0;
            for (int i= 0 ; i<elem.length();i++){
                char newChar = elem.charAt(i);
                if (newChar==included){
                    counter++;
            }
            }
            if (counter>=m){
                multiLetters.add(elem);
                counter=0;
            }
        }
    return multiLetters;
        
}
}







