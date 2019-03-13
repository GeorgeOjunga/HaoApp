package login.georgie.com.haoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class SigninActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener
{
    SignInButton signInButton;
    Button signoutButton;
    TextView statusTextView;
    GoogleApiClient mGoogleApiClient;
    public static final String TAG="SignInActivity";
    public static final int RC_SIGN_IN=9001;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        Toolbar toolbar=(Toolbar) findViewById(R.id.signintoolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this )
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        statusTextView=(TextView) findViewById(R.id.status_textview);
        signInButton=(SignInButton) findViewById(R.id.signin_btn);
        signInButton.setOnClickListener(this);


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(SigninActivity.this,"Connection failed, Check your internet connectivity ",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signin_btn:
                signIn();

        }

    }


    private void signIn() {
        Intent signInIntent=Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //result obtained from launching the intent from googleSigninApi.etSigninApi
        if(requestCode ==RC_SIGN_IN){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG,"handleSinInResult:"+result.isSuccess());
        if(result.isSuccess()){

            //MAKE A Toast Signed in successfully, for the authenticated user the open the homepage
            GoogleSignInAccount acct=result.getSignInAccount();
            Toast.makeText(SigninActivity.this,"Successfull Sign in for  " +acct.getDisplayName(),Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);



        }else {

        }
    }


}

