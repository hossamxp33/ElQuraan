package com.codesroots.elquraan.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Helpers.PreferenceHelper;
import com.codesroots.elquraan.Helpers.rtlVIEWPAGER;
import com.codesroots.elquraan.Models.QuranModel;
import com.codesroots.elquraan.Models.SewarModel;
import com.codesroots.elquraan.R;
import com.codesroots.elquraan.db.DBAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static android.content.ContentValues.TAG;
import static com.codesroots.elquraan.MainActivity.getBitmapAsByteArray;
import static com.codesroots.elquraan.MainActivity.souraposition;



public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    LayoutInflater mLayoutInflater;
    private List<QuranModel.QuraanBean> mResources;
    private boolean isHidden = true;
    private PreferenceHelper helper;
    DBAdapter dbAdapter;
     String imgpath;

    public CustomPagerAdapter(Context context, List<QuranModel.QuraanBean> resources) {
        mContext = context;
        this.mResources = resources;
        helper = new PreferenceHelper(context);
        dbAdapter = new DBAdapter(mContext);
    }

    @Override
    public int getCount() {

//        if (mResources.size() > 0) {
//            if (mResources.get(0).getId() == 33)
//                return 1;
//            else
//                return mResources.size();
//        }
        return mResources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        final View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(0,0,0,0);
         final ImageView imageView = itemView.findViewById(R.id.imageView);
        imageView.setLayoutParams(params);

        int id = ((Activity)mContext).getResources().getIdentifier("b"+mResources.get(position).getQuraan_page(), "drawable", ((Activity)mContext).getPackageName());
        imageView.setImageResource(id);


//        if (position < mResources.size()) {
//
//         if (!dbAdapter.CheckIsImageAlreadyInDBorNot(souraposition,mResources.get(position).getId()))
//         {
//
//             for (int j = 1; j < 6; j++) {
//                 Drawable drawable =((Activity)mContext).getResources().getDrawable(((Activity)mContext).getResources()
//                         .getIdentifier("1"+j, "drawable", ((Activity)mContext).getPackageName()));
//             }
//
//             int id = ((Activity)mContext).getResources().getIdentifier("1", "drawable", context.getPackageName());
//             imageView.setImageResource(id);
//
//
//
//             Glide.with(mContext).load("http://quraan.codesroots.com/library/sewar/" + mResources.get(position).getPage_image())
//                     .downloadOnly(new SimpleTarget<File>() {
//                         @Override
//                         public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
//                             BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//                             Bitmap bitmap = BitmapFactory.decodeFile(resource.getAbsolutePath(), bmOptions);
//                             imageView.setImageBitmap(bitmap);
//                             saveimageindevice( bitmap, mResources.get(position).getId(),mResources.get(position).getPage_image());
//                         }
//                     });
//         }
//
//          else
//             {
//               String returnImagePath = dbAdapter.getImagepath(souraposition,mResources.get(position).getId());
//                File imgFile = new  File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).
//                         getAbsolutePath()+returnImagePath);
//                if(imgFile.exists()){
//                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//                    imageView.setImageBitmap(myBitmap);
//                }
//                else
//                {
//                    Log.d("found","Not Found");
//                }
//            }
//

//
//            imageView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    showAllSourDownloadDialog(position);
//                    return false;
//                }
//            });
//        }

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHidden) {
                        BroadcastHelper.sendInform(mContext, "show");
                        isHidden = false;
                    } else {
                        BroadcastHelper.sendInform(mContext, "hide");
                        isHidden = true;
                    }
                }
            });
        container.addView(itemView);
        return itemView;
    }


    private void saveimageindevice(Bitmap bitmap, int iposition, String page_image) {

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        Environment.getRootDirectory();
        File myDir = new File(path + "/quran_images");
        myDir.mkdirs();

        Random generator = new Random();
        int x = Integer.MAX_VALUE;  //////////// bound values
        int  n = generator.nextInt(x);
        String fname = "Image-" + n + page_image ;
        File file = new File( myDir , fname);

        Log.i(TAG, "" + file);
        if (file.exists())
            file.delete();

        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
           }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        dbAdapter.addsouraimages(souraposition,iposition,"/quran_images/"+fname);

    }

    public void insertImage(int Souraid, Bitmap img, int souranumber, int ids, int gozaa,
                            int imageid, String soundtrack, String tafseer, String name,String urdolang,int pagees) {
        byte[] data = getBitmapAsByteArray(img); // this is a function
        dbAdapter.open();
        dbAdapter.addSouraImage(ids, Souraid, souranumber, gozaa, data, imageid, soundtrack, tafseer, name,urdolang,pagees);
        dbAdapter.close();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }

    private Dialog down_dialog;
    private void showAllSourDownloadDialog(final int pos) {

     down_dialog = new Dialog(mContext, R.style.MyDialog);
   Objects.requireNonNull(down_dialog.getWindow()).setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        down_dialog.setContentView(R.layout.addfasel);
        down_dialog.setCancelable(true);
        down_dialog.show();
        RelativeLayout add = down_dialog.findViewById(R.id.add);
        RelativeLayout adds = down_dialog.findViewById(R.id.adds);
        RelativeLayout addss = down_dialog.findViewById(R.id.addss);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.setSavedPage(pos);
                helper.setSavedSoraid(souraposition);
                down_dialog.cancel();
                Toast.makeText(mContext,"تم حفظ الفاصل بنجاح",Toast.LENGTH_SHORT).show();
            }
        });
        adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadcastHelper.sendInform(mContext,"playtafseers");
                down_dialog.cancel();
            }
        });


        addss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadcastHelper.sendInform(mContext,"playtelawoa");
                down_dialog.cancel();
            }
        });
    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((rtlVIEWPAGER) collection).removeView((View) view);
        collection = null;
    }

}
