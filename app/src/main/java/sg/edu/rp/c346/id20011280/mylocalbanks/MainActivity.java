package sg.edu.rp.c346.id20011280.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";
    boolean DBS = false; // black
    boolean OCBC = false;
    boolean UOB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.DBS);
        tvOCBC = findViewById(R.id.OCBC);
        tvUOB = findViewById(R.id.UOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle button");


        if (v == tvDBS) {
            wordClicked = "DBS"; // store the word that is being clicked // so on the DBS
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(wordClicked == "DBS") {
            if (id == 0) { // website
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));

                startActivity(i);
                return true;

            } else if (id == 1) { // contact
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);
                return true;
            } else if ( id == 2) { // color change
                if(wordClicked == "DBS")
                {
                    if(DBS == false) // check if color hasnt changed
                    {
                        tvDBS.setTextColor(Color.RED);
                        DBS = true;
                    }
                    else
                    {
                        tvDBS.setTextColor(Color.BLACK);
                    }
                }

            }
        }
        else if (wordClicked == "OCBC") {
            if (id == 0 ) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway"));
                startActivity(i);
                return true;
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800 363 3333"));
                startActivity(intentCall);
                return true;
            } else if (id == 2) {
                if(wordClicked == "OCBC")
                {
                    if(OCBC == false)
                    {
                        tvOCBC.setTextColor(Color.RED);
                        OCBC = true;
                    }
                    else
                    {
                        tvOCBC.setTextColor(Color.BLACK);
                        // ocbc will be false

                    }
                }

            }

        }
        else if (wordClicked == "UOB") {
            if (id == 0) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/index.page"));
                startActivity(i);
                return true;
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800 222 2121"));
                startActivity(intentCall);
                return true;
            } else if (id == 2){
                if(wordClicked == "UOB")
                {
                   if(UOB == false)
                   {
                       tvUOB.setTextColor(Color.RED);
                       UOB = true;
                   }
                   else
                   {
                       tvUOB.setTextColor(Color.BLACK);
                   }
                }
            }
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;

        }
        return super.onOptionsItemSelected(item);
    }






}
