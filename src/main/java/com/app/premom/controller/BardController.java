package com.app.premom.controller;

import com.pkslow.ai.AIClient;
import com.pkslow.ai.GoogleBardClient;
import com.pkslow.ai.domain.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
@RequiredArgsConstructor
public class BardController {

    private final String token = "g.a000gAjacRz5WQQQ8RR-gobQK_3SieLAKXpLmVrO8kmxp2yLkEtLJqovPRaz6h2lsqIKTC1yWwACgYKAcsSAQASFQHGX2Mi6JonmbJaqOsEAxIy4AEcEhoVAUF8yKpDzjtftuiMyOIH5OdBlYj00076" + ";" + "sidts-CjIBPVxjSoYEAh1ahRx08XIJ6vjBmUCA-AoopjpkGMsZHwfuzQ3VesqjK0Cd-zSA5UYNyhAA";

    @GetMapping("/bard-chating")
    public String handleGetAnswer(@RequestParam("question") String request) {
        AIClient client = new GoogleBardClient(token);
        Answer answer = client.ask(request);
        System.out.println(answer.getChosenAnswer());
        return answer.getChosenAnswer();
    }



}
