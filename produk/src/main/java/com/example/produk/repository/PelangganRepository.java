package com.example.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.produk.model.Pelanggan;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
    
}
