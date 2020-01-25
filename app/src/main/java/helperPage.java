import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memtracker.R;

public class helperPage extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_page);

        Intent intent = getIntent();
        String placeholder = intent.getStringExtra("key");
        name = (TextView) findViewById(R.id.Name);
        name.setText(placeholder);
    }

    public void onClick(View view) {
        Intent j = new Intent(helperPage.this, helpJoin.class);
        startActivity(j);
    }
}