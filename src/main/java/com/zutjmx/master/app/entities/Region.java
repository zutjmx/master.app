package com.zutjmx.master.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "region")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "regionid")
    private Integer id;

    @Column(name = "regiondescription")
    private String regionDescription;
}
