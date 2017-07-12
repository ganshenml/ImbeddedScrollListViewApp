package com.ganshenml.imbeddedscrolllistviewapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ganshenml.imbeddedscrolllistviewapp.R;
import com.ganshenml.imbeddedscrolllistviewapp.entities.CommentEntity;
import com.ganshenml.imbeddedscrolllistviewapp.utils.ListUtils;
import com.ganshenml.imbeddedscrolllistviewapp.utils.StringUtils;

import java.util.List;


public class CommentListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<CommentEntity> mData;

    public CommentListViewAdapter(Context mContext, List<CommentEntity> commentEntities) {
        this.mContext = mContext;
        this.mData = commentEntities;
        inflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_comment_list, null);
            viewHolder.avatarSdv = (SimpleDraweeView) convertView.findViewById(R.id.avatarSdv);
            viewHolder.nickNameTv = (TextView) convertView.findViewById(R.id.nickNameTv);
            viewHolder.contentTv = (TextView) convertView.findViewById(R.id.contentTv);
            viewHolder.commentIDTv = (TextView) convertView.findViewById(R.id.commentIDTv);
            viewHolder.convetDateTv = (TextView) convertView.findViewById(R.id.convetDateTv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        initView(viewHolder, position);

        return convertView;
    }

    private void initView(ViewHolder viewHolder, int position) {
        if (ListUtils.isEmpty(mData) || (position + 1) > mData.size()) {
            return;
        }
        CommentEntity commentEntityTemp = mData.get(position);
        String avatarUrl = commentEntityTemp.getAvatar();
        if (StringUtils.isNotEmpty(avatarUrl)) {
            viewHolder.avatarSdv.setImageURI(Uri.parse(avatarUrl));
        }
        String nickNameStr = commentEntityTemp.getNickName();
        if (StringUtils.isNotEmpty(nickNameStr)) {
            viewHolder.nickNameTv.setText(nickNameStr + "：");
        }

        String contentStr = commentEntityTemp.getContent();
        if (StringUtils.isNotEmpty(contentStr)) {
            viewHolder.contentTv.setText(contentStr);
        }

        viewHolder.commentIDTv.setText((position + 1) + "楼");

        String convertDateStr = commentEntityTemp.getConvetDate();
        if (StringUtils.isNotEmpty(convertDateStr)) {
            viewHolder.convetDateTv.setText(convertDateStr);
        }
    }

}

class ViewHolder {
    SimpleDraweeView avatarSdv;
    TextView nickNameTv;
    TextView contentTv;
    TextView commentIDTv;
    TextView convetDateTv;
}
