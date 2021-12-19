package com.example.uts1.entity;

import java.util.ArrayList;

public class DaftarDrHewan
{
    public ArrayList<Dokter> DrHewan;

    public DaftarDrHewan()
    {
        DrHewan = new ArrayList<>();
        DrHewan.add(Anis);
        DrHewan.add(Ari);
        DrHewan.add(Ety);
        DrHewan.add(Anggi);
        DrHewan.add(Brian);
        DrHewan.add(Ariel);
        DrHewan.add(Ecy);
        DrHewan.add(Anggika);
    }

    public static final Dokter Anis = new Dokter("Anis Hanifa Tiara, drh.","Dokter Hewan","111",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg", "Senin pukul 08.00 - 12.00");
    public static final Dokter Ari = new Dokter("Tri Ari Widiastuti, drh.","Dokter Hewab","112",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/young-asian-lady-doctor-white-medical-uniform-with-stethoscope-using-computer-laptop_7861-2838.jpg", "Selasa pukul 08.00 - 12.00");
    public static final Dokter Ety = new Dokter("Ety Erarindah, drh. ","Dokter Hewan","113",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg", "Rabu pukul 08.00 - 12.00");
    public static final Dokter Anggi = new Dokter("Anggi Desterina Prayitno, drh. ","Dokter Hewan","114",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/closeup-shot-female-doctor-holding-clipboard_181624-45534.jpg", "Kamis pukul 08.00 - 12.00");
    public static final Dokter Brian = new Dokter("Brian O. Connor, drh.","Dokter Hewan","111",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/healthcare-professional-dressed-lab-coat-staring-away_259150-57770.jpg", "Senin pukul 08.00 - 12.00");
    public static final Dokter Ariel = new Dokter("Ariel H. Tegar, drh.","Dokter Hewab","112",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/asian-male-medical-doctor_1098-19688.jpg", "Selasa pukul 08.00 - 12.00");
    public static final Dokter Ecy = new Dokter("Ecy Florensa, drh. ","Dokter Hewan","113",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg", "Rabu pukul 08.00 - 12.00");
    public static final Dokter Anggika = new Dokter("Anggika Ningsih, drh. ","Dokter Hewan","114",
            "Klinik Hewan Jogja","https://image.freepik.com/free-photo/portrait-beautiful-young-asian-doctor-asian-woman_74190-10516.jpg", "Kamis pukul 08.00 - 12.00");

}
