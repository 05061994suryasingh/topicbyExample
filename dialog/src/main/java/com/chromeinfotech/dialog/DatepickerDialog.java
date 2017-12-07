package com.chromeinfotech.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;

/**
 * DatepickerDialog extends DialogFragment to set the date from datepicker to textview
 */

public class DatepickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private Context context ;

    /**
     * constructor
     * @param context
     */
    public DatepickerDialog(Context context) {
        this.context= context;
    }

    /**
     *Override  onCreateDialog to create DatePickerDialog instance and pass context ,year , month and day day
     * @param savedInstanceState
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datepickerdialog = new DatePickerDialog(context,this,year,month,day);
//        calendar.add(Calendar.YEAR, 3);
        calendar.add(Calendar.YEAR, +1);
        // Set the Calendar new date as maximum date of date picker
        datepickerdialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());

        // Subtract 6 days from Calendar updated date
        calendar.add(Calendar.YEAR, -6);

        // Set the Calendar new date as minimum date of date picker
        datepickerdialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

        // So, now date picker selectable date range is 7 days only

        return datepickerdialog;
    }

    /**
     * set the day month  year to textview
     * @param view
     * @param year
     * @param month
     * @param dayOfMonth
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        int y = Calendar.getInstance().get(Calendar.YEAR);
        TextView textview = (TextView)getActivity().findViewById(R.id.textView1);
//        if(year >=2010 && year<=2020){
//            textview.setText(dayOfMonth + ":" + (month+1) + ":" + year);
//        }else {
//            textview.setText("select age betwen 2010-2020");
//            Utils.showToast(getActivity(),"plz select year between 2010-2020");
//        }
        Calendar calendar = Calendar.getInstance() ;
        calendar.setTimeInMillis(0);
        calendar.set(year , month , dayOfMonth , 0 , 0 , 0 );
        Date date = calendar.getTime();
        DateFormat dateFormat =  DateFormat.getDateInstance() ;
        String dateformate = dateFormat.format(date) ;
        textview.setText(dateformate);
    }



}


