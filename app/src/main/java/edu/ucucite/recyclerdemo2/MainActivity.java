package edu.ucucite.recyclerdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import edu.ucucite.recyclerdemo2.adapter.PhotoRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements ICallMethod{
    RecyclerView recyclerView;
    PhotoRecyclerViewAdapter photoRecyclerViewAdapter;
    ArrayList<Photo> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        getData();
        photoRecyclerViewAdapter = new PhotoRecyclerViewAdapter(arrayList, MainActivity.this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(photoRecyclerViewAdapter);
    }

    private void getData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Photo("Blah", R.drawable.ic_launcher_background));
        arrayList.add(new Photo("Blah1", R.drawable.ic_launcher_background));
        arrayList.add(new Photo("Blah2", R.drawable.ic_launcher_background));
        arrayList.add(new Photo("Blah3", R.drawable.ic_launcher_background));
        arrayList.add(new Photo("Blah4", R.drawable.ic_launcher_background));
    }

    @Override
    public void callMethod(Photo photo) {
        Toast.makeText(this, "Clciked" + photo.title, Toast.LENGTH_SHORT).show();
    }
}
