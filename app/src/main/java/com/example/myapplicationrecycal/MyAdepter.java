package com.example.myapplicationrecycal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;


    public MyAdepter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }


    //  layout ekata adala GUI component link kirima
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView1, textView2;
        public LinearLayout linearlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.TextView1);
            textView2 = (TextView) itemView.findViewById(R.id.TextView2);
            linearlayout = (LinearLayout) itemView.findViewById(R.id.linearlayout);

        }
    }


    //its call another view holder is create
    @NonNull
    @Override
    public MyAdepter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // list item eka add kala
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);

        return new ViewHolder(v);
    }
//  this call after call above method  / bind data to view object   // meke hama item ekakatama ekaparak call wenawa
    @Override
    public void onBindViewHolder(@NonNull MyAdepter.ViewHolder holder, int position) {
        // methanin position eka aran textView ealata set karanawa
        ListItem listItem = listItems.get(position);

        holder.textView1.setText(listItem.getText1());
        holder.textView2.setText(listItem.getText2());

        holder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"You click"+listItem.getText2(), Toast.LENGTH_SHORT).show();


            }
        });

    }
// RecyclerView eke items kiyak thiyanawada kiyana eka
    @Override
    public int getItemCount() {
        return listItems.size();
    }


}
