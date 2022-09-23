package com.example.server.service.serviceImplementation;

import com.example.server.entity.ServerEntity;
import com.example.server.repository.ServerRepo;
import com.example.server.service.ServerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;


import static com.example.server.enumiration.Status.STATUS_DOWN;
import static com.example.server.enumiration.Status.STATUS_UP;


@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {

    private final int limit = 30;

    private final ServerRepo serverRepo;


    @Override
    public ServerEntity create(ServerEntity serverEntity) {
        log.info("Server was created "+serverEntity);
        serverEntity.setImageUrl(setImageUrl());
        return serverRepo.save(serverEntity);
    }

    @Override
    public ServerEntity delete(Long id) {
        log.info("Server "+id+" was deleted");
        ServerEntity server = serverRepo.findById(id).get();
        serverRepo.delete(server);
        return server;
    }

    @Override
    public ServerEntity get(Long id) {
        log.info("Fetching server by id {}",id);
        ServerEntity server = serverRepo.findById(id).get();
        return server;
    }

    @Override
    public ServerEntity update(ServerEntity serverEntity) {
        log.info("Updating server {}",serverEntity.getName());
        serverRepo.save(serverEntity);
        return  serverEntity;
    }

    @Override
    public ServerEntity ping(String ipAddress) throws IOException {
        log.info("Pinging server with {} address",ipAddress);
        ServerEntity server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(1000) ? STATUS_UP : STATUS_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<ServerEntity> list() {
        log.info("Fetching all servers");
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    private String setImageUrl(){
        String[] images = {"server1.png","server2.png","server3.png","server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/"+images[new Random().nextInt(4)]).toString();
    }
}
