package com.optum.model;

public class NotificationSettings {
    private String account;
    private String email;
    private boolean remind;
    private int backupFrequency;

    // Getters and setters

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public int getBackupFrequency() {
        return backupFrequency;
    }

    public void setBackupFrequency(int backupFrequency) {
        this.backupFrequency = backupFrequency;
    }
}
