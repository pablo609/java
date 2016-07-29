package facebook.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessManager {
	private static final String TASK_LIST_CMD = "tasklist";
	private static final String KILL_ALL_TASK_CMD = "taskkill /F /FI \"IMAGENAME eq REPLACE_WITH_PROCESS_NAME*\"";
	
	public static boolean isProcessRunning(String name) {
		try {
			Runtime currentRuntime = Runtime.getRuntime();
			InputStream commandOutputStream = currentRuntime.exec(TASK_LIST_CMD).getInputStream();
			BufferedReader commandOutputReader = new BufferedReader(new InputStreamReader(commandOutputStream));
			
			String line;
			while ((line = commandOutputReader.readLine()) != null) {
				if(line.startsWith(name)) {
					return true;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public static void killAllInstancesOfProcess(String name) {
		try {
			Process process = Runtime.getRuntime().exec(KILL_ALL_TASK_CMD.replace("REPLACE_WITH_PROCESS_NAME", name));
			process.waitFor();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
