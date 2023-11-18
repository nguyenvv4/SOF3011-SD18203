package com.example.sd18203.model;

import jakarta.persistence.*;
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
public class SinhVien {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @ManyToOne
    @JoinColumn(name = "lop")
    private Lop lop;

    @Column(name = "chieuCao")
    private String chieuCao;

    @Column(name = "canNang")
    private String canNang;

//    public SinhVien(String id, String ten, String diaChi, String gioiTinh, Integer lop) {
//        this.id = id;
//        this.ten = ten;
//        this.diaChi = diaChi;
//        this.gioiTinh = gioiTinh;
//        this.lop = lop;
//    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", lop='" + lop + '\'' +
                ", chieuCao='" + chieuCao + '\'' +
                ", canNang='" + canNang + '\'' +
                '}';
    }
}
