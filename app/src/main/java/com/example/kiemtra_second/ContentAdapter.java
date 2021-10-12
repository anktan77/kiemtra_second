package com.example.kiemtra_second;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.libs.RetrofitClient;
import com.example.libs.models.Content;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Content.Data> dataList;

    public ContentAdapter(Context context, int layout, List<Content.Data> dataList) {
        this.context = context;
        this.layout = layout;
        this.dataList = dataList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public List<Content.Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Content.Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgPic;
        TextView txtTitle,txtContent,txtGroupName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView==null){
            //lấy phần context nào
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder = new ViewHolder();
            //ánh xạ view
            holder.txtTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
            holder.txtContent = (TextView) convertView.findViewById(R.id.textViewContent);
            holder.txtGroupName = (TextView) convertView.findViewById(R.id.textViewGroupName);
            holder.imgPic = (ImageView) convertView.findViewById(R.id.imagePic);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Content.Data content = dataList.get(position);
        holder.txtTitle.setText(content.getTitle());
        holder.txtContent.setText(content.getContent());
        holder.txtGroupName.setText(content.getGroupName());
        Picasso.with(getContext()).load(content.getImageUrl()).into(holder.imgPic);
        return convertView;
    }
}
