package com.chromeinfotech.Ui.JsonparsingwithExpandablelistview;

import android.content.Context;
import com.chromeinfotech.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by user on 10/4/17.
 */

public class JSonParcerclass {

    private Context context;
    private BeaconInfo beaconInfo;
    ArrayList<Advertisements> advertisementsArrayList;
    ArrayList<AdSchedules> adSchedulesArrayList;
    ArrayList<ImageList> adImagesArrayList;

    public JSonParcerclass(Context context){
        this.context = context;
    }
    public String loadAssets() {
        String json ;
        try {

            InputStream inputStream     =   context.getAssets().open("offielist.json");
            int size                    =   inputStream.available();
            byte[] buffer               =   new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private Data data = new Data();



    public Data parsedData() {
        try {
            JSONObject jsonObject        =          new JSONObject(loadAssets());
            JSONObject dataObj           =          jsonObject.getJSONObject("data");

            JSONArray beaconInfoArray    =           dataObj.getJSONArray("beaconInfo");
            ArrayList<BeaconInfo> beaconInfoArrayList = new ArrayList<>();

            for (int i = 0; i < beaconInfoArray.length(); i++) {
                JSONObject beaconInfoObject = beaconInfoArray.getJSONObject(i);
                this.addBeaconData(beaconInfoObject);
                this.advertismentData(beaconInfoObject);
                beaconInfo.setItems(advertisementsArrayList);
                beaconInfoArrayList.add(beaconInfo);
                data.setBeaconInfoArrayList(beaconInfoArrayList);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void addBeaconData(JSONObject beaconInfoObject) throws JSONException {

        beaconInfo = new BeaconInfo();
        beaconInfo.setBeaconID(beaconInfoObject.getInt("beaconID"));
        beaconInfo.setBeaconName(beaconInfoObject.getString("beaconName"));
        beaconInfo.setBeaconUUID(beaconInfoObject.getString("beaconUUID"));
        beaconInfo.setBeaconVendor(beaconInfoObject.getString("beaconVendor"));
        beaconInfo.setMajor(beaconInfoObject.getInt("major"));
        beaconInfo.setMinor(beaconInfoObject.getInt("minor"));
        beaconInfo.setStatus(beaconInfoObject.getBoolean("status"));
        beaconInfo.setLatitude(beaconInfoObject.getDouble("latitude"));
        beaconInfo.setLongitude(beaconInfoObject.getDouble("longitude"));
    }

    private void advertismentData(JSONObject beaconInfoObject) throws JSONException {

        advertisementsArrayList = new ArrayList<>();
        JSONArray advertisementsArray = beaconInfoObject.getJSONArray("advertisements");

        for (int j = 0; j < advertisementsArray.length(); j++) {
            JSONObject advertisementsObject = advertisementsArray.getJSONObject(j);
            Advertisements advertisements = new Advertisements();
            advertisements.setAdID(advertisementsObject.getInt("adID"));
            advertisements.setAdName(advertisementsObject.getString("adName"));
            advertisements.setEnabled(advertisementsObject.getBoolean("enabled"));
            advertisements.setShopID(advertisementsObject.getInt("shopID"));
            advertisements.setShopName(advertisementsObject.getString("shopName"));
            advertisements.setDescription(advertisementsObject.getString("description"));
            advertisements.setValidUpTo(advertisementsObject.getString("validUpTo"));

            this.imageData(advertisementsObject);
            advertisements.setImages(adImagesArrayList);

            advertisements.setCreateDate(advertisementsObject.getString("createDate"));
            advertisements.setUpdateDate(advertisementsObject.getString("updateDate"));

            this.scheduleData(advertisementsObject);
            advertisements.setShedules(adSchedulesArrayList);
            advertisementsArrayList.add(advertisements);
        }
    }

    private void scheduleData(JSONObject advertisementsObject) throws JSONException {

        adSchedulesArrayList = new ArrayList<>();
        JSONArray schedulesArray = advertisementsObject.getJSONArray("adSchedules");

        for (int k = 0; k < schedulesArray.length(); k++) {
            JSONObject schedules = schedulesArray.getJSONObject(k);
            AdSchedules adSchedules = new AdSchedules();
            adSchedules.setAdScheduleid(schedules.getInt("adScheduleId"));
            adSchedules.setAdID(schedules.getInt("adId"));
            adSchedules.setStartDate(schedules.getLong("startDate"));
            adSchedules.setEndDate(schedules.getLong("endDate"));
            adSchedulesArrayList.add(adSchedules);
        }



    }

    private void imageData(JSONObject advertisementsObject) throws JSONException {

        adImagesArrayList = new ArrayList<ImageList>();
        JSONArray imagesArray = advertisementsObject.getJSONArray("images");

        for (int k = 0; k < imagesArray.length(); k++) {
            JSONObject imagesObject = imagesArray.getJSONObject(k);
            ImageList adImages = new ImageList();
            adImages.setImageID(imagesObject.getInt("imageID"));
            adImages.setImageName(imagesObject.getString("imageName"));
            adImages.setImageURL(imagesObject.getString("imageURL"));
            adImages.setDescription(imagesObject.getString("description"));
            adImagesArrayList.add(adImages);
        }

    }
}

