package com.duoc.vrk.controller;

import com.duoc.vrk.services.ExternalVRKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vrk-api")
public class ExternalVRKController {

    @Autowired
    private ExternalVRKService externalVRKService;

    @GetMapping
    public ResponseEntity<List<Object>> obtenerTracks() {
        return ResponseEntity.ok(externalVRKService.getExternalTracks());
    }
}