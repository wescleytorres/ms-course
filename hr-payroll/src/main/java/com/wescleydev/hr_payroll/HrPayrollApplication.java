package com.wescleydev.hr_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableFeignClients
@SpringBootApplication
@RibbonClient(name = "hr-worker")
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
