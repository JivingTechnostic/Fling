package com.pennapps.vnd.ffling;

import java.io.File;
import java.util.ArrayList;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxFileInfo;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxUnlinkedException;

import com.google.android.maps.MapView;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class MailboxActivity extends ListActivity{
	ArrayList<Message> inbox;
	ListView listView;
	public DropboxAPI<AndroidAuthSession> mDBApi;
	private Entry secretList;
	@Override
	
    public void onCreate(Bundle savedInstanceState) {
		TextView selected;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mailbox);        
        inbox = new ArrayList<Message>();
        
        File directory = new File("/mnt/sdcard/Android/data/com.pennapps.vnd.ffling/");
        String[] children = directory.list();
        for (int i = 0; i < children.length; i = i + 1) {
        	ArrayList<Message> Temp = (MyFileReader.getWholeFile("/mnt/sdcard/Android/data/com.pennapps.vnd.ffling/" + children[i]));
        	inbox.add(Temp.get(0));
        }
        
        setListAdapter(new ArrayAdapter<Message>(this, android.R.layout.simple_expandable_list_item_1, inbox));
        selected = (TextView)findViewById(R.id.textViewMail);
	}
	
	@Override
	public void onListItemClick(ListView l, View view, int position, long id){
		view.getId();
		
		
		
		Intent myIntent = new Intent(view.getContext(), SomethingGoodActivity.class);
		myIntent.putExtra("file", "/mnt/sdcard/Android/data/com.pennapps.vnd.ffling/" + inbox.get(position-1).getLatitude() + "~" + inbox.get(position-1).getLongitude() +".txt");
		
		startActivityForResult(myIntent, 0);
	}
	
	public void goToMenu(View view){
    	Intent intent = new Intent();
    	setResult(RESULT_OK, intent);
    	finish();
    }
	public void goTo(View view){
		Intent myIntent = new Intent();
	}


	public void goToReader(View view){

	}
}
