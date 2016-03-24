package ua.internship.yaltask01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTextAssignedDate;
    TextView mTextAssigned;
    TextView mTextCreateDate;
    TextView mTextCreate;
    TextView mTextRegisterDate;
    TextView mTextRegister;
    TextView mTextDescription;
    TextView mTextStatus;
    TextView mTextResponsible2;
    TextView mTextResponsible;
    TextView mTextTitle;

    private Toolbar mToolbar;
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
        mToolbar = (Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(mToolbar);
        //Show back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mRecyclerView =(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        initializeData();

        final RVAdapter adapter = new RVAdapter(mImages);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        }));

        mTextAssignedDate = (TextView) findViewById(R.id.date_ass);
        mTextAssigned = (TextView) findViewById(R.id.text_ass);
        mTextCreateDate = (TextView) findViewById(R.id.date_create);
        mTextCreate = (TextView) findViewById(R.id.text_create);
        mTextRegisterDate = (TextView) findViewById(R.id.date_reg);
        mTextRegister = (TextView) findViewById(R.id.text_reg);
        mTextDescription = (TextView) findViewById(R.id.description);
        mTextStatus = (TextView) findViewById(R.id.status);
        mTextResponsible = (TextView) findViewById(R.id.text_res);
        mTextResponsible2 = (TextView) findViewById(R.id.text_res2);
        mTextTitle = (TextView) findViewById(R.id.title);

        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast;
                toast = Toast.makeText(MainActivity.this, v.getClass().getSimpleName(), Toast.LENGTH_LONG);
                toast.show();
            }
        };

        mTextAssignedDate.setOnClickListener(onClickListener);
        mTextAssigned.setOnClickListener(onClickListener);
        mTextCreateDate.setOnClickListener(onClickListener);
        mTextCreate.setOnClickListener(onClickListener);
        mTextRegisterDate.setOnClickListener(onClickListener);
        mTextRegister.setOnClickListener(onClickListener);
        mTextDescription.setOnClickListener(onClickListener);
        mTextStatus.setOnClickListener(onClickListener);
        mTextResponsible.setOnClickListener(onClickListener);
        mTextResponsible2.setOnClickListener(onClickListener);
        mTextTitle.setOnClickListener(onClickListener);
        mToolbar.setOnClickListener(onClickListener);
    }

    /** Adds pictures in collection. */
    private void initializeData(){
        mImages = new ArrayList<>();
        mImages.add(new Image(R.drawable.firstpic, R.drawable.fourthpic));
        mImages.add(new Image(R.drawable.secondpic, R.drawable.fivthpic));
        mImages.add(new Image(R.drawable.thirdpic, R.drawable.sixthpic));

    }

    /** Initialize recycler view adapter.  */
    //private void initializeAdapter(){
    //    RVAdapter adapter = new RVAdapter(mImages);
    //    mRecyclerView.setAdapter(adapter);
    //}

    public interface ClickListener {
        void onClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
