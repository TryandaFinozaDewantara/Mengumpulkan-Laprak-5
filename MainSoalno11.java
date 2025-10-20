class Mahasiswa {
    private String nama;
    private int nilai;

    public Mahasiswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public int getNilai() {
        return nilai;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + nama + " - Nilai: " + nilai);
    }
}

public class MainSoalno11 {
    public static void main(String[] args) {
        Mahasiswa[] daftar = new Mahasiswa[3];
        daftar[0] = new Mahasiswa("King Zaki", 95);
        daftar[1] = new Mahasiswa("Prince Ardi", 85);
        daftar[2] = new Mahasiswa("Ajudan Farrash", 60);

        for (Mahasiswa mhs : daftar) {
            mhs.tampilkanData();
        }

        Mahasiswa tertinggi = daftar[0];
        for (int i = 1; i < daftar.length; i++) {
            if (daftar[i].getNilai() > tertinggi.getNilai()) {
                tertinggi = daftar[i];
            }
        }

        System.out.println("Mahasiswa dengan nilai tertinggi: " +
                           tertinggi.getNama() + " (" + tertinggi.getNilai() + ")");
    }
}
