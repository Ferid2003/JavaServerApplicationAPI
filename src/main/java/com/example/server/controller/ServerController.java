package com.example.server.controller;

import com.example.server.entity.Response;
import com.example.server.entity.ServerEntity;
import com.example.server.enumiration.Status;
import com.example.server.service.serviceImplementation.ServerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;

import static com.example.server.enumiration.Status.*;
import static java.time.LocalDate.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/server")
@AllArgsConstructor
public class ServerController {

    private  final ServerServiceImpl serverService;

    @GetMapping("/create")
    public ResponseEntity<Response> createServer(@RequestBody ServerEntity server){
        return ResponseEntity.ok(Response.builder()
                .time(now())
                .message("Server was created!")
                .map(Map.of("server",serverService.create(server)))
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id){
        return ResponseEntity.ok(Response.builder()
                .time(now())
                .message("Server was deleted!")
                .map(Map.of("server",serverService.delete(id)))
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long id){
        return ResponseEntity.ok(Response.builder()
                .time(now())
                .message("Server was fetched!")
                .map(Map.of("server",serverService.get(id)))
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateServer(@RequestBody @Valid ServerEntity server){
        return ResponseEntity.ok(Response.builder()
                .time(now())
                .message("Server was updated!")
                .map(Map.of("server",serverService.update(server)))
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        ServerEntity server = serverService.ping(ipAddress);
        return ResponseEntity.ok(Response.builder()
                .time(now())
                .message(server.getStatus()== STATUS_UP ? "Server is up" : "Server is down")
                .map(Map.of("server",serverService.ping(ipAddress)))
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("/getList")
    public ResponseEntity<Response> getServerList(){
        return ResponseEntity.ok(Response.builder()
                .time(now())
                .message("Server list")
                .map(Map.of("server",serverService.list()))
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping(path = "/image/{imageUrl}",produces = IMAGE_PNG_VALUE)
    public byte[] setServerImage(@PathVariable("imageUrl") String imageUrl) throws IOException {
       return Files.readAllBytes(Paths.get("C:/Users/ferid/Downloads/Server/"+imageUrl));

    }


}
