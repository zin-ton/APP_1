package com.example.cookbook;
import com.lilittlecat.chatgpt.offical.ChatGPT;
public class ChatGpt {
    private static String APIkey = "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";

    public static String chatGPT(String text) throws Exception {
        ChatGPT chatGPT = new ChatGPT(APIkey);
        String answer = chatGPT.ask("hello");
        return answer;
    }
}
