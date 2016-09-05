package com.tma.ttphong.fairfind.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.tma.ttphong.fairfind.Product;
import com.tma.ttphong.fairfind.R;

public class SellingProductActivity extends AppCompatActivity {

    private static String INTENT_EXTRA_PRODUCT = "INTENT_EXTRA_PRODUCT";
    private Product mProduct;
    ImageView img_sellingProduct;
    TextView tv_dimention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_product);

        Intent intent = getIntent();
        mProduct = (Product)intent.getSerializableExtra(INTENT_EXTRA_PRODUCT);

        img_sellingProduct = (ImageView)findViewById(R.id.img_selling_product);
        img_sellingProduct.setImageResource(mProduct.getImageResourceId());

//        tv_dimention = (TextView)findViewById(R.id.tv)
    }

    public static Intent getStartIntent(Context context, Product product) {
        Intent intent = new Intent(context, SellingProductActivity.class);
        intent.putExtra(INTENT_EXTRA_PRODUCT, product);
        return intent;
    }
}
