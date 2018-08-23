package com.application.limitless.sourav.showcaseprojects.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.application.limitless.sourav.showcaseprojects.R;
import com.application.limitless.sourav.showcaseprojects.modle.dto.CLListItem;
import com.application.limitless.sourav.showcaseprojects.ui.adapter.ShawcaseAdapter;
import com.application.limitless.sourav.showcaseprojects.ui.base.component.RecyclerDividerItemDecoration;

import java.util.ArrayList;

public class ScrollingActivity extends SBaseActivity {

    private ArrayList<CLListItem> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpdata();
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView clRecyclerView=findViewById(R.id.rv_showcase_list);
        clRecyclerView.setPadding(5, 0, 0, 0);
        clRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        clRecyclerView.setAdapter(new ShawcaseAdapter(ScrollingActivity.this,customerList));
        clRecyclerView.addItemDecoration(new RecyclerDividerItemDecoration(this,RecyclerDividerItemDecoration.VERTICAL_LIST, getResources().getColor(R.color.gray_medium)));
        clRecyclerView.setHasFixedSize(true);


    }

    private void setUpdata() {

        customerList = new ArrayList<CLListItem>();
        for (int i = 1; i <= 25; i++) {
            CLListItem clListDTO = new CLListItem("Show Case "+i);
            customerList.add(clListDTO);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
