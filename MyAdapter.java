package com.example.myapplicationsfd;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = this.listItems.get(position);
        holder.desc.setText(listItem.getDesc());
        holder.likeImageView.setTag(Integer.valueOf((int) R.drawable.ic_action_copy));
    }


    @Override
    public int getItemCount() {
        return this.listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView desc;
        public ImageView likeImageView;
        public ImageView shareImg;

        public ViewHolder(View itemView) {
            super(itemView);
            this.desc = (TextView) itemView.findViewById(R.id.statusTextView);
            this.shareImg = (ImageView) itemView.findViewById(R.id.shareImageView);
            this.likeImageView = (ImageView) itemView.findViewById(R.id.likeImageView);
            this.likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String position = ViewHolder.this.desc.getText().toString();
                    ClipboardManager myClickboard = (ClipboardManager) MyAdapter.this.context.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData myClip = ClipData.newPlainText("text", position);
                    myClickboard.setPrimaryClip(myClip);
                    Toast.makeText(v.getContext(), "কপি করা হয়েছে", Toast.LENGTH_LONG).show();
                }
            });
            this.shareImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String position = ViewHolder.this.desc.getText().toString();
                    Intent share = new Intent("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT", position);
                    v.getContext().startActivity(Intent.createChooser(share, "শেয়ার করুন"));
                }
            });
        }
    }

}
