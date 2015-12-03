package de.systemengineering.shopadmin;

import android.hardware.Camera;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.content.pm.PackageManager;

/**
 * Created by SZC on 03.12.2015.
 */
public class CameraBase {
    Camera mCamera = null;
    int mCameraId = 0;

    /** A safe way to get an instance of the Camera object. */
    public Camera getCameraInstance(Context context){
        if (mCamera == null) {
            try {
                // do we have a camera?
                if (!context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                    Log.e("Camera", "No camera on this device");
                } else {
                    mCameraId = findBackFacingCamera();
                    if (mCameraId < 0) {
                        Log.i("Camera", "No BackFacingCamera found");
                    } else {
                        Log.d("Camera", "Camera open");
                        mCamera = Camera.open(mCameraId);
                    }
                }
            } catch (Exception e) {
                Log.e("Camera", "Could not open camera");
                // Camera is not available (in use or does not exist)
            }
        }
        return mCamera; // returns null if camera is unavailable
    }
    /** Check if this device has a camera */
    public static boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    private int findBackFacingCamera() {
        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                Log.d("Camera", "Camera found");
                cameraId = i;
                break;
            }
        }
        return cameraId;
    }

    private void releaseCameraAndPreview() {
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

}
