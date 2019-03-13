package login.georgie.com.haoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnappStart;
    TextView txtSlogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnappStart=(Button) findViewById(R.id.BtnstartApp);
        txtSlogan=(TextView) findViewById(R.id.appslogan);

        btnappStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent home=new Intent(this,Home.class);
                //startActivity(home);
                Toast.makeText(MainActivity.this,"Homepage succesfull",Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(MainActivity.this,Home.class);
                startActivity(homeIntent);
                finish();

            }
        });
    }
}
