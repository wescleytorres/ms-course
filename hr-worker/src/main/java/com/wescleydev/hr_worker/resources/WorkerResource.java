package com.wescleydev.hr_worker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wescleydev.hr_worker.entities.Worker;
import com.wescleydev.hr_worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

  @Autowired
  private WorkerRepository workerRepository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = workerRepository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {

    // try {
    // Thread.sleep(3000L);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }

    Worker obj = workerRepository.findById(id).get();
    return ResponseEntity.ok(obj);
  }
}
