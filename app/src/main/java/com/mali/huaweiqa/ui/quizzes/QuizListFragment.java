package com.mali.huaweiqa.ui.quizzes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.mali.huaweiqa.R;
import com.mali.huaweiqa.domain.quizzes.Quiz;

import java.util.ArrayList;

public class QuizListFragment extends Fragment {
    private QuizListViewModel quizListViewModel;
    private RecyclerView quizList;
    private QuizListAdapter adapter;

    // TODO: get User ID
    String ID = "1234";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        quizListViewModel =
                new ViewModelProvider(this).get(QuizListViewModel.class);
        View root = inflater.inflate(R.layout.quiz_list_main, container, false);
        quizList = root.findViewById(R.id.quizList);
        adapter = new QuizListAdapter();

        // retrieve data on changes
        quizListViewModel.getQuizzes(ID).observe(getViewLifecycleOwner(), new Observer<ArrayList<Quiz>>() {
            @Override
            public void onChanged(ArrayList<Quiz> quizzes) {
                ArrayList<Quiz> unTakenQuizzes = new ArrayList<>();
                // filter the taken quizzes
                for (Quiz quiz : quizzes){
                    if(!quiz.isTaken())
                        unTakenQuizzes.add(quiz);
                }

                adapter.setQuizzes(unTakenQuizzes);
                quizList.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


        return root;
    }
}