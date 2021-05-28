package com.example.asynctasktest;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class CovidTask extends AsyncTask<String,Void,String>{

    Context ct;

    List<DayWiseCovidCases> covidCasesList;
    RecyclerView myrv;

    ProgressDialog pd;


    public CovidTask(MainActivity mainActivity, RecyclerView rv) {
        ct = mainActivity;
        myrv = rv;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(ct);
        pd.setMessage("Please wait");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL u = new URL("https://api.covid19api.com/dayone/country/IN");
            HttpsURLConnection connection = (HttpsURLConnection) u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line ="";
            StringBuilder builder = new StringBuilder();
            while ((line=reader.readLine())!=null){
              builder.append(line);
            }
            return builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(ct,s, Toast.LENGTH_SHORT).show();
        covidCasesList = new ArrayList<>();
      //  Log.i("Sailakshmi",s);
        try {

            JSONArray jsonArray = new JSONArray(s);
            for(int i = 0; i<jsonArray.length();i++){
                JSONObject indexobject = jsonArray.getJSONObject(i);
                String date = indexobject.getString("Date");
                String confirmedcases = indexobject.getString("Confirmed");
                String activecases = indexobject.getString("Active");
                String recoverd = indexobject.getString("Recovered");
                String deaths = indexobject.getString("Deaths");
                Log.i("Lakshmi", date +" "+confirmedcases+" "+activecases+" "+recoverd+" "+deaths+"\n");
                DayWiseCovidCases dwc = new DayWiseCovidCases(date,confirmedcases,activecases,recoverd,deaths);
                covidCasesList.add(dwc);

            }
            Collections.reverse(covidCasesList);
           myrv.setLayoutManager(new LinearLayoutManager(ct));
            CovidAdapter adapter = new CovidAdapter(ct,covidCasesList);
            myrv.setAdapter(adapter);
            pd.dismiss();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}