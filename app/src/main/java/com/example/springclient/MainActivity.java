package com.example.springclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.springclient.model.Employee;
import com.example.springclient.retrofit.EmployeeApi;
import com.example.springclient.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intializeComponents();

    }

    private void intializeComponents() {
        TextInputEditText inputEditText=findViewById(R.id.form_textfieldname);
        TextInputEditText inputEditBranch=findViewById(R.id.form_textfieldbranch);
        TextInputEditText inputEditLocation=findViewById(R.id.form_textfieldlocation);

        MaterialButton buttonSave=findViewById(R.id.savebutton);
        RetrofitService retrofitService=new RetrofitService();
        EmployeeApi employeeApi=retrofitService.getRetrofit().create(EmployeeApi.class);


        buttonSave.setOnClickListener(view-> {
            String name=String.valueOf(inputEditText.getText());
            String branch=String.valueOf(inputEditBranch.getText());
            String location=String.valueOf(inputEditLocation.getText());

            Employee e=new Employee();
            e.setBranch(branch);
            e.setName(name);
            e.setLocation(location);

            employeeApi.save(e)
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Toast.makeText(MainActivity.this, "Save Success", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Save Failed!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,"Error occurred");
                        }
                    });
        });
    }
}