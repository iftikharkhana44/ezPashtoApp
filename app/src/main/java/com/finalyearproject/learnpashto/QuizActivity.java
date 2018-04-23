package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private TextView livesLabel;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private int lives = 3;

    public int QUIZ_COUNT = quizCount;
    private int LIVES = 0;


    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            {"How would you say the colour red in pashto?", "Soor", "Sheen", "Kela", "Shaltalu"},
            {"How would you say the colour green in pashto?", "Sheen", "Aloo", "Malta", "Gopi"},
            {"How would you say the colour blue in pashto?", "Udee", "Sheen", "Kela", "Shaltalu"},
            {"How would you say the colour orange in pashto?", "Naranji", "Sheen", "Kela", "Shaltalu"},
            {"How would you say the colour black in pashto?", "Toor", "Sheen", "Kela", "Mana"},
            {"How would you say the colour white in pashto?", "Spin", "Sheen", "Kela", "Alocha"},
            {"How would you say the colour yellow in pashto?", "Zyral", "Sheen", "Kela", "Shaltalu"},
            {"How would you say the colour brown in pashto?", "Naswari", "Sheen", "Kela", "Shaltalu"},
            {"What is one in pashto?", "Yaw", "Dre", "Pinza", "Aloo"},
            {"What does the word dwa mean?", "Two", "Fruit", "You", "Three"},
            {"What is three in pashto?", "Dre", "Shpag", "Owa", "Naha"},
            {"How would you say four in pashto?", "Calor", "Spay", "Malta", "Ata"},
            {"What is ata minus pinza?", "Three", "Four", "Two", "Six"},
            {"What is six add two?", "Ata", "Pinza", "Owa", "Naha"},
            {"How would you say number seven in pashto?", "Owa", "Las", "Yaw", "Ata"},
            {"If you had las apples and gave dre to your friend how many would you have left?", "Seven", "Five", "Six", "Four"},
            {"What is eight in pashto?", "Ata", "Kaddu", "Paluk", "Owa"},
            {"What does saba mean?", "Tomorrow", "Yesterday", "Sheen", "Shaltalu"},
            {"What does yesterday mean?", "Parun", "Haapta", "Mangal", "Charshamba"},
            {"If today is monday, then what day is it the day after tomorrow?", "Charshamba", "Jumma", "Khali", "Pir"},
            {"How do you say week?", "Haafta", "Zyral", "Naha", "Shpa"},
            {"what does saba na nel sa-baa mean?", "day after Tomorrow", "next week", "this week", "last week"},
            {"How is monday said in pashto?", "Pir", "Khali", "Mangal", "Paluk"},
            {"What is ananas?", "Pineapple", "Mana", "Kela", "Aam"},
            {"what do you call mango in pashto?", "Aam", "Piyaz", "Nimbu", "Nashpatay"},
            {"Translate: Pinza alogan.", "Five potatoes", "It is monday", "what do you want", "Three people"},
            {"Translate: Pir shpa.", "Monday night", "Monday afternoon", "Monday evening", "Monday morning"},
            {"Translate: Naha zmarey.", "Nine Lion's", "Nine Dog's", "Nine Monkey's", "Nine Foxes"},
            {"Translate: Naswari wekhta.", "Brown Hair", "Green Eyes", "Red Nose", "Blue Hands"},
            {"Translate: Three days.", "Dre wrazi", "Calor wrazi", "Dre shpey", "Dre wrazi"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);
        livesLabel = (TextView)findViewById(R.id.lives);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create quizArray from quizData
        for (int i = 0; i < quizData.length; i++) {
            // Prepare Array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            // Add tmpArray to quizArray
            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }
    public  void showNextQuiz(){
        //update quizCountLabel
        countLabel.setText("Score: " + rightAnswerCount);
        //update lives;
        livesLabel.setText("Lives: " + lives);
        // Generate random number between given quizArray
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        ArrayList<String> quiz = quizArray.get(randomNum);
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);
        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));
        quizArray.remove(randomNum);
    }
    public void checkAnswer (View view){
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        if (btnText.equals(rightAnswer)){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            rightAnswerCount++;
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            lives--;
            livesLabel.setTextColor(Color.RED);
        }
        if (quizCount == QUIZ_COUNT || lives ==  LIVES ){
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
            startActivity(intent);
            finish();
        }else {
            quizCount++;
            showNextQuiz();
        }
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}