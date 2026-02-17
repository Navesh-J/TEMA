package com.navesh.TEMA.common.entity;

import com.navesh.TEMA.common.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    @ManyToOne
    private User vendor;

    private String name;
    private Double price;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    private boolean active = true;
}
