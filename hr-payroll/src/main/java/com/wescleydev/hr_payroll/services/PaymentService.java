package com.wescleydev.hr_payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wescleydev.hr_payroll.entities.Payment;
import com.wescleydev.hr_payroll.entities.Worker;
import com.wescleydev.hr_payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

  @Autowired
  private WorkerFeignClient workerFeignClient;

  public Payment getPayment(long workerId, Integer days) {
    Worker worker = workerFeignClient.findById(workerId).getBody();
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}
