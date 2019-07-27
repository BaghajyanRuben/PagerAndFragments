package com.photo.pagerwithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ViewPager pager = findViewById(R.id.view_pager);

		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);

		pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
//
//		FirstFragment fragment = (FirstFragment) adapter.getItem(pager.getCurrentItem());
//
//		fragment.print();

		findViewById(R.id.btn_new_activity).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, SecondActivity.class));
			}
		});

	}
}
