package utitlities;

import java.io.File;

public class GenericHelper {
	// return absolute path of the given file in a folder
	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}
}
