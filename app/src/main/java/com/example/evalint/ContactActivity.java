package com.example.evalint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.evalint.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {
private ActivityContactBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void shareWithWhatsapp (String message){
        Intent mIntent = new Intent(Intent.ACTION_SEND);
        mIntent.putExtra(Intent.EXTRA_TEXT, message);
        String number = "+56972126842";
        Uri uri = Uri.parse("smsto:" + number);
        mIntent.setData(uri);
        mIntent.setType("text/plain");
        mIntent.setPackage("com.whatsapp");
        if (mIntent.resolveActivity(getPackageManager())!= null){

        } else {
            Toast.makeText(this, "Debes instalar whatsapp", Toast.LENGTH_SHORT).show();
        }

    }




}
