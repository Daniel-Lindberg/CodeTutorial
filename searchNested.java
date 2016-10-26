import java.util.*;
import java.io.File;

/*
	Garret here is an examle of using iteration. In the fibonacci sequence example we use recursion, the other way is through
	iteration. Iteration is when you know exactly how many times you want to compute something. So what this code does is it
	enters a directory it gets all files and folders within that path (which is a number it knows). Then it checks to see if it
	is a folder or a path to go down, and if it does it uses recursion and calls searchFolder again. This will print every single
	path under a certain directory. 

	I also added some code that makes it work for linux or windows. Heads up this isn't that big of a deal to learn the 
	differences right now. Its basically file paths and certain packages are included.
	An example of a Windows file path: C://Users/Daniel/Documents/
	An Example of a Unix File path: /home/ubuntu/Workspace/
*/

public class searchNested{
	static List files = new ArrayList<>();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){
		String filepath = new String();
		System.out.println("Enter a file directory path");
		filepath = reader.next();
		System.out.println("Value is: "+filepath);
		searchFolder(filepath);
		for(int i =0;i<files.size();i++)
		{
			System.out.println("We have:"+files.get(i));
		}
	}

	static void searchFolder(String folderLoc)
	{
		File file = new File(folderLoc);
		String[] names = file.list();
		for(String name: names)
		{
			if(System.getProperty("os.name").toLowerCase().contains("win"))
			{
				files.add(folderLoc+"//"+name);
			}
			else
			{
				files.add(folderLoc+"/"+name);
			}
			if( new File(folderLoc+name).isDirectory())
			{
				searchFolder(folderLoc+name);
			}
		}		
	}
}
