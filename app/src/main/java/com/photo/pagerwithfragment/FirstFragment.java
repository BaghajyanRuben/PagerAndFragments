package com.photo.pagerwithfragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater,
							 @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		return inflater.inflate(
				R.layout.fragment_first_layout,
				container,
				false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView textView = view.findViewById(R.id.tv_position);

		Bundle bundle = getArguments();

		if (bundle != null){
			int position = bundle.getInt(MyPagerAdapter.ARG_FRAGMENT_POSITION, -1);
			textView.setText(String.format(
					getString(R.string.first_fragment),
					String.valueOf(position)));
		}

	}

	public void print(){
		Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}


}
