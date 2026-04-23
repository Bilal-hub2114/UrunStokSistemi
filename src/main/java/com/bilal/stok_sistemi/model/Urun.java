package com.bilal.stok_sistemi.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Urun {
    private int id;
    private String adi;
    private double fiyat;

}
