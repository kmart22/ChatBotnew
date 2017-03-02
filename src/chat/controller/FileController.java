package chat.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileController 
{
	public static void saveFile(ChatController baseController, String fileName, String contents)
	{
		try
		{
			File saveFile;
			if(fileName.length() > 5)
			{
				saveFile = new File(fileName + ".txt");
			}
			else
			{
				String saveName = LocalDateTime.now().getDayOfWeek().name() + ", ";
				saveName += LocalDateTime.now().getHour();
				saveName += "-";
				saveName += LocalDateTime.now().getMinute();
				saveFile = new File(saveName + ".txt");
			}
			FileWriter saveFileWriter = new FileWriter(saveFile);
			saveFileWriter.write(contents);
			saveFileWriter.close();
			JOptionPane.showMessageDialog(baseController.getBaseFrame(), "Save success!");
		}
		catch(IOException error)
		{
			baseController.handleErrors(error);
		}
	}

	public static String readFile(ChatController baseController, String fileName)
	{
		String fileContents = "";
		
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine())
			{
				fileContents += fileReader.nextLine();
			}
			fileReader.close();
		}
		catch(IOException someIOError)
		{
			baseController.handleErrors(someIOError);
		}
		catch(NullPointerException fileError)
		{
			baseController.handleErrors(fileError);
		}
		
		return fileContents;
	}
	
}
