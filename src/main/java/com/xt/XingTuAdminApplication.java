package com.xt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.xt")
public class XingTuAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XingTuAdminApplication.class, args);
    }

}
