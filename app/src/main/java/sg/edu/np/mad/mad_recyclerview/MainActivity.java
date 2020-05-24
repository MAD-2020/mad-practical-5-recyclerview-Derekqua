package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText addToDoItems;
    Button AddItemBtn;
    ArrayList<String> toDoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerViewCustom = findViewById(R.id.recyclerView);
        final recyclerViewAdaptor mAdaptor = new recyclerViewAdaptor(toDoList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustom.setLayoutManager(mLayoutManager);
        recyclerViewCustom.setAdapter(mAdaptor);
        recyclerViewCustom.setItemAnimator(new DefaultItemAnimator());

        InitData();

        Button add = (Button)findViewById(R.id.addTaskBtn);
        final EditText addText = (EditText)findViewById(R.id.addTaskEditText);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = addText.getText().toString();
                toDoList.add(data);
                showNewEntry(recyclerViewCustom,toDoList );
                mAdaptor.notifyDataSetChanged();
            }
        });
    }


    public void InitData(){
        String choc = "Buy Chocolate";
        String pen = "Buy Pen";
        toDoList.add(choc);
        toDoList.add(pen);
    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }
}
