package com.fynnjason.permissonhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.constant.PermissionConstants;

public class MainActivity extends AppCompatActivity {

    private Button btnnormal;
    private Button btnmust;

    private PermissionHelper mPermissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnmust = findViewById(R.id.btn_must);
        this.btnnormal = findViewById(R.id.btn_normal);

        mPermissionHelper = new PermissionHelper();

        mPermissionHelper.setApplyListener(new PermissionHelper.ApplyListener() {
            @Override
            public void success() {
                Log.e("MainActivity", "权限都申请完成");
            }
        });

        // 普通申请单个或多个权限
        btnnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPermissionHelper.normalApply(PermissionConstants.STORAGE
                        , PermissionConstants.PHONE
                        , PermissionConstants.LOCATION
                        , PermissionConstants.CAMERA);
            }
        });

        // 必须申请单个或多个权限
        btnmust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPermissionHelper.mustApply(PermissionConstants.STORAGE
                        , PermissionConstants.PHONE
                        , PermissionConstants.LOCATION
                        , PermissionConstants.CAMERA);
            }
        });

    }

}
