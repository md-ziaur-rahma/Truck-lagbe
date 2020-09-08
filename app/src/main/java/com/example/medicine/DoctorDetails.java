package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorDetails extends AppCompatActivity {

    private ImageView drImage;
    private TextView drName, drCategory, drEduQualification, drDesignatioln, institute, consultantFee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        drImage = (ImageView)findViewById(R.id.doctorsDetails_profileID);
        drName = (TextView)findViewById(R.id.doctorsDetailsNameID);
        drCategory = (TextView)findViewById(R.id.doctorsDetailsCaategoryID);
        drEduQualification = (TextView)findViewById(R.id.doctorsDetailsEducationID);
        drDesignatioln = (TextView)findViewById(R.id.doctorsDetailsDesignationID);
        institute = (TextView)findViewById(R.id.doctorsDetailsInstituteID);
        consultantFee = (TextView)findViewById(R.id.doctorsDetailsFeeID);


        drImage.setImageResource(getIntent().getIntExtra("image",0));
        drName.setText(getIntent().getStringExtra("name"));
        drCategory.setText(getIntent().getStringExtra("category"));
        drEduQualification.setText(getIntent().getStringExtra("drEduQualification"));
        drDesignatioln.setText(getIntent().getStringExtra("dedignation"));
        institute.setText(getIntent().getStringExtra("institute"));
        consultantFee.setText("Tk - "+getIntent().getStringExtra("consultantFee"));


    }
}