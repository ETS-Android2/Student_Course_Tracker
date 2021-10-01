package edu.wgu.C196_StudentCourseTracker_RonMercier.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Assessment.AssessmentDAO;
import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Course.CourseDAO;
import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Instructor.InstructorDAO;
import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Term.TermDAO;
import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Assessment.AssessmentEntity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Course.CourseEntity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Instructor.InstructorEntity;
import edu.wgu.C196_StudentCourseTracker_RonMercier.Database.Term.TermEntity;

@Database(entities = {TermEntity.class, InstructorEntity.class, CourseEntity.class, AssessmentEntity.class},version = 1, exportSchema = false)
public abstract class CourseTrackerDatabase extends RoomDatabase{

    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract AssessmentDAO assessmentDAO();
    public abstract InstructorDAO instructorDAO();
    public static final int NUM_OF_THREADS = 4;

    public static final ExecutorService dataWriteExecutor =
            Executors.newFixedThreadPool(NUM_OF_THREADS);

    private static volatile CourseTrackerDatabase INSTANCE;

    public static CourseTrackerDatabase getDatabase(final Context context){
        if (INSTANCE==null){
            synchronized (CourseTrackerDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CourseTrackerDatabase.class, "course_tracker_database.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            dataWriteExecutor.execute(()->{




            });

        }
    };

}
