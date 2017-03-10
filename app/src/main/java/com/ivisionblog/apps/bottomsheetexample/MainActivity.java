package com.ivisionblog.apps.bottomsheetexample;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ivisionblog.apps.bottomsheetexample.adapter.ContactsAdapter;
import com.ivisionblog.apps.bottomsheetexample.modal.ContactsModal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        View bottomSheet = findViewById( R.id.bottom_sheet );
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });
        ContactsAdapter contactsAdapter = new ContactsAdapter(generateData(),mBottomSheetBehavior,getSupportFragmentManager());
        mRecyclerView.setAdapter(contactsAdapter);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

    }
    private ArrayList<ContactsModal> generateData(){
        ArrayList<ContactsModal> contactsModals = new ArrayList<>();

        contactsModals.add(new ContactsModal("Midhun Vignesh S","987654321"));
        contactsModals.add(new ContactsModal("Shivasurya S","987654321"));
        contactsModals.add(new ContactsModal("Aswin Vayiravan","987654321"));
        contactsModals.add(new ContactsModal("Muthu Alagappan M","987654321"));
        contactsModals.add(new ContactsModal("SriramaMoorthy S","987654321"));
        contactsModals.add(new ContactsModal("Puviyarasu V","987654321"));
        contactsModals.add(new ContactsModal("Arun Kumar K R","987654321"));
        contactsModals.add(new ContactsModal("Venkat Raman","987654321"));

        return contactsModals;
    }
}
