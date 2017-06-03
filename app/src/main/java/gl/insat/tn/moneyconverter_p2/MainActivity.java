package gl.insat.tn.moneyconverter_p2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bConvert;
    private EditText eEntry;
    private RadioButton rb1 ;
    private RadioButton rb2 ;
    public static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialisation
        this.bConvert = (Button) this.findViewById(R.id.button) ;
        this.eEntry = (EditText) this.findViewById(R.id.money) ;
        this.rb1=(RadioButton) this.findViewById(R.id.ED) ;
        this.rb2=(RadioButton) this.findViewById(R.id.DE) ;

        this.bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultat=0 ;
                //Initiatisation Intent
                Intent secondeActivite = new Intent(MainActivity.this, ResultActivity.class);


                  //Resultat
                String s = eEntry.getText().toString();
                int nb=Integer.parseInt(s);

                if (rb1.isChecked()) {
                     resultat = nb * 2.4236;

                } else if (rb2.isChecked()) {
                     resultat = nb / 2.4236;

                }

                // On rajoute le resultat

                secondeActivite.putExtra("resultat",resultat);

                //On lance
               // startActivity(secondeActivite);

                startActivityForResult(secondeActivite,0);
            }



        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected  void onActivityResult(int requestcode,int resultcode,Intent intent)
    {

            if (resultcode==1)
            {
                Toast.makeText(this,"Resultat : "+intent.getDoubleExtra("resultat",0),Toast.LENGTH_LONG).show();
            }

        super.onActivityResult(requestcode, resultcode, intent);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
