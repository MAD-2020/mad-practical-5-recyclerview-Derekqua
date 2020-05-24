package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class recylceViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    CheckBox checkBox;
    ConstraintLayout deleteArea;

    public recylceViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.taskTextView);
        checkBox = itemView.findViewById(R.id.taskCheckBox);
        deleteArea = itemView.findViewById(R.id.deletingHitBox);
    }
}