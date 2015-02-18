package android.saran.com.fragmentmodular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by saran on 18/2/15.
 */
public class FragmentB extends Fragment{
    private static final String EXTRA_INDEX = "index";
    TextView textView;
    int mIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentb, container, false);
        textView = (TextView) view.findViewById(R.id.textView);

        if(savedInstanceState!=null){
            mIndex = savedInstanceState.getInt(EXTRA_INDEX,0);
        }else{
            mIndex =0;
        }
        updateUI(mIndex);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_INDEX,mIndex);
    }

    public void updateUI(int index){
        mIndex = index;
        textView.setText(getActivity().getResources().getStringArray(R.array.values)[index]);
    }
}
