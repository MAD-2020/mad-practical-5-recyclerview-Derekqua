package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class recyclerViewAdaptor extends RecyclerView.Adapter<recylceViewHolder>{
    ArrayList<String> todoList;
    TextView displayItem;
    public recyclerViewAdaptor(ArrayList<String> listOfItems){
        todoList = listOfItems;
    }


    public recylceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylcer_view_item,parent,false);
        return new recylceViewHolder(view);
    }

    public void onBindViewHolder(recylceViewHolder holder, final int position){
        String list_items = todoList.get(position);
        holder.txt.setText(list_items);
        final String item = holder.txt.getText().toString();
        holder.deleteArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add here the alert and deleting method
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                // Get the layout inflater
                LayoutInflater layoutInflater = LayoutInflater.from(v.getContext());
                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                View AlertView = layoutInflater.inflate(R.layout.alert,null );
                builder.setView(AlertView)
                        // Add action buttons
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                todoList.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                displayItem = (TextView) AlertView.findViewById(R.id.itemName);
                displayItem.setText(item + "?");
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Delete");
                alertDialog.show();
            }
        });
    }

    public int getItemCount(){
        return todoList.size();
    }
}