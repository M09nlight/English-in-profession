package by.vgtk.englishinprofession.ui.roaders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentComputersBinding;

public class RoadersTest2Activity extends AppCompatActivity {

    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "Is the natural or artificial removal of surface and sub-surface water from an area?",
            "Is the process of using some implements such as claws, hands, or tools, " +
                    "to remove material from a solid surface, usually soil or sand on the surface of the earth?",
            "Is a structural failure in an asphalt pavement, caused by the presence of water in" +
                    " the underlying soil structure and the presence of traffic passing over the affected area?",
            "Is a sheet material manufactured from thin layers or \"plies\" of wood veneer that are glued together?",
            "Land reclamation along river banks, usually marked by roads and walkways running along it, parallel to the river?",
            "Is a broad category of coarse material used in construction, including sand, gravel, crushed stones, slag, recycled concrete?",
            "Is wood that has been processed into beams and planks, a stage in the process of wood production?",
            "Is building material used to make walls, pavements and other elements in masonry construction?",
            "The presence of a liquid, especially water?",
            "Is a structure built to span physical obstacles without closing the way under" +
                    " such as a body of water, valley, or road, for the purpose of providing passage over the obstacle?",
            "Calcium hydroxide is...",
            "Any material or substance that holds or draws other materials together?",
            "Is a manufactured piece of hard-wearing material such as ceramic, stone, metal, " +
                    "or even glass, generally used for covering roofs, floors, walls, showers, or other objects such as tabletops?",
            "Is a black mixture of hydrocarbons and free carbon obtained from a wide variety of organic materials?",
            "It is most commonly used to protect, color, or provide texture to objects?",
            "Is a kind of material used to cover and decorate the interior walls of homes, offices, cafes, government buildings, etc?",
            "Is an object, thing, action or situation that causes an obstruction?",
            "Is a naturally occurring material that is broken down by processes of weathering and erosion, " +
                    "and is subsequently transported by the action of wind, water, or ice, and/or by the force of gravity acting on the particles?",
            "Is a sticky, black and highly viscous liquid or semi-solid form of petroleum?",
    };

    String answers[] = {
            "drainage",
            "digging",
            "pothole",
            "ply-wood",
            "embankment",
            "aggregate",
            "timber",
            "brick",
            "moisture",
            "bridge",
            "lime",
            "binder",
            "tile",
            "tar",
            "paint",
            "plaster",
            "obstacle",
            "sediment",
            "bitumen",
    };

    String opt[][] = {
            {"moisture", "pipeline", "bridge", "drainage"},
            {"plumbing", "digging", "drainage", "excavation"},
            {"pothole", "road bed", "curve", "sulfur"},
            {"board", "laminate", "timber", "ply-wood"},
            {"gradient", "earthwork", "embankment", "bridge"},
            {"binder", "sediment", "compactor", "aggregate"},
            {"tile", "timber", "board", "ply-wood"},
            {"brick", "rock", "limestone", "cobble"},
            {"drainage", "moisture", "density", "durability"},
            {"highway", "tunnel", "drainage", "bridge"},
            {"lime", "clay", "bridge", "gypsum", "sand"},
            {"cement", "aggregate", "binder", "obstacle"},
            {"tile", "clay", "timber", "cobble"},
            {"bitumen", "crude oil", "tar", "asphalt"},
            {"stucco", "lime", "paint", "primer"},
            {"lime", "primer", "putty", "plaster"},
            {"obstacle", "pedestrian", "removal", "curve"},
            {"topsoil", "obstacle", "sediment", "curve"},
            {"tar", "paver", "bitumen", "oil"},
    };

    int question_counter = 0;
    public static int correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        correct = 0;
        wrong = 0;

        TextView textView = (TextView) findViewById(R.id.DispName);

        tv = (TextView) findViewById(R.id.tvque);
        submitButton = (Button) findViewById(R.id.button3);
        quitButton = (Button) findViewById(R.id.buttonquit);

        tv.setText(questions[question_counter]);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        rb1.setText(opt[question_counter][0]);
        rb2.setText(opt[question_counter][1]);
        rb3.setText(opt[question_counter][2]);
        rb4.setText(opt[question_counter][3]);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[question_counter])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                question_counter++;

                //change text on screen
                if (question_counter < questions.length) {
                    tv.setText(questions[question_counter]);
                    rb1.setText(opt[question_counter][0]);
                    rb2.setText(opt[question_counter][1]);
                    rb3.setText(opt[question_counter][2]);
                    rb4.setText(opt[question_counter][3]);
                } else {
                    rb1.setVisibility(View.INVISIBLE);
                    rb2.setVisibility(View.INVISIBLE);
                    rb3.setVisibility(View.INVISIBLE);
                    rb4.setVisibility(View.INVISIBLE);
                    radio_g.setVisibility(View.INVISIBLE);
                    submitButton.setVisibility(View.GONE);
                    quitButton.setVisibility(View.VISIBLE);
                    tv.setText("Number of questions: " + questions.length + "\nCorrect answer: "
                            + correct + "\n You result: " + Math.round(10.0 / questions.length * correct));
                }
                radio_g.clearCheck();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FragmentComputersBinding.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
