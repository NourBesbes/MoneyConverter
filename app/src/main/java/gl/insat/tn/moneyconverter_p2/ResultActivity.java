package gl.insat.tn.moneyconverter_p2;

/**
 * Created by nour on 2/18/17.
 */

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;

public class ResultActivity extends AppCompatActivity {
    private EditText resultat;
    private FloatingActionButton back;
    private FloatingActionButton callB;
    private Double res;
    public static final int REQUEST_CODE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        this.back = (FloatingActionButton) this.findViewById(R.id.back);
        this.callB = (FloatingActionButton) this.findViewById(R.id.callButton);
        this.resultat = (EditText) this.findViewById(R.id.res);
        // On récupère l'intent qui a lancé cette activité
        Intent i = getIntent();

        // Puis on récupère le résultat donné dans l'autre activité, ou 0 si cet extra n'est pas dans l'intent
        res = i.getDoubleExtra("resultat", 0);

        resultat.setText("Resultat : " + res);


        this.back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i2 = new Intent();
                i2.putExtra("resultat", res);
                ResultActivity.this.setResult(1, i2);
                ResultActivity.this.finish();
            }


        });

        this.callB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:123"));

                startActivity(callIntent);
            }
        });



        }


    }







