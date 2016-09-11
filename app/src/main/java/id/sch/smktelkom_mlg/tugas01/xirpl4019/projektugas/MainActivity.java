package id.sch.smktelkom_mlg.tugas01.xirpl4019.projektugas;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama ;
    EditText etUmur;
    EditText etAngkatan;
    TextView tvHasil;
    TextView tvHasil2;
    TextView tvHasil3;
    TextView tvHasil4;
    TextView tvHasil5;
    TextView tvHasil6;
    Button bOK;
    RadioGroup rgStatus;
    RadioGroup rgRiwayat;
    CheckBox PG,SG,SF,PF,C;
    Spinner spJurusan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

etNama = (EditText) findViewById(R.id.editTextNama);
        etUmur = (EditText) findViewById(R.id.editTextUmur);
        etAngkatan = (EditText) findViewById(R.id.editTextAngkatan);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil) ;
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        rgStatus = (RadioGroup) findViewById(R.id.radiogrouStatus);
        rgRiwayat = (RadioGroup) findViewById(R.id.radiogroupRiwayat);
        tvHasil3 = (TextView) findViewById(R.id.textViewRiwayat);
        PG = (CheckBox) findViewById(R.id.PG);
        SG = (CheckBox) findViewById(R.id.SG);
        SF = (CheckBox) findViewById(R.id.SF);
        PF = (CheckBox) findViewById(R.id.PF);
        C = (CheckBox) findViewById(R.id.C);
        tvHasil4 = (TextView) findViewById(R.id.textViewPosisi);
        tvHasil5 = (TextView) findViewById(R.id.textViewAngkatan);
        spJurusan = (Spinner) findViewById(R.id.spinnerJurusan);
        tvHasil6 = (TextView) findViewById(R.id.textViewJurusan);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doClick();

               String nama = etNama.getText().toString();
                String Umur = etUmur.getText().toString();
                tvHasil.setText("nama : " + nama + "\n"+ "umur : "+ "" + Umur);
                String Angkatan = etAngkatan.getText().toString();
                tvHasil5.setText("Angkatan ke :" + Angkatan);




            }
        });



    }

    private void doClick() {

        String hasil = null;

        if(rgStatus.getCheckedRadioButtonId()!=-1)
        {

            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if(hasil == null)
        {
            tvHasil2.setText("Belum Memilih Status");
        }
        else{
            tvHasil2.setText(hasil);
        }

        if(rgStatus.getCheckedRadioButtonId()!=-1)
        {

            RadioButton rb = (RadioButton)
                    findViewById(rgRiwayat.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if(hasil == null)
        {
            tvHasil3.setText("Belum Memilih Status");
        }
        else{
            tvHasil3.setText(hasil);
        }



        hasil = "Posisi anda : ";
        int startlen = hasil.length();
        if (PG.isChecked()) hasil+=PG.getText()+"\n";
        if (SG.isChecked()) hasil+=SG.getText()+"\n";
        if (SF.isChecked()) hasil+=SF.getText()+"\n";
        if (PF.isChecked()) hasil+=PF.getText()+"\n";
        if (C.isChecked()) hasil+=C.getText()+"\n";

        if(hasil.length()==startlen) hasil+="Tidak ada pilihan";

        tvHasil4.setText(hasil);

        tvHasil6.setText("Jurusan :" + spJurusan.getSelectedItem().toString());

    }
}
