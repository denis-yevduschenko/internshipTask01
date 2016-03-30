package ua.internship.yaltask01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Image> mImages;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add mToolbar to the activity
        Toolbar mToolbar = (Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(mToolbar);
        //Show back button
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mRecyclerView =(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        initializeData();
        initializeAdapter();


        TextView textAssignedDate = (TextView) findViewById(R.id.date_ass);
        TextView textAssigned = (TextView) findViewById(R.id.text_ass);
        TextView textCreateDate = (TextView) findViewById(R.id.date_create);
        TextView textCreate = (TextView) findViewById(R.id.text_create);
        TextView textRegisterDate = (TextView) findViewById(R.id.date_reg);
        TextView textRegister = (TextView) findViewById(R.id.text_reg);
        TextView textDescription = (TextView) findViewById(R.id.description);
        TextView textStatus = (TextView) findViewById(R.id.status);
        TextView textResponsible = (TextView) findViewById(R.id.text_res);
        TextView textResponsible2 = (TextView) findViewById(R.id.text_res2);
        TextView textTitle = (TextView) findViewById(R.id.title);

        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast;
                toast = Toast.makeText(MainActivity.this, v.getClass().getSimpleName(), Toast.LENGTH_LONG);
                toast.show();
            }
        };

        assert textAssignedDate != null;
        textAssignedDate.setOnClickListener(onClickListener);
        assert textAssigned != null;
        textAssigned.setOnClickListener(onClickListener);
        assert textCreateDate != null;
        textCreateDate.setOnClickListener(onClickListener);
        assert textCreate != null;
        textCreate.setOnClickListener(onClickListener);
        assert textRegisterDate != null;
        textRegisterDate.setOnClickListener(onClickListener);
        assert textRegister != null;
        textRegister.setOnClickListener(onClickListener);
        assert textDescription != null;
        textDescription.setOnClickListener(onClickListener);
        assert textStatus != null;
        textStatus.setOnClickListener(onClickListener);
        assert textResponsible != null;
        textResponsible.setOnClickListener(onClickListener);
        assert textResponsible2 != null;
        textResponsible2.setOnClickListener(onClickListener);
        assert textTitle != null;
        textTitle.setOnClickListener(onClickListener);
        assert mToolbar != null;
        mToolbar.setOnClickListener(onClickListener);
    }

    /** Adds pictures in collection. */
    private void initializeData(){
        mImages = new ArrayList<>();
        mImages.add(new Image(R.drawable.firstpic));
        mImages.add(new Image(R.drawable.fourthpic));
        mImages.add(new Image(R.drawable.secondpic));
        mImages.add(new Image(R.drawable.fivthpic));
        mImages.add(new Image(R.drawable.thirdpic));
        mImages.add(new Image(R.drawable.sixthpic));

    }

    /** Initialize recycler view adapter.  */
    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(mImages);
        mRecyclerView.setAdapter(adapter);
    }
}
