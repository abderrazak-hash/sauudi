package com.app.alshmalesalemalrwele;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.javiersantos.piracychecker.PiracyChecker;
import com.github.javiersantos.piracychecker.enums.Display;
import com.github.javiersantos.piracychecker.enums.InstallerID;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private MapAdapter adapter;

    private FloatingActionButton floatingActionButton ;
    private Display piracyCheckerDisplay = Display.DIALOG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.mapRv);

        ArrayList<MapModel> mapModels = new ArrayList<>();
        mapModels.add(new MapModel("خريطة الرياض البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1zDvUx5fza1RvGTDpoDrx2YeMRrmvbNKe"));
        mapModels.add(new MapModel("خريطة القصيم البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1uife5mhtb6LyfjWfsSSEk6wuq-R1Nkcq&shorturl=1&ll=25.97748045044987%2C43.16099694503086&z=7"));
        mapModels.add(new MapModel("خريطة مكة المكرمة البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1RAERgQNPG6IWwKkK3svbmQNOh8moerCW&shorturl=1&ll=0%2C0&z=6"));
        mapModels.add(new MapModel("خريطة حائل البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=18fBeGiAoVbLTGNcJoXR2NQUpuaInXepi&shorturl=1&ll=27.58001760289023%2C41.40549365936657&z=8"));
        mapModels.add(new MapModel("خريطة الحدود الشمالية البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1Ca79X7Y82zn1FWqZlJlgtxaCc4VSD1_X&shorturl=1&ll=29.89494833951375%2C42.924453226562505&z=6"));
        mapModels.add(new MapModel("خريطة المدينة المنورة البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1nB9BEpJwKrBUpNZl0r81Nw8dbLfQhUiw&shorturl=1&ll=25.43181553099574%2C39.14015512493359&z=6"));
        mapModels.add(new MapModel("خريطة عسير البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1Ph5YSXGpngGB61eOnlD-5u0LdtBsQN-N&shorturl=1&ll=0%2C0&z=7"));
        mapModels.add(new MapModel("خريطة الباحة البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1_Mwi6VATi5tWg-UoFsxnVEjdSbiHXNnU&shorturl=1&ll=20.17396668225389%2C41.39041947928671&z=8"));
        mapModels.add(new MapModel("خريطة تبوك البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1ex2Fz9YoPgxm5W0WiEJ7GU6HYDhSnVdJ&shorturl=1&ll=27.761459385581208%2C38.85111062109377&z=6"));
        mapModels.add(new MapModel("خريطة الجوف البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1HqaIi2Hp02lQelti20ago_cgtA7fMUcs&shorturl=1&ll=0%2C0&z=7"));
        mapModels.add(new MapModel("خريطة نجران البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1WsNswtQtjCouYxJC_7RsdIvwoM_5K30C&shorturl=1&ll=18.219590478724808%2C47.77679449999999&z=7"));
        mapModels.add(new MapModel("خريطة الشرقية البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=1SPQZ7GkcngMUjwMhYqrw-ANgddZrY7y6&shorturl=1&ll=24.429403977177106%2C50.443521765625064&z=5"));
        mapModels.add(new MapModel("خريطة جازان البرّية" ,"https://www.google.com/maps/d/u/0/viewer?mid=12vYaqBx9aijU5r-cIR7NUwNv-xAHafaw&shorturl=1&ll=0%2C0&z=8"));


        adapter = new MapAdapter(this ,mapModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , OurAppsActivity.class));
            }
        });
    }

    public void verifyInstallerId(View view) {
        new PiracyChecker(this)
                .display(piracyCheckerDisplay)
                .enableInstallerId(InstallerID.GOOGLE_PLAY)
                .start();
    }
}