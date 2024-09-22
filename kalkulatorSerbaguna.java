import java.util.Scanner;
public class kalkulatorSerbaguna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nKalkulator Serbaguna:");
            System.out.println("1. Kalkulator Bilangan Prima");
            System.out.println("2. Menghitung Nilai Rata-Rata Kelas");
            System.out.println("3. Kalkulator Suhu");
            System.out.println("4. Kalkulator Kurs Dollar");
            System.out.println("5. Exit Menu");

            try {
                System.out.print("Masukkan pilihan kamu: ");
                int pilihan = Integer.parseInt((scan.nextLine()));

                switch (pilihan) {
                    case 1:
                        kalkulatorPrima(scan);
                        break;
                    case 2:
                        rataRataKelas(scan);
                        break;
                    case 3:
                        kalkulatorSuhu(scan);
                        break;
                    case 4:
                        kalkulatorKurs(scan);
                        break;
                    case 5 :
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan kamu invalid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silahkan masukkan angka.");
            }
        }
    }

    public static void kalkulatorPrima(Scanner scanner) {
        do {
            try {
                System.out.print("\nMasukkan bilangan: ");
                int bilangan = Integer.parseInt(scanner.nextLine());
                if (bilangan <= 1) {
                    System.out.println(bilangan + " bukan bilangan prima.");
                } else {
                    boolean prima = true;
                    for (int i = 2; i <= Math.sqrt(bilangan); i++) {
                        if (bilangan % i == 0) {
                            prima = false;
                            break;
                        }
                    }
                    if (prima) {
                        System.out.println(bilangan + " adalah bilangan prima.");
                    } else {
                        System.out.println(bilangan + " bukan bilangan prima.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silahkan masukkan angka.");
            }
        } while (ulang(scanner));
    }

    public static void rataRataKelas(Scanner scanner) {
        do {
            try {
                System.out.print("\nMasukkan jumlah siswa: ");
                int jumlahSiswa = Integer.parseInt(scanner.nextLine());
                double totalNilai = 0;
                double nilaiTertinggi = Double.MIN_VALUE;
                double nilaiTerendah = Double.MAX_VALUE;

                for (int i = 1; i <= jumlahSiswa; i++) {
                    System.out.print("Masukkan nilai siswa ke-" + i + ": ");
                    double nilai = Double.parseDouble(scanner.nextLine());
                    totalNilai += nilai;
                    if (nilai > nilaiTertinggi) nilaiTertinggi = nilai;
                    if (nilai < nilaiTerendah) nilaiTerendah = nilai;
                }

                double rataRata = totalNilai / jumlahSiswa;
                System.out.println("Rata-rata nilai: " + rataRata);
                System.out.println("Nilai tertinggi: " + nilaiTertinggi);
                System.out.println("Nilai terendah: " + nilaiTerendah);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid.");
            }
        } while (ulang(scanner));
    }

    public static void kalkulatorSuhu(Scanner scanner) {
        do {
            try {
                System.out.print("\nMasukkan suhu pada hari ini dalam Celsius: ");
                double celsius = Double.parseDouble(scanner.nextLine());
                double fahrenheit = (celsius * 9/5) + 32;
                double kelvin = celsius + 273.15;
                double reamur = celsius * 4/5;

                System.out.println(celsius + " derajat Celsius");
                System.out.println(fahrenheit + " derajat Fahrenheit");
                System.out.println(kelvin + " Kelvin");
                System.out.println(reamur + " derajat Reamur");
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid.");
            }
        } while (ulang(scanner));
    }

    public static void kalkulatorKurs(Scanner scanner) {
        do {
            try {
                System.out.print("\nMasukkan Dollar: $");
                double dollar = Double.parseDouble(scanner.nextLine());
                double rupiah = dollar * 15545;
                double euro = dollar * 0.915;
                double yen = dollar * 146.62;
                double pound = dollar * 0.7618;

                System.out.println("Hasil kurs:");
                System.out.println("Rupiah Indonesia: Rp" + rupiah);
                System.out.println("Euro Eropa: €" + euro);
                System.out.println("Yen Jepang: ¥" + yen);
                System.out.println("Poundsterling Inggris: £" + pound);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid.");
            }
        } while (ulang(scanner));
    }

    public static boolean ulang(Scanner scanner) {
        while (true) {
            System.out.print("Ingin mengulangi? (y/n): ");
            String feedback = scanner.nextLine().toLowerCase();
            if (feedback.equals("y")) {
                return true;
            } else if (feedback.equals("n")) {
                return false;
            } else {
                System.out.println("Input tidak valid.");
            }
        }
    }
}
