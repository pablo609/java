package facebook.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	public static boolean writeObjectToFile(Object object, String file) {
		boolean result = false;
		
		try(FileOutputStream fileOut = new FileOutputStream(file)) {
			try(ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
				objectOut.writeObject(object);
				result = true;
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object readObjectFromFile(String file) {
		Object result = null;
		
		try(FileInputStream fileIn = new FileInputStream(file)) {
			try(ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
				result = objectIn.readObject();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
