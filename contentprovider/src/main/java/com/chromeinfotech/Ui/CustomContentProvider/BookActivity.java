package com.chromeinfotech.Ui.CustomContentProvider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.contentprovider.R;
import com.chromeinfotech.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BookActivity  extends BaseActivity implements View.OnClickListener {

    private Button btnAdd , btnDelete , btnupdate ;
    private EditText edtTxtTitle, edtISBN;
    private Button btnRetrieve;

    private List<Bookinfo> bookInfoList = new ArrayList<>();

    ListView listView;
    private BookAdapter bookItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        reference();
        setListenrs();
        setAdaptor();
    }

    /*Method is used to set the adaptor */
    private void setAdaptor() {
        bookItemAdapter = new BookAdapter(this, bookInfoList);
        listView.setAdapter(bookItemAdapter);
    }


    @Override
    public void reference() {
        btnAdd       = (Button)   findViewById(R.id.btnAdd);
        btnRetrieve  = (Button)   findViewById(R.id.btn_Retrieve);
        btnDelete       = (Button)   findViewById(R.id.btnDelete);
        btnupdate  = (Button)   findViewById(R.id.btnupdate);
        listView     = (ListView) findViewById(R.id.listView);
        edtTxtTitle  = (EditText) findViewById(R.id.et_Title);
         edtISBN      = (EditText) findViewById(R.id.et_Isbn);
    }

    @Override
    public void init() {

    }

    @Override
    public void setListenrs() {
        btnAdd.setOnClickListener(this);
        btnRetrieve.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnupdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                addBooks();
                break;
            case R.id.btn_Retrieve:
                retrieveBooks();
                bookItemAdapter.notifyDataSetChanged();
                break;
            case R.id.btnDelete:
                deleteBook();
                break;
            case R.id.btnupdate:
                updateBook();
                bookItemAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    private void updateBook() {
        ContentValues values = new ContentValues();
        values.put(BookProvider.ISBN, (
                 edtISBN.getText().toString()));
        String selectionClause = BookProvider.TITLE + " LIKE ?";
        String[] selectionArgs = {edtTxtTitle.getText().toString() };

        int rowsUpdated = getContentResolver().update(
             BookProvider.CONTENT_URI,
                values,
                selectionClause,
                selectionArgs
        );
    }

    private void deleteBook() {
        String selectionClause = BookProvider.TITLE + " LIKE ?";
        String[] selectionArgs = {edtTxtTitle.getText().toString()};

        int rowsDeleted = getContentResolver().delete(
                BookProvider.CONTENT_URI,
                selectionClause,
                selectionArgs
        );
        Utils.showToast(this ,"effected row ="+rowsDeleted);
    }

    /*Method is used to retrieve the books info*/
    private void retrieveBooks() {
        //---retrieve the titles---
        Uri allTitles = Uri.parse(
                "content://com.contantprovider.Books/books");
        Cursor c = getContentResolver().query(allTitles, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                String title = c.getString(c.getColumnIndex(
                        BookProvider.TITLE));

                String isbn = c.getString(c.getColumnIndex(
                        BookProvider.ISBN));

                Toast.makeText(getBaseContext(), "ContentProviders " +
                        c.getString(c.getColumnIndex(
                                BookProvider.ID)) + ", " +
                        title + ", " +
                        isbn + "", Toast.LENGTH_LONG).show();

                bookInfoList.add(new Bookinfo(title, isbn));
            } while (c.moveToNext());
        }

    }

    /*Method is used to add the books*/
    private void addBooks() {
        ContentValues values = new ContentValues();

        values.put(BookProvider.TITLE, (edtTxtTitle.getText().toString()));

        values.put(BookProvider.ISBN, (
                 edtISBN.getText().toString()));

        Uri uri = getContentResolver().insert(
                BookProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), uri.toString(),
                Toast.LENGTH_LONG).show();
    }
}
