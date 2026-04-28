package com.bilal.stok_sistemi.service;

import com.bilal.stok_sistemi.model.Urun;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
public class UrunService {
    public List<Urun> tumUrunleriGetir() {
        List<Urun> liste = new ArrayList<>();

        try{
            var inputStream = getClass().getResourceAsStream("/urunler.csv");
            if(inputStream == null) return liste;

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8));

            liste = reader.lines()
                    .map(satir -> {
                        String[] veriler = satir.split(",");
                        return new Urun(
                                Integer.parseInt(veriler[0].trim()),
                                veriler[1].trim(),
                                Double.parseDouble(veriler[2].trim())
                        );
                    })
                    .collect(Collectors.toList());
        }
        catch(Exception e){
                        System.out.println("Dosya okurken hata oluştu: "+ e.getMessage());
            }
        return liste;
    }
    public void urunEkle(Urun yeniUrun){
       try (java.io.FileWriter fw = new java.io.FileWriter("src/main/resources/urunler.csv",true);
            java.io.BufferedWriter bw= new java.io.BufferedWriter(fw);
            java.io.PrintWriter out = new java.io.PrintWriter(bw)) {
             out.println(yeniUrun.getId()+","+yeniUrun.getAdi()+","+yeniUrun.getFiyat());
       } catch(java.io.IOException e){
           System.out.println("Dosyaya yazarken hata oluştu: "+ e.getMessage());
       }

    }
}
