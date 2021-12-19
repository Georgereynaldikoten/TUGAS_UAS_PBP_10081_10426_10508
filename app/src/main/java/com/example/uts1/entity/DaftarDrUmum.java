package com.example.uts1.entity;

import java.util.ArrayList;

public class DaftarDrUmum
{
    public ArrayList<Dokter> DrUmum;

    public DaftarDrUmum()
    {
        DrUmum = new ArrayList<>();
        DrUmum.add(Edhi);
        DrUmum.add(Elisabeth);
        DrUmum.add(Stephanus);
        DrUmum.add(Yolenta);
        DrUmum.add(Heri);
        DrUmum.add(Lisa);
        DrUmum.add(Yogi);
        DrUmum.add(Siska);
    }

    public static final Dokter Edhi = new Dokter("Edhi Dharma, dr.","Dokter Umum","103",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/smiling-asian-male-doctor-pointing-upwards_1262-18321.jpg","Senin pukul 11.00 - 13.00");
    public static final Dokter Elisabeth = new Dokter("Elisabeth Alexandra, dr.","Dokter Umum","104",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/portrait-asian-doctor-woman-cross-arms-standing-medical-uniform-stethoscope-smiling-cam_1258-83844.jpg", "Selasa pukul 10.00 - 14.00");
    public static final Dokter Stephanus = new Dokter("Stephanus Hardyanto, dr.","Dokter Umum","105",
            "RS Panti Rapih Yogyakarta","https://img.freepik.com/free-photo/portrait-smiling-handsome-male-doctor-man_171337-5055.jpg?size=626&ext=jpg", "Sabtu pukul 10.00 - 14.00");
    public static final Dokter Yolenta = new Dokter("Yolenta Marganingsih, dr.","Dokter Umum","106",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/confident-asian-female-doctor-sitting-office-desk-smiling-camera_7861-1221.jpg", "Kamis pukul 10.00 - 17.00");
    public static final Dokter Heri = new Dokter("Heri Kusnardi, dr.","Dokter Umum","103",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/friendly-male-doctor-his-office_8595-5344.jpg","Senin pukul 11.00 - 13.00");
    public static final Dokter Lisa = new Dokter("Elisabeth Cammera, dr.","Dokter Umum","104",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/portrait-beautiful-young-asian-doctor-asian-woman_74190-10516.jpg", "Selasa pukul 10.00 - 14.00");
    public static final Dokter Yogi = new Dokter("Yogi Thai, dr.","Dokter Umum","105",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/smiling-young-male-doctor-wearing-medical-robe-stethoscope-standing-isolated-purple-wall-with-copy-space_141793-59803.jpg", "Sabtu pukul 10.00 - 14.00");
    public static final Dokter Siska = new Dokter("Siska Kerang, dr.","Dokter Umum","106",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/happy-smiling-female-doctor-with-okay-gesture-isolated-white_231208-13019.jpg", "Kamis pukul 10.00 - 17.00");
}
