package com.example.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produk.model.Order;
import com.example.produk.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order){
        order.setTotal(order.getHarga() * order.getJumlah());
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails){
        Order order = orderRepository.findById(id).orElse(null);
        if(order != null){
            order.setIdProduk(orderDetails.getIdProduk());
            order.setIdPelanggan(orderDetails.getIdPelanggan());
            order.setHarga(orderDetails.getHarga());
            order.setJumlah(orderDetails.getJumlah());
            order.setTotal(orderDetails.getHarga() * orderDetails.getJumlah());
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
