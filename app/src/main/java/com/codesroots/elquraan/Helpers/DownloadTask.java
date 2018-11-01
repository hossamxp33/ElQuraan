package com.codesroots.elquraan.Helpers;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Ali on 4/22/2018.
 */

public class DownloadTask {

    public DownloadTask(Context context, String url, String filename) {
        File direct = new File(Environment.getExternalStorageDirectory() + "/OtherTafaseer");
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request
                .setAllowedNetworkTypes(
                        DownloadManager.Request.NETWORK_WIFI
                                | DownloadManager.Request.NETWORK_MOBILE);
        boolean success = true;
        if (!direct.exists()) {
            success = direct.mkdir();
        }
        if (success) {
            //  download_check = "1";
            Toast.makeText(context, "لقد بدأ التحميل", Toast.LENGTH_SHORT).show();
            request.setDestinationInExternalPublicDir(String.valueOf(direct), filename + ".mp3");
//                        .setDestinationInExternalFilesDir(this, dir, "abc.png");
            DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            assert manager != null;
            manager.enqueue(request);
        }
    }
}
