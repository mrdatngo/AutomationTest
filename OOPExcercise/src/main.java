import java.util.*;

public class main {

    public class VanDongVien {
        public String hoten;
        public int tuoi;
        public float cannang;
        public float chieucao;

        public VanDongVien(String hoten, int tuoi, float cannang, float chieucao) {
            this.hoten = hoten;
            this.tuoi = tuoi;
            this.cannang = cannang;
            this.chieucao = chieucao;
        }

        public int sosanh(VanDongVien vanDongVien) {
            if (this.chieucao > vanDongVien.chieucao) {
                return 1;
            } else if (this.chieucao < vanDongVien.chieucao){
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "VanDongVien{" +
                    "hoten='" + hoten + '\'' +
                    ", tuoi=" + tuoi +
                    ", cannang=" + cannang +
                    ", chieucao=" + chieucao +
                    '}';
        }
    }

    public class CauThu extends VanDongVien {
        public String caulacbo;
        public int luongtuan;

        public CauThu (String hoten, int tuoi, float cannang, float chieucao) {
            super(hoten, tuoi, cannang, chieucao);
        }

        public int sosanh(CauThu cauThu) {
            if (this.luongtuan > cauThu.luongtuan) {
                return 1;
            } else if (this.luongtuan < cauThu.luongtuan){
                return -1;
            } else {
                return super.sosanh(cauThu);
            }
        }
    }

    public void start() {
        VanDongVien v = new VanDongVien("Ngo Thuc Dat", 26, 55, 165);
        System.out.println(v);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number");
        int numberOfVanDongVien = scan.nextInt();

        List<VanDongVien> vanDongViens = new ArrayList<VanDongVien>();

        for (int i = 0; i < numberOfVanDongVien; i++) {
            System.out.println("Enter Name: ");
            String ten = scan.nextLine();
            System.out.println("Tuoi: ");
            int tuoi = scan.nextInt();
            System.out.println("Tuoi: ");
            int cannang = scan.nextInt();
            System.out.println("Tuoi: ");
            int chieucao = scan.nextInt();
        }

        for (int i = 0; i < numberOfVanDongVien; i++) {
            System.out.println(vanDongViens.get(i));
        }

        Collections.sort(vanDongViens, new Comparator<VanDongVien>() {
            @Override
            public int compare(VanDongVien o1, VanDongVien o2) {
                return o1.sosanh(o2);
            }
        });

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        main myprogram = new main();
        myprogram.start();
    }
}