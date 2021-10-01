package edu.wgu.C196_StudentCourseTracker_RonMercier.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import edu.wgu.C196_StudentCourseTracker_RonMercier.R;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.AssessmentActivities.AssessmentActivity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.AssessmentActivities.AssessmentAddEditActivity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.CourseActivities.CourseActivity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.CourseActivities.CourseAddEditActivity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.InstructorActivities.InstructorActivity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.InstructorActivities.InstructorAddEditActivity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.TermActivities.TermActivity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.UI.TermActivities.TermAddEditActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Welcome");





        Button termBtn = findViewById(R.id.termBtn);
        Button courseBtn = findViewById(R.id.courseBtn);
        Button assessmentBtn = findViewById(R.id.assessmentBtn);
        Button instructorsBtn = findViewById(R.id.instructorBtn);
        FloatingActionButton addTermsFromMainFAB = findViewById(R.id.addTermsFromMainFAB);
        FloatingActionButton addCoursesFromMainFAB = findViewById(R.id.addCoursesFromMainFAB);
        FloatingActionButton addAssessmentsFromMainFAB = findViewById(R.id.addAssessmentFromMainFAB);
        FloatingActionButton addInstructorsFromMainFAB = findViewById(R.id.addInstructorFromMainFAB);


        termBtn.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, TermActivity.class);
            startActivity(intent);
        });

        courseBtn.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, CourseActivity.class);
            startActivity(intent);
        });

        assessmentBtn.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, AssessmentActivity.class);
            startActivity(intent);
        });

        instructorsBtn.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, InstructorActivity.class);
            startActivity(intent);
        });

        addTermsFromMainFAB.setOnClickListener(v->{
            Intent intent= new Intent(MainActivity.this, TermAddEditActivity.class);
            startActivity(intent);
        });

        addCoursesFromMainFAB.setOnClickListener(v->{
            Intent intent= new Intent(MainActivity.this, CourseAddEditActivity.class);
            startActivity(intent);
        });

        addAssessmentsFromMainFAB.setOnClickListener(v->{
            Intent intent= new Intent(MainActivity.this, AssessmentAddEditActivity.class);
            startActivity(intent);
        });

        addInstructorsFromMainFAB.setOnClickListener(v->{
            Intent intent= new Intent(MainActivity.this, InstructorAddEditActivity.class);
            startActivity(intent);
        });
    }

    //    Lifecycle Logs
    private final String TAG = "Lifecycle";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

}