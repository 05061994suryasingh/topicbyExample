package com.chromeinfotech.Ui.contentprovider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.contentprovider.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ListView list_contacts;
    private ContactAdapter arrayAdapter;
    private  Cursor cursor;
    private List<Contacts> StoreContacts  = new ArrayList<Contacts>();;
    private String name, phonenumber , contactID ;
    private Button btn_readcontacts ,btn_cstmcontentprovider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        StoreContacts = new ArrayList<Contacts>();
        this.setListenrs();
    }

    @Override
    public void reference() {
        list_contacts            = (ListView) findViewById(R.id.list_contacts);
        btn_readcontacts         = (Button)   findViewById(R.id.btn_readcontacts);
       // btn_cstmcontentprovider  = (Button)   findViewById(R.id.btn_cstmcontentprovider);
    }

    @Override
    public void setListenrs() {
        btn_readcontacts.setOnClickListener(this);
       // btn_cstmcontentprovider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_readcontacts :
                GetContactsIntoArrayList();
                arrayAdapter = new ContactAdapter(MainActivity.this , StoreContacts);
                list_contacts.setAdapter(arrayAdapter);
                break;

        }
    }
    public void GetContactsIntoArrayList(){

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);
        if(cursor.getCount() >0) {
            while (cursor.moveToNext()) {
                Contacts contacts = new Contacts() ;
                contactID =cursor
                        .getString(cursor
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                contacts.setName(name);
                phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contacts.setphonenumber(phonenumber);
                contacts.setContactphoto(loadContactPhoto(getContentResolver(), Long.valueOf(contactID)));
                StoreContacts.add(contacts);
            }}
        cursor.close();
    }

    public static Bitmap loadContactPhoto(ContentResolver cr, long id) {
        Uri uri = ContentUris.withAppendedId(
                ContactsContract.Contacts.CONTENT_URI, id);
        InputStream input = ContactsContract.Contacts
                .openContactPhotoInputStream(cr, uri);
        if (input == null) {
            return null;

        }
        return BitmapFactory.decodeStream(input);
    }
}
