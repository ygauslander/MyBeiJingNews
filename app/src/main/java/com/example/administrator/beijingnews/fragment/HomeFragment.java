package com.example.administrator.beijingnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.beijingnews.R;

/**
 * Created by Administrator on 2016/6/27.
 */
public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity() , R.layout.home_fragment_layout , null);
        TextView textView = (TextView) view.findViewById(R.id.home_titlebar);
        textView.setText("首页");
        return view;
    }
}
