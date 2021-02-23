package com.mao.common.util;

/**
 * ID生成器
 * create by mzx at 2021/2/17 15:48
 */
public class IdGenerator {

    //2021-02-17 15:50:00
    public static final long START_TIMESTAMP = 1613548238000L;

    private long sequence = 0L;

    private long lastTimestamp = -1L;

    public synchronized long nextId() {
        long current = System.currentTimeMillis();
        if (current < lastTimestamp)
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        if (current == lastTimestamp) {
            sequence = (sequence + 1) & 4095;
            if (sequence == 0)
                current = nextMill();
        } else sequence = 0L;
        lastTimestamp = current;
        return (current - START_TIMESTAMP) << 12 | sequence;
    }

    private long nextMill() {
        long mill = System.currentTimeMillis();
        while (mill <= lastTimestamp) {
            mill = System.currentTimeMillis();
        }
        return mill;
    }

}
