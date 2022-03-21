package com.hoan.lotto.Main.service;


import com.hoan.lotto.Main.service.impl.MainServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainServiceTest {

    MainService mainService;

    @BeforeEach
    public void beforeEach() {
        mainService = new MainServiceImpl();
    }


    /**
     * 중복 체크
     */
    @Test
    public void duplicationTest() {
        int testNum = 6;
        int [] duplCheck = new int[46];
        boolean isDupl = false;

        ArrayList<Integer> numbers = mainService.getNumbers(testNum);

        for(int number: numbers) {
            if(duplCheck[number] >= 1) {
                isDupl = true;
            }
            duplCheck[number]++;
        }

        Assertions.assertFalse(isDupl);

    }
}
