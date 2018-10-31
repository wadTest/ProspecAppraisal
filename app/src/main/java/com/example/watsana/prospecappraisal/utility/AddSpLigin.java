package com.example.watsana.prospecappraisal.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AddSpLigin extends AsyncTask<String, Void, String>{

    private Context context;

    public AddSpLigin(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            MyConstant myConstant = new MyConstant();
            String[] columnString1 = myConstant.getLogin_sp_mainString();


            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add(columnString1[0], strings[0])
                    .add(columnString1[1], strings[1])
                    .add(columnString1[2], strings[2])
                    .add(columnString1[3], strings[3])
                    .add(columnString1[4], strings[4])
                    .add(columnString1[5], strings[5])
                    .add(columnString1[6], strings[6])
                    .add(columnString1[7], strings[7])
                    .add(columnString1[8], strings[8])
                    .add(columnString1[9], strings[9])
                    .add(columnString1[10], strings[10])
                    .add(columnString1[11], strings[11])
                    .add(columnString1[12], strings[12])
                    .add(columnString1[13], strings[13])
                    .add(columnString1[14], strings[14])
                    .add(columnString1[15], strings[15])
                    .add(columnString1[16], strings[16])
                    .add(columnString1[17], strings[17])
                    .add(columnString1[18], strings[18])
                    .add(columnString1[19], strings[19])
                    .add(columnString1[20], strings[20])
                    .add(columnString1[21], strings[21])
                    .add(columnString1[22], strings[22])
                    .add(columnString1[23], strings[23])
                    .add(columnString1[24], strings[24])
                    .add(columnString1[25], strings[25])
                    .add(columnString1[26], strings[26])
                    .add(columnString1[27], strings[27])
                    .add(columnString1[28], strings[28])
                    .add(columnString1[29], strings[29])
                    .add(columnString1[30], strings[30])
                    .add(columnString1[31], strings[31])
                    .add(columnString1[32], strings[32])
                    .add(columnString1[33], strings[33])
                    .add(columnString1[34], strings[34])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[35]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return  response.body().string();



        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
