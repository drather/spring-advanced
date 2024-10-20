package com.example.advanced.trace.template.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관하는 방식
 */
@Slf4j
public class ContextV1 {
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;


    }

    public void execute() {
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
