package de.systemengineering.shopadmin;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.util.Log;
import android.hardware.Camera;
import android.widget.FrameLayout;
import android.content.pm.PackageManager;
import android.widget.Toast;
import android.hardware.Camera.CameraInfo;

/**
 * Created by SZC on 03.12.2015.
 */
public class CameraViewActivity extends AppCompatActivity {
    private CoordinatorLayout mCoordinatorLayout;
    private Camera mCamera;
    private CameraPreview mPreview;
    private CameraBase mCameraBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameraview);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        mCameraBase = new CameraBase();

        if ( CameraBase.checkCameraHardware(this) == false )
            Snackbar.make(mCoordinatorLayout, "OOOhhhhh... no Camera, no Service", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        else {
            // Create an instance of Camera
            mCamera = mCameraBase.getCameraInstance(this);
            if ( mCamera != null ) {
                mCamera.setDisplayOrientation(180);
                // Create our Preview view and set it as the content of our activity.
                mPreview = new CameraPreview(this, mCamera);
                FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
                preview.addView(mPreview);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
        return true;
    }

    public void onClickSave(View view) {
        Log.i("clicks", "You clicked Button Save");
    }

    public void onClickRescan(View view) {
        Log.i("clicks", "You clicked Button Rescan");
    }

    public void onClickEdit(View view) {
        Log.i("clicks", "You clicked Button Edit");
    }


    private void releaseCameraAndPreview() {
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

}
