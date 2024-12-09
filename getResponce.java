
/**
 * Download Jython 2.7 and add to Java Projects -> Reference Libraries
 * Still facing the issue of google not imported
 */

import org.python.util.PythonInterpreter;
import org.python.util.jython;

public class getResponce {
    public static void main(String[] args) {
        String str = "Tell me a fruit";
        // AIResponce.writeFile(str);
        PythonInterpreter pyInterp = new PythonInterpreter();
        pyInterp.compile("AIBot.py");
        pyInterp.execfile("AIBot.py");

        pyInterp.close();
    }
}