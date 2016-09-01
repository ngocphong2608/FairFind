package com.tma.ttphong.fairfind.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tma.ttphong.fairfind.R;

/**
 * Created by ttphong on 9/1/2016.
 */
public class ListSoldProductFragment extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_selling_product, container, false);
        return rootView;
    }
}
