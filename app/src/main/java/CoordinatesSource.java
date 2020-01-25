import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.memtracker.R;

public class CoordinatesSource extends AppCompatActivity {

    TextView coordinates;
    TextView degrees;

    private static final int MY_LOCATION_REQUEST = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinates_source);
        coordinates = (TextView) findViewById(R.id.coord);
        degrees = (TextView) findViewById(R.id.degrees);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_LOCATION_REQUEST);
        }
    }

    protected void onResume() {
        super.onResume();

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,permissions, grantResults);
        switch (requestCode){
            case MY_LOCATION_REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Succeeded
                }
                else{
                    //Permission wasn't granted. Program recover
                }
            }
        }
    }

    public void updateLocation(Location location){
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        coordinates.setText(latitude+ " "  + longitude);
        String converted = conversion22(location);
        degrees.setText(converted);

    }

    public String conversion22(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        char directionLat;
        char directionLong;
        int multiplierLat;
        int multiplierLong;

        //Latitude N/S:
        if (latitude < 0){
            directionLat = 'S';
            multiplierLat = -1;
        }
        else{
            directionLat = 'N';
            multiplierLat = 1;
        }

        //Longitude E/W:
        if (longitude < 0){
            directionLong = 'W';
            multiplierLong = -1;
        }
        else{
            directionLong = 'E';
            multiplierLong = 1;
        }

        int degreesLong = (int)(multiplierLong * (longitude - (longitude % 1)));
        double minutesLongD = (longitude % 1) * 60;
        int minutesLong = (int)(multiplierLong * (minutesLongD - (minutesLongD % 1)));
        double secondsLong = multiplierLong * (minutesLongD % 1) * 60;

        int degreesLat = (int)(multiplierLat * (latitude - (latitude % 1)));
        double minutesLatD = (latitude % 1) * 60;
        int minutesLat = (int)(multiplierLat * (minutesLatD - (minutesLatD % 1)));
        double secondsLat = multiplierLat * (minutesLatD % 1) * 60;



        String converted = (degreesLat + "°" + minutesLat + "'" + secondsLat + '"' + directionLat + degreesLong + "°" + minutesLong + "'" + secondsLong + '"' + directionLong);
        return converted;






    }


}
