package com.tma.ttphong.fairfind.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.tma.ttphong.fairfind.BitmapHelper;
import com.tma.ttphong.fairfind.Product;
import com.tma.ttphong.fairfind.R;

import java.util.ArrayList;

/**
 * Created by ttphong on 9/1/2016.
 */
public class SellingProductAdapter extends ArrayAdapter {
    private Context mContext;
    private int mResourceId;
    private ArrayList mData = new ArrayList();


    public SellingProductAdapter(Context context, int resource, ArrayList data) {
        super(context, resource, data);

        this.mContext = context;
        this.mResourceId = resource;
        this.mData = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;

        if (item == null) {
            LayoutInflater layoutInflater = ((Activity)mContext).getLayoutInflater();
            item = layoutInflater.inflate(mResourceId, parent, false);

            holder = new ViewHolder();
            holder.mImageView = (ImageView)item.findViewById(R.id.image_selling_product);
            holder.mTextView = (TextView) item.findViewById(R.id.tv_number_message);

            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        // image view
        Product product = (Product) mData.get(position);
        DecodeImageTask imageTask = new DecodeImageTask(holder.mImageView);
        imageTask.execute(product.getImageResourceId());
        // text view
        holder.mTextView.setText(String.valueOf(product.getNumberMessage()));

        return item;
    }

    private class DecodeImageTask extends AsyncTask<Integer, Void, Bitmap> {
        ImageView bmImage;

        public DecodeImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(Integer... params) {
            int resID = params[0];
            return BitmapHelper.decodeSampledBitmapFromResource(mContext.getResources(), resID, 100, 100);
        }

        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                bmImage.setImageBitmap(result);
            } else {
//                bmImage.setImageBitmap();
            }
        }
    }

    private class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }

}
