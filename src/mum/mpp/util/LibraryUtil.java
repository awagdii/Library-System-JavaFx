package mum.mpp.util;

import java.io.FileOutputStream;
import java.io.*;

public class LibraryUtil {

public static <T> void writeSerializedObject(T objectToBeSerialized,String fileName) {
	    try {
			// Store Serialized User Object in File
			FileOutputStream fileOutputStream = new FileOutputStream(
					IConstants.SERIALIZATION_ROOT_FOLDER+File.separator+fileName);
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			output.writeObject(objectToBeSerialized);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}



public static <T> T readSerializedObject(String fileName) {
	try {

		//Read from the stored file
		FileInputStream fileInputStream = new FileInputStream(new File(
				IConstants.SERIALIZATION_ROOT_FOLDER+File.separator+fileName));
		ObjectInputStream input = new ObjectInputStream(fileInputStream);
		T readObject = (T) input.readObject();
		input.close();
        return readObject;
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	return null;
}




}


