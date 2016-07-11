package com.example.mobileappdevelop.customadapterforlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BITM Trainer - 401 on 6/29/2016.
 */
public class ProfileAdapter extends ArrayAdapter<Profile> {
    private Context context;
    private ArrayList<Profile> profiles;

    public ProfileAdapter(Context context, ArrayList<Profile> profiles) {
        super(context, R.layout.list_row, profiles);
        this.context = context;
        this.profiles = profiles;
    }

    private static class ViewHolder {
        TextView profileNameText;
        TextView profilePhoneText;
        TextView profileEmailText;
        ImageView profilePic;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null, true);

            viewHolder.profileNameText = (TextView) convertView.findViewById(R.id.profileNameText);
            viewHolder.profilePhoneText = (TextView) convertView.findViewById(R.id.profilePhoneText);
            viewHolder.profileEmailText = (TextView) convertView.findViewById(R.id.profileEmailText);
            viewHolder.profilePic = (ImageView) convertView.findViewById(R.id.profilePic);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.profileNameText.setText(profiles.get(position).getProfileName());
        viewHolder.profilePhoneText.setText(profiles.get(position).getPhone());
        viewHolder.profileEmailText.setText(profiles.get(position).getEmail());
        viewHolder.profilePic.setImageResource(profiles.get(position).getImageId());
        viewHolder.profileNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, profiles.get(position).getProfileName(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
