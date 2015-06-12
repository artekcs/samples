import java.io.File;
import java.lang.String;
import java.util.Scanner;

public class rmdir {


	private static int fileCounter = 0;
	private static int folderCounter = 0;
	private static Scanner bufferReader;


	public static void main (String[] args) {
		if (args.length == 0)	{
			System.out.println("Syntax : rmdir [file] or [folder]");
		}
			else	{
				bufferReader = new Scanner(System.in);
				String folder = args[0];
				File file = new File(folder);
					if (file.exists()){
						char userInput;
						do {
							System.out.println("Do you confirm " + folder + " deletion ? (Y)es or (N)o :  ");
							userInput = catchUserInput();
						}
						while (!(userInput == 'y' || userInput == 'n'));
							if (userInput == 'y')	{
								do {
									delete(file);
								}
								while (file.exists());
								System.out.println("Deleted Folders : " + String.valueOf(folderCounter));
								System.out.println(String.format("Deleted files : %d", fileCounter));
							}
							else {
								System.out.println("Sortie du programme");
							}
					}
					else {
						System.out.print (folder+"Doesn't exist\n");
					}
				bufferReader.close();
			}			
	}


	private static char catchUserInput () {		
		char input = Character.toLowerCase(bufferReader.next().trim().charAt(0));	
		return input;
	}


	private static void delete (File file) {
		if (file.isDirectory()){
			String fileList[] = file.list();
			if (fileList.length == 0)	{
				System.out.print ("Deleted Folder : " + file.getPath() + "\n");
				file.delete();
				folderCounter ++;
			}
			else	{
				for (int i = 0;i < fileList.length;i++)	{
					String fileName = fileList[i];
					String fullPath = file.getPath() + "/" + fileName;
					File fileOrfolder = new File(fullPath);
					delete(fileOrfolder);
				}
			}
		}
		else {
			System.out.println("Deleted file : " + file.getPath());
			file.delete();
			fileCounter ++;
		}
	}
}