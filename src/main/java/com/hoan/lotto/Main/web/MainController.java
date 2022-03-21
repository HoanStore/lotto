package com.hoan.lotto.Main.web;

import com.hoan.lotto.Main.service.MainService;
import com.hoan.lotto.Main.service.impl.MainServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService service;

    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView("contents/main/main");
        return mv;
    }

    @PostMapping("/getNumbers")
    public ResponseEntity getNumbers(@RequestParam("num") String N) {
        ArrayList<Integer> list = service.getNumbers(Integer.parseInt(N));
        Map<String, Object> lotto = new HashMap<>();
        lotto.put("list", list);

        return new ResponseEntity<>(lotto, HttpStatus.OK);
    }

}
