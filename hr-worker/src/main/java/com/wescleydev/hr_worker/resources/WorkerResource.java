package com.wescleydev.hr_worker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wescleydev.hr_worker.entities.Worker;
import com.wescleydev.hr_worker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

  private static final Logger logger = LoggerFactory.getLogger(WorkerResource.class);

  @Autowired
  private WorkerRepository workerRepository;

  @Autowired
  private Environment env;

  @Value("${test.config}")
  private String testConfig;

  @GetMapping(value = "/configs")
  public ResponseEntity<Void> getConfigs() {
    logger.info("CONFIG: " + testConfig);
    return ResponseEntity.noContent().build();
  }

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

    logger.info("PORT = " + env.getProperty("local.server.port"));

    Worker obj = workerRepository.findById(id).get();
    return ResponseEntity.ok(obj);
  }
}
