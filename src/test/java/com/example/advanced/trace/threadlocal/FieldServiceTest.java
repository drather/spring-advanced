package com.example.advanced.trace.threadlocal;

import com.example.advanced.trace.threadlocal.code.FieldService;
import com.sun.jdi.Field;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.management.relation.RelationNotification;

@Slf4j
public class FieldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };
        
        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");
        
        threadA.start();
//        sleep(2000); // 동시성 문제 발생 X
        sleep(100);
        threadB.start();

        sleep(3000); // 메인스레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int mil) {
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
