        package com.example.recyclerview;

        import static android.app.ProgressDialog.show;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Toast;

        import androidx.activity.EdgeToEdge;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.graphics.Insets;
        import androidx.core.view.ViewCompat;
        import androidx.core.view.WindowInsetsCompat;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        public class MainActivity extends AppCompatActivity {

            int[] images={
                    R.drawable.rose,R.drawable.marigold,R.drawable.sunflower,R.drawable.tulip,
                    R.drawable.cherry_blossom, R.drawable.orchid, R.drawable.jasmine,
                    R.drawable.plumeria,R.drawable.lotus,R.drawable.aster,
            };
            Adapter adapter;
            String[] title,description;
            RecyclerView recyclerView;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                recyclerView=findViewById(R.id.recycle);

                title=getResources().getStringArray(R.array.flower_name);
                description=getResources().getStringArray(R.array.flower_description);
                adapter=new Adapter(this,title,description,images);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

                adapter.setOnItemClickListener(new Adapter.ClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Toast.makeText(getApplicationContext(),"on item click"+position,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemLongClick(int position, View v) {
                        Toast.makeText(getApplicationContext(),"on item long click"+position,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }