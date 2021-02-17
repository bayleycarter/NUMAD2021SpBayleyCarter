package edu.neu.madcourse.numad21sp_bayleycarter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity3 extends AppCompatActivity {

    private ArrayList<LinkName> linkList = new ArrayList<>();

    private String  s2[];
    private ArrayList<LinkName> listOfLinks = new ArrayList<>();


    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton linkButton;
    public String m_Text;
    public String m_Text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linkcollector_activity);
        Intent myIntent = getIntent();

        //recyclerView = findViewById(R.id.recyclerview);

        //LinkName s1 = new LinkName("", "");
        //listOfLinks.add(s1);
        //LinkName s2 = new LinkName("", "");
        //listOfLinks.add(s2);
        //LinkName s3 = new LinkName("", "");
        //listOfLinks.add(s3);
        //s1 = getResources().getStringArray(R.array.empty_links);
        //s2 = getResources().getStringArray(R.array.empty_urls);


        LinkName link1 = new LinkName("Nothing", "Nothing");
        LinkName link2 = new LinkName("Nothing", "Nothing");
        LinkName link3 = new LinkName("Nothing", "Nothing");
        listOfLinks.add(link1);
        listOfLinks.add(link2);
        listOfLinks.add(link3);

        //ViewAdapter myAdapter = new ViewAdapter(listOfLinks);
        //recyclerView.setAdapter((myAdapter));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        createRecyclerView();

        linkButton = findViewById(R.id.addLinkButton);
        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = 0;

                addItem(position);


            }
        });

    }

    public void addItem(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        EditText input = new EditText(this);

        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int pos) {
                m_Text = input.getText().toString();
                if (URLUtil.isValidUrl(m_Text)) {
                    listOfLinks.add(position, new LinkName("", m_Text));
                    viewAdapter.notifyItemInserted(position);
                    Snackbar.make(findViewById(R.id.mainLayout), "Added successfully!", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                }
                else {
                    Snackbar.make(findViewById(R.id.mainLayout), "Not a valid URL: " +
                                    "Try using http:// and removing spaces", Snackbar.LENGTH_SHORT)
                               .setAction("Action", null).show();
                }

                //String url = listOfLinks.get(0).getLinkUrl();
                //URLUtil.guessUrl(url);
                //try {
                  //  URL myURL = new URL(url);
                    //make url clickable and launch on click

                //} catch (MalformedURLException e) {

                   //not added successfully
                //}

            }

        });

        builder.show();

    }

    private void createRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        viewAdapter = new ViewAdapter(listOfLinks);
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {

                //listOfLinks.get(position).onItemClick(position);

                //viewAdapter.notifyItemChanged(position);

                Intent browser_intent=new Intent(Intent.ACTION_VIEW, Uri.parse(listOfLinks.get(position).getLinkUrl()));
                startActivity(browser_intent);

            }
        };

        viewAdapter.setOnItemClickListener(itemClickListener);

        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
