package com.optum.statistics.service;

import com.optum.statistics.model.DataPoint;
import com.optum.statistics.model.StatisticsDTO;
import com.optum.statistics.model.Statistics;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {

    private final Map<String, Statistics> statisticsMap;

    public StatisticsService() {
        statisticsMap = new HashMap<>();
        // Initialize with dummy data

        Statistics statistics1 = new Statistics("Khushi","password123", 1000, 500, 2000);
        Statistics statistics2 = new Statistics("Hritwika","password123", 1500, 700, 3000);
        Statistics statistics3 = new Statistics("Kritika", "password123",1200, 600, 2500);

        statisticsMap.put(statistics1.getAccount(), statistics1);
        statisticsMap.put(statistics2.getAccount(), statistics2);
        statisticsMap.put(statistics3.getAccount(), statistics3);
        Statistics demoStatistics = new Statistics("demo", "password123",1000.0, 500.0, 300.0);
        statisticsMap.put("demo", demoStatistics);
    }

    public StatisticsDTO getAccountStatistics(String account) {
        Statistics statistics = statisticsMap.get(account);
        if (statistics != null) {
            return StatisticsDTO.fromStatistics(statistics);
        }
        return null;
    }


    public StatisticsDTO getCurrentAccountStatistics() {
        // Replace with logic to retrieve current account statistics
        // Here, we are returning the demo account statistics as an example
        Statistics demoStatistics = statisticsMap.get("demo");
        if (demoStatistics != null) {
            return StatisticsDTO.fromStatistics(demoStatistics);
        }
        return null;
    }

    public StatisticsDTO getDemoAccountStatistics() {
        // Retrieve and return the demo account statistics
        Statistics demoStatistics = statisticsMap.get("demo");
        if (demoStatistics != null) {
            return StatisticsDTO.fromStatistics(demoStatistics);
        }
        return null;
    }
    public List<Statistics> getAllAccounts()
    {
        return new ArrayList<>(statisticsMap.values());
    }
    public void saveOrUpdateStatistics(Statistics statistics) {
        statisticsMap.put(statistics.getAccount(), statistics);
    }

    private final Map<String, List<DataPoint>> statistics = new HashMap<>();

//    public List<DataPoint> getAccountStatistics(String account) {
//        return statistics.getOrDefault(account, new ArrayList<>());
//    }
    @PutMapping("/{account}")
    public void updateOrCreateDataPoint(String account, double value, String timePeriod) {
        List<DataPoint> accountStatistics = statistics.computeIfAbsent(account, k -> new ArrayList<>());
        DataPoint existingDataPoint = findDataPointByTimePeriod(accountStatistics, timePeriod);

        if (existingDataPoint != null) {
            existingDataPoint.setValue(value);
        } else {
            DataPoint newDataPoint = new DataPoint(value, timePeriod);
            accountStatistics.add(newDataPoint);
        }
    }

    private DataPoint findDataPointByTimePeriod(List<DataPoint> dataPoints, String timePeriod) {
        return dataPoints.stream()
                .filter(dataPoint -> dataPoint.getTimePeriod().equals(timePeriod))
                .findFirst()
                .orElse(null);
    }


}

