package sg.edu.rp.c346.id22011117.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etToDo;
    Button btnAdd;
    Button btnClear;
    ListView lvToDo;

    ArrayList<String> thingsToDo;
    ArrayAdapter<String> aaToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToDo = findViewById(R.id.editTextToDo);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        lvToDo = findViewById(R.id.listViewToDo);

        thingsToDo = new ArrayList<>();

        ArrayAdapter aaToDo = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, thingsToDo);

        lvToDo.setAdapter(aaToDo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toDo = etToDo.getText().toString();
                thingsToDo.add(toDo);
                aaToDo.notifyDataSetChanged();
                etToDo.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thingsToDo.clear();
                aaToDo.notifyDataSetChanged();
            }
        });
    }
}