package com.chandu.jarvis.command;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ToolExecution {

    public String openApplication(String m) throws Exception {

        JSONObject obj = new JSONObject(m);
        String command = obj.optString("text", "").toLowerCase();

        switch (command) {

            case "open chrome":
                Runtime.getRuntime().exec("chrome path");
                return "Chrome opened";

            case "open notepad":
                Runtime.getRuntime().exec("notepad");
                return "notepad opened";

            case "open calculator":
                Runtime.getRuntime().exec("calc");
                return "calculator opened";

            case "open vscode":
                Runtime.getRuntime().exec("vs path");
                return "VS Code opened";

            case "spotify":
                Runtime.getRuntime().exec("spotify");
                return "Spotify opened";

            default:
                return "Unknown command: " + command;
        }
    }
}
