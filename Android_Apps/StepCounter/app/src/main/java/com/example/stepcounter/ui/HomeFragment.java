package com.example.stepcounter.ui;

import static android.app.PendingIntent.getActivity;
import static androidx.core.location.LocationManagerCompat.requestLocationUpdates;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.location.LocationManager;
import android.annotation.SuppressLint;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepcounter.databinding.FragmentHomeBinding;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ActivityResultLauncher<String[]> multiplePermissionLauncher;

    private LocationManager locationManager;
    private LocationListener listener;

    private long startTime = 0;
    private float steps, calories, miles, totalmiles;
    private Location lastLocation;

    DecimalFormat format = new DecimalFormat("0.00");


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //scrollview and its contents are invisible until location permissions are obtained
        binding.scrollView.setVisibility(View.INVISIBLE);

        binding.textHome.setText("This app needs location permission in order to count your steps.");

        //check for permission on startup
        String[] permissions = new String[] {
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION };

        boolean granted = true;
        for (String permission : permissions)
            if (getActivity().checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                granted = false;

        if (granted) {
            requestLocationUpdates();
        }

        else {
            ActivityResultLauncher<String[]> multiplePermissionLauncher = registerForActivityResult(
                    new ActivityResultContracts.RequestMultiplePermissions(),
                    isGranted -> {
                        //if location permission are given update location
                        boolean gotPermissions = !isGranted.containsValue(false);
                        if (gotPermissions)
                            requestLocationUpdates();
                    });
            multiplePermissionLauncher.launch(permissions);//ask for permissions
        }

        //timer that runs once a second
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(() -> {
                    if (startTime == 0)
                        return;

                    long msElapsed = System.currentTimeMillis() - startTime;
                    long seconds = msElapsed / 1000;
                    long minutes = seconds / 60;
                    seconds = seconds % 60;
                    String timeString = String.format("%02d:%02d", minutes, seconds);
                    binding.textViewTime.setText(timeString);
                    binding.textViewSteps.setText(String.valueOf((int) steps));
                    binding.textViewCalories.setText(String.valueOf((int) calories));
                    binding.textViewMiles.setText(String.format("%.2f", totalmiles));
                });
            }
        }, 0, 1000 /*invoke once a second */);

        binding.buttonStart.setOnClickListener(view -> {
            if (startTime == 0) {
                startTime = System.currentTimeMillis();
                binding.buttonStart.setText("Reset");
            }

            else {
                //already running, so reset
                startTime = System.currentTimeMillis();
                steps = calories = 0;
            }
        });

        return root;
    }
    @SuppressLint("MissingPermission")
    private void requestLocationUpdates(){

        binding.scrollView.setVisibility(View.VISIBLE);
        binding.textHome.setVisibility(View.INVISIBLE);

        binding.textHome.setText("Starting location updates...");

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                if (lastLocation == null) {
                    lastLocation = location;
                    return;
                }

                float distance = lastLocation.distanceTo(location);
                lastLocation = location;

                distance = distance * 3.28084f;         //meters to feet
                steps += distance / 2.3f;               //feet ti steps
                totalmiles += distance * 0.000189394f;  //contantly add distance to totalmiles
                miles = distance * 0.000189394f;        //convert feet to miles
                calories += 100 * miles;                //convert miles to calories



              /*  binding.textHome.setText("Lat: " + location.getLatitude() + " Long: " + location.getLongitude());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD && Geocoder.isPresent()) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.execute(() ->{
                        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                        List<String> addressStrings = new ArrayList<>();
                        try {
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),
                                    location.getLongitude(), 10);
                            for (Address address : addresses) {
                                String addressString =
                                                    address.getSubThoroughfare() + " " +
                                                    address.getThoroughfare() + " " +
                                                    address.getLocality() + " " +
                                                    address.getAdminArea() + " " +
                                                    address.getCountryName();
                                addressStrings.add(addressString);
                            }
                        }
                        catch (IOException ex) {
                            Log.e ( "Step Count" , "Error Retreiving Address");
                        }

                        handler.post(() -> {
                            if (addressStrings.size() > 0)
                                binding.textHome.setText("Address: " + addressStrings.get(0));

                            else {
                                binding.textHome.setText("Could not get the address");
                            }
                        });
                    });

                } */
            }
        };

        locationManager =(LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000 /* 10 seconds */,
                1 /* 10 meters */, listener);

    }

    @Override
    public void onStop() {
        super.onStop();
        locationManager.removeUpdates(listener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}