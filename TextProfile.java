import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//Daniel Lindberg
// 2-26-2016

//Garret here is an example of a class and some functions for it 

/*
	This is the generation of a class it has some functions to run.
*/
public class TextProfile
{
	//These are variables which are within a TextProfile(), they are set when the constructor below is called
	static File opened_file = null;
	static List lines = new ArrayList();
	
	/*This is the constructor, it takes a string fileName and it sets the file equal to the filename path.
	Note: it must be an absolute path passed to it. Examples of absolute paths below:
	Unix:
	home/ubuntu/Workspace/lind_dn/CodeExamples/GarretFiles
	Windows:
	C://Daniel//Documents//Workspace//CodeExamples//
	*/
	public TextProfile(String fileName)
	{
		String content = null;
		BufferedReader br = null;
		opened_file = new File(fileName);	
		/*
			Going to use a try-catch block below:
			try-catch blocks are meant to be used so that code can try its code but there is a chance it may not work.
			The catch part is meant to catch an error that may happen within the try brackets. I have IOException, however
			you can specify just a general (Exception e) and this in my opinion is better because it will deal with all errors
			not just IOErrors. IOerros stand for input output error.
		*/
		//Will read the file line by line and add the lines into a list
		try{
			br=new BufferedReader(new FileReader(opened_file));
			while((content=br.readLine())!= null){
				lines.add(content);			
			}
			br.close();
		}catch(IOException e){
			//Below I'm telling the error to print its previous calls that caused the error
			//You don't need to do anything within this but I do so I can see if my code errors out
			//Sometimes you can allow code to raise an error and continue to let it run.
			e.printStackTrace();

		}
	}
	public static void main(String[] args)
	{
		//I am adding this main function so you can run this however in classes typically you don't have a main function
		//Change this file path below if you are running this on windows. Find some text document on your computer and copy
		//it's path
		TextProfile tp = new TextProfile("/home/ubuntu/Downloads/DanielLindbergh/GettingStarted.txt");
		
		System.out.println("Character Count:"+getCharacterCount());
		System.out.println("Word Count:"+getWordCount());
		System.out.println("Line Count:"+getLineCount());
		System.out.println("Average Words per Line:"+getAverageWordsPerLine());
		System.out.println("Average Word length:"+getAverageWordLength());
		System.out.println("Get Hapax Ratio:"+hapaxRatio());
		System.out.println("Get Type Token:"+typeTokenRatio());
	}
	static int getCharacterCount()
	{
		int length=0;
		for(int i = 0; i< lines.size(); i++)
		{
			String[] words_per_line = getWordsOfSentence(i);
			for(int j = 0; j<words_per_line.length; j++)
			{
				length+=words_per_line[j].length();
			}			
		}
		return length;
	}
	static int getWordCount()
	{
		int length = 0;
		for(int i = 0; i< lines.size(); i++)
		{
			length+=getWordsOfSentence(i).length;			
		}
		return length;
	}
	static int getLineCount()
	{
		return lines.size();
	}
	static double getAverageWordsPerLine()
	{
		return getWordCount()/((double)lines.size());
	}
	static double getAverageWordLength()
	{
		return getCharacterCount()/((double)getWordCount());
	}
	static double typeTokenRatio()
	{
		List allWords = new ArrayList();
		Set<String> uniqueWords = new HashSet<String>();
		for(int i = 0; i< lines.size(); i++)
		{
			String [] words_per_line = getWordsOfSentence(i);
			for(int j = 0; j< words_per_line.length; j++)
			{
				allWords.add(words_per_line[j]);
			}		
		}
		for(int i = 0; i < allWords.size(); i++)
		{
			uniqueWords.add(allWords.get(i).toString());
		}
		return uniqueWords.size()/((double)allWords.size());		
	}
	static double hapaxRatio()
	{
		List allWords = new ArrayList();
		List uniqueWords = new ArrayList();
		for(int i = 0; i< lines.size(); i++)
		{
			String [] words_per_line = getWordsOfSentence(i);
			for(int j = 0; j< words_per_line.length; j++)
			{
				allWords.add(words_per_line[j]);
			}			
		}
		int[] count = new int[allWords.size()];
		for(int i = 0; i<count.length;i++)
		{
			count[i] = Collections.frequency(allWords,allWords.get(i));
		}
		for(int i = 0; i<count.length;i++)
		{
			if(count[i]==1)
			{
				uniqueWords.add(allWords.get(i));				
			}
		}
		return uniqueWords.size()/((double)allWords.size());
	}
	static String[] getWordsOfSentence(int num)
	{
		String [] words = (lines.get(num).toString()).split("\\s+");
		return words; 			
	}
}
