package com.wbja.stone.ydt.adapter;

import java.util.List;

import com.wbja.stone.ydt.R;
import com.wbja.stone.ydt.entity.ClassicCase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClassicCaseAdapter extends BaseAdapter{
	
	private Context context;
	private List<ClassicCase> list;
	public ClassicCaseAdapter(Context context,List<ClassicCase> list){
		this.context=context;
		this.list=list;
	}

	
	public void updateListView(List<ClassicCase> list){
		this.list = list;
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
	final static class ViewHolder {
		TextView txtContent;
		TextView txtType;
		TextView txtTime;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		ClassicCase cas=list.get(position);
		if (view == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(context).inflate(R.layout.item_schedule, null);
			viewHolder.txtContent = (TextView) view.findViewById(R.id.txtContent);
			viewHolder.txtType = (TextView) view.findViewById(R.id.txtType);
			viewHolder.txtTime = (TextView) view.findViewById(R.id.txtTime);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.txtContent.setText(cas.getCh_title());
		viewHolder.txtType.setVisibility(View.GONE);
		viewHolder.txtTime.setVisibility(View.GONE);
//		if(cas.getCh_title().length()>16){
//			viewHolder.txtContent.setText(cas.getCh_title().subSequence(0, 15)+"...");
//		}else{
//			viewHolder.txtContent.setText(cas.getCh_title());
//		}
//		viewHolder.txtType.setText(cas.getFi_name());
//		viewHolder.txtTime.setText(""+cas.getCh_ID());
		return view;
	}

}