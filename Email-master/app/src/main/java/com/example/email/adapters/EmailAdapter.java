package com.example.email.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.email.R;
import com.example.email.models.Email;

import java.util.List;

public class EmailAdapter extends BaseAdapter {

    Context context;
    List<Email> emails;

    public EmailAdapter(Context context, List<Email> emails) {
        this.context = context;
        this.emails = emails;
    }

    @Override
    public int getCount() {
        return emails.size();
    }

    @Override
    public Object getItem(int position) {
        return emails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.email_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.text_view = convertView.findViewById(R.id.text_view);
            viewHolder.text_sender = convertView.findViewById(R.id.text_sender);
            viewHolder.text_title = convertView.findViewById(R.id.text_title);
            viewHolder.text_content = convertView.findViewById(R.id.text_content);
            viewHolder.text_time = convertView.findViewById(R.id.text_time);
            viewHolder.text_bacham = convertView.findViewById(R.id.text_bacham);
            viewHolder.star = convertView.findViewById(R.id.star);

            convertView.setTag(viewHolder);
        } else viewHolder = (ViewHolder) convertView.getTag();

        Email email = emails.get(position);
        switch (email.getColor()){
            case 0:
                viewHolder.text_view.setBackground(context.getResources().getDrawable(R.drawable.oval_background));
                break;
            case 1:
                viewHolder.text_view.setBackground(context.getResources().getDrawable(R.drawable.oval_background1));
                break;
            case 2:
                viewHolder.text_view.setBackground(context.getResources().getDrawable(R.drawable.oval_background2));
                break;
            case 3:
                viewHolder.text_view.setBackground(context.getResources().getDrawable(R.drawable.oval_background3));
                break;
        }
        viewHolder.text_view.setText(email.getFirstChar());
        viewHolder.text_sender.setText(email.getSender());
        viewHolder.text_title.setText(email.getTitle());
        viewHolder.text_content.setText(email.getContent());
        viewHolder.text_bacham.setText("...");
        viewHolder.text_time.setText(email.getTime());
        return convertView;
    }
    private class ViewHolder {
        TextView text_view, text_sender, text_title, text_content, text_time, text_bacham;
        ImageButton star;
    }
}
