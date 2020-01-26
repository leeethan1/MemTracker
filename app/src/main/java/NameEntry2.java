import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memtracker.R;

public class NameEntry2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_entry2);
    }

    public void onClick(View view) {
        Intent i = new Intent(NameEntry2.this, helperPage.class);
        startActivity(i);

        Intent b = new Intent(NameEntry2.this, helperPage.class);
        EditText input = findViewById(R.id.Name);
        b.putExtra("key", input.getText().toString());
        startActivity(b);
    }
}
