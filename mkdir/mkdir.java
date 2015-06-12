import java.io.File;
import java.lang.String;
import java.util.Scanner;

public class mkdir {


	private static int fileCounter = 0;
	private static int folderCounter = 0;
	private static Scanner bufferReader;


	public static void main (String[] args) {
		if (args.length == 0)	{
			System.out.println("Syntax : mkdir [folder]");
		}
			else	{
				bufferReader = new Scanner(System.in);
				String folderName = args[0];
				File folder = new File(folderName);
					if (folder.exists()){
						System.out.print (folderName+" Exists\n");
					}

					else {
						char userInput;
						do {
							System.out.println("Do you confirm " + folder + " creation ? (Y)es or (N)o :  ");
							userInput = catchUserInput();
						}
						while (!(userInput == 'y' || userInput == 'n'));
							if (userInput == 'y')	{
								if (create(folderName)) {
									System.out.println("Folder created successfully");
								}
								else {
									System.out.println("Folder was not created");
								}
							}
							else {
								System.out.println("Sortie du programme");
							}
						
					}
				bufferReader.close();
			}			
	}


	private static char catchUserInput () {		
		char input = Character.toLowerCase(bufferReader.next().trim().charAt(0));	
		return input;
	}


	private static boolean create (String folderName) {
		File folder;
			for (int i = 0; i < 300; i++) {
				folder = new File (folderName);
				if (folder.mkdir()) {
					System.out.println(folder + " Folder Created");
				}
				else {
					System.out.println("Could not create" + folder);
					return false;
				}
				folderName = folderName + "/abc";				
			}
			return true;
	}
}