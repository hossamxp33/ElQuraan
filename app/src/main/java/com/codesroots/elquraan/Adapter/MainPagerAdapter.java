package com.codesroots.elquraan.Adapter;//package com.codesroots.elquraan.Adapter;
//
//import android.content.Context;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.PagerAdapter;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//
//import com.codesroots.elquraan.Helpers.BroadcastHelper;
//import com.codesroots.elquraan.Models.SewarModelView;
//import com.codesroots.elquraan.R;
//
//import java.util.ArrayList;
//
//import it.sephiroth.android.library.imagezoom.ImageViewTouch;
//import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
//
//
///**
// * Created by Ali on 3/4/2018.
// */
//
//public class MainPagerAdapter extends FragmentPagerAdapter {
//
//
//        public MainPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(final int position) {
//            Log.i("position", String.valueOf(position));
//            if (position == 0) {
//
//            } else if (position == 1) {
//
//            } else {
//
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return 3;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return Cat_arrayList.get(position).getName();
//        }
//    }
//}
