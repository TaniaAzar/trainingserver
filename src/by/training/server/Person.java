package by.training.server;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class Person {

    private String name;

    public Person(String string) throws ScriptException {
        ScriptEngine engine;
        ScriptEngineManager sem = new ScriptEngineManager();
        engine = sem.getEngineByName("js");
        String script = "Java.asJSONCompatible(" + string + ")";
        Object result = engine.eval(script);

        Map<String, String> contents = (Map) result;
        this.name = contents.get("name");
    }

    public String getName(){
        return name;
    }
}
