package android.saran.com.fragmentlistdialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by saran on 20/2/15.
 */
public class FragmentDialog extends DialogFragment{

    TextView mTextView;
    String mContent;
    Button mCancelButton;

    public FragmentDialog(String content){
        mContent = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Test","in onCreateView of FragmentDialog");

        //Doesnt require container and false, since we dont display it in any container
        View view = inflater.inflate(R.layout.fragment_dialog,null);
        setCancelable(false);
        getDialog().setTitle("Item Selected is");
        mTextView = (TextView) view.findViewById(R.id.dialog_content);
        mTextView.setText(mContent);
        mCancelButton = (Button) view.findViewById(R.id.cancel_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                //This will call onStop->onDestroyView->onDestroy->onDetach
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Test","in onAttach of FragmentDialog");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Test","in onDetach of FragmentDialog");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Test","in onCreate of FragmentDialog");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Test","in onStop of FragmentDialog");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Test","in onDestroyView of FragmentDialog");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Test","in onDestroy of FragmentDialog");
    }
}
