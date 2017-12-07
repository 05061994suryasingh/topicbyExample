package com.chromeinfotech.Ui.JsonparsingwithListview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.jsonparsing.R;
import com.chromeinfotech.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonparcerActivityListview extends BaseActivity {

    private TextView txtjsondata, txtjsondata1 ;
    private String jsondata ="" ,advertismentdata="";
    private JSONArray jsonarray ,jsonarray1 ;
    ArrayList<String> listdata = new ArrayList<>() ;
    private  JSONObject object ;
    private ListView listvirew ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonparcer);
        this.reference();
        this.jsonparcer();
        this.setListenrs();
    }

    private void jsonparcer() {
        JSONObject datajsonobject = null;
        try {
            datajsonobject = new JSONObject(loadJSONFromAsset());
            object = datajsonobject.getJSONObject("data");
            jsonarray = object.getJSONArray("beaconInfo") ;
            setbininfo();
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // txtjsondata.setText(jsondata);

    }

    private void setbininfo() throws JSONException {

        for(int i= 0 ;i<jsonarray.length();i++){
            Utils.printLog(String.valueOf(this),"inside jsonparcer for loop");

            JSONObject jb =(JSONObject) jsonarray.get(i);
//
//            jsondata += "\n\n"+"node " + (i+1) + "\n";
//            jsondata += jb.getInt("beaconID")+"\n";
//            jsondata += jb.getString("beaconName")+"\n";
//            jsondata += jb.getString("beaconUUID")+"\n";
//            jsondata += jb.getString("beaconVendor")+"\n";
//            jsondata += jb.getInt("major")+"\n";
//            jsondata += jb.getInt("minor")+"\n";
//            jsondata += jb.getString("status")+"\n";
//            jsondata += jb.getInt("latitude")+"\n";
//            jsondata += jb.getInt("longitude")+"\n\n";

            listdata.add( "\n\n"+"node " + (i+1) + "\n");
            listdata.add(jb.getInt("beaconID")+"\n");
            listdata.add( jb.getString("beaconName")+"\n");
            listdata.add(jb.getString("beaconUUID")+"\n");
            listdata.add(jb.getString("beaconVendor")+"\n");
            listdata.add( jb.getInt("major")+"\n");
            listdata.add( jb.getInt("minor")+"\n");
            listdata.add( jb.getString("status")+"\n");
            listdata.add( jb.getInt("latitude")+"\n");
            listdata.add(jb.getInt("longitude")+"\n\n");


            JSONArray  jsonarray1 = jb.getJSONArray("advertisements") ;
            for(int j= 0 ; j < jsonarray1.length() ; j++) {
                Utils.printLog(String.valueOf(this), "inside second for loop") ;

                JSONObject advertisements =(JSONObject) jsonarray1.get(j) ;

//                jsondata += advertisements.getInt("adID") + "\n" ;
//                jsondata += advertisements.getString("adName") + "\n" ;
//                jsondata += advertisements.getString("enabled") + "\n" ;
//                jsondata += advertisements.getInt("shopID") + "\n" ;
//                jsondata += advertisements.getString("shopName") + "\n" ;
//                jsondata += advertisements.getString("description") + "\n" ;
//                jsondata += advertisements.getString("validUpTo") + "\n" ;
                listdata.add( advertisements.getInt("adID") + "\n" );
                listdata.add(advertisements.getString("adName") + "\n");
                listdata.add( advertisements.getString("enabled") + "\n") ;
                listdata.add(advertisements.getInt("shopID") + "\n" );
                listdata.add( advertisements.getString("shopName") + "\n") ;
                listdata.add(advertisements.getString("description") + "\n" );
                listdata.add( advertisements.getString("validUpTo") + "\n" );
            }
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("offielist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    @Override
    public void reference() {
        txtjsondata  = (TextView) findViewById(R.id.txtjsondata) ;
        txtjsondata1 = (TextView) findViewById(R.id.txtjsondata1) ;
        listvirew = (ListView) findViewById(R.id.listvirew ) ;
    }

    @Override
    public void setListenrs() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this ,R.layout.activity_may_xml_parser , R.id.textView1 , listdata);
        listvirew.setAdapter(arrayAdapter);
    }
}
