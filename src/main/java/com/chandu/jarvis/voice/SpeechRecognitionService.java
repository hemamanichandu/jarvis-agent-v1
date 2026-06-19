package com.chandu.jarvis.voice;

import org.springframework.stereotype.Service;
import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.*;
import java.io.IOException;

@Service
public class SpeechRecognitionService {

    private static final String MODEL_PATH =
            System.getProperty("user.dir") + "/models/vosk-model-en-in-0.5";

    private final Model model;

    public SpeechRecognitionService() throws IOException {
        System.out.println("Loading Vosk Model from: " + MODEL_PATH);
        this.model = new Model(MODEL_PATH);
        System.out.println("Model loaded successfully");
    }

    public String listen() {

        TargetDataLine microphone = null;
        Recognizer recognizer = null;



        try {
            AudioFormat format = new AudioFormat(
                    16000.0f,
                    16,
                    1,
                    true,
                    false
            );

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();

            System.out.println("Listening... Speak now.");

            recognizer = new Recognizer(model, 16000);

            byte[] buffer = new byte[4096];

            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() - startTime < 5000)
            {

                int bytesRead = microphone.read(buffer, 0, buffer.length);

                if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                    String result = recognizer.getResult();

                    System.out.println("Final Result: " + result);

                    return result;
                }
            }

            String finalResult = recognizer.getFinalResult();
            System.out.println("Final Result: " + finalResult);

            return finalResult;

        } catch (Exception e) {
            throw new RuntimeException("Voice recognition failed", e);

        } finally {

            if (microphone != null) {
                microphone.stop();
                microphone.close();
            }

            if (recognizer != null) {
                recognizer.close();
            }
        }
    }
}