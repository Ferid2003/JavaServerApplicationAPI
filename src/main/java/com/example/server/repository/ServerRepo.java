package com.example.server.repository;

import com.example.server.entity.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<ServerEntity,Long> {

    ServerEntity findByIpAddress(String ipAddress);

}
