package com.kamus.android.app;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class KamusBaseAdapter extends BaseAdapter {
	private static ArrayList<EntitasKamus> searchArrayList;
	private LayoutInflater mInflater;
	Bitmap bm;
	
	public KamusBaseAdapter(Context context, ArrayList<EntitasKamus> results){
		searchArrayList = results;
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return searchArrayList.size();
	}

	@Override
	public Object getItem(int p) {
		// TODO Auto-generated method stub
		return searchArrayList.get(p);
	}

	@Override
	public long getItemId(int p) {
		// TODO Auto-generated method stub
		return p;
	}

	@Override
	public View getView(int p, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		
		if(v==null){
			v = mInflater.inflate(R.layout.item_custom_listview, null);
			holder = new ViewHolder();
			holder.indo = (TextView)v.findViewById(R.id.outindo);
			holder.jawa = (TextView)v.findViewById(R.id.outjawa);
			v.setTag(holder);
		}else{
			holder = (ViewHolder) v.getTag();
		}
		
		holder.indo.setText(searchArrayList.get(p).getIndo());
		holder.jawa.setText(searchArrayList.get(p).getJawa());
		return v;
	}
	
	static class ViewHolder{
		TextView indo, jawa;
	}
}
