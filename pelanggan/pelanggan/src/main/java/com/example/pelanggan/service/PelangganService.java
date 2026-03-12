package com.example.pelanggan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pelanggan.model.Pelanggan;
import com.example.pelanggan.repository.PelangganRepository;

@Service
public class PelangganService {
    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggans(){
        return pelangganRepository.findAll();
    }

    public Pelanggan getPelangganById(Long id){
        return pelangganRepository.findById(id).orElse(null);
    }

    public Pelanggan createPelanggan(Pelanggan pelanggan){
        return pelangganRepository.save(pelanggan);
    }

    public Pelanggan updatePelanggan(Long id, Pelanggan pelangganDetails){
        Pelanggan pelanggan = pelangganRepository.findById(id).orElse(null);
        if(pelanggan != null){
            pelanggan.setNama(pelangganDetails.getNama());
            pelanggan.setAlamat(pelangganDetails.getAlamat());
            return pelangganRepository.save(pelanggan);
        }
        return null;
    }

    public void deletePelanggan(Long id){
        pelangganRepository.deleteById(id);
    }
}
