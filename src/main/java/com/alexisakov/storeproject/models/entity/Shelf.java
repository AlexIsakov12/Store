package com.alexisakov.storeproject.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shelf")
public class Shelf implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shelf_name")
    private String shelfName;

    @ManyToMany
    @JoinTable(
            name = "shelf_shelf_category",
            joinColumns = @JoinColumn(name = "shelf_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<ShelfCategory> shelfCategories;

    @OneToMany(mappedBy = "shelf")
    private List<ShelfProduct> shelfProducts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

}
