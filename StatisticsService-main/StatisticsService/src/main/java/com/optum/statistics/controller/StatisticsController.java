package com.optum.statistics.controller;

import com.optum.statistics.model.DataPoint;
import com.optum.statistics.model.Statistics;
import com.optum.statistics.model.StatisticsDTO;
import com.optum.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
    @GetMapping()
    public ResponseEntity<List<StatisticsDTO>>getAllAccounts()
    {
        List<Statistics> statistics = statisticsService.getAllAccounts();
        List<StatisticsDTO> accountDTOs = new ArrayList<>();
        for(Statistics statistic:statistics)
        {
            StatisticsDTO accountDTO = new StatisticsDTO(statistic.getAccount(),statistic.getPassword(),statistic.getTotalIncome(),statistic.getTotalExpenses(),statistic.getBalance());
            accountDTOs.add(accountDTO);
        }
        return ResponseEntity.ok(accountDTOs);
    }

    @CrossOrigin("http://localhost:3001")
    @GetMapping("/{account}")
    public ResponseEntity<StatisticsDTO> getAccountStatistics(@PathVariable String account) {
        StatisticsDTO statistics = statisticsService.getAccountStatistics(account);
        if (statistics != null) {
            return ResponseEntity.ok(statistics);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @CrossOrigin("http://localhost:3001")
    @GetMapping("/current")
    public ResponseEntity<StatisticsDTO> getCurrentAccountStatistics() {
        StatisticsDTO statistics = statisticsService.getCurrentAccountStatistics();
        if (statistics != null) {
            return ResponseEntity.ok(statistics);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3001")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody StatisticsDTO statisticsDTO)
    {
        StatisticsDTO statistics1 = statisticsService.getAccountStatistics(statisticsDTO.getAccount());
        if(statistics!=null && statistics1.getPassword().equals(statisticsDTO.getPassword()))
        {
            return ResponseEntity.ok("Login Successful");


        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    @CrossOrigin("http://localhost:3001")
    @GetMapping("/demo")
    public ResponseEntity<StatisticsDTO> getDemoAccountStatistics() {
        StatisticsDTO statistics = statisticsService.getDemoAccountStatistics();
        if (statistics != null) {
            return ResponseEntity.ok(statistics);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    private final Map<String, List<DataPoint>> statistics = new HashMap<>();

//    @GetMapping("/{account}")
//    public List<DataPoint> getAccountStatistics(String account) {
//        return statistics.getOrDefault(account, new ArrayList<>());
//    }

    @CrossOrigin("http://localhost:3001")
    @PutMapping("/{account}")
    public ResponseEntity<String> updateOrCreateDataPoint(
            @PathVariable String account,
            @RequestParam double value,
            @RequestParam String timePeriod) {

        statisticsService.updateOrCreateDataPoint(account, value, timePeriod);
        return ResponseEntity.ok("Data point updated or created successfully");
    }



}



