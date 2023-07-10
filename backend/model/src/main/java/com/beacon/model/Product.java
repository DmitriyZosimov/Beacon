package com.beacon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Map;

@MappedSuperclass
@Getter
@Setter
public abstract class Product {


    @Column(name = "relevant", nullable = false)
    @JsonIgnore
    private Integer relevant;

    @PrePersist
    @PreUpdate
    public void preSave() {
        this.relevant = Integer.parseInt(getReleaseYear()) + getPriority(getBrand());
    }

    protected abstract String getReleaseYear();

    protected abstract String getBrand();

    private int getPriority(String brand) {
        Map<String, Integer> priorities = Map.ofEntries(Map.entry("apple", 5), Map.entry("samsung", 5),
                Map.entry("xiaomi", 5), Map.entry("poco", 5), Map.entry("honor", 5),
                Map.entry("huawei", 5), Map.entry("sony", 5), Map.entry("realme", 5),
                Map.entry("oneplus", 5), Map.entry("google", 5), Map.entry("vivo", 5),
                Map.entry("a1", 3), Map.entry("agm", 3), Map.entry("alcatel", 3),
                Map.entry("asus", 4), Map.entry("black shark", 3), Map.entry("blackview", 3),
                Map.entry("bq-mobile", 4), Map.entry("caterpillar", 3), Map.entry("conquest", 3),
                Map.entry("cubot", 3), Map.entry("dexp", 3), Map.entry("digma", 3),
                Map.entry("dizo", 3), Map.entry("doogee", 3), Map.entry("f+", 3),
                Map.entry("f150", 3), Map.entry("ginzzu", 3), Map.entry("homtom", 3),
                Map.entry("htc", 4), Map.entry("infinix", 3), Map.entry("inoi", 3),
                Map.entry("irbis", 3), Map.entry("itel", 3), Map.entry("joy's", 3),
                Map.entry("keneksi", 3), Map.entry("leeco", 3), Map.entry("lenovo", 4),
                Map.entry("lexand", 3), Map.entry("lg", 4), Map.entry("maxvi", 3),
                Map.entry("meizu", 3), Map.entry("micromax", 3), Map.entry("motorola", 4),
                Map.entry("myphone", 3), Map.entry("nobby", 3), Map.entry("nokia", 4),
                Map.entry("nubia", 3), Map.entry("olmio", 3), Map.entry("oppo", 3),
                Map.entry("oukitel", 3), Map.entry("panasonic", 4), Map.entry("philips", 4),
                Map.entry("prestigio", 3), Map.entry("strike", 3), Map.entry("sunwind", 3),
                Map.entry("tcl", 3), Map.entry("tecno", 3), Map.entry("texet", 3),
                Map.entry("ulefone", 3), Map.entry("umidigi", 3), Map.entry("vertext", 3),
                Map.entry("vsmart", 3), Map.entry("zoji", 3), Map.entry("zte", 4));
        return priorities.getOrDefault(brand.toLowerCase(), 1);
    }
}
