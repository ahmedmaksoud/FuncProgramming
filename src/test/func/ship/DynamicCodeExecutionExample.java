package test.func.ship;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DynamicCodeExecutionExample {
    public static void main(String[] args) {
        // Create a script engine manager
        ScriptEngineManager manager = new ScriptEngineManager();

        // Get a JavaScript engine
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Define a dynamic script
        String script = """
                function add(a, b) {
                    return a + b;
                }
                add(10, 20);
                """;

        try {
            // Execute the script
            Object result = engine.eval(script);

            // Print the result
            System.out.println("Result of the dynamic script: " + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
