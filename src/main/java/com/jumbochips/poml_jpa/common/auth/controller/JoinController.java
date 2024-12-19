package com.jumbochips.poml_jpa.common.auth.controller;

import com.jumbochips.poml_jpa.common.auth.dto.JoinDto;
import com.jumbochips.poml_jpa.common.auth.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String join(JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        return "ok";
    }
}
