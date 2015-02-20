package android.saran.com.fragmentlistdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by saran on 20/2/15.
 */
public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

    public interface ListItemSelectedListener{
        public void onListItemSelected(String item);
    }

    public void setListItemSelectedListener(ListItemSelectedListener listener){
        mListener = listener;
    }

    ListItemSelectedListener mListener;
    ArrayAdapter mListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.countries,android.R.layout.simple_list_item_1);
        setListAdapter(mListAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) mListAdapter.getItem(position);
        mListener.onListItemSelected(item);
    }
}
