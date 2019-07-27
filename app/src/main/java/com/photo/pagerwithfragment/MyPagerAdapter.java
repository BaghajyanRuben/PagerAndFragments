package com.photo.pagerwithfragment;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
	public static final String ARG_FRAGMENT_POSITION = "fragment_position";

	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		FirstFragment fragment = new FirstFragment();
		Bundle data = new Bundle();
		data.putInt(ARG_FRAGMENT_POSITION, position);
		fragment.setArguments(data);
		return fragment;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return "fragment " + position;
	}
}
