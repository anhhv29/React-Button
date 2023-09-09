package anhhv.dev.reactbutton;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FbReactsDialog extends DialogFragment implements View.OnClickListener {
    View view;
    ImageView reactLike, reactLove, reactHaha, reactWow, reactSad, reactAngry, reactDiskLike;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.dialog_fb_reactions, container, false);
        initializeComponents();
        return view;
    }

    private void initializeComponents() {
        if (getView() == null) return;
        reactLike = getView().findViewById(R.id.reactLike);
        reactLove = getView().findViewById(R.id.reactLove);
        reactHaha = getView().findViewById(R.id.reactHaha);
        reactWow = getView().findViewById(R.id.reactWow);
        reactSad = getView().findViewById(R.id.reactSad);
        reactAngry = getView().findViewById(R.id.reactAngry);
        reactDiskLike = getView().findViewById(R.id.reactDiskLike);

        reactLike.setOnClickListener(this);
        reactLove.setOnClickListener(this);
        reactHaha.setOnClickListener(this);
        reactWow.setOnClickListener(this);
        reactSad.setOnClickListener(this);
        reactAngry.setOnClickListener(this);
        reactDiskLike.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reactLike:
                listener.onReactionSelected(0);
                getDialog().dismiss();
                break;
            case R.id.reactLove:
                listener.onReactionSelected(1);
                getDialog().dismiss();
                break;
            case R.id.reactHaha:
                listener.onReactionSelected(2);
                getDialog().dismiss();
                break;
            case R.id.reactWow:
                listener.onReactionSelected(3);
                getDialog().dismiss();
                break;
            case R.id.reactSad:
                listener.onReactionSelected(4);
                getDialog().dismiss();
                break;
            case R.id.reactAngry:
                listener.onReactionSelected(5);
                getDialog().dismiss();
                break;
            case R.id.reactDiskLike:
                listener.onReactionSelected(6);
                getDialog().dismiss();
                break;
        }
    }

    @SuppressLint({"RestrictedApi", "UseCompatLoadingForDrawables"})
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        WindowManager.LayoutParams manager = new WindowManager.LayoutParams();
        manager.width = WindowManager.LayoutParams.MATCH_PARENT;
        manager.height = WindowManager.LayoutParams.WRAP_CONTENT;
        manager.dimAmount = 0.0f;
        dialog.getWindow().getDecorView().setBackground(getResources().getDrawable(android.R.color.transparent));
        dialog.setCanceledOnTouchOutside(true);
        dialog.onBackPressed();
    }

    ReactionListener listener;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            listener = (ReactionListener) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString());
        }
    }
}
