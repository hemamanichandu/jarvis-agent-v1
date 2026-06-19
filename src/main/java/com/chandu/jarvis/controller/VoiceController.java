package com.chandu.jarvis.controller;

import com.chandu.jarvis.command.ToolExecution;
import com.chandu.jarvis.voice.SpeechRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoiceController {

    private final SpeechRecognitionService speechService;


    public VoiceController(SpeechRecognitionService speechService) {
        this.speechService = speechService;
    }

    @Autowired
    private ToolExecution toolExecution;

    @GetMapping("/listen")
    public String listen() {

        return speechService.listen();
    }

    @GetMapping("open")
    public String opener() throws Exception {

        String m=speechService.listen();
        System.out.println(m);
    return toolExecution.openApplication(m);
    }

}