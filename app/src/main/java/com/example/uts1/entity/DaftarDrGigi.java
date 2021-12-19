package com.example.uts1.entity;

import java.util.ArrayList;

public class DaftarDrGigi
{
    public ArrayList<Dokter> DrGigi;

    public DaftarDrGigi()
    {
        DrGigi = new ArrayList<>();
        DrGigi.add(Evy);
        DrGigi.add(Haryo);
        DrGigi.add(Julie);
        DrGigi.add(Kris);
        DrGigi.add(Ayu);
        DrGigi.add(Tirto);
        DrGigi.add(Julian);
        DrGigi.add(Kristanto);
    }

    public static final Dokter Evy = new Dokter("Evy Tri Utami, drg., Sp.KG","Dokter Gigi","107",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/young-doctor-posing-standing-white-wall_114579-90442.jpg", "Senin pukul 14.00 - 16.00");
    public static final Dokter Haryo = new Dokter("Haryo Mustiko, drg., Sp.Pros(K), Prof., Dr.","Dokter Gigi","108",
            "RS Panti Rapih Yogyakarta","https://img.freepik.com/free-photo/portrait-smiling-handsome-male-doctor-man_171337-5055.jpg?size=626&ext=jpg", "Selasa pukul 14.00 - 16.00");
    public static final Dokter Julie = new Dokter("Julie Christine L., drg., Sp.KGA","Dokter Gigi","109",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg", "Senin pukul 08.00 - 12.00");
    public static final Dokter Kris = new Dokter("Krisnovianto, drg., Sp.KG","Dokter Gigi","110",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/smiling-asian-male-doctor-pointing-upwards_1262-18321.jpg", "Rabu pukul 08.00 - 12.00");
    public static final Dokter Ayu = new Dokter("Ayu Sari Dewi, drg., Sp.KG","Dokter Gigi","107",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/asian-healthcare-female-posing_1258-36738.jpg", "Senin pukul 14.00 - 16.00");
    public static final Dokter Tirto = new Dokter("Tirto Mangunkusumo, drg., Sp.Pros(K), Prof., Dr.","Dokter Gigi","108",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/healthcare-workers-medicine-covid-19-pandemic-self-quarantine-concept-smiling-attractive-doctor-scrubs-glasses-stethoscope-neck-cross-arms-chest-ready-help-patients_1258-58772.jpg", "Selasa pukul 14.00 - 16.00");
    public static final Dokter Julian = new Dokter("Julian Syukur S., drg., Sp.KGA","Dokter Gigi","109",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/confident-female-doctor-asian-physician-medical-uniform-stethoscope-showing-okay-sign-nod-pleased-praising-recommending-smth-good-white-background_1258-83211.jpg", "Senin pukul 08.00 - 12.00");
    public static final Dokter Kristanto = new Dokter("Kristanto Novianto, drg., Sp.KG","Dokter Gigi","110",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/healthcare-workers-pandemic-coronavirus-outbreak-concept-enthusiastic-smiling-bearded-doctor-blue-scrubs-stethoscope-pointing-fingers-up-show-top-ad-look-amazed-happy_1258-57228.jpg", "Rabu pukul 08.00 - 12.00");
}
