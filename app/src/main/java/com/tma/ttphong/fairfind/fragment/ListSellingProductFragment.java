package com.tma.ttphong.fairfind.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.tma.ttphong.fairfind.Product;
import com.tma.ttphong.fairfind.R;
import com.tma.ttphong.fairfind.adapter.SellingProductAdapter;

import java.util.ArrayList;

/**
 * Created by ttphong on 9/1/2016.
 */
public class ListSellingProductFragment extends Fragment {

    GridView gv_sellingProduct;
    private SellingProductAdapter mAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_selling_product, container, false);

        gv_sellingProduct = (GridView)rootView.findViewById(R.id.gv_selling_product);
        mAdapter = new SellingProductAdapter(getContext(), R.layout.item_selling_product, getData());
        gv_sellingProduct.setAdapter(mAdapter);

        return rootView;
    }

    private ArrayList getData() {
        ArrayList<Product> products = new ArrayList<>();

        Product p0 = new Product();
        p0.setImageResourceId(R.drawable.product_0);
        p0.setNumberMessage(3);
        products.add(p0);

        Product p1 = new Product();
        p1.setImageResourceId(R.drawable.product_1);
        p1.setNumberMessage(4);
        products.add(p1);

        Product p2 = new Product();
        p2.setImageResourceId(R.drawable.product_2);
        p2.setNumberMessage(0);
        products.add(p2);

        return products;
    }
}
