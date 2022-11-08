package com.example.springclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.springclient.R;
import com.example.springclient.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

    private List<Employee>employeeList;
    public EmployeeAdapter(List<Employee> el){
        employeeList=el;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_employee_item,parent,false);

        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        Employee emp=employeeList.get(position);
        holder.name.setText(emp.getName());
        holder.location.setText(emp.getLocation());
        holder.branch.setText(emp.getBranch());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
