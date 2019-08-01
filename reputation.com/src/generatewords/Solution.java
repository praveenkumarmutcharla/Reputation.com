package generatewords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public List<String> computeWords(String digits) {
    
    List<String> result = new ArrayList<String>();
    if(digits==null||digits.length()==0) 
    	return result;
    char[][] map = new char[8][];
    map[0]="abc".toCharArray();
    map[1]="def".toCharArray();
    map[2]="ghi".toCharArray();
    map[3]="jkl".toCharArray();
    map[4]="mno".toCharArray();
    map[5]="pqrs".toCharArray();
    map[6]="tuv".toCharArray();
    map[7]="wxyz".toCharArray();
    
    char[] input = digits.toCharArray();
    result.add("");
    for(char ch:input)
        result = getPermutations(result,map[ch-'2']);
    return result;
    
    }
    private List<String> getPermutations(List<String> templist,char[] maparr)
    {
        List<String> tempresult = new ArrayList<String>();
        for(String str:templist)
            for(char ch:maparr)
            	tempresult.add(str+ch);
        return tempresult;
    }
   
	public List<String> wordsInDictionary( List<String> computedWords) throws IOException
    {
    	Iterator<String> iterator = computedWords.iterator();
    	List<String> meaningFullWords = new ArrayList<String>();
    	File fileDescriptor;
    	FileReader fr;
    	BufferedReader br;
    	String word=null;
    	while(iterator.hasNext())
    	{
    		String wordToCompare = iterator.next();
    		fileDescriptor=new File("D:\\STSworkspace\\reputation.com\\google-10000-english.txt");
        	fr = new FileReader(fileDescriptor);
    		br = new BufferedReader(fr);   		 
    		 while((word=br.readLine())!=null)   
    	      {    	   
    	         if (word.equals(wordToCompare))
    	         {
    	        	 meaningFullWords.add(wordToCompare);
    	        	 break;
    	         }
    	         	
    	      }
    	}
    	
		return meaningFullWords;    	
    }
    public static void main(String []args) throws IOException
    {
    	Scanner scan = new Scanner(System.in);
    	String Number = null;
    	System.out.println("Enter the number where each digit is greater than 1");
    	Number = scan.next();
    	Solution solObj = new Solution();
    	List<String> computedWords,meaningFullWords;
    	computedWords = solObj.computeWords(Number);
    	meaningFullWords = solObj.wordsInDictionary(computedWords);
    	if(meaningFullWords.size()> 0)
    		System.out.println(meaningFullWords);
    	else
    		System.out.println("No meaning full words present");
        scan.close();
    	
    	
    }
        
}
