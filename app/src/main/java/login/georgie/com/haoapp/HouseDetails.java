package login.georgie.com.haoapp;

import android.icu.util.ULocale;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import login.georgie.com.haoapp.Category.Category;

public class HouseDetails extends AppCompatActivity {

    TextView House_name,House_price,House_Description;
    ImageView House_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton BtnCart;
    ElegantNumberButton NumberButton;

    String CategoryID="";

    FirebaseDatabase database;
    DatabaseReference Houses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_details);

        //firebase
        database=FirebaseDatabase.getInstance();
        Houses=database.getReference("Category");

        //init view
        NumberButton=(ElegantNumberButton)findViewById(R.id.number_button);
        BtnCart=(FloatingActionButton)findViewById(R.id.btnCart);

        House_Description=(TextView)findViewById(R.id.house_description);
        House_name=(TextView)findViewById(R.id.house_Name);
        House_price=(TextView)findViewById(R.id.house_price);

        House_image=(ImageView)findViewById(R.id.img_house);

        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        //get category id from intent
        if(getIntent() !=null)
            CategoryID= getIntent().getStringExtra("CategoryId");
        if(!CategoryID.isEmpty())
        {
            getDetailHouse(CategoryID);
        }




    }

    private void getDetailHouse(final String categoryID) {
        Houses.child(categoryID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Category category =dataSnapshot.getValue(Category.class);

                //set image
                Picasso.get().load(category.getImage())
                        .into(House_image);

                collapsingToolbarLayout.setTitle(category.getName());

                House_price.setText(category.getPrice());
                House_Description.setText(category.getDescription());
                House_name.setText(category.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
