package com.codeskraps.ocras;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListAdapter extends BaseAdapter implements OnClickListener {
	private static final String TAG = CustomListAdapter.class.getSimpleName();

	private Context context;
	private LayoutInflater mInflater = null;
	private List<ListItem> mItems = new ArrayList<ListItem>(); 	// Our List of Items from ListItem.java

	public CustomListAdapter(Context context) {
		Log.d(TAG, "Constructor");
		this.context = context;
		mInflater = LayoutInflater.from(context);
	}

	public void addItem(ListItem it) {
		mItems.add(it);											// Adding Items to the list
	}
	
	public List<ListItem> getList() {
		return mItems;
	}

	public void setListItems(List<ListItem> lit) {				// Adding Items by passing a whole new List
		mItems = lit;
	}

	public int getCount() {
		return mItems.size();
	}

	public Object getItem(int position) {
		return mItems.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	/*
	 * This gets called every time ListView needs a new Row Item
	 * position holds the position on the row in the ListView
	 * convertView is the new view we have to filled with our custom --> list_item.xml
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vHolder = null;

		if (convertView != null)
			vHolder = (ViewHolder) convertView.getTag();								// convertView is been recycled
		else {
			convertView = (View) mInflater.inflate(R.layout.list_item, null);			// Set content of new View with list_item.xml

			vHolder = new ViewHolder();
			vHolder.textView = ((TextView) convertView.findViewById(R.id.lstText));
			vHolder.textView.setOnClickListener(this);
			
			convertView.setTag(vHolder);
		}

		vHolder.textView.setId(position);												// Do not delete !!!
		
		vHolder.textView.setText(mItems.get(position).getText());
		
		return convertView;
	}
	
	public static class ViewHolder {
		TextView textView;
	}

	@Override
	public void onClick(View arg0) {
		ListItem item = mItems.get(arg0.getId());
		Toast.makeText(context, "id: " + item.getText(), Toast.LENGTH_SHORT).show();
	}
}