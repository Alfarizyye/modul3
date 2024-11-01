package org.example;

import java.util.ArrayList;

/**
 * Kelas Pesanan merepresentasikan sebuah item pesanan makanan di restoran.
 */
class Pesanan {
    private String nama;
    private double harga;
    private int jumlah;

    /**
     * Konstruktor untuk membuat item pesanan baru.
     *
     * @param nama   Nama makanan
     * @param harga  Harga per item
     * @param jumlah Jumlah yang dipesan
     */
    public Pesanan(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    /**
     * Menghitung total harga berdasarkan harga per item dan jumlah pesanan.
     *
     * @return Total harga untuk item pesanan ini
     */
    public double hitungTotal() {
        return harga * jumlah;
    }

    /**
     * Mengambil nama item pesanan.
     *
     * @return Nama makanan
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengambil jumlah pesanan.
     *
     * @return Jumlah item yang dipesan
     */
    public int getJumlah() {
        return jumlah;
    }
}

/**
 * Kelas ManajemenPesanan mengelola daftar pesanan dan melakukan kalkulasi total.
 */
class ManajemenPesanan {
    private ArrayList<Pesanan> daftarPesanan;

    /**
     * Konstruktor untuk membuat manajemen pesanan dengan daftar pesanan baru.
     */
    public ManajemenPesanan() {
        daftarPesanan = new ArrayList<>();
    }

    /**
     * Menambahkan pesanan ke daftar pesanan.
     *
     * @param pesanan Objek pesanan yang ingin ditambahkan
     */
    public void tambahPesanan(Pesanan pesanan) {
        daftarPesanan.add(pesanan);
    }

    /**
     * Menghitung total keseluruhan dari semua item pesanan.
     *
     * @return Total harga keseluruhan
     */
    public double hitungTotalKeseluruhan() {
        double total = 0;
        for (Pesanan pesanan : daftarPesanan) {
            total += pesanan.hitungTotal();
        }
        return total;
    }

    /**
     * Mencetak nota yang berisi detail setiap pesanan dan total keseluruhan.
     */
    public void cetakNota() {
        System.out.println("Nota Pesanan:");
        for (Pesanan pesanan : daftarPesanan) {
            System.out.println(pesanan.getNama() + " x" + pesanan.getJumlah() + " = " + pesanan.hitungTotal());
        }
        System.out.println("Total Keseluruhan: " + hitungTotalKeseluruhan());
    }
}

/**
 * Kelas utama untuk menjalankan aplikasi manajemen pesanan makanan di restoran.
 */
public class AplikasiRestoran {
    /**
     * Metode utama untuk menjalankan aplikasi.
     *
     * @param args Argumen baris perintah
     */
    public static void main(String[] args) {
        ManajemenPesanan manajemenPesanan = new ManajemenPesanan();
        manajemenPesanan.tambahPesanan(new Pesanan("Nasi Goreng", 25000, 2));
        manajemenPesanan.tambahPesanan(new Pesanan("Ayam Bakar", 30000, 1));
        manajemenPesanan.cetakNota();
    }
}
