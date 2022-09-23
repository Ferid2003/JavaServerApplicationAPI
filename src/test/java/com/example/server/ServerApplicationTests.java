package com.example.server;

import jdk.swing.interop.SwingInterOpUtils;
import org.assertj.core.internal.Dates;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.concurrent.TimeUnit;

import static java.time.LocalTime.now;
import static java.time.LocalTime.ofNanoOfDay;

@SpringBootTest
class ServerApplicationTests {


    public static void main(String[] args) {
        LocalDate qaqa = LocalDate.of(2003,6,23);
        LocalDate deadline = LocalDate.of(2024,3,1);
        System.out.println(Duration.between(qaqa.atStartOfDay(),deadline.atStartOfDay()).toDays());
        System.out.println();

    }

    @Test
    void contextLoads() {
    }

}
