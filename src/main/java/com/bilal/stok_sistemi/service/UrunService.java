package com.bilal.stok_sistemi.service;

import com.bilal.stok_sistemi.model.Urun;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class UrunService {
    public List<Urun> tumUrunleriGetir(){
        List<Urun> liste = new ArrayList<>();

        liste.add(new Urun(1,"RTX 5090",200000.0));
        liste.add(new Urun(2,"ASUS ProArt PA278CFRV 27",20999.0));
        liste.add(new Urun(3,"MSI FORGE GK300 Red Switch",1929.0));
        return liste;
    }
}
