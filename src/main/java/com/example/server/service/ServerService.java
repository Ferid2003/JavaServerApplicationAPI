package com.example.server.service;

import com.example.server.entity.ServerEntity;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Optional;

public interface ServerService {

    ServerEntity create(ServerEntity serverEntity);
    ServerEntity delete(Long id);
    ServerEntity get(Long id);
    ServerEntity update(ServerEntity serverEntity);
    ServerEntity ping(String ipAddress) throws IOException;
    Collection<ServerEntity> list();

}
