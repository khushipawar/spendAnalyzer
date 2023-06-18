package com.optum.service;

import com.optum.model.NotificationSettings;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {
    private Map<String, NotificationSettings> settingsMap = new HashMap<>();

    public NotificationService() {
        // Add dummy notification settings
        NotificationSettings settings1 = new NotificationSettings();
        settings1.setAccount("Khushi");
        settings1.setEmail("khushi@example.com");
        settings1.setRemind(true);
        settings1.setBackupFrequency(1);
        settingsMap.put("Khushi", settings1);

        NotificationSettings settings2 = new NotificationSettings();
        settings2.setAccount("Hritwika");
        settings2.setEmail("hritwika@example.com");
        settings2.setRemind(false);
        settings2.setBackupFrequency(3);
        settingsMap.put("Hritwika", settings2);

        NotificationSettings settings3 = new NotificationSettings();
        settings3.setAccount("Kritika");
        settings3.setEmail("kritika@example.com");
        settings3.setRemind(true);
        settings3.setBackupFrequency(7);
        settingsMap.put("Kritika", settings3);
    }

    public NotificationSettings getNotificationSettings(String account) {
        return settingsMap.get(account);
    }

    public void saveNotificationSettings(String account, NotificationSettings settings) {
        settingsMap.put(account, settings);
    }

}
