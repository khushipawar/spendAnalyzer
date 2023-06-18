package com.optum.controller;

import com.optum.model.NotificationSettings;
import com.optum.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications/settings/current")
public class NotificationSettingsController {
    private NotificationService notificationService;

    public NotificationSettingsController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<NotificationSettings> getCurrentNotificationSettings(@RequestParam String account) {
        NotificationSettings settings = notificationService.getNotificationSettings(account);
        if (settings != null) {
            return ResponseEntity.ok(settings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> saveCurrentNotificationSettings(
            @RequestParam String account,
            @RequestBody NotificationSettings settings) {
        notificationService.saveNotificationSettings(account, settings);
        return ResponseEntity.ok("Notification settings saved successfully");
    }
}
