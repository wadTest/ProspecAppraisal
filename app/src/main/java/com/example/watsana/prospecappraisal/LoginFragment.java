package com.example.watsana.prospecappraisal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.watsana.prospec.FormLandActivity;
import com.example.watsana.prospec.utility.AddSpMain;
import com.example.watsana.prospec.utility.MyAlert;
import com.example.watsana.prospec.utility.MyConstant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferListener;

public class LoginFragment extends Fragment {

    //    Explicit
    private boolean spinnerABoolean = true; // true ==> โปรดเลือกประเภท
    private String typeDocString;
    private String[] strings;
    private Uri uri;
    private FTPClient ftpClient;
    private int anInt = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Crete Toolbar
        creteToolbar();

//        Create Spinner
        createSpinner();

//        Check Tab1
        checkTab1();


    }//Main Method

    private void checkTab1() {
        try {

            SharedPreferences sharedPreferences = getActivity()
                    .getSharedPreferences("landDoc", Context.MODE_PRIVATE);
            boolean tab1Bool = sharedPreferences.getBoolean("Tab1", false);

            Log.d("20octV1", "current tab1Bool ==> " + tab1Bool);

            if (tab1Bool) {

                ImageView imageView = getView().findViewById(R.id.imvProcess);
                imageView.setImageResource(R.drawable.first);

//                Just Recoded
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setIcon(R.drawable.ic_action_alert);
                builder.setTitle("Confirm");
                builder.setMessage("Have Record You want to Edit ?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        getActivity().finish();
                    }
                });
                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class uploadListener implements FTPDataTransferListener {


        @Override
        public void started() {
            Toast.makeText(getActivity(), "Start Upload", Toast.LENGTH_SHORT)
                    .show();
        }

        @Override
        public void transferred(int i) {
            Toast.makeText(getActivity(), "Continue Upload", Toast.LENGTH_SHORT)
                    .show();
        }

        @Override
        public void completed() {
            Toast.makeText(getActivity(), "Success Upload", Toast.LENGTH_SHORT)
                    .show();
            getActivity().finish();
        }

        @Override
        public void aborted() {

        }

        @Override
        public void failed() {
            Toast.makeText(getActivity(), "False Upload", Toast.LENGTH_SHORT)
                    .show();

        }
    }   // uploadListener Class




    private void createSpinner() {
        final Spinner spinner = getView().findViewById(R.id.spinner_type_doc);
        MyConstant myConstant = new MyConstant();
        strings = myConstant.getTypeDocStrings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);

        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

                if (i == 0) {
                    spinnerABoolean = true;
                } else {
                    spinnerABoolean = false;
                }

                typeDocString = Integer.toString(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemUpload) {

            checDataAndUpload();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void checDataAndUpload() {

//        Initial View
        EditText editText1 = getView().findViewById(R.id.EditText1);
        EditText editText2 = getView().findViewById(R.id.EditText2);
        EditText editText3 = getView().findViewById(R.id.EditText3);
        EditText editText4 = getView().findViewById(R.id.EditText4);
        EditText editText5 = getView().findViewById(R.id.EditText5);
        EditText editText6 = getView().findViewById(R.id.EditText6);
        EditText editText7 = getView().findViewById(R.id.EditText7);
        EditText editText8 = getView().findViewById(R.id.EditText8);
        EditText editText9 = getView().findViewById(R.id.EditText9);
        EditText editText10 = getView().findViewById(R.id.EditText10);
        EditText editText11 = getView().findViewById(R.id.EditText11);


        final String string1 = editText1.getText().toString().trim();
        final String string2 = editText2.getText().toString().trim();
        final String string3 = editText3.getText().toString().trim();
        final String string4 = editText4.getText().toString().trim();
        final String string5 = editText5.getText().toString().trim();
        final String string6 = editText6.getText().toString().trim();
        final String string7 = editText7.getText().toString().trim();
        final String string8 = editText8.getText().toString().trim();
        final String string9 = editText9.getText().toString().trim();
        final String string10 = editText10.getText().toString().trim();
        final String string11 = editText11.getText().toString().trim();


        String[] strings = new String[]{string1, string2, string3, string4,
                string5, string6, string7, string8, string9, string10, string11};

        for (int i = 0; i < strings.length; i +=1) {
            if (strings[i].isEmpty()){
                anInt += 1;
            }
        }

        Log.d("19octV2", "anInt ==>" + anInt);


//        Old code

//        if (string1.isEmpty() || string2.isEmpty() || string3.isEmpty() || string4.isEmpty() ||
//                string5.isEmpty() || string6.isEmpty() || string7.isEmpty() || string8.isEmpty() ||
//                string9.isEmpty() || string10.isEmpty() || string11.isEmpty()) {

        if (false) {

//            Have Space
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.normalDialog(getString(R.string.title_have_space),
                    getString(R.string.massage_have_space));

        } else if (spinnerABoolean) {
//            position ==> 0
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.normalDialog(getString(R.string.title_type_doc1), getString(R.string.message_type_doc1));

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setCancelable(false);
            builder.setIcon(R.drawable.ic_action_alert);
            builder.setTitle(R.string.title_comfirm);
            builder.setMessage(getString(R.string.num_titledeed) + "=" + string1 + "\n" +
                    getString(R.string.number5) + "=" + string2 + "\n" +
                    getString(R.string.type_doc_title) + "=" + strings[Integer.parseInt(typeDocString)] + "\n" +
                    getString(R.string.number) + "=" + string3 + "\n" +
                    getString(R.string.number1) + "=" + string4 + "\n" +
                    getString(R.string.index_doc) + "=" + string5 + "\n" +
                    getString(R.string.rawang) + "=" + string7 + "\n" +
                    getString(R.string.number2) + "=" + string8 + "\n" +
                    getString(R.string.number3) + "=" + string9 + "\n" +
                    getString(R.string.number4) + "=" + string10 + "\n" +
                    getString(R.string.area) + "=" + string11);
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    try {

                        MyConstant myConstant = new MyConstant();
                        AddSpMain addSpMain = new AddSpMain(getActivity());
                        addSpMain.execute(string1, string2, string3, string4,
                                string5, string6, string7, string8, string9
                                , string10, string11, typeDocString,
                                myConstant.getUrlAddsp_mainString());

                        String resultString = addSpMain.get();
                        Log.d("19octV1", "result ==> " + resultString);

                        if (Boolean.parseBoolean(resultString)) {

                            uploadFileXls(string1, string2, string3, string4,
                                    string5, string6, string7, string8, string9
                                    , string10, string11, typeDocString);


                        } else {

                            MyAlert myAlert = new MyAlert(getActivity());
                            myAlert.normalDialog("Cannot Upload",
                                    "Please Try again Cannot Upload");
                        }


                    } catch (Exception e) {
                        Log.d("19octV1", "e ==> " + e.toString());
                    }

                    dialog.dismiss();
                }
            });
            builder.show();

        }//if

    }//checkData

    private void uploadFileXls(String string1, String string2, String string3,
                               String string4, String string5, String string6,
                               String string7, String string8, String string9,
                               String string10, String string11, String typeDocString) {

        String nameFileString = "master_" + string1 + ".xls";

        File xlsFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), nameFileString);

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(xlsFile);
            fileOutputStream.write(string1.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string2.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string3.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string4.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string5.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string6.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string7.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string8.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string9.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string10.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(string11.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(typeDocString.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.close();

            Toast.makeText(getActivity(), "Create File Xls Success",
                    Toast.LENGTH_SHORT).show();

            uri = Uri.fromFile(xlsFile);
            String pathString = uri.getPath();
            Log.d("19octV2", "pathString ==> " + pathString);

//            Change Policy
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy
                    .Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ftpClient = new FTPClient();
            MyConstant myConstant = new MyConstant();

            ftpClient.connect(myConstant.getHostString(), myConstant.getPostAnInt());
            ftpClient.login(myConstant.getUserString(), myConstant.getPasswordString());
            ftpClient.setType(FTPClient.TYPE_BINARY);
            ftpClient.changeDirectory("Wad");
            ftpClient.upload(xlsFile, new uploadListener());


//            Record Upload
            SharedPreferences sharedPreferences = getActivity()
                    .getSharedPreferences("landDoc", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Tab1", true);
            editor.commit();



        } catch (FileNotFoundException e) {
            Log.d("19octV2", "e File ==> " + e.toString());
        } catch (IOException e) {
            Log.d("19octV2", "e IO ==> " + e.toString());
        } catch (Exception e) {

            try {

                ftpClient.disconnect(true);

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }


    }   // upload

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


        inflater.inflate(R.menu.menu_land_tab, menu);
    }

    private void creteToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbar_land_tab1);
        ((FormLandActivity) getActivity()).setSupportActionBar(toolbar);
        ((FormLandActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.toolbar_login));
        ((FormLandActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.massage_login));

        ((FormLandActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((FormLandActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        View view = inflater.inflate(R.layout.fragment_form_land, container, false);
        return view;
    }
}//Main Class