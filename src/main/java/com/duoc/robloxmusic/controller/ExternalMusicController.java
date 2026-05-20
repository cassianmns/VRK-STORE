package com.duoc.robloxmusic.controller;

import com.duoc.robloxmusic.services.ExternalMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/musica-externa")
public class ExternalMusicController {

    @Autowired
    private ExternalMusicService externalMusicService;

    @GetMapping
    public ResponseEntity<List<Object>> obtenerTracks() {
        return ResponseEntity.ok(externalMusicService.getExternalTracks());
    }
}