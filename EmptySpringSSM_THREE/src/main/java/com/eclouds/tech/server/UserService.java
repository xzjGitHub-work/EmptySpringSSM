package com.eclouds.tech.server;

public interface UserService {
    void save();

    Integer update();

    Integer delete(Integer id);
}