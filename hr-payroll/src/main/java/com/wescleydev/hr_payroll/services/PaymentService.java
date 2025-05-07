package com.wescleydev.hr_payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wescleydev.hr_payroll.entities.Payment;
import com.wescleydev.hr_payroll.entities.Worker;

@Service
public class PaymentService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${hr-worker.url}")
  private String workerHost;

  public Payment getPayment(long workerId, Integer days) {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("id", String.valueOf(workerId));

    Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}
