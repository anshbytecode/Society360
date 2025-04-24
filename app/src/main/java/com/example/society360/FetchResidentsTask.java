package com.example.society360;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FetchResidentsTask extends AsyncTask<Void, Void, ArrayList<ResidentModel>> {

    private FetchResidentsListener listener;

    public interface FetchResidentsListener {
        void onResidentsFetched(ArrayList<ResidentModel> residents);
    }

    public FetchResidentsTask(FetchResidentsListener listener) {
        this.listener = listener;
    }

    @Override
    protected ArrayList<ResidentModel> doInBackground(Void... voids) {
        ArrayList<ResidentModel> residentsList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://10.0.2.2:3306/society360", "root", "adi@123"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM residents");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String flat = resultSet.getString("flat_no");
                String phoneNumber = resultSet.getString("phone_number"); // Phone number add kiya

                residentsList.add(new ResidentModel( id,name, flat, phoneNumber)); // Three arguments pass kiye
            }

            connection.close();
        } catch (Exception e) {
            Log.e("DB_ERROR", e.getMessage());
        }
        return residentsList;
    }

    @Override
    protected void onPostExecute(ArrayList<ResidentModel> residents) {
        super.onPostExecute(residents);
        if (listener != null) {
            listener.onResidentsFetched(residents);
        }
    }
}