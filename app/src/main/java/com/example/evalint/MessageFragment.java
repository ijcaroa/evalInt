package com.example.evalint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.evalint.databinding.FragmentMessageBinding;


public class MessageFragment extends Fragment {
    private FragmentMessageBinding mBinding;




    public MessageFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    mBinding = FragmentMessageBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.btnContact.setVisibility(View.GONE);
                mBinding.msgHolder.setVisibility(View.VISIBLE);
                mBinding.btnSet.setVisibility(View.VISIBLE);
            }
        });
        mBinding.btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBinding.eTMsg.getText().toString().length() != 0){
                    String message =mBinding.eTMsg.getText().toString();

                } else {
                    Toast.makeText(getContext(), "Debes ingresar un mensaje", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void sendMessage(String message){

        String [] emails = {"ignacio.caro@outlook.com"};
        Intent mIntent = new Intent(Intent.ACTION_SENDTO);
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        mIntent.putExtra(Intent.EXTRA_SUBJECT,"CONTACTO ABOUT ME");
        mIntent.putExtra(Intent.EXTRA_TEXT, message);
        if (mIntent.resolveActivity(getActivity().getPackageManager()) != null){
            startActivity(mIntent);
        } else {
            Toast.makeText(getContext(), "Debes instalar una app de correo",
                    Toast.LENGTH_SHORT).show();
        }
    }
}