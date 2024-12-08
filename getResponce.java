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