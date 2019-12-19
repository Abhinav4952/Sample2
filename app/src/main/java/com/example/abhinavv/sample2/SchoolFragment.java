package com.example.abhinavv.sample2;


import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.leavjenn.smoothdaterangepicker.date.SmoothDateRangePickerFragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import java.util.Calendar;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment {

    private TextView tvDateRange, tvDate;

    public SchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(), "Opened", Toast.LENGTH_SHORT).show();
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_school, null);
        tvDateRange = (TextView) view.findViewById(R.id.tv_date_range);

        Button btnDateRange = (Button) view.findViewById(R.id.btn_date_picker);
        btnDateRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Click!", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getActivity().getFragmentManager();
                SmoothDateRangePickerFragment smoothDateRangePickerFragment =SmoothDateRangePickerFragment.newInstance(new SmoothDateRangePickerFragment.OnDateRangeSetListener() {
                    @Override
                    public void onDateRangeSet(SmoothDateRangePickerFragment view, int yearStart, int monthStart, int dayStart, int yearEnd, int monthEnd, int dayEnd) {
                        String date = "You picked the following date range: \n"
                                + "From " + dayStart + "/" + (++monthStart)
                                + "/" + yearStart + " To " + dayEnd + "/"
                                + (++monthEnd) + "/" + yearEnd;
                        tvDateRange.setText(date);
                    }
                });
                smoothDateRangePickerFragment.show(fm, "Datepickerdialog");
            }
        });
        return view;
    }


}
