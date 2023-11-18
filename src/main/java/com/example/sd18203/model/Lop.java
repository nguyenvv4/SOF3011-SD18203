package com.example.sd18203.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
@Entity
public class Lop {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "tenLop")
    private String ten;
}
