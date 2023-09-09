package anhhv.dev.reactbutton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity implements ReactionListener {
    LinearLayout lnTotal, btnReact;
    ImageView imgReact1, imgReact2, imgReact;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lnTotal = findViewById(R.id.lnTotal);
        btnReact = findViewById(R.id.btnReact);
        imgReact1 = findViewById(R.id.imgReact1);
        imgReact2 = findViewById(R.id.imgReact2);
        imgReact = findViewById(R.id.imgReact);
        tvTotal = findViewById(R.id.tvTotal);

        btnReact.setOnLongClickListener(view -> {
            getReactionsDialog();
            return false;
        });
    }

    private DialogFragment getReactionsDialog() {
        FbReactsDialog fbReactsDialog = new FbReactsDialog();
        fbReactsDialog.show(getSupportFragmentManager(), fbReactsDialog.getClass().getSimpleName());
        return fbReactsDialog;
    }

    @Override
    public void onReactionSelected(int reactionType) {
        switch (reactionType) {
            case 0:
                tvTotal.setText("like");
                imgReact.setImageResource(R.drawable.ic_like_fill);
                break;
            case 1:
                tvTotal.setText("love");
                imgReact.setImageResource(R.drawable.love2);
                break;
            case 2:
                tvTotal.setText("haha");
                imgReact.setImageResource(R.drawable.haha2);
                break;
            case 3:
                tvTotal.setText("wow");
                imgReact.setImageResource(R.drawable.wow2);
                break;
            case 4:
                tvTotal.setText("sad");
                imgReact.setImageResource(R.drawable.sad2);
                break;
            case 5:
                tvTotal.setText("angry");
                imgReact.setImageResource(R.drawable.angry2);
                break;
            case 6:
                tvTotal.setText("diskLike");
                imgReact.setImageResource(R.drawable.ic_dislike);
                break;
        }
    }
}
