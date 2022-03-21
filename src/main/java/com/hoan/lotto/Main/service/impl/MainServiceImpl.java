package com.hoan.lotto.Main.service.impl;

import com.hoan.lotto.Main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {


    @Override
    public ArrayList<Integer> getNumbers(int N) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        // 로또는 1부터 45까지 있다
        for(int i=0; i<N; i++) {
            int randomNum = (int)(Math.random()*45)+1;
            if(isDuplication(randomNum, list) == true) {
                list.add(randomNum);
            } else {
                i--;
            }

        }
        Collections.sort(list);
        System.out.println("list.toString() = " + list.toString());        
        return list;
    }

    private boolean isDuplication(int randomNum, ArrayList<Integer> list) {
        int N = list.size();
        boolean answer = true;
        for(int i=0; i<N; i++) {
            if(list.get(i) == randomNum) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
