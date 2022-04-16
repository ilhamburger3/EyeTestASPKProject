package com.example.eyetestaspkv2;

import static com.example.eyetestaspkv2.EmployeeActivity.EMPLOYEE_ID_KEY;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class EmployeeRecViewAdapter extends RecyclerView.Adapter<EmployeeRecViewAdapter.ViewHolder>{
    private static final String TAG = "EmployeeRecViewAdapter";

    private ArrayList<Employee> employees = new ArrayList<>();
    private Context mContext;


    public EmployeeRecViewAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_employee, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtEmployeeName.setText(employees.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(employees.get(position).getImageUrl())
                .into(holder.imgEmployee);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EmployeeActivity.class);
                intent.putExtra(EMPLOYEE_ID_KEY, employees.get(position).getId());
                mContext.startActivity(intent);
            }
        });


        holder.txtDescription.setText(employees.get(position).getShortDesc());

        if (employees.get(position).getExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }


    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgEmployee;
        private TextView txtEmployeeName;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgEmployee = itemView.findViewById(R.id.imgEmployee);
            txtEmployeeName = itemView.findViewById(R.id.txtEmployeeName);

            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            txtDescription = itemView.findViewById(R.id.txtShortDesc);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Employee employee = employees.get(getAdapterPosition());
                    employee.setExpanded(!employee.getExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Employee employee = employees.get(getAdapterPosition());
                    employee.setExpanded(!employee.getExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
