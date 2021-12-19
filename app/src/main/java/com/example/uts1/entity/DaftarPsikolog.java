package com.example.uts1.entity;

import java.util.ArrayList;

public class DaftarPsikolog
{
    public ArrayList<Dokter> Psikolog;

    public DaftarPsikolog()
    {
        Psikolog = new ArrayList<>();
        Psikolog.add(Agnes);
        Psikolog.add(Maria);
        Psikolog.add(Vennu);
    }

    public static final Dokter Agnes = new Dokter("Agnes Dewanti P, Psi., MPsi","Psikolog","100",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/female-doctor-using-stethoscope-white_114579-77921.jpg","Selasa pukul 09.00 - 11.00");
    public static final Dokter Maria = new Dokter("Maria Ratih Maharani, M.Psi., Psikolog","Psikolog","101",
            "RS Panti Rapih Yogyakarta","https://image.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg","Rabu pukul 09.00 - 13.00");
    public static final Dokter Vennu = new Dokter("Vennu, M.Psi","Psikolog","102",
            "RS Panti Rapih Yogyakarta","https://img.freepik.com/free-photo/portrait-smiling-handsome-male-doctor-man_171337-5055.jpg?size=626&ext=jpg","Senin pukul 17.00 - 18.00");
}
