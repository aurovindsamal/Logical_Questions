package com.projects.problemStatement;

/**
 * 
 * @author aurovind.samal 
 *         Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA,
 *         PLIE, POIN} start = TOON target = PLEA Output: 7 TOON - POON - POIN -
 *         POIE - PLIE - PLEE - PLEA
 * 
 *         Input: Dictionary = {ABCD, EBAD, EBCD, XYZA} Start = ABCV End = EBAD
 *         Output: 4 ABCV - ABCD - EBCD - EBAD
 * 
 *         Approach:
 * 
 *         Start from the given start word. Push the word in the queue Run a
 *         loop until the queue is empty Traverse all words that adjacent
 *         (differ by one character) to it and push the word in a queue (for
 *         BFS) Keep doing so until we find the target word or we have traversed
 *         all words.
 *
 */
//Java program to find length
//of the shortest chain
//transformation from source
//to target
import java.util.*;

public class Word_Ladder {

	class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
	 
	    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	        LinkedList<WordNode> queue = new LinkedList<WordNode>();
	        queue.add(new WordNode(beginWord, 1));
	 
	        wordDict.add(endWord);
	 	while(!queue.isEmpty()){
	            WordNode top = queue.remove();
	            String word = top.word;
	 
	            if(word.equals(endWord)){
	                return top.numSteps;
	            }
	 	      char[] arr = word.toCharArray();
	            for(int i=0; i<arr.length; i++){
	                for(char c='a'; c<='z'; c++){
	                    char temp = arr[i];
	                    if(arr[i]!=c){
	                        arr[i]=c;
	                    }
	 
	                    String newWord = new String(arr);
	                    if(wordDict.contains(newWord)){
	                        queue.add(new WordNode(newWord, top.numSteps+1));
	                        wordDict.remove(newWord);
	                    }
	 			arr[i]=temp;
	                }
	            }
	        }
	return 0;
	    }


//Driver code
	public static void main(String[] args) {
		// make dictionary
		Set<String> D = new HashSet<String>();
		Word_Ladder wl = new Word_Ladder();
		D.add("poon");
		D.add("plee");
		D.add("same");
		D.add("poie");
		D.add("plie");
		D.add("poin");
		D.add("plea");
		String start = "toon";
		String target = "plea";
		System.out.print("Length of shortest chain is: " + wl.ladderLength(start, target, D));
	}
}
