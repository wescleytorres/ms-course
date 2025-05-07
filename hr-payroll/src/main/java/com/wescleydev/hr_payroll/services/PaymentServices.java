package com.wescleydev.hr_payroll.services;

import com.wescleydev.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {
  public Payment getPayment(long workerId, Integer days) {
    return new Payment("Bob", 200.0, days);
  }
}
