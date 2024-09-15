import java.util.ArrayList;
import java.util.Scanner;
public class menghitungIPK {
    public static void main(String[] args) {
        class mataKuliah {
            String nama;
            int sks;
            String nilai;

            // Constructor
            public mataKuliah(String nama, int sks, String nilai) {
                this.nama = nama;
                this.sks = sks;
                this.nilai = nilai;
            }

            // Mengkonversi nilai huruf ke angka
            public double konversiNilai() {
                return switch (nilai.toUpperCase()) {
                    case "A" -> 4.0;
                    case "AB" -> 3.5;
                    case "B" -> 3.0;
                    case "BC" -> 2.5;
                    case "C" -> 2.0;
                    case "CD" -> 1.5;
                    case "D" -> 1.0;
                    case "E" -> 0.5;
                    // Input lain 0.0
                    default -> 0.0;
                };
            }
        }

        System.out.println("Konversi nilai: ");
        System.out.println("A  -> 4.0  C  -> 2.0");
        System.out.println("AB -> 3.5  CD -> 1.5");
        System.out.println("B  -> 3.0  D  -> 1.0");
        System.out.println("BC -> 2.5  E  -> 0.5");

        Scanner scan = new Scanner(System.in);
        ArrayList<mataKuliah> daftarMataKuliah = new ArrayList<>();

        // Membuat blok input
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();

        boolean lagi = true;
        while (lagi) {
            // Membuat blok input dalam loop
            System.out.print("\nNama mata kuliah: ");
            String namaMataKuliah = scan.nextLine();
            System.out.print("SKS: ");
            int sks = scan.nextInt();
            scan.nextLine();
            System.out.print("Nilai: ");
            String nilai = scan.nextLine();

            // Menambahkan class mata kuliah ke dalam daftar
            daftarMataKuliah.add(new mataKuliah(namaMataKuliah, sks, nilai));

            // Menanyakan apakah ingin menambahkan nilai lagi
            System.out.print("Ingin memasukkan nilai lagi? (y/n): ");
            String opsi = scan.nextLine();
            // Jika input "y" maka kembalikan true
            lagi = opsi.equalsIgnoreCase("y");
        }

        // Menghitung total SKS dan total nilai
        double totalNilai = 0.0;
        int totalSKS = 0;
        for (mataKuliah mk : daftarMataKuliah) {
            totalNilai += mk.konversiNilai() * mk.sks;
            totalSKS += mk.sks;
        }

        // Menghitung IPK
        double ipk = totalNilai / totalSKS;

        System.out.printf("\nIPK dari %s (%s) adalah %.2f", nama, nim, ipk);
    }
}