package com.main.modules.banner.domain.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "banners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String image;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String description;


}
