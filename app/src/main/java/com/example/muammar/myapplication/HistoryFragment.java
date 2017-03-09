package com.example.muammar.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HistoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    FirebaseListAdapter<String> myAdapter;
    ArrayList<UpObjects> hitlist = new ArrayList<>();



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }







    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View s = inflater.inflate(R.layout.fragment_history,container,false);
        final DecimalFormat formate = new DecimalFormat("#,###,###");

        RecyclerView lv = (RecyclerView) s.findViewById(R.id.HistList);
        lv.setHasFixedSize(true);
        lv.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseDatabase mDb = FirebaseDatabase.getInstance();
        DatabaseReference trans = mDb.getReferenceFromUrl("https://test-38be8.firebaseio.com/Transactions");
        FirebaseRecyclerAdapter<UpObjects,ViewHoldur> adapter = new FirebaseRecyclerAdapter<UpObjects, ViewHoldur>(UpObjects.class,R.layout.histfragrecyclerlist,ViewHoldur.class,trans) {
            @Override
            protected void populateViewHolder(ViewHoldur viewHolder, UpObjects model, int position) {



                String valtexts = Integer.toString(model.getValue());
                String newval = "Rp. "+valtexts;


                String TypeDate = model.getType();




               viewHolder.txtv.setText(model.getCurrent());
                viewHolder.txtv2.setText(newval);
                viewHolder.date.setText(TypeDate);
                if(model.getNotes() != "" && model.getNotes() != null){
                    String notus = "Note : "+model.getNotes();
                    viewHolder.notesz.setText(notus);

                }else{

                    viewHolder.notesz.setText("No Notes");
                }






            }
        };






        lv.setAdapter(adapter);



        return s;
    }

    public static class ViewHoldur extends RecyclerView.ViewHolder{

        public TextView txtv;
        public TextView txtv2;
        public TextView date;
        public TextView notesz;

        public ViewHoldur(View itemView) {
            super(itemView);
            txtv = (TextView)itemView.findViewById(R.id.ID_hist);
            txtv2 = (TextView)itemView.findViewById(R.id.value_hist);
            date = (TextView)itemView.findViewById(R.id.Date_hist);
            notesz = (TextView)itemView.findViewById(R.id.noteshist);

        }


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
