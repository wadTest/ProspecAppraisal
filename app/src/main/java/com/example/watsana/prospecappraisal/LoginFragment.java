package com.example.watsana.prospecappraisal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LoginFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//    Crete Toolbar
        creteToolbar();

    }//Main Method

//  Method Toolbar
    private void creteToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbar_login);
        ((FormBankActivity) getActivity()).setSupportActionBar(toolbar);
        ((FormBankActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.toolbar_login));
        ((FormBankActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.massage_login));

//       เมื่อทำการกดปุ่มย้อยหลัง ให้ลบ Activity นี้ทิ้งซะ
        ((FormBankActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((FormBankActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//      การทำปุ่มย้อนกลับ
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        setHasOptionsMenu(true);

        toolbar.setNavigationIcon(R.drawable.logo2);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//      สร้างหน้ากาก layout ชื่อ fragment_login
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }
}//Main Class