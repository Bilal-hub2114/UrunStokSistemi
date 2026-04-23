package com.bilal.stok_sistemi.controller;

import com.bilal.stok_sistemi.model.Urun;
import com.bilal.stok_sistemi.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/selam")
    public String selamVer(){
        return "Hello World.";
    }
    @Autowired
    private UrunService urunService;

    @GetMapping("/urunler")
    public List<Urun> urunleriListele(){
       return urunService.tumUrunleriGetir();
    }
}
