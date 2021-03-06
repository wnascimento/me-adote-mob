package com.wnascimento.com.me_adote_mob.presentation.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.wnascimento.com.me_adote_mob.MainApplication;
import com.wnascimento.com.me_adote_mob.R;
import com.wnascimento.com.me_adote_mob.presentation.timeline.TimelineActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
    private EditText editEmail;
    private EditText editPassword;
    private ImageButton buttonLogin;

    @Inject
    LoginPresenter presenter;

    private LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initDagger();
        initFields();
        initListeners();
    }

    private void initDagger() {
        DaggerLoginComponent.builder()
                .mainComponent(MainApplication.mainComponent)
                .repositoryComponent(MainApplication.repositoryComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    private void initFields() {
        textInputEmail = (TextInputLayout) findViewById(R.id.text_input_email);
        textInputPassword = (TextInputLayout) findViewById(R.id.text_input_password);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editPassword = (EditText) findViewById(R.id.edit_password);
        buttonLogin = (ImageButton) findViewById(R.id.button_login);
    }

    private void initListeners() {
        buttonLogin.setOnClickListener(new OnClickLogin());
    }

    @Override
    protected void onPause() {
        super.onPause();
        loginPresenter.close();
    }

    @Override
    public void attachPresenter(LoginContract.Presenter presenter) {
        loginPresenter = presenter;
    }

    @Override
    public void showMessageUserNotFound() {
        Toast.makeText(this, getString(R.string.error_user_not_found), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageEmailNotValid() {
        textInputEmail.setError(getString(R.string.error_email_not_valid));
    }

    @Override
    public void showMessagePasswordNotValid() {
        textInputPassword.setError(getString(R.string.error_password_not_valid));
    }

    @Override
    public void goToPets() {
        TimelineActivity.start(this);
    }


    private final class OnClickLogin implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String login = editEmail.getText().toString().toLowerCase();
            String password = editPassword.getText().toString().toLowerCase();
            loginPresenter.login(login, password);
        }
    }

}
