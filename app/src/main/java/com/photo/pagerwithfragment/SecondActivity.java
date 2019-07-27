package com.photo.pagerwithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
	private FragmentManager fm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		 fm = getSupportFragmentManager();

		FirstFragment fragment = (FirstFragment) fm.findFragmentById(R.id.fragment_first);

		fragment.print();
//
//		FirstFragment secondFragment = new FirstFragment();
//		Bundle bundle = new Bundle();
//		bundle.putInt(MyPagerAdapter.ARG_FRAGMENT_POSITION, 13);
//		secondFragment.setArguments(bundle);
//
//		fm.beginTransaction().add(R.id.second_fragment_container,
//				secondFragment,
//				"second_fragment_tag").commit();

		findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				addNewFragment();
			}
		});

		findViewById(R.id.btn_replace).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				replaceFragment();
			}
		});



	}

	private void addNewFragment(){
		int fragmentCount = fm.getFragments().size();
		FirstFragment secondFragment = new FirstFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(MyPagerAdapter.ARG_FRAGMENT_POSITION, fragmentCount + 1);
		secondFragment.setArguments(bundle);

		String fragmentTag ="second_fragment_tag_" + (fragmentCount + 1);
		fm.beginTransaction().add(R.id.second_fragment_container,
				secondFragment, fragmentTag)
				.addToBackStack(fragmentTag)
				.commit();
	}

	private void replaceFragment(){
		int fragmentCount = fm.getFragments().size();
		int pos = fragmentCount / 2;

		String fragmentTag ="second_fragment_tag_" + pos;

		Fragment fragment = fm.findFragmentByTag(fragmentTag);
		if (fragment != null) {
			fm.beginTransaction().replace(R.id.second_fragment_container,
					fragment, fragmentTag)
					.addToBackStack(fragmentTag)
					.commit();
		}
	}

}
