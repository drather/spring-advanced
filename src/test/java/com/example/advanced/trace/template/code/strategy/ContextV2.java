package com.example.advanced.trace.template.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {
    private Strategy strategy;

    public ContextV2(Strategy strategy) {
        this.strategy = strategy;


    }

    public ContextV2() {
    }

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call();

        // 비즈니스 로직 실행
        log.info("비즈니스 로직 1 실행");
        // 비즈니스 로직 실행

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }
}
