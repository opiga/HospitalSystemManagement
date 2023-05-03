package com.example.hospitalsystemmanagement.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by bonda on 13.04.2023 13:11
 *
 * @author bonda
 */
@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long categoryId;
    @Column(name= "name_Category")
    private String nameCategory;
}
