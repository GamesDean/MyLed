package com.menowattge.myled;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PresetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PresetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PresetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    protected OnFragmentInteractionListener mListener;
    protected Spinner spinner;
    protected ArrayAdapter adapter;
    protected Button buttonSend;

    public PresetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PresetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PresetFragment newInstance(String param1, String param2) {
        PresetFragment fragment = new PresetFragment();
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
        View view = inflater.inflate(R.layout.fragment_preset, container, false);

        //invisibili altrimenti randomicamente compaiono
        MainActivity.startScanningButton.setVisibility(View.INVISIBLE);
        MainActivity.stopScanningButton.setVisibility(View.INVISIBLE);
        //bug infame,anche se non visibile,è cliccabile. così risolvo
        CharacteristicFragment.disConnect.setClickable(false);
        CharacteristicFragment.disConnect.setEnabled(false);

        buttonSend = (Button)view.findViewById(R.id.buttonSend);

        spinner = (Spinner)view.findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(getActivity(),
                                    android.R.layout.simple_spinner_dropdown_item,
                                    new String[]{"Dimmeraggio 1","Dimmeraggio 2","Dimmeraggio 3","Dimmeraggio 4","Dimmeraggio 5"});
        spinner.setAdapter(adapter);
/*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getActivity(),
                        "hai selezionato ",
                        Toast.LENGTH_LONG).show();

                Log.i("TOTTA","selezionato");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

*/
        return view;

    }
    @Override
    public void onResume(){
        super.onResume();

        MainActivity.startScanningButton.setVisibility(View.INVISIBLE);
        MainActivity.stopScanningButton.setVisibility(View.INVISIBLE);
        CharacteristicFragment.disConnect.setClickable(false);
        CharacteristicFragment.disConnect.setEnabled(false);

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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
