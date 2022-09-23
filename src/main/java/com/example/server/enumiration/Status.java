package com.example.server.enumiration;

public enum Status {
    STATUS_UP("STATUS_UP"),
    STATUS_DOWN("STATUS_DOWN");

    private String status;

    Status(String status) {
        this.status = status;
    }

}
