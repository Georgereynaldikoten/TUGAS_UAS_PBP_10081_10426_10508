package com.example.uts1.entity;

import java.util.ArrayList;
import java.util.List;

public class DaftarArtikel
{
    public ArrayList<Artikel> artikel;

    public DaftarArtikel()
    {
        artikel = new ArrayList<>();
        artikel.add(buah);
        artikel.add(kurangPerhatian);
        artikel.add(rabies);
        artikel.add(sakitGigi);
        artikel.add(pernikahanDini);
        artikel.add(buah1);
    }

    public static final Artikel buah = new Artikel("https://picsum.photos/id/1080/6858/4574", "Buah", "9 Buah yang Paling Banyak Mengandung Vitamin C",
            "Selama ini, banyak orang beranggapan bahwa sumber terbaik vitamin C adalah jeruk. Padahal, jeruk bukanlah buah yang paling banyak mengandung vitamin C. Masih ada buah-buahan lain dengan kandungan vitamin C yang jauh lebih berlimpah. Beberapa di antaranya mungkin tidak Anda duga. Apa saja contohnya?\n" +
                    "\nBeragam buah yang mengandung vitamin C \n1. Jambu biji \n2. Pepaya \n3. Kiwi \n4. Jeruk \n5. Stroberi \n6. Nanas \n7. Mangga \n8. Blackcurrant \n9. Lemon",
            "Selama ini, banyak orang beranggapan..");
    public static final Artikel kurangPerhatian = new Artikel("https://picsum.photos/id/1010/5184/3456", "Anak", "Tanda Anak Kurang Perhatian Orangtua dan Efeknya",
                    "Tanpa disadari, banyak orangtua yang tidak sengaja atau bahkan sengaja mengabaikan anaknya. Hal ini membuat anak menjadi kurang perhatian dan kasih sayang dari orangtuanya. Perasaan ini dapat memengaruhi tumbuh kembang si anak, khususnya pada perkembangan psikologis anak. " +
                        "Lalu, bagaimana mengetahui jika anak kurang perhatian dari orangtua?\n" +"\nBentuk mengabaikan anak yang mungkin dilakukan orangtua" +
                        "\nMungkin kebanyakan orangtua tidak menyadari bahwa mereka telah mengabaikan anak. Sebenarnya, mengabaikan anak tak hanya sekadar tidak memberi perhatian atau kasih sayang.\n" +
                        "\nNamun, hal ini juga berkaitan dengan pemenuhan semua kebutuhan anak, dari kebutuhan mental, fisik, kesehatan, dan pendidikan. Anak yang kurang perhatian dan kasih sayang orangtua, biasanya cenderung mengalami berbagai masalah kesehatan baik fisik maupun mental.",
            "Tanpa disadari, banyak orangtua yang tidak..");
    public static final Artikel rabies = new Artikel("https://picsum.photos/id/1025/4951/3301", "Hewan", "Waspadai Penularan Rabies dari Hewan, Ini Ciri-Ciri Anjing yang Terinfeksi",
            "Rabies tidak hanya menjangkit hewan tertentu, tapi juga bisa menginfeksi manusia. Sebagian besar kasus rabies pada manusia terjadi akibat gigitan hewan yang terinfeksi seperti anjing. Saat terinfeksi, virus rabies bisa menyebabkan gangguan pada sistem saraf. Untuk mencegah penularan virus rabies pada manusia, Anda perlu mengetahui ciri-ciri rabies pada hewan yang berisiko terinfeksi seperti anjing dan kucing."+
                "Ciri-ciri rabies pada hewan peliharaan seperti anjing dan kucing adalah:\n" +
                "\nselalu gelisah,\ntidak bisa diam,\nketakutan,\nlebih sensitif dan mudah marah,\nterlihat kesakitan,\ndemam,\nsering menggigiti benda-benda,\nsering menyerang hewan lain,\n" +
                "kelumpuhan kaki belakang,\ntidak nafsu makan,\nkejang, dan\nair liur berbuih.",
            "Rabies tidak hanya menjangkit hewan..");
    public static final Artikel sakitGigi = new Artikel("https://cdn.hellosehat.com/wp-content/uploads/2019/06/shutterstock_1258029415.jpg", "Gigi", "2 Pilihan Obat untuk Sakit Gigi Berlubang",
            "Dikutip dari Mayo Clinic, gigi berlubang yang tidak diobati dapat semakin parah. Lubang akan menjadi lebih besar dan proses pembusukannya memengaruhi setiap lapisan gigi sampai ke akar.\n" +
                    "\nHal ini tentu membuat gigi yang berlubang terasa semakin sakit. Saat Anda berkunjung ke dokter gigi, dokter tidak akan segera melakukan tindakan tertentu melainkan meresepkan obat untuk mengobati terlebih dulu sakit akibat gigi berlubang. Lalu dokter akan menyarankan Anda untuk kembali lagi di lain waktu saat nyerinya sudah mereda.\n" +
                    "\nNah sementara menunggu jadwal berobat selanjutnya, berikut pilihan obat di apotik yang bisa Anda gunakan untuk meringankan sakit pada gigi berlubang:\n" +
                    "\n1. Paracetamol \n2. Ibuprofen",
            "Dikutip dari Mayo Clinic, gigi berlubang..");
    public static final Artikel pernikahanDini = new Artikel("https://cdn.hellosehat.com/wp-content/uploads/2017/01/dampak-psikologis-pernikahan-usia-remaja.jpg", "Remaja", "Dampak Psikologis Pernikahan Dini",
            "Angka pernikahan usia remaja (di bawah 18 tahun) di Indonesia cukup tinggi jika dibandingkan dengan negara-negara lainnya. Menurut data yang dihimpun oleh UNICEF, badan PBB yang bergerak dalam bidang kesejahteraan anak, dari seluruh wanita Indonesia yang telah menikah, 34% di antaranya menikah saat remaja.\n" +
                    "\nBanyaknya kasus pernikahan usia remaja di Indonesia dan negara-negara lain di Asia dan Afrika mengundang perhatian khusus dari para peneliti. Mungkin Anda sudah pernah dengar bagaimana pernikahan usia remaja berisiko menyebabkan keguguran, kematian bayi, kematian ibu saat bersalin, kanker serviks (leher rahim), dan penularan penyakit kelamin. Di samping berbagai risiko kesehatan tersebut, pernikahan usia remaja juga berdampak buruk bagi kesehatan mental kedua orang pasangan. " +
                    "Berikut adalah dampak-dampak psikologis yang mungkin muncul karena pernikahan usia remaja gangguan mental, kecanduan, tekanan sosial",
            "Angka pernikahan usia remaja (di bawah 18 tahun) di..");
    public static final Artikel buah1 = new Artikel("https://picsum.photos/id/1080/6858/4574", "Buah", "9 Buah yang Paling Banyak Mengandung Vitamin C",
            "Selama ini, banyak orang beranggapan bahwa sumber terbaik vitamin C adalah jeruk. Padahal, jeruk bukanlah buah yang paling banyak mengandung vitamin C. Masih ada buah-buahan lain dengan kandungan vitamin C yang jauh lebih berlimpah. Beberapa di antaranya mungkin tidak Anda duga. Apa saja contohnya?\n" +
                    "\nBeragam buah yang mengandung vitamin C \n1. Jambu biji \n2. Pepaya \n3. Kiwi \n4. Jeruk \n5. Stroberi \n6. Nanas \n7. Mangga \n8. Blackcurrant \n9. Lemon",
            "Selama ini, banyak orang beranggapan..");
}
