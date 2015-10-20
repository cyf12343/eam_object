package cdhxqh.shekou.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import cdhxqh.shekou.R;
import cdhxqh.shekou.config.Constants;
import cdhxqh.shekou.manager.AppManager;
import cdhxqh.shekou.utils.AccountUtils;


/**
 * 登录界面
 */
public class Activity_Login extends BaseActivity{


    private static final String TAG = "Activity_Login";
    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private ProgressDialog mProgressDialog;
    //    private MemberModel mProfile;
    private CheckBox checkBox; //记住密码

    private boolean isRemember; //是否记住密码


    String userName; //用户名

    String userPassWorld; //密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        findViewById();
        initView();
    }
    @Override
    protected void findViewById() {
        mUsername = (EditText) findViewById(R.id.user_login_id);
        mPassword = (EditText) findViewById(R.id.user_login_password);
        checkBox = (CheckBox) findViewById(R.id.isremenber_password);
        mLogin = (Button) findViewById(R.id.user_login);
    }

    @Override
    protected void initView() {
        mUsername.setText(myshared.getString(Constants.NAME_KEY, ""));
        mPassword.setText(myshared.getString(Constants.PASS_KEY,""));
        checkBox.setChecked(myshared.getBoolean(Constants.ISREMENBER, false));
        mLogin.setOnClickListener(longinlistener);
    }

    private View.OnClickListener longinlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SaveUserLoginInfo();
        }
    };

    private void SaveUserLoginInfo(){
        SharedPreferences.Editor editor = myshared.edit();
        editor.putString(Constants.NAME_KEY,mUsername.getText().toString());
        editor.putBoolean(Constants.ISREMENBER,checkBox.isChecked());
        if(checkBox.isChecked()){
            editor.putString(Constants.PASS_KEY,mPassword.getText().toString());
        }else {
            editor.putString(Constants.PASS_KEY,"");
        }
        editor.commit();
    }
}
