package com.zutjmx.master.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    private Integer id;

    @Column(name = "categoryname")
    private String categoryName;

    @Column(name = "description")
    private String description;
}
