package com.example.produk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produk.model.Pelanggan;
import com.example.produk.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganService pelangganService;

    @GetMapping
    public List<Pelanggan> getAllPelanggans(){
        return pelangganService.getAllPelanggans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelanggan> getPelangganById(@PathVariable Long id) {
        Pelanggan pelanggan = pelangganService.getPelangganById(id);
        return pelanggan != null ? ResponseEntity.ok(pelanggan) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Pelanggan createPelanggan(@RequestBody Pelanggan pelanggan) {
        return pelangganService.createPelanggan(pelanggan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelanggan> updatePelanggan(@PathVariable Long id, @RequestBody Pelanggan pelangganDetails) {
        Pelanggan pelanggan = pelangganService.updatePelanggan(id, pelangganDetails);
        return pelanggan != null ? ResponseEntity.ok(pelanggan) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePelanggan(@PathVariable Long id) {
        pelangganService.deletePelanggan(id);
        return ResponseEntity.ok().build();
    }
}
