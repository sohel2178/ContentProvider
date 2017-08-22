package com.linearbd.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    private String[] mColumnProjection= new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER,
            ContactsContract.Contacts.CONTENT_ITEM_TYPE

    };

    private String mSelectionClause = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY+"='Sohel'";
    private String[] mSelectionArguments = new String[]{"Sohel"};
    private String mOrderBy = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.contacts);

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,mColumnProjection,null,null,null);

        if(cursor!=null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                Log.d("HHHH",cursor.getString(0));
                //Log.d("HHHH",cursor.getString(1));
                //Log.d("HHHH",cursor.getString(2));
                //Log.d("HHHH",cursor.getString(3));
            }
        }else{
            textView.setText("No Contact Found");
        }
    }
}
