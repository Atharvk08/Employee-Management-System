package com.example.springclient.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.springclient.R;


public class EmployeeHolder extends RecyclerView.ViewHolder {

    TextView name,location,branch;

    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.employeelistitem_name);
        location=itemView.findViewById(R.id.employeelistitem_location);
        branch=itemView.findViewById(R.id.employeelistitem_branch);
    }
}
