import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class RemoteShell {

	public static void main(String[] args) {
		RemoteShell rs=new RemoteShell();
		String cmd="lsof *.xml";
		String result=rs.centosShell(cmd);
		result=result.toLowerCase();
		System.out.println("find file|"+result.indexOf("xml")+"|");
		
	}
	
	public String winShell(String cmd) {
		String result="";
		try {
			String[] command = { "cmd", "/c", cmd };
			Process process = Runtime.getRuntime().exec(command);
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				result+= line;
			}
		} catch (Exception e) {
			result="exception :"+e.getMessage();
		}
		return result;
	}
	
	public String centosShell(String cmd) {
		String result="";
		try {
			String[] command = { "/bin/sh", "-c", cmd };
			Process process = Runtime.getRuntime().exec(command);
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				result+= line;
			}
		} catch (Exception e) {
			result="exception :"+e.getMessage();
		}
		return result;
	}

}
